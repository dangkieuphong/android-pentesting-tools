package com.google.android.gms.nearby.sharing;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class AppContentReceivedResult implements SafeParcelable {
    public static final Parcelable.Creator<AppContentReceivedResult> CREATOR = new zza();
    private int statusCode;
    private final int versionCode;
    private Uri zzaGj;

    private AppContentReceivedResult() {
        this.versionCode = 1;
    }

    AppContentReceivedResult(int versionCode2, Uri destinationUri, int statusCode2) {
        this.versionCode = versionCode2;
        this.zzaGj = destinationUri;
        this.statusCode = statusCode2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AppContentReceivedResult)) {
            return false;
        }
        AppContentReceivedResult appContentReceivedResult = (AppContentReceivedResult) o;
        return zzt.equal(this.zzaGj, appContentReceivedResult.zzaGj) && zzt.equal(Integer.valueOf(this.statusCode), Integer.valueOf(appContentReceivedResult.statusCode));
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaGj, Integer.valueOf(this.statusCode));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Uri zzxc() {
        return this.zzaGj;
    }
}
