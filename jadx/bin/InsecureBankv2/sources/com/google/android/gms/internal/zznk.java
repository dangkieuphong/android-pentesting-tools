package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zznm;

public class zznk extends zzi<zznm> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzOx;
    private zza zzawz;

    public static final class zza extends zznl.zza {
        private Activity mActivity;
        private final int zzZY;

        public zza(int i, Activity activity) {
            this.zzZY = i;
            this.mActivity = activity;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.google.android.gms.internal.zznl
        public void zzh(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.mActivity.createPendingResult(this.zzZY, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (PendingIntent.CanceledException e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                    }
                }
            } else {
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this.mActivity, this.zzZY);
                    } catch (IntentSender.SendIntentException e2) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    }
                } else {
                    try {
                        PendingIntent createPendingResult2 = this.mActivity.createPendingResult(this.zzZY, new Intent(), 1073741824);
                        if (createPendingResult2 != null) {
                            createPendingResult2.send(1);
                        }
                    } catch (PendingIntent.CanceledException e3) {
                        Log.w("AddressClientImpl", "Exception setting pending result", e3);
                    }
                }
            }
        }
    }

    public zznk(Activity activity, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, 12, connectionCallbacks, onConnectionFailedListener);
        this.zzOx = str;
        this.mActivity = activity;
        this.mTheme = i;
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        super.disconnect();
        if (this.zzawz != null) {
            this.zzawz.setActivity(null);
            this.zzawz = null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.identity.service.BIND";
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public boolean requiresAccount() {
        return true;
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzuc();
        this.zzawz = new zza(i, this.mActivity);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzOx)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzOx, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzub().zza(this.zzawz, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_ERROR_CODE, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzawz.zzh(1, bundle2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbO */
    public zznm zzT(IBinder iBinder) {
        return zznm.zza.zzbQ(iBinder);
    }

    /* access modifiers changed from: protected */
    public zznm zzub() throws DeadObjectException {
        return (zznm) super.zznM();
    }

    /* access modifiers changed from: protected */
    public void zzuc() {
        super.zznL();
    }
}
