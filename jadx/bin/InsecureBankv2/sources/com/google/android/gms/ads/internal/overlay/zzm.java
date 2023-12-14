package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzhl;

/* access modifiers changed from: package-private */
public class zzm implements Runnable {
    private boolean zzAq = false;
    private zzh zzzl;

    zzm(zzh zzh) {
        this.zzzl = zzh;
    }

    public void cancel() {
        this.zzAq = true;
        zzhl.zzGk.removeCallbacks(this);
    }

    public void run() {
        if (!this.zzAq) {
            this.zzzl.zzeL();
            zzeY();
        }
    }

    public void zzeY() {
        zzhl.zzGk.postDelayed(this, 250);
    }
}
