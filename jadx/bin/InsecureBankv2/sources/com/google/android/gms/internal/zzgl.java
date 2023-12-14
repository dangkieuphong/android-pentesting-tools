package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzgk;
import java.util.WeakHashMap;

@zzgd
public final class zzgl {
    private WeakHashMap<Context, zza> zzEH = new WeakHashMap<>();

    /* access modifiers changed from: private */
    public class zza {
        public final long zzEI = zzo.zzbz().currentTimeMillis();
        public final zzgk zzEJ;

        public zza(zzgk zzgk) {
            this.zzEJ = zzgk;
        }

        public boolean hasExpired() {
            return zzbz.zzuw.get().longValue() + this.zzEI < zzo.zzbz().currentTimeMillis();
        }
    }

    public zzgk zzC(Context context) {
        zza zza2 = this.zzEH.get(context);
        zzgk zzfJ = (zza2 == null || zza2.hasExpired() || !zzbz.zzuv.get().booleanValue()) ? new zzgk.zza(context).zzfJ() : new zzgk.zza(context, zza2.zzEJ).zzfJ();
        this.zzEH.put(context, new zza(zzfJ));
        return zzfJ;
    }
}
