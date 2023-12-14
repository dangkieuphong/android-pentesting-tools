package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzol zzaFk;
    private final zzon zzaFm;

    StartScanRequest(int versionCode2, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode2;
        zzu.zzu(scanListener);
        this.zzaFm = zzon.zza.zzcZ(scanListener);
        zzu.zzu(callback);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zzg zzg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzqU() {
        if (this.zzaFk == null) {
            return null;
        }
        return this.zzaFk.asBinder();
    }

    public IBinder zzwQ() {
        if (this.zzaFm == null) {
            return null;
        }
        return this.zzaFm.asBinder();
    }
}
