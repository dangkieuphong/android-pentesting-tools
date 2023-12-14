package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class zzc implements Parcelable.Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, customProperty.zzCY);
        zzb.zza(parcel, 2, (Parcelable) customProperty.zzagG, i, false);
        zzb.zza(parcel, 3, customProperty.mValue, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbB */
    public CustomProperty createFromParcel(Parcel parcel) {
        String zzo;
        CustomPropertyKey customPropertyKey;
        int i;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        CustomPropertyKey customPropertyKey2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    customPropertyKey = customPropertyKey2;
                    i = zza.zzg(parcel, zzaa);
                    zzo = str;
                    break;
                case 2:
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) zza.zza(parcel, zzaa, CustomPropertyKey.CREATOR);
                    i = i2;
                    zzo = str;
                    customPropertyKey = customPropertyKey3;
                    break;
                case 3:
                    zzo = zza.zzo(parcel, zzaa);
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzo = str;
                    customPropertyKey = customPropertyKey2;
                    i = i2;
                    break;
            }
            i2 = i;
            customPropertyKey2 = customPropertyKey;
            str = zzo;
        }
        if (parcel.dataPosition() == zzab) {
            return new CustomProperty(i2, customPropertyKey2, str);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdq */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
