package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10  reason: invalid class name */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ String zzTE;
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzTE, this.zzaqA, this.zzaqy);
        }
    }

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Achievements.LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzQ */
        public Achievements.LoadAchievementsResult createFailedResult(final Status status) {
            return new Achievements.LoadAchievementsResult() {
                /* class com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzbi(14));
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

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Achievements.UpdateAchievementResult> {
        private final String zzKI;

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzKI = id;
        }

        /* renamed from: zzR */
        public Achievements.UpdateAchievementResult createFailedResult(final Status status) {
            return new Achievements.UpdateAchievementResult() {
                /* class com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
                public String getAchievementId() {
                    return UpdateImpl.this.zzKI;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsA();
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void increment(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass6 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, id, numSteps);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass7 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, id, numSteps);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass1 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass2 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Achievements.UpdateAchievementResult>) null, id);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass3 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, id);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void setSteps(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass8 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, id, numSteps);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass9 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, id, numSteps);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass4 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zza.zzb<Achievements.UpdateAchievementResult>) null, id);
            }
        });
    }

    @Override // com.google.android.gms.games.achievement.Achievements
    public PendingResult<Achievements.UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            /* class com.google.android.gms.games.internal.api.AchievementsImpl.AnonymousClass5 */

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, id);
            }
        });
    }
}
