package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<TimeInterval> {
    static void zza(TimeInterval timeInterval, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, timeInterval.getVersionCode());
        zzb.zza(parcel, 2, timeInterval.zzaSH);
        zzb.zza(parcel, 3, timeInterval.zzaSI);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgE */
    public TimeInterval createFromParcel(Parcel parcel) {
        long j = 0;
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new TimeInterval(i, j2, j);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjJ */
    public TimeInterval[] newArray(int i) {
        return new TimeInterval[i];
    }
}
