package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class FullTextSearchFilter extends AbstractFilter {
    public static final zzh CREATOR = new zzh();
    final String mValue;
    final int zzCY;

    FullTextSearchFilter(int versionCode, String value) {
        this.zzCY = versionCode;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public <F> F zza(zzf<F> zzf) {
        return zzf.zzcC(this.mValue);
    }
}
