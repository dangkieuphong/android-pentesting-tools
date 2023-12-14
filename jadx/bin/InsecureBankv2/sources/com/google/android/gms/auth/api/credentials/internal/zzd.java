package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zza;

/* access modifiers changed from: package-private */
public abstract class zzd<R extends Result> extends zza.AbstractC0027zza<R, CredentialsClientImpl> {
    zzd(GoogleApiClient googleApiClient) {
        super(Auth.CLIENT_KEY_CREDENTIALS_API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, ICredentialsService iCredentialsService) throws DeadObjectException, RemoteException;

    /* access modifiers changed from: protected */
    public final void zza(CredentialsClientImpl credentialsClientImpl) throws DeadObjectException, RemoteException {
        zza(credentialsClientImpl.getContext(), (ICredentialsService) credentialsClientImpl.zznM());
    }
}
