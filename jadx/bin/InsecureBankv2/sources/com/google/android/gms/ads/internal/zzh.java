package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzkw;
import java.util.ArrayList;
import java.util.List;

@zzgd
public class zzh extends zzo.zza {
    private final Context mContext;
    private final zzn zzoE;
    private final zzcu zzoF;
    private final zzcv zzoG;
    private final zzkw<String, zzcx> zzoH;
    private final zzkw<String, zzcw> zzoI;
    private final NativeAdOptionsParcel zzoJ;
    private final List<String> zzoK = zzbg();
    private final String zzoL;
    private final VersionInfoParcel zzoM;
    private final zzef zzoq;

    zzh(Context context, String str, zzef zzef, VersionInfoParcel versionInfoParcel, zzn zzn, zzcu zzcu, zzcv zzcv, zzkw<String, zzcx> zzkw, zzkw<String, zzcw> zzkw2, NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.mContext = context;
        this.zzoL = str;
        this.zzoq = zzef;
        this.zzoM = versionInfoParcel;
        this.zzoE = zzn;
        this.zzoG = zzcv;
        this.zzoF = zzcu;
        this.zzoH = zzkw;
        this.zzoI = zzkw2;
        this.zzoJ = nativeAdOptionsParcel;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<String> zzbg() {
        ArrayList arrayList = new ArrayList();
        if (this.zzoG != null) {
            arrayList.add("1");
        }
        if (this.zzoF != null) {
            arrayList.add("2");
        }
        if (this.zzoH.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        zzhl.zzGk.post(runnable);
    }

    /* access modifiers changed from: protected */
    public zzm zzbh() {
        return new zzm(this.mContext, AdSizeParcel.zzs(this.mContext), this.zzoL, this.zzoq, this.zzoM);
    }

    @Override // com.google.android.gms.ads.internal.client.zzo
    public void zze(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable() {
            /* class com.google.android.gms.ads.internal.zzh.AnonymousClass1 */

            public void run() {
                zzm zzbh = zzh.this.zzbh();
                zzbh.zzb(zzh.this.zzoF);
                zzbh.zzb(zzh.this.zzoG);
                zzbh.zza(zzh.this.zzoH);
                zzbh.zza(zzh.this.zzoE);
                zzbh.zzb(zzh.this.zzoI);
                zzbh.zza(zzh.this.zzbg());
                zzbh.zzb(zzh.this.zzoJ);
                zzbh.zza(adRequestParcel);
            }
        });
    }
}
