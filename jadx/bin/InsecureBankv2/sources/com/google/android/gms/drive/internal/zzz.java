package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.zzq;
import com.google.android.gms.drive.internal.zzr;
import java.util.ArrayList;
import java.util.Set;

public class zzz implements DriveResource {
    protected final DriveId zzacT;

    /* access modifiers changed from: private */
    public static class zza extends zzd {
        private final zza.zzb<DriveApi.MetadataBufferResult> zzOs;

        public zza(zza.zzb<DriveApi.MetadataBufferResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzOs.zzm(new zzq.zzf(Status.zzXP, new MetadataBuffer(onListParentsResponse.zzpR()), false));
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzq.zzf(status, null, false));
        }
    }

    /* access modifiers changed from: private */
    public static class zzb extends zzd {
        private final zza.zzb<DriveResource.MetadataResult> zzOs;

        public zzb(zza.zzb<DriveResource.MetadataResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzOs.zzm(new zzc(Status.zzXP, new zzn(onMetadataResponse.zzpS())));
        }

        @Override // com.google.android.gms.drive.internal.zzal, com.google.android.gms.drive.internal.zzd
        public void zzt(Status status) throws RemoteException {
            this.zzOs.zzm(new zzc(status, null));
        }
    }

    /* access modifiers changed from: private */
    public static class zzc implements DriveResource.MetadataResult {
        private final Status zzOt;
        private final Metadata zzafA;

        public zzc(Status status, Metadata metadata) {
            this.zzOt = status;
            this.zzafA = metadata;
        }

        @Override // com.google.android.gms.drive.DriveResource.MetadataResult
        public Metadata getMetadata() {
            return this.zzafA;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private abstract class zzd extends zzr<DriveResource.MetadataResult> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzA */
        public DriveResource.MetadataResult createFailedResult(Status status) {
            return new zzc(status, null);
        }
    }

    protected zzz(DriveId driveId) {
        this.zzacT = driveId;
    }

    private PendingResult<DriveResource.MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(googleApiClient) {
            /* class com.google.android.gms.drive.internal.zzz.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new GetMetadataRequest(zzz.this.zzacT, z), new zzb(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zza(apiClient, this.zzacT, listener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zza(apiClient, this.zzacT);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzr.zza(apiClient) {
            /* class com.google.android.gms.drive.internal.zzz.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new DeleteResourceRequest(zzz.this.zzacT), new zzbq(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public DriveId getDriveId() {
        return this.zzacT;
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzq.zzg(apiClient) {
            /* class com.google.android.gms.drive.internal.zzz.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new ListParentsRequest(zzz.this.zzacT), new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zzb(apiClient, this.zzacT, listener);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzs) apiClient.zza(Drive.zzNX)).zzb(apiClient, this.zzacT);
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        } else if (parentIds.isEmpty()) {
            throw new IllegalArgumentException("ParentIds must contain at least one parent.");
        } else {
            final ArrayList arrayList = new ArrayList(parentIds);
            return apiClient.zzb(new zzr.zza(apiClient) {
                /* class com.google.android.gms.drive.internal.zzz.AnonymousClass3 */

                /* access modifiers changed from: protected */
                public void zza(zzs zzs) throws RemoteException {
                    zzs.zzpB().zza(new SetResourceParentsRequest(zzz.this.zzacT, arrayList), new zzbq(this));
                }
            });
        }
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzr.zza(apiClient) {
            /* class com.google.android.gms.drive.internal.zzz.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new TrashResourceRequest(zzz.this.zzacT), new zzbq(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new zzr.zza(apiClient) {
            /* class com.google.android.gms.drive.internal.zzz.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public void zza(zzs zzs) throws RemoteException {
                zzs.zzpB().zza(new UntrashResourceRequest(zzz.this.zzacT), new zzbq(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DriveResource
    public PendingResult<DriveResource.MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(apiClient) {
                /* class com.google.android.gms.drive.internal.zzz.AnonymousClass4 */

                /* access modifiers changed from: protected */
                public void zza(zzs zzs) throws RemoteException {
                    changeSet.zzpm().setContext(zzs.getContext());
                    zzs.zzpB().zza(new UpdateMetadataRequest(zzz.this.zzacT, changeSet.zzpm()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
