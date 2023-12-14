package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzi implements Parcelable.Creator<PersonEntity.PlacesLivedEntity> {
    static void zza(PersonEntity.PlacesLivedEntity placesLivedEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = placesLivedEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, placesLivedEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, placesLivedEntity.zzaJu);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, placesLivedEntity.mValue, true);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfU */
    public PersonEntity.PlacesLivedEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzaa);
                    hashSet.add(2);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(3);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.PlacesLivedEntity(hashSet, i, z, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziK */
    public PersonEntity.PlacesLivedEntity[] newArray(int i) {
        return new PersonEntity.PlacesLivedEntity[i];
    }
}
