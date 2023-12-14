package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzc extends zzak {
    private static final String ID = zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzaKo;

    public zzc(Context context) {
        this(zza.zzaE(context));
    }

    zzc(zza zza) {
        super(ID, new String[0]);
        this.zzaKo = zza;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(Boolean.valueOf(!this.zzaKo.isLimitAdTrackingEnabled()));
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
