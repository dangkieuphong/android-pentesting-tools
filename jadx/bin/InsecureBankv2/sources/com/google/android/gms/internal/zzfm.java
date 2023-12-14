package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzgd
public class zzfm implements InAppPurchaseResult {
    private final zzfi zzBc;

    public zzfm(zzfi zzfi) {
        this.zzBc = zzfi;
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public void finishPurchase() {
        try {
            this.zzBc.finishPurchase();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public String getProductId() {
        try {
            return this.zzBc.getProductId();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public Intent getPurchaseData() {
        try {
            return this.zzBc.getPurchaseData();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public int getResultCode() {
        try {
            return this.zzBc.getResultCode();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public boolean isVerified() {
        try {
            return this.zzBc.isVerified();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
