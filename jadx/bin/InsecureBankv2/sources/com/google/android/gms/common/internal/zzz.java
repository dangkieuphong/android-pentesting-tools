package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzz<T extends IInterface> extends zzi<T> {
    private final Api.zzb<T> zzabf;

    public zzz(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze, Api.zzb zzb) {
        super(context, looper, i, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzabf = zzb;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return this.zzabf.getServiceDescriptor();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return this.zzabf.getStartServiceAction();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public T zzT(IBinder iBinder) {
        return this.zzabf.zzT(iBinder);
    }
}
