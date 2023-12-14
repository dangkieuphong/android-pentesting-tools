package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR = new zzo();
    final int zzCY;

    public OwnedByMeFilter() {
        this(1);
    }

    OwnedByMeFilter(int versionCode) {
        this.zzCY = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzqe();
    }
}
