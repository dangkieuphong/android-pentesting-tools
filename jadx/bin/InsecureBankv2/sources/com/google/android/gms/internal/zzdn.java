package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@zzgd
public final class zzdn implements zzdg {
    private final zzd zzww;
    private final zzep zzwx;
    private final zzdi zzwz;

    public zzdn(zzdi zzdi, zzd zzd, zzep zzep) {
        this.zzwz = zzdi;
        this.zzww = zzd;
        this.zzwx = zzep;
    }

    private static boolean zzd(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zze(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgr();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgq();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzo.zzbx().zzgs();
            }
        }
        return -1;
    }

    private void zzm(boolean z) {
        if (this.zzwx != null) {
            this.zzwx.zzn(z);
        }
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        String str = map.get("a");
        if (str == null) {
            zzb.zzaC("Action missing from an open GMSG.");
        } else if (this.zzww == null || this.zzww.zzbd()) {
            zzie zzgF = zzid.zzgF();
            if ("expand".equalsIgnoreCase(str)) {
                if (zzid.zzgJ()) {
                    zzb.zzaC("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzm(false);
                zzgF.zza(zzd(map), zze(map));
            } else if ("webapp".equalsIgnoreCase(str)) {
                String str2 = map.get("u");
                zzm(false);
                if (str2 != null) {
                    zzgF.zza(zzd(map), zze(map), str2);
                } else {
                    zzgF.zza(zzd(map), zze(map), map.get("html"), map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str)) {
                String str3 = map.get("product_id");
                String str4 = map.get("report_urls");
                if (this.zzwz == null) {
                    return;
                }
                if (str4 == null || str4.isEmpty()) {
                    this.zzwz.zza(str3, new ArrayList<>());
                } else {
                    this.zzwz.zza(str3, new ArrayList<>(Arrays.asList(str4.split(" "))));
                }
            } else {
                zzm(true);
                zzid.zzgH();
                String str5 = map.get("u");
                zzgF.zza(new AdLauncherIntentInfoParcel(map.get("i"), !TextUtils.isEmpty(str5) ? zzo.zzbv().zza(zzid, str5) : str5, map.get("m"), map.get("p"), map.get("c"), map.get("f"), map.get("e")));
            }
        } else {
            this.zzww.zzo(map.get("u"));
        }
    }
}
