package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetLocalNodeResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetLocalNodeResponse> CREATOR = new zzap();
    public final int statusCode;
    public final int versionCode;
    public final NodeParcelable zzaUz;

    GetLocalNodeResponse(int versionCode2, int statusCode2, NodeParcelable node) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUz = node;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }
}
