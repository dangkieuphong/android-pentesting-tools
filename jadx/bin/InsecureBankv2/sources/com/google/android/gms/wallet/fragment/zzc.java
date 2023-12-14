package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.zzCY);
        zzb.zza(parcel, 2, walletFragmentStyle.zzaSm, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzaSn);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgx */
    public WalletFragmentStyle createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
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
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjA */
    public WalletFragmentStyle[] newArray(int i) {
        return new WalletFragmentStyle[i];
    }
}
