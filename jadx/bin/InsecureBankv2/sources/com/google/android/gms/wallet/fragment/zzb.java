package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<WalletFragmentOptions> {
    static void zza(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, walletFragmentOptions.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, walletFragmentOptions.getEnvironment());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, walletFragmentOptions.getTheme());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) walletFragmentOptions.getFragmentStyle(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, walletFragmentOptions.getMode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgw */
    public WalletFragmentOptions createFromParcel(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int zzab = zza.zzab(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) zza.zza(parcel, zzaa, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjz */
    public WalletFragmentOptions[] newArray(int i) {
        return new WalletFragmentOptions[i];
    }
}
