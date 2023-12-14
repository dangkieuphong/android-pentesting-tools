package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;

@zzgd
public class zzdp extends zzhh {
    final zzid zzoA;
    final zzdr zzwB;
    private final String zzwC;

    zzdp(zzid zzid, String str) {
        this.zzoA = zzid;
        this.zzwB = new zzdr(zzid);
        this.zzwC = str;
        zzo.zzbH().zza(this);
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        this.zzwB.abort();
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        try {
            this.zzwB.zzW(this.zzwC);
        } finally {
            zzhl.zzGk.post(new Runnable() {
                /* class com.google.android.gms.internal.zzdp.AnonymousClass1 */

                public void run() {
                    zzo.zzbH().zzb(zzdp.this);
                }
            });
        }
    }
}
