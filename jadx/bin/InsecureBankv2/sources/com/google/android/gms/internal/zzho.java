package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzm;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzgd
public class zzho {
    private static zzl zzGu;
    public static final zza<Void> zzGv = new zza() {
        /* class com.google.android.gms.internal.zzho.AnonymousClass1 */

        /* renamed from: zzgu */
        public Void zzft() {
            return null;
        }

        /* renamed from: zzi */
        public Void zzh(InputStream inputStream) {
            return null;
        }
    };
    private static final Object zzoW = new Object();

    public interface zza<T> {
        T zzft();

        T zzh(InputStream inputStream);
    }

    /* access modifiers changed from: private */
    public static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzGz;
        private final zzm.zzb<T> zzaH;

        public zzb(String str, final zza<T> zza, final zzm.zzb<T> zzb) {
            super(0, str, new zzm.zza() {
                /* class com.google.android.gms.internal.zzho.zzb.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.zzm$zzb */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.zzm.zza
                public void zze(zzr zzr) {
                    zzm.zzb.this.zzb(zza.zzft());
                }
            });
            this.zzGz = zza;
            this.zzaH = zzb;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        public zzm<InputStream> zza(zzi zzi) {
            return zzm.zza(new ByteArrayInputStream(zzi.data), zzx.zzb(zzi));
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzj */
        public void zza(InputStream inputStream) {
            this.zzaH.zzb(this.zzGz.zzh(inputStream));
        }
    }

    /* access modifiers changed from: private */
    public class zzc<T> extends zzhs<T> implements zzm.zzb<T> {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(T t) {
            super.zzf(t);
        }
    }

    public zzho(Context context) {
        zzGu = zzN(context);
    }

    private static zzl zzN(Context context) {
        zzl zzl;
        synchronized (zzoW) {
            if (zzGu == null) {
                zzGu = zzac.zza(context.getApplicationContext());
            }
            zzl = zzGu;
        }
        return zzl;
    }

    public <T> zzhv<T> zza(String str, zza<T> zza2) {
        zzc zzc2 = new zzc();
        zzGu.zze(new zzb(str, zza2, zzc2));
        return zzc2;
    }

    public zzhv<String> zzb(final String str, final Map<String, String> map) {
        final zzc zzc2 = new zzc();
        zzGu.zze(new zzab(str, zzc2, new zzm.zza() {
            /* class com.google.android.gms.internal.zzho.AnonymousClass2 */

            @Override // com.google.android.gms.internal.zzm.zza
            public void zze(zzr zzr) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Failed to load URL: " + str + "\n" + zzr.toString());
                zzc2.zzb((Object) null);
            }
        }) {
            /* class com.google.android.gms.internal.zzho.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzk
            public Map<String, String> getHeaders() throws zza {
                return map == null ? super.getHeaders() : map;
            }
        });
        return zzc2;
    }
}
