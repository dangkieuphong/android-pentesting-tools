package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzjd;
import java.util.Set;

public final class zzjb extends zzi<zzjd> {

    private static final class zza extends zzja {
        private final zza.zzb<AppStateManager.StateDeletedResult> zzOs;

        public zza(zza.zzb<AppStateManager.StateDeletedResult> zzb) {
            this.zzOs = (zza.zzb) zzu.zzb(zzb, "Result holder must not be null");
        }

        @Override // com.google.android.gms.internal.zzja, com.google.android.gms.internal.zzjc
        public void zzg(int i, int i2) {
            this.zzOs.zzm(new zzb(new Status(i), i2));
        }
    }

    private static final class zzb implements AppStateManager.StateDeletedResult {
        private final Status zzOt;
        private final int zzOu;

        public zzb(Status status, int i) {
            this.zzOt = status;
            this.zzOu = i;
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateDeletedResult
        public int getStateKey() {
            return this.zzOu;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private static final class zzc extends zzja {
        private final zza.zzb<AppStateManager.StateListResult> zzOs;

        public zzc(zza.zzb<AppStateManager.StateListResult> zzb) {
            this.zzOs = (zza.zzb) zzu.zzb(zzb, "Result holder must not be null");
        }

        @Override // com.google.android.gms.internal.zzja, com.google.android.gms.internal.zzjc
        public void zza(DataHolder dataHolder) {
            this.zzOs.zzm(new zzd(dataHolder));
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zzc implements AppStateManager.StateListResult {
        private final AppStateBuffer zzOv;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzOv = new AppStateBuffer(dataHolder);
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateListResult
        public AppStateBuffer getStateBuffer() {
            return this.zzOv;
        }
    }

    private static final class zze extends zzja {
        private final zza.zzb<AppStateManager.StateResult> zzOs;

        public zze(zza.zzb<AppStateManager.StateResult> zzb) {
            this.zzOs = (zza.zzb) zzu.zzb(zzb, "Result holder must not be null");
        }

        @Override // com.google.android.gms.internal.zzja, com.google.android.gms.internal.zzjc
        public void zza(int i, DataHolder dataHolder) {
            this.zzOs.zzm(new zzf(i, dataHolder));
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zzc implements AppStateManager.StateConflictResult, AppStateManager.StateLoadedResult, AppStateManager.StateResult {
        private final int zzOu;
        private final AppStateBuffer zzOv;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzOu = i;
            this.zzOv = new AppStateBuffer(dataHolder);
        }

        private boolean zzkX() {
            return this.zzOt.getStatusCode() == 2000;
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateResult
        public AppStateManager.StateConflictResult getConflictResult() {
            if (zzkX()) {
                return this;
            }
            return null;
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateResult
        public AppStateManager.StateLoadedResult getLoadedResult() {
            if (zzkX()) {
                return null;
            }
            return this;
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateConflictResult
        public byte[] getLocalData() {
            if (this.zzOv.getCount() == 0) {
                return null;
            }
            return this.zzOv.get(0).getLocalData();
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateConflictResult
        public String getResolvedVersion() {
            if (this.zzOv.getCount() == 0) {
                return null;
            }
            return this.zzOv.get(0).getConflictVersion();
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateConflictResult
        public byte[] getServerData() {
            if (this.zzOv.getCount() == 0) {
                return null;
            }
            return this.zzOv.get(0).getConflictData();
        }

        @Override // com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateConflictResult
        public int getStateKey() {
            return this.zzOu;
        }

        @Override // com.google.android.gms.common.api.zzc, com.google.android.gms.common.api.Releasable
        public void release() {
            this.zzOv.release();
        }
    }

    private static final class zzg extends zzja {
        private final zza.zzb<Status> zzOs;

        public zzg(zza.zzb<Status> zzb) {
            this.zzOs = (zza.zzb) zzu.zzb(zzb, "Holder must not be null");
        }

        @Override // com.google.android.gms.internal.zzja, com.google.android.gms.internal.zzjc
        public void zzkU() {
            this.zzOs.zzm(new Status(0));
        }
    }

    public zzjb(Context context, Looper looper, com.google.android.gms.common.internal.zze zze2, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, connectionCallbacks, onConnectionFailedListener, zze2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.appstate.service.START";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresSignIn() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Set<Scope> zza(Set<Scope> set) {
        zzu.zza(set.contains(new Scope(Scopes.APP_STATE)), String.format("App State APIs requires %s to function.", Scopes.APP_STATE));
        return set;
    }

    public void zza(zza.zzb<AppStateManager.StateListResult> zzb2) throws RemoteException {
        ((zzjd) zznM()).zza(new zzc(zzb2));
    }

    public void zza(zza.zzb<AppStateManager.StateDeletedResult> zzb2, int i) throws RemoteException {
        ((zzjd) zznM()).zzb(new zza(zzb2), i);
    }

    public void zza(zza.zzb<AppStateManager.StateResult> zzb2, int i, String str, byte[] bArr) throws RemoteException {
        ((zzjd) zznM()).zza(new zze(zzb2), i, str, bArr);
    }

    public void zza(zza.zzb<AppStateManager.StateResult> zzb2, int i, byte[] bArr) throws RemoteException {
        ((zzjd) zznM()).zza(zzb2 == null ? null : new zze(zzb2), i, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaj */
    public zzjd zzT(IBinder iBinder) {
        return zzjd.zza.zzal(iBinder);
    }

    public void zzb(zza.zzb<Status> zzb2) throws RemoteException {
        ((zzjd) zznM()).zzb(new zzg(zzb2));
    }

    public void zzb(zza.zzb<AppStateManager.StateResult> zzb2, int i) throws RemoteException {
        ((zzjd) zznM()).zza(new zze(zzb2), i);
    }

    public int zzkV() {
        try {
            return ((zzjd) zznM()).zzkV();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzkW() {
        try {
            return ((zzjd) zznM()).zzkW();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
