package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDataItemResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetDataItemResponse> CREATOR = new zzan();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzaUx;

    GetDataItemResponse(int versionCode2, int statusCode2, DataItemParcelable dataItem) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUx = dataItem;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzan.zza(this, dest, flags);
    }
}
