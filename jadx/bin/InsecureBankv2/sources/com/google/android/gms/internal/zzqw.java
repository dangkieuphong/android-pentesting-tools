package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

public class zzqw implements Payments {
    @Override // com.google.android.gms.wallet.Payments
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zze(googleTransactionId, merchantTransactionId, requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zzjB(requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zzjC(requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) {
            /* class com.google.android.gms.internal.zzqw.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzqx zzqx) {
                zzqx.zza(request);
                setResult(Status.zzXP);
            }
        });
    }
}
