package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzb;

public final class PublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<PublishRequest> CREATOR = new zzi();
    final int zzCY;
    public final MessageWrapper zzaGb;
    public final Strategy zzaGc;
    public final zzb zzaGd;
    public final String zzaGe;
    public final String zzayp;

    PublishRequest(int versionCode, MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName) {
        this.zzCY = versionCode;
        this.zzaGb = messageWrapper;
        this.zzaGc = strategy;
        this.zzaGd = zzb.zza.zzde(callbackAsBinder);
        this.zzayp = zeroPartyPackageName;
        this.zzaGe = realClientPackageName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxa() {
        return this.zzaGd.asBinder();
    }
}
