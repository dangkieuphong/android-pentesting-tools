package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import java.util.Map;

public class zzaf extends zzd {
    private static String zzMl = "3";
    private static String zzMm = "01VDIWEA?";
    private static zzaf zzMn;

    public zzaf(zzf zzf) {
        super(zzf);
    }

    public static zzaf zzkc() {
        return zzMn;
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = zzy.zzLb.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzab zzab, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        zzd("Discarding hit. " + str, zzab != null ? zzab.toString() : "no hit data");
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            zzu.zzu(str);
            if (i >= 0) {
                i2 = i;
            }
            String str2 = zzMl + zzMm.charAt(i2 >= zzMm.length() ? zzMm.length() - 1 : i2) + (zzhR().zziX() ? zzhR().zziW() ? 'P' : 'C' : zzhR().zziW() ? 'p' : 'c') + zze.VERSION + ":" + zzc(str, zzk(obj), zzk(obj2), zzk(obj3));
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            zzai zzif = zzhM().zzif();
            if (zzif != null) {
                zzif.zzkp().zzbg(str2);
            }
        }
    }

    public void zzg(Map<String, String> map, String str) {
        String str2;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        zzd("Discarding hit. " + str, str2);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        synchronized (zzaf.class) {
            zzMn = this;
        }
    }

    /* access modifiers changed from: protected */
    public String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) l).longValue()) < 100) {
            return String.valueOf(l);
        }
        String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
        String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
        return str + Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))) + "..." + str + Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
    }
}
