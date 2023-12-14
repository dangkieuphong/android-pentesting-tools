package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public class zzay extends zzak {
    private static final String ID = zzad.JOINER.toString();
    private static final String zzaLE = zzae.ARG0.toString();
    private static final String zzaLW = zzae.ITEM_SEPARATOR.toString();
    private static final String zzaLX = zzae.KEY_VALUE_SEPARATOR.toString();
    private static final String zzaLY = zzae.ESCAPE.toString();

    /* access modifiers changed from: private */
    public enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzay() {
        super(ID, zzaLE);
    }

    private String zza(String str, zza zza2, Set<Character> set) {
        switch (zza2) {
            case URL:
                try {
                    return zzdj.zzeQ(str);
                } catch (UnsupportedEncodingException e) {
                    zzbg.zzb("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                for (Character ch : set) {
                    String ch2 = ch.toString();
                    replace = replace.replace(ch2, "\\" + ch2);
                }
                return replace;
            default:
                return str;
        }
    }

    private void zza(StringBuilder sb, String str, zza zza2, Set<Character> set) {
        sb.append(zza(str, zza2, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        HashSet hashSet;
        zza zza2;
        zzag.zza zza3 = map.get(zzaLE);
        if (zza3 == null) {
            return zzdf.zzzQ();
        }
        zzag.zza zza4 = map.get(zzaLW);
        String zzg = zza4 != null ? zzdf.zzg(zza4) : "";
        zzag.zza zza5 = map.get(zzaLX);
        String zzg2 = zza5 != null ? zzdf.zzg(zza5) : "=";
        zza zza6 = zza.NONE;
        zzag.zza zza7 = map.get(zzaLY);
        if (zza7 != null) {
            String zzg3 = zzdf.zzg(zza7);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(zzg3)) {
                zza2 = zza.URL;
                hashSet = null;
            } else if ("backslash".equals(zzg3)) {
                zza2 = zza.BACKSLASH;
                hashSet = new HashSet();
                zza(hashSet, zzg);
                zza(hashSet, zzg2);
                hashSet.remove('\\');
            } else {
                zzbg.zzaz("Joiner: unsupported escape type: " + zzg3);
                return zzdf.zzzQ();
            }
        } else {
            hashSet = null;
            zza2 = zza6;
        }
        StringBuilder sb = new StringBuilder();
        switch (zza3.type) {
            case 2:
                boolean z = true;
                zzag.zza[] zzaArr = zza3.zziS;
                int length = zzaArr.length;
                int i = 0;
                while (i < length) {
                    zzag.zza zza8 = zzaArr[i];
                    if (!z) {
                        sb.append(zzg);
                    }
                    zza(sb, zzdf.zzg(zza8), zza2, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zza3.zziT.length; i2++) {
                    if (i2 > 0) {
                        sb.append(zzg);
                    }
                    String zzg4 = zzdf.zzg(zza3.zziT[i2]);
                    String zzg5 = zzdf.zzg(zza3.zziU[i2]);
                    zza(sb, zzg4, zza2, hashSet);
                    sb.append(zzg2);
                    zza(sb, zzg5, zza2, hashSet);
                }
                break;
            default:
                zza(sb, zzdf.zzg(zza3), zza2, hashSet);
                break;
        }
        return zzdf.zzI(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
