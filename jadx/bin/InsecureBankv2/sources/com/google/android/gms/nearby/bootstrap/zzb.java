package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, device.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, device.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, device.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, device.getDeviceId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, device.zzwK());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfe */
    public Device createFromParcel(Parcel parcel) {
        byte b = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
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
            return new Device(i, str3, str2, str, b);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhM */
    public Device[] newArray(int i) {
        return new Device[i];
    }
}
