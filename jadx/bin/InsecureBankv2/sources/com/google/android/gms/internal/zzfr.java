package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzfr extends zzfp {
    zzfr(Context context, zzha.zza zza, zzid zzid, zzft.zza zza2) {
        super(context, zza, zzid, zza2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfs
    public void zzh(long j) throws zzfs.zza {
        int i;
        int i2;
        AdSizeParcel zzaN = this.zzoA.zzaN();
        if (zzaN.zzsn) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = zzaN.widthPixels;
            i2 = zzaN.heightPixels;
        }
        final zzfq zzfq = new zzfq(this, this.zzoA, i, i2);
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.internal.zzfr.AnonymousClass1 */

            public void run() {
                synchronized (zzfr.this.zzqt) {
                    if (zzfr.this.zzBt.errorCode == -2) {
                        zzfr.this.zzoA.zzgF().zza(zzfr.this);
                        zzfq.zza(zzfr.this.zzBt);
                    }
                }
            }
        });
        zzg(j);
        if (zzfq.zzfl()) {
            zzb.zzay("Ad-Network indicated no fill with passback URL.");
            throw new zzfs.zza("AdNetwork sent passback url", 3);
        } else if (!zzfq.zzfm()) {
            throw new zzfs.zza("AdNetwork timed out", 2);
        }
    }
}
