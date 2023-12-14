package com.google.android.gms.internal;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzpz {
    static zzag.zza zza(int i, JSONArray jSONArray, zzag.zza[] zzaArr, Set<Integer> set) throws zzqf.zzg, JSONException {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzeT("Value cycle detected. Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        Object zza = zza(jSONArray, i, "values");
        if (zzaArr[i] != null) {
            return zzaArr[i];
        }
        set.add(Integer.valueOf(i));
        zzag.zza zza2 = new zzag.zza();
        if (zza instanceof JSONArray) {
            JSONArray jSONArray2 = (JSONArray) zza;
            zza2.type = 2;
            zza2.zzjb = true;
            zza2.zziS = new zzag.zza[jSONArray2.length()];
            while (i2 < zza2.zziS.length) {
                zza2.zziS[i2] = zza(jSONArray2.getInt(i2), jSONArray, zzaArr, set);
                i2++;
            }
        } else if (zza instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) zza;
            JSONArray optJSONArray = jSONObject.optJSONArray("escaping");
            if (optJSONArray != null) {
                zza2.zzja = new int[optJSONArray.length()];
                for (int i3 = 0; i3 < zza2.zzja.length; i3++) {
                    zza2.zzja[i3] = optJSONArray.getInt(i3);
                }
            }
            if (jSONObject.has("function_id")) {
                zza2.type = 5;
                zza2.zziW = jSONObject.getString("function_id");
            } else if (jSONObject.has("macro_reference")) {
                zza2.type = 4;
                zza2.zzjb = true;
                zza2.zziV = zzdf.zzg(zza(jSONObject.getInt("macro_reference"), jSONArray, zzaArr, set));
            } else if (jSONObject.has("template_token")) {
                zza2.type = 7;
                zza2.zzjb = true;
                JSONArray jSONArray3 = jSONObject.getJSONArray("template_token");
                zza2.zziZ = new zzag.zza[jSONArray3.length()];
                while (i2 < zza2.zziZ.length) {
                    zza2.zziZ[i2] = zza(jSONArray3.getInt(i2), jSONArray, zzaArr, set);
                    i2++;
                }
            } else {
                zza2.type = 3;
                zza2.zzjb = true;
                int length = jSONObject.length();
                zza2.zziT = new zzag.zza[length];
                zza2.zziU = new zzag.zza[length];
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    zza2.zziT[i2] = zza(new Integer(next).intValue(), jSONArray, zzaArr, set);
                    zza2.zziU[i2] = zza(jSONObject.getInt(next), jSONArray, zzaArr, set);
                    i2++;
                }
            }
        } else if (zza instanceof String) {
            zza2.zziR = (String) zza;
            zza2.type = 1;
        } else if (zza instanceof Boolean) {
            zza2.zziY = ((Boolean) zza).booleanValue();
            zza2.type = 8;
        } else if (zza instanceof Integer) {
            zza2.zziX = (long) ((Integer) zza).intValue();
            zza2.type = 6;
        } else {
            zzeT("Invalid value type: " + zza);
        }
        zzaArr[i] = zza2;
        set.remove(Integer.valueOf(i));
        return zza2;
    }

    static zzqf.zza zza(JSONObject jSONObject, JSONArray jSONArray, JSONArray jSONArray2, zzag.zza[] zzaArr, int i) throws zzqf.zzg, JSONException {
        zzqf.zzb zzAm = zzqf.zza.zzAm();
        JSONArray jSONArray3 = jSONObject.getJSONArray("property");
        for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) zza(jSONArray, jSONArray3.getInt(i2), "properties");
            String str = (String) zza(jSONArray2, jSONObject2.getInt("key"), "key");
            zzag.zza zza = (zzag.zza) zza(zzaArr, jSONObject2.getInt("value"), "value");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzAm.zzq(zza);
            } else {
                zzAm.zzb(str, zza);
            }
        }
        return zzAm.zzAo();
    }

    static zzqf.zze zza(JSONObject jSONObject, List<zzqf.zza> list, List<zzqf.zza> list2, List<zzqf.zza> list3, zzag.zza[] zzaArr) throws JSONException {
        zzqf.zzf zzAt = zzqf.zze.zzAt();
        JSONArray optJSONArray = jSONObject.optJSONArray("positive_predicate");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("negative_predicate");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("add_tag");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("remove_tag");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("add_tag_rule_name");
        JSONArray optJSONArray6 = jSONObject.optJSONArray("remove_tag_rule_name");
        JSONArray optJSONArray7 = jSONObject.optJSONArray("add_macro");
        JSONArray optJSONArray8 = jSONObject.optJSONArray("remove_macro");
        JSONArray optJSONArray9 = jSONObject.optJSONArray("add_macro_rule_name");
        JSONArray optJSONArray10 = jSONObject.optJSONArray("remove_macro_rule_name");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                zzAt.zzd(list3.get(optJSONArray.getInt(i)));
            }
        }
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                zzAt.zze(list3.get(optJSONArray2.getInt(i2)));
            }
        }
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                zzAt.zzf(list.get(optJSONArray3.getInt(i3)));
            }
        }
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                zzAt.zzg(list.get(optJSONArray4.getInt(i4)));
            }
        }
        if (optJSONArray5 != null) {
            for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                zzAt.zzeW(zzaArr[optJSONArray5.getInt(i5)].zziR);
            }
        }
        if (optJSONArray6 != null) {
            for (int i6 = 0; i6 < optJSONArray6.length(); i6++) {
                zzAt.zzeX(zzaArr[optJSONArray6.getInt(i6)].zziR);
            }
        }
        if (optJSONArray7 != null) {
            for (int i7 = 0; i7 < optJSONArray7.length(); i7++) {
                zzAt.zzh(list2.get(optJSONArray7.getInt(i7)));
            }
        }
        if (optJSONArray8 != null) {
            for (int i8 = 0; i8 < optJSONArray8.length(); i8++) {
                zzAt.zzi(list2.get(optJSONArray8.getInt(i8)));
            }
        }
        if (optJSONArray9 != null) {
            for (int i9 = 0; i9 < optJSONArray9.length(); i9++) {
                zzAt.zzeY(zzaArr[optJSONArray9.getInt(i9)].zziR);
            }
        }
        if (optJSONArray10 != null) {
            for (int i10 = 0; i10 < optJSONArray10.length(); i10++) {
                zzAt.zzeZ(zzaArr[optJSONArray10.getInt(i10)].zziR);
            }
        }
        return zzAt.zzAE();
    }

    private static <T> T zza(JSONArray jSONArray, int i, String str) throws zzqf.zzg {
        if (i >= 0 && i < jSONArray.length()) {
            try {
                return (T) jSONArray.get(i);
            } catch (JSONException e) {
            }
        }
        zzeT("Index out of bounds detected: " + i + " in " + str);
        return null;
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzqf.zzg {
        if (i < 0 || i >= tArr.length) {
            zzeT("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    static List<zzqf.zza> zza(JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, zzag.zza[] zzaArr) throws JSONException, zzqf.zzg {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(zza(jSONArray.getJSONObject(i), jSONArray2, jSONArray3, zzaArr, i));
        }
        return arrayList;
    }

    private static void zzeT(String str) throws zzqf.zzg {
        zzbg.zzaz(str);
        throw new zzqf.zzg(str);
    }

    static zzqf.zzc zzey(String str) throws JSONException, zzqf.zzg {
        JSONObject jSONObject = new JSONObject(str);
        Object obj = jSONObject.get("resource");
        if (obj instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) obj;
            zzqf.zzd zzAp = zzqf.zzc.zzAp();
            zzag.zza[] zzj = zzj(jSONObject2);
            JSONArray jSONArray = jSONObject2.getJSONArray("properties");
            JSONArray jSONArray2 = jSONObject2.getJSONArray("key");
            List<zzqf.zza> zza = zza(jSONObject2.getJSONArray("tags"), jSONArray, jSONArray2, zzj);
            List<zzqf.zza> zza2 = zza(jSONObject2.getJSONArray("predicates"), jSONArray, jSONArray2, zzj);
            List<zzqf.zza> zza3 = zza(jSONObject2.getJSONArray("macros"), jSONArray, jSONArray2, zzj);
            for (zzqf.zza zza4 : zza3) {
                zzAp.zzc(zza4);
            }
            JSONArray jSONArray3 = jSONObject2.getJSONArray("rules");
            for (int i = 0; i < jSONArray3.length(); i++) {
                zzAp.zzb(zza(jSONArray3.getJSONObject(i), zza, zza3, zza2, zzj));
            }
            zzAp.zzeV("1");
            zzAp.zzjb(1);
            if (jSONObject.optJSONArray("runtime") != null) {
            }
            return zzAp.zzAs();
        }
        throw new zzqf.zzg("Resource map not found");
    }

    static zzag.zza[] zzj(JSONObject jSONObject) throws JSONException, zzqf.zzg {
        Object opt = jSONObject.opt("values");
        if (opt instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) opt;
            zzag.zza[] zzaArr = new zzag.zza[jSONArray.length()];
            for (int i = 0; i < zzaArr.length; i++) {
                zza(i, jSONArray, zzaArr, new HashSet(0));
            }
            return zzaArr;
        }
        throw new zzqf.zzg("Missing Values list");
    }
}
