package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafetyNetApi;

public class zzpj implements SafetyNetApi {

    /* access modifiers changed from: package-private */
    public static class zza implements SafetyNetApi.AttestationResult {
        private final Status zzOt;
        private final AttestationData zzaJB;

        public zza(Status status, AttestationData attestationData) {
            this.zzOt = status;
            this.zzaJB = attestationData;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.AttestationResult
        public String getJwsResult() {
            if (this.zzaJB == null) {
                return null;
            }
            return this.zzaJB.getJwsResult();
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static abstract class zzb extends zzpg<SafetyNetApi.AttestationResult> {
        protected zzph zzaJC = new zzpf() {
            /* class com.google.android.gms.internal.zzpj.zzb.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzpf, com.google.android.gms.internal.zzph
            public void zza(Status status, AttestationData attestationData) {
                zzb.this.setResult(new zza(status, attestationData));
            }
        };

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaR */
        public SafetyNetApi.AttestationResult createFailedResult(Status status) {
            return new zza(status, null);
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzpj.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzpk zzpk) throws RemoteException {
                zzpk.zza(this.zzaJC, nonce);
            }
        });
    }
}
