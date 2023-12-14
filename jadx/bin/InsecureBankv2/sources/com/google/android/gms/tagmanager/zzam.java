package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzam extends zzbv {
    private static final String ID = zzad.GREATER_EQUALS.toString();

    public zzam() {
        super(ID);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.tagmanager.zzbv
    public boolean zza(zzde zzde, zzde zzde2, Map<String, zzag.zza> map) {
        return zzde.compareTo(zzde2) >= 0;
    }
}
