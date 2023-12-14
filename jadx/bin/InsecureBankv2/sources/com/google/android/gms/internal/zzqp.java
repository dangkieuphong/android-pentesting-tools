package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.tagmanager.zzbg;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzqp {
    private boolean mClosed;
    private String zzaLc;
    private final ScheduledExecutorService zzaMX;
    private ScheduledFuture<?> zzaMZ;

    public zzqp() {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    public zzqp(String str) {
        this(Executors.newSingleThreadScheduledExecutor());
        this.zzaLc = str;
    }

    zzqp(ScheduledExecutorService scheduledExecutorService) {
        this.zzaMZ = null;
        this.zzaLc = null;
        this.zzaMX = scheduledExecutorService;
        this.mClosed = false;
    }

    public void zza(Context context, zzqd zzqd, long j, zzqn zzqn) {
        synchronized (this) {
            zzbg.zzaB("ResourceLoaderScheduler: Loading new resource.");
            if (this.zzaMZ == null) {
                this.zzaMZ = this.zzaMX.schedule(this.zzaLc != null ? new zzqo(context, zzqd, zzqn, this.zzaLc) : new zzqo(context, zzqd, zzqn), j, TimeUnit.MILLISECONDS);
            }
        }
    }
}
