package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzfu extends zzfp {
    zzfu(Context context, zzha.zza zza, zzid zzid, zzft.zza zza2) {
        super(context, zza, zzid, zza2);
    }

    /* access modifiers changed from: protected */
    public void zzfn() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfs
    public void zzh(long j) throws zzfs.zza {
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.internal.zzfu.AnonymousClass1 */

            public void run() {
                synchronized (zzfu.this.zzqt) {
                    if (zzfu.this.zzBt.errorCode == -2) {
                        zzfu.this.zzoA.zzgF().zza(zzfu.this);
                        zzfu.this.zzfn();
                        zzb.zzaB("Loading HTML in WebView.");
                        zzfu.this.zzoA.loadDataWithBaseURL(zzo.zzbv().zzat(zzfu.this.zzBt.zzzG), zzfu.this.zzBt.zzCI, "text/html", "UTF-8", null);
                    }
                }
            }
        });
        zzg(j);
    }
}
