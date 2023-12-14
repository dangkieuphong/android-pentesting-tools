package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.fitness.zza;
import java.util.Set;

public abstract class zzlw<T extends IInterface> extends zzi<T> {
    protected zzlw(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zze zze) {
        super(context, looper, i, connectionCallbacks, onConnectionFailedListener, zze);
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresSignIn() {
        return !zzlv.zzam(getContext());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Set<Scope> zza(Set<Scope> set) {
        return zza.zzd(set);
    }
}
