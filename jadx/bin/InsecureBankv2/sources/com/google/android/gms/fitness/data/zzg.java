package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator<DataType> {
    static void zza(DataType dataType, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataType.getName(), false);
        zzb.zzc(parcel, 1000, dataType.getVersionCode());
        zzb.zzc(parcel, 2, dataType.getFields(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzco */
    public DataType createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzaa, Field.CREATOR);
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
            return new DataType(i, str, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeh */
    public DataType[] newArray(int i) {
        return new DataType[i];
    }
}
