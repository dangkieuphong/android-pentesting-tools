package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;

public final class zzkl {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", zzNY, zzNX, new Scope[0]);
    public static final Api.ClientKey<zzkp> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzkp, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzkp, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.internal.zzkl.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzg */
        public zzkp zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkp(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final zzkm zzabj = new zzkn();
}
