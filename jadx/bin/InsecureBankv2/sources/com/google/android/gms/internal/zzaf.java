package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzrh<zza> {
        public int level;
        public int zzhK;
        public int zzhL;

        public zza() {
            zzA();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.level == zza.level && this.zzhK == zza.zzhK && this.zzhL == zza.zzhL) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.zzhK) * 31) + this.zzhL) * 31) + zzBI();
        }

        public zza zzA() {
            this.level = 1;
            this.zzhK = 0;
            this.zzhL = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (this.level != 1) {
                zzB += zzrg.zzA(1, this.level);
            }
            if (this.zzhK != 0) {
                zzB += zzrg.zzA(2, this.zzhK);
            }
            return this.zzhL != 0 ? zzB + zzrg.zzA(3, this.zzhL) : zzB;
        }

        /* renamed from: zza */
        public zza zzb(zzrf zzrf) throws IOException {
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
                                this.level = zzBu;
                                continue;
                        }
                    case 16:
                        this.zzhK = zzrf.zzBu();
                        break;
                    case 24:
                        this.zzhL = zzrf.zzBu();
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

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.level != 1) {
                zzrg.zzy(1, this.level);
            }
            if (this.zzhK != 0) {
                zzrg.zzy(2, this.zzhK);
            }
            if (this.zzhL != 0) {
                zzrg.zzy(3, this.zzhL);
            }
            super.zza(zzrg);
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzhM;
        public int name;
        public int[] zzhN;
        public int zzhO;
        public boolean zzhP;
        public boolean zzhQ;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhM == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhM == null) {
                        zzhM = new zzb[0];
                    }
                }
            }
            return zzhM;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (zzrl.equals(this.zzhN, zzb.zzhN) && this.zzhO == zzb.zzhO && this.name == zzb.name && this.zzhP == zzb.zzhP && this.zzhQ == zzb.zzhQ) {
                return zza(zzb);
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzhP ? 1231 : 1237) + ((((((zzrl.hashCode(this.zzhN) + 527) * 31) + this.zzhO) * 31) + this.name) * 31)) * 31;
            if (!this.zzhQ) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB();
            if (this.zzhQ) {
                zzB += zzrg.zzc(1, this.zzhQ);
            }
            int zzA = zzrg.zzA(2, this.zzhO) + zzB;
            if (this.zzhN == null || this.zzhN.length <= 0) {
                i = zzA;
            } else {
                for (int i3 = 0; i3 < this.zzhN.length; i3++) {
                    i2 += zzrg.zzkJ(this.zzhN[i3]);
                }
                i = zzA + i2 + (this.zzhN.length * 1);
            }
            if (this.name != 0) {
                i += zzrg.zzA(4, this.name);
            }
            return this.zzhP ? i + zzrg.zzc(6, this.zzhP) : i;
        }

        public zzb zzD() {
            this.zzhN = zzrq.zzaWh;
            this.zzhO = 0;
            this.name = 0;
            this.zzhP = false;
            this.zzhQ = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzhQ) {
                zzrg.zzb(1, this.zzhQ);
            }
            zzrg.zzy(2, this.zzhO);
            if (this.zzhN != null && this.zzhN.length > 0) {
                for (int i = 0; i < this.zzhN.length; i++) {
                    zzrg.zzy(3, this.zzhN[i]);
                }
            }
            if (this.name != 0) {
                zzrg.zzy(4, this.name);
            }
            if (this.zzhP) {
                zzrg.zzb(6, this.zzhP);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzc */
        public zzb zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        this.zzhQ = zzrf.zzBv();
                        break;
                    case 16:
                        this.zzhO = zzrf.zzBu();
                        break;
                    case 24:
                        int zzb = zzrq.zzb(zzrf, 24);
                        int length = this.zzhN == null ? 0 : this.zzhN.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzhN, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrf.zzBu();
                            zzrf.zzBr();
                            length++;
                        }
                        iArr[length] = zzrf.zzBu();
                        this.zzhN = iArr;
                        break;
                    case 26:
                        int zzkC = zzrf.zzkC(zzrf.zzBy());
                        int position = zzrf.getPosition();
                        int i = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i++;
                        }
                        zzrf.zzkE(position);
                        int length2 = this.zzhN == null ? 0 : this.zzhN.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhN, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrf.zzBu();
                            length2++;
                        }
                        this.zzhN = iArr2;
                        zzrf.zzkD(zzkC);
                        break;
                    case 32:
                        this.name = zzrf.zzBu();
                        break;
                    case 48:
                        this.zzhP = zzrf.zzBv();
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

    public static final class zzc extends zzrh<zzc> {
        private static volatile zzc[] zzhR;
        public String zzaC;
        public long zzhS;
        public long zzhT;
        public boolean zzhU;
        public long zzhV;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhR == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhR == null) {
                        zzhR = new zzc[0];
                    }
                }
            }
            return zzhR;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.zzaC == null) {
                if (zzc.zzaC != null) {
                    return false;
                }
            } else if (!this.zzaC.equals(zzc.zzaC)) {
                return false;
            }
            if (this.zzhS == zzc.zzhS && this.zzhT == zzc.zzhT && this.zzhU == zzc.zzhU && this.zzhV == zzc.zzhV) {
                return zza(zzc);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.zzhU ? 1231 : 1237) + (((((((this.zzaC == null ? 0 : this.zzaC.hashCode()) + 527) * 31) + ((int) (this.zzhS ^ (this.zzhS >>> 32)))) * 31) + ((int) (this.zzhT ^ (this.zzhT >>> 32)))) * 31)) * 31) + ((int) (this.zzhV ^ (this.zzhV >>> 32)))) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (!this.zzaC.equals("")) {
                zzB += zzrg.zzk(1, this.zzaC);
            }
            if (this.zzhS != 0) {
                zzB += zzrg.zzd(2, this.zzhS);
            }
            if (this.zzhT != 2147483647L) {
                zzB += zzrg.zzd(3, this.zzhT);
            }
            if (this.zzhU) {
                zzB += zzrg.zzc(4, this.zzhU);
            }
            return this.zzhV != 0 ? zzB + zzrg.zzd(5, this.zzhV) : zzB;
        }

        public zzc zzF() {
            this.zzaC = "";
            this.zzhS = 0;
            this.zzhT = 2147483647L;
            this.zzhU = false;
            this.zzhV = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (!this.zzaC.equals("")) {
                zzrg.zzb(1, this.zzaC);
            }
            if (this.zzhS != 0) {
                zzrg.zzb(2, this.zzhS);
            }
            if (this.zzhT != 2147483647L) {
                zzrg.zzb(3, this.zzhT);
            }
            if (this.zzhU) {
                zzrg.zzb(4, this.zzhU);
            }
            if (this.zzhV != 0) {
                zzrg.zzb(5, this.zzhV);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzd */
        public zzc zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.zzaC = zzrf.readString();
                        break;
                    case 16:
                        this.zzhS = zzrf.zzBt();
                        break;
                    case 24:
                        this.zzhT = zzrf.zzBt();
                        break;
                    case 32:
                        this.zzhU = zzrf.zzBv();
                        break;
                    case 40:
                        this.zzhV = zzrf.zzBt();
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

    public static final class zzd extends zzrh<zzd> {
        public zzag.zza[] zzhW;
        public zzag.zza[] zzhX;
        public zzc[] zzhY;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (!zzrl.equals(this.zzhW, zzd.zzhW) || !zzrl.equals(this.zzhX, zzd.zzhX) || !zzrl.equals(this.zzhY, zzd.zzhY)) {
                return false;
            }
            return zza(zzd);
        }

        public int hashCode() {
            return ((((((zzrl.hashCode(this.zzhW) + 527) * 31) + zzrl.hashCode(this.zzhX)) * 31) + zzrl.hashCode(this.zzhY)) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzhW != null && this.zzhW.length > 0) {
                int i = zzB;
                for (int i2 = 0; i2 < this.zzhW.length; i2++) {
                    zzag.zza zza = this.zzhW[i2];
                    if (zza != null) {
                        i += zzrg.zzc(1, zza);
                    }
                }
                zzB = i;
            }
            if (this.zzhX != null && this.zzhX.length > 0) {
                int i3 = zzB;
                for (int i4 = 0; i4 < this.zzhX.length; i4++) {
                    zzag.zza zza2 = this.zzhX[i4];
                    if (zza2 != null) {
                        i3 += zzrg.zzc(2, zza2);
                    }
                }
                zzB = i3;
            }
            if (this.zzhY != null && this.zzhY.length > 0) {
                for (int i5 = 0; i5 < this.zzhY.length; i5++) {
                    zzc zzc = this.zzhY[i5];
                    if (zzc != null) {
                        zzB += zzrg.zzc(3, zzc);
                    }
                }
            }
            return zzB;
        }

        public zzd zzG() {
            this.zzhW = zzag.zza.zzQ();
            this.zzhX = zzag.zza.zzQ();
            this.zzhY = zzc.zzE();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzhW != null && this.zzhW.length > 0) {
                for (int i = 0; i < this.zzhW.length; i++) {
                    zzag.zza zza = this.zzhW[i];
                    if (zza != null) {
                        zzrg.zza(1, zza);
                    }
                }
            }
            if (this.zzhX != null && this.zzhX.length > 0) {
                for (int i2 = 0; i2 < this.zzhX.length; i2++) {
                    zzag.zza zza2 = this.zzhX[i2];
                    if (zza2 != null) {
                        zzrg.zza(2, zza2);
                    }
                }
            }
            if (this.zzhY != null && this.zzhY.length > 0) {
                for (int i3 = 0; i3 < this.zzhY.length; i3++) {
                    zzc zzc = this.zzhY[i3];
                    if (zzc != null) {
                        zzrg.zza(3, zzc);
                    }
                }
            }
            super.zza(zzrg);
        }

        /* renamed from: zze */
        public zzd zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzrq.zzb(zzrf, 10);
                        int length = this.zzhW == null ? 0 : this.zzhW.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzhW, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new zzag.zza();
                            zzrf.zza(zzaArr[length]);
                            zzrf.zzBr();
                            length++;
                        }
                        zzaArr[length] = new zzag.zza();
                        zzrf.zza(zzaArr[length]);
                        this.zzhW = zzaArr;
                        break;
                    case 18:
                        int zzb2 = zzrq.zzb(zzrf, 18);
                        int length2 = this.zzhX == null ? 0 : this.zzhX.length;
                        zzag.zza[] zzaArr2 = new zzag.zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhX, 0, zzaArr2, 0, length2);
                        }
                        while (length2 < zzaArr2.length - 1) {
                            zzaArr2[length2] = new zzag.zza();
                            zzrf.zza(zzaArr2[length2]);
                            zzrf.zzBr();
                            length2++;
                        }
                        zzaArr2[length2] = new zzag.zza();
                        zzrf.zza(zzaArr2[length2]);
                        this.zzhX = zzaArr2;
                        break;
                    case 26:
                        int zzb3 = zzrq.zzb(zzrf, 26);
                        int length3 = this.zzhY == null ? 0 : this.zzhY.length;
                        zzc[] zzcArr = new zzc[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzhY, 0, zzcArr, 0, length3);
                        }
                        while (length3 < zzcArr.length - 1) {
                            zzcArr[length3] = new zzc();
                            zzrf.zza(zzcArr[length3]);
                            zzrf.zzBr();
                            length3++;
                        }
                        zzcArr[length3] = new zzc();
                        zzrf.zza(zzcArr[length3]);
                        this.zzhY = zzcArr;
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

    public static final class zze extends zzrh<zze> {
        private static volatile zze[] zzhZ;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzhZ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhZ == null) {
                        zzhZ = new zze[0];
                    }
                }
            }
            return zzhZ;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze zze = (zze) o;
            if (this.key == zze.key && this.value == zze.value) {
                return zza(zze);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            return super.zzB() + zzrg.zzA(1, this.key) + zzrg.zzA(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            zzrg.zzy(1, this.key);
            zzrg.zzy(2, this.value);
            super.zza(zzrg);
        }

        /* renamed from: zzf */
        public zze zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        this.key = zzrf.zzBu();
                        break;
                    case 16:
                        this.value = zzrf.zzBu();
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

    public static final class zzf extends zzrh<zzf> {
        public String version;
        public String[] zzia;
        public String[] zzib;
        public zzag.zza[] zzic;
        public zze[] zzid;
        public zzb[] zzie;
        public zzb[] zzif;
        public zzb[] zzig;
        public zzg[] zzih;
        public String zzii;
        public String zzij;
        public String zzik;
        public zza zzil;
        public float zzim;
        public boolean zzin;
        public String[] zzio;
        public int zzip;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzrm {
            return (zzf) zzrn.zza(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) o;
            if (!zzrl.equals(this.zzia, zzf.zzia) || !zzrl.equals(this.zzib, zzf.zzib) || !zzrl.equals(this.zzic, zzf.zzic) || !zzrl.equals(this.zzid, zzf.zzid) || !zzrl.equals(this.zzie, zzf.zzie) || !zzrl.equals(this.zzif, zzf.zzif) || !zzrl.equals(this.zzig, zzf.zzig) || !zzrl.equals(this.zzih, zzf.zzih)) {
                return false;
            }
            if (this.zzii == null) {
                if (zzf.zzii != null) {
                    return false;
                }
            } else if (!this.zzii.equals(zzf.zzii)) {
                return false;
            }
            if (this.zzij == null) {
                if (zzf.zzij != null) {
                    return false;
                }
            } else if (!this.zzij.equals(zzf.zzij)) {
                return false;
            }
            if (this.zzik == null) {
                if (zzf.zzik != null) {
                    return false;
                }
            } else if (!this.zzik.equals(zzf.zzik)) {
                return false;
            }
            if (this.version == null) {
                if (zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzf.version)) {
                return false;
            }
            if (this.zzil == null) {
                if (zzf.zzil != null) {
                    return false;
                }
            } else if (!this.zzil.equals(zzf.zzil)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzim) == Float.floatToIntBits(zzf.zzim) && this.zzin == zzf.zzin && zzrl.equals(this.zzio, zzf.zzio) && this.zzip == zzf.zzip) {
                return zza(zzf);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzik == null ? 0 : this.zzik.hashCode()) + (((this.zzij == null ? 0 : this.zzij.hashCode()) + (((this.zzii == null ? 0 : this.zzii.hashCode()) + ((((((((((((((((zzrl.hashCode(this.zzia) + 527) * 31) + zzrl.hashCode(this.zzib)) * 31) + zzrl.hashCode(this.zzic)) * 31) + zzrl.hashCode(this.zzid)) * 31) + zzrl.hashCode(this.zzie)) * 31) + zzrl.hashCode(this.zzif)) * 31) + zzrl.hashCode(this.zzig)) * 31) + zzrl.hashCode(this.zzih)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzil != null) {
                i = this.zzil.hashCode();
            }
            return (((((((this.zzin ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.zzim)) * 31)) * 31) + zzrl.hashCode(this.zzio)) * 31) + this.zzip) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzib == null || this.zzib.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzib.length; i4++) {
                    String str = this.zzib[i4];
                    if (str != null) {
                        i3++;
                        i2 += zzrg.zzfj(str);
                    }
                }
                i = zzB + i2 + (i3 * 1);
            }
            if (this.zzic != null && this.zzic.length > 0) {
                int i5 = i;
                for (int i6 = 0; i6 < this.zzic.length; i6++) {
                    zzag.zza zza = this.zzic[i6];
                    if (zza != null) {
                        i5 += zzrg.zzc(2, zza);
                    }
                }
                i = i5;
            }
            if (this.zzid != null && this.zzid.length > 0) {
                int i7 = i;
                for (int i8 = 0; i8 < this.zzid.length; i8++) {
                    zze zze = this.zzid[i8];
                    if (zze != null) {
                        i7 += zzrg.zzc(3, zze);
                    }
                }
                i = i7;
            }
            if (this.zzie != null && this.zzie.length > 0) {
                int i9 = i;
                for (int i10 = 0; i10 < this.zzie.length; i10++) {
                    zzb zzb = this.zzie[i10];
                    if (zzb != null) {
                        i9 += zzrg.zzc(4, zzb);
                    }
                }
                i = i9;
            }
            if (this.zzif != null && this.zzif.length > 0) {
                int i11 = i;
                for (int i12 = 0; i12 < this.zzif.length; i12++) {
                    zzb zzb2 = this.zzif[i12];
                    if (zzb2 != null) {
                        i11 += zzrg.zzc(5, zzb2);
                    }
                }
                i = i11;
            }
            if (this.zzig != null && this.zzig.length > 0) {
                int i13 = i;
                for (int i14 = 0; i14 < this.zzig.length; i14++) {
                    zzb zzb3 = this.zzig[i14];
                    if (zzb3 != null) {
                        i13 += zzrg.zzc(6, zzb3);
                    }
                }
                i = i13;
            }
            if (this.zzih != null && this.zzih.length > 0) {
                int i15 = i;
                for (int i16 = 0; i16 < this.zzih.length; i16++) {
                    zzg zzg = this.zzih[i16];
                    if (zzg != null) {
                        i15 += zzrg.zzc(7, zzg);
                    }
                }
                i = i15;
            }
            if (!this.zzii.equals("")) {
                i += zzrg.zzk(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                i += zzrg.zzk(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                i += zzrg.zzk(12, this.zzik);
            }
            if (!this.version.equals("")) {
                i += zzrg.zzk(13, this.version);
            }
            if (this.zzil != null) {
                i += zzrg.zzc(14, this.zzil);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                i += zzrg.zzc(15, this.zzim);
            }
            if (this.zzio != null && this.zzio.length > 0) {
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < this.zzio.length; i19++) {
                    String str2 = this.zzio[i19];
                    if (str2 != null) {
                        i18++;
                        i17 += zzrg.zzfj(str2);
                    }
                }
                i = i + i17 + (i18 * 2);
            }
            if (this.zzip != 0) {
                i += zzrg.zzA(17, this.zzip);
            }
            if (this.zzin) {
                i += zzrg.zzc(18, this.zzin);
            }
            if (this.zzia == null || this.zzia.length <= 0) {
                return i;
            }
            int i20 = 0;
            int i21 = 0;
            for (int i22 = 0; i22 < this.zzia.length; i22++) {
                String str3 = this.zzia[i22];
                if (str3 != null) {
                    i21++;
                    i20 += zzrg.zzfj(str3);
                }
            }
            return i + i20 + (i21 * 2);
        }

        public zzf zzJ() {
            this.zzia = zzrq.zzaWm;
            this.zzib = zzrq.zzaWm;
            this.zzic = zzag.zza.zzQ();
            this.zzid = zze.zzH();
            this.zzie = zzb.zzC();
            this.zzif = zzb.zzC();
            this.zzig = zzb.zzC();
            this.zzih = zzg.zzK();
            this.zzii = "";
            this.zzij = "";
            this.zzik = "0";
            this.version = "";
            this.zzil = null;
            this.zzim = 0.0f;
            this.zzin = false;
            this.zzio = zzrq.zzaWm;
            this.zzip = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzib != null && this.zzib.length > 0) {
                for (int i = 0; i < this.zzib.length; i++) {
                    String str = this.zzib[i];
                    if (str != null) {
                        zzrg.zzb(1, str);
                    }
                }
            }
            if (this.zzic != null && this.zzic.length > 0) {
                for (int i2 = 0; i2 < this.zzic.length; i2++) {
                    zzag.zza zza = this.zzic[i2];
                    if (zza != null) {
                        zzrg.zza(2, zza);
                    }
                }
            }
            if (this.zzid != null && this.zzid.length > 0) {
                for (int i3 = 0; i3 < this.zzid.length; i3++) {
                    zze zze = this.zzid[i3];
                    if (zze != null) {
                        zzrg.zza(3, zze);
                    }
                }
            }
            if (this.zzie != null && this.zzie.length > 0) {
                for (int i4 = 0; i4 < this.zzie.length; i4++) {
                    zzb zzb = this.zzie[i4];
                    if (zzb != null) {
                        zzrg.zza(4, zzb);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (int i5 = 0; i5 < this.zzif.length; i5++) {
                    zzb zzb2 = this.zzif[i5];
                    if (zzb2 != null) {
                        zzrg.zza(5, zzb2);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (int i6 = 0; i6 < this.zzig.length; i6++) {
                    zzb zzb3 = this.zzig[i6];
                    if (zzb3 != null) {
                        zzrg.zza(6, zzb3);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (int i7 = 0; i7 < this.zzih.length; i7++) {
                    zzg zzg = this.zzih[i7];
                    if (zzg != null) {
                        zzrg.zza(7, zzg);
                    }
                }
            }
            if (!this.zzii.equals("")) {
                zzrg.zzb(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                zzrg.zzb(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                zzrg.zzb(12, this.zzik);
            }
            if (!this.version.equals("")) {
                zzrg.zzb(13, this.version);
            }
            if (this.zzil != null) {
                zzrg.zza(14, this.zzil);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                zzrg.zzb(15, this.zzim);
            }
            if (this.zzio != null && this.zzio.length > 0) {
                for (int i8 = 0; i8 < this.zzio.length; i8++) {
                    String str2 = this.zzio[i8];
                    if (str2 != null) {
                        zzrg.zzb(16, str2);
                    }
                }
            }
            if (this.zzip != 0) {
                zzrg.zzy(17, this.zzip);
            }
            if (this.zzin) {
                zzrg.zzb(18, this.zzin);
            }
            if (this.zzia != null && this.zzia.length > 0) {
                for (int i9 = 0; i9 < this.zzia.length; i9++) {
                    String str3 = this.zzia[i9];
                    if (str3 != null) {
                        zzrg.zzb(19, str3);
                    }
                }
            }
            super.zza(zzrg);
        }

        /* renamed from: zzg */
        public zzf zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzrq.zzb(zzrf, 10);
                        int length = this.zzib == null ? 0 : this.zzib.length;
                        String[] strArr = new String[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzib, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzrf.readString();
                            zzrf.zzBr();
                            length++;
                        }
                        strArr[length] = zzrf.readString();
                        this.zzib = strArr;
                        break;
                    case 18:
                        int zzb2 = zzrq.zzb(zzrf, 18);
                        int length2 = this.zzic == null ? 0 : this.zzic.length;
                        zzag.zza[] zzaArr = new zzag.zza[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzic, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zzag.zza();
                            zzrf.zza(zzaArr[length2]);
                            zzrf.zzBr();
                            length2++;
                        }
                        zzaArr[length2] = new zzag.zza();
                        zzrf.zza(zzaArr[length2]);
                        this.zzic = zzaArr;
                        break;
                    case 26:
                        int zzb3 = zzrq.zzb(zzrf, 26);
                        int length3 = this.zzid == null ? 0 : this.zzid.length;
                        zze[] zzeArr = new zze[(zzb3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzid, 0, zzeArr, 0, length3);
                        }
                        while (length3 < zzeArr.length - 1) {
                            zzeArr[length3] = new zze();
                            zzrf.zza(zzeArr[length3]);
                            zzrf.zzBr();
                            length3++;
                        }
                        zzeArr[length3] = new zze();
                        zzrf.zza(zzeArr[length3]);
                        this.zzid = zzeArr;
                        break;
                    case 34:
                        int zzb4 = zzrq.zzb(zzrf, 34);
                        int length4 = this.zzie == null ? 0 : this.zzie.length;
                        zzb[] zzbArr = new zzb[(zzb4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzie, 0, zzbArr, 0, length4);
                        }
                        while (length4 < zzbArr.length - 1) {
                            zzbArr[length4] = new zzb();
                            zzrf.zza(zzbArr[length4]);
                            zzrf.zzBr();
                            length4++;
                        }
                        zzbArr[length4] = new zzb();
                        zzrf.zza(zzbArr[length4]);
                        this.zzie = zzbArr;
                        break;
                    case 42:
                        int zzb5 = zzrq.zzb(zzrf, 42);
                        int length5 = this.zzif == null ? 0 : this.zzif.length;
                        zzb[] zzbArr2 = new zzb[(zzb5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzif, 0, zzbArr2, 0, length5);
                        }
                        while (length5 < zzbArr2.length - 1) {
                            zzbArr2[length5] = new zzb();
                            zzrf.zza(zzbArr2[length5]);
                            zzrf.zzBr();
                            length5++;
                        }
                        zzbArr2[length5] = new zzb();
                        zzrf.zza(zzbArr2[length5]);
                        this.zzif = zzbArr2;
                        break;
                    case 50:
                        int zzb6 = zzrq.zzb(zzrf, 50);
                        int length6 = this.zzig == null ? 0 : this.zzig.length;
                        zzb[] zzbArr3 = new zzb[(zzb6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzig, 0, zzbArr3, 0, length6);
                        }
                        while (length6 < zzbArr3.length - 1) {
                            zzbArr3[length6] = new zzb();
                            zzrf.zza(zzbArr3[length6]);
                            zzrf.zzBr();
                            length6++;
                        }
                        zzbArr3[length6] = new zzb();
                        zzrf.zza(zzbArr3[length6]);
                        this.zzig = zzbArr3;
                        break;
                    case 58:
                        int zzb7 = zzrq.zzb(zzrf, 58);
                        int length7 = this.zzih == null ? 0 : this.zzih.length;
                        zzg[] zzgArr = new zzg[(zzb7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zzih, 0, zzgArr, 0, length7);
                        }
                        while (length7 < zzgArr.length - 1) {
                            zzgArr[length7] = new zzg();
                            zzrf.zza(zzgArr[length7]);
                            zzrf.zzBr();
                            length7++;
                        }
                        zzgArr[length7] = new zzg();
                        zzrf.zza(zzgArr[length7]);
                        this.zzih = zzgArr;
                        break;
                    case 74:
                        this.zzii = zzrf.readString();
                        break;
                    case 82:
                        this.zzij = zzrf.readString();
                        break;
                    case 98:
                        this.zzik = zzrf.readString();
                        break;
                    case 106:
                        this.version = zzrf.readString();
                        break;
                    case 114:
                        if (this.zzil == null) {
                            this.zzil = new zza();
                        }
                        zzrf.zza(this.zzil);
                        break;
                    case 125:
                        this.zzim = zzrf.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        int zzb8 = zzrq.zzb(zzrf, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzio == null ? 0 : this.zzio.length;
                        String[] strArr2 = new String[(zzb8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zzio, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = zzrf.readString();
                            zzrf.zzBr();
                            length8++;
                        }
                        strArr2[length8] = zzrf.readString();
                        this.zzio = strArr2;
                        break;
                    case 136:
                        this.zzip = zzrf.zzBu();
                        break;
                    case 144:
                        this.zzin = zzrf.zzBv();
                        break;
                    case 154:
                        int zzb9 = zzrq.zzb(zzrf, 154);
                        int length9 = this.zzia == null ? 0 : this.zzia.length;
                        String[] strArr3 = new String[(zzb9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zzia, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = zzrf.readString();
                            zzrf.zzBr();
                            length9++;
                        }
                        strArr3[length9] = zzrf.readString();
                        this.zzia = strArr3;
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

    public static final class zzg extends zzrh<zzg> {
        private static volatile zzg[] zziq;
        public int[] zziA;
        public int[] zzir;
        public int[] zzis;
        public int[] zzit;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziq == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziq == null) {
                        zziq = new zzg[0];
                    }
                }
            }
            return zziq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) o;
            if (!zzrl.equals(this.zzir, zzg.zzir) || !zzrl.equals(this.zzis, zzg.zzis) || !zzrl.equals(this.zzit, zzg.zzit) || !zzrl.equals(this.zziu, zzg.zziu) || !zzrl.equals(this.zziv, zzg.zziv) || !zzrl.equals(this.zziw, zzg.zziw) || !zzrl.equals(this.zzix, zzg.zzix) || !zzrl.equals(this.zziy, zzg.zziy) || !zzrl.equals(this.zziz, zzg.zziz) || !zzrl.equals(this.zziA, zzg.zziA)) {
                return false;
            }
            return zza(zzg);
        }

        public int hashCode() {
            return ((((((((((((((((((((zzrl.hashCode(this.zzir) + 527) * 31) + zzrl.hashCode(this.zzis)) * 31) + zzrl.hashCode(this.zzit)) * 31) + zzrl.hashCode(this.zziu)) * 31) + zzrl.hashCode(this.zziv)) * 31) + zzrl.hashCode(this.zziw)) * 31) + zzrl.hashCode(this.zzix)) * 31) + zzrl.hashCode(this.zziy)) * 31) + zzrl.hashCode(this.zziz)) * 31) + zzrl.hashCode(this.zziA)) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zzir == null || this.zzir.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzir.length; i3++) {
                    i2 += zzrg.zzkJ(this.zzir[i3]);
                }
                i = zzB + i2 + (this.zzir.length * 1);
            }
            if (this.zzis != null && this.zzis.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.zzis.length; i5++) {
                    i4 += zzrg.zzkJ(this.zzis[i5]);
                }
                i = i + i4 + (this.zzis.length * 1);
            }
            if (this.zzit != null && this.zzit.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.zzit.length; i7++) {
                    i6 += zzrg.zzkJ(this.zzit[i7]);
                }
                i = i + i6 + (this.zzit.length * 1);
            }
            if (this.zziu != null && this.zziu.length > 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < this.zziu.length; i9++) {
                    i8 += zzrg.zzkJ(this.zziu[i9]);
                }
                i = i + i8 + (this.zziu.length * 1);
            }
            if (this.zziv != null && this.zziv.length > 0) {
                int i10 = 0;
                for (int i11 = 0; i11 < this.zziv.length; i11++) {
                    i10 += zzrg.zzkJ(this.zziv[i11]);
                }
                i = i + i10 + (this.zziv.length * 1);
            }
            if (this.zziw != null && this.zziw.length > 0) {
                int i12 = 0;
                for (int i13 = 0; i13 < this.zziw.length; i13++) {
                    i12 += zzrg.zzkJ(this.zziw[i13]);
                }
                i = i + i12 + (this.zziw.length * 1);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < this.zzix.length; i15++) {
                    i14 += zzrg.zzkJ(this.zzix[i15]);
                }
                i = i + i14 + (this.zzix.length * 1);
            }
            if (this.zziy != null && this.zziy.length > 0) {
                int i16 = 0;
                for (int i17 = 0; i17 < this.zziy.length; i17++) {
                    i16 += zzrg.zzkJ(this.zziy[i17]);
                }
                i = i + i16 + (this.zziy.length * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                int i18 = 0;
                for (int i19 = 0; i19 < this.zziz.length; i19++) {
                    i18 += zzrg.zzkJ(this.zziz[i19]);
                }
                i = i + i18 + (this.zziz.length * 1);
            }
            if (this.zziA == null || this.zziA.length <= 0) {
                return i;
            }
            int i20 = 0;
            for (int i21 = 0; i21 < this.zziA.length; i21++) {
                i20 += zzrg.zzkJ(this.zziA[i21]);
            }
            return i + i20 + (this.zziA.length * 1);
        }

        public zzg zzL() {
            this.zzir = zzrq.zzaWh;
            this.zzis = zzrq.zzaWh;
            this.zzit = zzrq.zzaWh;
            this.zziu = zzrq.zzaWh;
            this.zziv = zzrq.zzaWh;
            this.zziw = zzrq.zzaWh;
            this.zzix = zzrq.zzaWh;
            this.zziy = zzrq.zzaWh;
            this.zziz = zzrq.zzaWh;
            this.zziA = zzrq.zzaWh;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzir != null && this.zzir.length > 0) {
                for (int i = 0; i < this.zzir.length; i++) {
                    zzrg.zzy(1, this.zzir[i]);
                }
            }
            if (this.zzis != null && this.zzis.length > 0) {
                for (int i2 = 0; i2 < this.zzis.length; i2++) {
                    zzrg.zzy(2, this.zzis[i2]);
                }
            }
            if (this.zzit != null && this.zzit.length > 0) {
                for (int i3 = 0; i3 < this.zzit.length; i3++) {
                    zzrg.zzy(3, this.zzit[i3]);
                }
            }
            if (this.zziu != null && this.zziu.length > 0) {
                for (int i4 = 0; i4 < this.zziu.length; i4++) {
                    zzrg.zzy(4, this.zziu[i4]);
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                for (int i5 = 0; i5 < this.zziv.length; i5++) {
                    zzrg.zzy(5, this.zziv[i5]);
                }
            }
            if (this.zziw != null && this.zziw.length > 0) {
                for (int i6 = 0; i6 < this.zziw.length; i6++) {
                    zzrg.zzy(6, this.zziw[i6]);
                }
            }
            if (this.zzix != null && this.zzix.length > 0) {
                for (int i7 = 0; i7 < this.zzix.length; i7++) {
                    zzrg.zzy(7, this.zzix[i7]);
                }
            }
            if (this.zziy != null && this.zziy.length > 0) {
                for (int i8 = 0; i8 < this.zziy.length; i8++) {
                    zzrg.zzy(8, this.zziy[i8]);
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (int i9 = 0; i9 < this.zziz.length; i9++) {
                    zzrg.zzy(9, this.zziz[i9]);
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (int i10 = 0; i10 < this.zziA.length; i10++) {
                    zzrg.zzy(10, this.zziA[i10]);
                }
            }
            super.zza(zzrg);
        }

        /* renamed from: zzh */
        public zzg zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        int zzb = zzrq.zzb(zzrf, 8);
                        int length = this.zzir == null ? 0 : this.zzir.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzir, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrf.zzBu();
                            zzrf.zzBr();
                            length++;
                        }
                        iArr[length] = zzrf.zzBu();
                        this.zzir = iArr;
                        break;
                    case 10:
                        int zzkC = zzrf.zzkC(zzrf.zzBy());
                        int position = zzrf.getPosition();
                        int i = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i++;
                        }
                        zzrf.zzkE(position);
                        int length2 = this.zzir == null ? 0 : this.zzir.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzir, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrf.zzBu();
                            length2++;
                        }
                        this.zzir = iArr2;
                        zzrf.zzkD(zzkC);
                        break;
                    case 16:
                        int zzb2 = zzrq.zzb(zzrf, 16);
                        int length3 = this.zzis == null ? 0 : this.zzis.length;
                        int[] iArr3 = new int[(zzb2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzis, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrf.zzBu();
                            zzrf.zzBr();
                            length3++;
                        }
                        iArr3[length3] = zzrf.zzBu();
                        this.zzis = iArr3;
                        break;
                    case 18:
                        int zzkC2 = zzrf.zzkC(zzrf.zzBy());
                        int position2 = zzrf.getPosition();
                        int i2 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i2++;
                        }
                        zzrf.zzkE(position2);
                        int length4 = this.zzis == null ? 0 : this.zzis.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zzis, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrf.zzBu();
                            length4++;
                        }
                        this.zzis = iArr4;
                        zzrf.zzkD(zzkC2);
                        break;
                    case 24:
                        int zzb3 = zzrq.zzb(zzrf, 24);
                        int length5 = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr5 = new int[(zzb3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zzit, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrf.zzBu();
                            zzrf.zzBr();
                            length5++;
                        }
                        iArr5[length5] = zzrf.zzBu();
                        this.zzit = iArr5;
                        break;
                    case 26:
                        int zzkC3 = zzrf.zzkC(zzrf.zzBy());
                        int position3 = zzrf.getPosition();
                        int i3 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i3++;
                        }
                        zzrf.zzkE(position3);
                        int length6 = this.zzit == null ? 0 : this.zzit.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zzit, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrf.zzBu();
                            length6++;
                        }
                        this.zzit = iArr6;
                        zzrf.zzkD(zzkC3);
                        break;
                    case 32:
                        int zzb4 = zzrq.zzb(zzrf, 32);
                        int length7 = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr7 = new int[(zzb4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziu, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrf.zzBu();
                            zzrf.zzBr();
                            length7++;
                        }
                        iArr7[length7] = zzrf.zzBu();
                        this.zziu = iArr7;
                        break;
                    case 34:
                        int zzkC4 = zzrf.zzkC(zzrf.zzBy());
                        int position4 = zzrf.getPosition();
                        int i4 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i4++;
                        }
                        zzrf.zzkE(position4);
                        int length8 = this.zziu == null ? 0 : this.zziu.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zziu, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrf.zzBu();
                            length8++;
                        }
                        this.zziu = iArr8;
                        zzrf.zzkD(zzkC4);
                        break;
                    case 40:
                        int zzb5 = zzrq.zzb(zzrf, 40);
                        int length9 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr9 = new int[(zzb5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.zziv, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = zzrf.zzBu();
                            zzrf.zzBr();
                            length9++;
                        }
                        iArr9[length9] = zzrf.zzBu();
                        this.zziv = iArr9;
                        break;
                    case 42:
                        int zzkC5 = zzrf.zzkC(zzrf.zzBy());
                        int position5 = zzrf.getPosition();
                        int i5 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i5++;
                        }
                        zzrf.zzkE(position5);
                        int length10 = this.zziv == null ? 0 : this.zziv.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.zziv, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = zzrf.zzBu();
                            length10++;
                        }
                        this.zziv = iArr10;
                        zzrf.zzkD(zzkC5);
                        break;
                    case 48:
                        int zzb6 = zzrq.zzb(zzrf, 48);
                        int length11 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr11 = new int[(zzb6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.zziw, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = zzrf.zzBu();
                            zzrf.zzBr();
                            length11++;
                        }
                        iArr11[length11] = zzrf.zzBu();
                        this.zziw = iArr11;
                        break;
                    case 50:
                        int zzkC6 = zzrf.zzkC(zzrf.zzBy());
                        int position6 = zzrf.getPosition();
                        int i6 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i6++;
                        }
                        zzrf.zzkE(position6);
                        int length12 = this.zziw == null ? 0 : this.zziw.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.zziw, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = zzrf.zzBu();
                            length12++;
                        }
                        this.zziw = iArr12;
                        zzrf.zzkD(zzkC6);
                        break;
                    case 56:
                        int zzb7 = zzrq.zzb(zzrf, 56);
                        int length13 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr13 = new int[(zzb7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.zzix, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = zzrf.zzBu();
                            zzrf.zzBr();
                            length13++;
                        }
                        iArr13[length13] = zzrf.zzBu();
                        this.zzix = iArr13;
                        break;
                    case 58:
                        int zzkC7 = zzrf.zzkC(zzrf.zzBy());
                        int position7 = zzrf.getPosition();
                        int i7 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i7++;
                        }
                        zzrf.zzkE(position7);
                        int length14 = this.zzix == null ? 0 : this.zzix.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.zzix, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = zzrf.zzBu();
                            length14++;
                        }
                        this.zzix = iArr14;
                        zzrf.zzkD(zzkC7);
                        break;
                    case 64:
                        int zzb8 = zzrq.zzb(zzrf, 64);
                        int length15 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr15 = new int[(zzb8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.zziy, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = zzrf.zzBu();
                            zzrf.zzBr();
                            length15++;
                        }
                        iArr15[length15] = zzrf.zzBu();
                        this.zziy = iArr15;
                        break;
                    case 66:
                        int zzkC8 = zzrf.zzkC(zzrf.zzBy());
                        int position8 = zzrf.getPosition();
                        int i8 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i8++;
                        }
                        zzrf.zzkE(position8);
                        int length16 = this.zziy == null ? 0 : this.zziy.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.zziy, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = zzrf.zzBu();
                            length16++;
                        }
                        this.zziy = iArr16;
                        zzrf.zzkD(zzkC8);
                        break;
                    case 72:
                        int zzb9 = zzrq.zzb(zzrf, 72);
                        int length17 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr17 = new int[(zzb9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.zziz, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = zzrf.zzBu();
                            zzrf.zzBr();
                            length17++;
                        }
                        iArr17[length17] = zzrf.zzBu();
                        this.zziz = iArr17;
                        break;
                    case 74:
                        int zzkC9 = zzrf.zzkC(zzrf.zzBy());
                        int position9 = zzrf.getPosition();
                        int i9 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i9++;
                        }
                        zzrf.zzkE(position9);
                        int length18 = this.zziz == null ? 0 : this.zziz.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.zziz, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = zzrf.zzBu();
                            length18++;
                        }
                        this.zziz = iArr18;
                        zzrf.zzkD(zzkC9);
                        break;
                    case 80:
                        int zzb10 = zzrq.zzb(zzrf, 80);
                        int length19 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr19 = new int[(zzb10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.zziA, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = zzrf.zzBu();
                            zzrf.zzBr();
                            length19++;
                        }
                        iArr19[length19] = zzrf.zzBu();
                        this.zziA = iArr19;
                        break;
                    case 82:
                        int zzkC10 = zzrf.zzkC(zzrf.zzBy());
                        int position10 = zzrf.getPosition();
                        int i10 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i10++;
                        }
                        zzrf.zzkE(position10);
                        int length20 = this.zziA == null ? 0 : this.zziA.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.zziA, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = zzrf.zzBu();
                            length20++;
                        }
                        this.zziA = iArr20;
                        zzrf.zzkD(zzkC10);
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

    public static final class zzh extends zzrh<zzh> {
        public static final zzri<zzag.zza, zzh> zziB = zzri.zza(11, zzh.class, 810);
        private static final zzh[] zziC = new zzh[0];
        public int[] zziD;
        public int[] zziE;
        public int[] zziF;
        public int zziG;
        public int[] zziH;
        public int zziI;
        public int zziJ;

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh zzh = (zzh) o;
            if (!zzrl.equals(this.zziD, zzh.zziD) || !zzrl.equals(this.zziE, zzh.zziE) || !zzrl.equals(this.zziF, zzh.zziF) || this.zziG != zzh.zziG || !zzrl.equals(this.zziH, zzh.zziH) || this.zziI != zzh.zziI || this.zziJ != zzh.zziJ) {
                return false;
            }
            return zza(zzh);
        }

        public int hashCode() {
            return ((((((((((((((zzrl.hashCode(this.zziD) + 527) * 31) + zzrl.hashCode(this.zziE)) * 31) + zzrl.hashCode(this.zziF)) * 31) + this.zziG) * 31) + zzrl.hashCode(this.zziH)) * 31) + this.zziI) * 31) + this.zziJ) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int i;
            int zzB = super.zzB();
            if (this.zziD == null || this.zziD.length <= 0) {
                i = zzB;
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < this.zziD.length; i3++) {
                    i2 += zzrg.zzkJ(this.zziD[i3]);
                }
                i = zzB + i2 + (this.zziD.length * 1);
            }
            if (this.zziE != null && this.zziE.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.zziE.length; i5++) {
                    i4 += zzrg.zzkJ(this.zziE[i5]);
                }
                i = i + i4 + (this.zziE.length * 1);
            }
            if (this.zziF != null && this.zziF.length > 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.zziF.length; i7++) {
                    i6 += zzrg.zzkJ(this.zziF[i7]);
                }
                i = i + i6 + (this.zziF.length * 1);
            }
            if (this.zziG != 0) {
                i += zzrg.zzA(4, this.zziG);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                int i8 = 0;
                for (int i9 = 0; i9 < this.zziH.length; i9++) {
                    i8 += zzrg.zzkJ(this.zziH[i9]);
                }
                i = i + i8 + (this.zziH.length * 1);
            }
            if (this.zziI != 0) {
                i += zzrg.zzA(6, this.zziI);
            }
            return this.zziJ != 0 ? i + zzrg.zzA(7, this.zziJ) : i;
        }

        public zzh zzM() {
            this.zziD = zzrq.zzaWh;
            this.zziE = zzrq.zzaWh;
            this.zziF = zzrq.zzaWh;
            this.zziG = 0;
            this.zziH = zzrq.zzaWh;
            this.zziI = 0;
            this.zziJ = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zziD != null && this.zziD.length > 0) {
                for (int i = 0; i < this.zziD.length; i++) {
                    zzrg.zzy(1, this.zziD[i]);
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (int i2 = 0; i2 < this.zziE.length; i2++) {
                    zzrg.zzy(2, this.zziE[i2]);
                }
            }
            if (this.zziF != null && this.zziF.length > 0) {
                for (int i3 = 0; i3 < this.zziF.length; i3++) {
                    zzrg.zzy(3, this.zziF[i3]);
                }
            }
            if (this.zziG != 0) {
                zzrg.zzy(4, this.zziG);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                for (int i4 = 0; i4 < this.zziH.length; i4++) {
                    zzrg.zzy(5, this.zziH[i4]);
                }
            }
            if (this.zziI != 0) {
                zzrg.zzy(6, this.zziI);
            }
            if (this.zziJ != 0) {
                zzrg.zzy(7, this.zziJ);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzi */
        public zzh zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        int zzb = zzrq.zzb(zzrf, 8);
                        int length = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr = new int[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziD, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzrf.zzBu();
                            zzrf.zzBr();
                            length++;
                        }
                        iArr[length] = zzrf.zzBu();
                        this.zziD = iArr;
                        break;
                    case 10:
                        int zzkC = zzrf.zzkC(zzrf.zzBy());
                        int position = zzrf.getPosition();
                        int i = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i++;
                        }
                        zzrf.zzkE(position);
                        int length2 = this.zziD == null ? 0 : this.zziD.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zziD, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzrf.zzBu();
                            length2++;
                        }
                        this.zziD = iArr2;
                        zzrf.zzkD(zzkC);
                        break;
                    case 16:
                        int zzb2 = zzrq.zzb(zzrf, 16);
                        int length3 = this.zziE == null ? 0 : this.zziE.length;
                        int[] iArr3 = new int[(zzb2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zziE, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = zzrf.zzBu();
                            zzrf.zzBr();
                            length3++;
                        }
                        iArr3[length3] = zzrf.zzBu();
                        this.zziE = iArr3;
                        break;
                    case 18:
                        int zzkC2 = zzrf.zzkC(zzrf.zzBy());
                        int position2 = zzrf.getPosition();
                        int i2 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i2++;
                        }
                        zzrf.zzkE(position2);
                        int length4 = this.zziE == null ? 0 : this.zziE.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.zziE, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = zzrf.zzBu();
                            length4++;
                        }
                        this.zziE = iArr4;
                        zzrf.zzkD(zzkC2);
                        break;
                    case 24:
                        int zzb3 = zzrq.zzb(zzrf, 24);
                        int length5 = this.zziF == null ? 0 : this.zziF.length;
                        int[] iArr5 = new int[(zzb3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.zziF, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = zzrf.zzBu();
                            zzrf.zzBr();
                            length5++;
                        }
                        iArr5[length5] = zzrf.zzBu();
                        this.zziF = iArr5;
                        break;
                    case 26:
                        int zzkC3 = zzrf.zzkC(zzrf.zzBy());
                        int position3 = zzrf.getPosition();
                        int i3 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i3++;
                        }
                        zzrf.zzkE(position3);
                        int length6 = this.zziF == null ? 0 : this.zziF.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.zziF, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = zzrf.zzBu();
                            length6++;
                        }
                        this.zziF = iArr6;
                        zzrf.zzkD(zzkC3);
                        break;
                    case 32:
                        this.zziG = zzrf.zzBu();
                        break;
                    case 40:
                        int zzb4 = zzrq.zzb(zzrf, 40);
                        int length7 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr7 = new int[(zzb4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.zziH, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = zzrf.zzBu();
                            zzrf.zzBr();
                            length7++;
                        }
                        iArr7[length7] = zzrf.zzBu();
                        this.zziH = iArr7;
                        break;
                    case 42:
                        int zzkC4 = zzrf.zzkC(zzrf.zzBy());
                        int position4 = zzrf.getPosition();
                        int i4 = 0;
                        while (zzrf.zzBD() > 0) {
                            zzrf.zzBu();
                            i4++;
                        }
                        zzrf.zzkE(position4);
                        int length8 = this.zziH == null ? 0 : this.zziH.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.zziH, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = zzrf.zzBu();
                            length8++;
                        }
                        this.zziH = iArr8;
                        zzrf.zzkD(zzkC4);
                        break;
                    case 48:
                        this.zziI = zzrf.zzBu();
                        break;
                    case 56:
                        this.zziJ = zzrf.zzBu();
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

    public static final class zzi extends zzrh<zzi> {
        private static volatile zzi[] zziK;
        public String name;
        public zzag.zza zziL;
        public zzd zziM;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziK == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziK == null) {
                        zziK = new zzi[0];
                    }
                }
            }
            return zziK;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi zzi = (zzi) o;
            if (this.name == null) {
                if (zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzi.name)) {
                return false;
            }
            if (this.zziL == null) {
                if (zzi.zziL != null) {
                    return false;
                }
            } else if (!this.zziL.equals(zzi.zziL)) {
                return false;
            }
            if (this.zziM == null) {
                if (zzi.zziM != null) {
                    return false;
                }
            } else if (!this.zziM.equals(zzi.zziM)) {
                return false;
            }
            return zza(zzi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziL == null ? 0 : this.zziL.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zziM != null) {
                i = this.zziM.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrg.zzk(1, this.name);
            }
            if (this.zziL != null) {
                zzB += zzrg.zzc(2, this.zziL);
            }
            return this.zziM != null ? zzB + zzrg.zzc(3, this.zziM) : zzB;
        }

        public zzi zzO() {
            this.name = "";
            this.zziL = null;
            this.zziM = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (!this.name.equals("")) {
                zzrg.zzb(1, this.name);
            }
            if (this.zziL != null) {
                zzrg.zza(2, this.zziL);
            }
            if (this.zziM != null) {
                zzrg.zza(3, this.zziM);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzj */
        public zzi zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrf.readString();
                        break;
                    case 18:
                        if (this.zziL == null) {
                            this.zziL = new zzag.zza();
                        }
                        zzrf.zza(this.zziL);
                        break;
                    case 26:
                        if (this.zziM == null) {
                            this.zziM = new zzd();
                        }
                        zzrf.zza(this.zziM);
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

    public static final class zzj extends zzrh<zzj> {
        public zzi[] zziN;
        public zzf zziO;
        public String zziP;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzrm {
            return (zzj) zzrn.zza(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj zzj = (zzj) o;
            if (!zzrl.equals(this.zziN, zzj.zziN)) {
                return false;
            }
            if (this.zziO == null) {
                if (zzj.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zzj.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (zzj.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(zzj.zziP)) {
                return false;
            }
            return zza(zzj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziO == null ? 0 : this.zziO.hashCode()) + ((zzrl.hashCode(this.zziN) + 527) * 31)) * 31;
            if (this.zziP != null) {
                i = this.zziP.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (this.zziN != null && this.zziN.length > 0) {
                for (int i = 0; i < this.zziN.length; i++) {
                    zzi zzi = this.zziN[i];
                    if (zzi != null) {
                        zzB += zzrg.zzc(1, zzi);
                    }
                }
            }
            if (this.zziO != null) {
                zzB += zzrg.zzc(2, this.zziO);
            }
            return !this.zziP.equals("") ? zzB + zzrg.zzk(3, this.zziP) : zzB;
        }

        public zzj zzP() {
            this.zziN = zzi.zzN();
            this.zziO = null;
            this.zziP = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zziN != null && this.zziN.length > 0) {
                for (int i = 0; i < this.zziN.length; i++) {
                    zzi zzi = this.zziN[i];
                    if (zzi != null) {
                        zzrg.zza(1, zzi);
                    }
                }
            }
            if (this.zziO != null) {
                zzrg.zza(2, this.zziO);
            }
            if (!this.zziP.equals("")) {
                zzrg.zzb(3, this.zziP);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzk */
        public zzj zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzrq.zzb(zzrf, 10);
                        int length = this.zziN == null ? 0 : this.zziN.length;
                        zzi[] zziArr = new zzi[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zziN, 0, zziArr, 0, length);
                        }
                        while (length < zziArr.length - 1) {
                            zziArr[length] = new zzi();
                            zzrf.zza(zziArr[length]);
                            zzrf.zzBr();
                            length++;
                        }
                        zziArr[length] = new zzi();
                        zzrf.zza(zziArr[length]);
                        this.zziN = zziArr;
                        break;
                    case 18:
                        if (this.zziO == null) {
                            this.zziO = new zzf();
                        }
                        zzrf.zza(this.zziO);
                        break;
                    case 26:
                        this.zziP = zzrf.readString();
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
