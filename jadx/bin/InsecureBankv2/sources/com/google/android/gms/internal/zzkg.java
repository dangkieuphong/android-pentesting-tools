package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

public final class zzkg extends Drawable implements Drawable.Callback {
    private int mFrom;
    private long zzKT;
    private int zzZA;
    private boolean zzZh;
    private int zzZo;
    private int zzZp;
    private int zzZq;
    private int zzZr;
    private int zzZs;
    private boolean zzZt;
    private zzb zzZu;
    private Drawable zzZv;
    private Drawable zzZw;
    private boolean zzZx;
    private boolean zzZy;
    private boolean zzZz;

    private static final class zza extends Drawable {
        private static final zza zzZB = new zza();
        private static final C0104zza zzZC = new C0104zza();

        /* renamed from: com.google.android.gms.internal.zzkg$zza$zza  reason: collision with other inner class name */
        private static final class C0104zza extends Drawable.ConstantState {
            private C0104zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzZB;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return zzZC;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zzb extends Drawable.ConstantState {
        int zzZD;
        int zzZE;

        zzb(zzb zzb) {
            if (zzb != null) {
                this.zzZD = zzb.zzZD;
                this.zzZE = zzb.zzZE;
            }
        }

        public int getChangingConfigurations() {
            return this.zzZD;
        }

        public Drawable newDrawable() {
            return new zzkg(this);
        }
    }

    public zzkg(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zza.zzZB : drawable;
        this.zzZv = drawable;
        drawable.setCallback(this);
        this.zzZu.zzZE |= drawable.getChangingConfigurations();
        drawable2 = drawable2 == null ? zza.zzZB : drawable2;
        this.zzZw = drawable2;
        drawable2.setCallback(this);
        this.zzZu.zzZE |= drawable2.getChangingConfigurations();
    }

    zzkg(zzb zzb2) {
        this.zzZo = 0;
        this.zzZq = 255;
        this.zzZs = 0;
        this.zzZh = true;
        this.zzZu = new zzb(zzb2);
    }

    public boolean canConstantState() {
        if (!this.zzZx) {
            this.zzZy = (this.zzZv.getConstantState() == null || this.zzZw.getConstantState() == null) ? false : true;
            this.zzZx = true;
        }
        return this.zzZy;
    }

    public void draw(Canvas canvas) {
        boolean z = true;
        boolean z2 = false;
        switch (this.zzZo) {
            case 1:
                this.zzKT = SystemClock.uptimeMillis();
                this.zzZo = 2;
                break;
            case 2:
                if (this.zzKT >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzKT)) / ((float) this.zzZr);
                    if (uptimeMillis < 1.0f) {
                        z = false;
                    }
                    if (z) {
                        this.zzZo = 0;
                    }
                    this.zzZs = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.zzZp - this.mFrom))) + ((float) this.mFrom));
                }
            default:
                z2 = z;
                break;
        }
        int i = this.zzZs;
        boolean z3 = this.zzZh;
        Drawable drawable = this.zzZv;
        Drawable drawable2 = this.zzZw;
        if (z2) {
            if (!z3 || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzZq) {
                drawable2.setAlpha(this.zzZq);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.zzZq - i);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.zzZq);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzZq);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.zzZu.zzZD | this.zzZu.zzZE;
    }

    public Drawable.ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzZu.zzZD = getChangingConfigurations();
        return this.zzZu;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzZv.getIntrinsicHeight(), this.zzZw.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzZv.getIntrinsicWidth(), this.zzZw.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzZz) {
            this.zzZA = Drawable.resolveOpacity(this.zzZv.getOpacity(), this.zzZw.getOpacity());
            this.zzZz = true;
        }
        return this.zzZA;
    }

    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback;
        if (zzlk.zzoR() && (callback = getCallback()) != null) {
            callback.invalidateDrawable(this);
        }
    }

    public Drawable mutate() {
        if (!this.zzZt && super.mutate() == this) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.zzZv.mutate();
            this.zzZw.mutate();
            this.zzZt = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.zzZv.setBounds(bounds);
        this.zzZw.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback;
        if (zzlk.zzoR() && (callback = getCallback()) != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void setAlpha(int alpha) {
        if (this.zzZs == this.zzZq) {
            this.zzZs = alpha;
        }
        this.zzZq = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.zzZv.setColorFilter(cf);
        this.zzZw.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.zzZp = this.zzZq;
        this.zzZs = 0;
        this.zzZr = durationMillis;
        this.zzZo = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback;
        if (zzlk.zzoR() && (callback = getCallback()) != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    public Drawable zznp() {
        return this.zzZw;
    }
}
