package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.zzCY);
        zzb.zzc(parcel, 2, parcelableEventList.zzoB, false);
        zzb.zza(parcel, 3, (Parcelable) parcelableEventList.zzaiQ, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzaiR);
        zzb.zzb(parcel, 5, parcelableEventList.zzaiS, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzca */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList<String> arrayList = null;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder = null;
        ArrayList arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    arrayList2 = zza.zzc(parcel, zzaa, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    arrayList = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParcelableEventList(i, arrayList2, dataHolder, z, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdQ */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
