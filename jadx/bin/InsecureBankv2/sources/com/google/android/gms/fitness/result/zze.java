package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import java.util.ArrayList;

public class zze implements Parcelable.Creator<DataSourcesResult> {
    static void zza(DataSourcesResult dataSourcesResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, dataSourcesResult.getDataSources(), false);
        zzb.zzc(parcel, 1000, dataSourcesResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataSourcesResult.getStatus(), i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdi */
    public DataSourcesResult createFromParcel(Parcel parcel) {
        Status status = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
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
            return new DataSourcesResult(i, arrayList, status);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfd */
    public DataSourcesResult[] newArray(int i) {
        return new DataSourcesResult[i];
    }
}
