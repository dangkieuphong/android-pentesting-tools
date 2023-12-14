package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Map;

@zzgd
public class zzeq {
    private final zzid zzoA;
    private final boolean zzyJ;
    private final String zzyK;

    public zzeq(zzid zzid, Map<String, String> map) {
        this.zzoA = zzid;
        this.zzyK = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzyJ = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzyJ = true;
        }
    }

    public void execute() {
        if (this.zzoA == null) {
            zzb.zzaC("AdWebView is null");
        } else {
            this.zzoA.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzyK) ? zzo.zzbx().zzgr() : "landscape".equalsIgnoreCase(this.zzyK) ? zzo.zzbx().zzgq() : this.zzyJ ? -1 : zzo.zzbx().zzgs());
        }
    }
}
