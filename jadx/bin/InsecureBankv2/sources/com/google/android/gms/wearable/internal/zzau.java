package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.wearable.internal.zzat;
import com.google.android.gms.wearable.internal.zzbj;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzau<T> {
    private final Map<T, zzbl<T>> zzakE = new HashMap();

    /* access modifiers changed from: private */
    public static class zza<T> extends zzbj.zzb<Status> {
        private WeakReference<Map<T, zzbl<T>>> zzaUA;
        private WeakReference<T> zzaUB;

        zza(Map<T, zzbl<T>> map, T t, zza.zzb<Status> zzb) {
            super(zzb);
            this.zzaUA = new WeakReference<>(map);
            this.zzaUB = new WeakReference<>(t);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.common.api.Status */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(Status status) {
            Map<T, zzbl<T>> map = this.zzaUA.get();
            T t = this.zzaUB.get();
            if (!(status.getStatus().isSuccess() || map == null || t == null)) {
                synchronized (map) {
                    zzbl<T> remove = map.remove(t);
                    if (remove != null) {
                        remove.clear();
                    }
                }
            }
            zzP(status);
        }
    }

    /* access modifiers changed from: private */
    public static class zzb<T> extends zzbj.zzb<Status> {
        private WeakReference<Map<T, zzbl<T>>> zzaUA;
        private WeakReference<T> zzaUB;

        zzb(Map<T, zzbl<T>> map, T t, zza.zzb<Status> zzb) {
            super(zzb);
            this.zzaUA = new WeakReference<>(map);
            this.zzaUB = new WeakReference<>(t);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.android.gms.common.api.Status */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzar
        public void zza(Status status) {
            Map<T, zzbl<T>> map = this.zzaUA.get();
            T t = this.zzaUB.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || t == null)) {
                synchronized (map) {
                    zzbl<T> remove = map.remove(t);
                    if (remove != null) {
                        remove.clear();
                    }
                }
            }
            zzP(status);
        }
    }

    zzau() {
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.zzakE) {
            isEmpty = this.zzakE.isEmpty();
        }
        return isEmpty;
    }

    public void zza(zzbk zzbk, zza.zzb<Status> zzb2, T t) throws RemoteException {
        synchronized (this.zzakE) {
            zzbl<T> remove = this.zzakE.remove(t);
            if (remove == null) {
                zzb2.zzm(new Status(4002));
                return;
            }
            remove.clear();
            ((zzat) zzbk.zznM()).zza(new zzb(this.zzakE, t, zzb2), new RemoveListenerRequest(remove));
        }
    }

    public void zza(zzbk zzbk, zza.zzb<Status> zzb2, T t, zzbl<T> zzbl) throws RemoteException {
        synchronized (this.zzakE) {
            if (this.zzakE.get(t) != null) {
                zzb2.zzm(new Status(4001));
                return;
            }
            this.zzakE.put(t, zzbl);
            try {
                ((zzat) zzbk.zznM()).zza(new zza(this.zzakE, t, zzb2), new AddListenerRequest(zzbl));
            } catch (RemoteException e) {
                this.zzakE.remove(t);
                throw e;
            }
        }
    }

    public void zzb(zzbk zzbk) {
        synchronized (this.zzakE) {
            zzbj.zzo zzo = new zzbj.zzo();
            for (Map.Entry<T, zzbl<T>> entry : this.zzakE.entrySet()) {
                zzbl<T> value = entry.getValue();
                if (value != null) {
                    value.clear();
                    if (zzbk.isConnected()) {
                        try {
                            ((zzat) zzbk.zznM()).zza(zzo, new RemoveListenerRequest(value));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + ((Object) entry.getKey()) + "/" + value);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + ((Object) entry.getKey()) + "/" + value);
                        }
                    }
                }
            }
            this.zzakE.clear();
        }
    }

    public void zzdR(IBinder iBinder) {
        synchronized (this.zzakE) {
            zzat zzdQ = zzat.zza.zzdQ(iBinder);
            zzbj.zzo zzo = new zzbj.zzo();
            for (Map.Entry<T, zzbl<T>> entry : this.zzakE.entrySet()) {
                zzbl<T> value = entry.getValue();
                try {
                    zzdQ.zza(zzo, new AddListenerRequest(value));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + ((Object) entry.getKey()) + "/" + value);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + ((Object) entry.getKey()) + "/" + value);
                }
            }
        }
    }
}
