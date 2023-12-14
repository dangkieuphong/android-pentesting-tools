package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzdl implements zzdg {
    final HashMap<String, zzhs<JSONObject>> zzwv = new HashMap<>();

    public Future<JSONObject> zzU(String str) {
        zzhs<JSONObject> zzhs = new zzhs<>();
        this.zzwv.put(str, zzhs);
        return zzhs;
    }

    public void zzV(String str) {
        zzhs<JSONObject> zzhs = this.zzwv.get(str);
        if (zzhs == null) {
            zzb.zzaz("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzhs.isDone()) {
            zzhs.cancel(true);
        }
        this.zzwv.remove(str);
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        zze(map.get("request_id"), map.get("fetched_ad"));
    }

    public void zze(String str, String str2) {
        zzb.zzay("Received ad from the cache.");
        zzhs<JSONObject> zzhs = this.zzwv.get(str);
        if (zzhs == null) {
            zzb.zzaz("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            zzhs.zzf(new JSONObject(str2));
        } catch (JSONException e) {
            zzb.zzb("Failed constructing JSON object from value passed from javascript", e);
            zzhs.zzf(null);
        } finally {
            this.zzwv.remove(str);
        }
    }
}
