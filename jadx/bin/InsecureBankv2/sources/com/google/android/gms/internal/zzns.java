package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzu;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzns {
    private static volatile zzns zzaEh;
    private final Context mContext;
    private volatile zznx zzKm;
    private final List<zznt> zzaEi = new CopyOnWriteArrayList();
    private final zznn zzaEj = new zznn();
    private final zza zzaEk = new zza();
    private Thread.UncaughtExceptionHandler zzaEl;

    /* access modifiers changed from: private */
    public class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            return new FutureTask<T>(runnable, value) {
                /* class com.google.android.gms.internal.zzns.zza.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public void setException(Throwable error) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = zzns.this.zzaEl;
                    if (uncaughtExceptionHandler != null) {
                        uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), error);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        Log.e("GAv4", "MeasurementExecutor: job failed with " + error);
                    }
                    super.setException(error);
                }
            };
        }
    }

    private static class zzb implements ThreadFactory {
        private static final AtomicInteger zzaEp = new AtomicInteger();

        private zzb() {
        }

        public Thread newThread(Runnable target) {
            return new zzc(target, "measurement-" + zzaEp.incrementAndGet());
        }
    }

    /* access modifiers changed from: private */
    public static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzns(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzu.zzu(applicationContext);
        this.mContext = applicationContext;
    }

    public static zzns zzaB(Context context) {
        zzu.zzu(context);
        if (zzaEh == null) {
            synchronized (zzns.class) {
                if (zzaEh == null) {
                    zzaEh = new zzns(context);
                }
            }
        }
        return zzaEh;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzb(zzno zzno) {
        zzu.zzbZ("deliver should be called from worker thread");
        zzu.zzb(zzno.zzvU(), "Measurement must be submitted");
        List<zznu> zzvR = zzno.zzvR();
        if (!zzvR.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (zznu zznu : zzvR) {
                Uri zzhe = zznu.zzhe();
                if (!hashSet.contains(zzhe)) {
                    hashSet.add(zzhe);
                    zznu.zzb(zzno);
                }
            }
        }
    }

    public static void zzhO() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void zza(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzaEl = uncaughtExceptionHandler;
    }

    public <V> Future<V> zzb(Callable<V> callable) {
        zzu.zzu(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzaEk.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* access modifiers changed from: package-private */
    public void zze(zzno zzno) {
        if (zzno.zzvY()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (zzno.zzvU()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            final zzno zzvP = zzno.zzvP();
            zzvP.zzvV();
            this.zzaEk.execute(new Runnable() {
                /* class com.google.android.gms.internal.zzns.AnonymousClass1 */

                public void run() {
                    zzvP.zzvW().zza(zzvP);
                    for (zznt zznt : zzns.this.zzaEi) {
                        zznt.zza(zzvP);
                    }
                    zzns.this.zzb((zzns) zzvP);
                }
            });
        }
    }

    public void zze(Runnable runnable) {
        zzu.zzu(runnable);
        this.zzaEk.submit(runnable);
    }

    public zznx zzwc() {
        if (this.zzKm == null) {
            synchronized (this) {
                if (this.zzKm == null) {
                    zznx zznx = new zznx();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    zznx.setAppId(packageName);
                    zznx.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    zznx.setAppName(packageName);
                    zznx.setAppVersion(str);
                    this.zzKm = zznx;
                }
            }
        }
        return this.zzKm;
    }

    public zznz zzwd() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zznz zznz = new zznz();
        zznz.setLanguage(zzam.zza(Locale.getDefault()));
        zznz.zzhG(displayMetrics.widthPixels);
        zznz.zzhH(displayMetrics.heightPixels);
        return zznz;
    }
}
