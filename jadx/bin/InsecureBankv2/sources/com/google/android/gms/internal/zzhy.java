package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhx;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzgd
public class zzhy<T> implements zzhx<T> {
    protected final BlockingQueue<zzhy<T>.zza> zzGU = new LinkedBlockingQueue();
    protected T zzGV;
    private final Object zzqt = new Object();
    protected int zzwS = 0;

    class zza {
        public final zzhx.zzc<T> zzGW;
        public final zzhx.zza zzGX;

        public zza(zzhx.zzc<T> zzc, zzhx.zza zza) {
            this.zzGW = zzc;
            this.zzGX = zza;
        }
    }

    public int getStatus() {
        return this.zzwS;
    }

    public void reject() {
        synchronized (this.zzqt) {
            if (this.zzwS != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzwS = -1;
            Iterator it = this.zzGU.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzGX.run();
            }
            this.zzGU.clear();
        }
    }

    public void zza(zzhx.zzc<T> zzc, zzhx.zza zza2) {
        synchronized (this.zzqt) {
            if (this.zzwS == 1) {
                zzc.zzc(this.zzGV);
            } else if (this.zzwS == -1) {
                zza2.run();
            } else if (this.zzwS == 0) {
                this.zzGU.add(new zza(zzc, zza2));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzqt) {
            if (this.zzwS != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzGV = t;
            this.zzwS = 1;
            Iterator it = this.zzGU.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzGW.zzc(t);
            }
            this.zzGU.clear();
        }
    }
}
