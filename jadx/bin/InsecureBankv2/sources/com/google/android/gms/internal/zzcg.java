package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgd
public class zzcg implements CustomRenderedAd {
    private final zzch zzuV;

    public zzcg(zzch zzch) {
        this.zzuV = zzch;
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public String getBaseUrl() {
        try {
            return this.zzuV.zzdt();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public String getContent() {
        try {
            return this.zzuV.getContent();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public void onAdRendered(View view) {
        try {
            this.zzuV.zza(view != null ? zze.zzw(view) : null);
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public void recordClick() {
        try {
            this.zzuV.recordClick();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public void recordImpression() {
        try {
            this.zzuV.recordImpression();
        } catch (RemoteException e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
