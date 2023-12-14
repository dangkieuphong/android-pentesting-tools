package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    PendingIntent mPendingIntent;
    private final int zzCY;
    int zzazf;
    LocationRequestInternal zzazg;
    zzd zzazh;
    zzc zzazi;

    LocationRequestUpdateData(int versionCode, int operation, LocationRequestInternal locationRequest, IBinder locationListenerBinder, PendingIntent pendingIntent, IBinder locationCallbackBinder) {
        zzc zzc = null;
        this.zzCY = versionCode;
        this.zzazf = operation;
        this.zzazg = locationRequest;
        this.zzazh = locationListenerBinder == null ? null : zzd.zza.zzbT(locationListenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzazi = locationCallbackBinder != null ? zzc.zza.zzbS(locationCallbackBinder) : zzc;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc zzc) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzc.asBinder());
    }

    public static LocationRequestUpdateData zza(zzc zzc) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzc.asBinder());
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null);
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, zzd zzd) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zzb(zzd zzd) {
        return new LocationRequestUpdateData(1, 2, null, zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zze(PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzuy() {
        if (this.zzazh == null) {
            return null;
        }
        return this.zzazh.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzuz() {
        if (this.zzazi == null) {
            return null;
        }
        return this.zzazi.asBinder();
    }
}
