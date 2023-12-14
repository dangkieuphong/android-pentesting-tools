package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.ArrayList;
import java.util.List;

public final class zzax implements NodeApi {

    private static final class zza extends zzf<Status> {
        private NodeApi.NodeListener zzaUI;

        private zza(GoogleApiClient googleApiClient, NodeApi.NodeListener nodeListener) {
            super(googleApiClient);
            this.zzaUI = nodeListener;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zza(this, this.zzaUI);
            this.zzaUI = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaUI = null;
            return status;
        }
    }

    public static class zzb implements NodeApi.GetConnectedNodesResult {
        private final Status zzOt;
        private final List<Node> zzaUJ;

        public zzb(Status status, List<Node> list) {
            this.zzOt = status;
            this.zzaUJ = list;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
        public List<Node> getNodes() {
            return this.zzaUJ;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements NodeApi.GetLocalNodeResult {
        private final Status zzOt;
        private final Node zzaUK;

        public zzc(Status status, Node node) {
            this.zzOt = status;
            this.zzaUK = node;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
        public Node getNode() {
            return this.zzaUK;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<Status> addListener(GoogleApiClient client, NodeApi.NodeListener listener) {
        return client.zza(new zza(client, listener));
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzf<NodeApi.GetConnectedNodesResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzax.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzn(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbj */
            public NodeApi.GetConnectedNodesResult createFailedResult(Status status) {
                return new zzb(status, new ArrayList());
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzf<NodeApi.GetLocalNodeResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzax.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzm(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbi */
            public NodeApi.GetLocalNodeResult createFailedResult(Status status) {
                return new zzc(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeApi.NodeListener listener) {
        return client.zza(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.zzax.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzb(this, listener);
            }

            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }
}
