package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.util.Map;

@zzgd
public class zzds implements zzdg {
    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        zzdq zzbH = zzo.zzbH();
        if (!map.containsKey("abort")) {
            String str = map.get("src");
            if (str == null) {
                zzb.zzaC("Precache video action is missing the src parameter.");
            } else if (zzbH.zzb(zzid)) {
                zzb.zzaC("Precache task already running.");
            } else {
                new zzdp(zzid, str).zzgi();
            }
        } else if (!zzbH.zza(zzid)) {
            zzb.zzaC("Precache abort but no preload task running.");
        }
    }
}
