package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<LocationSettingsResult> {
    static void zza(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) locationSettingsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, locationSettingsResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) locationSettingsResult.getLocationSettingsStates(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeg */
    public LocationSettingsResult createFromParcel(Parcel parcel) {
        LocationSettingsStates locationSettingsStates;
        Status status;
        int i;
        LocationSettingsStates locationSettingsStates2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    locationSettingsStates = locationSettingsStates2;
                    status = status3;
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) zza.zza(parcel, zzaa, LocationSettingsStates.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    locationSettingsStates = locationSettingsStates2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    locationSettingsStates = locationSettingsStates2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            locationSettingsStates2 = locationSettingsStates;
        }
        if (parcel.dataPosition() == zzab) {
            return new LocationSettingsResult(i2, status2, locationSettingsStates2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgy */
    public LocationSettingsResult[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
