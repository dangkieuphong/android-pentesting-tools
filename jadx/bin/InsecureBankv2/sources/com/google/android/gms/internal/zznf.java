package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmt;
import java.util.concurrent.TimeUnit;

public class zznf implements SessionsApi {

    /* access modifiers changed from: private */
    public static class zza extends zzms.zza {
        private final zza.zzb<SessionReadResult> zzOs;

        private zza(zza.zzb<SessionReadResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzms
        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzOs.zzm(sessionReadResult);
        }
    }

    /* access modifiers changed from: private */
    public static class zzb extends zzmt.zza {
        private final zza.zzb<SessionStopResult> zzOs;

        private zzb(zza.zzb<SessionStopResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzmt
        public void zza(SessionStopResult sessionStopResult) {
            this.zzOs.zzm(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zzmd.zza<SessionStopResult>(googleApiClient) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass2 */

            /* access modifiers changed from: protected */
            /* renamed from: zzH */
            public SessionStopResult createFailedResult(Status status) {
                return SessionStopResult.zzP(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionStopRequest(str, str2, new zzb(this), zzmd.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzmd.zzc(client) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionInsertRequest(request, new zzng(this), zzmd.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zzmd.zza<SessionReadResult>(client) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass4 */

            /* access modifiers changed from: protected */
            /* renamed from: zzI */
            public SessionReadResult createFailedResult(Status status) {
                return SessionReadResult.zzO(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionReadRequest(request, new zza(this), zzmd.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzu.zzb(session, "Session cannot be null");
        zzu.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, "Cannot start a session which has already ended");
        return client.zzb(new zzmd.zzc(client) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionStartRequest(session, new zzng(this), zzmd.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, (String) null, identifier);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzmd.zzc(client) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionUnregistrationRequest(intent, new zzng(this), zzmd.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzmd.zzc(googleApiClient) {
            /* class com.google.android.gms.internal.zznf.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(zzmd zzmd) throws RemoteException {
                ((zzmo) zzmd.zznM()).zza(new SessionRegistrationRequest(pendingIntent, new zzng(this), zzmd.getContext().getPackageName(), i));
            }
        });
    }
}
