package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzol zzaFk;
    private final String zzaFl;

    ContinueConnectRequest(int versionCode2, String token, IBinder callback) {
        this.versionCode = versionCode2;
        this.zzaFl = (String) zzu.zzu(token);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public String getToken() {
        return this.zzaFl;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public IBinder zzqU() {
        if (this.zzaFk == null) {
            return null;
        }
        return this.zzaFk.asBinder();
    }
}
