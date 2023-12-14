package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzcu;

@zzgd
public class zzcz extends zzcu.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzvQ;

    public zzcz(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzvQ = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcu
    public void zza(zzco zzco) {
        this.zzvQ.onAppInstallAdLoaded(zzb(zzco));
    }

    /* access modifiers changed from: package-private */
    public zzcp zzb(zzco zzco) {
        return new zzcp(zzco);
    }
}
