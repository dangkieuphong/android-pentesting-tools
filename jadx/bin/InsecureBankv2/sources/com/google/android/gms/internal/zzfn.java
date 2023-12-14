package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgd
public class zzfn implements InAppPurchase {
    private final zzfe zzAN;

    public zzfn(zzfe zzfe) {
        this.zzAN = zzfe;
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public String getProductId() {
        try {
            return this.zzAN.getProductId();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.zzAN.recordPlayBillingResolution(billingResponseCode);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public void recordResolution(int resolution) {
        try {
            this.zzAN.recordResolution(resolution);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
