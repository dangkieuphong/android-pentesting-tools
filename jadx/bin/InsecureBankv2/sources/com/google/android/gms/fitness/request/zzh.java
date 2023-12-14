package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator<DataSourcesRequest> {
    static void zza(DataSourcesRequest dataSourcesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, dataSourcesRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, dataSourcesRequest.getVersionCode());
        zzb.zza(parcel, 2, dataSourcesRequest.zzrd(), false);
        zzb.zza(parcel, 3, dataSourcesRequest.zzre());
        zzb.zza(parcel, 4, dataSourcesRequest.zzqU(), false);
        zzb.zza(parcel, 5, dataSourcesRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcH */
    public DataSourcesRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder = null;
        ArrayList<Integer> arrayList = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList2 = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 2:
                    arrayList = zza.zzB(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
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
            return new DataSourcesRequest(i, arrayList2, arrayList, z, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeB */
    public DataSourcesRequest[] newArray(int i) {
        return new DataSourcesRequest[i];
    }
}
