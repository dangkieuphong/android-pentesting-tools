package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DeleteDataItemsResponse implements SafeParcelable {
    public static final Parcelable.Creator<DeleteDataItemsResponse> CREATOR = new zzad();
    public final int statusCode;
    public final int versionCode;
    public final int zzaUp;

    DeleteDataItemsResponse(int versionCode2, int statusCode2, int numDeleted) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUp = numDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags);
    }
}
