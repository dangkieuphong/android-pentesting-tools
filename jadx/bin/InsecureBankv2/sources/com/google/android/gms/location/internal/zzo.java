package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.SettingsApi;

public class zzo implements SettingsApi {
    @Override // com.google.android.gms.location.SettingsApi
    public PendingResult<LocationSettingsResult> checkLocationSettings(GoogleApiClient client, LocationSettingsRequest request) {
        return zza(client, request, null);
    }

    public PendingResult<LocationSettingsResult> zza(GoogleApiClient googleApiClient, final LocationSettingsRequest locationSettingsRequest, final String str) {
        return googleApiClient.zza(new LocationServices.zza<LocationSettingsResult>(googleApiClient) {
            /* class com.google.android.gms.location.internal.zzo.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(locationSettingsRequest, this, str);
            }

            /* renamed from: zzaE */
            public LocationSettingsResult createFailedResult(Status status) {
                return new LocationSettingsResult(status);
            }
        });
    }
}
