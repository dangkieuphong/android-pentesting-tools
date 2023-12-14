package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzq;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzv;
import com.google.android.gms.drive.internal.zzy;

public final class Drive {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Drive.API", new zza<Api.ApiOptions.NoOptions>() {
        /* class com.google.android.gms.drive.Drive.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public Bundle zza(Api.ApiOptions.NoOptions noOptions) {
            return new Bundle();
        }
    }, zzNX, new Scope[0]);
    public static final DriveApi DriveApi = new zzq();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzy();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final Api.ClientKey<zzs> zzNX = new Api.ClientKey<>();
    public static final Scope zzacY = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzacZ = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzada = new Api<>("Drive.INTERNAL_API", new zza<zzb>() {
        /* class com.google.android.gms.drive.Drive.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public Bundle zza(zzb zzb) {
            return zzb == null ? new Bundle() : zzb.zzpd();
        }
    }, zzNX, new Scope[0]);
    public static final zzc zzadb = new zzv();
    public static final zzf zzadc = new zzaa();

    public static abstract class zza<O extends Api.ApiOptions> implements Api.zza<zzs, O> {
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        /* access modifiers changed from: protected */
        public abstract Bundle zza(O o);

        public zzs zza(Context context, Looper looper, zze zze, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzs(context, looper, zze, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    public static class zzb implements Api.ApiOptions.Optional {
        private final Bundle zzNW;

        private zzb() {
            this(new Bundle());
        }

        private zzb(Bundle bundle) {
            this.zzNW = bundle;
        }

        public Bundle zzpd() {
            return this.zzNW;
        }
    }

    private Drive() {
    }
}
