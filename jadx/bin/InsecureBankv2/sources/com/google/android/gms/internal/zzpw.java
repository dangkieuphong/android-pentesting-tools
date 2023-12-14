package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import java.util.HashSet;
import java.util.Set;

public class zzpw {
    private static zzpw zzaOV;
    private Context mContext;
    private boolean mStarted;
    private final Set<zza> zzaOW = new HashSet();
    private TagManager zzaOX = null;
    private zzpv zzoY;

    public interface zza {
        void zzbm();
    }

    zzpw(Context context, TagManager tagManager) {
        this.mContext = context;
        this.zzaOX = tagManager;
    }

    public static zzpw zzaK(Context context) {
        zzu.zzu(context);
        if (zzaOV == null) {
            synchronized (zzpw.class) {
                if (zzaOV == null) {
                    zzaOV = new zzpw(context, TagManager.getInstance(context.getApplicationContext()));
                }
            }
        }
        return zzaOV;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void zzgy() {
        synchronized (this) {
            for (zza zza2 : this.zzaOW) {
                zza2.zzbm();
            }
        }
    }

    public void start() throws IllegalStateException {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Method start() has already been called");
            } else if (this.zzoY == null) {
                throw new IllegalStateException("No settings configured");
            } else {
                this.mStarted = true;
                this.zzaOX.zzc(this.zzoY.zzzT(), -1, "admob").setResultCallback(new ResultCallback<ContainerHolder>() {
                    /* class com.google.android.gms.internal.zzpw.AnonymousClass1 */

                    /* renamed from: zza */
                    public void onResult(ContainerHolder containerHolder) {
                        zzpw.this.zzoY = new zzpu(zzpw.this.mContext, containerHolder.getStatus().isSuccess() ? containerHolder.getContainer() : null, zzpw.this.zzzX()).zzzR();
                        zzpw.this.zzgy();
                    }
                });
            }
        }
    }

    public void zza(zzpv zzpv) {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Settings can't be changed after TagManager has been started");
            }
            this.zzoY = zzpv;
        }
    }

    public void zza(zza zza2) {
        synchronized (this) {
            this.zzaOW.add(zza2);
        }
    }

    public zzpv zzzX() {
        zzpv zzpv;
        synchronized (this) {
            zzpv = this.zzoY;
        }
        return zzpv;
    }
}
