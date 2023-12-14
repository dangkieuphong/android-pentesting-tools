package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.wearable.internal.zzav;
import com.google.android.gms.wearable.internal.zzax;
import com.google.android.gms.wearable.internal.zzbi;
import com.google.android.gms.wearable.internal.zzbk;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzd;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzt;
import com.google.android.gms.wearable.internal.zzu;

public class Wearable {
    public static final Api<WearableOptions> API = new Api<>("Wearable.API", zzNY, zzNX, new Scope[0]);
    public static final CapabilityApi CapabilityApi = new zzg();
    public static final ChannelApi ChannelApi = new zzi();
    public static final DataApi DataApi = new zzu();
    public static final MessageApi MessageApi = new zzav();
    public static final NodeApi NodeApi = new zzax();
    public static final Api.ClientKey<zzbk> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzbk, WearableOptions> zzNY = new Api.zza<zzbk, WearableOptions>() {
        /* class com.google.android.gms.wearable.Wearable.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzbk zza(Context context, Looper looper, zze zze, WearableOptions wearableOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                new WearableOptions(new WearableOptions.Builder());
            }
            return new zzbk(context, looper, connectionCallbacks, onConnectionFailedListener, zze);
        }
    };
    public static final zza zzaSZ = new zzd();
    public static final zzd zzaTa = new zzt();
    public static final zzg zzaTb = new zzbi();
    public static final zzi zzaTc = new zzbm();

    public static final class WearableOptions implements Api.ApiOptions.Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions(this);
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
