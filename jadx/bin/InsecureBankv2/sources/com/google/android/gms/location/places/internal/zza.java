package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.ArrayList;

public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, autocompletePredictionEntity.zzakM, false);
        zzb.zzc(parcel, 1000, autocompletePredictionEntity.zzCY);
        zzb.zza(parcel, 2, autocompletePredictionEntity.zzazK, false);
        zzb.zza(parcel, 3, autocompletePredictionEntity.zzazo, false);
        zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaAe, false);
        zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaAf);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzex */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        ArrayList<Integer> arrayList2 = null;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, zzaa);
                    break;
                case 4:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AutocompletePredictionEntity(i2, str2, str, arrayList2, arrayList, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzgW */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
