package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzu;

public class CampaignTrackingService extends Service {
    private static Boolean zzIe;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.mHandler = handler2;
        return handler2;
    }

    public static boolean zzU(Context context) {
        zzu.zzu(context);
        if (zzIe != null) {
            return zzIe.booleanValue();
        }
        boolean zza = zzam.zza(context, CampaignTrackingService.class);
        zzIe = Boolean.valueOf(zza);
        return zza;
    }

    private void zzhd() {
        try {
            synchronized (CampaignTrackingReceiver.zzoW) {
                PowerManager.WakeLock wakeLock = CampaignTrackingReceiver.zzIc;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        zzf.zzV(this).zzhQ().zzaT("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        zzf.zzV(this).zzhQ().zzaT("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzhd();
        zzf zzV = zzf.zzV(this);
        final zzaf zzhQ = zzV.zzhQ();
        String str = null;
        if (zzV.zzhR().zziW()) {
            zzhQ.zzaX("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(str)) {
            if (!zzV.zzhR().zziW()) {
                zzhQ.zzaW("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzV.zzhS().zze(new Runnable() {
                /* class com.google.android.gms.analytics.CampaignTrackingService.AnonymousClass1 */

                public void run() {
                    CampaignTrackingService.this.zza(zzhQ, handler, startId);
                }
            });
        } else {
            int zzja = zzV.zzhR().zzja();
            if (str.length() > zzja) {
                zzhQ.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(zzja));
                str = str.substring(0, zzja);
            }
            zzhQ.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(startId), str);
            zzV.zzhl().zza(str, (Runnable) new Runnable() {
                /* class com.google.android.gms.analytics.CampaignTrackingService.AnonymousClass2 */

                public void run() {
                    CampaignTrackingService.this.zza(zzhQ, handler, startId);
                }
            });
        }
        return 2;
    }

    /* access modifiers changed from: protected */
    public void zza(final zzaf zzaf, Handler handler, final int i) {
        handler.post(new Runnable() {
            /* class com.google.android.gms.analytics.CampaignTrackingService.AnonymousClass3 */

            public void run() {
                boolean stopSelfResult = CampaignTrackingService.this.stopSelfResult(i);
                if (stopSelfResult) {
                    zzaf.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }
}
