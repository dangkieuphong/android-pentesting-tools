package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;
import org.json.JSONException;

@zzgd
public class zzb extends zzhh implements zzc.zza {
    private final Context mContext;
    private final Object zzBr = new Object();
    AdResponseParcel zzBt;
    private final zza.AbstractC0012zza zzCd;
    private final AdRequestInfoParcel.zza zzCe;
    zzhh zzCf;
    Object zzqt = new Object();
    private final zzan zzvA;
    zzdy zzxn;

    /* access modifiers changed from: package-private */
    @zzgd
    public static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zza2, zzan zzan, zza.AbstractC0012zza zza3) {
        this.zzCd = zza3;
        this.mContext = context;
        this.zzCe = zza2;
        this.zzvA = zzan;
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzBr) {
            if (this.zzCf != null) {
                this.zzCf.cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzhh zzb(AdRequestInfoParcel adRequestInfoParcel) {
        return zzc.zza(this.mContext, adRequestInfoParcel, this);
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Received ad response.");
            this.zzBt = adResponseParcel;
            this.zzqt.notify();
        }
    }

    /* access modifiers changed from: protected */
    public AdSizeParcel zzc(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzBt.zzCN == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzBt.zzCN.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzBt.zzCN, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            AdSizeParcel[] adSizeParcelArr = adRequestInfoParcel.zzpN.zzso;
            for (AdSizeParcel adSizeParcel : adSizeParcelArr) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / f) : adSizeParcel.width;
                int i2 = adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / f) : adSizeParcel.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzpN.zzso);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzBt.zzCN, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzBt.zzCN, 0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d A[SYNTHETIC, Splitter:B:30:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc  */
    @Override // com.google.android.gms.internal.zzhh
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzdP() {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzb.zzdP():void");
    }

    /* access modifiers changed from: protected */
    public boolean zze(long j) throws zza {
        long elapsedRealtime = 60000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    /* access modifiers changed from: protected */
    public void zzfu() throws zza {
        if (this.zzBt.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzBt.zzCI)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzo.zzby().zza(this.mContext, this.zzBt.zzCu);
            if (this.zzBt.zzCK) {
                try {
                    this.zzxn = new zzdy(this.zzBt.zzCI);
                } catch (JSONException e) {
                    throw new zza("Could not parse mediation config: " + this.zzBt.zzCI, 0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzi(long j) throws zza {
        while (zze(j)) {
            if (this.zzBt != null) {
                synchronized (this.zzBr) {
                    this.zzCf = null;
                }
                if (this.zzBt.errorCode != -2 && this.zzBt.errorCode != -3) {
                    throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzBt.errorCode, this.zzBt.errorCode);
                }
                return;
            }
        }
        throw new zza("Timed out waiting for ad response.", 2);
    }

    /* access modifiers changed from: protected */
    public void zzw(boolean z) {
        zzo.zzby().zzA(z);
        zzbk zzD = zzo.zzby().zzD(this.mContext);
        if (zzD != null && !zzD.isAlive()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("start fetching content...");
            zzD.zzcp();
        }
    }
}
