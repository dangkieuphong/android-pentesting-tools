package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class ClientIdentity implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final String packageName;
    public final int uid;
    private final int zzCY;

    ClientIdentity(int versionCode, int uid2, String packageName2) {
        this.zzCY = versionCode;
        this.uid = uid2;
        this.packageName = packageName2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) o;
        return clientIdentity.uid == this.uid && zzt.equal(clientIdentity.packageName, this.packageName);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        return String.format("%d:%s", Integer.valueOf(this.uid), this.packageName);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
