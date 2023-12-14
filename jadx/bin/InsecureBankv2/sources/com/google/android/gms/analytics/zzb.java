package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzny;
import com.google.android.gms.internal.zznz;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoc;
import com.google.android.gms.internal.zzod;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzof;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzb extends zzc implements zznu {
    private static DecimalFormat zzIk;
    private final zzf zzIa;
    private final Uri zzIl;
    private final boolean zzIm;
    private final boolean zzIn;
    private final String zztd;

    public zzb(zzf zzf, String str) {
        this(zzf, str, true, false);
    }

    public zzb(zzf zzf, String str, boolean z, boolean z2) {
        super(zzf);
        zzu.zzcj(str);
        this.zzIa = zzf;
        this.zztd = str;
        this.zzIm = z;
        this.zzIn = z2;
        this.zzIl = zzaK(this.zztd);
    }

    static String zza(double d) {
        if (zzIk == null) {
            zzIk = new DecimalFormat("0.######");
        }
        return zzIk.format(d);
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zza(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void zza(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    static Uri zzaK(String str) {
        zzu.zzcj(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    public static Map<String, String> zzc(zzno zzno) {
        HashMap hashMap = new HashMap();
        zzio zzio = (zzio) zzno.zzd(zzio.class);
        if (zzio != null) {
            for (Map.Entry<String, Object> entry : zzio.zzhv().entrySet()) {
                String zzh = zzh(entry.getValue());
                if (zzh != null) {
                    hashMap.put(entry.getKey(), zzh);
                }
            }
        }
        zzip zzip = (zzip) zzno.zzd(zzip.class);
        if (zzip != null) {
            zza(hashMap, "t", zzip.zzhw());
            zza(hashMap, "cid", zzip.getClientId());
            zza(hashMap, "uid", zzip.getUserId());
            zza(hashMap, "sc", zzip.zzhz());
            zza(hashMap, "sf", zzip.zzhB());
            zza(hashMap, "ni", zzip.zzhA());
            zza(hashMap, "adid", zzip.zzhx());
            zza(hashMap, "ate", zzip.zzhy());
        }
        zzod zzod = (zzod) zzno.zzd(zzod.class);
        if (zzod != null) {
            zza(hashMap, "cd", zzod.zzwB());
            zza(hashMap, "a", (double) zzod.zzbn());
            zza(hashMap, "dr", zzod.zzwE());
        }
        zzob zzob = (zzob) zzno.zzd(zzob.class);
        if (zzob != null) {
            zza(hashMap, "ec", zzob.zzwy());
            zza(hashMap, "ea", zzob.getAction());
            zza(hashMap, "el", zzob.getLabel());
            zza(hashMap, "ev", (double) zzob.getValue());
        }
        zzny zzny = (zzny) zzno.zzd(zzny.class);
        if (zzny != null) {
            zza(hashMap, "cn", zzny.getName());
            zza(hashMap, "cs", zzny.getSource());
            zza(hashMap, "cm", zzny.zzwj());
            zza(hashMap, "ck", zzny.zzwk());
            zza(hashMap, "cc", zzny.getContent());
            zza(hashMap, "ci", zzny.getId());
            zza(hashMap, "anid", zzny.zzwl());
            zza(hashMap, "gclid", zzny.zzwm());
            zza(hashMap, "dclid", zzny.zzwn());
            zza(hashMap, "aclid", zzny.zzwo());
        }
        zzoc zzoc = (zzoc) zzno.zzd(zzoc.class);
        if (zzoc != null) {
            zza(hashMap, "exd", zzoc.getDescription());
            zza(hashMap, "exf", zzoc.zzwz());
        }
        zzoe zzoe = (zzoe) zzno.zzd(zzoe.class);
        if (zzoe != null) {
            zza(hashMap, "sn", zzoe.zzwI());
            zza(hashMap, "sa", zzoe.getAction());
            zza(hashMap, "st", zzoe.getTarget());
        }
        zzof zzof = (zzof) zzno.zzd(zzof.class);
        if (zzof != null) {
            zza(hashMap, "utv", zzof.zzwJ());
            zza(hashMap, "utt", (double) zzof.getTimeInMillis());
            zza(hashMap, "utc", zzof.zzwy());
            zza(hashMap, "utl", zzof.getLabel());
        }
        zzim zzim = (zzim) zzno.zzd(zzim.class);
        if (zzim != null) {
            for (Map.Entry<Integer, String> entry2 : zzim.zzht().entrySet()) {
                String zzO = zzc.zzO(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(zzO)) {
                    hashMap.put(zzO, entry2.getValue());
                }
            }
        }
        zzin zzin = (zzin) zzno.zzd(zzin.class);
        if (zzin != null) {
            for (Map.Entry<Integer, Double> entry3 : zzin.zzhu().entrySet()) {
                String zzQ = zzc.zzQ(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(zzQ)) {
                    hashMap.put(zzQ, zza(entry3.getValue().doubleValue()));
                }
            }
        }
        zzoa zzoa = (zzoa) zzno.zzd(zzoa.class);
        if (zzoa != null) {
            ProductAction zzwu = zzoa.zzwu();
            if (zzwu != null) {
                for (Map.Entry<String, String> entry4 : zzwu.build().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        hashMap.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion promotion : zzoa.zzwx()) {
                hashMap.putAll(promotion.zzaQ(zzc.zzU(i)));
                i++;
            }
            int i2 = 1;
            for (Product product : zzoa.zzwv()) {
                hashMap.putAll(product.zzaQ(zzc.zzS(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzoa.zzww().entrySet()) {
                String zzX = zzc.zzX(i3);
                int i4 = 1;
                for (Product product2 : entry5.getValue()) {
                    hashMap.putAll(product2.zzaQ(zzX + zzc.zzV(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    hashMap.put(zzX + "nm", entry5.getKey());
                }
                i3++;
            }
        }
        zznz zznz = (zznz) zzno.zzd(zznz.class);
        if (zznz != null) {
            zza(hashMap, "ul", zznz.getLanguage());
            zza(hashMap, "sd", (double) zznz.zzwp());
            zza(hashMap, "sr", zznz.zzwq(), zznz.zzwr());
            zza(hashMap, "vp", zznz.zzws(), zznz.zzwt());
        }
        zznx zznx = (zznx) zzno.zzd(zznx.class);
        if (zznx != null) {
            zza(hashMap, "an", zznx.zzjL());
            zza(hashMap, "aid", zznx.zzsK());
            zza(hashMap, "aiid", zznx.zzwi());
            zza(hashMap, "av", zznx.zzjN());
        }
        return hashMap;
    }

    private static String zzh(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        } else if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return zza(d.doubleValue());
            }
            return null;
        } else if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        } else {
            if (obj != Boolean.FALSE) {
                return "1";
            }
            return null;
        }
    }

    private static String zzz(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.zznu
    public void zzb(zzno zzno) {
        zzu.zzu(zzno);
        zzu.zzb(zzno.zzvU(), "Can't deliver not submitted measurement");
        zzu.zzbZ("deliver should be called on worker thread");
        zzno zzvP = zzno.zzvP();
        zzip zzip = (zzip) zzvP.zze(zzip.class);
        if (TextUtils.isEmpty(zzip.zzhw())) {
            zzhQ().zzg(zzc(zzvP), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzip.getClientId())) {
            zzhQ().zzg(zzc(zzvP), "Ignoring measurement without client id");
        } else if (!this.zzIa.zzie().getAppOptOut()) {
            double zzhB = zzip.zzhB();
            if (zzam.zza(zzhB, zzip.getClientId())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzhB));
                return;
            }
            Map<String, String> zzc = zzc(zzvP);
            zzc.put("v", "1");
            zzc.put("_v", zze.zzJB);
            zzc.put("tid", this.zztd);
            if (this.zzIa.zzie().isDryRunEnabled()) {
                zzc("Dry run is enabled. GoogleAnalytics would have sent", zzz(zzc));
                return;
            }
            HashMap hashMap = new HashMap();
            zzam.zzb(hashMap, "uid", zzip.getUserId());
            zznx zznx = (zznx) zzno.zzd(zznx.class);
            if (zznx != null) {
                zzam.zzb(hashMap, "an", zznx.zzjL());
                zzam.zzb(hashMap, "aid", zznx.zzsK());
                zzam.zzb(hashMap, "av", zznx.zzjN());
                zzam.zzb(hashMap, "aiid", zznx.zzwi());
            }
            zzc.put("_s", String.valueOf(zzhl().zza(new zzh(0, zzip.getClientId(), this.zztd, !TextUtils.isEmpty(zzip.zzhx()), 0, hashMap))));
            zzhl().zza(new zzab(zzhQ(), zzc, zzno.zzvS(), true));
        }
    }

    @Override // com.google.android.gms.internal.zznu
    public Uri zzhe() {
        return this.zzIl;
    }
}
