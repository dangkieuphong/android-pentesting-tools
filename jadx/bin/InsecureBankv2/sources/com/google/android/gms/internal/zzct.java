package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzgd
public class zzct implements NativeCustomTemplateAd {
    private final zzcs zzvP;

    public zzct(zzcs zzcs) {
        this.zzvP = zzcs;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public List<String> getAvailableAssetNames() {
        try {
            return this.zzvP.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public String getCustomTemplateId() {
        try {
            return this.zzvP.getCustomTemplateId();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public NativeAd.Image getImage(String assetName) {
        try {
            zzck zzR = this.zzvP.zzR(assetName);
            if (zzR != null) {
                return new zzcl(zzR);
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public CharSequence getText(String assetName) {
        try {
            return this.zzvP.zzQ(assetName);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void performClick(String assetName) {
        try {
            this.zzvP.performClick(assetName);
        } catch (RemoteException e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public void recordImpression() {
        try {
            this.zzvP.recordImpression();
        } catch (RemoteException e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
