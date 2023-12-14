package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzgd
public class zzc extends zzhh implements ServiceConnection {
    private Context mContext;
    private boolean zzAC;
    private zzfj zzAD;
    private zzb zzAE;
    private zzh zzAF;
    private List<zzf> zzAG;
    private zzk zzAH;
    private final Object zzqt;

    public zzc(Context context, zzfj zzfj, zzk zzk) {
        this(context, zzfj, zzk, new zzb(context), zzh.zzy(context.getApplicationContext()));
    }

    zzc(Context context, zzfj zzfj, zzk zzk, zzb zzb, zzh zzh) {
        this.zzqt = new Object();
        this.zzAC = false;
        this.zzAG = null;
        this.mContext = context;
        this.zzAD = zzfj;
        this.zzAH = zzk;
        this.zzAE = zzb;
        this.zzAF = zzh;
        this.zzAG = this.zzAF.zzf(10);
    }

    private void zzd(long j) {
        do {
            if (!zze(j)) {
                zzb.zzaB("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzAC);
    }

    private boolean zze(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzb.zzaC("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.zzqt) {
            this.zzAE.zzK(service);
            zzfe();
            this.zzAC = true;
            this.zzqt.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzqt) {
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, this);
            this.zzAE.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(final zzf zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzo.zzbF();
        intent.putExtra("RESPONSE_CODE", 0);
        zzo.zzbF();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzo.zzbF();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzhl.zzGk.post(new Runnable() {
            /* class com.google.android.gms.ads.internal.purchase.zzc.AnonymousClass1 */

            public void run() {
                try {
                    if (zzc.this.zzAH.zza(zzf.zzAS, -1, intent)) {
                        zzc.this.zzAD.zza(new zzg(zzc.this.mContext, zzf.zzAT, true, -1, intent, zzf));
                    } else {
                        zzc.this.zzAD.zza(new zzg(zzc.this.mContext, zzf.zzAT, false, -1, intent, zzf));
                    }
                } catch (RemoteException e) {
                    zzb.zzaC("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        synchronized (this.zzqt) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, intent, this, 1);
            zzd(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, this);
            this.zzAE.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void zzfe() {
        if (!this.zzAG.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf zzf : this.zzAG) {
                hashMap.put(zzf.zzAT, zzf);
            }
            String str = null;
            while (true) {
                Bundle zzi = this.zzAE.zzi(this.mContext.getPackageName(), str);
                if (zzi == null || zzo.zzbF().zzb(zzi) != 0) {
                    break;
                }
                ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzi.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        String str2 = stringArrayList.get(i);
                        String str3 = stringArrayList2.get(i);
                        String str4 = stringArrayList3.get(i);
                        zzf zzf2 = (zzf) hashMap.get(str2);
                        if (zzf2.zzAS.equals(zzo.zzbF().zzai(str3))) {
                            zza(zzf2, str3, str4);
                            hashMap.remove(str2);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str5 : hashMap.keySet()) {
                this.zzAF.zza((zzf) hashMap.get(str5));
            }
        }
    }
}
