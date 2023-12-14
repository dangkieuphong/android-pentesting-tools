package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class zzhu {

    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zzhv<B> zza(final zzhv<A> zzhv, final zza<A, B> zza2) {
        final zzhs zzhs = new zzhs();
        zzhv.zzb(new Runnable() {
            /* class com.google.android.gms.internal.zzhu.AnonymousClass1 */

            public void run() {
                try {
                    zzhs.zzf(zza2.zze(zzhv.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzhs.cancel(true);
                }
            }
        });
        return zzhs;
    }
}
