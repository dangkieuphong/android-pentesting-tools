package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzmh;

public class zzna implements ConfigApi {

    /* access modifiers changed from: private */
    public static class zza extends zzmh.zza {
        private final zza.zzb<DataTypeResult> zzOs;

        private zza(zza.zzb<DataTypeResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzmh
        public void zza(DataTypeResult dataTypeResult) {
            this.zzOs.zzm(dataTypeResult);
        }
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zzly.zza<DataTypeResult>(client) {
            /* class com.google.android.gms.internal.zzna.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: zzC */
            public DataTypeResult createFailedResult(Status status) {
                return DataTypeResult.zzM(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzly zzly) throws RemoteException {
                ((zzmj) zzly.zznM()).zza(new DataTypeCreateRequest(request, new zza(this), zzly.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzly.zzc(client) {
            /* class com.google.android.gms.internal.zzna.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzly zzly) throws RemoteException {
                ((zzmj) zzly.zznM()).zza(new DisableFitRequest(new zzng(this), zzly.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zzly.zza<DataTypeResult>(client) {
            /* class com.google.android.gms.internal.zzna.AnonymousClass2 */

            /* access modifiers changed from: protected */
            /* renamed from: zzC */
            public DataTypeResult createFailedResult(Status status) {
                return DataTypeResult.zzM(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzly zzly) throws RemoteException {
                ((zzmj) zzly.zznM()).zza(new DataTypeReadRequest(dataTypeName, new zza(this), zzly.getContext().getPackageName()));
            }
        });
    }
}
