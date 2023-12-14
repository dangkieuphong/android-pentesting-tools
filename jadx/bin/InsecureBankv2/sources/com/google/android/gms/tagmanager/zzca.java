package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;
import java.util.Set;

public abstract class zzca extends zzak {
    private static final String zzaLE = zzae.ARG0.toString();
    private static final String zzaMC = zzae.ARG1.toString();

    public zzca(String str) {
        super(str, zzaLE, zzaMC);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        for (zzag.zza zza : map.values()) {
            if (zza == zzdf.zzzQ()) {
                return zzdf.zzI(false);
            }
        }
        zzag.zza zza2 = map.get(zzaLE);
        zzag.zza zza3 = map.get(zzaMC);
        return zzdf.zzI(Boolean.valueOf((zza2 == null || zza3 == null) ? false : zza(zza2, zza3, map)));
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzag.zza zza, zzag.zza zza2, Map<String, zzag.zza> map);

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ String zzyM() {
        return super.zzyM();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public /* bridge */ /* synthetic */ Set zzyN() {
        return super.zzyN();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
