package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, latLng.getVersionCode());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeP */
    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int zzab = zza.zzab(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    d2 = zza.zzm(parcel, zzaa);
                    break;
                case 3:
                    d = zza.zzm(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LatLng(i, d2, d);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhp */
    public LatLng[] newArray(int i) {
        return new LatLng[i];
    }
}
