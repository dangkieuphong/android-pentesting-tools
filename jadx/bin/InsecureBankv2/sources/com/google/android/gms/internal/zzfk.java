package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzff;

@zzgd
public final class zzfk extends zzff.zza {
    private final InAppPurchaseListener zzsW;

    public zzfk(InAppPurchaseListener inAppPurchaseListener) {
        this.zzsW = inAppPurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzff
    public void zza(zzfe zzfe) {
        this.zzsW.onInAppPurchaseRequested(new zzfn(zzfe));
    }
}
