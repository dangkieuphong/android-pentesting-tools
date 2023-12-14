package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzae extends zzcz {
    private static final String ID = zzad.ENDS_WITH.toString();

    public zzae() {
        super(ID);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.tagmanager.zzcz
    public boolean zza(String str, String str2, Map<String, zzag.zza> map) {
        return str.endsWith(str2);
    }
}
