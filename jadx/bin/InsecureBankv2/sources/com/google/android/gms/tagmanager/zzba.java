package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm;

/* access modifiers changed from: package-private */
public class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzaMe;

    zzba(int i, final zzm.zza<K, V> zza) {
        this.zzaMe = new LruCache<K, V>(i) {
            /* class com.google.android.gms.tagmanager.zzba.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(K key, V value) {
                return zza.sizeOf(key, value);
            }
        };
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public V get(K key) {
        return this.zzaMe.get(key);
    }

    @Override // com.google.android.gms.tagmanager.zzl
    public void zzf(K k, V v) {
        this.zzaMe.put(k, v);
    }
}
