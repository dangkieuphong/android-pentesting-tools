package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;

/* access modifiers changed from: package-private */
public class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
    DrawableWrapperHoneycomb(Drawable drawable) {
        super(drawable);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }
}
