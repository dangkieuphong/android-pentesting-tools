package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<EnableTargetRequest> {
    static void zza(EnableTargetRequest enableTargetRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, enableTargetRequest.getName(), false);
        zzb.zzc(parcel, 1000, enableTargetRequest.versionCode);
        zzb.zza(parcel, 2, enableTargetRequest.getDescription(), false);
        zzb.zza(parcel, 3, enableTargetRequest.zzwO(), false);
        zzb.zza(parcel, 4, enableTargetRequest.zzwP(), false);
        zzb.zza(parcel, 5, enableTargetRequest.zzqU(), false);
        zzb.zza(parcel, 6, enableTargetRequest.zzwK());
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfj */
    public EnableTargetRequest createFromParcel(Parcel parcel) {
        byte b = 0;
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    iBinder3 = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 6:
                    b = zza.zze(parcel, zzaa);
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
            return new EnableTargetRequest(i, str2, str, b, iBinder3, iBinder2, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhR */
    public EnableTargetRequest[] newArray(int i) {
        return new EnableTargetRequest[i];
    }
}
