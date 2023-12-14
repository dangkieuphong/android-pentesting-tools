package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzoe extends zznq<zzoe> {
    public String zzaER;
    public String zzaES;
    public String zzuO;

    public String getAction() {
        return this.zzuO;
    }

    public String getTarget() {
        return this.zzaES;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.zzaER);
        hashMap.put("action", this.zzuO);
        hashMap.put("target", this.zzaES);
        return zzy(hashMap);
    }

    public void zza(zzoe zzoe) {
        if (!TextUtils.isEmpty(this.zzaER)) {
            zzoe.zzdL(this.zzaER);
        }
        if (!TextUtils.isEmpty(this.zzuO)) {
            zzoe.zzdH(this.zzuO);
        }
        if (!TextUtils.isEmpty(this.zzaES)) {
            zzoe.zzdM(this.zzaES);
        }
    }

    public void zzdH(String str) {
        this.zzuO = str;
    }

    public void zzdL(String str) {
        this.zzaER = str;
    }

    public void zzdM(String str) {
        this.zzaES = str;
    }

    public String zzwI() {
        return this.zzaER;
    }
}
