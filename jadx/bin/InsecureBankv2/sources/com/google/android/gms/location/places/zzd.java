package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzb(parcel, 1, nearbyAlertFilter.zzazu, false);
        zzb.zzc(parcel, 1000, nearbyAlertFilter.zzCY);
        zzb.zza(parcel, 2, nearbyAlertFilter.zzazs, false);
        zzb.zzc(parcel, 3, nearbyAlertFilter.zzazv, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzep */
    public NearbyAlertFilter createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList<Integer> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList3 = zza.zzC(parcel, zzaa);
                    break;
                case 2:
                    arrayList2 = zza.zzB(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, UserDataType.CREATOR);
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
            return new NearbyAlertFilter(i, arrayList3, arrayList2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgL */
    public NearbyAlertFilter[] newArray(int i) {
        return new NearbyAlertFilter[i];
    }
}
