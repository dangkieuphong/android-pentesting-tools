package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter extends AbstractFilter {
    public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();
    final int zzCY;
    final FilterHolder zzaig;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.zzCY = versionCode;
        this.zzaig = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.android.gms.drive.query.internal.zzf<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.drive.query.Filter
    public <T> T zza(zzf<T> zzf) {
        return (T) zzf.zzv(this.zzaig.getFilter().zza(zzf));
    }
}
