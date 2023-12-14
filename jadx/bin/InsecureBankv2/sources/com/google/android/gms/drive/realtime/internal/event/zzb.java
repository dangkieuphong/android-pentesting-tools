package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<ObjectChangedDetails> {
    static void zza(ObjectChangedDetails objectChangedDetails, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, objectChangedDetails.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, objectChangedDetails.zzaiA);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, objectChangedDetails.zzaiB);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbY */
    public ObjectChangedDetails createFromParcel(Parcel parcel) {
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
            return new ObjectChangedDetails(i3, i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdO */
    public ObjectChangedDetails[] newArray(int i) {
        return new ObjectChangedDetails[i];
    }
}
