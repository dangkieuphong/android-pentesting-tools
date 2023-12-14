package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Parcelable.Creator<StopBleScanRequest> {
    static void zza(StopBleScanRequest stopBleScanRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, stopBleScanRequest.zzrq(), false);
        zzb.zzc(parcel, 1000, stopBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, stopBleScanRequest.zzqU(), false);
        zzb.zza(parcel, 3, stopBleScanRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzda */
    public StopBleScanRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 3:
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
            return new StopBleScanRequest(i, iBinder2, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeV */
    public StopBleScanRequest[] newArray(int i) {
        return new StopBleScanRequest[i];
    }
}
