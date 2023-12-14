package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Parcelable.Creator<MobileAdsSettingsParcel> {
    static void zza(MobileAdsSettingsParcel mobileAdsSettingsParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, mobileAdsSettingsParcel.versionCode);
        zzb.zza(parcel, 2, mobileAdsSettingsParcel.zztf);
        zzb.zza(parcel, 3, mobileAdsSettingsParcel.zztg, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzd */
    public MobileAdsSettingsParcel createFromParcel(Parcel parcel) {
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
            return new MobileAdsSettingsParcel(i, z, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzn */
    public MobileAdsSettingsParcel[] newArray(int i) {
        return new MobileAdsSettingsParcel[i];
    }
}
