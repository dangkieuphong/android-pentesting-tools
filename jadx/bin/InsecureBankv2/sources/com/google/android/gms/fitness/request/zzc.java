package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzc implements Parcelable.Creator<DailyTotalRequest> {
    static void zza(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dailyTotalRequest.zzqU(), false);
        zzb.zzc(parcel, 1000, dailyTotalRequest.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) dailyTotalRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, dailyTotalRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcC */
    public DailyTotalRequest createFromParcel(Parcel parcel) {
        String zzo;
        DataType dataType;
        IBinder iBinder;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        DataType dataType2 = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    iBinder = zza.zzp(parcel, zzaa);
                    zzo = str;
                    dataType = dataType2;
                    break;
                case 2:
                    iBinder = iBinder2;
                    i = i2;
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    zzo = str;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = i2;
                    break;
                case 1000:
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    dataType = dataType2;
                    iBinder = iBinder2;
                    i = i2;
                    break;
            }
            i2 = i;
            iBinder2 = iBinder;
            dataType2 = dataType;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new DailyTotalRequest(i2, iBinder2, dataType2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzew */
    public DailyTotalRequest[] newArray(int i) {
        return new DailyTotalRequest[i];
    }
}
