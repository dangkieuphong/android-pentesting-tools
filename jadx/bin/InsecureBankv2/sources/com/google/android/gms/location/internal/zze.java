package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zze;
import java.util.List;

public class zze implements GeofencingApi {

    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zze.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(geofencingRequest, pendingIntent, new zze.zza() {
                    /* class com.google.android.gms.location.internal.zze.AnonymousClass1.AnonymousClass1 */

                    @Override // com.google.android.gms.location.zze.zza
                    public void zza(int i, String[] strArr) {
                        AnonymousClass1.this.setResult(LocationStatusCodes.zzgB(i));
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zze.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(pendingIntent, new zze.zzb() {
                    /* class com.google.android.gms.location.internal.zze.AnonymousClass2.AnonymousClass1 */

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zza(int i, PendingIntent pendingIntent) {
                        AnonymousClass2.this.setResult(LocationStatusCodes.zzgB(i));
                    }

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zzb(int i, String[] strArr) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zze.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(geofenceRequestIds, new zze.zzb() {
                    /* class com.google.android.gms.location.internal.zze.AnonymousClass3.AnonymousClass1 */

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zza(int i, PendingIntent pendingIntent) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zzb(int i, String[] strArr) {
                        AnonymousClass3.this.setResult(LocationStatusCodes.zzgB(i));
                    }
                });
            }
        });
    }
}
