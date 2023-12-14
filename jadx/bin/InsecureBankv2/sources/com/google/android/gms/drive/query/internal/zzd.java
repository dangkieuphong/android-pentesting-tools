package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, (Parcelable) filterHolder.zzahU, i, false);
        zzb.zzc(parcel, 1000, filterHolder.zzCY);
        zzb.zza(parcel, 2, (Parcelable) filterHolder.zzahV, i, false);
        zzb.zza(parcel, 3, (Parcelable) filterHolder.zzahW, i, false);
        zzb.zza(parcel, 4, (Parcelable) filterHolder.zzahX, i, false);
        zzb.zza(parcel, 5, (Parcelable) filterHolder.zzahY, i, false);
        zzb.zza(parcel, 6, (Parcelable) filterHolder.zzahZ, i, false);
        zzb.zza(parcel, 7, (Parcelable) filterHolder.zzaia, i, false);
        zzb.zza(parcel, 8, (Parcelable) filterHolder.zzaib, i, false);
        zzb.zza(parcel, 9, (Parcelable) filterHolder.zzaic, i, false);
        zzb.zzH(parcel, zzac);
    }

    /* renamed from: zzbK */
    public FilterHolder createFromParcel(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzaa, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzaa, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzaa, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) zza.zza(parcel, zzaa, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) zza.zza(parcel, zzaa, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzaa, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) zza.zza(parcel, zzaa, HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzaa, FullTextSearchFilter.CREATOR);
                    break;
                case 9:
                    ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzaa, OwnedByMeFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new zza.C0031zza("Overread allowed size end=" + zzab, parcel);
    }

    /* renamed from: zzdz */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }
}
