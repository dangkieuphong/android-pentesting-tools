package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2  reason: invalid class name */
    class AnonymousClass2 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzaqV;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzaqA, this.zzaqV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3  reason: invalid class name */
    class AnonymousClass3 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaqX;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this, this.zzaqX);
        }
    }

    private static abstract class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaa */
        public Invitations.LoadInvitationsResult createFailedResult(final Status status) {
            return new Invitations.LoadInvitationsResult() {
                /* class com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.AnonymousClass1 */

                @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.zzbi(14));
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

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsC();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.zza(new LoadInvitationsImpl(apiClient) {
            /* class com.google.android.gms.games.internal.api.InvitationsImpl.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc(this, sortOrder);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zza(apiClient.zzo(listener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzsD();
        }
    }
}
