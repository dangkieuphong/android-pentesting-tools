package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzai extends zzak {
    private static final String ID = zzad.EVENT.toString();
    private final zzcp zzaKA;

    public zzai(zzcp zzcp) {
        super(ID, new String[0]);
        this.zzaKA = zzcp;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String zzzp = this.zzaKA.zzzp();
        return zzzp == null ? zzdf.zzzQ() : zzdf.zzI(zzzp);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
