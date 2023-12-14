package com.google.android.gms.internal;

/* access modifiers changed from: package-private */
public class zzrj implements Cloneable {
    private static final zzrk zzaVX = new zzrk();
    private int mSize;
    private boolean zzaVY;
    private int[] zzaVZ;
    private zzrk[] zzaWa;

    public zzrj() {
        this(10);
    }

    public zzrj(int i) {
        this.zzaVY = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzaVZ = new int[idealIntArraySize];
        this.zzaWa = new zzrk[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzaVZ;
        zzrk[] zzrkArr = this.zzaWa;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzrk zzrk = zzrkArr[i3];
            if (zzrk != zzaVX) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    zzrkArr[i2] = zzrk;
                    zzrkArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzaVY = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzrk[] zzrkArr, zzrk[] zzrkArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzrkArr[i2].equals(zzrkArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzkT(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzaVZ[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrj)) {
            return false;
        }
        zzrj zzrj = (zzrj) o;
        if (size() != zzrj.size()) {
            return false;
        }
        return zza(this.zzaVZ, zzrj.zzaVZ, this.mSize) && zza(this.zzaWa, zzrj.zzaWa, this.mSize);
    }

    public int hashCode() {
        if (this.zzaVY) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzaVZ[i2]) * 31) + this.zzaWa[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.zzaVY) {
            gc();
        }
        return this.mSize;
    }

    /* renamed from: zzBL */
    public final zzrj clone() {
        int size = size();
        zzrj zzrj = new zzrj(size);
        System.arraycopy(this.zzaVZ, 0, zzrj.zzaVZ, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.zzaWa[i] != null) {
                zzrj.zzaWa[i] = this.zzaWa[i].clone();
            }
        }
        zzrj.mSize = size;
        return zzrj;
    }

    public void zza(int i, zzrk zzrk) {
        int zzkT = zzkT(i);
        if (zzkT >= 0) {
            this.zzaWa[zzkT] = zzrk;
            return;
        }
        int i2 = zzkT ^ -1;
        if (i2 >= this.mSize || this.zzaWa[i2] != zzaVX) {
            if (this.zzaVY && this.mSize >= this.zzaVZ.length) {
                gc();
                i2 = zzkT(i) ^ -1;
            }
            if (this.mSize >= this.zzaVZ.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzrk[] zzrkArr = new zzrk[idealIntArraySize];
                System.arraycopy(this.zzaVZ, 0, iArr, 0, this.zzaVZ.length);
                System.arraycopy(this.zzaWa, 0, zzrkArr, 0, this.zzaWa.length);
                this.zzaVZ = iArr;
                this.zzaWa = zzrkArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzaVZ, i2, this.zzaVZ, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzaWa, i2, this.zzaWa, i2 + 1, this.mSize - i2);
            }
            this.zzaVZ[i2] = i;
            this.zzaWa[i2] = zzrk;
            this.mSize++;
            return;
        }
        this.zzaVZ[i2] = i;
        this.zzaWa[i2] = zzrk;
    }

    public zzrk zzkR(int i) {
        int zzkT = zzkT(i);
        if (zzkT < 0 || this.zzaWa[zzkT] == zzaVX) {
            return null;
        }
        return this.zzaWa[zzkT];
    }

    public zzrk zzkS(int i) {
        if (this.zzaVY) {
            gc();
        }
        return this.zzaWa[i];
    }
}
