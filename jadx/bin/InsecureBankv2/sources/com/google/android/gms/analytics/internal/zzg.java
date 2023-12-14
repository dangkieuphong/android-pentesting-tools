package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzns;

public class zzg {
    private final Context zzJR;
    private final Context zzqw;

    public zzg(Context context) {
        zzu.zzu(context);
        Context applicationContext = context.getApplicationContext();
        zzu.zzb(applicationContext, "Application context can't be null");
        this.zzqw = applicationContext;
        this.zzJR = applicationContext;
    }

    public Context getApplicationContext() {
        return this.zzqw;
    }

    /* access modifiers changed from: protected */
    public zzns zzW(Context context) {
        return zzns.zzaB(context);
    }

    /* access modifiers changed from: protected */
    public zzu zza(zzf zzf) {
        return new zzu(zzf);
    }

    /* access modifiers changed from: protected */
    public zzk zzb(zzf zzf) {
        return new zzk(zzf);
    }

    /* access modifiers changed from: protected */
    public zza zzc(zzf zzf) {
        return new zza(zzf);
    }

    /* access modifiers changed from: protected */
    public zzn zzd(zzf zzf) {
        return new zzn(zzf);
    }

    /* access modifiers changed from: protected */
    public zzan zze(zzf zzf) {
        return new zzan(zzf);
    }

    /* access modifiers changed from: protected */
    public zzaf zzf(zzf zzf) {
        return new zzaf(zzf);
    }

    /* access modifiers changed from: protected */
    public zzr zzg(zzf zzf) {
        return new zzr(zzf);
    }

    /* access modifiers changed from: protected */
    public zzlb zzh(zzf zzf) {
        return zzld.zzoQ();
    }

    /* access modifiers changed from: protected */
    public GoogleAnalytics zzi(zzf zzf) {
        return new GoogleAnalytics(zzf);
    }

    public Context zzic() {
        return this.zzJR;
    }

    /* access modifiers changed from: package-private */
    public zzl zzj(zzf zzf) {
        return new zzl(zzf, this);
    }

    /* access modifiers changed from: package-private */
    public zzag zzk(zzf zzf) {
        return new zzag(zzf);
    }

    /* access modifiers changed from: protected */
    public zzb zzl(zzf zzf) {
        return new zzb(zzf, this);
    }

    public zzj zzm(zzf zzf) {
        return new zzj(zzf);
    }

    public zzah zzn(zzf zzf) {
        return new zzah(zzf);
    }

    public zzi zzo(zzf zzf) {
        return new zzi(zzf);
    }

    public zzv zzp(zzf zzf) {
        return new zzv(zzf);
    }

    public zzai zzq(zzf zzf) {
        return new zzai(zzf);
    }
}
