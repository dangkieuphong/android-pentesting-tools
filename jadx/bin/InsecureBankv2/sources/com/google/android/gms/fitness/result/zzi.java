package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) readRawResult.zzpx(), i, false);
        zzb.zzc(parcel, 1000, readRawResult.getVersionCode());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdm */
    public ReadRawResult createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
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
            return new ReadRawResult(i, dataHolder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfh */
    public ReadRawResult[] newArray(int i) {
        return new ReadRawResult[i];
    }
}
