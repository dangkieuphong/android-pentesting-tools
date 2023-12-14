package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<StopProvidingContentRequest> {
    static void zza(StopProvidingContentRequest stopProvidingContentRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, stopProvidingContentRequest.versionCode);
        zzb.zza(parcel, 2, stopProvidingContentRequest.zzaGs);
        zzb.zza(parcel, 3, stopProvidingContentRequest.zzxa(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfE */
    public StopProvidingContentRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new StopProvidingContentRequest(i, j, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzit */
    public StopProvidingContentRequest[] newArray(int i) {
        return new StopProvidingContentRequest[i];
    }
}
