package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs implements Parcelable.Creator<CloseChannelResponse> {
    static void zza(CloseChannelResponse closeChannelResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, closeChannelResponse.versionCode);
        zzb.zzc(parcel, 2, closeChannelResponse.statusCode);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgS */
    public CloseChannelResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
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
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CloseChannelResponse(i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzka */
    public CloseChannelResponse[] newArray(int i) {
        return new CloseChannelResponse[i];
    }
}
