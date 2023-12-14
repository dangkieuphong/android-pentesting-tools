package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkj;
import java.lang.ref.WeakReference;

public abstract class zza {
    final C0028zza zzZc;
    protected int zzZd = 0;
    protected int zzZe = 0;
    protected boolean zzZf = false;
    protected ImageManager.OnImageLoadedListener zzZg;
    private boolean zzZh = true;
    private boolean zzZi = false;
    private boolean zzZj = true;
    protected int zzZk;

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.gms.common.images.zza$zza  reason: collision with other inner class name */
    public static final class C0028zza {
        public final Uri uri;

        public C0028zza(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0028zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzt.equal(((C0028zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzt.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzZl;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzq(imageView);
            this.zzZl = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzq(imageView);
            this.zzZl = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzki)) {
                int zznr = ((zzki) imageView).zznr();
                if (this.zzZe != 0 && zznr == this.zzZe) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            Drawable newDrawable = (!this.zzZf || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzb) {
                newDrawable = zza(imageView.getDrawable(), newDrawable);
            }
            imageView.setImageDrawable(newDrawable);
            if (imageView instanceof zzki) {
                zzki zzki = (zzki) imageView;
                zzki.zzi(z3 ? this.zzZc.uri : null);
                zzki.zzbo(z4 ? this.zzZe : 0);
            }
            if (zzb) {
                ((zzkg) newDrawable).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = this.zzZl.get();
            ImageView imageView2 = ((zzb) obj).zzZl.get();
            return (imageView2 == null || imageView == null || !zzt.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.images.zza
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = this.zzZl.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<ImageManager.OnImageLoadedListener> zzZm;

        public zzc(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzq(onImageLoadedListener);
            this.zzZm = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzZm.get();
            ImageManager.OnImageLoadedListener onImageLoadedListener2 = zzc.zzZm.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzt.equal(onImageLoadedListener2, onImageLoadedListener) && zzt.equal(zzc.zzZc, this.zzZc);
        }

        public int hashCode() {
            return zzt.hashCode(this.zzZc);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.images.zza
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            if (!z2 && (onImageLoadedListener = this.zzZm.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.zzZc.uri, drawable, z3);
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzZc = new C0028zza(uri);
        this.zzZe = i;
    }

    private Drawable zza(Context context, zzkj zzkj, int i) {
        Resources resources = context.getResources();
        if (this.zzZk <= 0) {
            return resources.getDrawable(i);
        }
        zzkj.zza zza = new zzkj.zza(i, this.zzZk);
        Drawable drawable = (Drawable) zzkj.get(zza);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.zzZk & 1) != 0) {
            drawable2 = zza(resources, drawable2);
        }
        zzkj.put(zza, drawable2);
        return drawable2;
    }

    /* access modifiers changed from: protected */
    public Drawable zza(Resources resources, Drawable drawable) {
        return zzkh.zza(resources, drawable);
    }

    /* access modifiers changed from: protected */
    public zzkg zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzkg) {
            drawable = ((zzkg) drawable).zznp();
        }
        return new zzkg(drawable, drawable2);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzq(bitmap);
        if ((this.zzZk & 1) != 0) {
            bitmap = zzkh.zza(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzZg != null) {
            this.zzZg.onImageLoaded(this.zzZc.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzkj zzkj) {
        if (this.zzZj) {
            Drawable drawable = null;
            if (this.zzZd != 0) {
                drawable = zza(context, zzkj, this.zzZd);
            }
            zza(drawable, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(Context context, zzkj zzkj, boolean z) {
        Drawable drawable = null;
        if (this.zzZe != 0) {
            drawable = zza(context, zzkj, this.zzZe);
        }
        if (this.zzZg != null) {
            this.zzZg.onImageLoaded(this.zzZc.uri, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public boolean zzb(boolean z, boolean z2) {
        return this.zzZh && !z2 && (!z || this.zzZi);
    }

    public void zzbm(int i) {
        this.zzZe = i;
    }
}
