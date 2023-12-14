package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzf implements Parcelable.Creator<LocationResult> {
    static void zza(LocationResult locationResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, locationResult.getLocations(), false);
        zzb.zzc(parcel, 1000, locationResult.getVersionCode());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzee */
    public LocationResult createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List<Location> list = LocationResult.zzaxZ;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list = zza.zzc(parcel, zzaa, Location.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LocationResult(i, list);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgw */
    public LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}
