package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<GetInstrumentsRequest> {
    static void zza(GetInstrumentsRequest getInstrumentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getInstrumentsRequest.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsRequest.zzaRL, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgt */
    public GetInstrumentsRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iArr = zza.zzu(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetInstrumentsRequest(i, iArr);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjv */
    public GetInstrumentsRequest[] newArray(int i) {
        return new GetInstrumentsRequest[i];
    }
}
