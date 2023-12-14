package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api<>("Wallet.API", zzNY, zzNX, new Scope[0]);
    public static final Payments Payments = new zzqw();
    private static final Api.ClientKey<zzqx> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzqx, WalletOptions> zzNY = new Api.zza<zzqx, WalletOptions>() {
        /* class com.google.android.gms.wallet.Wallet.AnonymousClass1 */

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public zzqx zza(Context context, Looper looper, zze zze, WalletOptions walletOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(context instanceof Activity, "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzqx(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, zze.getAccountName(), walletOptions.theme);
        }
    };
    public static final zzj zzaRF = new zzra();
    public static final com.google.android.gms.wallet.firstparty.zza zzaRG = new zzqz();

    public static final class WalletOptions implements Api.ApiOptions.HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            private int mTheme = 0;
            private int zzaRH = 3;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1 || environment == 3) {
                    this.zzaRH = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(environment)));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(theme)));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzaRH;
            this.theme = builder.mTheme;
        }
    }

    public static abstract class zza<R extends Result> extends zza.AbstractC0027zza<R, zzqx> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzNX, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
