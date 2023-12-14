package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<TextDeletedDetails> {
    static void zza(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, textDeletedDetails.zzCY);
        zzb.zzc(parcel, 2, textDeletedDetails.mIndex);
        zzb.zzc(parcel, 3, textDeletedDetails.zzaiX);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcc */
    public TextDeletedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdS */
    public TextDeletedDetails[] newArray(int i) {
        return new TextDeletedDetails[i];
    }
}
