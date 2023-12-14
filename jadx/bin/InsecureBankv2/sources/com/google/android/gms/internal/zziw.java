package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zziy;

public class zziw implements AppInviteApi {

    static abstract class zza<R extends Result> extends zza.AbstractC0027zza<R, zzix> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppInvite.zzNX, googleApiClient);
        }
    }

    final class zzb extends zza<Status> {
        private final String zzNZ;

        public zzb(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzNZ = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzix zzix) throws RemoteException {
            zzix.zzb(new zziy.zza() {
                /* class com.google.android.gms.internal.zziw.zzb.AnonymousClass1 */

                @Override // com.google.android.gms.internal.zziy
                public void zzc(Status status) throws RemoteException {
                    zzb.this.setResult(status);
                }
            }, this.zzNZ);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    final class zzc extends zza<Status> {
        private final String zzNZ;

        public zzc(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzNZ = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzix zzix) throws RemoteException {
            zzix.zza(new zziy.zza() {
                /* class com.google.android.gms.internal.zziw.zzc.AnonymousClass1 */

                @Override // com.google.android.gms.internal.zziy
                public void zzc(Status status) throws RemoteException {
                    zzc.this.setResult(status);
                }
            }, this.zzNZ);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(client, invitationId));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzb(client, invitationId));
    }
}
