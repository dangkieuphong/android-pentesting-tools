package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzo;

@zzgd
public abstract class zzbv<T> implements zzbs {
    private final String zztw;
    private final T zztx;

    private zzbv(String str, T t) {
        this.zztw = str;
        this.zztx = t;
        zzo.zzbD().zza((zzbs) this);
    }

    public static zzbv<String> zzO(String str) {
        zzbv<String> zzc = zzc(str, null);
        zzo.zzbD().zza(zzc);
        return zzc;
    }

    public static zzbv<String> zzP(String str) {
        zzbv<String> zzc = zzc(str, null);
        zzo.zzbD().zzb(zzc);
        return zzc;
    }

    public static zzbv<Integer> zza(String str, int i) {
        return new zzbv<Integer>(str, Integer.valueOf(i)) {
            /* class com.google.android.gms.internal.zzbv.AnonymousClass2 */

            /* renamed from: zzc */
            public Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzcY()).intValue()));
            }

            @Override // com.google.android.gms.internal.zzbv
            public zzkf<Integer> zzcZ() {
                return zzkf.zza(getKey(), (Integer) zzcY());
            }
        };
    }

    public static zzbv<Boolean> zza(String str, Boolean bool) {
        return new zzbv<Boolean>(str, bool) {
            /* class com.google.android.gms.internal.zzbv.AnonymousClass1 */

            /* renamed from: zzb */
            public Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzcY()).booleanValue()));
            }

            @Override // com.google.android.gms.internal.zzbv
            public zzkf<Boolean> zzcZ() {
                return zzkf.zzg(getKey(), ((Boolean) zzcY()).booleanValue());
            }
        };
    }

    public static zzbv<Long> zzb(String str, long j) {
        return new zzbv<Long>(str, Long.valueOf(j)) {
            /* class com.google.android.gms.internal.zzbv.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzbv
            public zzkf<Long> zzcZ() {
                return zzkf.zza(getKey(), (Long) zzcY());
            }

            /* renamed from: zzd */
            public Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzcY()).longValue()));
            }
        };
    }

    public static zzbv<String> zzc(String str, String str2) {
        return new zzbv<String>(str, str2) {
            /* class com.google.android.gms.internal.zzbv.AnonymousClass4 */

            @Override // com.google.android.gms.internal.zzbv
            public zzkf<String> zzcZ() {
                return zzkf.zzs(getKey(), (String) zzcY());
            }

            /* renamed from: zze */
            public String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzcY());
            }
        };
    }

    public T get() {
        return (T) zzo.zzbE().zzc(this);
    }

    public String getKey() {
        return this.zztw;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public T zzcY() {
        return this.zztx;
    }

    public abstract zzkf<T> zzcZ();
}
