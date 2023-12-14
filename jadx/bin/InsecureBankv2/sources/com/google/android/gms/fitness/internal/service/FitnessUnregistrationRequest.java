package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class FitnessUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessUnregistrationRequest> CREATOR = new zzb();
    private final int zzCY;
    private final DataSource zzajG;

    FitnessUnregistrationRequest(int versionCode, DataSource dataSource) {
        this.zzCY = versionCode;
        this.zzajG = dataSource;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", this.zzajG);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
