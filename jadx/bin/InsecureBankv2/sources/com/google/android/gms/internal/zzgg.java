package com.google.android.gms.internal;

import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public final class zzgg {
    private static final SimpleDateFormat zzDJ = new SimpleDateFormat("yyyyMMdd");

    private static String zzG(int i) {
        return String.format(Locale.US, "#%06x", Integer.valueOf(16777215 & i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r32, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r33, java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 465
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgg.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, zzgk zzgk, Location location, zzbr zzbr, String str, String str2, List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzCl != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzCl);
            }
            zza(hashMap, adRequestInfoParcel.zzCm);
            hashMap.put("format", adRequestInfoParcel.zzpN.zzsm);
            if (adRequestInfoParcel.zzpN.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzpN.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzpN.zzso != null) {
                StringBuilder sb = new StringBuilder();
                AdSizeParcel[] adSizeParcelArr = adRequestInfoParcel.zzpN.zzso;
                for (AdSizeParcel adSizeParcel : adSizeParcelArr) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / zzgk.zzCy) : adSizeParcel.width);
                    sb.append("x");
                    sb.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / zzgk.zzCy) : adSizeParcel.height);
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.zzCs != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzCs));
                hashMap.put("native_templates", adRequestInfoParcel.zzqd);
                hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzqb));
                if (!adRequestInfoParcel.zzCG.isEmpty()) {
                    hashMap.put("native_custom_templates", adRequestInfoParcel.zzCG);
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzpG);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzCn != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzCn.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.zzCp);
            hashMap.put("session_id", adRequestInfoParcel.zzCq);
            hashMap.put("js", adRequestInfoParcel.zzpJ.zzGG);
            zza(hashMap, zzgk);
            hashMap.put("fdz", new Integer(zzbr.zzcX()));
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzCm.versionCode >= 2 && adRequestInfoParcel.zzCm.zzsf != null) {
                zza(hashMap, adRequestInfoParcel.zzCm.zzsf);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzCr);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzCu) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzCu));
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzCt != null) {
                hashMap.put("content_info", adRequestInfoParcel.zzCt);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzCy));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzCx));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzCw));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzgk.zzCy));
                hashMap.put("sh", Integer.valueOf(zzgk.zzCx));
                hashMap.put("sw", Integer.valueOf(zzgk.zzCw));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzCz)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzCz));
                    } catch (JSONException e) {
                        zzb.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                if (zzbz.zzun.get().booleanValue() && adRequestInfoParcel.zzCA) {
                    hashMap.put("ga_hid", Integer.valueOf(adRequestInfoParcel.zzCB));
                    hashMap.put("ga_cid", adRequestInfoParcel.zzCC);
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzCD));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzCE);
            }
            zza(hashMap, str);
            if (zzb.zzL(2)) {
                zzb.zzaB("Ad Request JSON: " + zzo.zzbv().zzy(hashMap).toString(2));
            }
            return zzo.zzbv().zzy(hashMap);
        } catch (JSONException e2) {
            zzb.zzaC("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzgh = zzhg.zzgh();
        if (zzgh != null) {
            hashMap.put("abf", zzgh);
        }
        if (adRequestParcel.zzrX != -1) {
            hashMap.put("cust_age", zzDJ.format(new Date(adRequestParcel.zzrX)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzrY != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zzrY));
        }
        if (adRequestParcel.zzrZ != null) {
            hashMap.put("kw", adRequestParcel.zzrZ);
        }
        if (adRequestParcel.zzsb != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzsb));
        }
        if (adRequestParcel.zzsa) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzsc) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzsd)) {
                hashMap.put("ppid", adRequestParcel.zzsd);
            }
            if (adRequestParcel.zzse != null) {
                zza(hashMap, adRequestParcel.zzse);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzsg != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, adRequestParcel.zzsg);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzsi != null) {
                hashMap.put("custom_targeting", adRequestParcel.zzsi);
            }
            if (adRequestParcel.zzsj != null) {
                hashMap.put("category_exclusions", adRequestParcel.zzsj);
            }
            if (adRequestParcel.zzsk != null) {
                hashMap.put("request_agent", adRequestParcel.zzsk);
            }
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zzth) != 0) {
            hashMap.put("acolor", zzG(searchAdRequestParcel.zzth));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzG(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzti) == 0 || Color.alpha(searchAdRequestParcel.zztj) == 0)) {
            hashMap.put("gradientto", zzG(searchAdRequestParcel.zzti));
            hashMap.put("gradientfrom", zzG(searchAdRequestParcel.zztj));
        }
        if (Color.alpha(searchAdRequestParcel.zztk) != 0) {
            hashMap.put("bcolor", zzG(searchAdRequestParcel.zztk));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zztl));
        switch (searchAdRequestParcel.zztm) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (searchAdRequestParcel.zztn) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zzto != null) {
            hashMap.put("channel", searchAdRequestParcel.zzto);
        }
        if (Color.alpha(searchAdRequestParcel.zztp) != 0) {
            hashMap.put("dcolor", zzG(searchAdRequestParcel.zztp));
        }
        if (searchAdRequestParcel.zztq != null) {
            hashMap.put("font", searchAdRequestParcel.zztq);
        }
        if (Color.alpha(searchAdRequestParcel.zztr) != 0) {
            hashMap.put("hcolor", zzG(searchAdRequestParcel.zztr));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzts));
        if (searchAdRequestParcel.zztt != null) {
            hashMap.put("q", searchAdRequestParcel.zztt);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzgk zzgk) {
        hashMap.put("am", Integer.valueOf(zzgk.zzEn));
        hashMap.put("cog", zzx(zzgk.zzEo));
        hashMap.put("coh", zzx(zzgk.zzEp));
        if (!TextUtils.isEmpty(zzgk.zzEq)) {
            hashMap.put("carrier", zzgk.zzEq);
        }
        hashMap.put("gl", zzgk.zzEr);
        if (zzgk.zzEs) {
            hashMap.put("simulator", 1);
        }
        hashMap.put("ma", zzx(zzgk.zzEt));
        hashMap.put("sp", zzx(zzgk.zzEu));
        hashMap.put("hl", zzgk.zzEv);
        if (!TextUtils.isEmpty(zzgk.zzEw)) {
            hashMap.put("mv", zzgk.zzEw);
        }
        hashMap.put("muv", Integer.valueOf(zzgk.zzEx));
        if (zzgk.zzEy != -2) {
            hashMap.put("cnt", Integer.valueOf(zzgk.zzEy));
        }
        hashMap.put("gnt", Integer.valueOf(zzgk.zzEz));
        hashMap.put("pt", Integer.valueOf(zzgk.zzEA));
        hashMap.put("rm", Integer.valueOf(zzgk.zzEB));
        hashMap.put("riv", Integer.valueOf(zzgk.zzEC));
        Bundle bundle = new Bundle();
        bundle.putInt("active_network_state", zzgk.zzEG);
        bundle.putBoolean("active_network_metered", zzgk.zzEF);
        hashMap.put("connectivity", bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", zzgk.zzEE);
        bundle2.putDouble("battery_level", zzgk.zzED);
        hashMap.put("battery", bundle2);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("token", str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzvD : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    private static Integer zzx(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
