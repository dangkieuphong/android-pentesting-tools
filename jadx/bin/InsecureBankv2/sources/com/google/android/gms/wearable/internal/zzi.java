package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

public final class zzi implements ChannelApi {

    static final class zza extends zzf<Status> {
        private final String zzaTK;
        private ChannelApi.ChannelListener zzaTL;

        zza(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelApi.ChannelListener) zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zza(this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzb implements ChannelApi.OpenChannelResult {
        private final Status zzOt;
        private final Channel zzaTM;

        zzb(Status status, Channel channel) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTM = channel;
        }

        @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
        public Channel getChannel() {
            return this.zzaTM;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static final class zzc extends zzf<Status> {
        private final String zzaTK;
        private ChannelApi.ChannelListener zzaTL;

        zzc(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelApi.ChannelListener) zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zzb(this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> addListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        zzu.zzb(client, "client is null");
        zzu.zzb(listener, "listener is null");
        return client.zza(new zza(client, listener, null));
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient client, final String nodeId, final String path) {
        zzu.zzb(client, "client is null");
        zzu.zzb(nodeId, "nodeId is null");
        zzu.zzb(path, "path is null");
        return client.zzb(new zzf<ChannelApi.OpenChannelResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzi.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zze(this, nodeId, path);
            }

            /* renamed from: zzba */
            public ChannelApi.OpenChannelResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        zzu.zzb(client, "client is null");
        zzu.zzb(listener, "listener is null");
        return client.zza(new zzc(client, listener, null));
    }
}
