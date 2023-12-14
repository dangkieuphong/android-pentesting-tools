package com.google.android.gms.internal;

import java.security.MessageDigest;

public class zzbo extends zzbl {
    private MessageDigest zzrS;

    /* access modifiers changed from: package-private */
    public byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzj(zzbn.zzB(strArr[i]));
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public byte zzj(int i) {
        return (byte) ((((i & 255) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((-16777216 & i) >> 24));
    }

    @Override // com.google.android.gms.internal.zzbl
    public byte[] zzy(String str) {
        byte[] bArr;
        byte[] zza = zza(str.split(" "));
        this.zzrS = zzcu();
        synchronized (this.zzqt) {
            if (this.zzrS == null) {
                bArr = new byte[0];
            } else {
                this.zzrS.reset();
                this.zzrS.update(zza);
                byte[] digest = this.zzrS.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                bArr = new byte[i];
                System.arraycopy(digest, 0, bArr, 0, bArr.length);
            }
        }
        return bArr;
    }
}
