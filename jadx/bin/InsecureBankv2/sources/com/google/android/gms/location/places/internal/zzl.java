package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<PlaceLikelihoodEntity> {
    static void zza(PlaceLikelihoodEntity placeLikelihoodEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) placeLikelihoodEntity.zzaAK, i, false);
        zzb.zzc(parcel, 1000, placeLikelihoodEntity.zzCY);
        zzb.zza(parcel, 2, placeLikelihoodEntity.zzaAL);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzez */
    public PlaceLikelihoodEntity createFromParcel(Parcel parcel) {
        float zzl;
        PlaceImpl placeImpl;
        int i;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        PlaceImpl placeImpl2 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    PlaceImpl placeImpl3 = (PlaceImpl) zza.zza(parcel, zzaa, PlaceImpl.CREATOR);
                    i = i2;
                    zzl = f;
                    placeImpl = placeImpl3;
                    break;
                case 2:
                    zzl = zza.zzl(parcel, zzaa);
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
                case 1000:
                    placeImpl = placeImpl2;
                    i = zza.zzg(parcel, zzaa);
                    zzl = f;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzl = f;
                    placeImpl = placeImpl2;
                    i = i2;
                    break;
            }
            i2 = i;
            placeImpl2 = placeImpl;
            f = zzl;
        }
        if (parcel.dataPosition() == zzab) {
            return new PlaceLikelihoodEntity(i2, placeImpl2, f);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgZ */
    public PlaceLikelihoodEntity[] newArray(int i) {
        return new PlaceLikelihoodEntity[i];
    }
}
