package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zznu;
import java.util.ListIterator;

public class zza extends zznr<zza> {
    private final zzf zzIa;
    private boolean zzIb;

    public zza(zzf zzf) {
        super(zzf.zzhS(), zzf.zzhP());
        this.zzIa = zzf;
    }

    public void enableAdvertisingIdCollection(boolean enable) {
        this.zzIb = enable;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zznr
    public void zza(zzno zzno) {
        zzip zzip = (zzip) zzno.zze(zzip.class);
        if (TextUtils.isEmpty(zzip.getClientId())) {
            zzip.setClientId(this.zzIa.zzih().zziP());
        }
        if (this.zzIb && TextUtils.isEmpty(zzip.zzhx())) {
            com.google.android.gms.analytics.internal.zza zzig = this.zzIa.zzig();
            zzip.zzaO(zzig.zzhC());
            zzip.zzE(zzig.zzhy());
        }
    }

    public void zzaI(String str) {
        zzu.zzcj(str);
        zzaJ(str);
        zzwb().add(new zzb(this.zzIa, str));
    }

    public void zzaJ(String str) {
        Uri zzaK = zzb.zzaK(str);
        ListIterator<zznu> listIterator = zzwb().listIterator();
        while (listIterator.hasNext()) {
            if (zzaK.equals(listIterator.next().zzhe())) {
                listIterator.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzf zzhb() {
        return this.zzIa;
    }

    @Override // com.google.android.gms.internal.zznr
    public zzno zzhc() {
        zzno zzvP = zzwa().zzvP();
        zzvP.zzb(this.zzIa.zzhX().zzix());
        zzvP.zzb(this.zzIa.zzhY().zzjE());
        zzd(zzvP);
        return zzvP;
    }
}
