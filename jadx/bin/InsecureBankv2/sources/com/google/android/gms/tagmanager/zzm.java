package com.google.android.gms.tagmanager;

import android.os.Build;

/* access modifiers changed from: package-private */
public class zzm<K, V> {
    final zza<K, V> zzaKw = new zza<K, V>() {
        /* class com.google.android.gms.tagmanager.zzm.AnonymousClass1 */

        @Override // com.google.android.gms.tagmanager.zzm.zza
        public int sizeOf(K k, V v) {
            return 1;
        }
    };

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    public zzl<K, V> zza(int i, zza<K, V> zza2) {
        if (i > 0) {
            return zzyj() < 12 ? new zzcw(i, zza2) : new zzba(i, zza2);
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* access modifiers changed from: package-private */
    public int zzyj() {
        return Build.VERSION.SDK_INT;
    }
}
