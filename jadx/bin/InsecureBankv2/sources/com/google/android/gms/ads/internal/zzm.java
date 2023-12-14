package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzkw;
import java.util.List;

@zzgd
public class zzm extends zzb {
    public zzm(Context context, AdSizeParcel adSizeParcel, String str, zzef zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzef, versionInfoParcel);
    }

    private void zza(final zzha zzha, final String str) {
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.zzm.AnonymousClass3 */

            public void run() {
                try {
                    zzm.this.zzon.zzqa.get(str).zza((zzf) zzha.zzFq);
                } catch (RemoteException e) {
                    zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    private void zzd(final zzha zzha) {
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.zzm.AnonymousClass1 */

            public void run() {
                try {
                    zzm.this.zzon.zzpX.zza((zzd) zzha.zzFq);
                } catch (RemoteException e) {
                    zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zze(final zzha zzha) {
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.zzm.AnonymousClass2 */

            public void run() {
                try {
                    zzm.this.zzon.zzpY.zza((zze) zzha.zzFq);
                } catch (RemoteException e) {
                    zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zzb
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zza
    public void zza(zzci zzci) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public void zza(zzff zzff) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(zzkw<String, zzcx> zzkw) {
        zzu.zzbY("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzon.zzqa = zzkw;
    }

    public void zza(List<String> list) {
        zzu.zzbY("setNativeTemplates must be called on the main UI thread.");
        this.zzon.zzqd = list;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzb
    public boolean zza(AdRequestParcel adRequestParcel, zzha zzha, boolean z) {
        return this.zzom.zzbp();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public boolean zza(zzha zzha, zzha zzha2) {
        zza((List<String>) null);
        if (!this.zzon.zzbM()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        zzg.zza zza = zzha2.zzFq;
        if ((zza instanceof zze) && this.zzon.zzpY != null) {
            zze(zzha2);
        } else if ((zza instanceof zzd) && this.zzon.zzpX != null) {
            zzd(zzha2);
        } else if (!(zza instanceof zzf) || this.zzon.zzqa == null || this.zzon.zzqa.get(((zzf) zza).getCustomTemplateId()) == null) {
            zzb.zzaC("No matching listener for retrieved native ad template.");
            zze(0);
            return false;
        } else {
            zza(zzha2, ((zzf) zza).getCustomTemplateId());
        }
        return super.zza(zzha, zzha2);
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzu.zzbY("setNativeAdOptions must be called on the main UI thread.");
        this.zzon.zzqb = nativeAdOptionsParcel;
    }

    public void zzb(zzcu zzcu) {
        zzu.zzbY("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzon.zzpX = zzcu;
    }

    public void zzb(zzcv zzcv) {
        zzu.zzbY("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzon.zzpY = zzcv;
    }

    public void zzb(zzkw<String, zzcw> zzkw) {
        zzu.zzbY("setOnCustomClickListener must be called on the main UI thread.");
        this.zzon.zzpZ = zzkw;
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzb(zzha.zza zza) {
        if (zza.zzpN != null) {
            this.zzon.zzpN = zza.zzpN;
        }
        if (zza.errorCode != -2) {
            zzb(new zzha(zza, null, null, null, null, null, null));
            return false;
        }
        this.zzon.zzqh = 0;
        this.zzon.zzpM = zzo.zzbu().zza(this.zzon.zzpH, this, zza, this.zzon.zzpI, null, this.zzoq, this);
        return true;
    }

    public zzkw<String, zzcx> zzbo() {
        zzu.zzbY("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzon.zzqa;
    }

    public zzcw zzq(String str) {
        zzu.zzbY("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzon.zzpZ.get(str);
    }
}
