package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

class DonutAnimatorCompatProvider implements AnimatorProvider {
    DonutAnimatorCompatProvider() {
    }

    @Override // android.support.v4.animation.AnimatorProvider
    public ValueAnimatorCompat emptyValueAnimator() {
        return new DonutFloatValueAnimator();
    }

    private static class DonutFloatValueAnimator implements ValueAnimatorCompat {
        private long mDuration = 200;
        private boolean mEnded = false;
        private float mFraction = 0.0f;
        List<AnimatorListenerCompat> mListeners = new ArrayList();
        private Runnable mLoopRunnable = new Runnable() {
            /* class android.support.v4.animation.DonutAnimatorCompatProvider.DonutFloatValueAnimator.AnonymousClass1 */

            public void run() {
                float fraction = (((float) (DonutFloatValueAnimator.this.getTime() - DonutFloatValueAnimator.this.mStartTime)) * 1.0f) / ((float) DonutFloatValueAnimator.this.mDuration);
                if (fraction > 1.0f || DonutFloatValueAnimator.this.mTarget.getParent() == null) {
                    fraction = 1.0f;
                }
                DonutFloatValueAnimator.this.mFraction = fraction;
                DonutFloatValueAnimator.this.notifyUpdateListeners();
                if (DonutFloatValueAnimator.this.mFraction >= 1.0f) {
                    DonutFloatValueAnimator.this.dispatchEnd();
                } else {
                    DonutFloatValueAnimator.this.mTarget.postDelayed(DonutFloatValueAnimator.this.mLoopRunnable, 16);
                }
            }
        };
        private long mStartTime;
        private boolean mStarted = false;
        View mTarget;
        List<AnimatorUpdateListenerCompat> mUpdateListeners = new ArrayList();

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void notifyUpdateListeners() {
            for (int i = this.mUpdateListeners.size() - 1; i >= 0; i--) {
                this.mUpdateListeners.get(i).onAnimationUpdate(this);
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setTarget(View view) {
            this.mTarget = view;
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addListener(AnimatorListenerCompat listener) {
            this.mListeners.add(listener);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void setDuration(long duration) {
            if (!this.mStarted) {
                this.mDuration = duration;
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                dispatchStart();
                this.mFraction = 0.0f;
                this.mStartTime = getTime();
                this.mTarget.postDelayed(this.mLoopRunnable, 16);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private long getTime() {
            return this.mTarget.getDrawingTime();
        }

        private void dispatchStart() {
            for (int i = this.mListeners.size() - 1; i >= 0; i--) {
                this.mListeners.get(i).onAnimationStart(this);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void dispatchEnd() {
            for (int i = this.mListeners.size() - 1; i >= 0; i--) {
                this.mListeners.get(i).onAnimationEnd(this);
            }
        }

        private void dispatchCancel() {
            for (int i = this.mListeners.size() - 1; i >= 0; i--) {
                this.mListeners.get(i).onAnimationCancel(this);
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void cancel() {
            if (!this.mEnded) {
                this.mEnded = true;
                if (this.mStarted) {
                    dispatchCancel();
                }
                dispatchEnd();
            }
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public void addUpdateListener(AnimatorUpdateListenerCompat animatorUpdateListener) {
            this.mUpdateListeners.add(animatorUpdateListener);
        }

        @Override // android.support.v4.animation.ValueAnimatorCompat
        public float getAnimatedFraction() {
            return this.mFraction;
        }
    }
}
