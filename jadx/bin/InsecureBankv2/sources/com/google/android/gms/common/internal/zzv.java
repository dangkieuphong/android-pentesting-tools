package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzv implements Parcelable.Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.zzCY);
        zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzX */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int zzg;
        Account account;
        int i;
        int i2 = 0;
        int zzab = zza.zzab(parcel);
        Account account2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    account = account2;
                    i = zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    Account account3 = (Account) zza.zza(parcel, zzaa, Account.CREATOR);
                    i = i3;
                    zzg = i2;
                    account = account3;
                    break;
                case 3:
                    zzg = zza.zzg(parcel, zzaa);
                    account = account2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzg = i2;
                    account = account2;
                    i = i3;
                    break;
            }
            i3 = i;
            account2 = account;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new ResolveAccountRequest(i3, account2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzbx */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
