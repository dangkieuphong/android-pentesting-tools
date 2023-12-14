package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzj implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzaaC;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaaD = new ArrayList<>();
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaaE = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaaF = new ArrayList<>();
    private volatile boolean zzaaG = false;
    private final AtomicInteger zzaaH = new AtomicInteger(0);
    private boolean zzaaI = false;
    private final Object zzqt = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzlM();
    }

    public zzj(Looper looper, zza zza2) {
        this.zzaaC = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) msg.obj;
            synchronized (this.zzqt) {
                if (this.zzaaG && this.zzaaC.isConnected() && this.zzaaD.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzaaC.zzlM());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks listener) {
        boolean contains;
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            contains = this.zzaaD.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener listener) {
        boolean contains;
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            contains = this.zzaaF.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            if (this.zzaaD.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.zzaaD.add(listener);
            }
        }
        if (this.zzaaC.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            if (this.zzaaF.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.zzaaF.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            if (!this.zzaaD.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
            } else if (this.zzaaI) {
                this.zzaaE.add(listener);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        zzu.zzu(listener);
        synchronized (this.zzqt) {
            if (!this.zzaaF.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }

    public void zzbu(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzqt) {
            this.zzaaI = true;
            ArrayList arrayList = new ArrayList(this.zzaaD);
            int i2 = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzaaG || this.zzaaH.get() != i2) {
                    break;
                } else if (this.zzaaD.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzaaE.clear();
            this.zzaaI = false;
        }
    }

    public void zzg(Bundle bundle) {
        boolean z = true;
        synchronized (this.zzqt) {
            zzu.zzU(!this.zzaaI);
            this.mHandler.removeMessages(1);
            this.zzaaI = true;
            if (this.zzaaE.size() != 0) {
                z = false;
            }
            zzu.zzU(z);
            ArrayList arrayList = new ArrayList(this.zzaaD);
            int i = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzaaG || !this.zzaaC.isConnected() || this.zzaaH.get() != i) {
                    break;
                } else if (!this.zzaaE.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzaaE.clear();
            this.zzaaI = false;
        }
    }

    public void zzh(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzqt) {
            ArrayList arrayList = new ArrayList(this.zzaaF);
            int i = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (this.zzaaG && this.zzaaH.get() == i) {
                    if (this.zzaaF.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void zznT() {
        this.zzaaG = false;
        this.zzaaH.incrementAndGet();
    }

    public void zznU() {
        this.zzaaG = true;
    }
}
