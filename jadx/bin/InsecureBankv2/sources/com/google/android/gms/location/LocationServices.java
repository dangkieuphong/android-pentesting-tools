package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zze;
import com.google.android.gms.location.internal.zzj;
import com.google.android.gms.location.internal.zzo;

public class LocationServices {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("LocationServices.API", zzNY, zzNX, new Scope[0]);
    public static final FusedLocationProviderApi FusedLocationApi = new zzd();
    public static final GeofencingApi GeofencingApi = new zze();
    public static final SettingsApi SettingsApi = new zzo();
    private static final Api.ClientKey<zzj> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzj, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzj, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.location.LocationServices.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzo */
        public zzj zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zze);
        }
    };

    public static abstract class zza<R extends Result> extends zza.AbstractC0027zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzNX, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzj zze(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzu.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzj zzj = (zzj) googleApiClient.zza(zzNX);
        if (zzj == null) {
            z = false;
        }
        zzu.zza(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzj;
    }
}
