package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzba implements Parcelable.Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.zzCY);
        zzb.zza(parcel, 2, (Parcelable) onFetchThumbnailResponse.zzago, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbf */
    public OnFetchThumbnailResponse createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcU */
    public OnFetchThumbnailResponse[] newArray(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
