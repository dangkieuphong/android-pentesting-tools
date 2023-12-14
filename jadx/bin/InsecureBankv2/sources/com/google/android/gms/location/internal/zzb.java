package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.location.internal.zzg;

public class zzb extends zzi<zzg> {
    protected final zzn<zzg> zzayq = new zzn<zzg>() {
        /* class com.google.android.gms.location.internal.zzb.AnonymousClass1 */

        @Override // com.google.android.gms.location.internal.zzn
        public void zznL() {
            zzb.this.zznL();
        }

        /* renamed from: zzut */
        public zzg zznM() throws DeadObjectException {
            return (zzg) zzb.this.zznM();
        }
    };
    private final String zzayw;

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zze zze) {
        super(context, looper, 23, connectionCallbacks, onConnectionFailedListener, zze);
        this.zzayw = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbU */
    public zzg zzT(IBinder iBinder) {
        return zzg.zza.zzbW(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    public Bundle zzkR() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzayw);
        return bundle;
    }
}
