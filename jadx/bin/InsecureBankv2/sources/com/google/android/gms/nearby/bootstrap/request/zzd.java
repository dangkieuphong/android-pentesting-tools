package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd implements Parcelable.Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) disconnectRequest.zzwM(), i, false);
        zzb.zzc(parcel, 1000, disconnectRequest.versionCode);
        zzb.zza(parcel, 2, disconnectRequest.zzqU(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfi */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        IBinder zzp;
        Device device;
        int i;
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Device device2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Device device3 = (Device) zza.zza(parcel, zzaa, Device.CREATOR);
                    i = i2;
                    zzp = iBinder;
                    device = device3;
                    break;
                case 2:
                    zzp = zza.zzp(parcel, zzaa);
                    device = device2;
                    i = i2;
                    break;
                case 1000:
                    device = device2;
                    i = zza.zzg(parcel, zzaa);
                    zzp = iBinder;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzp = iBinder;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            iBinder = zzp;
        }
        if (parcel.dataPosition() == zzab) {
            return new DisconnectRequest(i2, device2, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhQ */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
