package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class GetConfigsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigsResponse> CREATOR = new zzal();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration[] zzaUv;

    GetConfigsResponse(int versionCode2, int statusCode2, ConnectionConfiguration[] configs) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUv = configs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzal.zza(this, dest, flags);
    }
}
