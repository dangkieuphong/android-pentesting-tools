package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<DataTypeReadRequest> {
    static void zza(DataTypeReadRequest dataTypeReadRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataTypeReadRequest.getName(), false);
        zzb.zzc(parcel, 1000, dataTypeReadRequest.getVersionCode());
        zzb.zza(parcel, 3, dataTypeReadRequest.zzqU(), false);
        zzb.zza(parcel, 4, dataTypeReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcJ */
    public DataTypeReadRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
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
            return new DataTypeReadRequest(i, str2, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeD */
    public DataTypeReadRequest[] newArray(int i) {
        return new DataTypeReadRequest[i];
    }
}
