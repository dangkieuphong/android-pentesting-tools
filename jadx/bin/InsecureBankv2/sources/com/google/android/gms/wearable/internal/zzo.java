package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Parcelable.Creator<ChannelReceiveFileResponse> {
    static void zza(ChannelReceiveFileResponse channelReceiveFileResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, channelReceiveFileResponse.versionCode);
        zzb.zzc(parcel, 2, channelReceiveFileResponse.statusCode);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgQ */
    public ChannelReceiveFileResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChannelReceiveFileResponse(i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjY */
    public ChannelReceiveFileResponse[] newArray(int i) {
        return new ChannelReceiveFileResponse[i];
    }
}
