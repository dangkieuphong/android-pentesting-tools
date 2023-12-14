package android.support.v4.app;

import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

/* access modifiers changed from: package-private */
/* compiled from: FragmentManager */
public interface FragmentContainer {
    @Nullable
    View findViewById(@IdRes int i);

    boolean hasView();
}
