package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.HereContent;
import java.util.ArrayList;

public class zzb implements Parcelable.Creator<HereContent> {
    static void zza(HereContent hereContent, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, hereContent.getData(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, hereContent.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, hereContent.getActions(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzeE */
    public HereContent createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzaa, HereContent.Action.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new HereContent(i, str, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzhe */
    public HereContent[] newArray(int i) {
        return new HereContent[i];
    }
}
