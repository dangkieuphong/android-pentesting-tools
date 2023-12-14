package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzgd
public final class zzdw {
    private final Context mContext;
    private final zzef zzoq;
    private final Object zzqt = new Object();
    private final AdRequestInfoParcel zzxm;
    private final zzdy zzxn;
    private boolean zzxo = false;
    private zzeb zzxp;

    public zzdw(Context context, AdRequestInfoParcel adRequestInfoParcel, zzef zzef, zzdy zzdy) {
        this.mContext = context;
        this.zzxm = adRequestInfoParcel;
        this.zzoq = zzef;
        this.zzxn = zzdy;
    }

    public void cancel() {
        synchronized (this.zzqt) {
            this.zzxo = true;
            if (this.zzxp != null) {
                this.zzxp.cancel();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0080, code lost:
        r4 = r17.zzxp.zzb(r18, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r4.zzxY != 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Adapter succeeded.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (r4.zzya == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009d, code lost:
        com.google.android.gms.internal.zzhl.zzGk.post(new com.google.android.gms.internal.zzdw.AnonymousClass1(r17));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzec zza(long r18, long r20) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdw.zza(long, long):com.google.android.gms.internal.zzec");
    }
}
