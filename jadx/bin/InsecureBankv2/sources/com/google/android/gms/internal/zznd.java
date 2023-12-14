package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmp;

public class zznd implements RecordingApi {

    /* access modifiers changed from: private */
    public static class zza extends zzmp.zza {
        private final zza.zzb<ListSubscriptionsResult> zzOs;

        private zza(zza.zzb<ListSubscriptionsResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzmp
        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzOs.zzm(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzmb.zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zznd.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzmb zzmb) throws RemoteException {
                ((zzmm) zzmb.zznM()).zza(new SubscribeRequest(subscription, false, new zzng(this), zzmb.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zzmb.zza<ListSubscriptionsResult>(client) {
            /* class com.google.android.gms.internal.zznd.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: zzF */
            public ListSubscriptionsResult createFailedResult(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmb zzmb) throws RemoteException {
                ((zzmm) zzmb.zznM()).zza(new ListSubscriptionsRequest(null, new zza(this), zzmb.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zzmb.zza<ListSubscriptionsResult>(client) {
            /* class com.google.android.gms.internal.zznd.AnonymousClass2 */

            /* access modifiers changed from: protected */
            /* renamed from: zzF */
            public ListSubscriptionsResult createFailedResult(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmb zzmb) throws RemoteException {
                ((zzmm) zzmb.zznM()).zza(new ListSubscriptionsRequest(dataType, new zza(this), zzmb.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new Subscription.zza().zzb(dataSource).zzqN());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new Subscription.zza().zzb(dataType).zzqN());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzmb.zzc(client) {
            /* class com.google.android.gms.internal.zznd.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzmb zzmb) throws RemoteException {
                ((zzmm) zzmb.zznM()).zza(new UnsubscribeRequest(null, dataSource, new zzng(this), zzmb.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzmb.zzc(client) {
            /* class com.google.android.gms.internal.zznd.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(zzmb zzmb) throws RemoteException {
                ((zzmm) zzmb.zznM()).zza(new UnsubscribeRequest(dataType, null, new zzng(this), zzmb.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
