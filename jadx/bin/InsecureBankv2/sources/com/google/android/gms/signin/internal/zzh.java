package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.signin.internal.zzd;
import com.google.android.gms.signin.internal.zzf;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzh extends zzi<zzf> implements zzps {
    private final zze zzXa;
    private final zzpt zzZU;
    private Integer zzZV;
    private final boolean zzaKa;
    private final ExecutorService zzaKb;

    /* access modifiers changed from: private */
    public static class zza extends zzd.zza {
        private final zzpt zzZU;
        private final ExecutorService zzaKb;

        public zza(zzpt zzpt, ExecutorService executorService) {
            this.zzZU = zzpt;
            this.zzaKb = executorService;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private GoogleApiClient.ServerAuthCodeCallbacks zzyb() throws RemoteException {
            return this.zzZU.zzyb();
        }

        @Override // com.google.android.gms.signin.internal.zzd
        public void zza(final String str, final String str2, final zzf zzf) throws RemoteException {
            this.zzaKb.submit(new Runnable() {
                /* class com.google.android.gms.signin.internal.zzh.zza.AnonymousClass2 */

                public void run() {
                    try {
                        zzf.zzal(zza.this.zzyb().onUploadServerAuthCode(str, str2));
                    } catch (RemoteException e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
                    }
                }
            });
        }

        @Override // com.google.android.gms.signin.internal.zzd
        public void zza(final String str, final List<Scope> list, final zzf zzf) throws RemoteException {
            this.zzaKb.submit(new Runnable() {
                /* class com.google.android.gms.signin.internal.zzh.zza.AnonymousClass1 */

                public void run() {
                    try {
                        GoogleApiClient.ServerAuthCodeCallbacks.CheckResult onCheckServerAuthorization = zza.this.zzyb().onCheckServerAuthorization(str, Collections.unmodifiableSet(new HashSet(list)));
                        zzf.zza(new CheckServerAuthResult(onCheckServerAuthorization.zzmA(), onCheckServerAuthorization.zzmB()));
                    } catch (RemoteException e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
                    }
                }
            });
        }
    }

    public zzh(Context context, Looper looper, boolean z, zze zze, zzpt zzpt, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        super(context, looper, 44, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzaKa = z;
        this.zzXa = zze;
        this.zzZU = zzpt;
        this.zzZV = zze.zznC();
        this.zzaKb = executorService;
    }

    public static Bundle zza(zzpt zzpt, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzpt.zzxZ());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzpt.zzya());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzpt.zzxt());
        if (zzpt.zzyb() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(zzpt, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.zzps
    public void connect() {
        connect(new zzi.zzf());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresSignIn() {
        return this.zzaKa;
    }

    @Override // com.google.android.gms.internal.zzps
    public void zza(IAccountAccessor iAccountAccessor, Set<Scope> set, zze zze) {
        zzu.zzb(zze, "Expecting a valid ISignInCallbacks");
        try {
            ((zzf) zznM()).zza(new AuthAccountRequest(iAccountAccessor, set), zze);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                zze.zza(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    @Override // com.google.android.gms.internal.zzps
    public void zza(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zzf) zznM()).zza(iAccountAccessor, this.zzZV.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzps
    public void zza(zzq zzq) {
        zzu.zzb(zzq, "Expecting a valid IResolveAccountCallbacks");
        try {
            ((zzf) zznM()).zza(new ResolveAccountRequest(this.zzXa.zznt(), this.zzZV.intValue()), zzq);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                zzq.zzb(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdE */
    public zzf zzT(IBinder iBinder) {
        return zzf.zza.zzdD(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Bundle zzkR() {
        Bundle zza2 = zza(this.zzZU, this.zzXa.zznC(), this.zzaKb);
        if (!getContext().getPackageName().equals(this.zzXa.zzny())) {
            zza2.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzXa.zzny());
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.zzps
    public void zzxY() {
        try {
            ((zzf) zznM()).zziQ(this.zzZV.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }
}
