package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzmh;

public class DataTypeReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();
    private final String mName;
    private final int zzCY;
    private final String zzMZ;
    private final zzmh zzamk;

    DataTypeReadRequest(int versionCode, String name, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.mName = name;
        this.zzamk = callback == null ? null : zzmh.zza.zzbs(callback);
        this.zzMZ = packageName;
    }

    public DataTypeReadRequest(String name, zzmh callback, String packageName) {
        this.zzCY = 2;
        this.mName = name;
        this.zzamk = callback;
        this.zzMZ = packageName;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return zzt.equal(this.mName, dataTypeReadRequest.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) o));
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.mName);
    }

    public String toString() {
        return zzt.zzt(this).zzg("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public IBinder zzqU() {
        return this.zzamk.asBinder();
    }
}
