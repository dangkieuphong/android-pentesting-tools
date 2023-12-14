package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetChannelInputStreamResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetChannelInputStreamResponse> CREATOR = new zzag();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaUs;

    GetChannelInputStreamResponse(int versionCode2, int statusCode2, ParcelFileDescriptor fileDescriptor) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUs = fileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
