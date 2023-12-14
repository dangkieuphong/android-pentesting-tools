package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;

public class DeleteAllUserDataRequest implements SafeParcelable {
    public static final Parcelable.Creator<DeleteAllUserDataRequest> CREATOR = new zzk();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;

    DeleteAllUserDataRequest(int versionCode, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzalN = zzmu.zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN.asBinder();
    }
}
