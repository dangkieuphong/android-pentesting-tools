package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzgd
public final class zzdd implements zzdg {
    private final zzde zzvU;

    public zzdd(zzde zzde) {
        this.zzvU = zzde;
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzb.zzaC("App event with no name parameter.");
        } else {
            this.zzvU.onAppEvent(str, map.get("info"));
        }
    }
}
