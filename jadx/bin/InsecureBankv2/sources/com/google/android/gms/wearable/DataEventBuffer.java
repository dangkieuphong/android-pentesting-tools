package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzw;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status zzOt;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzOt = new Status(dataHolder.getStatusCode());
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    public String zzni() {
        return "path";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzu */
    public DataEvent zzj(int i, int i2) {
        return new zzw(this.zzWu, i, i2);
    }
}
