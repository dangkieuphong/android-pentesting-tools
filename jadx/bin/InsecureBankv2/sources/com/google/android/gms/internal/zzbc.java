package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbb;
import java.util.concurrent.Future;

@zzgd
public class zzbc {
    /* access modifiers changed from: protected */
    public zzbb zza(Context context, VersionInfoParcel versionInfoParcel, final zzhs<zzbb> zzhs) {
        final zzbd zzbd = new zzbd(context, versionInfoParcel);
        zzbd.zza(new zzbb.zza() {
            /* class com.google.android.gms.internal.zzbc.AnonymousClass2 */

            @Override // com.google.android.gms.internal.zzbb.zza
            public void zzcf() {
                zzhs.zzf(zzbd);
            }
        });
        return zzbd;
    }

    public Future<zzbb> zza(final Context context, final VersionInfoParcel versionInfoParcel, final String str) {
        final zzhs zzhs = new zzhs();
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.internal.zzbc.AnonymousClass1 */

            public void run() {
                zzbc.this.zza(context, versionInfoParcel, zzhs).zzs(str);
            }
        });
        return zzhs;
    }
}
