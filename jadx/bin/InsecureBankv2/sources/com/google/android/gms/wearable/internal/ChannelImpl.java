package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.internal.zzi;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzl();
    final int zzCY;
    private final String zzaST;
    private final String zzaTK;
    private final String zzaTQ;

    /* access modifiers changed from: package-private */
    public static final class zza implements Channel.GetInputStreamResult {
        private final Status zzOt;
        private final InputStream zzaTV;

        zza(Status status, InputStream inputStream) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTV = inputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetInputStreamResult
        public InputStream getInputStream() {
            return this.zzaTV;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaTV != null) {
                try {
                    this.zzaTV.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzb implements Channel.GetOutputStreamResult {
        private final Status zzOt;
        private final OutputStream zzaTW;

        zzb(Status status, OutputStream outputStream) {
            this.zzOt = (Status) zzu.zzu(status);
            this.zzaTW = outputStream;
        }

        @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
        public OutputStream getOutputStream() {
            return this.zzaTW;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaTW != null) {
                try {
                    this.zzaTW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.zzCY = versionCode;
        this.zzaTK = (String) zzu.zzu(token);
        this.zzaST = (String) zzu.zzu(nodeId);
        this.zzaTQ = (String) zzu.zzu(path);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> addListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        zzu.zzb(client, "client is null");
        zzu.zzb(listener, "listener is null");
        return client.zza(new zzi.zza(client, listener, this.zzaTK));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zzb(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzt(this, ChannelImpl.this.zzaTK);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zzb(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzh(this, ChannelImpl.this.zzaTK, errorCode);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzaTK.equals(channelImpl.zzaTK) && zzt.equal(channelImpl.zzaST, this.zzaST) && zzt.equal(channelImpl.zzaTQ, this.zzaTQ) && channelImpl.zzCY == this.zzCY;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zzb(new zzf<Channel.GetInputStreamResult>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzu(this, ChannelImpl.this.zzaTK);
            }

            /* renamed from: zzbb */
            public Channel.GetInputStreamResult createFailedResult(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getNodeId() {
        return this.zzaST;
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zzb(new zzf<Channel.GetOutputStreamResult>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzv(this, ChannelImpl.this.zzaTK);
            }

            /* renamed from: zzbc */
            public Channel.GetOutputStreamResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public String getPath() {
        return this.zzaTQ;
    }

    public String getToken() {
        return this.zzaTK;
    }

    public int hashCode() {
        return this.zzaTK.hashCode();
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        zzu.zzb(client, "client is null");
        zzu.zzb(uri, "uri is null");
        return client.zzb(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, ChannelImpl.this.zzaTK, uri, append);
            }

            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        zzu.zzb(client, "client is null");
        zzu.zzb(listener, "listener is null");
        return client.zza(new zzi.zzc(client, listener, this.zzaTK));
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    @Override // com.google.android.gms.wearable.Channel
    public PendingResult<Status> sendFile(GoogleApiClient client, final Uri uri, final long startOffset, final long length) {
        zzu.zzb(client, "client is null");
        zzu.zzb(this.zzaTK, "token is null");
        zzu.zzb(uri, "uri is null");
        zzu.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        zzu.zzb(length >= 0 || length == -1, "invalid length: %s", Long.valueOf(length));
        return client.zzb(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.ChannelImpl.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, ChannelImpl.this.zzaTK, uri, startOffset, length);
            }

            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.zzCY + ", token='" + this.zzaTK + '\'' + ", nodeId='" + this.zzaST + '\'' + ", path='" + this.zzaTQ + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
