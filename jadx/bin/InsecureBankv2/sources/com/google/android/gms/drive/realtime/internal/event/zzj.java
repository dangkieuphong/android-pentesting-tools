package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<ValuesRemovedDetails> {
    static void zza(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, valuesRemovedDetails.zzCY);
        zzb.zzc(parcel, 2, valuesRemovedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesRemovedDetails.zzaiA);
        zzb.zzc(parcel, 4, valuesRemovedDetails.zzaiB);
        zzb.zza(parcel, 5, valuesRemovedDetails.zzaja, false);
        zzb.zzc(parcel, 6, valuesRemovedDetails.zzajb);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcg */
    public ValuesRemovedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdW */
    public ValuesRemovedDetails[] newArray(int i) {
        return new ValuesRemovedDetails[i];
    }
}
