package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.zzCY);
        zzb.zza(parcel, 2, (Parcelable) queryResultEventParcelable.zzWu, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzaei);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzaej);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzaA */
    public QueryResultEventParcelable createFromParcel(Parcel parcel) {
        int zzg;
        boolean z;
        DataHolder dataHolder;
        int i;
        int i2 = 0;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder2 = null;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    z = z2;
                    dataHolder = dataHolder2;
                    i = zza.zzg(parcel, zzaa);
                    zzg = i2;
                    break;
                case 2:
                    i = i3;
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    zzg = i2;
                    z = z2;
                    break;
                case 3:
                    dataHolder = dataHolder2;
                    i = i3;
                    z = zza.zzc(parcel, zzaa);
                    zzg = i2;
                    break;
                case 4:
                    zzg = zza.zzg(parcel, zzaa);
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzg = i2;
                    z = z2;
                    dataHolder = dataHolder2;
                    i = i3;
                    break;
            }
            i3 = i;
            dataHolder2 = dataHolder;
            z2 = z;
            i2 = zzg;
        }
        if (parcel.dataPosition() == zzab) {
            return new QueryResultEventParcelable(i3, dataHolder2, z2, i2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzcj */
    public QueryResultEventParcelable[] newArray(int i) {
        return new QueryResultEventParcelable[i];
    }
}
