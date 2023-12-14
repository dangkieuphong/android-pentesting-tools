package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzow;

public final class Panorama {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Panorama.API", zzNY, zzNX, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new zzov();
    public static final Api.ClientKey<zzow> zzNX = new Api.ClientKey<>();
    static final Api.zza<zzow, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzow, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.panorama.Panorama.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzs */
        public zzow zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzow(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private Panorama() {
    }
}
