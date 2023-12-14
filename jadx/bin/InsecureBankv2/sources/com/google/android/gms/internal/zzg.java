package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
    private final zzb zzj;
    private final zzn zzk;
    private volatile boolean zzl = false;
    private final BlockingQueue<zzk<?>> zzy;
    private final zzf zzz;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf zzf, zzb zzb, zzn zzn) {
        this.zzy = blockingQueue;
        this.zzz = zzf;
        this.zzj = zzb;
        this.zzk = zzn;
    }

    private void zzb(zzk<?> zzk2) {
        if (Build.VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(zzk2.zzg());
        }
    }

    private void zzb(zzk<?> zzk2, zzr zzr) {
        this.zzk.zza(zzk2, zzk2.zzb(zzr));
    }

    public void quit() {
        this.zzl = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk<?> take = this.zzy.take();
                try {
                    take.zzc("network-queue-take");
                    if (take.isCanceled()) {
                        take.zzd("network-discard-cancelled");
                    } else {
                        zzb(take);
                        zzi zza = this.zzz.zza(take);
                        take.zzc("network-http-complete");
                        if (!zza.zzB || !take.zzw()) {
                            zzm<?> zza2 = take.zza(zza);
                            take.zzc("network-parse-complete");
                            if (take.zzr() && zza2.zzag != null) {
                                this.zzj.zza(take.zzh(), zza2.zzag);
                                take.zzc("network-cache-written");
                            }
                            take.zzv();
                            this.zzk.zza(take, zza2);
                        } else {
                            take.zzd("not-modified");
                        }
                    }
                } catch (zzr e) {
                    e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    zzb(take, e);
                } catch (Exception e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr zzr = new zzr(e2);
                    zzr.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzk.zza(take, zzr);
                }
            } catch (InterruptedException e3) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
