package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzjl;

public final class zzjj extends zzi<zzjl> {
    private final Bundle zzOR;

    public zzjj(Context context, Looper looper, zze zze, Auth.zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzOR = zza == null ? new Bundle() : zza.zzkY();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresSignIn() {
        zze zznK = zznK();
        return !TextUtils.isEmpty(zznK.getAccountName()) && !zznK.zzb(Auth.zzOL).isEmpty();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzar */
    public zzjl zzT(IBinder iBinder) {
        return zzjl.zza.zzat(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Bundle zzkR() {
        return this.zzOR;
    }
}
