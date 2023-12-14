package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<GetSyncInfoRequest> {
    static void zza(GetSyncInfoRequest getSyncInfoRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, getSyncInfoRequest.zzqU(), false);
        zzb.zzc(parcel, 1000, getSyncInfoRequest.getVersionCode());
        zzb.zza(parcel, 2, getSyncInfoRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcM */
    public GetSyncInfoRequest createFromParcel(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetSyncInfoRequest(i, iBinder, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzeG */
    public GetSyncInfoRequest[] newArray(int i) {
        return new GetSyncInfoRequest[i];
    }
}
