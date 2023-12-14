package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

public class zza implements Parcelable.Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, query.zzCY);
        zzb.zza(parcel, 1, (Parcelable) query.zzahG, i, false);
        zzb.zza(parcel, 3, query.zzahH, false);
        zzb.zza(parcel, 4, (Parcelable) query.zzahI, i, false);
        zzb.zzb(parcel, 5, query.zzahJ, false);
        zzb.zza(parcel, 6, query.zzahK);
        zzb.zzc(parcel, 7, query.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbF */
    public Query createFromParcel(Parcel parcel) {
        boolean z = false;
        ArrayList arrayList = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        ArrayList<String> arrayList2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, SortOrder.CREATOR);
                    break;
                case 5:
                    arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Query(i, logicalFilter, str, sortOrder, arrayList2, z, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdu */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
