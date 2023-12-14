package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.request.zzd;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;

@zzgd
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    /* access modifiers changed from: package-private */
    public interface zzb {
        boolean zzd(AdRequestInfoParcel adRequestInfoParcel);
    }

    public static zzhh zza(final Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        return zza(context, adRequestInfoParcel, zza2, new zzb() {
            /* class com.google.android.gms.ads.internal.request.zzc.AnonymousClass1 */

            @Override // com.google.android.gms.ads.internal.request.zzc.zzb
            public boolean zzd(AdRequestInfoParcel adRequestInfoParcel) {
                return adRequestInfoParcel.zzpJ.zzGJ || GooglePlayServicesUtil.zzae(context);
            }
        });
    }

    static zzhh zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2, zzb zzb2) {
        return zzb2.zzd(adRequestInfoParcel) ? zzb(context, adRequestInfoParcel, zza2) : zzc(context, adRequestInfoParcel, zza2);
    }

    private static zzhh zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Fetching ad response from local ad request service.");
        zzd.zza zza3 = new zzd.zza(context, adRequestInfoParcel, zza2);
        zza3.zzgi();
        return zza3;
    }

    private static zzhh zzc(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Fetching ad response from remote ad request service.");
        if (zzk.zzcA().zzP(context)) {
            return new zzd.zzb(context, adRequestInfoParcel, zza2);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Failed to connect to remote ad request service.");
        return null;
    }
}
