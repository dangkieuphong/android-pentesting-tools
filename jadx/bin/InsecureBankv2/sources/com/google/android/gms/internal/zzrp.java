package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class zzrp {
    final int tag;
    final byte[] zzaWg;

    zzrp(int i, byte[] bArr) {
        this.tag = i;
        this.zzaWg = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrp)) {
            return false;
        }
        zzrp zzrp = (zzrp) o;
        return this.tag == zzrp.tag && Arrays.equals(this.zzaWg, zzrp.zzaWg);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzaWg);
    }

    /* access modifiers changed from: package-private */
    public int zzB() {
        return 0 + zzrg.zzkO(this.tag) + this.zzaWg.length;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzrg zzrg) throws IOException {
        zzrg.zzkN(this.tag);
        zzrg.zzD(this.zzaWg);
    }
}
