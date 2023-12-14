package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zze implements Parcelable.Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataSet.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzqz(), false);
        zzb.zzc(parcel, 4, dataSet.zzqA(), false);
        zzb.zza(parcel, 5, dataSet.zzqr());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcm */
    public DataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList2 = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzaa, arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
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
            return new DataSet(i, dataSource, dataType, arrayList2, arrayList, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzef */
    public DataSet[] newArray(int i) {
        return new DataSet[i];
    }
}
