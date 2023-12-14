package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.messages.zze;

public class zzg implements zzc {
    public static final Api.ClientKey<zzf> zzNX = new Api.ClientKey<>();
    public static final Api.zza<zzf, zze> zzNY = new Api.zza<zzf, zze>() {
        /* class com.google.android.gms.nearby.messages.internal.zzg.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zze, zze zze2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, connectionCallbacks, onConnectionFailedListener, zze, zze2);
        }
    };
}
