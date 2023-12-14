package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah implements Parcelable.Creator<GetChannelOutputStreamResponse> {
    static void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getChannelOutputStreamResponse.versionCode);
        zzb.zzc(parcel, 2, getChannelOutputStreamResponse.statusCode);
        zzb.zza(parcel, 3, (Parcelable) getChannelOutputStreamResponse.zzaUs, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgZ */
    public GetChannelOutputStreamResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                case 3:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetChannelOutputStreamResponse(i2, i, parcelFileDescriptor);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzkh */
    public GetChannelOutputStreamResponse[] newArray(int i) {
        return new GetChannelOutputStreamResponse[i];
    }
}
