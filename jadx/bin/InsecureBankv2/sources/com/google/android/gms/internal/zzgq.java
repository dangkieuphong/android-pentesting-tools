package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzgq extends zzhh implements zzgr, zzgu {
    private final Context mContext;
    private final zzha.zza zzBs;
    private int zzBv = 3;
    private final String zzEO;
    private final zzgp zzEV;
    private final zzgu zzEW;
    private final String zzEX;
    private int zzEY = 0;
    private final Object zzqt;
    private final String zzxQ;

    public zzgq(Context context, String str, String str2, String str3, zzha.zza zza, zzgp zzgp, zzgu zzgu) {
        this.mContext = context;
        this.zzxQ = str;
        this.zzEO = str2;
        this.zzEX = str3;
        this.zzBs = zza;
        this.zzEV = zzgp;
        this.zzqt = new Object();
        this.zzEW = zzgu;
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzqt) {
                if (this.zzEY == 0) {
                    if (!zze(j)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzgr
    public void zzI(int i) {
        zzb(this.zzxQ, 0);
    }

    @Override // com.google.android.gms.internal.zzgu
    public void zzap(String str) {
        synchronized (this.zzqt) {
            this.zzEY = 1;
            this.zzqt.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzgu
    public void zzb(String str, int i) {
        synchronized (this.zzqt) {
            this.zzEY = 2;
            this.zzBv = i;
            this.zzqt.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        if (this.zzEV != null && this.zzEV.zzfN() != null && this.zzEV.zzfM() != null) {
            final zzgt zzfN = this.zzEV.zzfN();
            zzfN.zza((zzgu) this);
            zzfN.zza((zzgr) this);
            final AdRequestParcel adRequestParcel = this.zzBs.zzFr.zzCm;
            final zzeg zzfM = this.zzEV.zzfM();
            try {
                if (zzfM.isInitialized()) {
                    zza.zzGF.post(new Runnable() {
                        /* class com.google.android.gms.internal.zzgq.AnonymousClass1 */

                        public void run() {
                            try {
                                zzfM.zza(adRequestParcel, zzgq.this.zzEX);
                            } catch (RemoteException e) {
                                zzb.zzd("Fail to load ad from adapter.", e);
                                zzgq.this.zzb(zzgq.this.zzxQ, 0);
                            }
                        }
                    });
                } else {
                    zza.zzGF.post(new Runnable() {
                        /* class com.google.android.gms.internal.zzgq.AnonymousClass2 */

                        public void run() {
                            try {
                                zzfM.zza(zze.zzw(zzgq.this.mContext), adRequestParcel, zzgq.this.zzEO, zzfN, zzgq.this.zzEX);
                            } catch (RemoteException e) {
                                zzb.zzd("Fail to initialize adapter " + zzgq.this.zzxQ, e);
                                zzgq.this.zzb(zzgq.this.zzxQ, 0);
                            }
                        }
                    });
                }
            } catch (RemoteException e) {
                zzb.zzd("Fail to check if adapter is initialized.", e);
                zzb(this.zzxQ, 0);
            }
            zzk(zzo.zzbz().elapsedRealtime());
            zzfN.zza((zzgu) null);
            zzfN.zza((zzgr) null);
            if (this.zzEY == 1) {
                this.zzEW.zzap(this.zzxQ);
            } else {
                this.zzEW.zzb(this.zzxQ, this.zzBv);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean zze(long j) {
        long elapsedRealtime = 20000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzgr
    public void zzfO() {
        this.zzEV.zzfN();
        AdRequestParcel adRequestParcel = this.zzBs.zzFr.zzCm;
        try {
            this.zzEV.zzfM().zza(adRequestParcel, this.zzEX);
        } catch (RemoteException e) {
            zzb.zzd("Fail to load ad from adapter.", e);
            zzb(this.zzxQ, 0);
        }
    }
}
