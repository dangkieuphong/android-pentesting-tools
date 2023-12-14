package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzft {

    public interface zza {
        void zzb(zzha zzha);
    }

    public zzhh zza(Context context, com.google.android.gms.ads.internal.zza zza2, zzha.zza zza3, zzan zzan, zzid zzid, zzef zzef, zza zza4) {
        zzhh zzfw;
        AdResponseParcel adResponseParcel = zza3.zzFs;
        if (!adResponseParcel.zzsp) {
            zzfw = adResponseParcel.zzCK ? new zzfw(context, zza3, zzid, zzef, zza4) : adResponseParcel.zzCQ ? new zzfr(context, zza3, zzid, zza4) : (!zzbz.zzuj.get().booleanValue() || !zzlk.zzoX() || zzlk.isAtLeastL() || !zzid.zzaN().zzsn) ? new zzfu(context, zza3, zzid, zza4) : new zzfv(context, zza3, zzid, zza4);
        } else if (zza2 instanceof zzm) {
            zzfw = new zzfx(context, (zzm) zza2, new zzbc(), zza3, zzan, zza4);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zza2 != null ? zza2.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        zzfw.zzgj();
        return zzfw;
    }
}
