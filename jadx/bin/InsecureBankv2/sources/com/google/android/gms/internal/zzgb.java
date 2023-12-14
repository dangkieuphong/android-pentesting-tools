package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzgb implements zzfy.zza<zzf> {
    private final boolean zzBY;

    public zzgb(boolean z) {
        this.zzBY = z;
    }

    private void zza(zzfy zzfy, JSONObject jSONObject, zzkw<String, Future<zzc>> zzkw) throws JSONException {
        zzkw.put(jSONObject.getString("name"), zzfy.zza(jSONObject, "image_value", this.zzBY));
    }

    private void zza(JSONObject jSONObject, zzkw<String, String> zzkw) throws JSONException {
        zzkw.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    private <K, V> zzkw<K, V> zzc(zzkw<K, Future<V>> zzkw) throws InterruptedException, ExecutionException {
        zzkw<K, V> zzkw2 = new zzkw<>();
        for (int i = 0; i < zzkw.size(); i++) {
            zzkw2.put(zzkw.keyAt(i), zzkw.valueAt(i).get());
        }
        return zzkw2;
    }

    /* renamed from: zzd */
    public zzf zza(zzfy zzfy, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        zzkw<String, Future<zzc>> zzkw = new zzkw<>();
        zzkw<String, String> zzkw2 = new zzkw<>();
        zzhv<zza> zze = zzfy.zze(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                zza(jSONObject2, zzkw2);
            } else if ("image".equals(string)) {
                zza(zzfy, jSONObject2, zzkw);
            } else {
                zzb.zzaC("Unknown custom asset type: " + string);
            }
        }
        return new zzf(jSONObject.getString("custom_template_id"), zzc(zzkw), zzkw2, (zza) zze.get());
    }
}
