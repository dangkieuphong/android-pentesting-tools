package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placeFilter.zzazs, false);
        zzb.zzc(parcel, 1000, placeFilter.zzCY);
        zzb.zza(parcel, 3, placeFilter.zzazC);
        zzb.zzc(parcel, 4, placeFilter.zzazv, false);
        zzb.zzb(parcel, 6, placeFilter.zzazu, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzer */
    public PlaceFilter createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        ArrayList<String> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList3 = zza.zzB(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzaa, UserDataType.CREATOR);
                    break;
                case 6:
                    arrayList2 = zza.zzC(parcel, zzaa);
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
            return new PlaceFilter(i, arrayList3, z, arrayList2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgN */
    public PlaceFilter[] newArray(int i) {
        return new PlaceFilter[i];
    }
}
