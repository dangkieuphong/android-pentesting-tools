package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdt;
import java.util.Map;
import java.util.concurrent.Future;

@zzgd
public final class zzgh {
    private String zzDK;
    private String zzDL;
    private zzhs<zzgj> zzDM = new zzhs<>();
    zzdt.zzd zzDN;
    public final zzdg zzDO = new zzdg() {
        /* class com.google.android.gms.internal.zzgh.AnonymousClass1 */

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            synchronized (zzgh.this.zzqt) {
                if (!zzgh.this.zzDM.isDone()) {
                    if (zzgh.this.zzDK.equals(map.get("request_id"))) {
                        zzgj zzgj = new zzgj(1, map);
                        zzb.zzaC("Invalid " + zzgj.getType() + " request error: " + zzgj.zzfG());
                        zzgh.this.zzDM.zzf(zzgj);
                    }
                }
            }
        }
    };
    public final zzdg zzDP = new zzdg() {
        /* class com.google.android.gms.internal.zzgh.AnonymousClass2 */

        @Override // com.google.android.gms.internal.zzdg
        public void zza(zzid zzid, Map<String, String> map) {
            synchronized (zzgh.this.zzqt) {
                if (!zzgh.this.zzDM.isDone()) {
                    zzgj zzgj = new zzgj(-2, map);
                    if (!zzgh.this.zzDK.equals(zzgj.getRequestId())) {
                        zzb.zzaC(zzgj.getRequestId() + " ==== " + zzgh.this.zzDK);
                        return;
                    }
                    String url = zzgj.getUrl();
                    if (url == null) {
                        zzb.zzaC("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzhg.zza(zzid.getContext(), map.get("check_adapters"), zzgh.this.zzDL));
                        zzgj.setUrl(replaceAll);
                        zzb.zzaB("Ad request URL modified to " + replaceAll);
                    }
                    zzgh.this.zzDM.zzf(zzgj);
                }
            }
        }
    };
    zzid zzoA;
    private final Object zzqt = new Object();

    public zzgh(String str, String str2) {
        this.zzDL = str2;
        this.zzDK = str;
    }

    public void zzb(zzdt.zzd zzd) {
        this.zzDN = zzd;
    }

    public void zze(zzid zzid) {
        this.zzoA = zzid;
    }

    public zzdt.zzd zzfD() {
        return this.zzDN;
    }

    public Future<zzgj> zzfE() {
        return this.zzDM;
    }

    public void zzfF() {
        if (this.zzoA != null) {
            this.zzoA.destroy();
            this.zzoA = null;
        }
    }
}
