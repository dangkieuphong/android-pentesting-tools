package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;

public final class zzas extends zzrh<zzas> {
    public long zzafV;
    public long zzafY;

    public zzas() {
        zzpI();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas zzas = (zzas) o;
        if (this.zzafY == zzas.zzafY && this.zzafV == zzas.zzafV) {
            return zza(zzas);
        }
        return false;
    }

    public int hashCode() {
        return ((((((int) (this.zzafY ^ (this.zzafY >>> 32))) + 527) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + zzBI();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public int zzB() {
        return super.zzB() + zzrg.zze(1, this.zzafY) + zzrg.zze(2, this.zzafV);
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrg) throws IOException {
        zzrg.zzc(1, this.zzafY);
        zzrg.zzc(2, this.zzafV);
        super.zza(zzrg);
    }

    /* renamed from: zzo */
    public zzas zzb(zzrf zzrf) throws IOException {
        while (true) {
            int zzBr = zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.zzafY = zzrf.zzBx();
                    break;
                case 16:
                    this.zzafV = zzrf.zzBx();
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

    public zzas zzpI() {
        this.zzafY = -1;
        this.zzafV = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
