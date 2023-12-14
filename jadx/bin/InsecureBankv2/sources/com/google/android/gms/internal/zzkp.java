package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzkr;

public class zzkp extends zzi<zzkr> {
    public zzkp(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.common.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaK */
    public zzkr zzT(IBinder iBinder) {
        return zzkr.zza.zzaM(iBinder);
    }
}
