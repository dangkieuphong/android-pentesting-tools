package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private static final List<Integer> zzaxL = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));
    private static final List<Integer> zzaxM = Collections.unmodifiableList(Arrays.asList(1));
    private static final List<Integer> zzaxN = Collections.unmodifiableList(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 19));
    private static final List<Integer> zzaxO = Collections.unmodifiableList(Arrays.asList(3, 5, 7, 9, 11, 13, 15, 17));
    private final int zzCY;
    private final List<Integer> zzaxP;

    GestureRequest(int versionCode, List<Integer> gestureTypes) {
        this.zzCY = versionCode;
        this.zzaxP = gestureTypes;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public List<Integer> zzuo() {
        return this.zzaxP;
    }
}
