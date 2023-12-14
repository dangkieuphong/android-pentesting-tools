package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1  reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzarm;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzarm, true);
        }

        /* renamed from: zzaf */
        public Notifications.GameMuteStatusChangeResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                /* class com.google.android.gms.games.internal.api.NotificationsImpl.AnonymousClass1.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2  reason: invalid class name */
    class AnonymousClass2 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzarm;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzarm, false);
        }

        /* renamed from: zzaf */
        public Notifications.GameMuteStatusChangeResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() {
                /* class com.google.android.gms.games.internal.api.NotificationsImpl.AnonymousClass2.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3  reason: invalid class name */
    class AnonymousClass3 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusLoadResult> {
        final /* synthetic */ String zzarm;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzarm);
        }

        /* renamed from: zzag */
        public Notifications.GameMuteStatusLoadResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() {
                /* class com.google.android.gms.games.internal.api.NotificationsImpl.AnonymousClass3.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4  reason: invalid class name */
    class AnonymousClass4 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaqy;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this, this.zzaqy);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5  reason: invalid class name */
    class AnonymousClass5 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzarq;
        final /* synthetic */ Bundle zzarr;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzarq, this.zzarr);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6  reason: invalid class name */
    class AnonymousClass6 extends InboxCountImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        /* renamed from: zzah */
        public Notifications.ContactSettingLoadResult createFailedResult(final Status status) {
            return new Notifications.ContactSettingLoadResult() {
                /* class com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        /* renamed from: zzai */
        public Notifications.InboxCountResult createFailedResult(final Status status) {
            return new Notifications.InboxCountResult() {
                /* class com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfD(notificationTypes);
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
