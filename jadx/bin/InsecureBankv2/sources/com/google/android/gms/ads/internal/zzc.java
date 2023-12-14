package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzid;

@zzgd
public abstract class zzc extends zzb implements zzf, zzev {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzef zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzef, versionInfoParcel);
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public void recordClick() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzf, com.google.android.gms.ads.internal.zza
    public void recordImpression() {
        zza(this.zzon.zzpO, false);
    }

    /* access modifiers changed from: protected */
    public zzid zza(zzd zzd) {
        zzid zza;
        View nextView = this.zzon.zzpK.getNextView();
        if (nextView instanceof zzid) {
            zza = (zzid) nextView;
            zza.zza(this.zzon.zzpH, this.zzon.zzpN);
        } else {
            if (nextView != null) {
                this.zzon.zzpK.removeView(nextView);
            }
            zza = zzo.zzbw().zza(this.zzon.zzpH, this.zzon.zzpN, false, false, this.zzon.zzpI, this.zzon.zzpJ);
            if (this.zzon.zzpN.zzso == null) {
                zzb(zza.getWebView());
            }
        }
        zza.zzgF().zzb(this, this, this, this, false, this, null, zzd, this);
        return zza;
    }

    @Override // com.google.android.gms.internal.zzev
    public void zza(int i, int i2, int i3, int i4) {
        zzaS();
    }

    @Override // com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.ads.internal.zza
    public void zza(zzci zzci) {
        zzu.zzbY("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzon.zzqc = zzci;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.zzb
    public boolean zza(zzha zzha, zzha zzha2) {
        if (this.zzon.zzbM() && this.zzon.zzpK != null) {
            this.zzon.zzpK.zzbP().zzaw(zzha2.zzCP);
        }
        return super.zza(zzha, zzha2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzb(zzha.zza zza) {
        String str = null;
        final zzd zzd = new zzd();
        zzid zza2 = zza(zzd);
        zzd.zza(new zzd.zzb(zza, zza2));
        zza2.setOnTouchListener(new View.OnTouchListener() {
            /* class com.google.android.gms.ads.internal.zzc.AnonymousClass1 */

            public boolean onTouch(View v, MotionEvent event) {
                zzd.recordClick();
                return false;
            }
        });
        zza2.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.gms.ads.internal.zzc.AnonymousClass2 */

            public void onClick(View v) {
                zzd.recordClick();
            }
        });
        if (zza.zzpN != null) {
            this.zzon.zzpN = zza.zzpN;
        }
        if (zza.errorCode != -2) {
            zzb(new zzha(zza, zza2, null, null, null, null, null));
            return false;
        }
        if (!zza.zzFs.zzCK && zza.zzFs.zzCT) {
            if (zza.zzFs.zzzG != null) {
                str = zzo.zzbv().zzat(zza.zzFs.zzzG);
            }
            zzcf zzcf = new zzcf(this, str, zza.zzFs.zzCI);
            try {
                if (this.zzon.zzqc != null) {
                    this.zzon.zzqh = 1;
                    this.zzon.zzqc.zza(zzcf);
                    return false;
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
            }
        }
        this.zzon.zzqh = 0;
        this.zzon.zzpM = zzo.zzbu().zza(this.zzon.zzpH, this, zza, this.zzon.zzpI, zza2, this.zzoq, this);
        return true;
    }

    @Override // com.google.android.gms.internal.zzev
    public void zzbc() {
        zzaQ();
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public void zzc(View view) {
        this.zzon.zzqg = view;
        zzb(new zzha(this.zzon.zzpP, null, null, null, null, null, null));
    }
}
