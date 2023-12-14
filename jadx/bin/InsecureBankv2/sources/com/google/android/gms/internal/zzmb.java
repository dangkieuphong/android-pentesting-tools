package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.internal.zzmm;

public class zzmb extends zzlw<zzmm> {

    static abstract class zza<R extends Result> extends zza.AbstractC0027zza<R, zzmb> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzajA, googleApiClient);
        }
    }

    public static class zzb implements Api.zza<zzmb, Api.ApiOptions.NoOptions> {
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzl */
        public zzmb zza(Context context, Looper looper, zze zze, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmb(context, looper, zze, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            zzu.zzV(!status.isSuccess());
            return status;
        }
    }

    public zzmb(Context context, Looper looper, zze zze, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 56, connectionCallbacks, onConnectionFailedListener, zze);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.fitness.RecordingApi";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbm */
    public zzmm zzT(IBinder iBinder) {
        return zzmm.zza.zzbx(iBinder);
    }
}
