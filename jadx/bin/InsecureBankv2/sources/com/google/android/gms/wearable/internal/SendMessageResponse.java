package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SendMessageResponse implements SafeParcelable {
    public static final Parcelable.Creator<SendMessageResponse> CREATOR = new zzbe();
    public final int statusCode;
    public final int versionCode;
    public final int zzaxg;

    SendMessageResponse(int versionCode2, int statusCode2, int requestId) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaxg = requestId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbe.zza(this, dest, flags);
    }
}
