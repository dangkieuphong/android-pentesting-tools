package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzu;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzOt;
    private final PendingResult<?>[] zzWq;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.zzOt = status;
        this.zzWq = pendingResults;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        zzu.zzb(resultToken.mId < this.zzWq.length, "The result token does not belong to this batch");
        return (R) this.zzWq[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
