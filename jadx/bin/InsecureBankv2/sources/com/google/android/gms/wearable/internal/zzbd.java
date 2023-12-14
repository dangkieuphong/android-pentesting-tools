package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Parcelable.Creator<RemoveLocalCapabilityResponse> {
    static void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, removeLocalCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, removeLocalCapabilityResponse.statusCode);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzho */
    public RemoveLocalCapabilityResponse createFromParcel(Parcel parcel) {
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
            return new RemoveLocalCapabilityResponse(i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzkw */
    public RemoveLocalCapabilityResponse[] newArray(int i) {
        return new RemoveLocalCapabilityResponse[i];
    }
}
