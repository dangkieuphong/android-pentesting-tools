package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.util.AttributeSet;
import android.widget.RatingBar;
import com.google.android.gms.search.SearchAuth;

public class AppCompatRatingBar extends RatingBar {
    private static final int[] TINT_ATTRS = {16843067, 16843068};
    private Bitmap mSampleTile;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (TintManager.SHOULD_BE_USED) {
            TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, TINT_ATTRS, defStyleAttr, 0);
            Drawable drawable = a.getDrawableIfKnown(0);
            if (drawable != null) {
                setIndeterminateDrawable(tileifyIndeterminate(drawable));
            }
            Drawable drawable2 = a.getDrawableIfKnown(1);
            if (drawable2 != null) {
                setProgressDrawable(tileify(drawable2, false));
            }
            a.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.graphics.drawable.ClipDrawable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable tileify(android.graphics.drawable.Drawable r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatRatingBar.tileify(android.graphics.drawable.Drawable, boolean):android.graphics.drawable.Drawable");
    }

    private Drawable tileifyIndeterminate(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable background = (AnimationDrawable) drawable;
        int N = background.getNumberOfFrames();
        AnimationDrawable newBg = new AnimationDrawable();
        newBg.setOneShot(background.isOneShot());
        for (int i = 0; i < N; i++) {
            Drawable frame = tileify(background.getFrame(i), true);
            frame.setLevel(SearchAuth.StatusCodes.AUTH_DISABLED);
            newBg.addFrame(frame, background.getDuration(i));
        }
        newBg.setLevel(SearchAuth.StatusCodes.AUTH_DISABLED);
        return newBg;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.mSampleTile != null) {
            setMeasuredDimension(ViewCompat.resolveSizeAndState(this.mSampleTile.getWidth() * getNumStars(), widthMeasureSpec, 0), getMeasuredHeight());
        }
    }
}
