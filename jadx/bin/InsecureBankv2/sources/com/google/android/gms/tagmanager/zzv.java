package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzv extends zzak {
    private static final String ID = zzad.CUSTOM_VAR.toString();
    private static final String NAME = zzae.NAME.toString();
    private static final String zzaLo = zzae.DEFAULT_VALUE.toString();
    private final DataLayer zzaKz;

    public zzv(DataLayer dataLayer) {
        super(ID, NAME);
        this.zzaKz = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        Object obj = this.zzaKz.get(zzdf.zzg(map.get(NAME)));
        if (obj != null) {
            return zzdf.zzI(obj);
        }
        zzag.zza zza = map.get(zzaLo);
        return zza != null ? zza : zzdf.zzzQ();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
