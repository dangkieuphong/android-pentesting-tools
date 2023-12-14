package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<ValuesSetDetails> {
    static void zza(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, valuesSetDetails.zzCY);
        zzb.zzc(parcel, 2, valuesSetDetails.mIndex);
        zzb.zzc(parcel, 3, valuesSetDetails.zzaiA);
        zzb.zzc(parcel, 4, valuesSetDetails.zzaiB);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzch */
    public ValuesSetDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdX */
    public ValuesSetDetails[] newArray(int i) {
        return new ValuesSetDetails[i];
    }
}
