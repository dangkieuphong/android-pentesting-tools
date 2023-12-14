package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<StringParcel> {
    static void zza(StringParcel stringParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, stringParcel.zzCY);
        zzb.zza(parcel, 2, stringParcel.zzuU, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzF */
    public StringParcel[] newArray(int i) {
        return new StringParcel[i];
    }

    /* renamed from: zzm */
    public StringParcel createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new StringParcel(i, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
