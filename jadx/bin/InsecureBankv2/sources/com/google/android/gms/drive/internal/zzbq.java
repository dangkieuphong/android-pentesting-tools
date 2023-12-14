package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;

public class zzbq extends zzd {
    private final zza.zzb<Status> zzOs;

    public zzbq(zza.zzb<Status> zzb) {
        this.zzOs = zzb;
    }

    @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
    public void onSuccess() throws RemoteException {
        this.zzOs.zzm(Status.zzXP);
    }

    @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
    public void zzt(Status status) throws RemoteException {
        this.zzOs.zzm(status);
    }
}
