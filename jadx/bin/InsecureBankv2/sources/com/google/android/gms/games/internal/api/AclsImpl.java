package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2  reason: invalid class name */
    class AnonymousClass2 extends LoadNotifyAclImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3  reason: invalid class name */
    class AnonymousClass3 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzaqF;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzaqF);
        }
    }

    private static abstract class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
        /* renamed from: zzU */
        public Acls.LoadAclResult createFailedResult(Status status) {
            return AclsImpl.zzS(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Status> {
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    /* access modifiers changed from: private */
    public static Acls.LoadAclResult zzS(final Status status) {
        return new Acls.LoadAclResult() {
            /* class com.google.android.gms.games.internal.api.AclsImpl.AnonymousClass1 */

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
