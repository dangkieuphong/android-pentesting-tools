package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzmu;

public class zzng extends zzmu.zza {
    private final zza.zzb<Status> zzOs;

    public zzng(zza.zzb<Status> zzb) {
        this.zzOs = zzb;
    }

    @Override // com.google.android.gms.internal.zzmu
    public void zzm(Status status) {
        this.zzOs.zzm(status);
    }
}
