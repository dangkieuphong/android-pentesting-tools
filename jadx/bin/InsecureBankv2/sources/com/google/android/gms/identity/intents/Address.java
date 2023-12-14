package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznk;

public final class Address {
    public static final Api<AddressOptions> API = new Api<>("Address.API", zzNY, zzNX, new Scope[0]);
    static final Api.ClientKey<zznk> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zznk, AddressOptions> zzNY = new Api.zza<zznk, AddressOptions>() {
        /* class com.google.android.gms.identity.intents.Address.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zznk zza(Context context, Looper looper, zze zze, AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(context instanceof Activity, "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zznk((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, zze.getAccountName(), addressOptions.theme);
        }
    };

    public static final class AddressOptions implements Api.ApiOptions.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme2) {
            this.theme = theme2;
        }
    }

    private static abstract class zza extends zza.AbstractC0027zza<Status, zznk> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzNX, googleApiClient);
        }

        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) {
            /* class com.google.android.gms.identity.intents.Address.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public void zza(zznk zznk) throws RemoteException {
                zznk.zza(request, requestCode);
                setResult(Status.zzXP);
            }
        });
    }
}
