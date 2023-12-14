package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzh();
    String description;
    private final int zzCY;
    String zzaGl;

    UriData() {
        this.zzCY = 1;
    }

    UriData(int versionCode, String uri, String description2) {
        this.zzCY = versionCode;
        this.zzaGl = uri;
        this.description = description2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
