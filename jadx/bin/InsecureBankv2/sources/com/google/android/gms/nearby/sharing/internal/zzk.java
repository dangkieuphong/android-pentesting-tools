package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<TrustedDevicesRequest> {
    static void zza(TrustedDevicesRequest trustedDevicesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, trustedDevicesRequest.versionCode);
        zzb.zza(parcel, 2, trustedDevicesRequest.zzaGv, false);
        zzb.zza(parcel, 3, trustedDevicesRequest.zzaGw, false);
        zzb.zza(parcel, 4, trustedDevicesRequest.zzxa(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfF */
    public TrustedDevicesRequest createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new TrustedDevicesRequest(i, str, bArr, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziu */
    public TrustedDevicesRequest[] newArray(int i) {
        return new TrustedDevicesRequest[i];
    }
}
