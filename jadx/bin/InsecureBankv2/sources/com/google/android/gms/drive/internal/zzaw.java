package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaw implements Parcelable.Creator<OnDownloadProgressResponse> {
    static void zza(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onDownloadProgressResponse.zzCY);
        zzb.zza(parcel, 2, onDownloadProgressResponse.zzagg);
        zzb.zza(parcel, 3, onDownloadProgressResponse.zzagh);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbb */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        long j = 0;
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcQ */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
