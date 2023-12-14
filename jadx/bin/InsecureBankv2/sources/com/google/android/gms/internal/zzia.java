package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzo;
import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
public class zzia extends zzic implements ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakReference<ViewTreeObserver.OnGlobalLayoutListener> zzGZ;

    public zzia(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzGZ = new WeakReference<>(onGlobalLayoutListener);
    }

    public void onGlobalLayout() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzGZ.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzic
    public void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzic
    public void zzb(ViewTreeObserver viewTreeObserver) {
        zzo.zzbx().zza(viewTreeObserver, this);
    }
}
