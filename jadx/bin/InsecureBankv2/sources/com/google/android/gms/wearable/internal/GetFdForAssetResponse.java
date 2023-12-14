package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetFdForAssetResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzao();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaUy;

    GetFdForAssetResponse(int versionCode2, int statusCode2, ParcelFileDescriptor pfd) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUy = pfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags | 1);
    }
}
