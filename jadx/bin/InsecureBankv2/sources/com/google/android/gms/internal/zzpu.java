package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.tagmanager.Container;

/* access modifiers changed from: package-private */
public class zzpu {
    private final Context mContext;
    private final zzpv zzoY;

    /* access modifiers changed from: package-private */
    public static class zza implements zznw.zza {
        private final Tracker zzIq;

        zza(Tracker tracker) {
            this.zzIq = tracker;
        }

        @Override // com.google.android.gms.internal.zznw.zza
        public void zza(zzod zzod) {
            this.zzIq.setScreenName(zzod.zzwB());
            HitBuilders.ScreenViewBuilder screenViewBuilder = new HitBuilders.ScreenViewBuilder();
            screenViewBuilder.set("&a", String.valueOf(zzod.zzbn()));
            this.zzIq.send(screenViewBuilder.build());
        }

        @Override // com.google.android.gms.internal.zznw.zza
        public void zza(zzod zzod, Activity activity) {
        }
    }

    public zzpu(Context context, Container container, zzpv zzpv) {
        this.mContext = context;
        this.zzoY = zza(container, zzpv);
        zzzS();
    }

    static zzpv zza(Container container, zzpv zzpv) {
        if (container == null || container.isDefault()) {
            return zzpv;
        }
        zzpv.zza zza2 = new zzpv.zza(zzpv.zzzT());
        zza2.zzeS(container.getString("trackingId")).zzap(container.getBoolean("trackScreenViews")).zzaq(container.getBoolean("collectAdIdentifiers"));
        return zza2.zzzW();
    }

    private void zzzS() {
        if (this.zzoY.zzzU() && !TextUtils.isEmpty(this.zzoY.getTrackingId())) {
            Tracker zzeR = zzeR(this.zzoY.getTrackingId());
            zzeR.enableAdvertisingIdCollection(this.zzoY.zzzV());
            zzb(new zza(zzeR));
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(zznw.zza zza2) {
        zzu.zzu(zza2);
        zznw zzaC = zznw.zzaC(this.mContext);
        zzaC.zzaf(true);
        zzaC.zza(zza2);
    }

    /* access modifiers changed from: package-private */
    public Tracker zzeR(String str) {
        return GoogleAnalytics.getInstance(this.mContext).newTracker(str);
    }

    public zzpv zzzR() {
        return this.zzoY;
    }
}
