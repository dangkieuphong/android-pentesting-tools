package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* access modifiers changed from: package-private */
public final class zzg implements GoogleApiClient {
    private final Context mContext;
    private final int zzWB;
    private final int zzWC;
    final Api.zza<? extends zzps, zzpt> zzWE;
    private final Lock zzWL = new ReentrantLock();
    private final Looper zzWt;
    final Set<zze<?>> zzXA = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final zzc zzXB = new zzc() {
        /* class com.google.android.gms.common.api.zzg.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.zzg.zzc
        public void zzc(zze<?> zze) {
            zzg.this.zzXA.remove(zze);
        }
    };
    private final GoogleApiClient.ConnectionCallbacks zzXC = new zzd() {
        /* class com.google.android.gms.common.api.zzg.AnonymousClass2 */

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle connectionHint) {
            zzg.this.zzXx.onConnected(connectionHint);
        }
    };
    private final zzj.zza zzXD = new zzj.zza() {
        /* class com.google.android.gms.common.api.zzg.AnonymousClass3 */

        @Override // com.google.android.gms.common.internal.zzj.zza
        public boolean isConnected() {
            return zzg.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        public Bundle zzlM() {
            return null;
        }
    };
    final com.google.android.gms.common.internal.zze zzXa;
    final Map<Api<?>, Integer> zzXb;
    private final Condition zzXm;
    final zzj zzXn;
    final Queue<zze<?>> zzXo = new LinkedList();
    private volatile boolean zzXp;
    private long zzXq = 120000;
    private long zzXr = 5000;
    final zza zzXs;
    BroadcastReceiver zzXt;
    final Map<Api.ClientKey<?>, Api.Client> zzXu = new HashMap();
    final Map<Api.ClientKey<?>, ConnectionResult> zzXv = new HashMap();
    Set<Scope> zzXw = new HashSet();
    private volatile zzh zzXx;
    private ConnectionResult zzXy = null;
    private final Set<zzi<?>> zzXz = Collections.newSetFromMap(new WeakHashMap());

    /* access modifiers changed from: package-private */
    public final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzg.this.zzmP();
                    return;
                case 2:
                    zzg.this.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    private static class zzb extends BroadcastReceiver {
        private WeakReference<zzg> zzXK;

        zzb(zzg zzg) {
            this.zzXK = new WeakReference<>(zzg);
        }

        public void onReceive(Context context, Intent intent) {
            zzg zzg;
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals("com.google.android.gms") && (zzg = this.zzXK.get()) != null) {
                zzg.resume();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public interface zzc {
        void zzc(zze<?> zze);
    }

    public abstract class zzd implements GoogleApiClient.ConnectionCallbacks {
        public zzd() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int cause) {
            zzg.this.zzWL.lock();
            try {
                zzg.this.zzXx.onConnectionSuspended(cause);
            } finally {
                zzg.this.zzWL.unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public interface zze<A extends Api.Client> {
        void cancel();

        void forceFailureUnlessReady(Status status);

        void zza(zzc zzc);

        void zzb(A a) throws DeadObjectException;

        Api.ClientKey<A> zzms();

        int zzmv();

        void zzr(Status status);
    }

    public zzg(Context context, Looper looper, com.google.android.gms.common.internal.zze zze2, Api.zza<? extends zzps, zzpt> zza2, Map<Api<?>, Api.ApiOptions> map, Set<GoogleApiClient.ConnectionCallbacks> set, Set<GoogleApiClient.OnConnectionFailedListener> set2, int i, int i2) {
        this.mContext = context;
        this.zzXn = new zzj(looper, this.zzXD);
        this.zzWt = looper;
        this.zzXs = new zza(looper);
        this.zzWB = i;
        this.zzWC = i2;
        this.zzXb = new HashMap();
        this.zzXm = this.zzWL.newCondition();
        this.zzXx = new zzf(this);
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : set) {
            this.zzXn.registerConnectionCallbacks(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : set2) {
            this.zzXn.registerConnectionFailedListener(onConnectionFailedListener);
        }
        Map<Api<?>, zze.zza> zznx = zze2.zznx();
        for (Api<?> api : map.keySet()) {
            Api.ApiOptions apiOptions = map.get(api);
            int i3 = zznx.get(api) != null ? zznx.get(api).zzZW ? 1 : 2 : 0;
            this.zzXb.put(api, Integer.valueOf(i3));
            this.zzXu.put(api.zzms(), api.zzmt() ? zza(api.zzmq(), apiOptions, context, looper, zze2, this.zzXC, zza(api, i3)) : zza(api.zzmp(), apiOptions, context, looper, zze2, this.zzXC, zza(api, i3)));
        }
        this.zzXa = zze2;
        this.zzWE = zza2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resume() {
        this.zzWL.lock();
        try {
            if (zzmO()) {
                connect();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.Client, O> C zza(Api.zza<C, O> zza2, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zze zze2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return zza2.zza(context, looper, zze2, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private final GoogleApiClient.OnConnectionFailedListener zza(final Api<?> api, final int i) {
        return new GoogleApiClient.OnConnectionFailedListener() {
            /* class com.google.android.gms.common.api.zzg.AnonymousClass4 */

            @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
            public void onConnectionFailed(ConnectionResult result) {
                zzg.this.zzXx.zza(result, api, i);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.zzb, O> zzz zza(Api.zzc<C, O> zzc2, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zze zze2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzz(context, looper, zzc2.zzmu(), connectionCallbacks, onConnectionFailedListener, zze2, zzc2.zzl(obj));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(final GoogleApiClient googleApiClient, final zzl zzl, final boolean z) {
        zzkl.zzabj.zzc(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* class com.google.android.gms.common.api.zzg.AnonymousClass7 */

            /* renamed from: zzm */
            public void onResult(Status status) {
                if (status.isSuccess() && zzg.this.isConnected()) {
                    zzg.this.reconnect();
                }
                zzl.setResult(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzaY(int i) {
        this.zzWL.lock();
        try {
            this.zzXx.zzaV(i);
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmP() {
        this.zzWL.lock();
        try {
            if (zzmR()) {
                connect();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        zzu.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzWL.lock();
        try {
            connect();
            while (isConnecting()) {
                try {
                    this.zzXm.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            if (isConnected()) {
                ConnectionResult connectionResult = ConnectionResult.zzVG;
                this.zzWL.unlock();
                return connectionResult;
            } else if (this.zzXy != null) {
                ConnectionResult connectionResult2 = this.zzXy;
                this.zzWL.unlock();
                return connectionResult2;
            } else {
                ConnectionResult connectionResult3 = new ConnectionResult(13, null);
                this.zzWL.unlock();
                return connectionResult3;
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        zzu.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzWL.lock();
        try {
            connect();
            long nanos = unit.toNanos(timeout);
            while (isConnecting()) {
                try {
                    nanos = this.zzXm.awaitNanos(nanos);
                    if (nanos <= 0) {
                        return new ConnectionResult(14, null);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    ConnectionResult connectionResult = new ConnectionResult(15, null);
                    this.zzWL.unlock();
                    return connectionResult;
                }
            }
            if (isConnected()) {
                ConnectionResult connectionResult2 = ConnectionResult.zzVG;
                this.zzWL.unlock();
                return connectionResult2;
            } else if (this.zzXy != null) {
                ConnectionResult connectionResult3 = this.zzXy;
                this.zzWL.unlock();
                return connectionResult3;
            } else {
                ConnectionResult connectionResult4 = new ConnectionResult(13, null);
                this.zzWL.unlock();
                return connectionResult4;
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzu.zza(isConnected(), "GoogleApiClient is not connected yet.");
        final zzl zzl = new zzl(this.zzWt);
        if (this.zzXu.containsKey(zzkl.zzNX)) {
            zza(this, zzl, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            AnonymousClass5 r2 = new GoogleApiClient.ConnectionCallbacks() {
                /* class com.google.android.gms.common.api.zzg.AnonymousClass5 */

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle connectionHint) {
                    zzg.this.zza((GoogleApiClient) atomicReference.get(), zzl, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzkl.API).addConnectionCallbacks(r2).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                /* class com.google.android.gms.common.api.zzg.AnonymousClass6 */

                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(ConnectionResult result) {
                    zzl.setResult(new Status(8));
                }
            }).setHandler(this.zzXs).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzl;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.zzWL.lock();
        try {
            this.zzXx.connect();
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        zzmR();
        zzaY(-1);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append((CharSequence) prefix).append("mState=").append((CharSequence) this.zzXx.getName());
        writer.append(" mResuming=").print(this.zzXp);
        writer.append(" mWorkQueue.size()=").print(this.zzXo.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzXA.size());
        String str = prefix + "  ";
        for (Api<?> api : this.zzXb.keySet()) {
            writer.append((CharSequence) prefix).append((CharSequence) api.getName()).println(":");
            this.zzXu.get(api.zzms()).dump(str, fd, writer, args);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        Api.ClientKey<?> zzms = api.zzms();
        this.zzWL.lock();
        try {
            if (!isConnected() && !zzmO()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (!this.zzXu.containsKey(zzms)) {
                this.zzWL.unlock();
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            } else if (this.zzXu.get(zzms).isConnected()) {
                return ConnectionResult.zzVG;
            } else if (this.zzXv.containsKey(zzms)) {
                ConnectionResult connectionResult = this.zzXv.get(zzms);
                this.zzWL.unlock();
                return connectionResult;
            } else {
                Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed connections map");
                ConnectionResult connectionResult2 = new ConnectionResult(8, null);
                this.zzWL.unlock();
                return connectionResult2;
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzWt;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        Api.Client client = this.zzXu.get(api.zzms());
        if (client == null) {
            return false;
        }
        return client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.zzXx instanceof zzd;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.zzXx instanceof zze;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks listener) {
        return this.zzXn.isConnectionCallbacksRegistered(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener listener) {
        return this.zzXn.isConnectionFailedListenerRegistered(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        this.zzXn.registerConnectionCallbacks(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzXn.registerConnectionFailedListener(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        if (this.zzWB >= 0) {
            zzm.zza(lifecycleActivity).zzbb(this.zzWB);
        } else if (this.zzWC >= 0) {
            zzn.zzb(lifecycleActivity).zzbb(this.zzWC);
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        this.zzXn.unregisterConnectionCallbacks(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzXn.unregisterConnectionFailedListener(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <C extends Api.Client> C zza(Api.ClientKey<C> clientKey) {
        C c = (C) this.zzXu.get(clientKey);
        zzu.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.Client, R extends Result, T extends zza.AbstractC0027zza<R, A>> T zza(T t) {
        zzu.zzb(t.zzms() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        zzu.zzb(this.zzXu.containsKey(t.zzms()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzWL.lock();
        try {
            return (T) this.zzXx.zza(t);
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Api<?> api) {
        return this.zzXu.containsKey(api.zzms());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Scope scope) {
        this.zzWL.lock();
        try {
            return isConnected() && this.zzXw.contains(scope);
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.Client, T extends zza.AbstractC0027zza<? extends Result, A>> T zzb(T t) {
        zzu.zzb(t.zzms() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzWL.lock();
        try {
            if (zzmO()) {
                this.zzXo.add(t);
                while (!this.zzXo.isEmpty()) {
                    zze<?> remove = this.zzXo.remove();
                    zzb(remove);
                    remove.zzr(Status.zzXR);
                }
                return t;
            }
            T t2 = (T) this.zzXx.zzb(t);
            this.zzWL.unlock();
            return t2;
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public <A extends Api.Client> void zzb(zze<A> zze2) {
        this.zzXA.add(zze2);
        zze2.zza(this.zzXB);
    }

    /* access modifiers changed from: package-private */
    public void zze(ConnectionResult connectionResult) {
        this.zzWL.lock();
        try {
            this.zzXy = connectionResult;
            this.zzXx = new zzf(this);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzmK() {
        for (zze<?> zze2 : this.zzXA) {
            zze2.zza(null);
            zze2.cancel();
        }
        this.zzXA.clear();
        for (zzi<?> zzi : this.zzXz) {
            zzi.clear();
        }
        this.zzXz.clear();
        this.zzXw.clear();
    }

    /* access modifiers changed from: package-private */
    public void zzmL() {
        for (Api.Client client : this.zzXu.values()) {
            client.disconnect();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzmM() {
        this.zzWL.lock();
        try {
            this.zzXx = new zze(this, this.zzXa, this.zzXb, this.zzWE, this.zzWL, this.mContext);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzmN() {
        this.zzWL.lock();
        try {
            zzmR();
            this.zzXx = new zzd(this);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzmO() {
        return this.zzXp;
    }

    /* access modifiers changed from: package-private */
    public void zzmQ() {
        if (!zzmO()) {
            this.zzXp = true;
            if (this.zzXt == null) {
                this.zzXt = new zzb(this);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.mContext.getApplicationContext().registerReceiver(this.zzXt, intentFilter);
            }
            this.zzXs.sendMessageDelayed(this.zzXs.obtainMessage(1), this.zzXq);
            this.zzXs.sendMessageDelayed(this.zzXs.obtainMessage(2), this.zzXr);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzmR() {
        this.zzWL.lock();
        try {
            if (!zzmO()) {
                return false;
            }
            this.zzXp = false;
            this.zzXs.removeMessages(2);
            this.zzXs.removeMessages(1);
            if (this.zzXt != null) {
                this.mContext.getApplicationContext().unregisterReceiver(this.zzXt);
                this.zzXt = null;
            }
            this.zzWL.unlock();
            return true;
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzi<L> zzo(L l) {
        zzu.zzb(l, "Listener must not be null");
        this.zzWL.lock();
        try {
            zzi<L> zzi = new zzi<>(this.zzWt, l);
            this.zzXz.add(zzi);
            return zzi;
        } finally {
            this.zzWL.unlock();
        }
    }
}
