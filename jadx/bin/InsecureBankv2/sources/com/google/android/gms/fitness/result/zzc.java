package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzrv(), false);
        zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzru(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzrt());
        zzb.zzc(parcel, 6, dataReadResult.zzqA(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzrw(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdg */
    public DataReadResult createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    zza.zza(parcel, zzaa, arrayList2, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzaa, arrayList3, getClass().getClassLoader());
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    arrayList4 = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 7:
                    arrayList = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataReadResult(i2, arrayList2, status, arrayList3, i, arrayList4, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfb */
    public DataReadResult[] newArray(int i) {
        return new DataReadResult[i];
    }
}
