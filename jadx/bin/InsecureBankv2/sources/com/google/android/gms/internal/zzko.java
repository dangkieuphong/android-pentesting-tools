package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;

abstract class zzko<R extends Result> extends zza.AbstractC0027zza<R, zzkp> {

    /* access modifiers changed from: package-private */
    public static abstract class zza extends zzko<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    public zzko(GoogleApiClient googleApiClient) {
        super(zzkl.zzNX, googleApiClient);
    }
}
