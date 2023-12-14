package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzh implements Parcelable.Creator<PersonEntity.OrganizationsEntity> {
    static void zza(PersonEntity.OrganizationsEntity organizationsEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = organizationsEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, organizationsEntity.zzCY);
        }
        if (set.contains(2)) {
            zzb.zza(parcel, 2, organizationsEntity.zzaJs, true);
        }
        if (set.contains(3)) {
            zzb.zza(parcel, 3, organizationsEntity.zzakM, true);
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, organizationsEntity.zzaIn, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, organizationsEntity.zzaJt, true);
        }
        if (set.contains(6)) {
            zzb.zza(parcel, 6, organizationsEntity.mName, true);
        }
        if (set.contains(7)) {
            zzb.zza(parcel, 7, organizationsEntity.zzaJu);
        }
        if (set.contains(8)) {
            zzb.zza(parcel, 8, organizationsEntity.zzaID, true);
        }
        if (set.contains(9)) {
            zzb.zza(parcel, 9, organizationsEntity.zzadv, true);
        }
        if (set.contains(10)) {
            zzb.zzc(parcel, 10, organizationsEntity.zzSq);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfT */
    public PersonEntity.OrganizationsEntity createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                    str7 = zza.zzo(parcel, zzaa);
                    hashSet.add(2);
                    break;
                case 3:
                    str6 = zza.zzo(parcel, zzaa);
                    hashSet.add(3);
                    break;
                case 4:
                    str5 = zza.zzo(parcel, zzaa);
                    hashSet.add(4);
                    break;
                case 5:
                    str4 = zza.zzo(parcel, zzaa);
                    hashSet.add(5);
                    break;
                case 6:
                    str3 = zza.zzo(parcel, zzaa);
                    hashSet.add(6);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzaa);
                    hashSet.add(7);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    hashSet.add(8);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(9);
                    break;
                case 10:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(10);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.OrganizationsEntity(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziJ */
    public PersonEntity.OrganizationsEntity[] newArray(int i) {
        return new PersonEntity.OrganizationsEntity[i];
    }
}
