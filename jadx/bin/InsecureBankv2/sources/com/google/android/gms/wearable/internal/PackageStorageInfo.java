package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PackageStorageInfo implements SafeParcelable {
    public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new zzba();
    public final String label;
    public final String packageName;
    public final int versionCode;
    public final long zzaUN;

    PackageStorageInfo(int versionCode2, String packageName2, String label2, long totalSizeBytes) {
        this.versionCode = versionCode2;
        this.packageName = packageName2;
        this.label = label2;
        this.zzaUN = totalSizeBytes;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzba.zza(this, out, flags);
    }
}
