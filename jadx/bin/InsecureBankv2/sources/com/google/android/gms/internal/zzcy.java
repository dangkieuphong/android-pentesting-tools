package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcn;

public class zzcy extends zzg<zzcn> {
    public zzcy() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzcm zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzcm.zza.zzu(((zzcn) zzak(context)).zza(zze.zzw(context), zze.zzw(frameLayout), zze.zzw(frameLayout2), 7571000));
        } catch (RemoteException | zzg.zza e) {
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzD */
    public zzcn zzd(IBinder iBinder) {
        return zzcn.zza.zzv(iBinder);
    }

    public zzcm zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzcm zzb;
        if (zzk.zzcA().zzP(context) && (zzb = zzb(context, frameLayout, frameLayout2)) != null) {
            return zzb;
        }
        zzb.zzay("Using NativeAdViewDelegate from the client jar.");
        return new zzi(frameLayout, frameLayout2);
    }
}
