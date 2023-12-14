package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl$1  reason: invalid class name */
    class AnonymousClass1 extends LoadsImpl {
        final /* synthetic */ int zzaqG;
        final /* synthetic */ String zzaqH;
        final /* synthetic */ String[] zzaqI;
        final /* synthetic */ boolean zzaqy;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaqG, this.zzaqH, this.zzaqI, this.zzaqy);
        }
    }

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult> {
        /* renamed from: zzV */
        public AppContents.LoadAppContentResult createFailedResult(final Status status) {
            return new AppContents.LoadAppContentResult() {
                /* class com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.AnonymousClass1 */

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
}
