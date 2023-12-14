package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncSettingResponse> CREATOR = new zzaj();
    public final boolean enabled;
    public final int statusCode;
    public final int versionCode;

    GetCloudSyncSettingResponse(int versionCode2, int statusCode2, boolean enabled2) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.enabled = enabled2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaj.zza(this, dest, flags);
    }
}
