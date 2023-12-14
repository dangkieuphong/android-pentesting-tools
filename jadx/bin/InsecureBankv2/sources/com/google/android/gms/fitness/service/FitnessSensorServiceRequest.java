package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zza();
    public static final int UNSPECIFIED = -1;
    private final int zzCY;
    private final DataSource zzajG;
    private final zzj zzamr;
    private final long zzana;
    private final long zzanb;

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.zzCY = versionCode;
        this.zzajG = dataSource;
        this.zzamr = zzj.zza.zzbh(listenerBinder);
        this.zzana = samplingRateMicros;
        this.zzanb = batchIntervalMicros;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzt.equal(this.zzajG, fitnessSensorServiceRequest.zzajG) && this.zzana == fitnessSensorServiceRequest.zzana && this.zzanb == fitnessSensorServiceRequest.zzanb;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzanb, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzamr);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        if (this.zzana == -1) {
            return -1;
        }
        return timeUnit.convert(this.zzana, TimeUnit.MICROSECONDS);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajG, Long.valueOf(this.zzana), Long.valueOf(this.zzanb));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", this.zzajG);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public long zzqL() {
        return this.zzana;
    }

    public long zzrB() {
        return this.zzanb;
    }

    /* access modifiers changed from: package-private */
    public IBinder zzrl() {
        return this.zzamr.asBinder();
    }
}
