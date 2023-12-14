package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public abstract class zzh extends zzb<Status> {
    public zzh(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* renamed from: zzb */
    public Status createFailedResult(Status status) {
        return status;
    }
}
