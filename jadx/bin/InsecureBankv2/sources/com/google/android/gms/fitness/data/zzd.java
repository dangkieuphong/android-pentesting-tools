package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<DataPoint> {
    static void zza(DataPoint dataPoint, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataPoint.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, dataPoint.getVersionCode());
        zzb.zza(parcel, 3, dataPoint.getTimestampNanos());
        zzb.zza(parcel, 4, dataPoint.zzqy());
        zzb.zza(parcel, 5, (Parcelable[]) dataPoint.zzqu(), i, false);
        zzb.zza(parcel, 6, (Parcelable) dataPoint.getOriginalDataSource(), i, false);
        zzb.zza(parcel, 7, dataPoint.zzqv());
        zzb.zza(parcel, 8, dataPoint.zzqw());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcl */
    public DataPoint createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataSource dataSource = null;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        DataSource dataSource2 = null;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    valueArr = (Value[]) zza.zzb(parcel, zzaa, Value.CREATOR);
                    break;
                case 6:
                    dataSource2 = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 7:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 8:
                    j4 = zza.zzi(parcel, zzaa);
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
            return new DataPoint(i, dataSource, j, j2, valueArr, dataSource2, j3, j4);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzee */
    public DataPoint[] newArray(int i) {
        return new DataPoint[i];
    }
}
