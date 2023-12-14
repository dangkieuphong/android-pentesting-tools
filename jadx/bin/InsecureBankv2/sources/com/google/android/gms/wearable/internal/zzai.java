package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai implements Parcelable.Creator<GetCloudSyncOptInOutDoneResponse> {
    static void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInOutDoneResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInOutDoneResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInOutDoneResponse.zzaUt);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzha */
    public GetCloudSyncOptInOutDoneResponse createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
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
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetCloudSyncOptInOutDoneResponse(i2, i, z);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzki */
    public GetCloudSyncOptInOutDoneResponse[] newArray(int i) {
        return new GetCloudSyncOptInOutDoneResponse[i];
    }
}
