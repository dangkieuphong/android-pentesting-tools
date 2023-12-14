package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;

public class zzkb extends zzi<zzkd> implements IBinder.DeathRecipient {
    private static final zzl zzQW = new zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzQH;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzVB;

    public zzkb(Context context, Looper looper, CastDevice castDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, connectionCallbacks, onConnectionFailedListener);
        this.zzVB = castRemoteDisplaySessionCallbacks;
        this.zzQH = castDevice;
    }

    public void binderDied() {
    }

    @Override // com.google.android.gms.common.api.Api.Client, com.google.android.gms.common.internal.zzi
    public void disconnect() {
        try {
            ((zzkd) zznM()).disconnect();
        } catch (RemoteException e) {
        } finally {
            super.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    public void zza(zzkc zzkc) throws RemoteException {
        zzQW.zzb("stopRemoteDisplay", new Object[0]);
        ((zzkd) zznM()).zza(zzkc);
    }

    public void zza(zzkc zzkc, int i) throws RemoteException {
        ((zzkd) zznM()).zza(zzkc, i);
    }

    public void zza(zzkc zzkc, final zzke zzke, String str) throws RemoteException {
        zzQW.zzb("startRemoteDisplay", new Object[0]);
        ((zzkd) zznM()).zza(zzkc, new zzke.zza() {
            /* class com.google.android.gms.internal.zzkb.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzke
            public void zzaR(int i) throws RemoteException {
                zzkb.zzQW.zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzke != null) {
                    zzke.zzaR(i);
                }
                if (zzkb.this.zzVB != null) {
                    zzkb.this.zzVB.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzQH.getDeviceId(), str);
    }

    /* renamed from: zzay */
    public zzkd zzT(IBinder iBinder) {
        return zzkd.zza.zzaA(iBinder);
    }
}
