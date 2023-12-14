package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2  reason: invalid class name */
    class AnonymousClass2 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzaqA;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzaqA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3  reason: invalid class name */
    class AnonymousClass3 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzaqR;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzaqR);
        }
    }

    private static abstract class LoadGameInstancesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameInstancesResult> {
        /* renamed from: zzX */
        public GamesMetadata.LoadGameInstancesResult createFailedResult(final Status status) {
            return new GamesMetadata.LoadGameInstancesResult() {
                /* class com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.AnonymousClass1 */

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

    private static abstract class LoadGameSearchSuggestionsImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGameSearchSuggestionsResult> {
        /* renamed from: zzY */
        public GamesMetadata.LoadGameSearchSuggestionsResult createFailedResult(final Status status) {
            return new GamesMetadata.LoadGameSearchSuggestionsResult() {
                /* class com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.AnonymousClass1 */

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

    private static abstract class LoadGamesImpl extends Games.BaseGamesApiMethodImpl<GamesMetadata.LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzZ */
        public GamesMetadata.LoadGamesResult createFailedResult(final Status status) {
            return new GamesMetadata.LoadGamesResult() {
                /* class com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzbi(14));
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

    @Override // com.google.android.gms.games.GamesMetadata
    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsy();
    }

    @Override // com.google.android.gms.games.GamesMetadata
    public PendingResult<GamesMetadata.LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new LoadGamesImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.GamesMetadataImpl.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }
}
