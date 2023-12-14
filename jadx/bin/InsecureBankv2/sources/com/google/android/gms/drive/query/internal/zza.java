package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zza implements Parcelable.Creator<ComparisonFilter> {
    static void zza(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, comparisonFilter.zzCY);
        zzb.zza(parcel, 1, (Parcelable) comparisonFilter.zzahQ, i, false);
        zzb.zza(parcel, 2, (Parcelable) comparisonFilter.zzahR, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbH */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        Operator operator;
        int i;
        MetadataBundle metadataBundle2 = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    Operator operator3 = (Operator) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Operator.CREATOR);
                    i = i2;
                    metadataBundle = metadataBundle2;
                    operator = operator3;
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    operator = operator2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    metadataBundle = metadataBundle2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    metadataBundle = metadataBundle2;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == zzab) {
            return new ComparisonFilter(i2, operator2, metadataBundle2);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdw */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }
}
