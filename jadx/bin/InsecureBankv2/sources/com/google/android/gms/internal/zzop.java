package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzi;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;

public final class zzop extends zzi<zzos> {
    private final long zzaoX = ((long) hashCode());

    private static final class zza extends zzb {
        private final zza.zzb<Status> zzOs;

        public zza(zza.zzb<Status> zzb, com.google.android.gms.common.api.zzi<Connections.MessageListener> zzi) {
            super(zzi);
            this.zzOs = (zza.zzb) zzu.zzu(zzb);
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void zzia(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    private static class zzb extends zzoo {
        private final com.google.android.gms.common.api.zzi<Connections.MessageListener> zzaFr;

        zzb(com.google.android.gms.common.api.zzi<Connections.MessageListener> zzi) {
            this.zzaFr = zzi;
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzaFr.zza(new zzi.zzb<Connections.MessageListener>() {
                /* class com.google.android.gms.internal.zzop.zzb.AnonymousClass2 */

                /* renamed from: zza */
                public void zzn(Connections.MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzaFr.zza(new zzi.zzb<Connections.MessageListener>() {
                /* class com.google.android.gms.internal.zzop.zzb.AnonymousClass1 */

                /* renamed from: zza */
                public void zzn(Connections.MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }
    }

    private static final class zzc extends zzb {
        private final zza.zzb<Status> zzOs;
        private final com.google.android.gms.common.api.zzi<Connections.ConnectionResponseCallback> zzaFv;

        public zzc(zza.zzb<Status> zzb, com.google.android.gms.common.api.zzi<Connections.ConnectionResponseCallback> zzi, com.google.android.gms.common.api.zzi<Connections.MessageListener> zzi2) {
            super(zzi2);
            this.zzOs = (zza.zzb) zzu.zzu(zzb);
            this.zzaFv = (com.google.android.gms.common.api.zzi) zzu.zzu(zzi);
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzaFv.zza(new zzi.zzb<Connections.ConnectionResponseCallback>() {
                /* class com.google.android.gms.internal.zzop.zzc.AnonymousClass1 */

                /* renamed from: zza */
                public void zzn(Connections.ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void zzhZ(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    private static final class zzd extends zzoo {
        private final zza.zzb<Connections.StartAdvertisingResult> zzOs;
        private final com.google.android.gms.common.api.zzi<Connections.ConnectionRequestListener> zzaFx;

        zzd(zza.zzb<Connections.StartAdvertisingResult> zzb, com.google.android.gms.common.api.zzi<Connections.ConnectionRequestListener> zzi) {
            this.zzOs = (zza.zzb) zzu.zzu(zzb);
            this.zzaFx = (com.google.android.gms.common.api.zzi) zzu.zzu(zzi);
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void onConnectionRequest(final String remoteEndpointId, final String remoteDeviceId, final String remoteEndpointName, final byte[] payload) throws RemoteException {
            this.zzaFx.zza(new zzi.zzb<Connections.ConnectionRequestListener>() {
                /* class com.google.android.gms.internal.zzop.zzd.AnonymousClass1 */

                /* renamed from: zza */
                public void zzn(Connections.ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(remoteEndpointId, remoteDeviceId, remoteEndpointName, payload);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void zzj(int i, String str) throws RemoteException {
            this.zzOs.zzm(new zze(new Status(i), str));
        }
    }

    private static final class zze implements Connections.StartAdvertisingResult {
        private final Status zzOt;
        private final String zzaFB;

        zze(Status status, String str) {
            this.zzOt = status;
            this.zzaFB = str;
        }

        @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
        public String getLocalEndpointName() {
            return this.zzaFB;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzf extends zzoo {
        private final zza.zzb<Status> zzOs;
        private final com.google.android.gms.common.api.zzi<Connections.EndpointDiscoveryListener> zzaFx;

        zzf(zza.zzb<Status> zzb, com.google.android.gms.common.api.zzi<Connections.EndpointDiscoveryListener> zzi) {
            this.zzOs = (zza.zzb) zzu.zzu(zzb);
            this.zzaFx = (com.google.android.gms.common.api.zzi) zzu.zzu(zzi);
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void onEndpointFound(final String endpointId, final String deviceId, final String serviceId, final String name) throws RemoteException {
            this.zzaFx.zza(new zzi.zzb<Connections.EndpointDiscoveryListener>() {
                /* class com.google.android.gms.internal.zzop.zzf.AnonymousClass1 */

                /* renamed from: zza */
                public void zzn(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(endpointId, deviceId, serviceId, name);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzaFx.zza(new zzi.zzb<Connections.EndpointDiscoveryListener>() {
                /* class com.google.android.gms.internal.zzop.zzf.AnonymousClass2 */

                /* renamed from: zza */
                public void zzn(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                @Override // com.google.android.gms.common.api.zzi.zzb
                public void zzmw() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
        public void zzhX(int i) throws RemoteException {
            this.zzOs.zzm(new Status(i));
        }
    }

    public zzop(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzos) zznM()).zzE(this.zzaoX);
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    public void zza(zza.zzb<Status> zzb2, String str, long j, com.google.android.gms.common.api.zzi<Connections.EndpointDiscoveryListener> zzi) throws RemoteException {
        ((zzos) zznM()).zza(new zzf(zzb2, zzi), str, j, this.zzaoX);
    }

    public void zza(zza.zzb<Connections.StartAdvertisingResult> zzb2, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.zzi<Connections.ConnectionRequestListener> zzi) throws RemoteException {
        ((zzos) zznM()).zza(new zzd(zzb2, zzi), str, appMetadata, j, this.zzaoX);
    }

    public void zza(zza.zzb<Status> zzb2, String str, String str2, byte[] bArr, com.google.android.gms.common.api.zzi<Connections.ConnectionResponseCallback> zzi, com.google.android.gms.common.api.zzi<Connections.MessageListener> zzi2) throws RemoteException {
        ((zzos) zznM()).zza(new zzc(zzb2, zzi, zzi2), str, str2, bArr, this.zzaoX);
    }

    public void zza(zza.zzb<Status> zzb2, String str, byte[] bArr, com.google.android.gms.common.api.zzi<Connections.MessageListener> zzi) throws RemoteException {
        ((zzos) zznM()).zza(new zza(zzb2, zzi), str, bArr, this.zzaoX);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzos) zznM()).zza(strArr, bArr, this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzos) zznM()).zzb(strArr, bArr, this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    public void zzdQ(String str) {
        try {
            ((zzos) zznM()).zzf(str, this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzdR(String str) {
        try {
            ((zzos) zznM()).zzg(str, this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzda */
    public zzos zzT(IBinder iBinder) {
        return zzos.zza.zzdc(iBinder);
    }

    public void zzp(final zza.zzb<Status> zzb2, String str) throws RemoteException {
        ((zzos) zznM()).zza(new zzoo() {
            /* class com.google.android.gms.internal.zzop.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzoo, com.google.android.gms.internal.zzor
            public void zzib(int i) throws RemoteException {
                zzb2.zzm(new Status(i));
            }
        }, str, this.zzaoX);
    }

    public String zzwR() {
        try {
            return ((zzos) zznM()).zzQ(this.zzaoX);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String zzwS() {
        try {
            return ((zzos) zznM()).zzwS();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzwT() {
        try {
            ((zzos) zznM()).zzN(this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzwU() {
        try {
            ((zzos) zznM()).zzP(this.zzaoX);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
