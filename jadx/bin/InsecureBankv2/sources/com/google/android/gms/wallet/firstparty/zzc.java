package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<GetBuyFlowInitializationTokenResponse> {
    static void zza(GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getBuyFlowInitializationTokenResponse.getVersionCode());
        zzb.zza(parcel, 2, getBuyFlowInitializationTokenResponse.zzaRK, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgs */
    public GetBuyFlowInitializationTokenResponse createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetBuyFlowInitializationTokenResponse(i, bArr);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzju */
    public GetBuyFlowInitializationTokenResponse[] newArray(int i) {
        return new GetBuyFlowInitializationTokenResponse[i];
    }
}
