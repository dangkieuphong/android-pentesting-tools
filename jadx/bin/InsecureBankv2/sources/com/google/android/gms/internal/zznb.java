package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmf;

public class zznb implements HistoryApi {

    /* access modifiers changed from: private */
    public static class zza extends zzmf.zza {
        private final zza.zzb<DataReadResult> zzOs;
        private int zzalm;
        private DataReadResult zzaln;

        private zza(zza.zzb<DataReadResult> zzb) {
            this.zzalm = 0;
            this.zzaln = null;
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzmf
        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzaln == null) {
                    this.zzaln = dataReadResult;
                } else {
                    this.zzaln.zzb(dataReadResult);
                }
                this.zzalm++;
                if (this.zzalm == this.zzaln.zzrt()) {
                    this.zzOs.zzm(this.zzaln);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzu.zzb(dataSet, "Must set the data set");
        zzu.zza(!dataSet.getDataPoints().isEmpty(), "Cannot use an empty data set");
        zzu.zzb(dataSet.getDataSource().zzqB(), "Must set the app package name for the data source");
        return googleApiClient.zza(new zzlz.zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zznb.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzlz zzlz) throws RemoteException {
                ((zzmk) zzlz.zznM()).zza(new DataInsertRequest(dataSet, new zzng(this), zzlz.getContext().getPackageName(), z));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzlz.zzc(client) {
            /* class com.google.android.gms.internal.zznb.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzlz zzlz) throws RemoteException {
                ((zzmk) zzlz.zznM()).zza(new DataDeleteRequest(request, new zzng(this), zzlz.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zzlz.zza<DailyTotalResult>(client) {
            /* class com.google.android.gms.internal.zznb.AnonymousClass4 */

            /* access modifiers changed from: protected */
            /* renamed from: zzE */
            public DailyTotalResult createFailedResult(Status status) {
                return DailyTotalResult.zzK(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzlz zzlz) throws RemoteException {
                ((zzmk) zzlz.zznM()).zza(new DailyTotalRequest(new zzme.zza() {
                    /* class com.google.android.gms.internal.zznb.AnonymousClass4.AnonymousClass1 */

                    @Override // com.google.android.gms.internal.zzme
                    public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                        AnonymousClass4.this.setResult(dailyTotalResult);
                    }
                }, dataType, zzlz.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.HistoryApi
    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zzlz.zza<DataReadResult>(client) {
            /* class com.google.android.gms.internal.zznb.AnonymousClass3 */

            /* access modifiers changed from: protected */
            /* renamed from: zzD */
            public DataReadResult createFailedResult(Status status) {
                return DataReadResult.zza(status, request);
            }

            /* access modifiers changed from: protected */
            public void zza(zzlz zzlz) throws RemoteException {
                ((zzmk) zzlz.zznM()).zza(new DataReadRequest(request, new zza(this), zzlz.getContext().getPackageName()));
            }
        });
    }
}
