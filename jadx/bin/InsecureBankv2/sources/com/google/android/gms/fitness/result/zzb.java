package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;

public class zzb implements Parcelable.Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dailyTotalResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) dailyTotalResult.getTotal(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdf */
    public DailyTotalResult createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Status status;
        int i;
        DataSet dataSet2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    dataSet = dataSet2;
                    status = status3;
                    break;
                case 2:
                    dataSet = (DataSet) zza.zza(parcel, zzaa, DataSet.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    dataSet = dataSet2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataSet = dataSet2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() == zzab) {
            return new DailyTotalResult(i2, status2, dataSet2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfa */
    public DailyTotalResult[] newArray(int i) {
        return new DailyTotalResult[i];
    }
}
