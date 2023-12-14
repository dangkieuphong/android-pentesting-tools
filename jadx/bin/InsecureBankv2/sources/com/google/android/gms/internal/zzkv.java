package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* access modifiers changed from: package-private */
public abstract class zzkv<K, V> {
    zzkv<K, V>.zzb zzabu;
    zzkv<K, V>.zzc zzabv;
    zzkv<K, V>.zze zzabw;

    final class zza<T> implements Iterator<T> {
        boolean mCanRemove = false;
        int mIndex;
        final int mOffset;
        int mSize;

        zza(int i) {
            this.mOffset = i;
            this.mSize = zzkv.this.colGetSize();
        }

        public boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public T next() {
            T t = (T) zzkv.this.colGetEntry(this.mIndex, this.mOffset);
            this.mIndex++;
            this.mCanRemove = true;
            return t;
        }

        public void remove() {
            if (!this.mCanRemove) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.mCanRemove = false;
            zzkv.this.colRemoveAt(this.mIndex);
        }
    }

    final class zzb implements Set<Map.Entry<K, V>> {
        zzb() {
        }

        @Override // java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object x0) {
            return add((Map.Entry) ((Map.Entry) x0));
        }

        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.internal.zzkv */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int colGetSize = zzkv.this.colGetSize();
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                zzkv.this.colPut(entry.getKey(), entry.getValue());
            }
            return colGetSize != zzkv.this.colGetSize();
        }

        public void clear() {
            zzkv.this.colClear();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o;
            int colIndexOfKey = zzkv.this.colIndexOfKey(entry.getKey());
            if (colIndexOfKey >= 0) {
                return zzkt.equal(zzkv.this.colGetEntry(colIndexOfKey, 1), entry.getValue());
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object object) {
            return zzkv.equalsSetHelper(this, object);
        }

        public int hashCode() {
            int colGetSize = zzkv.this.colGetSize() - 1;
            int i = 0;
            while (colGetSize >= 0) {
                Object colGetEntry = zzkv.this.colGetEntry(colGetSize, 0);
                Object colGetEntry2 = zzkv.this.colGetEntry(colGetSize, 1);
                colGetSize--;
                i += (colGetEntry2 == null ? 0 : colGetEntry2.hashCode()) ^ (colGetEntry == null ? 0 : colGetEntry.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return zzkv.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new zzd();
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return zzkv.this.colGetSize();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    final class zzc implements Set<K> {
        zzc() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            zzkv.this.colClear();
        }

        public boolean contains(Object object) {
            return zzkv.this.colIndexOfKey(object) >= 0;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return zzkv.containsAllHelper(zzkv.this.colGetMap(), collection);
        }

        public boolean equals(Object object) {
            return zzkv.equalsSetHelper(this, object);
        }

        public int hashCode() {
            int i = 0;
            for (int colGetSize = zzkv.this.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                Object colGetEntry = zzkv.this.colGetEntry(colGetSize, 0);
                i += colGetEntry == null ? 0 : colGetEntry.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return zzkv.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new zza(0);
        }

        public boolean remove(Object object) {
            int colIndexOfKey = zzkv.this.colIndexOfKey(object);
            if (colIndexOfKey < 0) {
                return false;
            }
            zzkv.this.colRemoveAt(colIndexOfKey);
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return zzkv.removeAllHelper(zzkv.this.colGetMap(), collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return zzkv.retainAllHelper(zzkv.this.colGetMap(), collection);
        }

        public int size() {
            return zzkv.this.colGetSize();
        }

        public Object[] toArray() {
            return zzkv.this.toArrayHelper(0);
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] array) {
            return (T[]) zzkv.this.toArrayHelper(array, 0);
        }
    }

    final class zzd implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int mEnd;
        boolean mEntryValid = false;
        int mIndex;

        zzd() {
            this.mEnd = zzkv.this.colGetSize() - 1;
            this.mIndex = -1;
        }

        public final boolean equals(Object o) {
            boolean z = true;
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(o instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) o;
                if (!zzkt.equal(entry.getKey(), zzkv.this.colGetEntry(this.mIndex, 0)) || !zzkt.equal(entry.getValue(), zzkv.this.colGetEntry(this.mIndex, 1))) {
                    z = false;
                }
                return z;
            }
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.mEntryValid) {
                return (K) zzkv.this.colGetEntry(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.mEntryValid) {
                return (V) zzkv.this.colGetEntry(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.mIndex < this.mEnd;
        }

        public final int hashCode() {
            int i = 0;
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object colGetEntry = zzkv.this.colGetEntry(this.mIndex, 0);
            Object colGetEntry2 = zzkv.this.colGetEntry(this.mIndex, 1);
            int hashCode = colGetEntry == null ? 0 : colGetEntry.hashCode();
            if (colGetEntry2 != null) {
                i = colGetEntry2.hashCode();
            }
            return i ^ hashCode;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.mIndex++;
            this.mEntryValid = true;
            return this;
        }

        public void remove() {
            if (!this.mEntryValid) {
                throw new IllegalStateException();
            }
            zzkv.this.colRemoveAt(this.mIndex);
            this.mIndex--;
            this.mEnd--;
            this.mEntryValid = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V object) {
            if (this.mEntryValid) {
                return (V) zzkv.this.colSetValue(this.mIndex, object);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    final class zze implements Collection<V> {
        zze() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            zzkv.this.colClear();
        }

        public boolean contains(Object object) {
            return zzkv.this.colIndexOfValue(object) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return zzkv.this.colGetSize() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new zza(1);
        }

        public boolean remove(Object object) {
            int colIndexOfValue = zzkv.this.colIndexOfValue(object);
            if (colIndexOfValue < 0) {
                return false;
            }
            zzkv.this.colRemoveAt(colIndexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int i = 0;
            int colGetSize = zzkv.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (collection.contains(zzkv.this.colGetEntry(i, 1))) {
                    zzkv.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int i = 0;
            int colGetSize = zzkv.this.colGetSize();
            boolean z = false;
            while (i < colGetSize) {
                if (!collection.contains(zzkv.this.colGetEntry(i, 1))) {
                    zzkv.this.colRemoveAt(i);
                    i--;
                    colGetSize--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return zzkv.this.colGetSize();
        }

        public Object[] toArray() {
            return zzkv.this.toArrayHelper(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) zzkv.this.toArrayHelper(array, 1);
        }
    }

    zzkv() {
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object object) {
        boolean z = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set2 = (Set) object;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    public abstract void colClear();

    /* access modifiers changed from: protected */
    public abstract Object colGetEntry(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract Map<K, V> colGetMap();

    /* access modifiers changed from: protected */
    public abstract int colGetSize();

    /* access modifiers changed from: protected */
    public abstract int colIndexOfKey(Object obj);

    /* access modifiers changed from: protected */
    public abstract int colIndexOfValue(Object obj);

    /* access modifiers changed from: protected */
    public abstract void colPut(K k, V v);

    /* access modifiers changed from: protected */
    public abstract void colRemoveAt(int i);

    /* access modifiers changed from: protected */
    public abstract V colSetValue(int i, V v);

    public Set<Map.Entry<K, V>> getEntrySet() {
        if (this.zzabu == null) {
            this.zzabu = new zzb();
        }
        return this.zzabu;
    }

    public Set<K> getKeySet() {
        if (this.zzabv == null) {
            this.zzabv = new zzc();
        }
        return this.zzabv;
    }

    public Collection<V> getValues() {
        if (this.zzabw == null) {
            this.zzabw = new zze();
        }
        return this.zzabw;
    }

    public Object[] toArrayHelper(int offset) {
        int colGetSize = colGetSize();
        Object[] objArr = new Object[colGetSize];
        for (int i = 0; i < colGetSize; i++) {
            objArr[i] = colGetEntry(i, offset);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] toArrayHelper(T[] array, int offset) {
        int colGetSize = colGetSize();
        if (array.length < colGetSize) {
            array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), colGetSize));
        }
        for (int i = 0; i < colGetSize; i++) {
            array[i] = colGetEntry(i, offset);
        }
        if (array.length > colGetSize) {
            array[colGetSize] = null;
        }
        return array;
    }
}
