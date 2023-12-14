package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzCY;
    final String zzMZ;
    final String zzNa;
    final String zzNb;

    DocumentId(int versionCode, String packageName, String corpusName, String uri) {
        this.zzCY = versionCode;
        this.zzMZ = packageName;
        this.zzNa = corpusName;
        this.zzNb = uri;
    }

    public DocumentId(String packageName, String corpusName, String uri) {
        this(1, packageName, corpusName, uri);
    }

    public int describeContents() {
        zzc zzc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", this.zzMZ, this.zzNa, this.zzNb);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc zzc = CREATOR;
        zzc.zza(this, dest, flags);
    }
}
