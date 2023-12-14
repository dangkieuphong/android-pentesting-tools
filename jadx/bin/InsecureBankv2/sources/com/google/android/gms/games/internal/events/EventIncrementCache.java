package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzasG = new Object();
    private Handler zzasH;
    private boolean zzasI;
    private HashMap<String, AtomicInteger> zzasJ;
    private int zzasK;

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzasH = new Handler(looper);
        this.zzasJ = new HashMap<>();
        this.zzasK = flushIntervalMillis;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzth() {
        synchronized (this.zzasG) {
            this.zzasI = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzasG) {
            for (Map.Entry<String, AtomicInteger> entry : this.zzasJ.entrySet()) {
                zzs(entry.getKey(), entry.getValue().get());
            }
            this.zzasJ.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzs(String str, int i);

    public void zzw(String str, int i) {
        synchronized (this.zzasG) {
            if (!this.zzasI) {
                this.zzasI = true;
                this.zzasH.postDelayed(new Runnable() {
                    /* class com.google.android.gms.games.internal.events.EventIncrementCache.AnonymousClass1 */

                    public void run() {
                        EventIncrementCache.this.zzth();
                    }
                }, (long) this.zzasK);
            }
            AtomicInteger atomicInteger = this.zzasJ.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzasJ.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
