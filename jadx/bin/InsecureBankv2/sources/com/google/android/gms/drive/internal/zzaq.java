package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;

public final class zzaq extends zzrh<zzaq> {
    public int versionCode;
    public long zzafU;
    public long zzafV;
    public long zzafW;

    public zzaq() {
        zzpG();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzaq)) {
            return false;
        }
        zzaq zzaq = (zzaq) o;
        if (this.versionCode == zzaq.versionCode && this.zzafU == zzaq.zzafU && this.zzafV == zzaq.zzafV && this.zzafW == zzaq.zzafW) {
            return zza(zzaq);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzafU ^ (this.zzafU >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + ((int) (this.zzafW ^ (this.zzafW >>> 32)))) * 31) + zzBI();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public int zzB() {
        return super.zzB() + zzrg.zzA(1, this.versionCode) + zzrg.zze(2, this.zzafU) + zzrg.zze(3, this.zzafV) + zzrg.zze(4, this.zzafW);
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrg) throws IOException {
        zzrg.zzy(1, this.versionCode);
        zzrg.zzc(2, this.zzafU);
        zzrg.zzc(3, this.zzafV);
        zzrg.zzc(4, this.zzafW);
        super.zza(zzrg);
    }

    /* renamed from: zzm */
    public zzaq zzb(zzrf zzrf) throws IOException {
        while (true) {
            int zzBr = zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzrf.zzBu();
                    break;
                case 16:
                    this.zzafU = zzrf.zzBx();
                    break;
                case 24:
                    this.zzafV = zzrf.zzBx();
                    break;
                case 32:
                    this.zzafW = zzrf.zzBx();
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

    public zzaq zzpG() {
        this.versionCode = 1;
        this.zzafU = -1;
        this.zzafV = -1;
        this.zzafW = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
