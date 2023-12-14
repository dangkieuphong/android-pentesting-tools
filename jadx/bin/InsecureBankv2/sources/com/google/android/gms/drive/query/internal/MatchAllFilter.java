package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter extends AbstractFilter {
    public static final zzl CREATOR = new zzl();
    final int zzCY;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.zzCY = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzqf();
    }
}
