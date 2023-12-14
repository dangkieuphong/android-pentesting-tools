package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.location.internal.zzj;

public class ActivityRecognition {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ActivityRecognition.API", zzNY, zzNX, new Scope[0]);
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final Api.ClientKey<zzj> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzj, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzj, Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.location.ActivityRecognition.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzo */
        public zzj zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    };

    public static abstract class zza<R extends Result> extends zza.AbstractC0027zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.zzNX, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
