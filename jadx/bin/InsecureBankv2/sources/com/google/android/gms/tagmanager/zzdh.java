package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzdh extends zzak {
    private static final String ID = zzad.UPPERCASE_STRING.toString();
    private static final String zzaLE = zzae.ARG0.toString();

    public zzdh() {
        super(ID, zzaLE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(zzdf.zzg(map.get(zzaLE)).toUpperCase());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
