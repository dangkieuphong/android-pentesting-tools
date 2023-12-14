package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf implements Parcelable.Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) sendDataRequest.zzwM(), i, false);
        zzb.zzc(parcel, 1000, sendDataRequest.versionCode);
        zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        zzb.zza(parcel, 3, sendDataRequest.zzqU(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfk */
    public SendDataRequest createFromParcel(Parcel parcel) {
        IBinder zzp;
        byte[] bArr;
        Device device;
        int i;
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        byte[] bArr2 = null;
        Device device2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = i2;
                    device = (Device) zza.zza(parcel, zzaa, Device.CREATOR);
                    zzp = iBinder;
                    bArr = bArr2;
                    break;
                case 2:
                    device = device2;
                    i = i2;
                    bArr = zza.zzr(parcel, zzaa);
                    zzp = iBinder;
                    break;
                case 3:
                    zzp = zza.zzp(parcel, zzaa);
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
                case 1000:
                    bArr = bArr2;
                    device = device2;
                    i = zza.zzg(parcel, zzaa);
                    zzp = iBinder;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzp = iBinder;
                    bArr = bArr2;
                    device = device2;
                    i = i2;
                    break;
            }
            i2 = i;
            device2 = device;
            bArr2 = bArr;
            iBinder = zzp;
        }
        if (parcel.dataPosition() == zzab) {
            return new SendDataRequest(i2, device2, bArr2, iBinder);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhS */
    public SendDataRequest[] newArray(int i) {
        return new SendDataRequest[i];
    }
}
