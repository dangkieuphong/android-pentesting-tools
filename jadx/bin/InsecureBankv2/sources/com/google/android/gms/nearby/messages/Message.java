package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public class Message implements SafeParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new zza();
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzaby;

    Message(int versionCode2, byte[] content2, String namespace, String type2) {
        zzu.zzb(content2.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(content2.length), 102400);
        this.versionCode = versionCode2;
        this.content = (byte[]) zzu.zzu(content2);
        this.type = (String) zzu.zzu(type2);
        this.zzaby = namespace == null ? "" : namespace;
    }

    public int describeContents() {
        return 0;
    }

    public String getNamespace() {
        return this.zzaby;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return "Message{type='" + this.type + "'" + ", namespace='" + this.zzaby + "'" + ", content=[" + this.content.length + " bytes]" + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public byte[] zzwV() {
        return this.content;
    }
}
