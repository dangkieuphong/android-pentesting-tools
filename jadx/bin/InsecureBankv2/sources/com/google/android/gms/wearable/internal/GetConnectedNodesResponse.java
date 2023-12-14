package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new zzam();
    public final int statusCode;
    public final int versionCode;
    public final List<NodeParcelable> zzaUw;

    GetConnectedNodesResponse(int versionCode2, int statusCode2, List<NodeParcelable> nodes) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUw = nodes;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzam.zza(this, dest, flags);
    }
}
