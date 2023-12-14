package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.zzu;

public class zzv extends zzd {
    private boolean zzKW;
    private boolean zzKX;
    private AlarmManager zzKY = ((AlarmManager) getContext().getSystemService("alarm"));

    protected zzv(zzf zzf) {
        super(zzf);
    }

    private PendingIntent zzjI() {
        Intent intent = new Intent(getContext(), AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel() {
        zzia();
        this.zzKX = false;
        this.zzKY.cancel(zzjI());
    }

    public boolean zzbp() {
        return this.zzKX;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.analytics.internal.zzd
    public void zzhn() {
        ActivityInfo receiverInfo;
        try {
            this.zzKY.cancel(zzjI());
            if (zzhR().zzjf() > 0 && (receiverInfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), AnalyticsReceiver.class), 2)) != null && receiverInfo.enabled) {
                zzaT("Receiver registered. Using alarm for local dispatch.");
                this.zzKW = true;
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
    }

    public boolean zzjG() {
        return this.zzKW;
    }

    public void zzjH() {
        zzia();
        zzu.zza(zzjG(), "Receiver not registered");
        long zzjf = zzhR().zzjf();
        if (zzjf > 0) {
            cancel();
            long elapsedRealtime = zzhP().elapsedRealtime() + zzjf;
            this.zzKX = true;
            this.zzKY.setInexactRepeating(2, elapsedRealtime, 0, zzjI());
        }
    }
}
