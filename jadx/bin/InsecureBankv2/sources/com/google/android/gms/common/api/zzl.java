package com.google.android.gms.common.api;

import android.os.Looper;

public class zzl extends AbstractPendingResult<Status> {
    public zzl(Looper looper) {
        super(looper);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzb */
    public Status createFailedResult(Status status) {
        return status;
    }
}
