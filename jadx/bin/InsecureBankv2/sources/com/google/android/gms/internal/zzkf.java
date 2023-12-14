package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzkf<T> {
    private static zza zzYj = null;
    private static int zzYk = 0;
    private static String zzYl = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzoW = new Object();
    private T zzLS = null;
    protected final String zztw;
    protected final T zztx;

    /* access modifiers changed from: private */
    public interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zzb(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzkf(String str, T t) {
        this.zztw = str;
        this.zztx = t;
    }

    public static boolean isInitialized() {
        return zzYj != null;
    }

    public static zzkf<Float> zza(String str, Float f) {
        return new zzkf<Float>(str, f) {
            /* class com.google.android.gms.internal.zzkf.AnonymousClass4 */

            /* access modifiers changed from: protected */
            /* renamed from: zzbT */
            public Float zzbP(String str) {
                return zzkf.zzYj.zzb(this.zztw, (Float) this.zztx);
            }
        };
    }

    public static zzkf<Integer> zza(String str, Integer num) {
        return new zzkf<Integer>(str, num) {
            /* class com.google.android.gms.internal.zzkf.AnonymousClass3 */

            /* access modifiers changed from: protected */
            /* renamed from: zzbS */
            public Integer zzbP(String str) {
                return zzkf.zzYj.zzb(this.zztw, (Integer) this.zztx);
            }
        };
    }

    public static zzkf<Long> zza(String str, Long l) {
        return new zzkf<Long>(str, l) {
            /* class com.google.android.gms.internal.zzkf.AnonymousClass2 */

            /* access modifiers changed from: protected */
            /* renamed from: zzbR */
            public Long zzbP(String str) {
                return zzkf.zzYj.getLong(this.zztw, (Long) this.zztx);
            }
        };
    }

    public static zzkf<Boolean> zzg(String str, boolean z) {
        return new zzkf<Boolean>(str, Boolean.valueOf(z)) {
            /* class com.google.android.gms.internal.zzkf.AnonymousClass1 */

            /* access modifiers changed from: protected */
            /* renamed from: zzbQ */
            public Boolean zzbP(String str) {
                return zzkf.zzYj.zzb(this.zztw, (Boolean) this.zztx);
            }
        };
    }

    public static int zzmY() {
        return zzYk;
    }

    public static zzkf<String> zzs(String str, String str2) {
        return new zzkf<String>(str, str2) {
            /* class com.google.android.gms.internal.zzkf.AnonymousClass5 */

            /* access modifiers changed from: protected */
            /* renamed from: zzbU */
            public String zzbP(String str) {
                return zzkf.zzYj.getString(this.zztw, (String) this.zztx);
            }
        };
    }

    public final T get() {
        return this.zzLS != null ? this.zzLS : zzbP(this.zztw);
    }

    /* access modifiers changed from: protected */
    public abstract T zzbP(String str);

    public final T zzmZ() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
