package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class zzks<K, V> extends zzkw<K, V> implements Map<K, V> {
    zzkv<K, V> zzabl;

    private zzkv<K, V> zzog() {
        if (this.zzabl == null) {
            this.zzabl = new zzkv<K, V>() {
                /* class com.google.android.gms.internal.zzks.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public void colClear() {
                    zzks.this.clear();
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public Object colGetEntry(int index, int offset) {
                    return zzks.this.mArray[(index << 1) + offset];
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public Map<K, V> colGetMap() {
                    return zzks.this;
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public int colGetSize() {
                    return zzks.this.mSize;
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public int colIndexOfKey(Object key) {
                    return key == null ? zzks.this.indexOfNull() : zzks.this.indexOf(key, key.hashCode());
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public int colIndexOfValue(Object value) {
                    return zzks.this.indexOfValue(value);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public void colPut(K key, V value) {
                    zzks.this.put(key, value);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public void colRemoveAt(int index) {
                    zzks.this.removeAt(index);
                }

                /* access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.zzkv
                public V colSetValue(int index, V value) {
                    return (V) zzks.this.setValueAt(index, value);
                }
            };
        }
        return this.zzabl;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return zzog().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return zzog().getKeySet();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.internal.zzks<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return zzog().getValues();
    }
}
