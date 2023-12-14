package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzid;

@zzgd
public class zzj extends zzc implements zzdk {
    protected transient boolean zzoT = false;

    public zzj(Context context, AdSizeParcel adSizeParcel, String str, zzef zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzef, versionInfoParcel);
    }

    private void zza(Bundle bundle) {
        zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, "gmob-apps", bundle, false);
    }

    private void zzbk() {
        if (this.zzon.zzbM()) {
            this.zzon.zzbJ();
            this.zzon.zzpO = null;
            this.zzon.zzoU = false;
            this.zzoT = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zzb
    public void showInterstitial() {
        zzu.zzbY("showInterstitial must be called on the main UI thread.");
        if (this.zzon.zzpO == null) {
            zzb.zzaC("The interstitial has not loaded.");
            return;
        }
        String packageName = this.zzon.zzpH.getApplicationContext() != null ? this.zzon.zzpH.getApplicationContext().getPackageName() : this.zzon.zzpH.getPackageName();
        if (!this.zzoT) {
            zzb.zzaC("It is not recommended to show an interstitial before onAdLoaded completes.");
            Bundle bundle = new Bundle();
            bundle.putString("appid", packageName);
            bundle.putString("action", "show_interstitial_before_load_finish");
            zza(bundle);
        }
        if (!zzo.zzbv().zzM(this.zzon.zzpH)) {
            zzb.zzaC("It is not recommended to show an interstitial when app is not in foreground.");
            Bundle bundle2 = new Bundle();
            bundle2.putString("appid", packageName);
            bundle2.putString("action", "show_interstitial_app_not_in_foreground");
            zza(bundle2);
        }
        if (this.zzon.zzbN()) {
            return;
        }
        if (this.zzon.zzpO.zzzE.zzgJ()) {
            zzb.zzaC("The interstitial is already showing.");
            return;
        }
        this.zzon.zzpO.zzzE.zzB(true);
        if (this.zzon.zzpO.zzzE.zzgF().zzbU() || this.zzon.zzpO.zzFl != null) {
            zzaz zza = this.zzop.zza(this.zzon.zzpN, this.zzon.zzpO);
            if (this.zzon.zzpO.zzzE.zzgF().zzbU() && zza != null) {
                zza.zza(this);
            }
        }
        if (this.zzon.zzpO.zzCK) {
            try {
                this.zzon.zzpO.zzya.showInterstitial();
            } catch (RemoteException e) {
                zzb.zzd("Could not show interstitial.", e);
                zzbk();
            }
        } else {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzon.zzoU, zzbj());
            int requestedOrientation = this.zzon.zzpO.zzzE.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzon.zzpO.orientation;
            }
            zzo.zzbt().zza(this.zzon.zzpH, new AdOverlayInfoParcel(this, this, this, this.zzon.zzpO.zzzE, requestedOrientation, this.zzon.zzpJ, this.zzon.zzpO.zzCP, interstitialAdParameterParcel));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public zzid zza(zzd zzd) {
        zzid zza = zzo.zzbw().zza(this.zzon.zzpH, this.zzon.zzpN, false, false, this.zzon.zzpI, this.zzon.zzpJ);
        zza.zzgF().zzb(this, null, this, this, zzbz.zzuk.get().booleanValue(), this, this, zzd, null);
        return zza;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzb
    public boolean zza(AdRequestParcel adRequestParcel, zzha zzha, boolean z) {
        if (this.zzon.zzbM()) {
            zzo.zzbx().zza(zzha.zzzE.getWebView());
        }
        return this.zzom.zzbp();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public boolean zza(zzha zzha, zzha zzha2) {
        if (!super.zza(zzha, zzha2)) {
            return false;
        }
        if (this.zzon.zzbM()) {
            if (zzha2.zzzE != null) {
                zzha2.zzzE.zzgF().zzgS();
            }
        } else if (!(this.zzon.zzqg == null || zzha2.zzFl == null)) {
            this.zzop.zza(this.zzon.zzpN, zzha2, this.zzon.zzqg);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzaT() {
        if (!super.zzaT()) {
            return false;
        }
        this.zzoT = true;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzf, com.google.android.gms.ads.internal.zzb
    public void zzaV() {
        zzbk();
        super.zzaV();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzf, com.google.android.gms.ads.internal.zzb
    public void zzaW() {
        recordImpression();
        super.zzaW();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public boolean zzb(AdRequestParcel adRequestParcel) {
        if (this.zzon.zzpO == null) {
            return super.zzb(adRequestParcel);
        }
        zzb.zzaC("An interstitial is already loading. Aborting.");
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzbj() {
        Window window;
        if (!(this.zzon.zzpH instanceof Activity) || (window = ((Activity) this.zzon.zzpH).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zzd(boolean z) {
        this.zzon.zzoU = z;
    }
}
