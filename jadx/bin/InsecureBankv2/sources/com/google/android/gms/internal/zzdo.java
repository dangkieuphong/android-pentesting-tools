package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzgd
public final class zzdo implements zzdg {
    private final Map<zzid, Integer> zzwA = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return zzk.zzcA().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzb.zzaC("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    @Override // com.google.android.gms.internal.zzdg
    public void zza(zzid zzid, Map<String, String> map) {
        zzh zzeq;
        String str = map.get("action");
        if (str == null) {
            zzb.zzaC("Action missing from video GMSG.");
            return;
        }
        if (zzb.zzL(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzb.zzay("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzb.zzaC("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzc zzgD = zzid.zzgD();
                if (zzgD == null || (zzeq = zzgD.zzeq()) == null) {
                    this.zzwA.put(zzid, Integer.valueOf(parseColor));
                } else {
                    zzeq.setBackgroundColor(parseColor);
                }
            } catch (IllegalArgumentException e) {
                zzb.zzaC("Invalid color parameter in video GMSG.");
            }
        } else {
            zzc zzgD2 = zzid.zzgD();
            if (zzgD2 == null) {
                zzb.zzaC("Could not get ad overlay for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzid.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                if (!equals || zzgD2.zzeq() != null) {
                    zzgD2.zzd(zza, zza2, zza3, zza4);
                    return;
                }
                zzgD2.zze(zza, zza2, zza3, zza4);
                if (this.zzwA.containsKey(zzid)) {
                    zzgD2.zzeq().setBackgroundColor(this.zzwA.get(zzid).intValue());
                    return;
                }
                return;
            }
            zzh zzeq2 = zzgD2.zzeq();
            if (zzeq2 == null) {
                zzh.zzd(zzid);
            } else if ("click".equals(str)) {
                Context context2 = zzid.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzeq2.zzc(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str3 = map.get("time");
                if (str3 == null) {
                    zzb.zzaC("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzeq2.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e2) {
                    zzb.zzaC("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equals(str)) {
                zzeq2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzeq2.zzeH();
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean(map.get("muted"))) {
                    zzeq2.zzeI();
                } else {
                    zzeq2.zzeJ();
                }
            } else if ("pause".equals(str)) {
                zzeq2.pause();
            } else if ("play".equals(str)) {
                zzeq2.play();
            } else if ("show".equals(str)) {
                zzeq2.setVisibility(0);
            } else if ("src".equals(str)) {
                zzeq2.zzah(map.get("src"));
            } else if (MediaRouteProviderProtocol.CLIENT_DATA_VOLUME.equals(str)) {
                String str4 = map.get(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
                if (str4 == null) {
                    zzb.zzaC("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzeq2.zza(Float.parseFloat(str4));
                } catch (NumberFormatException e3) {
                    zzb.zzaC("Could not parse volume parameter from volume video GMSG: " + str4);
                }
            } else if ("watermark".equals(str)) {
                zzeq2.zzeK();
            } else {
                zzb.zzaC("Unknown video action: " + str);
            }
        }
    }
}
