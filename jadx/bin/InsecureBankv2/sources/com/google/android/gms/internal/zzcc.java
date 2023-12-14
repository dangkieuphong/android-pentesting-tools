package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;

public class zzcc {
    private boolean zzuy = false;

    private zzcb zzb(zzca zzca, int i) {
        zzcb zzcb = new zzcb(zzca.getContext(), zzca.zzbR(), zzca.zzdd(), zzca.zzde(), zzca.zzdf(), zzca.zzdg(), zzca.zzdh(), zzca.zzdi(), i);
        this.zzuy = true;
        return zzcb;
    }

    public zzcb zza(zzca zzca) {
        return zza(zzca, 1);
    }

    public zzcb zza(zzca zzca, int i) {
        if (zzca == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!zzca.zzdc()) {
            zzb.zzaA("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (zzca.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzca.zzbR())) {
            return zzb(zzca, i);
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }

    public zzcb zzb(zzca zzca) {
        return zza(zzca, 2);
    }

    public boolean zzdc() {
        return this.zzuy;
    }
}
