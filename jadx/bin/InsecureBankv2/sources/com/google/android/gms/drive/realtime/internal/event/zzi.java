package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<ValuesAddedDetails> {
    static void zza(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, valuesAddedDetails.zzCY);
        zzb.zzc(parcel, 2, valuesAddedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesAddedDetails.zzaiA);
        zzb.zzc(parcel, 4, valuesAddedDetails.zzaiB);
        zzb.zza(parcel, 5, valuesAddedDetails.zzaiY, false);
        zzb.zzc(parcel, 6, valuesAddedDetails.zzaiZ);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcf */
    public ValuesAddedDetails createFromParcel(Parcel parcel) {
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
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdV */
    public ValuesAddedDetails[] newArray(int i) {
        return new ValuesAddedDetails[i];
    }
}
