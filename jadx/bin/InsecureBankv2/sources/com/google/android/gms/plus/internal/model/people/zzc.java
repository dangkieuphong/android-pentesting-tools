package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzc implements Parcelable.Creator<PersonEntity.CoverEntity> {
    static void zza(PersonEntity.CoverEntity coverEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = coverEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, coverEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, (Parcelable) coverEntity.zzaJj, i, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, (Parcelable) coverEntity.zzaJk, i, true);
        }
        if (set.contains(4)) {
            zzb.zzc(parcel, 4, coverEntity.zzaJl);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfO */
    public PersonEntity.CoverEntity createFromParcel(Parcel parcel) {
        PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    hashSet.add(2);
                    coverInfoEntity = (PersonEntity.CoverEntity.CoverInfoEntity) zza.zza(parcel, zzaa, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
                    break;
                case 3:
                    hashSet.add(3);
                    coverPhotoEntity = (PersonEntity.CoverEntity.CoverPhotoEntity) zza.zza(parcel, zzaa, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(4);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.CoverEntity(hashSet, i2, coverInfoEntity, coverPhotoEntity, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziE */
    public PersonEntity.CoverEntity[] newArray(int i) {
        return new PersonEntity.CoverEntity[i];
    }
}
