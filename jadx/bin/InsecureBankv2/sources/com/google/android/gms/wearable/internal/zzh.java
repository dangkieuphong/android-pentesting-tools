package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator<CapabilityInfoParcelable> {
    static void zza(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, capabilityInfoParcelable.zzCY);
        zzb.zza(parcel, 2, capabilityInfoParcelable.getName(), false);
        zzb.zzc(parcel, 3, capabilityInfoParcelable.zzBa(), false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzgN */
    public CapabilityInfoParcelable createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzaa, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CapabilityInfoParcelable(i, str, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzjS */
    public CapabilityInfoParcelable[] newArray(int i) {
        return new CapabilityInfoParcelable[i];
    }
}
