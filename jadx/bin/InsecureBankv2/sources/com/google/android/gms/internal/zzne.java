package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmu;

public class zzne implements SensorsApi {

    /* access modifiers changed from: private */
    public interface zza {
        void zzqR();
    }

    /* access modifiers changed from: private */
    public static class zzb extends zzmg.zza {
        private final zza.zzb<DataSourcesResult> zzOs;

        private zzb(zza.zzb<DataSourcesResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzmg
        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzOs.zzm(dataSourcesResult);
        }
    }

    /* access modifiers changed from: private */
    public static class zzc extends zzmu.zza {
        private final zza.zzb<Status> zzOs;
        private final zza zzalA;

        private zzc(zza.zzb<Status> zzb, zza zza) {
            this.zzOs = zzb;
            this.zzalA = zza;
        }

        @Override // com.google.android.gms.internal.zzmu
        public void zzm(Status status) {
            if (this.zzalA != null && status.isSuccess()) {
                this.zzalA.zzqR();
            }
            this.zzOs.zzm(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final zzj zzj, final PendingIntent pendingIntent, final zza zza2) {
        return googleApiClient.zzb(new zzmc.zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zzne.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzmc zzmc) throws RemoteException {
                ((zzmn) zzmc.zznM()).zza(new SensorUnregistrationRequest(zzj, pendingIntent, new zzc(this, zza2), zzmc.getContext().getPackageName()));
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzmc.zzc
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final SensorRequest sensorRequest, final zzj zzj, final PendingIntent pendingIntent) {
        return googleApiClient.zza(new zzmc.zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zzne.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zzmc zzmc) throws RemoteException {
                ((zzmn) zzmc.zznM()).zza(new SensorRegistrationRequest(sensorRequest, zzj, pendingIntent, new zzng(this), zzmc.getContext().getPackageName()));
            }

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzmc.zzc
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, (zzj) null, intent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, zzk.zza.zzqH().zza(listener), (PendingIntent) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zzmc.zza<DataSourcesResult>(client) {
            /* class com.google.android.gms.internal.zzne.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: zzG */
            public DataSourcesResult createFailedResult(Status status) {
                return DataSourcesResult.zzL(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmc zzmc) throws RemoteException {
                ((zzmn) zzmc.zznM()).zza(new DataSourcesRequest(request, new zzb(this), zzmc.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, (zzj) null, pendingIntent, (zza) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzk zzb2 = zzk.zza.zzqH().zzb(listener);
        return zzb2 == null ? new zzmw(Status.zzXP) : zza(client, zzb2, (PendingIntent) null, new zza() {
            /* class com.google.android.gms.internal.zzne.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzne.zza
            public void zzqR() {
                zzk.zza.zzqH().zzc(listener);
            }
        });
    }
}
