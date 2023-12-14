package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Parcelable.Creator<PutDataResponse> {
    static void zza(PutDataResponse putDataResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, putDataResponse.versionCode);
        zzb.zzc(parcel, 2, putDataResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) putDataResponse.zzaUx, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzhm */
    public PutDataResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        DataItemParcelable dataItemParcelable = null;
        int i2 = 0;
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
                    dataItemParcelable = (DataItemParcelable) zza.zza(parcel, zzaa, DataItemParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PutDataResponse(i2, i, dataItemParcelable);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzku */
    public PutDataResponse[] newArray(int i) {
        return new PutDataResponse[i];
    }
}
