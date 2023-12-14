package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Parcelable.Creator<PersonEntity.NameEntity> {
    static void zza(PersonEntity.NameEntity nameEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = nameEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, nameEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, nameEntity.zzaIo, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, nameEntity.zzaJo, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, nameEntity.zzaIr, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, nameEntity.zzaJp, true);
        }
        if (set.contains(6)) {
            zzb.zza(parcel, 6, nameEntity.zzaJq, true);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, nameEntity.zzaJr, true);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfS */
    public PersonEntity.NameEntity createFromParcel(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    str6 = zza.zzo(parcel, zzaa);
                    hashSet.add(2);
                    break;
                case 3:
                    str5 = zza.zzo(parcel, zzaa);
                    hashSet.add(3);
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzaa);
                    hashSet.add(4);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    hashSet.add(5);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    hashSet.add(6);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(7);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziI */
    public PersonEntity.NameEntity[] newArray(int i) {
        return new PersonEntity.NameEntity[i];
    }
}
