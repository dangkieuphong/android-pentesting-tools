package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzu;

public final class PendingResults {

    private static final class zza<R extends Result> extends AbstractPendingResult<R> {
        private final R zzXN;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzXN = r;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        public R createFailedResult(Status status) {
            if (status.getStatusCode() == this.zzXN.getStatus().getStatusCode()) {
                return this.zzXN;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends AbstractPendingResult<R> {
        public zzb() {
            super(Looper.getMainLooper());
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        public R createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzl zzl = new zzl(Looper.getMainLooper());
        zzl.cancel();
        return zzl;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzu.zzb(result, "Result must not be null");
        zzu.zzb(result.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(result);
        zza2.cancel();
        return zza2;
    }

    public static <R extends Result> PendingResult<R> immediatePendingResult(R result) {
        zzu.zzb(result, "Result must not be null");
        zzb zzb2 = new zzb();
        zzb2.setResult(result);
        return zzb2;
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzu.zzb(result, "Result must not be null");
        zzl zzl = new zzl(Looper.getMainLooper());
        zzl.setResult(result);
        return zzl;
    }
}
