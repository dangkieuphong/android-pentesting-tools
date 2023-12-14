package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.nearby.sharing.internal.zzd;

/* access modifiers changed from: package-private */
public class zze extends zzi<zzd> {
    public zze(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zze zze) {
        super(context, looper, 49, connectionCallbacks, onConnectionFailedListener, zze);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdl */
    public zzd zzT(IBinder iBinder) {
        return zzd.zza.zzdk(iBinder);
    }
}
