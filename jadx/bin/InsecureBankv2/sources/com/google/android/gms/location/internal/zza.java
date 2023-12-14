package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.location.internal.zza$zza  reason: collision with other inner class name */
    private static abstract class AbstractC0152zza extends ActivityRecognition.zza<Status> {
        public AbstractC0152zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new AbstractC0152zza(client) {
            /* class com.google.android.gms.location.internal.zza.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, final long detectionIntervalMillis, final PendingIntent callbackIntent) {
        return client.zzb(new AbstractC0152zza(client) {
            /* class com.google.android.gms.location.internal.zza.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(detectionIntervalMillis, callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }
}
