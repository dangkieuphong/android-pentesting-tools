package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<ContinueConnectRequest> {
    static void zza(ContinueConnectRequest continueConnectRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, continueConnectRequest.getToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, continueConnectRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, continueConnectRequest.zzqU(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfg */
    public ContinueConnectRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
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
            return new ContinueConnectRequest(i, str, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhO */
    public ContinueConnectRequest[] newArray(int i) {
        return new ContinueConnectRequest[i];
    }
}
