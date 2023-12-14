package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.reward.client.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgn;

@zzgd
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzee zzee) {
        try {
            return zzb.zza.zzX(((zzc) zzak(context)).zza(zze.zzw(context), zzee, 7571000));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    public zzb zza(Context context, zzee zzee) {
        zzb zzb;
        if (zzk.zzcA().zzP(context) && (zzb = zzb(context, zzee)) != null) {
            return zzb;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Using RewardedVideoAd from the client jar.");
        return new zzgn(context, zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaa */
    public zzc zzd(IBinder iBinder) {
        return zzc.zza.zzY(iBinder);
    }
}
