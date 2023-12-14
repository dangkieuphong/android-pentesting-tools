package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zze extends zzak {
    private static final String ID = zzad.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzaKp = zzae.COMPONENT.toString();
    private static final String zzaKq = zzae.CONVERSION_ID.toString();
    private final Context zzpH;

    public zze(Context context) {
        super(ID, zzaKq);
        this.zzpH = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        zzag.zza zza = map.get(zzaKq);
        if (zza == null) {
            return zzdf.zzzQ();
        }
        String zzg = zzdf.zzg(zza);
        zzag.zza zza2 = map.get(zzaKp);
        String zzf = zzax.zzf(this.zzpH, zzg, zza2 != null ? zzdf.zzg(zza2) : null);
        return zzf != null ? zzdf.zzI(zzf) : zzdf.zzzQ();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
