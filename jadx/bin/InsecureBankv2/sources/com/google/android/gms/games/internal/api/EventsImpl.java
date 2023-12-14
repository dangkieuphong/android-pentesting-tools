package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzW */
        public Events.LoadEventsResult createFailedResult(final Status status) {
            return new Events.LoadEventsResult() {
                /* class com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.event.Events.LoadEventsResult
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbi(14));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        public Result createFailedResult(final Status status) {
            return new Result() {
                /* class com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.AnonymousClass1 */

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzp(eventId, incrementAmount);
            } else {
                apiClient.zzb(new UpdateImpl(apiClient) {
                    /* class com.google.android.gms.games.internal.api.EventsImpl.AnonymousClass3 */

                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzp(eventId, incrementAmount);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.EventsImpl.AnonymousClass2 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.zza(new LoadImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.EventsImpl.AnonymousClass1 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, forceReload, eventIds);
            }
        });
    }
}
