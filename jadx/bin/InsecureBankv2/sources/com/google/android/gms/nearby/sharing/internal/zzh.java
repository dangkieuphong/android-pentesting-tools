package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.nearby.sharing.zzd;

public final class zzh implements zzd {
    public static final Api.ClientKey<zze> zzNX = new Api.ClientKey<>();
    public static final Api.zza<zze, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zze, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.nearby.sharing.internal.zzh.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzr */
        public zze zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, connectionCallbacks, onConnectionFailedListener, zze);
        }
    };
}
