package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlb;

/* access modifiers changed from: package-private */
public class zzaj {
    private long zzMC;
    private final zzlb zzpw;

    public zzaj(zzlb zzlb) {
        zzu.zzu(zzlb);
        this.zzpw = zzlb;
    }

    public zzaj(zzlb zzlb, long j) {
        zzu.zzu(zzlb);
        this.zzpw = zzlb;
        this.zzMC = j;
    }

    public void clear() {
        this.zzMC = 0;
    }

    public void start() {
        this.zzMC = this.zzpw.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzMC == 0 || this.zzpw.elapsedRealtime() - this.zzMC > j;
    }
}
