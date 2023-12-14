package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    public void zzaL(String str) {
        zzax.zzex(str);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.CampaignTrackingReceiver
    public Class<? extends CampaignTrackingService> zzhf() {
        return InstallReferrerService.class;
    }
}
