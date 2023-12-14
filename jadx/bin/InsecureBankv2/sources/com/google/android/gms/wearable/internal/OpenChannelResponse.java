package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator<OpenChannelResponse> CREATOR = new zzaz();
    public final int statusCode;
    public final int versionCode;
    public final ChannelImpl zzaTP;

    OpenChannelResponse(int versionCode2, int statusCode2, ChannelImpl channel) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaTP = channel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
