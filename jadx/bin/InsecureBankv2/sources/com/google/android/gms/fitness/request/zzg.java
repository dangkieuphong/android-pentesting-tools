package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzg implements Parcelable.Creator<DataSourceQueryParams> {
    static void zza(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataSourceQueryParams.zzajG, i, false);
        zzb.zzc(parcel, 1000, dataSourceQueryParams.zzCY);
        zzb.zza(parcel, 2, dataSourceQueryParams.zzOw);
        zzb.zza(parcel, 3, dataSourceQueryParams.zzajW);
        zzb.zza(parcel, 4, dataSourceQueryParams.zzamd);
        zzb.zzc(parcel, 5, dataSourceQueryParams.zzalY);
        zzb.zzc(parcel, 6, dataSourceQueryParams.zzame);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcG */
    public DataSourceQueryParams createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzab = zza.zzab(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataSourceQueryParams(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeA */
    public DataSourceQueryParams[] newArray(int i) {
        return new DataSourceQueryParams[i];
    }
}
