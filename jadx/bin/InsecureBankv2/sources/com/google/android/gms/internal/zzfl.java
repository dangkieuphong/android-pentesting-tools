package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzfh;

@zzgd
public final class zzfl extends zzg<zzfh> {
    private static final zzfl zzBb = new zzfl();

    /* access modifiers changed from: private */
    public static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzfl() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static zzfg zze(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzBb.zzf(activity);
            }
            zzb.zzay("Using AdOverlay from the client jar.");
            return new zze(activity);
        } catch (zza e) {
            zzb.zzaC(e.getMessage());
            return null;
        }
    }

    private zzfg zzf(Activity activity) {
        try {
            return zzfg.zza.zzN(((zzfh) zzak(activity)).zzd(com.google.android.gms.dynamic.zze.zzw(activity)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzR */
    public zzfh zzd(IBinder iBinder) {
        return zzfh.zza.zzO(iBinder);
    }
}
