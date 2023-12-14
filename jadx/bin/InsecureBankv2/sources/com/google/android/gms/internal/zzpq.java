package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.signin.internal.zzg;
import com.google.android.gms.signin.internal.zzh;
import java.util.concurrent.Executors;

public final class zzpq {
    public static final Api<zzpt> API = new Api<>("SignIn.API", zzNY, zzNX, new Scope[0]);
    public static final Api.ClientKey<zzh> zzNX = new Api.ClientKey<>();
    public static final Api.zza<zzh, zzpt> zzNY = new Api.zza<zzh, zzpt>() {
        /* class com.google.android.gms.internal.zzpq.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzh zza(Context context, Looper looper, zze zze, zzpt zzpt, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, true, zze, zzpt == null ? zzpt.zzaJQ : zzpt, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    };
    static final Api.zza<zzh, Api.ApiOptions.NoOptions> zzaJO = new Api.zza<zzh, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.internal.zzpq.AnonymousClass2 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzv */
        public zzh zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzh(context, looper, false, zze, zzpt.zzaJQ, connectionCallbacks, onConnectionFailedListener, Executors.newSingleThreadExecutor());
        }
    };
    public static final zzpr zzaJP = new zzg();
    public static final Api<Api.ApiOptions.NoOptions> zzada = new Api<>("SignIn.INTERNAL_API", zzaJO, zzajz, new Scope[0]);
    public static final Api.ClientKey<zzh> zzajz = new Api.ClientKey<>();
}
