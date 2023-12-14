package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zze implements Parcelable.Creator<PersonEntity.CoverEntity.CoverPhotoEntity> {
    static void zza(PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = coverPhotoEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, coverPhotoEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zzc(parcel, 2, coverPhotoEntity.zznN);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, coverPhotoEntity.zzF, true);
        }
        if (set.contains(4)) {
            zzb.zzc(parcel, 4, coverPhotoEntity.zznM);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfQ */
    public PersonEntity.CoverEntity.CoverPhotoEntity createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(2);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(3);
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
            return new PersonEntity.CoverEntity.CoverPhotoEntity(hashSet, i3, i2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziG */
    public PersonEntity.CoverEntity.CoverPhotoEntity[] newArray(int i) {
        return new PersonEntity.CoverEntity.CoverPhotoEntity[i];
    }
}
