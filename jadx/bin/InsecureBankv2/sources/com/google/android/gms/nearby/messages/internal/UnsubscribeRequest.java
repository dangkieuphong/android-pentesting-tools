package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zza;
import com.google.android.gms.nearby.messages.internal.zzb;

public final class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzl();
    final int zzCY;
    public final zzb zzaGd;
    public final String zzaGe;
    public final zza zzaGf;
    public final PendingIntent zzaGh;
    public final int zzaGi;
    public final String zzayp;

    UnsubscribeRequest(int versionCode, IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName) {
        this.zzCY = versionCode;
        this.zzaGf = zza.AbstractBinderC0204zza.zzdd(messageListener);
        this.zzaGd = zzb.zza.zzde(callbackAsBinder);
        this.zzaGh = pendingIntent;
        this.zzaGi = messageListenerKey;
        this.zzayp = zeroPartyPackageName;
        this.zzaGe = realClientPackageName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxa() {
        return this.zzaGd.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxb() {
        if (this.zzaGf == null) {
            return null;
        }
        return this.zzaGf.asBinder();
    }
}
