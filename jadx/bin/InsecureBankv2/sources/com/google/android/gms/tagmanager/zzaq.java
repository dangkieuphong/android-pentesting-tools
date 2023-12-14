package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzaq {
    private final long zzMb;
    private final long zzaLL;
    private final long zzaLM;
    private String zzaLN;

    zzaq(long j, long j2, long j3) {
        this.zzaLL = j;
        this.zzMb = j2;
        this.zzaLM = j3;
    }

    /* access modifiers changed from: package-private */
    public void zzev(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzaLN = str;
        }
    }

    /* access modifiers changed from: package-private */
    public long zzyO() {
        return this.zzaLL;
    }

    /* access modifiers changed from: package-private */
    public long zzyP() {
        return this.zzaLM;
    }

    /* access modifiers changed from: package-private */
    public String zzyQ() {
        return this.zzaLN;
    }
}
