package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzie;
import org.json.JSONObject;

@zzgd
public class zzbd implements zzbb {
    private final zzid zzoA;

    public zzbd(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzoA = zzo.zzbw().zza(context, new AdSizeParcel(), false, false, null, versionInfoParcel);
        this.zzoA.setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzk.zzcA().zzgw()) {
            runnable.run();
        } else {
            zzhl.zzGk.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.zzbb
    public void destroy() {
        this.zzoA.destroy();
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zza(zza zza, zzf zzf, zzde zzde, com.google.android.gms.ads.internal.overlay.zzk zzk, boolean z, zzdi zzdi, zzdk zzdk, zzd zzd, zzev zzev) {
        this.zzoA.zzgF().zzb(zza, zzf, zzde, zzk, z, zzdi, zzdk, new zzd(false), zzev);
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zza(final zzbb.zza zza) {
        this.zzoA.zzgF().zza(new zzie.zza() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass6 */

            @Override // com.google.android.gms.internal.zzie.zza
            public void zza(zzid zzid, boolean z) {
                zza.zzcf();
            }
        });
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, zzdg zzdg) {
        this.zzoA.zzgF().zza(str, zzdg);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass2 */

            public void run() {
                zzbd.this.zzoA.zza(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass1 */

            public void run() {
                zzbd.this.zzoA.zza(str, jSONObject);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, zzdg zzdg) {
        this.zzoA.zzgF().zzb(str, zzdg);
    }

    @Override // com.google.android.gms.internal.zzbb
    public zzbf zzce() {
        return new zzbg(this);
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzr(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass3 */

            public void run() {
                zzbd.this.zzoA.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzs(final String str) {
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass5 */

            public void run() {
                zzbd.this.zzoA.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.zzbb
    public void zzt(final String str) {
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.internal.zzbd.AnonymousClass4 */

            public void run() {
                zzbd.this.zzoA.loadData(str, "text/html", "UTF-8");
            }
        });
    }
}
