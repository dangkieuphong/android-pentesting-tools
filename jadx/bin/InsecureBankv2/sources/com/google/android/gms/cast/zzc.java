package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<LaunchOptions> {
    static void zza(LaunchOptions launchOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, launchOptions.getVersionCode());
        zzb.zza(parcel, 2, launchOptions.getRelaunchIfRunning());
        zzb.zza(parcel, 3, launchOptions.getLanguage(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzL */
    public LaunchOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str = null;
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
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LaunchOptions(i, z, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzaB */
    public LaunchOptions[] newArray(int i) {
        return new LaunchOptions[i];
    }
}
