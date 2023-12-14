package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzIt = new ArrayList();
    private boolean zzIu;
    private Set<zza> zzIv = new HashSet();
    private boolean zzIw;
    private boolean zzIx;
    private volatile boolean zzIy;
    private boolean zzIz;
    private boolean zzpb;

    /* access modifiers changed from: package-private */
    public interface zza {
        void zzn(Activity activity);

        void zzo(Activity activity);
    }

    /* access modifiers changed from: package-private */
    public class zzb implements Application.ActivityLifecycleCallbacks {
        zzb() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.zzl(activity);
        }

        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.zzm(activity);
        }
    }

    public GoogleAnalytics(zzf context) {
        super(context);
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzV(context).zzie();
    }

    public static void zzhj() {
        synchronized (GoogleAnalytics.class) {
            if (zzIt != null) {
                for (Runnable runnable : zzIt) {
                    runnable.run();
                }
                zzIt = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb zzhl() {
        return zzhb().zzhl();
    }

    private zzan zzhm() {
        return zzhb().zzhm();
    }

    public void dispatchLocalHits() {
        zzhl().zzhH();
    }

    public void enableAutoActivityReports(Application application) {
        if (Build.VERSION.SDK_INT >= 14 && !this.zzIw) {
            application.registerActivityLifecycleCallbacks(new zzb());
            this.zzIw = true;
        }
    }

    public boolean getAppOptOut() {
        return this.zzIy;
    }

    public String getClientId() {
        zzu.zzbZ("getClientId can not be called from the main thread");
        return zzhb().zzih().zziP();
    }

    @Deprecated
    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        return this.zzIx;
    }

    public boolean isInitialized() {
        return this.zzpb && !this.zzIu;
    }

    public Tracker newTracker(int configResId) {
        Tracker tracker;
        zzal zzal;
        synchronized (this) {
            tracker = new Tracker(zzhb(), null, null);
            if (configResId > 0 && (zzal = (zzal) new zzak(zzhb()).zzab(configResId)) != null) {
                tracker.zza(zzal);
            }
            tracker.zza();
        }
        return tracker;
    }

    public Tracker newTracker(String trackingId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzhb(), trackingId, null);
            tracker.zza();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzIw) {
            zzl(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzIw) {
            zzm(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        this.zzIy = optOut;
        if (this.zzIy) {
            zzhl().zzhG();
        }
    }

    public void setDryRun(boolean dryRun) {
        this.zzIx = dryRun;
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        zzhl().setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (!this.zzIz) {
            Log.i(zzy.zzLb.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.zzLb.get() + " DEBUG");
            this.zzIz = true;
        }
    }

    public void zza() {
        zzhi();
        this.zzpb = true;
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        this.zzIv.add(zza2);
        Context context = zzhb().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(zza zza2) {
        this.zzIv.remove(zza2);
    }

    /* access modifiers changed from: package-private */
    public void zzhi() {
        Logger logger;
        zzan zzhm = zzhm();
        if (zzhm.zzjO()) {
            getLogger().setLogLevel(zzhm.getLogLevel());
        }
        if (zzhm.zzjS()) {
            setDryRun(zzhm.zzjT());
        }
        if (zzhm.zzjO() && (logger = zzae.getLogger()) != null) {
            logger.setLogLevel(zzhm.getLogLevel());
        }
    }

    /* access modifiers changed from: package-private */
    public void zzhk() {
        zzhl().zzhI();
    }

    /* access modifiers changed from: package-private */
    public void zzl(Activity activity) {
        for (zza zza2 : this.zzIv) {
            zza2.zzn(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzm(Activity activity) {
        for (zza zza2 : this.zzIv) {
            zza2.zzo(activity);
        }
    }
}
