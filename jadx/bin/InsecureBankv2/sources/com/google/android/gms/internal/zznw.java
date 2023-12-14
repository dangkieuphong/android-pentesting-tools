package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.List;

public class zznw {
    private static final zza[] zzaEq = new zza[0];
    private static zznw zzaEr;
    private final Application zzaEs;
    private zzod zzaEt;
    private final List<zza> zzaEu = new ArrayList();
    private zzog zzaEv;

    public interface zza {
        void zza(zzod zzod);

        void zza(zzod zzod, Activity activity);
    }

    private zznw(Application application) {
        zzu.zzu(application);
        this.zzaEs = application;
    }

    public static zznw zzaC(Context context) {
        zznw zznw;
        zzu.zzu(context);
        Application application = (Application) context.getApplicationContext();
        zzu.zzu(application);
        synchronized (zznw.class) {
            if (zzaEr == null) {
                zzaEr = new zznw(application);
            }
            zznw = zzaEr;
        }
        return zznw;
    }

    private zza[] zzwh() {
        zza[] zzaArr;
        synchronized (this.zzaEu) {
            zzaArr = this.zzaEu.isEmpty() ? zzaEq : (zza[]) this.zzaEu.toArray(new zza[this.zzaEu.size()]);
        }
        return zzaArr;
    }

    public void zza(zza zza2) {
        zzu.zzu(zza2);
        synchronized (this.zzaEu) {
            this.zzaEu.remove(zza2);
            this.zzaEu.add(zza2);
        }
    }

    public void zzaf(boolean z) {
        if (Build.VERSION.SDK_INT < 14) {
            Log.i("com.google.android.gms.measurement.ScreenViewService", "AutoScreeViewTracking is not supported on API 14 or earlier devices");
        } else if (zzwg() == z) {
        } else {
            if (z) {
                this.zzaEv = new zzog(this);
                this.zzaEs.registerActivityLifecycleCallbacks(this.zzaEv);
                return;
            }
            this.zzaEs.unregisterActivityLifecycleCallbacks(this.zzaEv);
            this.zzaEv = null;
        }
    }

    public void zzb(zzod zzod, Activity activity) {
        zzu.zzu(zzod);
        zza[] zzaArr = null;
        if (zzod.isMutable()) {
            if (activity instanceof zznv) {
                ((zznv) activity).zzb(zzod);
            }
            if (this.zzaEt != null) {
                zzod.zzhL(this.zzaEt.zzbn());
                zzod.zzdJ(this.zzaEt.zzwB());
            }
            zza[] zzwh = zzwh();
            for (zza zza2 : zzwh) {
                zza2.zza(zzod, activity);
            }
            zzod.zzwF();
            if (!TextUtils.isEmpty(zzod.zzwB())) {
                zzaArr = zzwh;
            } else {
                return;
            }
        }
        if (this.zzaEt == null || this.zzaEt.zzbn() != zzod.zzbn()) {
            zzwf();
            this.zzaEt = zzod;
            if (zzaArr == null) {
                zzaArr = zzwh();
            }
            for (zza zza3 : zzaArr) {
                zza3.zza(zzod);
            }
            return;
        }
        this.zzaEt = zzod;
    }

    public zzod zzwe() {
        return this.zzaEt;
    }

    public void zzwf() {
        this.zzaEt = null;
    }

    public boolean zzwg() {
        return this.zzaEv != null;
    }
}
