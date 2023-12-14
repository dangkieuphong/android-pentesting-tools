package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, userMetadata.zzCY);
        zzb.zza(parcel, 2, userMetadata.zzadH, false);
        zzb.zza(parcel, 3, userMetadata.zzadI, false);
        zzb.zza(parcel, 4, userMetadata.zzadJ, false);
        zzb.zza(parcel, 5, userMetadata.zzadK);
        zzb.zza(parcel, 6, userMetadata.zzadL, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzau */
    public UserMetadata createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UserMetadata(i, str4, str3, str2, z, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcd */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}
