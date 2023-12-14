package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final zzi CREATOR = new zzi();
    final int zzCY;
    final MetadataBundle zzahR;
    final MetadataField<T> zzahS;

    HasFilter(int versionCode, MetadataBundle value) {
        this.zzCY = versionCode;
        this.zzahR = value;
        this.zzahS = (MetadataField<T>) zze.zzb(value);
    }

    public HasFilter(SearchableMetadataField<T> field, T value) {
        this(1, MetadataBundle.zza(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) this.zzahR.zza(this.zzahS);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzd(this.zzahS, getValue());
    }
}
