package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhh;

@zzgd
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza  reason: collision with other inner class name */
    public interface AbstractC0012zza {
        void zza(zzha.zza zza);
    }

    public zzhh zza(Context context, AdRequestInfoParcel.zza zza, zzan zzan, AbstractC0012zza zza2) {
        zzhh zzb = (!zzbz.zzuu.get().booleanValue() || zza.zzCm.extras.getBundle("sdk_less_server_data") == null) ? new zzb(context, zza, zzan, zza2) : new zzl(context, zza, zza2);
        zzb.zzgj();
        return zzb;
    }
}
