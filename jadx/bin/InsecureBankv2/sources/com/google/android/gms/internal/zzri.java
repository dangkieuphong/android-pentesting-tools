package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrh;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzri<M extends zzrh<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzaVV;
    protected final boolean zzaVW;

    private zzri(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzaVV = cls;
        this.tag = i2;
        this.zzaVW = z;
    }

    @Deprecated
    public static <M extends zzrh<M>, T extends zzrn> zzri<M, T> zza(int i, Class<T> cls, int i2) {
        return new zzri<>(i, cls, i2, false);
    }

    private T zzy(List<zzrp> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzrp zzrp = list.get(i);
            if (zzrp.zzaWg.length != 0) {
                zza(zzrp, arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzaVV.cast(Array.newInstance(this.zzaVV.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzz(List<zzrp> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzaVV.cast(zzA(zzrf.zzz(list.get(list.size() - 1).zzaWg)));
    }

    /* access modifiers changed from: protected */
    public Object zzA(zzrf zzrf) {
        Class<?> componentType = this.zzaVW ? this.zzaVV.getComponentType() : this.zzaVV;
        try {
            switch (this.type) {
                case 10:
                    T newInstance = componentType.newInstance();
                    zzrf.zza(newInstance, zzrq.zzkV(this.tag));
                    return newInstance;
                case 11:
                    T newInstance2 = componentType.newInstance();
                    zzrf.zza(newInstance2);
                    return newInstance2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzQ(Object obj) {
        return this.zzaVW ? zzR(obj) : zzS(obj);
    }

    /* access modifiers changed from: protected */
    public int zzR(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzS(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int zzS(Object obj) {
        int zzkV = zzrq.zzkV(this.tag);
        switch (this.type) {
            case 10:
                return zzrg.zzb(zzkV, (zzrn) obj);
            case 11:
                return zzrg.zzc(zzkV, (zzrn) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzrp zzrp, List<Object> list) {
        list.add(zzA(zzrf.zzz(zzrp.zzaWg)));
    }

    /* access modifiers changed from: package-private */
    public void zza(Object obj, zzrg zzrg) throws IOException {
        if (this.zzaVW) {
            zzc(obj, zzrg);
        } else {
            zzb(obj, zzrg);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzrg zzrg) {
        try {
            zzrg.zzkN(this.tag);
            switch (this.type) {
                case 10:
                    int zzkV = zzrq.zzkV(this.tag);
                    zzrg.zzb((zzrn) obj);
                    zzrg.zzC(zzkV, 4);
                    return;
                case 11:
                    zzrg.zzc((zzrn) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzrg zzrg) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzrg);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final T zzx(List<zzrp> list) {
        if (list == null) {
            return null;
        }
        return this.zzaVW ? zzy(list) : zzz(list);
    }
}
