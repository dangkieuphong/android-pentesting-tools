package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* access modifiers changed from: package-private */
public class zzdj {
    private static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbw) {
        try {
            return new zzbw<>(zzdf.zzI(zzeQ(zzdf.zzg(zzbw.getObject()))), zzbw.zzza());
        } catch (UnsupportedEncodingException e) {
            zzbg.zzb("Escape URI: unsupported encoding", e);
            return zzbw;
        }
    }

    private static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbw, int i) {
        if (!zzn(zzbw.getObject())) {
            zzbg.zzaz("Escaping can only be applied to strings.");
            return zzbw;
        }
        switch (i) {
            case 12:
                return zza(zzbw);
            default:
                zzbg.zzaz("Unsupported Value Escaping: " + i);
                return zzbw;
        }
    }

    static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbw, int... iArr) {
        for (int i : iArr) {
            zzbw = zza(zzbw, i);
        }
        return zzbw;
    }

    static String zzeQ(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zzag.zza zza) {
        return zzdf.zzl(zza) instanceof String;
    }
}
