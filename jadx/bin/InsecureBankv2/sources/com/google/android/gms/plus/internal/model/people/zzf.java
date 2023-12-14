package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Parcelable.Creator<PersonEntity.ImageEntity> {
    static void zza(PersonEntity.ImageEntity imageEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = imageEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, imageEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfR */
    public PersonEntity.ImageEntity createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(2);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.ImageEntity(hashSet, i, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziH */
    public PersonEntity.ImageEntity[] newArray(int i) {
        return new PersonEntity.ImageEntity[i];
    }
}
