package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Parcelable.Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzajV);
        zzb.zzc(parcel, 1000, rawDataPoint.zzCY);
        zzb.zza(parcel, 2, rawDataPoint.zzajW);
        zzb.zza(parcel, 3, (Parcelable[]) rawDataPoint.zzajX, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzakH);
        zzb.zzc(parcel, 5, rawDataPoint.zzakI);
        zzb.zza(parcel, 6, rawDataPoint.zzajZ);
        zzb.zza(parcel, 7, rawDataPoint.zzaka);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzct */
    public RawDataPoint createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    valueArr = (Value[]) zza.zzb(parcel, zzaa, Value.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 7:
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzem */
    public RawDataPoint[] newArray(int i) {
        return new RawDataPoint[i];
    }
}
