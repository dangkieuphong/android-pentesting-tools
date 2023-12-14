package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzai();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzaUt;

    GetCloudSyncOptInOutDoneResponse(int versionCode2, int statusCode2, boolean optInOutDone) {
        this.versionCode = versionCode2;
        this.statusCode = statusCode2;
        this.zzaUt = optInOutDone;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
