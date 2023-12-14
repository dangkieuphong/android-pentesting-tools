package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzcc extends zzak {
    private static final String ID = zzad.RANDOM.toString();
    private static final String zzaMM = zzae.MIN.toString();
    private static final String zzaMN = zzae.MAX.toString();

    public zzcc() {
        super(ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        double d;
        double d2;
        zzag.zza zza = map.get(zzaMM);
        zzag.zza zza2 = map.get(zzaMN);
        if (!(zza == null || zza == zzdf.zzzQ() || zza2 == null || zza2 == zzdf.zzzQ())) {
            zzde zzh = zzdf.zzh(zza);
            zzde zzh2 = zzdf.zzh(zza2);
            if (!(zzh == zzdf.zzzO() || zzh2 == zzdf.zzzO())) {
                double doubleValue = zzh.doubleValue();
                d = zzh2.doubleValue();
                if (doubleValue <= d) {
                    d2 = doubleValue;
                    return zzdf.zzI(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
                }
            }
        }
        d = 2.147483647E9d;
        d2 = 0.0d;
        return zzdf.zzI(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
