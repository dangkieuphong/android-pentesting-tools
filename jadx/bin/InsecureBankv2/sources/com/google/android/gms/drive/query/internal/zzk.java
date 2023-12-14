package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk implements Parcelable.Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, logicalFilter.zzCY);
        zzb.zza(parcel, 1, (Parcelable) logicalFilter.zzahQ, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzaif, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbO */
    public LogicalFilter createFromParcel(Parcel parcel) {
        ArrayList zzc;
        Operator operator;
        int i;
        ArrayList arrayList = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    Operator operator3 = (Operator) zza.zza(parcel, zzaa, Operator.CREATOR);
                    i = i2;
                    zzc = arrayList;
                    operator = operator3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzaa, FilterHolder.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    operator = operator2;
                    i = zza.zzg(parcel, zzaa);
                    zzc = arrayList;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = arrayList;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            arrayList = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new LogicalFilter(i2, operator2, arrayList);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdD */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }
}
