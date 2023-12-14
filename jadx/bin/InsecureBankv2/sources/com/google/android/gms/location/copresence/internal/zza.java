package com.google.android.gms.location.copresence.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<CopresenceApiOptions> {
    static void zza(CopresenceApiOptions copresenceApiOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, copresenceApiOptions.zzCY);
        zzb.zza(parcel, 2, copresenceApiOptions.zzayo);
        zzb.zza(parcel, 3, copresenceApiOptions.zzayp, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzei */
    public CopresenceApiOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CopresenceApiOptions(i, z, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgC */
    public CopresenceApiOptions[] newArray(int i) {
        return new CopresenceApiOptions[i];
    }
}
