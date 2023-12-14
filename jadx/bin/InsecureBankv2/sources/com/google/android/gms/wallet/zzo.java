package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Parcelable.Creator<PaymentMethodToken> {
    static void zza(PaymentMethodToken paymentMethodToken, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, paymentMethodToken.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodToken.zzaRz);
        zzb.zza(parcel, 3, paymentMethodToken.zzaFl, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgo */
    public PaymentMethodToken createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
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
            return new PaymentMethodToken(i2, i, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjq */
    public PaymentMethodToken[] newArray(int i) {
        return new PaymentMethodToken[i];
    }
}
