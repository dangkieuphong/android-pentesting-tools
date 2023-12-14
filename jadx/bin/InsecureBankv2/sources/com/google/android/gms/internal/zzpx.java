package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf;
import java.io.IOException;

public interface zzpx {

    public static final class zza extends zzrh<zza> {
        public long zzaOZ;
        public zzaf.zzj zzaPa;
        public zzaf.zzf zziO;

        public zza() {
            zzzY();
        }

        public static zza zzs(byte[] bArr) throws zzrm {
            return (zza) zzrn.zza(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            if (this.zzaOZ != zza.zzaOZ) {
                return false;
            }
            if (this.zziO == null) {
                if (zza.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zza.zziO)) {
                return false;
            }
            if (this.zzaPa == null) {
                if (zza.zzaPa != null) {
                    return false;
                }
            } else if (!this.zzaPa.equals(zza.zzaPa)) {
                return false;
            }
            return zza(zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziO == null ? 0 : this.zziO.hashCode()) + ((((int) (this.zzaOZ ^ (this.zzaOZ >>> 32))) + 527) * 31)) * 31;
            if (this.zzaPa != null) {
                i = this.zzaPa.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public int zzB() {
            int zzB = super.zzB() + zzrg.zzd(1, this.zzaOZ);
            if (this.zziO != null) {
                zzB += zzrg.zzc(2, this.zziO);
            }
            return this.zzaPa != null ? zzB + zzrg.zzc(3, this.zzaPa) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrg) throws IOException {
            zzrg.zzb(1, this.zzaOZ);
            if (this.zziO != null) {
                zzrg.zza(2, this.zziO);
            }
            if (this.zzaPa != null) {
                zzrg.zza(3, this.zzaPa);
            }
            super.zza(zzrg);
        }

        /* renamed from: zzu */
        public zza zzb(zzrf zzrf) throws IOException {
            while (true) {
                int zzBr = zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        this.zzaOZ = zzrf.zzBt();
                        break;
                    case 18:
                        if (this.zziO == null) {
                            this.zziO = new zzaf.zzf();
                        }
                        zzrf.zza(this.zziO);
                        break;
                    case 26:
                        if (this.zzaPa == null) {
                            this.zzaPa = new zzaf.zzj();
                        }
                        zzrf.zza(this.zzaPa);
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

        public zza zzzY() {
            this.zzaOZ = 0;
            this.zziO = null;
            this.zzaPa = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
