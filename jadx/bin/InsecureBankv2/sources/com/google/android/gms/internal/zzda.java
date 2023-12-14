package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzcv;

@zzgd
public class zzda extends zzcv.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzvR;

    public zzda(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzvR = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcv
    public void zza(zzcq zzcq) {
        this.zzvR.onContentAdLoaded(zzb(zzcq));
    }

    /* access modifiers changed from: package-private */
    public zzcr zzb(zzcq zzcq) {
        return new zzcr(zzcq);
    }
}
