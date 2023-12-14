package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzQW = new zzl("RequestTracker");
    public static final Object zzVr = new Object();
    private long zzTM = -1;
    private long zzVo;
    private long zzVp = 0;
    private zzo zzVq;

    public zzp(long j) {
        this.zzVo = j;
    }

    private void zzmd() {
        this.zzTM = -1;
        this.zzVq = null;
        this.zzVp = 0;
    }

    public void clear() {
        synchronized (zzVr) {
            if (this.zzTM != -1) {
                zzmd();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzVr) {
            z = this.zzTM != -1 && this.zzTM == j;
        }
        return z;
    }

    public void zza(long j, zzo zzo) {
        zzo zzo2;
        long j2;
        synchronized (zzVr) {
            zzo2 = this.zzVq;
            j2 = this.zzTM;
            this.zzTM = j;
            this.zzVq = zzo;
            this.zzVp = SystemClock.elapsedRealtime();
        }
        if (zzo2 != null) {
            zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo zzo = null;
        synchronized (zzVr) {
            if (this.zzTM == -1 || this.zzTM != j) {
                z = false;
            } else {
                zzQW.zzb("request %d completed", Long.valueOf(this.zzTM));
                zzo = this.zzVq;
                zzmd();
            }
        }
        if (zzo != null) {
            zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzVr) {
            if (this.zzTM == -1 || j - this.zzVp < this.zzVo) {
                z = false;
                zzo = null;
            } else {
                zzQW.zzb("request %d timed out", Long.valueOf(this.zzTM));
                j2 = this.zzTM;
                zzo = this.zzVq;
                zzmd();
            }
        }
        if (zzo != null) {
            zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzme() {
        boolean z;
        synchronized (zzVr) {
            z = this.zzTM != -1;
        }
        return z;
    }
}
