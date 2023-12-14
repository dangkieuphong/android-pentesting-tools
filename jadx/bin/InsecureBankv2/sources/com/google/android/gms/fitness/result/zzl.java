package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<SyncInfoResult> {
    static void zza(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) syncInfoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, syncInfoResult.getVersionCode());
        zzb.zza(parcel, 2, syncInfoResult.zzrz());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzdp */
    public SyncInfoResult createFromParcel(Parcel parcel) {
        long zzi;
        Status status;
        int i;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        long j = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    zzi = j;
                    break;
                case 2:
                    zzi = zza.zzi(parcel, zzaa);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    zzi = j;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzi = j;
                    status = status2;
                    i = i2;
                    break;
            }
            status2 = status;
            i2 = i;
            j = zzi;
        }
        if (parcel.dataPosition() == zzab) {
            return new SyncInfoResult(i2, status2, j);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzfk */
    public SyncInfoResult[] newArray(int i) {
        return new SyncInfoResult[i];
    }
}
