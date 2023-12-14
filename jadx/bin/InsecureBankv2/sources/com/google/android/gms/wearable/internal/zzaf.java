package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Parcelable.Creator<GetCapabilityResponse> {
    static void zza(GetCapabilityResponse getCapabilityResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, getCapabilityResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getCapabilityResponse.zzaUr, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgX */
    public GetCapabilityResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        CapabilityInfoParcelable capabilityInfoParcelable = null;
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
                    capabilityInfoParcelable = (CapabilityInfoParcelable) zza.zza(parcel, zzaa, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetCapabilityResponse(i2, i, capabilityInfoParcelable);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzkf */
    public GetCapabilityResponse[] newArray(int i) {
        return new GetCapabilityResponse[i];
    }
}
