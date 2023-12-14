package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Parcelable.Creator<VisibleRegion> {
    static void zza(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, visibleRegion.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        zzb.zza(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        zzb.zza(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        zzb.zza(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        zzb.zza(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeZ */
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    latLng4 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzaa, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhz */
    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }
}
