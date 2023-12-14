package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import java.util.HashMap;
import java.util.Map;

@zzgd
public class zzdm implements zzdg {
    static final Map<String, Integer> zzwy = new HashMap();
    private final zzd zzww;
    private final zzep zzwx;

    static {
        zzwy.put("resize", 1);
        zzwy.put("playVideo", 2);
        zzwy.put("storePicture", 3);
        zzwy.put("createCalendarEvent", 4);
        zzwy.put("setOrientationProperties", 5);
        zzwy.put("closeResizedAd", 6);
    }

    public zzdm(zzd zzd, zzep zzep) {
        this.zzww = zzd;
        this.zzwx = zzep;
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        int intValue = zzwy.get(map.get("a")).intValue();
        if (intValue == 5 || this.zzww == null || this.zzww.zzbd()) {
            switch (intValue) {
                case 1:
                    this.zzwx.zzh(map);
                    return;
                case 2:
                default:
                    zzb.zzaA("Unknown MRAID command called.");
                    return;
                case 3:
                    new zzer(zzid, map).execute();
                    return;
                case 4:
                    new zzeo(zzid, map).execute();
                    return;
                case 5:
                    new zzeq(zzid, map).execute();
                    return;
                case 6:
                    this.zzwx.zzn(true);
                    return;
            }
        } else {
            this.zzww.zzo(null);
        }
    }
}
