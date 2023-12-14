package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import java.util.HashMap;
import java.util.Map;

public final class zzog implements Application.ActivityLifecycleCallbacks {
    private final zznw zzaEV;
    private final Map<Activity, zzod> zzaEW = new HashMap();

    public zzog(zznw zznw) {
        zzu.zzu(zznw);
        this.zzaEV = zznw;
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Bundle bundle;
        if (savedInstanceState != null && (bundle = savedInstanceState.getBundle("com.google.android.gms.measurement.screen_view")) != null) {
            int i = bundle.getInt("id");
            if (i <= 0) {
                Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                return;
            }
            zzod zza = zza(activity, i);
            zza.setScreenName(bundle.getString("name"));
            zza.zzhL(bundle.getInt("referrer_id"));
            zza.zzdJ(bundle.getString("referrer_name"));
            zza.zzai(bundle.getBoolean("interstitial"));
            zza.zzwF();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.zzaEW.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        zzod zzod;
        if (outState != null && (zzod = this.zzaEW.get(activity)) != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("id", zzod.zzbn());
            bundle.putString("name", zzod.zzwB());
            bundle.putInt("referrer_id", zzod.zzwC());
            bundle.putString("referrer_name", zzod.zzwD());
            bundle.putBoolean("interstitial", zzod.zzwG());
            outState.putBundle("com.google.android.gms.measurement.screen_view", bundle);
        }
    }

    public void onActivityStarted(Activity activity) {
        this.zzaEV.zzb(zza(activity, 0), activity);
    }

    public void onActivityStopped(Activity activity) {
    }

    /* access modifiers changed from: package-private */
    public zzod zza(Activity activity, int i) {
        zzu.zzu(activity);
        zzod zzod = this.zzaEW.get(activity);
        if (zzod == null) {
            zzod = i == 0 ? new zzod(true) : new zzod(true, i);
            zzod.setScreenName(activity.getClass().getCanonicalName());
            this.zzaEW.put(activity, zzod);
        }
        return zzod;
    }
}
