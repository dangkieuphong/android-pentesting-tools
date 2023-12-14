package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import java.util.HashSet;
import java.util.Set;

public class zzj implements Parcelable.Creator<PersonEntity.UrlsEntity> {
    static void zza(PersonEntity.UrlsEntity urlsEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set<Integer> set = urlsEntity.zzaHQ;
        if (set.contains(1)) {
            zzb.zzc(parcel, 1, urlsEntity.zzCY);
        }
        if (set.contains(3)) {
            zzb.zzc(parcel, 3, urlsEntity.zzxS());
        }
        if (set.contains(4)) {
            zzb.zza(parcel, 4, urlsEntity.mValue, true);
        }
        if (set.contains(5)) {
            zzb.zza(parcel, 5, urlsEntity.zzaEH, true);
        }
        if (set.contains(6)) {
            zzb.zzc(parcel, 6, urlsEntity.zzSq);
        }
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzfV */
    public PersonEntity.UrlsEntity createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    hashSet.add(1);
                    break;
                case 2:
                default:
                    zza.zzb(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(3);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(4);
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzaa);
                    hashSet.add(5);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(6);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PersonEntity.UrlsEntity(hashSet, i3, str2, i2, str, i);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zziL */
    public PersonEntity.UrlsEntity[] newArray(int i) {
        return new PersonEntity.UrlsEntity[i];
    }
}
