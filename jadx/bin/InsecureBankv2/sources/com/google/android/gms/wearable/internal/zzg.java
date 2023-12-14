package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzg implements CapabilityApi {

    private static final class zza extends zzf<Status> {
        private CapabilityApi.CapabilityListener zzaTC;
        private String zzaTD;

        private zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaTC = capabilityListener;
            this.zzaTD = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zza(this, this.zzaTC, this.zzaTD);
            this.zzaTC = null;
            this.zzaTD = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaTC = null;
            this.zzaTD = null;
            return status;
        }
    }

    public static class zzb implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
        private final Status zzOt;

        public zzb(Status status) {
            this.zzOt = status;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzaTE;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzaTE = set;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public Set<Node> getNodes() {
            return this.zzaTE;
        }
    }

    public static class zzd implements CapabilityApi.GetAllCapabilitiesResult {
        private final Status zzOt;
        private final Map<String, CapabilityInfo> zzaTF;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzOt = status;
            this.zzaTF = map;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzaTF;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zze implements CapabilityApi.GetCapabilityResult {
        private final Status zzOt;
        private final CapabilityInfo zzaTG;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzOt = status;
            this.zzaTG = capabilityInfo;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
        public CapabilityInfo getCapability() {
            return this.zzaTG;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzf extends zzf<Status> {
        private CapabilityApi.CapabilityListener zzaTC;
        private String zzaTD;

        private zzf(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaTC = capabilityListener;
            this.zzaTD = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zzb(this, this.zzaTC, this.zzaTD);
            this.zzaTC = null;
            this.zzaTD = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaTC = null;
            this.zzaTD = null;
            return status;
        }
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener, String capability) {
        return client.zza(new zza(client, listener, capability));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzf<CapabilityApi.AddLocalCapabilityResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzg.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzr(this, capability);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzaY */
            public CapabilityApi.AddLocalCapabilityResult createFailedResult(Status status) {
                return new zzb(status);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, final int filter) {
        return client.zza(new zzf<CapabilityApi.GetAllCapabilitiesResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzg.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzd(this, filter);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzaX */
            public CapabilityApi.GetAllCapabilitiesResult createFailedResult(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient client, final String capability, final int filter) {
        return client.zza(new zzf<CapabilityApi.GetCapabilityResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzg.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzg(this, capability, filter);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzaW */
            public CapabilityApi.GetCapabilityResult createFailedResult(Status status) {
                return new zze(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener, String capability) {
        return client.zza(new zzf(client, listener, capability));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzf<CapabilityApi.RemoveLocalCapabilityResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzg.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzs(this, capability);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzaZ */
            public CapabilityApi.RemoveLocalCapabilityResult createFailedResult(Status status) {
                return new zzb(status);
            }
        });
    }
}
