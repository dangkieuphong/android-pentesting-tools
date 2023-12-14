package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;

public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzol zzaFk;

    StopScanRequest(int versionCode2, IBinder callback) {
        this.versionCode = versionCode2;
        zzu.zzu(callback);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zzh zzh = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh zzh = CREATOR;
        zzh.zza(this, out, flags);
    }

    public IBinder zzqU() {
        if (this.zzaFk == null) {
            return null;
        }
        return this.zzaFk.asBinder();
    }
}
