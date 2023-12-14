package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<NotifyTransactionStatusRequest> {
    static void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, notifyTransactionStatusRequest.zzCY);
        zzb.zza(parcel, 2, notifyTransactionStatusRequest.zzaQm, false);
        zzb.zzc(parcel, 3, notifyTransactionStatusRequest.status);
        zzb.zza(parcel, 4, notifyTransactionStatusRequest.zzaRw, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgm */
    public NotifyTransactionStatusRequest createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjo */
    public NotifyTransactionStatusRequest[] newArray(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
