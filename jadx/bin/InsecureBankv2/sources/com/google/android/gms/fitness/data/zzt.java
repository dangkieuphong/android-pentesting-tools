package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Parcelable.Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzqI());
        zzb.zza(parcel, 4, value.zzqO(), false);
        zzb.zza(parcel, 5, value.zzqP(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzcy */
    public Value createFromParcel(Parcel parcel) {
        Bundle bundle = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        float f = 0.0f;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
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
            return new Value(i2, i, z, f, str, bundle);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzes */
    public Value[] newArray(int i) {
        return new Value[i];
    }
}
