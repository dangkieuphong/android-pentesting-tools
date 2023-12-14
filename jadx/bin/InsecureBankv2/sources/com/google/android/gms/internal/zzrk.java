package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
public class zzrk implements Cloneable {
    private zzri<?, ?> zzaWb;
    private Object zzaWc;
    private List<zzrp> zzaWd = new ArrayList();

    zzrk() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzB()];
        zza(zzrg.zzA(bArr));
        return bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrk)) {
            return false;
        }
        zzrk zzrk = (zzrk) o;
        if (this.zzaWc == null || zzrk.zzaWc == null) {
            if (this.zzaWd != null && zzrk.zzaWd != null) {
                return this.zzaWd.equals(zzrk.zzaWd);
            }
            try {
                return Arrays.equals(toByteArray(), zzrk.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzaWb != zzrk.zzaWb) {
            return false;
        } else {
            if (!this.zzaWb.zzaVV.isArray()) {
                return this.zzaWc.equals(zzrk.zzaWc);
            }
            if (this.zzaWc instanceof byte[]) {
                return Arrays.equals((byte[]) this.zzaWc, (byte[]) zzrk.zzaWc);
            }
            if (this.zzaWc instanceof int[]) {
                return Arrays.equals((int[]) this.zzaWc, (int[]) zzrk.zzaWc);
            }
            if (this.zzaWc instanceof long[]) {
                return Arrays.equals((long[]) this.zzaWc, (long[]) zzrk.zzaWc);
            }
            if (this.zzaWc instanceof float[]) {
                return Arrays.equals((float[]) this.zzaWc, (float[]) zzrk.zzaWc);
            }
            if (this.zzaWc instanceof double[]) {
                return Arrays.equals((double[]) this.zzaWc, (double[]) zzrk.zzaWc);
            }
            return this.zzaWc instanceof boolean[] ? Arrays.equals((boolean[]) this.zzaWc, (boolean[]) zzrk.zzaWc) : Arrays.deepEquals((Object[]) this.zzaWc, (Object[]) zzrk.zzaWc);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzB() {
        int i = 0;
        if (this.zzaWc != null) {
            return this.zzaWb.zzQ(this.zzaWc);
        }
        for (zzrp zzrp : this.zzaWd) {
            i = zzrp.zzB() + i;
        }
        return i;
    }

    /* renamed from: zzBM */
    public final zzrk clone() {
        int i = 0;
        zzrk zzrk = new zzrk();
        try {
            zzrk.zzaWb = this.zzaWb;
            if (this.zzaWd == null) {
                zzrk.zzaWd = null;
            } else {
                zzrk.zzaWd.addAll(this.zzaWd);
            }
            if (this.zzaWc != null) {
                if (this.zzaWc instanceof zzrn) {
                    zzrk.zzaWc = ((zzrn) this.zzaWc).clone();
                } else if (this.zzaWc instanceof byte[]) {
                    zzrk.zzaWc = ((byte[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzaWc;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzrk.zzaWc = bArr2;
                    while (i < bArr.length) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                        i++;
                    }
                } else if (this.zzaWc instanceof boolean[]) {
                    zzrk.zzaWc = ((boolean[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof int[]) {
                    zzrk.zzaWc = ((int[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof long[]) {
                    zzrk.zzaWc = ((long[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof float[]) {
                    zzrk.zzaWc = ((float[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof double[]) {
                    zzrk.zzaWc = ((double[]) this.zzaWc).clone();
                } else if (this.zzaWc instanceof zzrn[]) {
                    zzrn[] zzrnArr = (zzrn[]) this.zzaWc;
                    zzrn[] zzrnArr2 = new zzrn[zzrnArr.length];
                    zzrk.zzaWc = zzrnArr2;
                    while (i < zzrnArr.length) {
                        zzrnArr2[i] = zzrnArr[i].clone();
                        i++;
                    }
                }
            }
            return zzrk;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzrg zzrg) throws IOException {
        if (this.zzaWc != null) {
            this.zzaWb.zza(this.zzaWc, zzrg);
            return;
        }
        for (zzrp zzrp : this.zzaWd) {
            zzrp.zza(zzrg);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzrp zzrp) {
        this.zzaWd.add(zzrp);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.internal.zzri<?, T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public <T> T zzb(zzri<?, T> zzri) {
        if (this.zzaWc == null) {
            this.zzaWb = zzri;
            this.zzaWc = zzri.zzx(this.zzaWd);
            this.zzaWd = null;
        } else if (this.zzaWb != zzri) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.zzaWc;
    }
}
