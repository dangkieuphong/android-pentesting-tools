package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveLocalCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<RemoveLocalCapabilityResponse> CREATOR = new zzbd();
    public final int statusCode;
    public final int versionCode;

    RemoveLocalCapabilityResponse(int versionCode2, int statusCode2) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbd.zza(this, dest, flags);
    }
}
