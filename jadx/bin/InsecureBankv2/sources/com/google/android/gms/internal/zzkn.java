package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzko;

public final class zzkn implements zzkm {

    /* access modifiers changed from: private */
    public static class zza extends zzkk {
        private final zza.zzb<Status> zzOs;

        public zza(zza.zzb<Status> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzkk, com.google.android.gms.internal.zzkq
        public void zzbB(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    @Override // com.google.android.gms.internal.zzkm
    public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzko.zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzkn.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzkp zzkp) throws RemoteException {
                ((zzkr) zzkp.zznM()).zza(new zza(this));
            }
        });
    }
}
