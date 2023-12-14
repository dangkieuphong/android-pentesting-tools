package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;

public class zzu implements Parcelable.Creator<AutocompletePredictionEntity.SubstringEntity> {
    static void zza(AutocompletePredictionEntity.SubstringEntity substringEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, substringEntity.mOffset);
        zzb.zzc(parcel, 1000, substringEntity.zzCY);
        zzb.zzc(parcel, 2, substringEntity.mLength);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeC */
    public AutocompletePredictionEntity.SubstringEntity createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AutocompletePredictionEntity.SubstringEntity(i3, i2, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhc */
    public AutocompletePredictionEntity.SubstringEntity[] newArray(int i) {
        return new AutocompletePredictionEntity.SubstringEntity[i];
    }
}
