package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zze extends zzg<zzs> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzr zza(Context context, AdSizeParcel adSizeParcel, String str, zzee zzee, int i) {
        try {
            return zzr.zza.zzk(((zzs) zzak(context)).zza(com.google.android.gms.dynamic.zze.zzw(context), adSizeParcel, str, zzee, 7571000, i));
        } catch (RemoteException | zzg.zza e) {
            zzb.zzd("Could not create remote AdManager.", e);
            return null;
        }
    }

    public zzr zza(Context context, AdSizeParcel adSizeParcel, String str, zzee zzee) {
        zzr zza;
        if (zzk.zzcA().zzP(context) && (zza = zza(context, adSizeParcel, str, zzee, 1)) != null) {
            return zza;
        }
        zzb.zzay("Using BannerAdManager from the client jar.");
        return new com.google.android.gms.ads.internal.zze(context, adSizeParcel, str, zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    public zzr zzb(Context context, AdSizeParcel adSizeParcel, String str, zzee zzee) {
        zzr zza;
        if (zzk.zzcA().zzP(context) && (zza = zza(context, adSizeParcel, str, zzee, 2)) != null) {
            return zza;
        }
        zzb.zzaC("Using InterstitialAdManager from the client jar.");
        return new zzj(context, adSizeParcel, str, zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zze */
    public zzs zzd(IBinder iBinder) {
        return zzs.zza.zzl(iBinder);
    }
}
