package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<FieldChangedDetails> {
    static void zza(FieldChangedDetails fieldChangedDetails, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, fieldChangedDetails.zzCY);
        zzb.zzc(parcel, 2, fieldChangedDetails.zzaiz);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbX */
    public FieldChangedDetails createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new FieldChangedDetails(i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdN */
    public FieldChangedDetails[] newArray(int i) {
        return new FieldChangedDetails[i];
    }
}
