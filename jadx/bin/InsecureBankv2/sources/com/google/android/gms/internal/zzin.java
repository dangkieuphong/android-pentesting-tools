package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzin extends zznq<zzin> {
    private Map<Integer, Double> zzJb = new HashMap(4);

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.zzJb.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return zzy(hashMap);
    }

    public void zza(zzin zzin) {
        zzin.zzJb.putAll(this.zzJb);
    }

    public Map<Integer, Double> zzhu() {
        return Collections.unmodifiableMap(this.zzJb);
    }
}
