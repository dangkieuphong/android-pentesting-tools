package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzn;
import java.util.HashMap;
import java.util.Map;

public class zza extends zzn.zza {
    private final BleScanCallback zzalI;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza  reason: collision with other inner class name */
    public static class C0059zza {
        private static final C0059zza zzalJ = new C0059zza();
        private final Map<BleScanCallback, zza> zzalK = new HashMap();

        private C0059zza() {
        }

        public static C0059zza zzqS() {
            return zzalJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzalK) {
                zza = this.zzalK.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                    this.zzalK.put(bleScanCallback, zza);
                }
            }
            return zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzalK) {
                zza = this.zzalK.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                }
            }
            return zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzalI = (BleScanCallback) zzu.zzu(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzalI.onDeviceFound(device);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onScanStopped() throws RemoteException {
        this.zzalI.onScanStopped();
    }
}
