package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs implements Parcelable.Creator<PlacesParams> {
    static void zza(PlacesParams placesParams, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placesParams.zzaAZ, false);
        zzb.zzc(parcel, 1000, placesParams.versionCode);
        zzb.zza(parcel, 2, placesParams.zzaBa, false);
        zzb.zza(parcel, 3, placesParams.zzaBb, false);
        zzb.zza(parcel, 4, placesParams.zzazX, false);
        zzb.zza(parcel, 5, placesParams.zzaBc, false);
        zzb.zzc(parcel, 6, placesParams.zzaBd);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeB */
    public PlacesParams createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str5 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PlacesParams(i2, str5, str4, str3, str2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhb */
    public PlacesParams[] newArray(int i) {
        return new PlacesParams[i];
    }
}
