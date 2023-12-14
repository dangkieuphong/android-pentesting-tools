package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzo implements Parcelable.Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzakH);
        zzb.zzc(parcel, 1000, rawDataSet.zzCY);
        zzb.zzc(parcel, 2, rawDataSet.zzakJ);
        zzb.zzc(parcel, 3, rawDataSet.zzakK, false);
        zzb.zza(parcel, 4, rawDataSet.zzajU);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcu */
    public RawDataSet createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        ArrayList arrayList = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
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
            return new RawDataSet(i3, i2, i, arrayList, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzen */
    public RawDataSet[] newArray(int i) {
        return new RawDataSet[i];
    }
}
