package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPendingResult<R extends Result> implements PendingResult<R> {
    protected final CallbackHandler<R> mHandler;
    private boolean zzL;
    private final Object zzWb = new Object();
    private final ArrayList<PendingResult.BatchCallback> zzWc = new ArrayList<>();
    private ResultCallback<R> zzWd;
    private volatile R zzWe;
    private volatile boolean zzWf;
    private boolean zzWg;
    private ICancelToken zzWh;
    private final CountDownLatch zzoD = new CountDownLatch(1);

    public static class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: protected */
        public void deliverResultCallback(ResultCallback<R> callback, R result) {
            try {
                callback.onResult(result);
            } catch (RuntimeException e) {
                AbstractPendingResult.zzb(result);
                throw e;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.common.api.AbstractPendingResult$CallbackHandler<R extends com.google.android.gms.common.api.Result> */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((AbstractPendingResult) msg.obj).forceFailureUnlessReady(Status.zzXS);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback<R> callback, R result) {
            sendMessage(obtainMessage(1, new Pair(callback, result)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> pendingResult, long millis) {
            sendMessageDelayed(obtainMessage(2, pendingResult), millis);
        }
    }

    protected AbstractPendingResult(Looper looper) {
        this.mHandler = new CallbackHandler<>(looper);
    }

    protected AbstractPendingResult(CallbackHandler<R> callbackHandler) {
        this.mHandler = (CallbackHandler) zzu.zzb(callbackHandler, "CallbackHandler must not be null");
    }

    private void zza(R r) {
        this.zzWe = r;
        this.zzWh = null;
        this.zzoD.countDown();
        Status status = this.zzWe.getStatus();
        if (this.zzWd != null) {
            this.mHandler.removeTimeoutMessages();
            if (!this.zzL) {
                this.mHandler.sendResultCallback(this.zzWd, zzmo());
            }
        }
        Iterator<PendingResult.BatchCallback> it = this.zzWc.iterator();
        while (it.hasNext()) {
            it.next().zzs(status);
        }
        this.zzWc.clear();
    }

    static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("AbstractPendingResult", "Unable to release " + result, e);
            }
        }
    }

    private R zzmo() {
        R r;
        boolean z = true;
        synchronized (this.zzWb) {
            if (this.zzWf) {
                z = false;
            }
            zzu.zza(z, "Result has already been consumed.");
            zzu.zza(isReady(), "Result is not ready.");
            r = this.zzWe;
            this.zzWe = null;
            this.zzWd = null;
            this.zzWf = true;
        }
        onResultConsumed();
        return r;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addBatchCallback(PendingResult.BatchCallback callback) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (isReady()) {
                callback.zzs(this.zzWe.getStatus());
            } else {
                this.zzWc.add(callback);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        boolean z = true;
        zzu.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.zzWf) {
            z = false;
        }
        zzu.zza(z, "Result has already been consumed");
        try {
            this.zzoD.await();
        } catch (InterruptedException e) {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long time, TimeUnit units) {
        boolean z = true;
        zzu.zza(time <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        if (this.zzWf) {
            z = false;
        }
        zzu.zza(z, "Result has already been consumed.");
        try {
            if (!this.zzoD.await(time, units)) {
                forceFailureUnlessReady(Status.zzXS);
            }
        } catch (InterruptedException e) {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzWb) {
            if (!this.zzL && !this.zzWf) {
                if (this.zzWh != null) {
                    try {
                        this.zzWh.cancel();
                    } catch (RemoteException e) {
                    }
                }
                zzb(this.zzWe);
                this.zzWd = null;
                this.zzL = true;
                zza(createFailedResult(Status.zzXT));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract R createFailedResult(Status status);

    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zzWb) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zzWg = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzWb) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoD.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    public void onResultConsumed() {
    }

    /* access modifiers changed from: protected */
    public final void setCancelToken(ICancelToken cancelToken) {
        synchronized (this.zzWb) {
            this.zzWh = cancelToken;
        }
    }

    public final void setResult(R result) {
        boolean z = true;
        synchronized (this.zzWb) {
            if (this.zzWg || this.zzL) {
                zzb(result);
                return;
            }
            zzu.zza(!isReady(), "Results have already been set");
            if (this.zzWf) {
                z = false;
            }
            zzu.zza(z, "Result has already been consumed");
            zza(result);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<R> callback) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (!isCanceled()) {
                if (isReady()) {
                    this.mHandler.sendResultCallback(callback, zzmo());
                } else {
                    this.zzWd = callback;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (!isCanceled()) {
                if (isReady()) {
                    this.mHandler.sendResultCallback(callback, zzmo());
                } else {
                    this.zzWd = callback;
                    this.mHandler.sendTimeoutResultCallback(this, units.toMillis(time));
                }
            }
        }
    }
}
