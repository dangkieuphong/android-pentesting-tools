package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

public class zzov implements PanoramaApi {

    private static abstract class zza extends zzc<PanoramaApi.PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaN */
        public PanoramaApi.PanoramaResult createFailedResult(Status status) {
            return new zzox(status, null);
        }
    }

    private static final class zzb extends zzot.zza {
        private final zza.zzb<PanoramaApi.PanoramaResult> zzOs;

        public zzb(zza.zzb<PanoramaApi.PanoramaResult> zzb) {
            this.zzOs = zzb;
        }

        @Override // com.google.android.gms.internal.zzot
        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzOs.zzm(new zzox(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends zza.AbstractC0027zza<R, zzow> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzNX, googleApiClient);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(Context context, zzou zzou) throws RemoteException;

        /* access modifiers changed from: protected */
        public final void zza(zzow zzow) throws RemoteException {
            zza(zzow.getContext(), (zzou) zzow.zznM());
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* access modifiers changed from: private */
    public static void zza(final Context context, zzou zzou, final zzot zzot, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzou.zza(new zzot.zza() {
                /* class com.google.android.gms.internal.zzov.AnonymousClass3 */

                @Override // com.google.android.gms.internal.zzot
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzov.zza(context, uri);
                    zzot.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) {
            /* class com.google.android.gms.internal.zzov.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzov.zzc
            public void zza(Context context, zzou zzou) throws RemoteException {
                zzou.zza(new zzb(this), uri, null, false);
            }
        });
    }

    @Override // com.google.android.gms.panorama.PanoramaApi
    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) {
            /* class com.google.android.gms.internal.zzov.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzov.zzc
            public void zza(Context context, zzou zzou) throws RemoteException {
                zzov.zza(context, zzou, new zzb(this), uri, null);
            }
        });
    }
}
