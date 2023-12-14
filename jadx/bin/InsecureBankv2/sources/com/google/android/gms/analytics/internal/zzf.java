package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzns;
import java.lang.Thread;

public class zzf {
    private static zzf zzJC;
    private final Context mContext;
    private final Context zzJD;
    private final zzr zzJE;
    private final zzaf zzJF;
    private final zzns zzJG;
    private final zzb zzJH;
    private final zzv zzJI;
    private final zzan zzJJ;
    private final zzai zzJK;
    private final GoogleAnalytics zzJL;
    private final zzn zzJM;
    private final zza zzJN;
    private final zzk zzJO;
    private final zzu zzJP;
    private final zzlb zzpw;

    protected zzf(zzg zzg) {
        Context applicationContext = zzg.getApplicationContext();
        zzu.zzb(applicationContext, "Application context can't be null");
        zzu.zzb(applicationContext instanceof Application, "getApplicationContext didn't return the application");
        Context zzic = zzg.zzic();
        zzu.zzu(zzic);
        this.mContext = applicationContext;
        this.zzJD = zzic;
        this.zzpw = zzg.zzh(this);
        this.zzJE = zzg.zzg(this);
        zzaf zzf = zzg.zzf(this);
        zzf.zza();
        this.zzJF = zzf;
        if (zzhR().zziW()) {
            zzhQ().zzaV("Google Analytics " + zze.VERSION + " is starting up.");
        } else {
            zzhQ().zzaV("Google Analytics " + zze.VERSION + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
        }
        zzai zzq = zzg.zzq(this);
        zzq.zza();
        this.zzJK = zzq;
        zzan zze = zzg.zze(this);
        zze.zza();
        this.zzJJ = zze;
        zzb zzl = zzg.zzl(this);
        zzn zzd = zzg.zzd(this);
        zza zzc = zzg.zzc(this);
        zzk zzb = zzg.zzb(this);
        zzu zza = zzg.zza(this);
        zzns zzW = zzg.zzW(applicationContext);
        zzW.zza(zzib());
        this.zzJG = zzW;
        GoogleAnalytics zzi = zzg.zzi(this);
        zzd.zza();
        this.zzJM = zzd;
        zzc.zza();
        this.zzJN = zzc;
        zzb.zza();
        this.zzJO = zzb;
        zza.zza();
        this.zzJP = zza;
        zzv zzp = zzg.zzp(this);
        zzp.zza();
        this.zzJI = zzp;
        zzl.zza();
        this.zzJH = zzl;
        if (zzhR().zziW()) {
            zzhQ().zzb("Device AnalyticsService version", zze.VERSION);
        }
        zzi.zza();
        this.zzJL = zzi;
        zzl.start();
    }

    public static zzf zzV(Context context) {
        zzu.zzu(context);
        if (zzJC == null) {
            synchronized (zzf.class) {
                if (zzJC == null) {
                    zzlb zzoQ = zzld.zzoQ();
                    long elapsedRealtime = zzoQ.elapsedRealtime();
                    zzf zzf = new zzf(new zzg(context.getApplicationContext()));
                    zzJC = zzf;
                    GoogleAnalytics.zzhj();
                    long elapsedRealtime2 = zzoQ.elapsedRealtime() - elapsedRealtime;
                    long longValue = zzy.zzLP.get().longValue();
                    if (elapsedRealtime2 > longValue) {
                        zzf.zzhQ().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zzJC;
    }

    private void zza(zzd zzd) {
        zzu.zzb(zzd, "Analytics service not created/initialized");
        zzu.zzb(zzd.isInitialized(), "Analytics service not initialized");
    }

    public Context getContext() {
        return this.mContext;
    }

    public void zzhO() {
        zzns.zzhO();
    }

    public zzlb zzhP() {
        return this.zzpw;
    }

    public zzaf zzhQ() {
        zza(this.zzJF);
        return this.zzJF;
    }

    public zzr zzhR() {
        return this.zzJE;
    }

    public zzns zzhS() {
        zzu.zzu(this.zzJG);
        return this.zzJG;
    }

    public zzv zzhT() {
        zza(this.zzJI);
        return this.zzJI;
    }

    public zzai zzhU() {
        zza(this.zzJK);
        return this.zzJK;
    }

    public zzk zzhX() {
        zza(this.zzJO);
        return this.zzJO;
    }

    public zzu zzhY() {
        return this.zzJP;
    }

    public zzb zzhl() {
        zza(this.zzJH);
        return this.zzJH;
    }

    public zzan zzhm() {
        zza(this.zzJJ);
        return this.zzJJ;
    }

    /* access modifiers changed from: protected */
    public Thread.UncaughtExceptionHandler zzib() {
        return new Thread.UncaughtExceptionHandler() {
            /* class com.google.android.gms.analytics.internal.zzf.AnonymousClass1 */

            public void uncaughtException(Thread thread, Throwable error) {
                zzaf zzid = zzf.this.zzid();
                if (zzid != null) {
                    zzid.zze("Job execution failed", error);
                }
            }
        };
    }

    public Context zzic() {
        return this.zzJD;
    }

    public zzaf zzid() {
        return this.zzJF;
    }

    public GoogleAnalytics zzie() {
        zzu.zzu(this.zzJL);
        zzu.zzb(this.zzJL.isInitialized(), "Analytics instance not initialized");
        return this.zzJL;
    }

    public zzai zzif() {
        if (this.zzJK == null || !this.zzJK.isInitialized()) {
            return null;
        }
        return this.zzJK;
    }

    public zza zzig() {
        zza(this.zzJN);
        return this.zzJN;
    }

    public zzn zzih() {
        zza(this.zzJM);
        return this.zzJM;
    }
}
