package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.nearby.messages.internal.zzc;

/* access modifiers changed from: package-private */
public class zzf extends zzi<zzc> {
    private String zzOe;
    private String zzaGa;

    zzf(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze, com.google.android.gms.nearby.messages.zze zze2) {
        super(context, looper, 62, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzOe = zze.zzny();
        if (zze2 != null) {
            this.zzaGa = zze2.zzayp;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresAccount() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdg */
    public zzc zzT(IBinder iBinder) {
        return zzc.zza.zzdf(iBinder);
    }
}
