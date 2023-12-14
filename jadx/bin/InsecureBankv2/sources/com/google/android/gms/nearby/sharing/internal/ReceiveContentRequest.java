package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza;
import com.google.android.gms.nearby.sharing.internal.zzc;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzaGp;
    public zzc zzaGt;
    public zza zzaGu;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode2, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName2, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaGp = clientBinder;
        this.zzaGu = zza.AbstractBinderC0208zza.zzdh(contentReceiverAsBinder);
        this.packageName = packageName2;
        this.zzaGt = zzc.zza.zzdj(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxa() {
        return this.zzaGt.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxj() {
        if (this.zzaGu == null) {
            return null;
        }
        return this.zzaGu.asBinder();
    }
}
