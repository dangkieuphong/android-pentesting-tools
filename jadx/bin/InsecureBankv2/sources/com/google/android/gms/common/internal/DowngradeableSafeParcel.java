package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzZZ = new Object();
    private static ClassLoader zzaaa = null;
    private static Integer zzaab = null;
    private boolean zzaac = false;

    private static boolean zza(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    protected static boolean zzca(String str) {
        ClassLoader zznD = zznD();
        if (zznD == null) {
            return true;
        }
        try {
            return zza(zznD.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zznD() {
        ClassLoader classLoader;
        synchronized (zzZZ) {
            classLoader = zzaaa;
        }
        return classLoader;
    }

    protected static Integer zznE() {
        Integer num;
        synchronized (zzZZ) {
            num = zzaab;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public boolean zznF() {
        return this.zzaac;
    }
}
