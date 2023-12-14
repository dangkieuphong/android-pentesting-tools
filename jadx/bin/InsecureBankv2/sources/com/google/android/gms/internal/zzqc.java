package com.google.android.gms.internal;

import com.google.android.gms.internal.zzqf;
import com.google.android.gms.tagmanager.zzbg;
import org.json.JSONException;

public final class zzqc {
    public static zzqb zzaPm = new zzqb() {
        /* class com.google.android.gms.internal.zzqc.AnonymousClass1 */

        @Override // com.google.android.gms.internal.zzqb
        public Object zzt(byte[] bArr) throws zzqf.zzg {
            if (bArr == null) {
                throw new zzqf.zzg("Cannot parse a null byte[]");
            } else if (bArr.length == 0) {
                throw new zzqf.zzg("Cannot parse a 0 length byte[]");
            } else {
                try {
                    zzqf.zzc zzey = zzpz.zzey(new String(bArr));
                    if (zzey != null) {
                        zzbg.zzaB("The container was successfully parsed from the resource");
                    }
                    return zzey;
                } catch (JSONException e) {
                    throw new zzqf.zzg("The resource data is corrupted. The container cannot be extracted from the binary data");
                } catch (zzqf.zzg e2) {
                    throw new zzqf.zzg("The resource data is invalid. The container cannot be extracted from the binary data");
                }
            }
        }
    };
}
