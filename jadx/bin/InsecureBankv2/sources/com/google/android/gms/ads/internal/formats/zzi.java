package com.google.android.gms.ads.internal.formats;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzhz;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class zzi extends zzcm.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final FrameLayout zznV;
    private final Object zzqt = new Object();
    private final FrameLayout zzvF;
    private final Map<String, WeakReference<View>> zzvG = new HashMap();
    private zzb zzvH;
    private zzg zzvq;

    public zzi(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzvF = frameLayout;
        this.zznV = frameLayout2;
        zzhz.zza((View) this.zzvF, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzhz.zza((View) this.zzvF, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzvF.setOnTouchListener(this);
    }

    private String zzi(View view) {
        synchronized (this.zzqt) {
            if (this.zzvH != null && this.zzvH.zzdv().equals(view)) {
                return "1007";
            }
            for (Map.Entry<String, WeakReference<View>> entry : this.zzvG.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }

    public void onClick(View view) {
        synchronized (this.zzqt) {
            if (this.zzvq != null) {
                String zzi = zzi(view);
                if (zzi != null) {
                    this.zzvq.performClick(zzi);
                }
            }
        }
    }

    public void onGlobalLayout() {
        synchronized (this.zzqt) {
            if (this.zzvq != null) {
                this.zzvq.zzh(this.zzvF);
            }
        }
    }

    public void onScrollChanged() {
        synchronized (this.zzqt) {
            if (this.zzvq != null) {
                this.zzvq.zzh(this.zzvF);
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        synchronized (this.zzqt) {
            if (this.zzvq == null) {
                z = false;
            } else {
                this.zzvq.zzb(motionEvent);
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.zzcm
    public zzd zzS(String str) {
        zzd zzw;
        synchronized (this.zzqt) {
            WeakReference<View> weakReference = this.zzvG.get(str);
            zzw = zze.zzw(weakReference == null ? null : weakReference.get());
        }
        return zzw;
    }

    @Override // com.google.android.gms.internal.zzcm
    public void zza(String str, zzd zzd) {
        View view = (View) zze.zzn(zzd);
        synchronized (this.zzqt) {
            if (view == null) {
                this.zzvG.remove(str);
            } else {
                this.zzvG.put(str, new WeakReference<>(view));
                view.setOnClickListener(this);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcm
    public void zzb(zzd zzd) {
        synchronized (this.zzqt) {
            this.zzvq = (zzg) zze.zzn(zzd);
            this.zznV.removeAllViews();
            this.zzvH = zzdI();
            if (this.zzvH != null) {
                this.zznV.addView(this.zzvH);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzb zzdI() {
        return this.zzvq.zza(this);
    }
}
