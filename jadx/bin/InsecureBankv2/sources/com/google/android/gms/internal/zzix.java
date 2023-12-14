package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zziz;

public class zzix extends zzi<zziz> {
    private final String zzOd;
    private final String zzOe;

    public zzix(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze) {
        super(context, looper, 77, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzOd = zze.zznz();
        this.zzOe = zze.zzny();
    }

    private Bundle zzkS() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzOe);
        return bundle;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.appinvite.service.START";
    }

    public void zza(zziy zziy, String str) {
        try {
            ((zziz) zznM()).zza(zziy, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzag */
    public zziz zzT(IBinder iBinder) {
        return zziz.zza.zzai(iBinder);
    }

    public void zzb(zziy zziy, String str) {
        try {
            ((zziz) zznM()).zzb(zziy, str);
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String zzkQ() {
        return this.zzOd;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Bundle zzkR() {
        return zzkS();
    }
}
