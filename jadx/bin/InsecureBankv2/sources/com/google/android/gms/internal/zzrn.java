package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzrn {
    protected volatile int zzaWf = -1;

    public static final <T extends zzrn> T zza(T t, byte[] bArr) throws zzrm {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzrn zzrn, byte[] bArr, int i, int i2) {
        try {
            zzrg zzb = zzrg.zzb(bArr, i, i2);
            zzrn.zza(zzb);
            zzb.zzBH();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzrn> T zzb(T t, byte[] bArr, int i, int i2) throws zzrm {
        try {
            zzrf zza = zzrf.zza(bArr, i, i2);
            t.zzb(zza);
            zza.zzkz(0);
            return t;
        } catch (zzrm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzrn zzrn) {
        byte[] bArr = new byte[zzrn.zzBV()];
        zza(zzrn, bArr, 0, bArr.length);
        return bArr;
    }

    public String toString() {
        return zzro.zzg(this);
    }

    /* access modifiers changed from: protected */
    public int zzB() {
        return 0;
    }

    /* renamed from: zzBK */
    public zzrn clone() throws CloneNotSupportedException {
        return (zzrn) super.clone();
    }

    public int zzBU() {
        if (this.zzaWf < 0) {
            zzBV();
        }
        return this.zzaWf;
    }

    public int zzBV() {
        int zzB = zzB();
        this.zzaWf = zzB;
        return zzB;
    }

    public void zza(zzrg zzrg) throws IOException {
    }

    public abstract zzrn zzb(zzrf zzrf) throws IOException;
}
