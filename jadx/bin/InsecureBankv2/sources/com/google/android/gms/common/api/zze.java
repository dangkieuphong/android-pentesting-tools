package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzg;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class zze implements zzh {
    private final Context mContext;
    private final Api.zza<? extends zzps, zzpt> zzWE;
    private final zzg zzWK;
    private final Lock zzWL;
    private ConnectionResult zzWM;
    private int zzWN;
    private int zzWO = 0;
    private boolean zzWP = false;
    private int zzWQ;
    private final Bundle zzWR = new Bundle();
    private final Set<Api.ClientKey> zzWS = new HashSet();
    private zzps zzWT;
    private int zzWU;
    private boolean zzWV;
    private boolean zzWW;
    private IAccountAccessor zzWX;
    private boolean zzWY;
    private boolean zzWZ;
    private final com.google.android.gms.common.internal.zze zzXa;
    private final Map<Api<?>, Integer> zzXb;

    /* access modifiers changed from: private */
    public static class zza extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zze> zzXe;

        zza(zze zze) {
            this.zzXe = new WeakReference<>(zze);
        }

        @Override // com.google.android.gms.signin.internal.zzb, com.google.android.gms.signin.internal.zze
        public void zza(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final zze zze = this.zzXe.get();
            if (zze != null) {
                zze.zzWK.zzXs.post(new Runnable() {
                    /* class com.google.android.gms.common.api.zze.zza.AnonymousClass1 */

                    public void run() {
                        zze.zza((zze) connectionResult);
                    }
                });
            }
        }
    }

    private static class zzb extends zzq.zza {
        private final WeakReference<zze> zzXe;

        zzb(zze zze) {
            this.zzXe = new WeakReference<>(zze);
        }

        @Override // com.google.android.gms.common.internal.zzq
        public void zzb(final ResolveAccountResponse resolveAccountResponse) {
            final zze zze = this.zzXe.get();
            if (zze != null) {
                zze.zzWK.zzXs.post(new Runnable() {
                    /* class com.google.android.gms.common.api.zze.zzb.AnonymousClass1 */

                    public void run() {
                        zze.zza((zze) resolveAccountResponse);
                    }
                });
            }
        }
    }

    private static class zzc implements GoogleApiClient.ConnectionProgressReportCallbacks {
        private final WeakReference<zze> zzXe;
        private final Api<?> zzXk;
        private final int zzXl;

        public zzc(zze zze, Api<?> api, int i) {
            this.zzXe = new WeakReference<>(zze);
            this.zzXk = api;
            this.zzXl = i;
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks
        public void onReportAccountValidation(ConnectionResult result) {
            boolean z = true;
            zze zze = this.zzXe.get();
            if (zze != null) {
                if (Looper.myLooper() != zze.zzWK.getLooper()) {
                    z = false;
                }
                zzu.zza(z, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                zze.zzWL.lock();
                try {
                    if (zze.zzaW(1)) {
                        if (!result.isSuccess()) {
                            zze.zzb(result, this.zzXk, this.zzXl);
                        }
                        if (zze.zzmC()) {
                            zze.zzmF();
                        }
                        zze.zzWL.unlock();
                    }
                } finally {
                    zze.zzWL.unlock();
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult result) {
            boolean z = false;
            zze zze = this.zzXe.get();
            if (zze != null) {
                if (Looper.myLooper() == zze.zzWK.getLooper()) {
                    z = true;
                }
                zzu.zza(z, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zze.zzWL.lock();
                try {
                    if (zze.zzaW(0)) {
                        if (!result.isSuccess()) {
                            zze.zzb(result, this.zzXk, this.zzXl);
                        }
                        if (zze.zzmC()) {
                            zze.zzmD();
                        }
                        zze.zzWL.unlock();
                    }
                } finally {
                    zze.zzWL.unlock();
                }
            }
        }
    }

    private class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zzd() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle connectionHint) {
            zze.this.zzWT.zza(new zzb(zze.this));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult result) {
            zze.this.zzWL.lock();
            try {
                if (zze.this.zzc((zze) result)) {
                    zze.this.zzmI();
                    zze.this.zzmG();
                } else {
                    zze.this.zzd((zze) result);
                }
            } finally {
                zze.this.zzWL.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int cause) {
        }
    }

    public zze(zzg zzg, com.google.android.gms.common.internal.zze zze, Map<Api<?>, Integer> map, Api.zza<? extends zzps, zzpt> zza2, Lock lock, Context context) {
        this.zzWK = zzg;
        this.zzXa = zze;
        this.zzXb = map;
        this.zzWE = zza2;
        this.zzWL = lock;
        this.mContext = context;
    }

    private void zzT(boolean z) {
        if (this.zzWT != null) {
            if (this.zzWT.isConnected()) {
                if (z) {
                    this.zzWT.zzxY();
                }
                this.zzWT.disconnect();
            }
            this.zzWX = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(ConnectionResult connectionResult) {
        this.zzWL.lock();
        try {
            if (zzaW(2)) {
                if (connectionResult.isSuccess()) {
                    zzmG();
                } else if (zzc(connectionResult)) {
                    zzmI();
                    zzmG();
                } else {
                    zzd(connectionResult);
                }
                this.zzWL.unlock();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zza(ResolveAccountResponse resolveAccountResponse) {
        ConnectionResult zzoa = resolveAccountResponse.zzoa();
        this.zzWL.lock();
        try {
            if (zzaW(0)) {
                if (zzoa.isSuccess()) {
                    this.zzWX = resolveAccountResponse.zznZ();
                    this.zzWW = true;
                    this.zzWY = resolveAccountResponse.zzob();
                    this.zzWZ = resolveAccountResponse.zzoc();
                    zzmE();
                } else if (zzc(zzoa)) {
                    zzmI();
                    if (this.zzWQ == 0) {
                        zzmG();
                    }
                } else {
                    zzd(zzoa);
                }
                this.zzWL.unlock();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zzb(connectionResult)) {
            return this.zzWM == null || i < this.zzWN;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean zzaW(int i) {
        if (this.zzWO == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzaX(this.zzWO) + " but received callback for step " + zzaX(i));
        zzd(new ConnectionResult(8, null));
        return false;
    }

    private String zzaX(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzmp().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzWM = connectionResult;
                this.zzWN = priority;
            }
        }
        this.zzWK.zzXv.put(api.zzms(), connectionResult);
    }

    private static boolean zzb(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || GooglePlayServicesUtil.zzaT(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean zzc(ConnectionResult connectionResult) {
        if (this.zzWU != 2) {
            return this.zzWU == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzd(ConnectionResult connectionResult) {
        boolean z = false;
        this.zzWP = false;
        this.zzWK.zzXw.clear();
        this.zzWM = connectionResult;
        if (!connectionResult.hasResolution()) {
            z = true;
        }
        zzT(z);
        zzaV(3);
        if (!this.zzWK.zzmO() || !GooglePlayServicesUtil.zze(this.mContext, connectionResult.getErrorCode())) {
            this.zzWK.zzmR();
            this.zzWK.zzXn.zzh(connectionResult);
        }
        this.zzWK.zzXn.zznT();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean zzmC() {
        this.zzWQ--;
        if (this.zzWQ > 0) {
            return false;
        }
        if (this.zzWQ < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            zzd(new ConnectionResult(8, null));
            return false;
        } else if (this.zzWM == null) {
            return true;
        } else {
            zzd(this.zzWM);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmD() {
        if (this.zzWV) {
            zzmE();
        } else {
            zzmG();
        }
    }

    private void zzmE() {
        if (this.zzWW && this.zzWQ == 0) {
            this.zzWO = 1;
            this.zzWQ = this.zzWK.zzXu.size();
            for (Api.ClientKey<?> clientKey : this.zzWK.zzXu.keySet()) {
                if (!this.zzWK.zzXv.containsKey(clientKey)) {
                    this.zzWK.zzXu.get(clientKey).validateAccount(this.zzWX);
                } else if (zzmC()) {
                    zzmF();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmF() {
        this.zzWO = 2;
        this.zzWK.zzXw = zzmJ();
        this.zzWT.zza(this.zzWX, this.zzWK.zzXw, new zza(this));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmG() {
        Set<Scope> set = this.zzWK.zzXw;
        Set<Scope> zzmJ = set.isEmpty() ? zzmJ() : set;
        this.zzWO = 3;
        this.zzWQ = this.zzWK.zzXu.size();
        for (Api.ClientKey<?> clientKey : this.zzWK.zzXu.keySet()) {
            if (!this.zzWK.zzXv.containsKey(clientKey)) {
                this.zzWK.zzXu.get(clientKey).getRemoteService(this.zzWX, zzmJ);
            } else if (zzmC()) {
                zzmH();
            }
        }
    }

    private void zzmH() {
        this.zzWK.zzmN();
        if (this.zzWT != null) {
            if (this.zzWY) {
                this.zzWT.zza(this.zzWX, this.zzWZ);
            }
            zzT(false);
        }
        for (Api.ClientKey<?> clientKey : this.zzWK.zzXv.keySet()) {
            this.zzWK.zzXu.get(clientKey).disconnect();
        }
        if (this.zzWP) {
            this.zzWP = false;
            zzaV(-1);
            return;
        }
        this.zzWK.zzXn.zzg(this.zzWR.isEmpty() ? null : this.zzWR);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzmI() {
        this.zzWV = false;
        this.zzWK.zzXw.clear();
        for (Api.ClientKey<?> clientKey : this.zzWS) {
            if (!this.zzWK.zzXv.containsKey(clientKey)) {
                this.zzWK.zzXv.put(clientKey, new ConnectionResult(17, null));
            }
        }
    }

    private Set<Scope> zzmJ() {
        HashSet hashSet = new HashSet(this.zzXa.zznv());
        Map<Api<?>, zze.zza> zznx = this.zzXa.zznx();
        for (Api<?> api : zznx.keySet()) {
            if (!this.zzWK.zzXv.containsKey(api.zzms())) {
                hashSet.addAll(zznx.get(api).zzWJ);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.zzh
    public void begin() {
        this.zzWK.zzXn.zznU();
        this.zzWK.zzXv.clear();
        this.zzWP = false;
        this.zzWV = false;
        this.zzWM = null;
        this.zzWO = 0;
        this.zzWU = 2;
        this.zzWW = false;
        this.zzWY = false;
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
            this.zzWK.zzXs.post(new Runnable() {
                /* class com.google.android.gms.common.api.zze.AnonymousClass1 */

                public void run() {
                    zze.this.zzWL.lock();
                    try {
                        zze.this.zzd((zze) connectionResult);
                    } finally {
                        zze.this.zzWL.unlock();
                    }
                }
            });
            return;
        }
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.zzXb.keySet()) {
            Api.Client client = this.zzWK.zzXu.get(api.zzms());
            int intValue = this.zzXb.get(api).intValue();
            boolean z2 = (api.zzmp().getPriority() == 1) | z;
            if (client.requiresSignIn()) {
                this.zzWV = true;
                if (intValue < this.zzWU) {
                    this.zzWU = intValue;
                }
                if (intValue != 0) {
                    this.zzWS.add(api.zzms());
                }
            }
            hashMap.put(client, new zzc(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.zzWV = false;
        }
        if (this.zzWV) {
            this.zzXa.zza(Integer.valueOf(this.zzWK.getSessionId()));
            zzd zzd2 = new zzd();
            this.zzWT = (zzps) this.zzWE.zza(this.mContext, this.zzWK.getLooper(), this.zzXa, this.zzXa.zznB(), zzd2, zzd2);
            this.zzWT.connect();
        }
        this.zzWQ = this.zzWK.zzXu.size();
        for (Api.Client client2 : this.zzWK.zzXu.values()) {
            client2.connect((GoogleApiClient.ConnectionProgressReportCallbacks) hashMap.get(client2));
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public void connect() {
        this.zzWP = false;
    }

    @Override // com.google.android.gms.common.api.zzh
    public String getName() {
        return "CONNECTING";
    }

    @Override // com.google.android.gms.common.api.zzh
    public void onConnected(Bundle connectionHint) {
        if (zzaW(3)) {
            if (connectionHint != null) {
                this.zzWR.putAll(connectionHint);
            }
            if (zzmC()) {
                zzmH();
            }
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public void onConnectionSuspended(int cause) {
        zzd(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.zzh
    public <A extends Api.Client, R extends Result, T extends zza.AbstractC0027zza<R, A>> T zza(T t) {
        this.zzWK.zzXo.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.zzh
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzaW(3)) {
            zzb(connectionResult, api, i);
            if (zzmC()) {
                zzmH();
            }
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public void zzaV(int i) {
        if (i == -1) {
            Iterator<zzg.zze<?>> it = this.zzWK.zzXo.iterator();
            while (it.hasNext()) {
                zzg.zze<?> next = it.next();
                if (next.zzmv() != 1) {
                    next.cancel();
                    it.remove();
                }
            }
            this.zzWK.zzmK();
            if (this.zzWM != null || this.zzWK.zzXo.isEmpty()) {
                this.zzWK.zzXv.clear();
                this.zzWM = null;
                zzT(true);
            } else {
                this.zzWP = true;
                return;
            }
        }
        this.zzWK.zze(this.zzWM);
    }

    @Override // com.google.android.gms.common.api.zzh
    public <A extends Api.Client, T extends zza.AbstractC0027zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
