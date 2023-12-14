package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.internal.zzak;
import com.google.android.gms.drive.internal.zzq;
import com.google.android.gms.drive.internal.zzr;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzs extends zzi<zzak> {
    private final String zzOe;
    final GoogleApiClient.ConnectionCallbacks zzaar;
    private final Bundle zzaeM;
    private final boolean zzaeN;
    private DriveId zzaeO;
    private DriveId zzaeP;
    final Map<DriveId, Map<ChangeListener, zzac>> zzaeQ = new HashMap();
    final Map<zzc, zzac> zzaeR = new HashMap();
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzac>> zzaeS = new HashMap();
    final Map<DriveId, Map<com.google.android.gms.drive.events.zzi, zzac>> zzaeT = new HashMap();

    public zzs(Context context, Looper looper, zze zze, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzOe = zze.zzny();
        this.zzaar = connectionCallbacks;
        this.zzaeM = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaeN = false;
                return;
            case 1:
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.zzaeN = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzu.zzb(zzg.zza(i, driveId), "id");
        zzu.zza(isConnected(), "Client must be connected");
        return googleApiClient.zzb(new zzr.zza(googleApiClient) {
            /* class com.google.android.gms.drive.internal.zzs.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new RemoveEventListenerRequest(driveId, i), (zzam) null, (String) null, new zzbq(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId, final ChangesAvailableOptions changesAvailableOptions) {
        zzu.zzb(zzg.zza(i, driveId), "id");
        zzu.zza(isConnected(), "Client must be connected");
        if (this.zzaeN) {
            return googleApiClient.zzb(new zzr.zza(googleApiClient) {
                /* class com.google.android.gms.drive.internal.zzs.AnonymousClass3 */

                /* access modifiers changed from: protected */
                public void zza(zzs zzs) throws RemoteException {
                    zzs.zzpB().zza(new AddEventListenerRequest(driveId, i, changesAvailableOptions), (zzam) null, (String) null, new zzbq(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId, final zzac zzac) {
        return googleApiClient.zzb(new zzr.zza(googleApiClient) {
            /* class com.google.android.gms.drive.internal.zzs.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new RemoveEventListenerRequest(driveId, i), zzac, (String) null, new zzbq(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId, final zzac zzac, final ChangesAvailableOptions changesAvailableOptions) {
        return googleApiClient.zzb(new zzr.zza(googleApiClient) {
            /* class com.google.android.gms.drive.internal.zzs.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new AddEventListenerRequest(driveId, i, changesAvailableOptions), zzac, (String) null, new zzbq(this));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        zzu.zzV(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzu.zzV(z);
        zzu.zza(isConnected(), "Client must be connected");
        return apiClient.zzb(new zzr.zza(apiClient) {
            /* class com.google.android.gms.drive.internal.zzs.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new CancelPendingActionsRequest(pendingTags), new zzbq(this));
            }
        });
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzak) zznM()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaeQ) {
            this.zzaeQ.clear();
        }
        synchronized (this.zzaeR) {
            this.zzaeR.clear();
        }
        synchronized (this.zzaeS) {
            this.zzaeS.clear();
        }
        synchronized (this.zzaeT) {
            this.zzaeT.clear();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresSignIn() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId, (ChangesAvailableOptions) null);
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        HashMap hashMap;
        zzac zzac;
        PendingResult<Status> zzj;
        zzu.zzb(zzg.zza(1, driveId), "id");
        zzu.zzb(changeListener, "listener");
        zzu.zza(isConnected(), "Client must be connected");
        synchronized (this.zzaeQ) {
            Map<ChangeListener, zzac> map = this.zzaeQ.get(driveId);
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.zzaeQ.put(driveId, hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            zzac zzac2 = hashMap.get(changeListener);
            if (zzac2 == null) {
                zzac = new zzac(getLooper(), getContext(), 1, changeListener);
                hashMap.put(changeListener, zzac);
            } else if (zzac2.zzcB(1)) {
                zzj = new zzq.zzj(googleApiClient, Status.zzXP);
            } else {
                zzac = zzac2;
            }
            zzac.zzcA(1);
            zzj = zza(googleApiClient, 1, driveId, zzac, null);
        }
        return zzj;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaeO = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaeP = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaN */
    public zzak zzT(IBinder iBinder) {
        return zzak.zza.zzaO(iBinder);
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    /* access modifiers changed from: package-private */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> zza;
        zzu.zzb(zzg.zza(1, driveId), "id");
        zzu.zza(isConnected(), "Client must be connected");
        zzu.zzb(changeListener, "listener");
        synchronized (this.zzaeQ) {
            Map<ChangeListener, zzac> map = this.zzaeQ.get(driveId);
            if (map == null) {
                zza = new zzq.zzj(googleApiClient, Status.zzXP);
            } else {
                zzac remove = map.remove(changeListener);
                if (remove == null) {
                    zza = new zzq.zzj(googleApiClient, Status.zzXP);
                } else {
                    if (map.isEmpty()) {
                        this.zzaeQ.remove(driveId);
                    }
                    zza = zza(googleApiClient, 1, driveId, remove);
                }
            }
        }
        return zza;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Bundle zzkR() {
        String packageName = getContext().getPackageName();
        zzu.zzu(packageName);
        zzu.zzU(!zznK().zznw().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzOe)) {
            bundle.putString("proxy_package_name", this.zzOe);
        }
        bundle.putAll(this.zzaeM);
        return bundle;
    }

    public zzak zzpB() throws DeadObjectException {
        return (zzak) zznM();
    }

    public DriveId zzpC() {
        return this.zzaeO;
    }

    public DriveId zzpD() {
        return this.zzaeP;
    }

    public boolean zzpE() {
        return this.zzaeN;
    }
}
