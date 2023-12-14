package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzj<T extends Parcelable> extends zza<T> {
    public zzj(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public T zzj(Bundle bundle) {
        return (T) bundle.getParcelable(getName());
    }
}
