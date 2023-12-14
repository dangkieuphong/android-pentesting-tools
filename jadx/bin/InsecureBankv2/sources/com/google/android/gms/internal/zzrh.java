package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrh;
import java.io.IOException;

public abstract class zzrh<M extends zzrh<M>> extends zzrn {
    protected zzrj zzaVU;

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzrn
    public int zzB() {
        if (this.zzaVU == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzaVU.size(); i2++) {
            i += this.zzaVU.zzkS(i2).zzB();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final int zzBI() {
        if (this.zzaVU == null || this.zzaVU.isEmpty()) {
            return 0;
        }
        return this.zzaVU.hashCode();
    }

    /* renamed from: zzBJ */
    public M zzBK() throws CloneNotSupportedException {
        M m = (M) ((zzrh) super.clone());
        zzrl.zza(this, m);
        return m;
    }

    public final <T> T zza(zzri<M, T> zzri) {
        zzrk zzkR;
        if (this.zzaVU == null || (zzkR = this.zzaVU.zzkR(zzrq.zzkV(zzri.tag))) == null) {
            return null;
        }
        return (T) zzkR.zzb(zzri);
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrg) throws IOException {
        if (this.zzaVU != null) {
            for (int i = 0; i < this.zzaVU.size(); i++) {
                this.zzaVU.zzkS(i).zza(zzrg);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzrf zzrf, int i) throws IOException {
        int position = zzrf.getPosition();
        if (!zzrf.zzkA(i)) {
            return false;
        }
        int zzkV = zzrq.zzkV(i);
        zzrp zzrp = new zzrp(i, zzrf.zzx(position, zzrf.getPosition() - position));
        zzrk zzrk = null;
        if (this.zzaVU == null) {
            this.zzaVU = new zzrj();
        } else {
            zzrk = this.zzaVU.zzkR(zzkV);
        }
        if (zzrk == null) {
            zzrk = new zzrk();
            this.zzaVU.zza(zzkV, zzrk);
        }
        zzrk.zza(zzrp);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(M m) {
        return (this.zzaVU == null || this.zzaVU.isEmpty()) ? m.zzaVU == null || m.zzaVU.isEmpty() : this.zzaVU.equals(m.zzaVU);
    }
}
