package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final zzj CREATOR = new zzj();
    final int zzCY;
    final MetadataBundle zzahR;
    private final zzb<T> zzaie;

    InFilter(int versionCode, MetadataBundle value) {
        this.zzCY = versionCode;
        this.zzahR = value;
        this.zzaie = (zzb) zze.zzb(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.zza(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return (T) ((Collection) this.zzahR.zza(this.zzaie)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzb(this.zzaie, getValue());
    }
}
