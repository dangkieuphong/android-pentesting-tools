package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final zza CREATOR = new zza();
    final int zzCY;
    final Operator zzahQ;
    final MetadataBundle zzahR;
    final MetadataField<T> zzahS;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.zzCY = versionCode;
        this.zzahQ = operator;
        this.zzahR = value;
        this.zzahS = (MetadataField<T>) zze.zzb(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.zza(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) this.zzahR.zza(this.zzahS);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzahQ, this.zzahS, getValue());
    }
}
