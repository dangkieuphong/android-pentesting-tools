package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$11  reason: invalid class name */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ String zzasq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzaqA, this.zzasq);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$12  reason: invalid class name */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ String zzasq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaqA, this.zzasq);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$13  reason: invalid class name */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzasr;
        final /* synthetic */ int[] zzass;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqA, this.zzasr, this.zzass);
        }
    }

    private static abstract class CancelMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.CancelMatchResult> {
        private final String zzKI;

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzKI = id;
        }

        /* renamed from: zzay */
        public TurnBasedMultiplayer.CancelMatchResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.CancelMatchResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
                public String getMatchId() {
                    return CancelMatchImpl.this.zzKI;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.InitiateMatchResult> {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaz */
        public TurnBasedMultiplayer.InitiateMatchResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.InitiateMatchResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LeaveMatchResult> {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaA */
        public TurnBasedMultiplayer.LeaveMatchResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.LeaveMatchResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchResult> {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaB */
        public TurnBasedMultiplayer.LoadMatchResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.LoadMatchesResult> {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaC */
        public TurnBasedMultiplayer.LoadMatchesResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.LoadMatchesResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
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

    private static abstract class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl<TurnBasedMultiplayer.UpdateMatchResult> {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaD */
        public TurnBasedMultiplayer.UpdateMatchResult createFailedResult(final Status status) {
            return new TurnBasedMultiplayer.UpdateMatchResult() {
                /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult
                public TurnBasedMatch getMatch() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.zzb(new InitiateMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd(this, invitationId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new CancelMatchImpl(apiClient, matchId) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this, matchId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.zzb(new InitiateMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, config);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 1);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzq(invitationId, 1);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzcN(matchId);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, (byte[]) null, (ParticipantResult[]) null);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> finishMatch(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final ParticipantResult... results) {
        return apiClient.zzb(new UpdateMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, matchId, matchData, results);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsB();
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsL();
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzd(apiClient).zzb(minPlayers, maxPlayers, true);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzd(apiClient).zzb(minPlayers, maxPlayers, allowAutomatch);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new LeaveMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze(this, matchId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.zzb(new LeaveMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, matchId, pendingParticipantId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zza(new LoadMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass10 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzg(this, matchId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.zza(new LoadMatchesImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass9 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzo(listener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new InitiateMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc(this, matchId);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public PendingResult<TurnBasedMultiplayer.UpdateMatchResult> takeTurn(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final String pendingParticipantId, final ParticipantResult... results) {
        return apiClient.zzb(new UpdateMatchImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, matchId, matchData, pendingParticipantId, results);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer
    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzsE();
        }
    }
}
