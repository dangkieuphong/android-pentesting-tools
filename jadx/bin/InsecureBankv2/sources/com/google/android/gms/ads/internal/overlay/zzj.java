package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zzj extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzAo;
    private final zzl zzAp;

    public zzj(Context context, int i, zzl zzl) {
        super(context);
        this.zzAp = zzl;
        setOnClickListener(this);
        this.zzAo = new ImageButton(context);
        this.zzAo.setImageResource(17301527);
        this.zzAo.setBackgroundColor(0);
        this.zzAo.setOnClickListener(this);
        this.zzAo.setPadding(0, 0, 0, 0);
        this.zzAo.setContentDescription("Interstitial close button");
        int zzb = zzk.zzcA().zzb(context, i);
        addView(this.zzAo, new FrameLayout.LayoutParams(zzb, zzb, 17));
    }

    public void onClick(View view) {
        if (this.zzAp != null) {
            this.zzAp.zzes();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzAo.setVisibility(0);
        } else if (z) {
            this.zzAo.setVisibility(4);
        } else {
            this.zzAo.setVisibility(8);
        }
    }
}
