package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<PlacePhotoMetadataResult> {
    static void zza(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoMetadataResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoMetadataResult.zzCY);
        zzb.zza(parcel, 2, (Parcelable) placePhotoMetadataResult.zzazH, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzes */
    public PlacePhotoMetadataResult createFromParcel(Parcel parcel) {
        DataHolder dataHolder;
        Status status;
        int i;
        DataHolder dataHolder2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    dataHolder = dataHolder2;
                    status = status3;
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    dataHolder = dataHolder2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataHolder = dataHolder2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            dataHolder2 = dataHolder;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlacePhotoMetadataResult(i2, status2, dataHolder2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgQ */
    public PlacePhotoMetadataResult[] newArray(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
