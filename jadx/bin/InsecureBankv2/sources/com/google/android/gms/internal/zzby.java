package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;

@zzgd
public class zzby {
    private boolean zzpb = false;
    private final Object zzqt = new Object();
    private SharedPreferences zztB = null;

    public <T> T zzc(zzbv<T> zzbv) {
        synchronized (this.zzqt) {
            if (this.zzpb) {
                return zzbv.zza(this.zztB);
            }
            return zzbv.zzcY();
        }
    }

    public void zzw(Context context) {
        synchronized (this.zzqt) {
            if (!this.zzpb) {
                Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
                if (remoteContext != null) {
                    this.zztB = zzo.zzbC().zzv(remoteContext);
                    this.zzpb = true;
                }
            }
        }
    }
}
