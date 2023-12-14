package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {
    private AtomicInteger zzY;
    private final Map<String, Queue<zzk<?>>> zzZ;
    private final Set<zzk<?>> zzaa;
    private final PriorityBlockingQueue<zzk<?>> zzab;
    private final PriorityBlockingQueue<zzk<?>> zzac;
    private zzg[] zzad;
    private zzc zzae;
    private List<zza> zzaf;
    private final zzb zzj;
    private final zzn zzk;
    private final zzf zzz;

    public interface zza<T> {
        void zzg(zzk<T> zzk);
    }

    public zzl(zzb zzb, zzf zzf) {
        this(zzb, zzf, 4);
    }

    public zzl(zzb zzb, zzf zzf, int i) {
        this(zzb, zzf, i, new zze(new Handler(Looper.getMainLooper())));
    }

    public zzl(zzb zzb, zzf zzf, int i, zzn zzn) {
        this.zzY = new AtomicInteger();
        this.zzZ = new HashMap();
        this.zzaa = new HashSet();
        this.zzab = new PriorityBlockingQueue<>();
        this.zzac = new PriorityBlockingQueue<>();
        this.zzaf = new ArrayList();
        this.zzj = zzb;
        this.zzz = zzf;
        this.zzad = new zzg[i];
        this.zzk = zzn;
    }

    public int getSequenceNumber() {
        return this.zzY.incrementAndGet();
    }

    public void start() {
        stop();
        this.zzae = new zzc(this.zzab, this.zzac, this.zzj, this.zzk);
        this.zzae.start();
        for (int i = 0; i < this.zzad.length; i++) {
            zzg zzg = new zzg(this.zzac, this.zzz, this.zzj, this.zzk);
            this.zzad[i] = zzg;
            zzg.start();
        }
    }

    public void stop() {
        if (this.zzae != null) {
            this.zzae.quit();
        }
        for (int i = 0; i < this.zzad.length; i++) {
            if (this.zzad[i] != null) {
                this.zzad[i].quit();
            }
        }
    }

    public <T> zzk<T> zze(zzk<T> zzk2) {
        zzk2.zza(this);
        synchronized (this.zzaa) {
            this.zzaa.add(zzk2);
        }
        zzk2.zza(getSequenceNumber());
        zzk2.zzc("add-to-queue");
        if (!zzk2.zzr()) {
            this.zzac.add(zzk2);
        } else {
            synchronized (this.zzZ) {
                String zzh = zzk2.zzh();
                if (this.zzZ.containsKey(zzh)) {
                    Queue<zzk<?>> queue = this.zzZ.get(zzh);
                    if (queue == null) {
                        queue = new LinkedList<>();
                    }
                    queue.add(zzk2);
                    this.zzZ.put(zzh, queue);
                    if (zzs.DEBUG) {
                        zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", zzh);
                    }
                } else {
                    this.zzZ.put(zzh, null);
                    this.zzab.add(zzk2);
                }
            }
        }
        return zzk2;
    }

    /* access modifiers changed from: package-private */
    public <T> void zzf(zzk<T> zzk2) {
        synchronized (this.zzaa) {
            this.zzaa.remove(zzk2);
        }
        synchronized (this.zzaf) {
            for (zza zza2 : this.zzaf) {
                zza2.zzg(zzk2);
            }
        }
        if (zzk2.zzr()) {
            synchronized (this.zzZ) {
                String zzh = zzk2.zzh();
                Queue<zzk<?>> remove = this.zzZ.remove(zzh);
                if (remove != null) {
                    if (zzs.DEBUG) {
                        zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), zzh);
                    }
                    this.zzab.addAll(remove);
                }
            }
        }
    }
}
