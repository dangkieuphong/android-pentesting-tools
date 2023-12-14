package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import java.io.IOException;

public final class zzar extends zzrh<zzar> {
    public int versionCode;
    public long zzafV;
    public String zzafX;
    public long zzafY;
    public int zzafZ;

    public zzar() {
        zzpH();
    }

    public static zzar zzl(byte[] bArr) throws zzrm {
        return (zzar) zzrn.zza(new zzar(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzar)) {
            return false;
        }
        zzar zzar = (zzar) o;
        if (this.versionCode != zzar.versionCode) {
            return false;
        }
        if (this.zzafX == null) {
            if (zzar.zzafX != null) {
                return false;
            }
        } else if (!this.zzafX.equals(zzar.zzafX)) {
            return false;
        }
        if (this.zzafY == zzar.zzafY && this.zzafV == zzar.zzafV && this.zzafZ == zzar.zzafZ) {
            return zza(zzar);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.zzafX == null ? 0 : this.zzafX.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzafY ^ (this.zzafY >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + this.zzafZ) * 31) + zzBI();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public int zzB() {
        int zzB = super.zzB() + zzrg.zzA(1, this.versionCode) + zzrg.zzk(2, this.zzafX) + zzrg.zze(3, this.zzafY) + zzrg.zze(4, this.zzafV);
        return this.zzafZ != -1 ? zzB + zzrg.zzA(5, this.zzafZ) : zzB;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrg) throws IOException {
        zzrg.zzy(1, this.versionCode);
        zzrg.zzb(2, this.zzafX);
        zzrg.zzc(3, this.zzafY);
        zzrg.zzc(4, this.zzafV);
        if (this.zzafZ != -1) {
            zzrg.zzy(5, this.zzafZ);
        }
        super.zza(zzrg);
    }

    /* renamed from: zzn */
    public zzar zzb(zzrf zzrf) throws IOException {
        while (true) {
            int zzBr = zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.versionCode = zzrf.zzBu();
                    break;
                case 18:
                    this.zzafX = zzrf.readString();
                    break;
                case 24:
                    this.zzafY = zzrf.zzBx();
                    break;
                case 32:
                    this.zzafV = zzrf.zzBx();
                    break;
                case 40:
                    this.zzafZ = zzrf.zzBu();
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

    public zzar zzpH() {
        this.versionCode = 1;
        this.zzafX = "";
        this.zzafY = -1;
        this.zzafV = -1;
        this.zzafZ = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
