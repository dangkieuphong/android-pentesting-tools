package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzx extends zzdd {
    private static final String ID = zzad.DATA_LAYER_WRITE.toString();
    private static final String VALUE = zzae.VALUE.toString();
    private static final String zzaLz = zzae.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzaKz;

    public zzx(DataLayer dataLayer) {
        super(ID, VALUE);
        this.zzaKz = dataLayer;
    }

    private void zza(zzag.zza zza) {
        String zzg;
        if (zza != null && zza != zzdf.zzzK() && (zzg = zzdf.zzg(zza)) != zzdf.zzzP()) {
            this.zzaKz.zzen(zzg);
        }
    }

    private void zzb(zzag.zza zza) {
        if (!(zza == null || zza == zzdf.zzzK())) {
            Object zzl = zzdf.zzl(zza);
            if (zzl instanceof List) {
                for (Object obj : (List) zzl) {
                    if (obj instanceof Map) {
                        this.zzaKz.push((Map) obj);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdd
    public void zzG(Map<String, zzag.zza> map) {
        zzb(map.get(VALUE));
        zza(map.get(zzaLz));
    }
}
