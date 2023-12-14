package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<Feature> {
    static void zza(Feature feature, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, feature.id);
        zzb.zzc(parcel, 1000, feature.zzCY);
        zzb.zza(parcel, 2, feature.zzNi, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaf */
    public Feature[] newArray(int i) {
        return new Feature[i];
    }

    /* renamed from: zzu */
    public Feature createFromParcel(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Feature(i2, i, bundle);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }
}
