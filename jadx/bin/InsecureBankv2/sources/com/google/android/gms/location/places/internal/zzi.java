package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;

public class zzi implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzm.zzd<zzj>(Places.zzazR, client) {
            /* class com.google.android.gms.location.places.internal.zzi.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(new zzm(this, zzj.getContext()), filter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzm.zzf<zzj>(Places.zzazR, client) {
            /* class com.google.android.gms.location.places.internal.zzi.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(new zzm(this), report);
            }
        });
    }
}
