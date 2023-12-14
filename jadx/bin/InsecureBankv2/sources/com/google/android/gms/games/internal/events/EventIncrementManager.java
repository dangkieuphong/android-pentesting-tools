package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzasM = new AtomicReference<>();

    public void flush() {
        EventIncrementCache eventIncrementCache = this.zzasM.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzp(String str, int i) {
        EventIncrementCache eventIncrementCache = this.zzasM.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzsS();
            if (!this.zzasM.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = this.zzasM.get();
            }
        }
        eventIncrementCache.zzw(str, i);
    }

    /* access modifiers changed from: protected */
    public abstract EventIncrementCache zzsS();
}
