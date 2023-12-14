package com.google.android.gms.internal;

import java.io.IOException;

public interface zznj {

    public static final class zza extends zzrh<zza> {
        public C0126zza[] zzawk;

        /* renamed from: com.google.android.gms.internal.zznj$zza$zza  reason: collision with other inner class name */
        public static final class C0126zza extends zzrh<C0126zza> {
            private static volatile C0126zza[] zzawl;
            public int viewId;
            public String zzawm;
            public String zzawn;

            public C0126zza() {
                zztW();
            }

            public static C0126zza[] zztV() {
                if (zzawl == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzawl == null) {
                            zzawl = new C0126zza[0];
                        }
                    }
                }
                return zzawl;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C0126zza)) {
                    return false;
                }
                C0126zza zza = (C0126zza) o;
                if (this.zzawm == null) {
                    if (zza.zzawm != null) {
                        return false;
                    }
                } else if (!this.zzawm.equals(zza.zzawm)) {
                    return false;
                }
                if (this.zzawn == null) {
                    if (zza.zzawn != null) {
                        return false;
                    }
                } else if (!this.zzawn.equals(zza.zzawn)) {
                    return false;
                }
                if (this.viewId == zza.viewId) {
                    return zza(zza);
                }
                return false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzawm == null ? 0 : this.zzawm.hashCode()) + 527) * 31;
                if (this.zzawn != null) {
                    i = this.zzawn.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzBI();
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public int zzB() {
                int zzB = super.zzB();
                if (!this.zzawm.equals("")) {
                    zzB += zzrg.zzk(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzB += zzrg.zzk(2, this.zzawn);
                }
                return this.viewId != 0 ? zzB + zzrg.zzA(3, this.viewId) : zzB;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrg) throws IOException {
                if (!this.zzawm.equals("")) {
                    zzrg.zzb(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzrg.zzb(2, this.zzawn);
                }
                if (this.viewId != 0) {
                    zzrg.zzy(3, this.viewId);
                }
                super.zza(zzrg);
            }

            /* renamed from: zzq */
            public C0126zza zzb(zzrf zzrf) throws IOException {
                while (true) {
                    int zzBr = zzrf.zzBr();
                    switch (zzBr) {
                        case 0:
                            break;
                        case 10:
                            this.zzawm = zzrf.readString();
                            break;
                        case 18:
                            this.zzawn = zzrf.readString();
                            break;
                        case 24:
                            this.viewId = zzrf.zzBu();
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

            public C0126zza zztW() {
                this.zzawm = "";
                this.zzawn = "";
                this.viewId = 0;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }
        }

        public zza() {
            zztU();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (zzrl.equals(this.zzawk, zza.zzawk)) {
                return zza(zza);
            }
            return false;
        }

        public int hashCode() {
            return ((zzrl.hashCode(this.zzawk) + 527) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C0126zza zza = this.zzawk[i];
                    if (zza != null) {
                        zzB += zzrg.zzc(1, zza);
                    }
                }
            }
            return zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C0126zza zza = this.zzawk[i];
                    if (zza != null) {
                        zzrg.zza(1, zza);
                    }
                }
            }
            super.zza(zzrg);
        }

        /* renamed from: zzp */
        public zza zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzrq.zzb(zzrf, 10);
                        int length = this.zzawk == null ? 0 : this.zzawk.length;
                        C0126zza[] zzaArr = new C0126zza[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzawk, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C0126zza();
                            zzrf.zza(zzaArr[length]);
                            zzrf.zzBr();
                            length++;
                        }
                        zzaArr[length] = new C0126zza();
                        zzrf.zza(zzaArr[length]);
                        this.zzawk = zzaArr;
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

        public zza zztU() {
            this.zzawk = C0126zza.zztV();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzawo;
        public String name;
        public zzd zzawp;

        public zzb() {
            zztY();
        }

        public static zzb[] zztX() {
            if (zzawo == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzawo == null) {
                        zzawo = new zzb[0];
                    }
                }
            }
            return zzawo;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) o;
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.zzawp == null) {
                if (zzb.zzawp != null) {
                    return false;
                }
            } else if (!this.zzawp.equals(zzb.zzawp)) {
                return false;
            }
            return zza(zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzawp != null) {
                i = this.zzawp.hashCode();
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
            return this.zzawp != null ? zzB + zzrg.zzc(2, this.zzawp) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (!this.name.equals("")) {
                zzrg.zzb(1, this.name);
            }
            if (this.zzawp != null) {
                zzrg.zza(2, this.zzawp);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzr */
        public zzb zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrf.readString();
                        break;
                    case 18:
                        if (this.zzawp == null) {
                            this.zzawp = new zzd();
                        }
                        zzrf.zza(this.zzawp);
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

        public zzb zztY() {
            this.name = "";
            this.zzawp = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public String type;
        public zzb[] zzawq;

        public zzc() {
            zztZ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) o;
            if (this.type == null) {
                if (zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzc.type)) {
                return false;
            }
            if (zzrl.equals(this.zzawq, zzc.zzawq)) {
                return zza(zzc);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzrl.hashCode(this.zzawq)) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrg.zzk(1, this.type);
            }
            if (this.zzawq == null || this.zzawq.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (int i2 = 0; i2 < this.zzawq.length; i2++) {
                zzb zzb = this.zzawq[i2];
                if (zzb != null) {
                    i += zzrg.zzc(2, zzb);
                }
            }
            return i;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (!this.type.equals("")) {
                zzrg.zzb(1, this.type);
            }
            if (this.zzawq != null && this.zzawq.length > 0) {
                for (int i = 0; i < this.zzawq.length; i++) {
                    zzb zzb = this.zzawq[i];
                    if (zzb != null) {
                        zzrg.zza(2, zzb);
                    }
                }
            }
            super.zza(zzrg);
        }

        /* renamed from: zzs */
        public zzc zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzrf.readString();
                        break;
                    case 18:
                        int zzb = zzrq.zzb(zzrf, 18);
                        int length = this.zzawq == null ? 0 : this.zzawq.length;
                        zzb[] zzbArr = new zzb[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzawq, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzrf.zza(zzbArr[length]);
                            zzrf.zzBr();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzrf.zza(zzbArr[length]);
                        this.zzawq = zzbArr;
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

        public zzc zztZ() {
            this.type = "";
            this.zzawq = zzb.zztX();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String zzabE;
        public boolean zzawr;
        public long zzaws;
        public double zzawt;
        public zzc zzawu;

        public zzd() {
            zzua();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) o;
            if (this.zzawr != zzd.zzawr) {
                return false;
            }
            if (this.zzabE == null) {
                if (zzd.zzabE != null) {
                    return false;
                }
            } else if (!this.zzabE.equals(zzd.zzabE)) {
                return false;
            }
            if (this.zzaws != zzd.zzaws || Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(zzd.zzawt)) {
                return false;
            }
            if (this.zzawu == null) {
                if (zzd.zzawu != null) {
                    return false;
                }
            } else if (!this.zzawu.equals(zzd.zzawu)) {
                return false;
            }
            return zza(zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzabE == null ? 0 : this.zzabE.hashCode()) + (((this.zzawr ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzaws ^ (this.zzaws >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzawt);
            int i2 = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzawu != null) {
                i = this.zzawu.hashCode();
            }
            return ((i2 + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB();
            if (this.zzawr) {
                zzB += zzrg.zzc(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzB += zzrg.zzk(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzB += zzrg.zzd(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrg.zzb(4, this.zzawt);
            }
            return this.zzawu != null ? zzB + zzrg.zzc(5, this.zzawu) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            if (this.zzawr) {
                zzrg.zzb(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzrg.zzb(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzrg.zzb(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzrg.zza(4, this.zzawt);
            }
            if (this.zzawu != null) {
                zzrg.zza(5, this.zzawu);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzt */
        public zzd zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        this.zzawr = zzrf.zzBv();
                        break;
                    case 18:
                        this.zzabE = zzrf.readString();
                        break;
                    case 24:
                        this.zzaws = zzrf.zzBt();
                        break;
                    case 33:
                        this.zzawt = zzrf.readDouble();
                        break;
                    case 42:
                        if (this.zzawu == null) {
                            this.zzawu = new zzc();
                        }
                        zzrf.zza(this.zzawu);
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

        public zzd zzua() {
            this.zzawr = false;
            this.zzabE = "";
            this.zzaws = 0;
            this.zzawt = 0.0d;
            this.zzawu = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
