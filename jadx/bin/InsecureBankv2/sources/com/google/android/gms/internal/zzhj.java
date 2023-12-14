package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgd
public final class zzhj {

    private static abstract class zza extends zzhh {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzhh
        public void onStop() {
        }
    }

    public interface zzb {
        void zzc(Bundle bundle);
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            /* class com.google.android.gms.internal.zzhj.AnonymousClass3 */

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                SharedPreferences.Editor edit = zzhj.zzv(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.commit();
            }
        }.zzgi();
    }

    public static Future zza(final Context context, final zzb zzb2) {
        return new zza() {
            /* class com.google.android.gms.internal.zzhj.AnonymousClass2 */

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                SharedPreferences zzv = zzhj.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzv.getBoolean("use_https", true));
                if (zzb2 != null) {
                    zzb2.zzc(bundle);
                }
            }
        }.zzgi();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            /* class com.google.android.gms.internal.zzhj.AnonymousClass1 */

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                SharedPreferences.Editor edit = zzhj.zzv(context).edit();
                edit.putBoolean("use_https", z);
                edit.commit();
            }
        }.zzgi();
    }

    public static Future zzb(final Context context, final zzb zzb2) {
        return new zza() {
            /* class com.google.android.gms.internal.zzhj.AnonymousClass4 */

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                SharedPreferences zzv = zzhj.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzv.getInt("webview_cache_version", 0));
                if (zzb2 != null) {
                    zzb2.zzc(bundle);
                }
            }
        }.zzgi();
    }

    /* access modifiers changed from: private */
    public static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
