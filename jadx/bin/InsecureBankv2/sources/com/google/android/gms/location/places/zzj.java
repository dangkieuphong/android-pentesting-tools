package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<PlacePhotoResult> {
    static void zza(PlacePhotoResult placePhotoResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) placePhotoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoResult.zzCY);
        zzb.zza(parcel, 2, (Parcelable) placePhotoResult.zzazJ, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzet */
    public PlacePhotoResult createFromParcel(Parcel parcel) {
        BitmapTeleporter bitmapTeleporter;
        Status status;
        int i;
        BitmapTeleporter bitmapTeleporter2 = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Status status2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i = i2;
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status3;
                    break;
                case 2:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, zzaa, BitmapTeleporter.CREATOR);
                    status = status2;
                    i = i2;
                    break;
                case 1000:
                    status = status2;
                    i = zza.zzg(parcel, zzaa);
                    bitmapTeleporter = bitmapTeleporter2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    bitmapTeleporter = bitmapTeleporter2;
                    status = status2;
                    i = i2;
                    break;
            }
            i2 = i;
            status2 = status;
            bitmapTeleporter2 = bitmapTeleporter;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlacePhotoResult(i2, status2, bitmapTeleporter2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgR */
    public PlacePhotoResult[] newArray(int i) {
        return new PlacePhotoResult[i];
    }
}
