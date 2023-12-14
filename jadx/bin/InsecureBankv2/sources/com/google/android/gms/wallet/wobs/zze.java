package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<LoyaltyPoints> {
    static void zza(LoyaltyPoints loyaltyPoints, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, loyaltyPoints.getVersionCode());
        zzb.zza(parcel, 2, loyaltyPoints.label, false);
        zzb.zza(parcel, 3, (Parcelable) loyaltyPoints.zzaSA, i, false);
        zzb.zza(parcel, 4, loyaltyPoints.type, false);
        zzb.zza(parcel, 5, (Parcelable) loyaltyPoints.zzaQV, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgC */
    public LoyaltyPoints createFromParcel(Parcel parcel) {
        TimeInterval timeInterval = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        LoyaltyPointsBalance loyaltyPointsBalance = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    loyaltyPointsBalance = (LoyaltyPointsBalance) zza.zza(parcel, zzaa, LoyaltyPointsBalance.CREATOR);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzaa, TimeInterval.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LoyaltyPoints(i, str2, loyaltyPointsBalance, str, timeInterval);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjH */
    public LoyaltyPoints[] newArray(int i) {
        return new LoyaltyPoints[i];
    }
}
