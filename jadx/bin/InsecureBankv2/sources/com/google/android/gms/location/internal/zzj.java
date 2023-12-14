package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import com.google.android.gms.location.internal.zzf;
import com.google.android.gms.location.internal.zzh;
import com.google.android.gms.location.zze;
import java.util.List;

public class zzj extends zzb {
    private final zzi zzayR;
    private final com.google.android.gms.location.copresence.internal.zzb zzayS;

    private final class zza extends zzi<zzg>.zzc {
        private final int zzTS;
        private final String[] zzayT;

        public zza(zze.zza zza, int i, String[] strArr) {
            super(zza);
            this.zzTS = LocationStatusCodes.zzgA(i);
            this.zzayT = strArr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void zzr(zze.zza zza) {
            if (zza != null) {
                zza.zza(this.zzTS, this.zzayT);
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.zzi.zzc
        public void zznP() {
        }
    }

    private static final class zzb extends zzf.zza {
        private zze.zza zzayV;
        private zze.zzb zzayW;
        private zzj zzayX;

        public zzb(zze.zza zza, zzj zzj) {
            this.zzayV = zza;
            this.zzayW = null;
            this.zzayX = zzj;
        }

        public zzb(zze.zzb zzb, zzj zzj) {
            this.zzayW = zzb;
            this.zzayV = null;
            this.zzayX = zzj;
        }

        @Override // com.google.android.gms.location.internal.zzf
        public void zza(int i, PendingIntent pendingIntent) {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            zzj zzj = this.zzayX;
            zzj zzj2 = this.zzayX;
            zzj2.getClass();
            zzj.zza(new zzc(zzj2, 1, this.zzayW, i, pendingIntent));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }

        @Override // com.google.android.gms.location.internal.zzf
        public void zza(int i, String[] strArr) throws RemoteException {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            zzj zzj = this.zzayX;
            zzj zzj2 = this.zzayX;
            zzj2.getClass();
            zzj.zza(new zza(this.zzayV, i, strArr));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }

        @Override // com.google.android.gms.location.internal.zzf
        public void zzb(int i, String[] strArr) {
            if (this.zzayX == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            zzj zzj = this.zzayX;
            zzj zzj2 = this.zzayX;
            zzj2.getClass();
            zzj.zza(new zzc(2, this.zzayW, i, strArr));
            this.zzayX = null;
            this.zzayV = null;
            this.zzayW = null;
        }
    }

    private final class zzc extends zzi<zzg>.zzc {
        private final PendingIntent mPendingIntent;
        private final int zzTS;
        private final String[] zzayT;
        private final int zzayY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public zzc(zzj zzj, int i, zze.zzb zzb, int i2, PendingIntent pendingIntent) {
            super(zzb);
            boolean z = true;
            zzj.this = zzj;
            com.google.android.gms.common.internal.zzb.zzU(i != 1 ? false : z);
            this.zzayY = i;
            this.zzTS = LocationStatusCodes.zzgA(i2);
            this.mPendingIntent = pendingIntent;
            this.zzayT = null;
        }

        public zzc(int i, zze.zzb zzb, int i2, String[] strArr) {
            super(zzb);
            com.google.android.gms.common.internal.zzb.zzU(i == 2);
            this.zzayY = i;
            this.zzTS = LocationStatusCodes.zzgA(i2);
            this.zzayT = strArr;
            this.mPendingIntent = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void zzr(zze.zzb zzb) {
            if (zzb != null) {
                switch (this.zzayY) {
                    case 1:
                        zzb.zza(this.zzTS, this.mPendingIntent);
                        return;
                    case 2:
                        zzb.zzb(this.zzTS, this.zzayT);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.zzayY);
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.zzi.zzc
        public void zznP() {
        }
    }

    private static final class zzd extends zzh.zza {
        private zza.zzb<LocationSettingsResult> zzayZ;

        public zzd(zza.zzb<LocationSettingsResult> zzb) {
            zzu.zzb(zzb != null, "listener can't be null.");
            this.zzayZ = zzb;
        }

        @Override // com.google.android.gms.location.internal.zzh
        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzayZ.zzm(locationSettingsResult);
            this.zzayZ = null;
        }
    }

    public zzj(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, new GoogleApiClient.Builder(context).zzmx());
    }

    public zzj(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zze zze) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, zze, CopresenceApiOptions.zzayn);
    }

    public zzj(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zze zze, CopresenceApiOptions copresenceApiOptions) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zze);
        this.zzayR = new zzi(context, this.zzayq);
        this.zzayS = com.google.android.gms.location.copresence.internal.zzb.zza(context, zze.getAccountName(), zze.zzny(), this.zzayq, copresenceApiOptions);
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        synchronized (this.zzayR) {
            if (isConnected()) {
                try {
                    this.zzayR.removeAllListeners();
                    this.zzayR.zzux();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.zzayR.getLastLocation();
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresAccount() {
        return true;
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zznL();
        zzu.zzu(pendingIntent);
        zzu.zzb(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzg) zznM()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zznL();
        zzu.zzu(pendingIntent);
        ((zzg) zznM()).zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, zze.zzb zzb2) throws RemoteException {
        zznL();
        zzu.zzb(pendingIntent, "PendingIntent must be specified.");
        zzu.zzb(zzb2, "OnRemoveGeofencesResultListener not provided.");
        ((zzg) zznM()).zza(pendingIntent, zzb2 == null ? null : new zzb(zzb2, this), getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zze.zza zza2) throws RemoteException {
        zznL();
        zzu.zzb(geofencingRequest, "geofencingRequest can't be null.");
        zzu.zzb(pendingIntent, "PendingIntent must be specified.");
        zzu.zzb(zza2, "OnAddGeofencesResultListener not provided.");
        ((zzg) zznM()).zza(geofencingRequest, pendingIntent, zza2 == null ? null : new zzb(zza2, this));
    }

    public void zza(LocationCallback locationCallback) throws RemoteException {
        this.zzayR.zza(locationCallback);
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzayR.zza(locationListener);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.zzayR) {
            this.zzayR.zza(locationRequest, locationListener, looper);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, zza.zzb<LocationSettingsResult> zzb2, String str) throws RemoteException {
        boolean z = true;
        zznL();
        zzu.zzb(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (zzb2 == null) {
            z = false;
        }
        zzu.zzb(z, "listener can't be null.");
        ((zzg) zznM()).zza(locationSettingsRequest, new zzd(zzb2), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper) throws RemoteException {
        synchronized (this.zzayR) {
            this.zzayR.zza(locationRequestInternal, locationCallback, looper);
        }
    }

    public void zza(List<String> list, zze.zzb zzb2) throws RemoteException {
        zznL();
        zzu.zzb(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        zzu.zzb(zzb2, "OnRemoveGeofencesResultListener not provided.");
        ((zzg) zznM()).zza((String[]) list.toArray(new String[0]), zzb2 == null ? null : new zzb(zzb2, this), getContext().getPackageName());
    }

    public void zzac(boolean z) throws RemoteException {
        this.zzayR.zzac(z);
    }

    public void zzb(Location location) throws RemoteException {
        this.zzayR.zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzayR.zzb(locationRequest, pendingIntent);
    }

    public void zzd(PendingIntent pendingIntent) throws RemoteException {
        this.zzayR.zzd(pendingIntent);
    }

    public LocationAvailability zzuw() {
        return this.zzayR.zzuw();
    }
}
