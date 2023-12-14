package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzha;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzgd
public class zzgv extends zzhh implements zzgu {
    private final Context mContext;
    private final zzha.zza zzBs;
    private final String zzEO;
    private final ArrayList<Future> zzFe = new ArrayList<>();
    private final ArrayList<String> zzFf = new ArrayList<>();
    private final HashSet<String> zzFg = new HashSet<>();
    private final zzgo zzFh;
    private final Object zzqt = new Object();

    public zzgv(Context context, String str, zzha.zza zza, zzgo zzgo) {
        this.mContext = context;
        this.zzEO = str;
        this.zzBs = zza;
        this.zzFh = zzgo;
    }

    private void zzj(String str, String str2) {
        synchronized (this.zzqt) {
            zzgp zzao = this.zzFh.zzao(str);
            if (zzao != null && zzao.zzfN() != null && zzao.zzfM() != null) {
                this.zzFe.add(new zzgq(this.mContext, str, this.zzEO, str2, this.zzBs, zzao, this).zzgi());
                this.zzFf.add(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzgu
    public void zzap(String str) {
        synchronized (this.zzqt) {
            this.zzFg.add(str);
        }
    }

    @Override // com.google.android.gms.internal.zzgu
    public void zzb(String str, int i) {
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        for (zzdx zzdx : this.zzBs.zzFm.zzxD) {
            String str = zzdx.zzxz;
            for (String str2 : zzdx.zzxu) {
                zzj(str2, str);
            }
        }
        int i = 0;
        while (i < this.zzFe.size()) {
            try {
                this.zzFe.get(i).get();
                synchronized (this.zzqt) {
                    if (this.zzFg.contains(this.zzFf.get(i))) {
                        final zzha zzha = new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, -2, this.zzBs.zzFs.zzxG, this.zzBs.zzFs.zzCM, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, this.zzBs.zzFs.zzCK, this.zzBs.zzFm.zzxD.get(i), null, this.zzFf.get(i), this.zzBs.zzFm, null, this.zzBs.zzFs.zzCL, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFs.zzCO, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
                        zza.zzGF.post(new Runnable() {
                            /* class com.google.android.gms.internal.zzgv.AnonymousClass1 */

                            public void run() {
                                zzgv.this.zzFh.zzb(zzha);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        final zzha zzha2 = new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, 3, this.zzBs.zzFs.zzxG, this.zzBs.zzFs.zzCM, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, this.zzBs.zzFs.zzCK, null, null, null, this.zzBs.zzFm, null, this.zzBs.zzFs.zzCL, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFs.zzCO, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
        zza.zzGF.post(new Runnable() {
            /* class com.google.android.gms.internal.zzgv.AnonymousClass2 */

            public void run() {
                zzgv.this.zzFh.zzb(zzha2);
            }
        });
        return;
        i++;
    }
}
