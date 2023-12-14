package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

public final class zzof extends zznq<zzof> {
    public String mCategory;
    public String zzaEH;
    public String zzaET;
    public long zzaEU;

    public String getLabel() {
        return this.zzaEH;
    }

    public long getTimeInMillis() {
        return this.zzaEU;
    }

    public void setTimeInMillis(long milliseconds) {
        this.zzaEU = milliseconds;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.zzaET);
        hashMap.put("timeInMillis", Long.valueOf(this.zzaEU));
        hashMap.put("category", this.mCategory);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaEH);
        return zzy(hashMap);
    }

    public void zza(zzof zzof) {
        if (!TextUtils.isEmpty(this.zzaET)) {
            zzof.zzdN(this.zzaET);
        }
        if (this.zzaEU != 0) {
            zzof.setTimeInMillis(this.zzaEU);
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            zzof.zzdG(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzaEH)) {
            zzof.zzdI(this.zzaEH);
        }
    }

    public void zzdG(String str) {
        this.mCategory = str;
    }

    public void zzdI(String str) {
        this.zzaEH = str;
    }

    public void zzdN(String str) {
        this.zzaET = str;
    }

    public String zzwJ() {
        return this.zzaET;
    }

    public String zzwy() {
        return this.mCategory;
    }
}
