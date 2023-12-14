package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.internal.zzaq;

public final class zzq extends zzaq.zza {
    private zzj zzaTY;
    private zzr zzaUc;
    private final Object zzqt = new Object();

    public void zza(zzr zzr) {
        zzj zzj;
        synchronized (this.zzqt) {
            this.zzaUc = (zzr) zzu.zzu(zzr);
            zzj = this.zzaTY;
        }
        if (zzj != null) {
            zzr.zzb(zzj);
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaq
    public void zzw(int i, int i2) {
        zzr zzr;
        zzj zzj;
        synchronized (this.zzqt) {
            zzr = this.zzaUc;
            zzj = new zzj(i, i2);
            this.zzaTY = zzj;
        }
        if (zzr != null) {
            zzr.zzb(zzj);
        }
    }
}
