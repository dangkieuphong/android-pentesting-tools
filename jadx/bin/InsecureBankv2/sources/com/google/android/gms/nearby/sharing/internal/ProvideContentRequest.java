package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzaGp;
    public zzb zzaGq;
    @Deprecated
    public List<SharedContent> zzaGr;
    public long zzaGs;
    public zzc zzaGt;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int versionCode2, IBinder clientBinder, IBinder contentProviderAsBinder, List<SharedContent> content, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaGp = clientBinder;
        this.zzaGq = zzb.zza.zzdi(contentProviderAsBinder);
        this.zzaGr = content;
        this.zzaGs = activityId;
        this.zzaGt = zzc.zza.zzdj(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxa() {
        return this.zzaGt.asBinder();
    }

    /* access modifiers changed from: package-private */
    public IBinder zzxi() {
        if (this.zzaGq == null) {
            return null;
        }
        return this.zzaGq.asBinder();
    }
}
