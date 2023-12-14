package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* access modifiers changed from: package-private */
public class zzce extends zzak {
    private static final String ID = zzad.REGEX_GROUP.toString();
    private static final String zzaMO = zzae.ARG0.toString();
    private static final String zzaMP = zzae.ARG1.toString();
    private static final String zzaMQ = zzae.IGNORE_CASE.toString();
    private static final String zzaMR = zzae.GROUP.toString();

    public zzce() {
        super(ID, zzaMO, zzaMP);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        int i;
        zzag.zza zza = map.get(zzaMO);
        zzag.zza zza2 = map.get(zzaMP);
        if (zza == null || zza == zzdf.zzzQ() || zza2 == null || zza2 == zzdf.zzzQ()) {
            return zzdf.zzzQ();
        }
        int i2 = 64;
        if (zzdf.zzk(map.get(zzaMQ)).booleanValue()) {
            i2 = 66;
        }
        zzag.zza zza3 = map.get(zzaMR);
        if (zza3 != null) {
            Long zzi = zzdf.zzi(zza3);
            if (zzi == zzdf.zzzL()) {
                return zzdf.zzzQ();
            }
            i = zzi.intValue();
            if (i < 0) {
                return zzdf.zzzQ();
            }
        } else {
            i = 1;
        }
        try {
            String zzg = zzdf.zzg(zza);
            String str = null;
            Matcher matcher = Pattern.compile(zzdf.zzg(zza2), i2).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? zzdf.zzzQ() : zzdf.zzI(str);
        } catch (PatternSyntaxException e) {
            return zzdf.zzzQ();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
