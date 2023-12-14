package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzn extends Fragment implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult> {
    private boolean zzXV;
    private int zzXW = -1;
    private ConnectionResult zzXX;
    private final Handler zzXY = new Handler(Looper.getMainLooper());
    private final SparseArray<zzb> zzXZ = new SparseArray<>();

    /* access modifiers changed from: package-private */
    public static class zza extends Loader<ConnectionResult> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        public final GoogleApiClient zzYb;
        private boolean zzYg;
        private ConnectionResult zzYh;

        public zza(Context context, GoogleApiClient googleApiClient) {
            super(context);
            this.zzYb = googleApiClient;
        }

        private void zzf(ConnectionResult connectionResult) {
            this.zzYh = connectionResult;
            if (isStarted() && !isAbandoned()) {
                deliverResult(connectionResult);
            }
        }

        @Override // android.support.v4.content.Loader
        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            super.dump(prefix, fd, writer, args);
            this.zzYb.dump(prefix, fd, writer, args);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle connectionHint) {
            this.zzYg = false;
            zzf(ConnectionResult.zzVG);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult result) {
            this.zzYg = true;
            zzf(result);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int cause) {
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.content.Loader
        public void onReset() {
            this.zzYh = null;
            this.zzYg = false;
            this.zzYb.unregisterConnectionCallbacks(this);
            this.zzYb.unregisterConnectionFailedListener(this);
            this.zzYb.disconnect();
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.content.Loader
        public void onStartLoading() {
            super.onStartLoading();
            this.zzYb.registerConnectionCallbacks(this);
            this.zzYb.registerConnectionFailedListener(this);
            if (this.zzYh != null) {
                deliverResult(this.zzYh);
            }
            if (!this.zzYb.isConnected() && !this.zzYb.isConnecting() && !this.zzYg) {
                this.zzYb.connect();
            }
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.content.Loader
        public void onStopLoading() {
            this.zzYb.disconnect();
        }

        public boolean zzmX() {
            return this.zzYg;
        }
    }

    /* access modifiers changed from: private */
    public static class zzb {
        public final GoogleApiClient zzYb;
        public final GoogleApiClient.OnConnectionFailedListener zzYc;

        private zzb(GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzYb = googleApiClient;
            this.zzYc = onConnectionFailedListener;
        }
    }

    /* access modifiers changed from: private */
    public class zzc implements Runnable {
        private final int zzYe;
        private final ConnectionResult zzYf;

        public zzc(int i, ConnectionResult connectionResult) {
            this.zzYe = i;
            this.zzYf = connectionResult;
        }

        public void run() {
            if (this.zzYf.hasResolution()) {
                try {
                    this.zzYf.startResolutionForResult(zzn.this.getActivity(), ((zzn.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzn.this) + 1) << 16) + 1);
                } catch (IntentSender.SendIntentException e) {
                    zzn.this.zzmV();
                }
            } else if (GooglePlayServicesUtil.isUserRecoverableError(this.zzYf.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzYf.getErrorCode(), zzn.this.getActivity(), zzn.this, 2, zzn.this);
            } else {
                zzn.this.zza((zzn) this.zzYe, (int) this.zzYf);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zzb zzb2 = this.zzXZ.get(i);
        if (zzb2 != null) {
            zzbb(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzb2.zzYc;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzmV();
    }

    public static zzn zzb(FragmentActivity fragmentActivity) {
        zzu.zzbY("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzn zzn = (zzn) supportFragmentManager.findFragmentByTag("GmsSupportLoaderLifecycleFragment");
            if (zzn != null && !zzn.isRemoving()) {
                return zzn;
            }
            zzn zzn2 = new zzn();
            supportFragmentManager.beginTransaction().add(zzn2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return zzn2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void zzb(int i, ConnectionResult connectionResult) {
        if (!this.zzXV) {
            this.zzXV = true;
            this.zzXW = i;
            this.zzXX = connectionResult;
            this.zzXY.post(new zzc(i, connectionResult));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmV() {
        this.zzXV = false;
        this.zzXW = -1;
        this.zzXX = null;
        LoaderManager loaderManager = getLoaderManager();
        for (int i = 0; i < this.zzXZ.size(); i++) {
            int keyAt = this.zzXZ.keyAt(i);
            zza zzbd = zzbd(keyAt);
            if (zzbd != null && zzbd.zzmX()) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.initLoader(keyAt, null, this);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r5 == -1) goto L_0x0006;
     */
    @Override // android.support.v4.app.Fragment
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            switch(r4) {
                case 1: goto L_0x0017;
                case 2: goto L_0x000c;
                default: goto L_0x0005;
            }
        L_0x0005:
            r0 = r1
        L_0x0006:
            if (r0 == 0) goto L_0x001b
            r3.zzmV()
        L_0x000b:
            return
        L_0x000c:
            android.support.v4.app.FragmentActivity r2 = r3.getActivity()
            int r2 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r2)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x0017:
            r2 = -1
            if (r5 != r2) goto L_0x0005
            goto L_0x0006
        L_0x001b:
            int r0 = r3.zzXW
            com.google.android.gms.common.ConnectionResult r1 = r3.zzXX
            r3.zza(r0, r1)
            goto L_0x000b
            switch-data {1->0x0017, 2->0x000c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzn.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        for (int i = 0; i < this.zzXZ.size(); i++) {
            int keyAt = this.zzXZ.keyAt(i);
            zza zzbd = zzbd(keyAt);
            if (zzbd == null || this.zzXZ.valueAt(i).zzYb == zzbd.zzYb) {
                getLoaderManager().initLoader(keyAt, null, this);
            } else {
                getLoaderManager().restartLoader(keyAt, null, this);
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzXW, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zzXV = savedInstanceState.getBoolean("resolving_error", false);
            this.zzXW = savedInstanceState.getInt("failed_client_id", -1);
            if (this.zzXW >= 0) {
                this.zzXX = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<ConnectionResult> onCreateLoader(int id, Bundle args) {
        return new zza(getActivity(), this.zzXZ.get(id).zzYb);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ConnectionResult> loader) {
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.zzXV);
        if (this.zzXW >= 0) {
            outState.putInt("failed_client_id", this.zzXW);
            outState.putInt("failed_status", this.zzXX.getErrorCode());
            outState.putParcelable("failed_resolution", this.zzXX.getResolution());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (!this.zzXV) {
            for (int i = 0; i < this.zzXZ.size(); i++) {
                getLoaderManager().initLoader(this.zzXZ.keyAt(i), null, this);
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzu.zza(this.zzXZ.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzXZ.put(i, new zzb(googleApiClient, onConnectionFailedListener));
        if (getActivity() != null) {
            LoaderManager.enableDebugLogging(false);
            getLoaderManager().initLoader(i, null, this);
        }
    }

    /* renamed from: zza */
    public void onLoadFinished(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (!connectionResult.isSuccess()) {
            zzb(loader.getId(), connectionResult);
        }
    }

    public void zzbb(int i) {
        this.zzXZ.remove(i);
        getLoaderManager().destroyLoader(i);
    }

    public GoogleApiClient zzbc(int i) {
        zza zzbd;
        if (getActivity() == null || (zzbd = zzbd(i)) == null) {
            return null;
        }
        return zzbd.zzYb;
    }

    /* access modifiers changed from: package-private */
    public zza zzbd(int i) {
        try {
            return (zza) getLoaderManager().getLoader(i);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }
}
