package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class CreateContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateContentsRequest> CREATOR = new zzi();
    final int zzCY;
    final int zzacS;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.zzCY = versionCode;
        zzu.zzb(mode == 536870912 || mode == 805306368, "Cannot create a new read-only contents!");
        this.zzacS = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
