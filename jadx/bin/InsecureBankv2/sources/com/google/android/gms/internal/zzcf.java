package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzch;

@zzgd
public final class zzcf extends zzch.zza {
    private final zzf zzuS;
    private final String zzuT;
    private final String zzuU;

    public zzcf(zzf zzf, String str, String str2) {
        this.zzuS = zzf;
        this.zzuT = str;
        this.zzuU = str2;
    }

    @Override // com.google.android.gms.internal.zzch
    public String getContent() {
        return this.zzuU;
    }

    @Override // com.google.android.gms.internal.zzch
    public void recordClick() {
        this.zzuS.recordClick();
    }

    @Override // com.google.android.gms.internal.zzch
    public void recordImpression() {
        this.zzuS.recordImpression();
    }

    @Override // com.google.android.gms.internal.zzch
    public void zza(zzd zzd) {
        if (zzd != null) {
            this.zzuS.zzc((View) zze.zzn(zzd));
        }
    }

    @Override // com.google.android.gms.internal.zzch
    public String zzdt() {
        return this.zzuT;
    }
}
