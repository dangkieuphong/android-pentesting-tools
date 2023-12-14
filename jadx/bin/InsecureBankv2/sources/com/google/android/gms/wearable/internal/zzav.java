package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

public final class zzav implements MessageApi {

    /* access modifiers changed from: private */
    public static final class zza extends zzf<Status> {
        private MessageApi.MessageListener zzaUF;
        private IntentFilter[] zzaUk;

        private zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaUF = messageListener;
            this.zzaUk = intentFilterArr;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zza(this, this.zzaUF, this.zzaUk);
            this.zzaUF = null;
            this.zzaUk = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaUF = null;
            this.zzaUk = null;
            return status;
        }
    }

    public static class zzb implements MessageApi.SendMessageResult {
        private final Status zzOt;
        private final int zzacR;

        public zzb(Status status, int i) {
            this.zzOt = status;
            this.zzacR = i;
        }

        @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
        public int getRequestId() {
            return this.zzacR;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, intentFilterArr));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> addListener(GoogleApiClient client, MessageApi.MessageListener listener) {
        return zza(client, listener, null);
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageApi.MessageListener listener) {
        return client.zza(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.zzav.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, listener);
            }

            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient client, final String nodeId, final String action, final byte[] data) {
        return client.zza(new zzf<MessageApi.SendMessageResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzav.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, nodeId, action, data);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbh */
            public MessageApi.SendMessageResult createFailedResult(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
