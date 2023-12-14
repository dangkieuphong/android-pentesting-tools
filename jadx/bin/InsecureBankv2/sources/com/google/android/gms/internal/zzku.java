package com.google.android.gms.internal;

import java.util.LinkedHashMap;

public class zzku<K, V> {
    private int size;
    private final LinkedHashMap<K, V> zzabn;
    private int zzabo;
    private int zzabp;
    private int zzabq;
    private int zzabr;
    private int zzabs;
    private int zzabt;

    public zzku(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zzabo = i;
        this.zzabn = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int zzc(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + ((Object) k) + "=" + ((Object) v));
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = create(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r4.zzabq++;
        r0 = r4.zzabn.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r4.zzabn.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        entryRemoved(false, r5, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0049, code lost:
        r4.size += zzc(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        trimToSize(r4.zzabo);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000a
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            throw r0
        L_0x000a:
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.zzabn     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001b
            int r1 = r4.zzabs     // Catch:{ all -> 0x002a }
            int r1 = r1 + 1
            r4.zzabs = r1     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
        L_0x001a:
            return r0
        L_0x001b:
            int r0 = r4.zzabt     // Catch:{ all -> 0x002a }
            int r0 = r0 + 1
            r4.zzabt = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = r4.create(r5)
            if (r1 != 0) goto L_0x002d
            r0 = 0
            goto L_0x001a
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x002d:
            monitor-enter(r4)
            int r0 = r4.zzabq     // Catch:{ all -> 0x0053 }
            int r0 = r0 + 1
            r4.zzabq = r0     // Catch:{ all -> 0x0053 }
            java.util.LinkedHashMap<K, V> r0 = r4.zzabn     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.put(r5, r1)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            java.util.LinkedHashMap<K, V> r2 = r4.zzabn     // Catch:{ all -> 0x0053 }
            r2.put(r5, r0)     // Catch:{ all -> 0x0053 }
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0056
            r2 = 0
            r4.entryRemoved(r2, r5, r1, r0)
            goto L_0x001a
        L_0x0049:
            int r2 = r4.size
            int r3 = r4.zzc(r5, r1)
            int r2 = r2 + r3
            r4.size = r2
            goto L_0x0041
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0056:
            int r0 = r4.zzabo
            r4.trimToSize(r0)
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzku.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K key, V value) {
        V put;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.zzabp++;
            this.size += zzc(key, value);
            put = this.zzabn.put(key, value);
            if (put != null) {
                this.size -= zzc(key, put);
            }
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.zzabo);
        return put;
    }

    public final synchronized int size() {
        return this.size;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.zzabs + this.zzabt;
            if (i2 != 0) {
                i = (this.zzabs * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zzabo), Integer.valueOf(this.zzabs), Integer.valueOf(this.zzabt), Integer.valueOf(i));
        }
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzku.trimToSize(int):void");
    }
}
