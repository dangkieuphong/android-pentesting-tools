package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<LatLngBounds> {
    static void zza(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, latLngBounds.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeO */
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int i;
        LatLng latLng3 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    latLng2 = latLng4;
                    i = zza.zzg(parcel, zzaa);
                    latLng = latLng3;
                    break;
                case 2:
                    LatLng latLng5 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    i = i2;
                    latLng = latLng3;
                    latLng2 = latLng5;
                    break;
                case 3:
                    latLng = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    latLng2 = latLng4;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    latLng = latLng3;
                    latLng2 = latLng4;
                    i = i2;
                    break;
            }
            i2 = i;
            latLng4 = latLng2;
            latLng3 = latLng;
        }
        if (parcel.dataPosition() == zzab) {
            return new LatLngBounds(i2, latLng4, latLng3);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzho */
    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }
}
