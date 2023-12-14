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
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.internal.zzf;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzd extends zzi<zzf> {
    private final PlacesParams zzaAl;
    private final Locale zzaAm = Locale.getDefault();

    public static class zza implements Api.zza<zzd, PlacesOptions> {
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

        public zzd zza(Context context, Looper looper, zze zze, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zze, connectionCallbacks, onConnectionFailedListener, this.zzaAn != null ? this.zzaAn : context.getPackageName(), this.zzaAo != null ? this.zzaAo : context.getPackageName(), placesOptions == null ? new PlacesOptions.Builder().build() : placesOptions);
        }
    }

    public zzd(Context context, Looper looper, zze zze, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzaAl = new PlacesParams(str, this.zzaAm, zze.getAccount() != null ? zze.getAccount().name : null, placesOptions.zzazX, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public void zza(zzm zzm, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzu.zzb(addPlaceRequest, "userAddedPlace == null");
        ((zzf) zznM()).zza(addPlaceRequest, this.zzaAl, zzm);
    }

    public void zza(zzm zzm, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzu.zzb(str, "query == null");
        zzu.zzb(latLngBounds, "bounds == null");
        zzu.zzb(zzm, "callback == null");
        ((zzf) zznM()).zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaAl, zzm);
    }

    public void zza(zzm zzm, List<String> list) throws RemoteException {
        ((zzf) zznM()).zzb(list, this.zzaAl, zzm);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbY */
    public zzf zzT(IBinder iBinder) {
        return zzf.zza.zzca(iBinder);
    }
}
