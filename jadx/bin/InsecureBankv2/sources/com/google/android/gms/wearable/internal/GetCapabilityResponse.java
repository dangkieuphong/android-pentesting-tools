package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCapabilityResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCapabilityResponse> CREATOR = new zzaf();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzaUr;

    GetCapabilityResponse(int versionCode2, int statusCode2, CapabilityInfoParcelable capability) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUr = capability;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaf.zza(this, dest, flags);
    }
}
