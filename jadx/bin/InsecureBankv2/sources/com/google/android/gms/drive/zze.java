package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<DrivePreferences> {
    static void zza(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, drivePreferences.zzCY);
        zzb.zza(parcel, 2, drivePreferences.zzadh);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaq */
    public DrivePreferences createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DrivePreferences(i, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzbV */
    public DrivePreferences[] newArray(int i) {
        return new DrivePreferences[i];
    }
}
