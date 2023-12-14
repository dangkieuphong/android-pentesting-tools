package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzqy extends zzg<zzqt> {
    private static zzqy zzaSv;

    protected zzqy() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzqy zzAM() {
        if (zzaSv == null) {
            zzaSv = new zzqy();
        }
        return zzaSv;
    }

    public static zzqq zza(Activity activity, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzqr zzqr) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzqt) zzAM().zzak(activity)).zza(zze.zzw(activity), zzc, walletFragmentOptions, zzqr);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (zzg.zza e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdM */
    public zzqt zzd(IBinder iBinder) {
        return zzqt.zza.zzdI(iBinder);
    }
}
