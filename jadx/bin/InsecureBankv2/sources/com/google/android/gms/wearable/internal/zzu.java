package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzu implements DataApi {

    /* access modifiers changed from: private */
    public static final class zza extends zzf<Status> {
        private DataApi.DataListener zzaUj;
        private IntentFilter[] zzaUk;

        private zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaUj = dataListener;
            this.zzaUk = intentFilterArr;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbk zzbk) throws RemoteException {
            zzbk.zza(this, this.zzaUj, this.zzaUk);
            this.zzaUj = null;
            this.zzaUk = null;
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            this.zzaUj = null;
            this.zzaUk = null;
            return status;
        }
    }

    public static class zzb implements DataApi.DataItemResult {
        private final Status zzOt;
        private final DataItem zzaUl;

        public zzb(Status status, DataItem dataItem) {
            this.zzOt = status;
            this.zzaUl = dataItem;
        }

        @Override // com.google.android.gms.wearable.DataApi.DataItemResult
        public DataItem getDataItem() {
            return this.zzaUl;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzc implements DataApi.DeleteDataItemsResult {
        private final Status zzOt;
        private final int zzaUm;

        public zzc(Status status, int i) {
            this.zzOt = status;
            this.zzaUm = i;
        }

        @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
        public int getNumDeleted() {
            return this.zzaUm;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    public static class zzd implements DataApi.GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzOt;
        private volatile InputStream zzaTV;
        private volatile ParcelFileDescriptor zzaUn;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzOt = status;
            this.zzaUn = parcelFileDescriptor;
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzaUn;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzaUn == null) {
                return null;
            } else {
                if (this.zzaTV == null) {
                    this.zzaTV = new ParcelFileDescriptor.AutoCloseInputStream(this.zzaUn);
                }
                return this.zzaTV;
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            if (this.zzaUn != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaTV != null) {
                        this.zzaTV.close();
                    } else {
                        this.zzaUn.close();
                    }
                    this.mClosed = true;
                    this.zzaUn = null;
                    this.zzaTV = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataApi.DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, dataListener, intentFilterArr));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<Status> addListener(GoogleApiClient client, DataApi.DataListener listener) {
        return zza(client, listener, null);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzf<DataApi.DeleteDataItemsResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzb(this, uri, filterType);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbf */
            public DataApi.DeleteDataItemsResult createFailedResult(Status status) {
                return new zzc(status, 0);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzf<DataApi.DataItemResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbd */
            public DataApi.DataItemResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzf<DataItemBuffer>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zzl(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbe */
            public DataItemBuffer createFailedResult(Status status) {
                return new DataItemBuffer(DataHolder.zzbi(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzf<DataItemBuffer>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, uri, filterType);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbe */
            public DataItemBuffer createFailedResult(Status status) {
                return new DataItemBuffer(DataHolder.zzbi(status.getStatusCode()));
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzf<DataApi.GetFdForAssetResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbg */
            public DataApi.GetFdForAssetResult createFailedResult(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzf<DataApi.GetFdForAssetResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbg */
            public DataApi.GetFdForAssetResult createFailedResult(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzf<DataApi.DataItemResult>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzbk zzbk) throws RemoteException {
                zzbk.zza(this, request);
            }

            /* renamed from: zzbd */
            public DataApi.DataItemResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.DataApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final DataApi.DataListener listener) {
        return client.zza(new zzf<Status>(client) {
            /* class com.google.android.gms.wearable.internal.zzu.AnonymousClass8 */

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
}
