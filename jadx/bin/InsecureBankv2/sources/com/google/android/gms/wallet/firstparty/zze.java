package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsResponse.zzaRM, false);
        zzb.zza(parcel, 3, getInstrumentsResponse.zzaRN, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgu */
    public GetInstrumentsResponse createFromParcel(Parcel parcel) {
        String[] strArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[][] bArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzaa);
                    break;
                case 3:
                    bArr = zza.zzs(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjw */
    public GetInstrumentsResponse[] newArray(int i) {
        return new GetInstrumentsResponse[i];
    }
}
