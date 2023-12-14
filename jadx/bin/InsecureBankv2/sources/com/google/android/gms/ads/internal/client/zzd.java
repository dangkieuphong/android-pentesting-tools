package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class zzd extends zzg<zzq> {
    private static final zzd zzrW = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzp zza(Context context, String str, zzee zzee) {
        zzp zzb;
        if (zzk.zzcA().zzP(context) && (zzb = zzrW.zzb(context, str, zzee)) != null) {
            return zzb;
        }
        zzb.zzay("Using AdLoader from the client jar.");
        return new zzi(context, str, zzee, new VersionInfoParcel(7571000, 7571000, true));
    }

    private zzp zzb(Context context, String str, zzee zzee) {
        try {
            return zzp.zza.zzi(((zzq) zzak(context)).zza(zze.zzw(context), str, zzee, 7571000));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzc */
    public zzq zzd(IBinder iBinder) {
        return zzq.zza.zzj(iBinder);
    }
}
