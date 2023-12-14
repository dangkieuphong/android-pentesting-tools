package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbh implements Parcelable.Creator<StorageInfoResponse> {
    static void zza(StorageInfoResponse storageInfoResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, storageInfoResponse.versionCode);
        zzb.zzc(parcel, 2, storageInfoResponse.statusCode);
        zzb.zza(parcel, 3, storageInfoResponse.zzaUN);
        zzb.zzc(parcel, 4, storageInfoResponse.zzaUP, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzhq */
    public StorageInfoResponse createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        long j = 0;
        ArrayList arrayList = null;
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
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    arrayList = zza.zzc(parcel, zzaa, PackageStorageInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new StorageInfoResponse(i2, i, j, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzky */
    public StorageInfoResponse[] newArray(int i) {
        return new StorageInfoResponse[i];
    }
}
