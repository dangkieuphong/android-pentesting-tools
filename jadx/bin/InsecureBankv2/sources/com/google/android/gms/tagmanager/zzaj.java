package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzaj {
    private static void zza(DataLayer dataLayer, zzaf.zzd zzd) {
        for (zzag.zza zza : zzd.zzhX) {
            dataLayer.zzen(zzdf.zzg(zza));
        }
    }

    public static void zza(DataLayer dataLayer, zzaf.zzi zzi) {
        if (zzi.zziM == null) {
            zzbg.zzaC("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zzi.zziM);
        zzb(dataLayer, zzi.zziM);
        zzc(dataLayer, zzi.zziM);
    }

    private static void zzb(DataLayer dataLayer, zzaf.zzd zzd) {
        for (zzag.zza zza : zzd.zzhW) {
            Map<String, Object> zzc = zzc(zza);
            if (zzc != null) {
                dataLayer.push(zzc);
            }
        }
    }

    private static Map<String, Object> zzc(zzag.zza zza) {
        Object zzl = zzdf.zzl(zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbg.zzaC("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzaf.zzd zzd) {
        zzaf.zzc[] zzcArr = zzd.zzhY;
        for (zzaf.zzc zzc : zzcArr) {
            if (zzc.zzaC == null) {
                zzbg.zzaC("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(zzc.zzaC);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = zzc.zzhS;
                long j2 = zzc.zzhT;
                if (!zzc.zzhU || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbg.zzaC("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzen(zzc.zzaC);
                Map<String, Object> zzj = dataLayer.zzj(zzc.zzaC, obj);
                if (zzc.zzhV > 0) {
                    if (!zzj.containsKey("gtm")) {
                        zzj.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzc.zzhV)));
                    } else {
                        Object obj2 = zzj.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(zzc.zzhV));
                        } else {
                            zzbg.zzaC("GaExperimentRandom: gtm not a map");
                        }
                    }
                }
                dataLayer.push(zzj);
            }
        }
    }
}
