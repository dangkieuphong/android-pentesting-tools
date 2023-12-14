package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzan implements Parcelable.Creator<GetDataItemResponse> {
    static void zza(GetDataItemResponse getDataItemResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getDataItemResponse.versionCode);
        zzb.zzc(parcel, 2, getDataItemResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getDataItemResponse.zzaUx, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzhf */
    public GetDataItemResponse createFromParcel(Parcel parcel) {
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
            return new GetDataItemResponse(i2, i, dataItemParcelable);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzkn */
    public GetDataItemResponse[] newArray(int i) {
        return new GetDataItemResponse[i];
    }
}
