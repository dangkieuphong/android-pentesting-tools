package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzad extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzaLE = zzae.ARG0.toString();
    private static final String zzaLF = zzae.NO_PADDING.toString();
    private static final String zzaLG = zzae.INPUT_FORMAT.toString();
    private static final String zzaLH = zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(ID, zzaLE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        byte[] decode;
        String encodeToString;
        zzag.zza zza = map.get(zzaLE);
        if (zza == null || zza == zzdf.zzzQ()) {
            return zzdf.zzzQ();
        }
        String zzg = zzdf.zzg(zza);
        zzag.zza zza2 = map.get(zzaLG);
        String zzg2 = zza2 == null ? "text" : zzdf.zzg(zza2);
        zzag.zza zza3 = map.get(zzaLH);
        String zzg3 = zza3 == null ? "base16" : zzdf.zzg(zza3);
        zzag.zza zza4 = map.get(zzaLF);
        int i = (zza4 == null || !zzdf.zzk(zza4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(zzg2)) {
                decode = zzg.getBytes();
            } else if ("base16".equals(zzg2)) {
                decode = zzk.zzee(zzg);
            } else if ("base64".equals(zzg2)) {
                decode = Base64.decode(zzg, i);
            } else if ("base64url".equals(zzg2)) {
                decode = Base64.decode(zzg, i | 8);
            } else {
                zzbg.zzaz("Encode: unknown input format: " + zzg2);
                return zzdf.zzzQ();
            }
            if ("base16".equals(zzg3)) {
                encodeToString = zzk.zzi(decode);
            } else if ("base64".equals(zzg3)) {
                encodeToString = Base64.encodeToString(decode, i);
            } else if ("base64url".equals(zzg3)) {
                encodeToString = Base64.encodeToString(decode, i | 8);
            } else {
                zzbg.zzaz("Encode: unknown output format: " + zzg3);
                return zzdf.zzzQ();
            }
            return zzdf.zzI(encodeToString);
        } catch (IllegalArgumentException e) {
            zzbg.zzaz("Encode: invalid input:");
            return zzdf.zzzQ();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
