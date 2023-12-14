package com.google.android.gms.internal;

import java.io.IOException;

public interface zzag {

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zziQ;
        public int type;
        public String zziR;
        public zza[] zziS;
        public zza[] zziT;
        public zza[] zziU;
        public String zziV;
        public String zziW;
        public long zziX;
        public boolean zziY;
        public zza[] zziZ;
        public int[] zzja;
        public boolean zzjb;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziQ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziQ == null) {
                        zziQ = new zza[0];
                    }
                }
            }
            return zziQ;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.type != zza.type) {
                return false;
            }
            if (this.zziR == null) {
                if (zza.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zza.zziR)) {
                return false;
            }
            if (!zzrl.equals(this.zziS, zza.zziS) || !zzrl.equals(this.zziT, zza.zziT) || !zzrl.equals(this.zziU, zza.zziU)) {
                return false;
            }
            if (this.zziV == null) {
                if (zza.zziV != null) {
                    return false;
                }
            } else if (!this.zziV.equals(zza.zziV)) {
                return false;
            }
            if (this.zziW == null) {
                if (zza.zziW != null) {
                    return false;
                }
            } else if (!this.zziW.equals(zza.zziW)) {
                return false;
            }
            if (this.zziX == zza.zziX && this.zziY == zza.zziY && zzrl.equals(this.zziZ, zza.zziZ) && zzrl.equals(this.zzja, zza.zzja) && this.zzjb == zza.zzjb) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((this.zziV == null ? 0 : this.zziV.hashCode()) + (((((((((this.zziR == null ? 0 : this.zziR.hashCode()) + ((this.type + 527) * 31)) * 31) + zzrl.hashCode(this.zziS)) * 31) + zzrl.hashCode(this.zziT)) * 31) + zzrl.hashCode(this.zziU)) * 31)) * 31;
            if (this.zziW != null) {
                i2 = this.zziW.hashCode();
            }
            int hashCode2 = ((((((this.zziY ? 1231 : 1237) + ((((hashCode + i2) * 31) + ((int) (this.zziX ^ (this.zziX >>> 32)))) * 31)) * 31) + zzrl.hashCode(this.zziZ)) * 31) + zzrl.hashCode(this.zzja)) * 31;
            if (!this.zzjb) {
                i = 1237;
            }
            return ((hashCode2 + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB() + zzrg.zzA(1, this.type);
            if (!this.zziR.equals("")) {
                zzB += zzrg.zzk(2, this.zziR);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                int i = zzB;
                for (int i2 = 0; i2 < this.zziS.length; i2++) {
                    zza zza = this.zziS[i2];
                    if (zza != null) {
                        i += zzrg.zzc(3, zza);
                    }
                }
                zzB = i;
            }
            if (this.zziT != null && this.zziT.length > 0) {
                int i3 = zzB;
                for (int i4 = 0; i4 < this.zziT.length; i4++) {
                    zza zza2 = this.zziT[i4];
                    if (zza2 != null) {
                        i3 += zzrg.zzc(4, zza2);
                    }
                }
                zzB = i3;
            }
            if (this.zziU != null && this.zziU.length > 0) {
                int i5 = zzB;
                for (int i6 = 0; i6 < this.zziU.length; i6++) {
                    zza zza3 = this.zziU[i6];
                    if (zza3 != null) {
                        i5 += zzrg.zzc(5, zza3);
                    }
                }
                zzB = i5;
            }
            if (!this.zziV.equals("")) {
                zzB += zzrg.zzk(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                zzB += zzrg.zzk(7, this.zziW);
            }
            if (this.zziX != 0) {
                zzB += zzrg.zzd(8, this.zziX);
            }
            if (this.zzjb) {
                zzB += zzrg.zzc(9, this.zzjb);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < this.zzja.length; i8++) {
                    i7 += zzrg.zzkJ(this.zzja[i8]);
                }
                zzB = zzB + i7 + (this.zzja.length * 1);
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int i9 = 0; i9 < this.zziZ.length; i9++) {
                    zza zza4 = this.zziZ[i9];
                    if (zza4 != null) {
                        zzB += zzrg.zzc(11, zza4);
                    }
                }
            }
            return this.zziY ? zzB + zzrg.zzc(12, this.zziY) : zzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziR = "";
            this.zziS = zzQ();
            this.zziT = zzQ();
            this.zziU = zzQ();
            this.zziV = "";
            this.zziW = "";
            this.zziX = 0;
            this.zziY = false;
            this.zziZ = zzQ();
            this.zzja = zzrq.zzaWh;
            this.zzjb = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            zzrg.zzy(1, this.type);
            if (!this.zziR.equals("")) {
                zzrg.zzb(2, this.zziR);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                for (int i = 0; i < this.zziS.length; i++) {
                    zza zza = this.zziS[i];
                    if (zza != null) {
                        zzrg.zza(3, zza);
                    }
                }
            }
            if (this.zziT != null && this.zziT.length > 0) {
                for (int i2 = 0; i2 < this.zziT.length; i2++) {
                    zza zza2 = this.zziT[i2];
                    if (zza2 != null) {
                        zzrg.zza(4, zza2);
                    }
                }
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (int i3 = 0; i3 < this.zziU.length; i3++) {
                    zza zza3 = this.zziU[i3];
                    if (zza3 != null) {
                        zzrg.zza(5, zza3);
                    }
                }
            }
            if (!this.zziV.equals("")) {
                zzrg.zzb(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                zzrg.zzb(7, this.zziW);
            }
            if (this.zziX != 0) {
                zzrg.zzb(8, this.zziX);
            }
            if (this.zzjb) {
                zzrg.zzb(9, this.zzjb);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                for (int i4 = 0; i4 < this.zzja.length; i4++) {
                    zzrg.zzy(10, this.zzja[i4]);
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int i5 = 0; i5 < this.zziZ.length; i5++) {
                    zza zza4 = this.zziZ[i5];
                    if (zza4 != null) {
                        zzrg.zza(11, zza4);
                    }
                }
            }
            if (this.zziY) {
                zzrg.zzb(12, this.zziY);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzl */
        public zza zzb(zzrf zzrf) throws IOException {
            int i;
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
                                this.type = zzBu;
                                continue;
                        }
                    case 18:
                        this.zziR = zzrf.readString();
                        break;
                    case 26:
                        int zzb = zzrq.zzb(zzrf, 26);
                        int length = this.zziS == null ? 0 : this.zziS.length;
                        zza[] zzaArr = new zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziS, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zza();
                            zzrf.zza(zzaArr[length]);
                            zzrf.zzBr();
                            length++;
                        }
                        zzaArr[length] = new zza();
                        zzrf.zza(zzaArr[length]);
                        this.zziS = zzaArr;
                        break;
                    case 34:
                        int zzb2 = zzrq.zzb(zzrf, 34);
                        int length2 = this.zziT == null ? 0 : this.zziT.length;
                        zza[] zzaArr2 = new zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziT, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zza();
                            zzrf.zza(zzaArr2[length2]);
                            zzrf.zzBr();
                            length2++;
                        }
                        zzaArr2[length2] = new zza();
                        zzrf.zza(zzaArr2[length2]);
                        this.zziT = zzaArr2;
                        break;
                    case 42:
                        int zzb3 = zzrq.zzb(zzrf, 42);
                        int length3 = this.zziU == null ? 0 : this.zziU.length;
                        zza[] zzaArr3 = new zza[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziU, 0, zzaArr3, 0, length3);
                        }
                        while (length3 < zzaArr3.length - 1) {
                            zzaArr3[length3] = new zza();
                            zzrf.zza(zzaArr3[length3]);
                            zzrf.zzBr();
                            length3++;
                        }
                        zzaArr3[length3] = new zza();
                        zzrf.zza(zzaArr3[length3]);
                        this.zziU = zzaArr3;
                        break;
                    case 50:
                        this.zziV = zzrf.readString();
                        break;
                    case 58:
                        this.zziW = zzrf.readString();
                        break;
                    case 64:
                        this.zziX = zzrf.zzBt();
                        break;
                    case 72:
                        this.zzjb = zzrf.zzBv();
                        break;
                    case 80:
                        int zzb4 = zzrq.zzb(zzrf, 80);
                        int[] iArr = new int[zzb4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < zzb4) {
                            if (i2 != 0) {
                                zzrf.zzBr();
                            }
                            int zzBu2 = zzrf.zzBu();
                            switch (zzBu2) {
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
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = zzBu2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.zzja == null ? 0 : this.zzja.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzja, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.zzja = iArr2;
                                break;
                            } else {
                                this.zzja = iArr;
                                break;
                            }
                        } else {
                            break;
                        }
                    case 82:
                        int zzkC = zzrf.zzkC(zzrf.zzBy());
                        int position = zzrf.getPosition();
                        int i4 = 0;
                        while (zzrf.zzBD() > 0) {
                            switch (zzrf.zzBu()) {
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
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            zzrf.zzkE(position);
                            int length5 = this.zzja == null ? 0 : this.zzja.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.zzja, 0, iArr3, 0, length5);
                            }
                            while (zzrf.zzBD() > 0) {
                                int zzBu3 = zzrf.zzBu();
                                switch (zzBu3) {
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
                                    case 16:
                                    case 17:
                                        iArr3[length5] = zzBu3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzja = iArr3;
                        }
                        zzrf.zzkD(zzkC);
                        break;
                    case 90:
                        int zzb5 = zzrq.zzb(zzrf, 90);
                        int length6 = this.zziZ == null ? 0 : this.zziZ.length;
                        zza[] zzaArr4 = new zza[(zzb5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziZ, 0, zzaArr4, 0, length6);
                        }
                        while (length6 < zzaArr4.length - 1) {
                            zzaArr4[length6] = new zza();
                            zzrf.zza(zzaArr4[length6]);
                            zzrf.zzBr();
                            length6++;
                        }
                        zzaArr4[length6] = new zza();
                        zzrf.zza(zzaArr4[length6]);
                        this.zziZ = zzaArr4;
                        break;
                    case 96:
                        this.zziY = zzrf.zzBv();
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
}
