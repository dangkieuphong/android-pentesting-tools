package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzu;
import java.util.Random;

public class zzl extends zzu.zza {
    private Object zzqt = new Object();
    private long zzsA;
    private final Random zzsz = new Random();

    public zzl() {
        zzcG();
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public long getValue() {
        return this.zzsA;
    }

    public void zzcG() {
        synchronized (this.zzqt) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzsz.nextInt()) + 2147483648L;
                if (j != this.zzsA && j != 0) {
                    break;
                }
            }
            this.zzsA = j;
        }
    }
}
