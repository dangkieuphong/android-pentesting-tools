package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzpi;

public class zzpk extends zzi<zzpi> {
    public zzpk(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.safetynet.service.START";
    }

    public void zza(zzph zzph, byte[] bArr) throws RemoteException {
        ((zzpi) zznM()).zza(zzph, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdy */
    public zzpi zzT(IBinder iBinder) {
        return zzpi.zza.zzdx(iBinder);
    }
}
