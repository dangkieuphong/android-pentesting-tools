package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzrc extends zzrh<zzrc> {
    public zza[] zzaVl;

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zzaVm;
        public String name;
        public C0149zza zzaVn;

        /* renamed from: com.google.android.gms.internal.zzrc$zza$zza  reason: collision with other inner class name */
        public static final class C0149zza extends zzrh<C0149zza> {
            private static volatile C0149zza[] zzaVo;
            public int type;
            public C0150zza zzaVp;

            /* renamed from: com.google.android.gms.internal.zzrc$zza$zza$zza  reason: collision with other inner class name */
            public static final class C0150zza extends zzrh<C0150zza> {
                public String[] zzaVA;
                public long[] zzaVB;
                public float[] zzaVC;
                public long zzaVD;
                public byte[] zzaVq;
                public String zzaVr;
                public double zzaVs;
                public float zzaVt;
                public long zzaVu;
                public int zzaVv;
                public int zzaVw;
                public boolean zzaVx;
                public zza[] zzaVy;
                public C0149zza[] zzaVz;

                public C0150zza() {
                    zzBp();
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof C0150zza)) {
                        return false;
                    }
                    C0150zza zza = (C0150zza) o;
                    if (!Arrays.equals(this.zzaVq, zza.zzaVq)) {
                        return false;
                    }
                    if (this.zzaVr == null) {
                        if (zza.zzaVr != null) {
                            return false;
                        }
                    } else if (!this.zzaVr.equals(zza.zzaVr)) {
                        return false;
                    }
                    if (Double.doubleToLongBits(this.zzaVs) == Double.doubleToLongBits(zza.zzaVs) && Float.floatToIntBits(this.zzaVt) == Float.floatToIntBits(zza.zzaVt) && this.zzaVu == zza.zzaVu && this.zzaVv == zza.zzaVv && this.zzaVw == zza.zzaVw && this.zzaVx == zza.zzaVx && zzrl.equals(this.zzaVy, zza.zzaVy) && zzrl.equals(this.zzaVz, zza.zzaVz) && zzrl.equals(this.zzaVA, zza.zzaVA) && zzrl.equals(this.zzaVB, zza.zzaVB) && zzrl.equals(this.zzaVC, zza.zzaVC) && this.zzaVD == zza.zzaVD) {
                        return zza(zza);
                    }
                    return false;
                }

                public int hashCode() {
                    int hashCode = (Arrays.hashCode(this.zzaVq) + 527) * 31;
                    int hashCode2 = this.zzaVr == null ? 0 : this.zzaVr.hashCode();
                    long doubleToLongBits = Double.doubleToLongBits(this.zzaVs);
                    return (((((((((((((((this.zzaVx ? 1231 : 1237) + ((((((((((((hashCode2 + hashCode) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzaVt)) * 31) + ((int) (this.zzaVu ^ (this.zzaVu >>> 32)))) * 31) + this.zzaVv) * 31) + this.zzaVw) * 31)) * 31) + zzrl.hashCode(this.zzaVy)) * 31) + zzrl.hashCode(this.zzaVz)) * 31) + zzrl.hashCode(this.zzaVA)) * 31) + zzrl.hashCode(this.zzaVB)) * 31) + zzrl.hashCode(this.zzaVC)) * 31) + ((int) (this.zzaVD ^ (this.zzaVD >>> 32)))) * 31) + zzBI();
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
                public int zzB() {
                    int zzB = super.zzB();
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        zzB += zzrg.zzb(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        zzB += zzrg.zzk(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        zzB += zzrg.zzb(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        zzB += zzrg.zzc(4, this.zzaVt);
                    }
                    if (this.zzaVu != 0) {
                        zzB += zzrg.zzd(5, this.zzaVu);
                    }
                    if (this.zzaVv != 0) {
                        zzB += zzrg.zzA(6, this.zzaVv);
                    }
                    if (this.zzaVw != 0) {
                        zzB += zzrg.zzB(7, this.zzaVw);
                    }
                    if (this.zzaVx) {
                        zzB += zzrg.zzc(8, this.zzaVx);
                    }
                    if (this.zzaVy != null && this.zzaVy.length > 0) {
                        int i = zzB;
                        for (int i2 = 0; i2 < this.zzaVy.length; i2++) {
                            zza zza = this.zzaVy[i2];
                            if (zza != null) {
                                i += zzrg.zzc(9, zza);
                            }
                        }
                        zzB = i;
                    }
                    if (this.zzaVz != null && this.zzaVz.length > 0) {
                        int i3 = zzB;
                        for (int i4 = 0; i4 < this.zzaVz.length; i4++) {
                            C0149zza zza2 = this.zzaVz[i4];
                            if (zza2 != null) {
                                i3 += zzrg.zzc(10, zza2);
                            }
                        }
                        zzB = i3;
                    }
                    if (this.zzaVA != null && this.zzaVA.length > 0) {
                        int i5 = 0;
                        int i6 = 0;
                        for (int i7 = 0; i7 < this.zzaVA.length; i7++) {
                            String str = this.zzaVA[i7];
                            if (str != null) {
                                i6++;
                                i5 += zzrg.zzfj(str);
                            }
                        }
                        zzB = zzB + i5 + (i6 * 1);
                    }
                    if (this.zzaVB != null && this.zzaVB.length > 0) {
                        int i8 = 0;
                        for (int i9 = 0; i9 < this.zzaVB.length; i9++) {
                            i8 += zzrg.zzY(this.zzaVB[i9]);
                        }
                        zzB = zzB + i8 + (this.zzaVB.length * 1);
                    }
                    if (this.zzaVD != 0) {
                        zzB += zzrg.zzd(13, this.zzaVD);
                    }
                    return (this.zzaVC == null || this.zzaVC.length <= 0) ? zzB : zzB + (this.zzaVC.length * 4) + (this.zzaVC.length * 1);
                }

                public C0150zza zzBp() {
                    this.zzaVq = zzrq.zzaWo;
                    this.zzaVr = "";
                    this.zzaVs = 0.0d;
                    this.zzaVt = 0.0f;
                    this.zzaVu = 0;
                    this.zzaVv = 0;
                    this.zzaVw = 0;
                    this.zzaVx = false;
                    this.zzaVy = zza.zzBl();
                    this.zzaVz = C0149zza.zzBn();
                    this.zzaVA = zzrq.zzaWm;
                    this.zzaVB = zzrq.zzaWi;
                    this.zzaVC = zzrq.zzaWj;
                    this.zzaVD = 0;
                    this.zzaVU = null;
                    this.zzaWf = -1;
                    return this;
                }

                @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
                public void zza(zzrg zzrg) throws IOException {
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        zzrg.zza(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        zzrg.zzb(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        zzrg.zza(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        zzrg.zzb(4, this.zzaVt);
                    }
                    if (this.zzaVu != 0) {
                        zzrg.zzb(5, this.zzaVu);
                    }
                    if (this.zzaVv != 0) {
                        zzrg.zzy(6, this.zzaVv);
                    }
                    if (this.zzaVw != 0) {
                        zzrg.zzz(7, this.zzaVw);
                    }
                    if (this.zzaVx) {
                        zzrg.zzb(8, this.zzaVx);
                    }
                    if (this.zzaVy != null && this.zzaVy.length > 0) {
                        for (int i = 0; i < this.zzaVy.length; i++) {
                            zza zza = this.zzaVy[i];
                            if (zza != null) {
                                zzrg.zza(9, zza);
                            }
                        }
                    }
                    if (this.zzaVz != null && this.zzaVz.length > 0) {
                        for (int i2 = 0; i2 < this.zzaVz.length; i2++) {
                            C0149zza zza2 = this.zzaVz[i2];
                            if (zza2 != null) {
                                zzrg.zza(10, zza2);
                            }
                        }
                    }
                    if (this.zzaVA != null && this.zzaVA.length > 0) {
                        for (int i3 = 0; i3 < this.zzaVA.length; i3++) {
                            String str = this.zzaVA[i3];
                            if (str != null) {
                                zzrg.zzb(11, str);
                            }
                        }
                    }
                    if (this.zzaVB != null && this.zzaVB.length > 0) {
                        for (int i4 = 0; i4 < this.zzaVB.length; i4++) {
                            zzrg.zzb(12, this.zzaVB[i4]);
                        }
                    }
                    if (this.zzaVD != 0) {
                        zzrg.zzb(13, this.zzaVD);
                    }
                    if (this.zzaVC != null && this.zzaVC.length > 0) {
                        for (int i5 = 0; i5 < this.zzaVC.length; i5++) {
                            zzrg.zzb(14, this.zzaVC[i5]);
                        }
                    }
                    super.zza(zzrg);
                }

                /* renamed from: zzy */
                public C0150zza zzb(zzrf zzrf) throws IOException {
                    while (true) {
                        int zzBr = zzrf.zzBr();
                        switch (zzBr) {
                            case 0:
                                break;
                            case 10:
                                this.zzaVq = zzrf.readBytes();
                                break;
                            case 18:
                                this.zzaVr = zzrf.readString();
                                break;
                            case 25:
                                this.zzaVs = zzrf.readDouble();
                                break;
                            case 37:
                                this.zzaVt = zzrf.readFloat();
                                break;
                            case 40:
                                this.zzaVu = zzrf.zzBt();
                                break;
                            case 48:
                                this.zzaVv = zzrf.zzBu();
                                break;
                            case 56:
                                this.zzaVw = zzrf.zzBw();
                                break;
                            case 64:
                                this.zzaVx = zzrf.zzBv();
                                break;
                            case 74:
                                int zzb = zzrq.zzb(zzrf, 74);
                                int length = this.zzaVy == null ? 0 : this.zzaVy.length;
                                zza[] zzaArr = new zza[(zzb + length)];
                                if (length != 0) {
                                    System.arraycopy(this.zzaVy, 0, zzaArr, 0, length);
                                }
                                while (length < zzaArr.length - 1) {
                                    zzaArr[length] = new zza();
                                    zzrf.zza(zzaArr[length]);
                                    zzrf.zzBr();
                                    length++;
                                }
                                zzaArr[length] = new zza();
                                zzrf.zza(zzaArr[length]);
                                this.zzaVy = zzaArr;
                                break;
                            case 82:
                                int zzb2 = zzrq.zzb(zzrf, 82);
                                int length2 = this.zzaVz == null ? 0 : this.zzaVz.length;
                                C0149zza[] zzaArr2 = new C0149zza[(zzb2 + length2)];
                                if (length2 != 0) {
                                    System.arraycopy(this.zzaVz, 0, zzaArr2, 0, length2);
                                }
                                while (length2 < zzaArr2.length - 1) {
                                    zzaArr2[length2] = new C0149zza();
                                    zzrf.zza(zzaArr2[length2]);
                                    zzrf.zzBr();
                                    length2++;
                                }
                                zzaArr2[length2] = new C0149zza();
                                zzrf.zza(zzaArr2[length2]);
                                this.zzaVz = zzaArr2;
                                break;
                            case 90:
                                int zzb3 = zzrq.zzb(zzrf, 90);
                                int length3 = this.zzaVA == null ? 0 : this.zzaVA.length;
                                String[] strArr = new String[(zzb3 + length3)];
                                if (length3 != 0) {
                                    System.arraycopy(this.zzaVA, 0, strArr, 0, length3);
                                }
                                while (length3 < strArr.length - 1) {
                                    strArr[length3] = zzrf.readString();
                                    zzrf.zzBr();
                                    length3++;
                                }
                                strArr[length3] = zzrf.readString();
                                this.zzaVA = strArr;
                                break;
                            case 96:
                                int zzb4 = zzrq.zzb(zzrf, 96);
                                int length4 = this.zzaVB == null ? 0 : this.zzaVB.length;
                                long[] jArr = new long[(zzb4 + length4)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzaVB, 0, jArr, 0, length4);
                                }
                                while (length4 < jArr.length - 1) {
                                    jArr[length4] = zzrf.zzBt();
                                    zzrf.zzBr();
                                    length4++;
                                }
                                jArr[length4] = zzrf.zzBt();
                                this.zzaVB = jArr;
                                break;
                            case 98:
                                int zzkC = zzrf.zzkC(zzrf.zzBy());
                                int position = zzrf.getPosition();
                                int i = 0;
                                while (zzrf.zzBD() > 0) {
                                    zzrf.zzBt();
                                    i++;
                                }
                                zzrf.zzkE(position);
                                int length5 = this.zzaVB == null ? 0 : this.zzaVB.length;
                                long[] jArr2 = new long[(i + length5)];
                                if (length5 != 0) {
                                    System.arraycopy(this.zzaVB, 0, jArr2, 0, length5);
                                }
                                while (length5 < jArr2.length) {
                                    jArr2[length5] = zzrf.zzBt();
                                    length5++;
                                }
                                this.zzaVB = jArr2;
                                zzrf.zzkD(zzkC);
                                break;
                            case 104:
                                this.zzaVD = zzrf.zzBt();
                                break;
                            case 114:
                                int zzBy = zzrf.zzBy();
                                int zzkC2 = zzrf.zzkC(zzBy);
                                int i2 = zzBy / 4;
                                int length6 = this.zzaVC == null ? 0 : this.zzaVC.length;
                                float[] fArr = new float[(i2 + length6)];
                                if (length6 != 0) {
                                    System.arraycopy(this.zzaVC, 0, fArr, 0, length6);
                                }
                                while (length6 < fArr.length) {
                                    fArr[length6] = zzrf.readFloat();
                                    length6++;
                                }
                                this.zzaVC = fArr;
                                zzrf.zzkD(zzkC2);
                                break;
                            case 117:
                                int zzb5 = zzrq.zzb(zzrf, 117);
                                int length7 = this.zzaVC == null ? 0 : this.zzaVC.length;
                                float[] fArr2 = new float[(zzb5 + length7)];
                                if (length7 != 0) {
                                    System.arraycopy(this.zzaVC, 0, fArr2, 0, length7);
                                }
                                while (length7 < fArr2.length - 1) {
                                    fArr2[length7] = zzrf.readFloat();
                                    zzrf.zzBr();
                                    length7++;
                                }
                                fArr2[length7] = zzrf.readFloat();
                                this.zzaVC = fArr2;
                                break;
                            default:
                                if (zza(zzrf, zzBr)) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }
            }

            public C0149zza() {
                zzBo();
            }

            public static C0149zza[] zzBn() {
                if (zzaVo == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzaVo == null) {
                            zzaVo = new C0149zza[0];
                        }
                    }
                }
                return zzaVo;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C0149zza)) {
                    return false;
                }
                C0149zza zza = (C0149zza) o;
                if (this.type != zza.type) {
                    return false;
                }
                if (this.zzaVp == null) {
                    if (zza.zzaVp != null) {
                        return false;
                    }
                } else if (!this.zzaVp.equals(zza.zzaVp)) {
                    return false;
                }
                return zza(zza);
            }

            public int hashCode() {
                return (((this.zzaVp == null ? 0 : this.zzaVp.hashCode()) + ((this.type + 527) * 31)) * 31) + zzBI();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public int zzB() {
                int zzB = super.zzB() + zzrg.zzA(1, this.type);
                return this.zzaVp != null ? zzB + zzrg.zzc(2, this.zzaVp) : zzB;
            }

            public C0149zza zzBo() {
                this.type = 1;
                this.zzaVp = null;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrg) throws IOException {
                zzrg.zzy(1, this.type);
                if (this.zzaVp != null) {
                    zzrg.zza(2, this.zzaVp);
                }
                super.zza(zzrg);
            }

            /* renamed from: zzx */
            public C0149zza zzb(zzrf zzrf) throws IOException {
                while (true) {
                    int zzBr = zzrf.zzBr();
                    switch (zzBr) {
                        case 0:
                            break;
                        case 8:
                            int zzBu = zzrf.zzBu();
                            switch (zzBu) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = zzBu;
                                    continue;
                            }
                        case 18:
                            if (this.zzaVp == null) {
                                this.zzaVp = new C0150zza();
                            }
                            zzrf.zza(this.zzaVp);
                            break;
                        default:
                            if (zza(zzrf, zzBr)) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }
        }

        public zza() {
            zzBm();
        }

        public static zza[] zzBl() {
            if (zzaVm == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzaVm == null) {
                        zzaVm = new zza[0];
                    }
                }
            }
            return zzaVm;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.zzaVn == null) {
                if (zza.zzaVn != null) {
                    return false;
                }
            } else if (!this.zzaVn.equals(zza.zzaVn)) {
                return false;
            }
            return zza(zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzaVn != null) {
                i = this.zzaVn.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB() + zzrg.zzk(1, this.name);
            return this.zzaVn != null ? zzB + zzrg.zzc(2, this.zzaVn) : zzB;
        }

        public zza zzBm() {
            this.name = "";
            this.zzaVn = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            zzrg.zzb(1, this.name);
            if (this.zzaVn != null) {
                zzrg.zza(2, this.zzaVn);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzw */
        public zza zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrf.readString();
                        break;
                    case 18:
                        if (this.zzaVn == null) {
                            this.zzaVn = new C0149zza();
                        }
                        zzrf.zza(this.zzaVn);
                        break;
                    default:
                        if (zza(zzrf, zzBr)) {
                            break;
                        } else {
                            break;
                        }
                }
            }
            return this;
        }
    }

    public zzrc() {
        zzBk();
    }

    public static zzrc zzw(byte[] bArr) throws zzrm {
        return (zzrc) zzrn.zza(new zzrc(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrc)) {
            return false;
        }
        zzrc zzrc = (zzrc) o;
        if (zzrl.equals(this.zzaVl, zzrc.zzaVl)) {
            return zza(zzrc);
        }
        return false;
    }

    public int hashCode() {
        return ((zzrl.hashCode(this.zzaVl) + 527) * 31) + zzBI();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public int zzB() {
        int zzB = super.zzB();
        if (this.zzaVl != null && this.zzaVl.length > 0) {
            for (int i = 0; i < this.zzaVl.length; i++) {
                zza zza2 = this.zzaVl[i];
                if (zza2 != null) {
                    zzB += zzrg.zzc(1, zza2);
                }
            }
        }
        return zzB;
    }

    public zzrc zzBk() {
        this.zzaVl = zza.zzBl();
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrg) throws IOException {
        if (this.zzaVl != null && this.zzaVl.length > 0) {
            for (int i = 0; i < this.zzaVl.length; i++) {
                zza zza2 = this.zzaVl[i];
                if (zza2 != null) {
                    zzrg.zza(1, zza2);
                }
            }
        }
        super.zza(zzrg);
    }

    /* renamed from: zzv */
    public zzrc zzb(zzrf zzrf) throws IOException {
        while (true) {
            int zzBr = zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 10:
                    int zzb = zzrq.zzb(zzrf, 10);
                    int length = this.zzaVl == null ? 0 : this.zzaVl.length;
                    zza[] zzaArr = new zza[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzaVl, 0, zzaArr, 0, length);
                    }
                    while (length < zzaArr.length - 1) {
                        zzaArr[length] = new zza();
                        zzrf.zza(zzaArr[length]);
                        zzrf.zzBr();
                        length++;
                    }
                    zzaArr[length] = new zza();
                    zzrf.zza(zzaArr[length]);
                    this.zzaVl = zzaArr;
                    break;
                default:
                    if (zza(zzrf, zzBr)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }
}
