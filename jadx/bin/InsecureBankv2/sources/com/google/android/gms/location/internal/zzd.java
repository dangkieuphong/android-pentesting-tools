package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).zzuw();
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzd(callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationCallback callback) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass9 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(callback);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(listener);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzb(request, callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationCallback callback, final Looper looper) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(LocationRequestInternal.zzb(request), callback, looper);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(request, listener, (Looper) null);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener, final Looper looper) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(request, listener, looper);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzb(mockLocation);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.FusedLocationProviderApi
    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.zzb(new zza(client) {
            /* class com.google.android.gms.location.internal.zzd.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzac(isMockMode);
                setResult(Status.zzXP);
            }
        });
    }
}
