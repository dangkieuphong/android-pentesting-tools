package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Arrays;

public class zzc implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient client, final AddPlaceRequest addPlaceRequest) {
        return client.zzb(new zzm.zzc<zzd>(Places.zzazQ, client) {
            /* class com.google.android.gms.location.places.internal.zzc.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                zzd.zza(new zzm(this, zzd.getContext()), addPlaceRequest);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient client, final String query, final LatLngBounds bounds, final AutocompleteFilter filter) {
        return client.zza(new zzm.zza<zzd>(Places.zzazQ, client) {
            /* class com.google.android.gms.location.places.internal.zzc.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                zzd.zza(new zzm(this), query, bounds, filter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> getPlaceById(GoogleApiClient client, final String... placeIds) {
        boolean z = true;
        if (placeIds == null || placeIds.length < 1) {
            z = false;
        }
        zzu.zzV(z);
        return client.zza(new zzm.zzc<zzd>(Places.zzazQ, client) {
            /* class com.google.android.gms.location.places.internal.zzc.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                zzd.zza(new zzm(this, zzd.getContext()), Arrays.asList(placeIds));
            }
        });
    }
}
