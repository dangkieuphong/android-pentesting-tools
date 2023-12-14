package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzu;

abstract class zzt {
    private static volatile Handler zzKS;
    private final zzf zzJy;
    private volatile long zzKT;
    private boolean zzKU;
    private final Runnable zzx = new Runnable() {
        /* class com.google.android.gms.analytics.internal.zzt.AnonymousClass1 */

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzt.this.zzJy.zzhS().zze(this);
                return;
            }
            boolean zzbp = zzt.this.zzbp();
            zzt.this.zzKT = 0;
            if (zzbp && !zzt.this.zzKU) {
                zzt.this.run();
            }
        }
    };

    zzt(zzf zzf) {
        zzu.zzu(zzf);
        this.zzJy = zzf;
    }

    private Handler getHandler() {
        Handler handler;
        if (zzKS != null) {
            return zzKS;
        }
        synchronized (zzt.class) {
            if (zzKS == null) {
                zzKS = new Handler(this.zzJy.getContext().getMainLooper());
            }
            handler = zzKS;
        }
        return handler;
    }

    public void cancel() {
        this.zzKT = 0;
        getHandler().removeCallbacks(this.zzx);
    }

    public abstract void run();

    public boolean zzbp() {
        return this.zzKT != 0;
    }

    public long zzjD() {
        if (this.zzKT == 0) {
            return 0;
        }
        return Math.abs(this.zzJy.zzhP().currentTimeMillis() - this.zzKT);
    }

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzKT = this.zzJy.zzhP().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzx, j)) {
                this.zzJy.zzhQ().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzu(long j) {
        long j2 = 0;
        if (zzbp()) {
            if (j < 0) {
                cancel();
                return;
            }
            long abs = j - Math.abs(this.zzJy.zzhP().currentTimeMillis() - this.zzKT);
            if (abs >= 0) {
                j2 = abs;
            }
            getHandler().removeCallbacks(this.zzx);
            if (!getHandler().postDelayed(this.zzx, j2)) {
                this.zzJy.zzhQ().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
            }
        }
    }
}
