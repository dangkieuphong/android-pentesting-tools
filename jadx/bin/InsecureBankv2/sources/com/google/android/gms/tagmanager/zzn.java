package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzn extends zzak {
    private static final String ID = zzad.CONSTANT.toString();
    private static final String VALUE = zzae.VALUE.toString();

    public zzn() {
        super(ID, VALUE);
    }

    public static String zzyk() {
        return ID;
    }

    public static String zzyl() {
        return VALUE;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return map.get(VALUE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
