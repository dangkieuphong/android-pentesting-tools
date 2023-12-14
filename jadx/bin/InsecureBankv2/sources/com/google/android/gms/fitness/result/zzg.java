package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzg implements Parcelable.Creator<DataTypeResult> {
    static void zza(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataTypeResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, dataTypeResult.getVersionCode());
        zzb.zza(parcel, 3, (Parcelable) dataTypeResult.getDataType(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdk */
    public DataTypeResult createFromParcel(Parcel parcel) {
        DataType dataType;
        Status status;
        int i;
        DataType dataType2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    dataType = dataType2;
                    status = status3;
                    break;
                case 3:
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    dataType = dataType2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataType = dataType2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataType2 = dataType;
        }
        if (parcel.dataPosition() == zzab) {
            return new DataTypeResult(i2, status2, dataType2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzff */
    public DataTypeResult[] newArray(int i) {
        return new DataTypeResult[i];
    }
}
