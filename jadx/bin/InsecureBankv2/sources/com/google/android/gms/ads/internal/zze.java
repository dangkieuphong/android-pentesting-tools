package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzid;

@zzgd
public class zze extends zzc {
    public zze(Context context, AdSizeParcel adSizeParcel, String str, zzef zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzef, versionInfoParcel);
    }

    private boolean zzb(zzha zzha, zzha zzha2) {
        if (zzha2.zzCK) {
            try {
                zzd view = zzha2.zzya.getView();
                if (view == null) {
                    zzb.zzaC("View in mediation adapter is null.");
                    return false;
                }
                View view2 = (View) com.google.android.gms.dynamic.zze.zzn(view);
                View nextView = this.zzon.zzpK.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzid) {
                        ((zzid) nextView).destroy();
                    }
                    this.zzon.zzpK.removeView(nextView);
                }
                try {
                    zzb(view2);
                } catch (Throwable th) {
                    zzb.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not get View from mediation adapter.", e);
                return false;
            }
        } else if (zzha2.zzFn != null) {
            zzha2.zzzE.zza(zzha2.zzFn);
            this.zzon.zzpK.removeAllViews();
            this.zzon.zzpK.setMinimumWidth(zzha2.zzFn.widthPixels);
            this.zzon.zzpK.setMinimumHeight(zzha2.zzFn.heightPixels);
            zzb(zzha2.zzzE.getWebView());
        }
        if (this.zzon.zzpK.getChildCount() > 1) {
            this.zzon.zzpK.showNext();
        }
        if (zzha != null) {
            View nextView2 = this.zzon.zzpK.getNextView();
            if (nextView2 instanceof zzid) {
                ((zzid) nextView2).zza(this.zzon.zzpH, this.zzon.zzpN);
            } else if (nextView2 != null) {
                this.zzon.zzpK.removeView(nextView2);
            }
            this.zzon.zzbL();
        }
        this.zzon.zzpK.setVisibility(0);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zzb
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public boolean zza(zzha zzha, zzha zzha2) {
        if (!super.zza(zzha, zzha2)) {
            return false;
        }
        if (!this.zzon.zzbM() || zzb(zzha, zzha2)) {
            zza(zzha2, false);
            if (this.zzon.zzbM()) {
                if (zzha2.zzzE != null && (zzha2.zzzE.zzgF().zzbU() || zzha2.zzFl != null)) {
                    zzaz zza = this.zzop.zza(this.zzon.zzpN, zzha2);
                    if (zzha2.zzzE.zzgF().zzbU() && zza != null) {
                        zza.zza(this);
                    }
                }
                if (zzha2.zzzE != null) {
                    zzha2.zzzE.zzgF().zzgS();
                }
            } else if (!(this.zzon.zzqg == null || zzha2.zzFl == null)) {
                this.zzop.zza(this.zzon.zzpN, zzha2, this.zzon.zzqg);
            }
            return true;
        }
        zze(0);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzb
    public boolean zzaU() {
        boolean z = true;
        if (!zzo.zzbv().zza(this.zzon.zzpH.getPackageManager(), this.zzon.zzpH.getPackageName(), "android.permission.INTERNET")) {
            zzk.zzcA().zza(this.zzon.zzpK, this.zzon.zzpN, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzo.zzbv().zzG(this.zzon.zzpH)) {
            zzk.zzcA().zza(this.zzon.zzpK, this.zzon.zzpN, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzon.zzpK != null) {
            this.zzon.zzpK.setVisibility(0);
        }
        return z;
    }
}
