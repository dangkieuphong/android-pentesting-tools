package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.ArrayList;

public class zze implements Parcelable.Creator<PlaceUserData> {
    static void zza(PlaceUserData placeUserData, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placeUserData.zzvb(), false);
        zzb.zzc(parcel, 1000, placeUserData.zzCY);
        zzb.zza(parcel, 2, placeUserData.getPlaceId(), false);
        zzb.zzc(parcel, 5, placeUserData.zzve(), false);
        zzb.zzc(parcel, 6, placeUserData.zzvc(), false);
        zzb.zzc(parcel, 7, placeUserData.zzvd(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeG */
    public PlaceUserData createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    arrayList3 = zza.zzc(parcel, zzaa, TestDataImpl.CREATOR);
                    break;
                case 6:
                    arrayList2 = zza.zzc(parcel, zzaa, PlaceAlias.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzc(parcel, zzaa, HereContent.CREATOR);
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
            return new PlaceUserData(i, str2, str, arrayList3, arrayList2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhg */
    public PlaceUserData[] newArray(int i) {
        return new PlaceUserData[i];
    }
}
