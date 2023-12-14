package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {
    private T zzYM;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // java.util.Iterator, com.google.android.gms.common.data.zzb
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzYq);
        }
        this.zzYq++;
        if (this.zzYq == 0) {
            this.zzYM = (T) this.zzYp.get(0);
            if (!(this.zzYM instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.zzYM.getClass() + " is not movable");
            }
        } else {
            this.zzYM.zzbf(this.zzYq);
        }
        return this.zzYM;
    }
}
