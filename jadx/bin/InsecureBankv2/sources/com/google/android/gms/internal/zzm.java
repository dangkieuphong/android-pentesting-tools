package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;

public class zzm<T> {
    public final T result;
    public final zzb.zza zzag;
    public final zzr zzah;
    public boolean zzai;

    public interface zza {
        void zze(zzr zzr);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzr) {
        this.zzai = false;
        this.result = null;
        this.zzag = null;
        this.zzah = zzr;
    }

    private zzm(T t, zzb.zza zza2) {
        this.zzai = false;
        this.result = t;
        this.zzag = zza2;
        this.zzah = null;
    }

    public static <T> zzm<T> zza(T t, zzb.zza zza2) {
        return new zzm<>(t, zza2);
    }

    public static <T> zzm<T> zzd(zzr zzr) {
        return new zzm<>(zzr);
    }

    public boolean isSuccess() {
        return this.zzah == null;
    }
}
