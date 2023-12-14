package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zze;
import com.google.android.gms.location.places.zzm;
import java.util.Locale;

public class zzj extends zzi<zze> {
    private final PlacesParams zzaAl;
    private final Locale zzaAm = Locale.getDefault();

    public static class zza implements Api.zza<zzj, PlacesOptions> {
        private final String zzaAn;
        private final String zzaAo;

        public zza(String str, String str2) {
            this.zzaAn = str;
            this.zzaAo = str2;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* renamed from: zzb */
        public zzj zza(Context context, Looper looper, zze zze, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, zze, connectionCallbacks, onConnectionFailedListener, this.zzaAn != null ? this.zzaAn : context.getPackageName(), this.zzaAo != null ? this.zzaAo : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zzj(Context context, Looper looper, zze zze, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzaAl = new PlacesParams(str, this.zzaAm, zze.getAccount() != null ? zze.getAccount().name : null, placesOptions.zzazX, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    public void zza(zzm zzm, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzuJ();
        }
        ((zze) zznM()).zza(placeFilter, this.zzaAl, zzm);
    }

    public void zza(zzm zzm, PlaceReport placeReport) throws RemoteException {
        zzu.zzu(placeReport);
        ((zze) zznM()).zza(placeReport, this.zzaAl, zzm);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcd */
    public zze zzT(IBinder iBinder) {
        return zze.zza.zzbZ(iBinder);
    }
}
