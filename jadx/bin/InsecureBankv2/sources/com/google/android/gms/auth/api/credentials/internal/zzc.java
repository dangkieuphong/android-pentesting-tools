package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;

public final class zzc implements CredentialsApi {

    private static class zza extends zza {
        private zza.zzb<Status> zzPg;

        zza(zza.zzb<Status> zzb) {
            this.zzPg = zzb;
        }

        @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks
        public void onStatusResult(Status status) {
            this.zzPg.zzm(status);
        }
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> delete(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(client) {
            /* class com.google.android.gms.auth.api.credentials.internal.zzc.AnonymousClass3 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.auth.api.credentials.internal.zzd
            public void zza(Context context, ICredentialsService iCredentialsService) throws RemoteException {
                iCredentialsService.performCredentialsDeleteOperation(new zza(this), new DeleteRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new zzd<Status>(client) {
            /* class com.google.android.gms.auth.api.credentials.internal.zzc.AnonymousClass4 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.auth.api.credentials.internal.zzd
            public void zza(Context context, ICredentialsService iCredentialsService) throws RemoteException {
                iCredentialsService.performDisableAutoSignInOperation(new zza(this));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, final CredentialRequest request) {
        return client.zza(new zzd<CredentialRequestResult>(client) {
            /* class com.google.android.gms.auth.api.credentials.internal.zzc.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.auth.api.credentials.internal.zzd
            public void zza(Context context, ICredentialsService iCredentialsService) throws RemoteException {
                iCredentialsService.performCredentialsRequestOperation(new zza() {
                    /* class com.google.android.gms.auth.api.credentials.internal.zzc.AnonymousClass1.AnonymousClass1 */

                    @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks
                    public void onCredentialResult(Status status, Credential credential) {
                        AnonymousClass1.this.setResult(new zzb(status, credential));
                    }
                }, request);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzk */
            public CredentialRequestResult createFailedResult(Status status) {
                return zzb.zzj(status);
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> save(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zzd<Status>(client) {
            /* class com.google.android.gms.auth.api.credentials.internal.zzc.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.auth.api.credentials.internal.zzd
            public void zza(Context context, ICredentialsService iCredentialsService) throws RemoteException {
                iCredentialsService.performCredentialsSaveOperation(new zza(this), new SaveRequest(credential));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }
}
