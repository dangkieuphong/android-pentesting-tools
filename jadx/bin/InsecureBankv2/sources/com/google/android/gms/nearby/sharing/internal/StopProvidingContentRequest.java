package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc;

public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzaGs;
    public zzc zzaGt;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int versionCode2, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaGs = activityId;
        this.zzaGt = zzc.zza.zzdj(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxa() {
        return this.zzaGt.asBinder();
    }
}
