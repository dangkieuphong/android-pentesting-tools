package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;

@zzgd
public class zzfv extends zzfu {
    private Object zzBx = new Object();
    private PopupWindow zzBy;
    private boolean zzBz = false;

    zzfv(Context context, zzha.zza zza, zzid zzid, zzft.zza zza2) {
        super(context, zza, zzid, zza2);
    }

    private void zzfo() {
        synchronized (this.zzBx) {
            this.zzBz = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzBy = null;
            }
            if (this.zzBy != null) {
                if (this.zzBy.isShowing()) {
                    this.zzBy.dismiss();
                }
                this.zzBy = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhh, com.google.android.gms.internal.zzfp, com.google.android.gms.internal.zzfs
    public void onStop() {
        zzfo();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfu
    public void zzfn() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(this.zzoA.getWebView(), -1, -1);
            synchronized (this.zzBx) {
                if (!this.zzBz) {
                    this.zzBy = new PopupWindow((View) frameLayout, 1, 1, false);
                    this.zzBy.setOutsideTouchable(true);
                    this.zzBy.setClippingEnabled(false);
                    zzb.zzay("Displaying the 1x1 popup off the screen.");
                    try {
                        this.zzBy.showAtLocation(window.getDecorView(), 0, -1, -1);
                    } catch (Exception e) {
                        this.zzBy = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzfs
    public void zzk(zzha zzha) {
        zzfo();
        super.zzk(zzha);
    }
}
