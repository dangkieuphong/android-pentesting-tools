package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new zzag();
    final int zzCY;
    final String zzafL;
    final boolean zzafM;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.zzCY = versionCode;
        this.zzafL = uniqueIdentifier;
        this.zzafM = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
