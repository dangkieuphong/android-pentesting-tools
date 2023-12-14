package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class MessageType implements SafeParcelable {
    public static final Parcelable.Creator<MessageType> CREATOR = new zzd();
    public final String type;
    final int versionCode;
    public final String zzaby;

    MessageType(int versionCode2, String namespace, String type2) {
        this.versionCode = versionCode2;
        this.zzaby = namespace;
        this.type = type2;
    }

    public MessageType(String namespace, String type2) {
        this(1, namespace, type2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) o;
        return zzt.equal(this.zzaby, messageType.zzaby) && zzt.equal(this.type, messageType.type);
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaby, this.type);
    }

    public String toString() {
        return "namespace=" + this.zzaby + ", type=" + this.type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
