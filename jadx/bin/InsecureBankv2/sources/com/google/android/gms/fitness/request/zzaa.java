package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzaa implements Parcelable.Creator<StartBleScanRequest> {
    static void zza(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, startBleScanRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, startBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, startBleScanRequest.zzrq(), false);
        zzb.zzc(parcel, 3, startBleScanRequest.getTimeoutSecs());
        zzb.zza(parcel, 4, startBleScanRequest.zzqU(), false);
        zzb.zza(parcel, 5, startBleScanRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcZ */
    public StartBleScanRequest createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        ArrayList arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
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
            return new StartBleScanRequest(i2, arrayList, iBinder2, i, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeU */
    public StartBleScanRequest[] newArray(int i) {
        return new StartBleScanRequest[i];
    }
}
