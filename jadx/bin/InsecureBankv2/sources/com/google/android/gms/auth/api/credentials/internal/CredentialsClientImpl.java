package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.internal.ICredentialsService;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;

public final class CredentialsClientImpl extends zzi<ICredentialsService> {
    public static final String ACTION_START_SERVICE = "com.google.android.gms.auth.api.credentials.service.START";

    public CredentialsClientImpl(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionListener, GoogleApiClient.OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 68, connectionListener, connectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: createServiceInterface */
    public ICredentialsService zzT(IBinder binder) {
        return ICredentialsService.zza.zzaq(binder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return ACTION_START_SERVICE;
    }
}
