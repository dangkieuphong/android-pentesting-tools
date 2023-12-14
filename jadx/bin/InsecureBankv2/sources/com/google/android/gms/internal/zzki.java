package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzki extends ImageView {
    private Uri zzZF;
    private int zzZG;
    private int zzZH;
    private zza zzZI;
    private int zzZJ;
    private float zzZK;

    public interface zza {
        Path zzk(int i, int i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.zzZI != null) {
            canvas.clipPath(this.zzZI.zzk(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzZH != 0) {
            canvas.drawColor(this.zzZH);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzZJ) {
            case 1:
                i = getMeasuredHeight();
                measuredWidth = (int) (((float) i) * this.zzZK);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i = (int) (((float) measuredWidth) / this.zzZK);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i);
    }

    public void zzbo(int i) {
        this.zzZG = i;
    }

    public void zzi(Uri uri) {
        this.zzZF = uri;
    }

    public int zznr() {
        return this.zzZG;
    }
}
