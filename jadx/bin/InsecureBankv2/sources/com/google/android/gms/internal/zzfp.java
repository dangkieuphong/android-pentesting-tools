package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;

@zzgd
public abstract class zzfp extends zzfs implements zzie.zza {
    private final zzie zzBd;
    protected boolean zzBe = false;
    private boolean zzxo = false;

    protected zzfp(Context context, zzha.zza zza, zzid zzid, zzft.zza zza2) {
        super(context, zza, zzid, zza2);
        this.zzBd = zzid.zzgF();
    }

    private boolean zze(long j) throws zzfs.zza {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 1) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zzfs.zza("Ad request cancelled.", -1);
        }
    }

    @Override // com.google.android.gms.internal.zzhh, com.google.android.gms.internal.zzfs
    public void onStop() {
        synchronized (this.zzBr) {
            this.zzoA.stopLoading();
            zzo.zzbx().zza(this.zzoA.getWebView());
        }
    }

    @Override // com.google.android.gms.internal.zzie.zza
    public void zza(zzid zzid, boolean z) {
        boolean z2 = true;
        synchronized (this.zzqt) {
            zzb.zzay("WebView finished loading.");
            this.zzBe = true;
            if (z) {
                z2 = false;
            }
            this.zzxo = z2;
            this.zzqt.notify();
        }
    }

    /* access modifiers changed from: protected */
    public void zzg(long j) throws zzfs.zza {
        while (zze(j)) {
            if (this.zzxo) {
                throw new zzfs.zza("Received cancellation request from creative.", 0);
            } else if (this.zzBe) {
                return;
            }
        }
        throw new zzfs.zza("Timed out waiting for WebView to finish loading.", 2);
    }
}
