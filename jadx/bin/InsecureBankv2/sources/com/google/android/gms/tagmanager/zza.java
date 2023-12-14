package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import java.io.IOException;

class zza {
    private static Object zzaKl = new Object();
    private static zza zzaKm;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzFZ;
    private volatile AdvertisingIdClient.Info zzJl;
    private volatile long zzaKh;
    private volatile long zzaKi;
    private volatile long zzaKj;
    private AbstractC0221zza zzaKk;
    private final zzlb zzpw;

    /* renamed from: com.google.android.gms.tagmanager.zza$zza  reason: collision with other inner class name */
    public interface AbstractC0221zza {
        AdvertisingIdClient.Info zzyg();
    }

    private zza(Context context) {
        this(context, null, zzld.zzoQ());
    }

    zza(Context context, AbstractC0221zza zza, zzlb zzlb) {
        this.zzaKh = 900000;
        this.zzaKi = 30000;
        this.mClosed = false;
        this.zzaKk = new AbstractC0221zza() {
            /* class com.google.android.gms.tagmanager.zza.AnonymousClass1 */

            @Override // com.google.android.gms.tagmanager.zza.AbstractC0221zza
            public AdvertisingIdClient.Info zzyg() {
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(zza.this.mContext);
                } catch (IllegalStateException e) {
                    zzbg.zzaC("IllegalStateException getting Advertising Id Info");
                    return null;
                } catch (GooglePlayServicesRepairableException e2) {
                    zzbg.zzaC("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return null;
                } catch (IOException e3) {
                    zzbg.zzaC("IOException getting Ad Id Info");
                    return null;
                } catch (GooglePlayServicesNotAvailableException e4) {
                    zzbg.zzaC("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return null;
                } catch (Exception e5) {
                    zzbg.zzaC("Unknown exception. Could not get the Advertising Id Info.");
                    return null;
                }
            }
        };
        this.zzpw = zzlb;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (zza != null) {
            this.zzaKk = zza;
        }
        this.zzFZ = new Thread(new Runnable() {
            /* class com.google.android.gms.tagmanager.zza.AnonymousClass2 */

            public void run() {
                zza.this.zzye();
            }
        });
    }

    static zza zzaE(Context context) {
        if (zzaKm == null) {
            synchronized (zzaKl) {
                if (zzaKm == null) {
                    zzaKm = new zza(context);
                    zzaKm.start();
                }
            }
        }
        return zzaKm;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzye() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.zzJl = this.zzaKk.zzyg();
                Thread.sleep(this.zzaKh);
            } catch (InterruptedException e) {
                zzbg.zzaA("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzyf() {
        if (this.zzpw.currentTimeMillis() - this.zzaKj >= this.zzaKi) {
            interrupt();
            this.zzaKj = this.zzpw.currentTimeMillis();
        }
    }

    /* access modifiers changed from: package-private */
    public void interrupt() {
        this.zzFZ.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        zzyf();
        if (this.zzJl == null) {
            return true;
        }
        return this.zzJl.isLimitAdTrackingEnabled();
    }

    /* access modifiers changed from: package-private */
    public void start() {
        this.zzFZ.start();
    }

    public String zzyd() {
        zzyf();
        if (this.zzJl == null) {
            return null;
        }
        return this.zzJl.getId();
    }
}
