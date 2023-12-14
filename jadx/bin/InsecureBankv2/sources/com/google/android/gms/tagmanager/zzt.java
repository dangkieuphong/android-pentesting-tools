package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzt extends zzak {
    private static final String ID = zzad.FUNCTION_CALL.toString();
    private static final String zzaKr = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzaLd = zzae.FUNCTION_CALL_NAME.toString();
    private final zza zzaLe;

    public interface zza {
        Object zzd(String str, Map<String, Object> map);
    }

    public zzt(zza zza2) {
        super(ID, zzaLd);
        this.zzaLe = zza2;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String zzg = zzdf.zzg(map.get(zzaLd));
        HashMap hashMap = new HashMap();
        zzag.zza zza2 = map.get(zzaKr);
        if (zza2 != null) {
            Object zzl = zzdf.zzl(zza2);
            if (!(zzl instanceof Map)) {
                zzbg.zzaC("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzzQ();
            }
            for (Map.Entry entry : ((Map) zzl).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzdf.zzI(this.zzaLe.zzd(zzg, hashMap));
        } catch (Exception e) {
            zzbg.zzaC("Custom macro/tag " + zzg + " threw exception " + e.getMessage());
            return zzdf.zzzQ();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
