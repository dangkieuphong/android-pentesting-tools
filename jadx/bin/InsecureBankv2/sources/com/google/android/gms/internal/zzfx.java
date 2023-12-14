package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
public class zzfx extends zzhh {
    private final zzfy zzBC;
    private Future<zzha> zzBD;
    private final zzft.zza zzBq;
    private final zzha.zza zzBs;
    private final AdResponseParcel zzBt;
    private final Object zzqt;

    public zzfx(Context context, zzm zzm, zzbc zzbc, zzha.zza zza, zzan zzan, zzft.zza zza2) {
        this(zza, zza2, new zzfy(context, zzm, zzbc, new zzho(context), zzan, zza));
    }

    zzfx(zzha.zza zza, zzft.zza zza2, zzfy zzfy) {
        this.zzqt = new Object();
        this.zzBs = zza;
        this.zzBt = zza.zzFs;
        this.zzBq = zza2;
        this.zzBC = zzfy;
    }

    private zzha zzA(int i) {
        return new zzha(this.zzBs.zzFr.zzCm, null, null, i, null, null, this.zzBt.orientation, this.zzBt.zzxJ, this.zzBs.zzFr.zzCp, false, null, null, null, null, null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzqt) {
            if (this.zzBD != null) {
                this.zzBD.cancel(true);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        final zzha zzha;
        int i;
        try {
            synchronized (this.zzqt) {
                this.zzBD = zzhk.zza(this.zzBC);
            }
            zzha = this.zzBD.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzb.zzaC("Timed out waiting for native ad.");
            this.zzBD.cancel(true);
            i = 2;
            zzha = null;
        } catch (ExecutionException e2) {
            i = 0;
            zzha = null;
        } catch (InterruptedException e3) {
            zzha = null;
            i = -1;
        } catch (CancellationException e4) {
            zzha = null;
            i = -1;
        }
        if (zzha == null) {
            zzha = zzA(i);
        }
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.internal.zzfx.AnonymousClass1 */

            public void run() {
                zzfx.this.zzBq.zzb(zzha);
            }
        });
    }
}
