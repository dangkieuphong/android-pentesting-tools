package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

public class zze implements Parcelable.Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) dataInsertRequest.zzqK(), i, false);
        zzb.zzc(parcel, 1000, dataInsertRequest.getVersionCode());
        zzb.zza(parcel, 2, dataInsertRequest.zzqU(), false);
        zzb.zza(parcel, 3, dataInsertRequest.getPackageName(), false);
        zzb.zza(parcel, 4, dataInsertRequest.zzqY());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcE */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder = null;
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSet = (DataSet) zza.zza(parcel, zzaa, DataSet.CREATOR);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
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
            return new DataInsertRequest(i, dataSet, iBinder, str, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzey */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
