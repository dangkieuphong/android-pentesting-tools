package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzpn;

public class zzpo extends zzi<zzpn> {
    public zzpo(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze) {
        super(context, context.getMainLooper(), 73, connectionCallbacks, onConnectionFailedListener, zze);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdB */
    public zzpn zzT(IBinder iBinder) {
        return zzpn.zza.zzdA(iBinder);
    }
}
