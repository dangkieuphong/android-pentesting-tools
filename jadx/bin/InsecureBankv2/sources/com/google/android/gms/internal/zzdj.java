package com.google.android.gms.internal;

import java.util.Map;

@zzgd
public class zzdj implements zzdg {
    private final zzdk zzwu;

    public zzdj(zzdk zzdk) {
        this.zzwu = zzdk;
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        this.zzwu.zzd("1".equals(map.get("transparentBackground")));
    }
}
