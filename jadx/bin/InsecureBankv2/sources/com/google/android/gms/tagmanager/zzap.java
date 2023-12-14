package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zzap extends zzak {
    private static final String ID = zzad.HASH.toString();
    private static final String zzaLE = zzae.ARG0.toString();
    private static final String zzaLG = zzae.INPUT_FORMAT.toString();
    private static final String zzaLK = zzae.ALGORITHM.toString();

    public zzap() {
        super(ID, zzaLE);
    }

    private byte[] zzd(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        byte[] zzee;
        zzag.zza zza = map.get(zzaLE);
        if (zza == null || zza == zzdf.zzzQ()) {
            return zzdf.zzzQ();
        }
        String zzg = zzdf.zzg(zza);
        zzag.zza zza2 = map.get(zzaLK);
        String zzg2 = zza2 == null ? "MD5" : zzdf.zzg(zza2);
        zzag.zza zza3 = map.get(zzaLG);
        String zzg3 = zza3 == null ? "text" : zzdf.zzg(zza3);
        if ("text".equals(zzg3)) {
            zzee = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            zzee = zzk.zzee(zzg);
        } else {
            zzbg.zzaz("Hash: unknown input format: " + zzg3);
            return zzdf.zzzQ();
        }
        try {
            return zzdf.zzI(zzk.zzi(zzd(zzg2, zzee)));
        } catch (NoSuchAlgorithmException e) {
            zzbg.zzaz("Hash: unknown algorithm: " + zzg2);
            return zzdf.zzzQ();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
