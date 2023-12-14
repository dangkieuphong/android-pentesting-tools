package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzir;

public abstract class zzis<T> extends zzir.zza {
    protected zza.zzb<T> zzNO;

    public zzis(zza.zzb<T> zzb) {
        this.zzNO = zzb;
    }

    @Override // com.google.android.gms.internal.zzir
    public void zza(GetRecentContextCall.Response response) {
    }

    @Override // com.google.android.gms.internal.zzir
    public void zza(Status status) {
    }

    @Override // com.google.android.gms.internal.zzir
    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    @Override // com.google.android.gms.internal.zzir
    public void zza(Status status, boolean z) {
    }
}
