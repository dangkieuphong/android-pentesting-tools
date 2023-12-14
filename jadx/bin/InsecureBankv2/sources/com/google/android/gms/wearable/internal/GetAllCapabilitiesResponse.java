package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new zzae();
    public final int statusCode;
    public final int versionCode;
    final List<CapabilityInfoParcelable> zzaUq;

    GetAllCapabilitiesResponse(int versionCode2, int statusCode2, List<CapabilityInfoParcelable> capabilities) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUq = capabilities;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzae.zza(this, dest, flags);
    }
}
