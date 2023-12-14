package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzf();
    static final List<Location> zzaxZ = Collections.emptyList();
    private final int zzCY;
    private final List<Location> zzaya;

    LocationResult(int versionCode, List<Location> locations) {
        this.zzCY = versionCode;
        this.zzaya = locations;
    }

    public static LocationResult create(List<Location> locations) {
        if (locations == null) {
            locations = zzaxZ;
        }
        return new LocationResult(2, locations);
    }

    public static LocationResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        return (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) other;
        if (locationResult.zzaya.size() != this.zzaya.size()) {
            return false;
        }
        Iterator<Location> it = this.zzaya.iterator();
        for (Location location : locationResult.zzaya) {
            if (it.next().getTime() != location.getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzaya.size();
        if (size == 0) {
            return null;
        }
        return this.zzaya.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzaya;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        int i = 17;
        for (Location location : this.zzaya) {
            long time = location.getTime();
            i = ((int) (time ^ (time >>> 32))) + (i * 31);
        }
        return i;
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaya + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }
}
