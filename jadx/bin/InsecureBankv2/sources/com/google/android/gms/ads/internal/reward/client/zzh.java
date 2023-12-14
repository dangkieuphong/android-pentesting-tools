package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<RewardedVideoAdRequestParcel> {
    static void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, rewardedVideoAdRequestParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) rewardedVideoAdRequestParcel.zzCm, i, false);
        zzb.zza(parcel, 3, rewardedVideoAdRequestParcel.zzpG, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzH */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    /* renamed from: zzn */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        String zzo;
        AdRequestParcel adRequestParcel;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    adRequestParcel = adRequestParcel2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                case 2:
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) zza.zza(parcel, zzaa, AdRequestParcel.CREATOR);
                    i = i2;
                    zzo = str;
                    adRequestParcel = adRequestParcel3;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
