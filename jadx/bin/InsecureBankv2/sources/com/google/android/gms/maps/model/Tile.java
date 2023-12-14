package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Tile implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public final byte[] data;
    public final int height;
    public final int width;
    private final int zzCY;

    Tile(int versionCode, int width2, int height2, byte[] data2) {
        this.zzCY = versionCode;
        this.width = width2;
        this.height = height2;
        this.data = data2;
    }

    public Tile(int width2, int height2, byte[] data2) {
        this(1, width2, height2, data2);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }
}
