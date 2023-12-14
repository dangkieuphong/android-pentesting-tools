package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import com.google.android.gms.ads.internal.request.zzi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zze extends zzi<zzi> {
    final int zzCk;

    public zze(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, context.getMainLooper(), 8, connectionCallbacks, onConnectionFailedListener);
        this.zzCk = i;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzS */
    public zzi zzT(IBinder iBinder) {
        return zzi.zza.zzU(iBinder);
    }

    public zzi zzfy() throws DeadObjectException {
        return (zzi) super.zznM();
    }
}
