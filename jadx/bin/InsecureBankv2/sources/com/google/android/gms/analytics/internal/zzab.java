package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzab {
    private final List<Command> zzLZ;
    private final long zzMa;
    private final long zzMb;
    private final int zzMc;
    private final boolean zzMd;
    private final String zzMe;
    private final Map<String, String> zzyn;

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z) {
        this(zzc, map, j, z, 0, 0, null);
    }

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzc, map, j, z, j2, i, null);
    }

    public zzab(zzc zzc, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String zza;
        String zza2;
        zzu.zzu(zzc);
        zzu.zzu(map);
        this.zzMb = j;
        this.zzMd = z;
        this.zzMa = j2;
        this.zzMc = i;
        this.zzLZ = list != null ? list : Collections.EMPTY_LIST;
        this.zzMe = zze(list);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (zzj(entry.getKey()) && (zza2 = zza(zzc, entry.getKey())) != null) {
                hashMap.put(zza2, zzb(zzc, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey()) && (zza = zza(zzc, entry2.getKey())) != null) {
                hashMap.put(zza, zzb(zzc, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.zzMe)) {
            zzam.zzb(hashMap, "_v", this.zzMe);
            if (this.zzMe.equals("ma4.0.0") || this.zzMe.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzyn = Collections.unmodifiableMap(hashMap);
    }

    public static zzab zza(zzc zzc, zzab zzab, Map<String, String> map) {
        return new zzab(zzc, map, zzab.zzjW(), zzab.zzjY(), zzab.zzjV(), zzab.zzjU(), zzab.zzjX());
    }

    private static String zza(zzc zzc, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzc zzc, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zze(java.util.List<com.google.android.gms.analytics.internal.Command> r5) {
        /*
            r1 = 0
            if (r5 == 0) goto L_0x002c
            java.util.Iterator r2 = r5.iterator()
        L_0x0007:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002c
            java.lang.Object r0 = r2.next()
            com.google.android.gms.analytics.internal.Command r0 = (com.google.android.gms.analytics.internal.Command) r0
            java.lang.String r3 = "appendVersion"
            java.lang.String r4 = r0.getId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0007
            java.lang.String r0 = r0.getValue()
        L_0x0023:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x002a
        L_0x0029:
            return r1
        L_0x002a:
            r1 = r0
            goto L_0x0029
        L_0x002c:
            r0 = r1
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzab.zze(java.util.List):java.lang.String");
    }

    private static boolean zzj(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private String zzn(String str, String str2) {
        zzu.zzcj(str);
        zzu.zzb(!str.startsWith("&"), "Short param name required");
        String str3 = this.zzyn.get(str);
        return str3 != null ? str3 : str2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzMb);
        if (this.zzMa != 0) {
            stringBuffer.append(", dbId=").append(this.zzMa);
        }
        if (((long) this.zzMc) != 0) {
            stringBuffer.append(", appUID=").append(this.zzMc);
        }
        ArrayList<String> arrayList = new ArrayList(this.zzyn.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.zzyn.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzjU() {
        return this.zzMc;
    }

    public long zzjV() {
        return this.zzMa;
    }

    public long zzjW() {
        return this.zzMb;
    }

    public List<Command> zzjX() {
        return this.zzLZ;
    }

    public boolean zzjY() {
        return this.zzMd;
    }

    public long zzjZ() {
        return zzam.zzbj(zzn("_s", "0"));
    }

    public String zzka() {
        return zzn("_m", "");
    }

    public Map<String, String> zzn() {
        return this.zzyn;
    }
}
