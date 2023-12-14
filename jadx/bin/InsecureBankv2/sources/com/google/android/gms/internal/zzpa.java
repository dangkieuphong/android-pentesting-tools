package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;

public final class zzpa implements Account {

    private static abstract class zza extends Plus.zza<Status> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Account
    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        zze zzf = Plus.zzf(googleApiClient, false);
        if (zzf != null) {
            zzf.zzxr();
        }
    }

    @Override // com.google.android.gms.plus.Account
    public String getAccountName(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).getAccountName();
    }

    @Override // com.google.android.gms.plus.Account
    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* class com.google.android.gms.internal.zzpa.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzk(this);
            }
        });
    }
}
