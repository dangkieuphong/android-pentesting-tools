package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.mediarouter.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* access modifiers changed from: package-private */
public final class MediaRouterThemeHelper {
    private MediaRouterThemeHelper() {
    }

    public static Context createThemedContext(Context context) {
        return new ContextThemeWrapper(context, isLightTheme(context) ? R.style.Theme_MediaRouter_Light : R.style.Theme_MediaRouter);
    }

    public static int getThemeResource(Context context, int attr) {
        TypedValue value = new TypedValue();
        if (context.getTheme().resolveAttribute(attr, value, true)) {
            return value.resourceId;
        }
        return 0;
    }

    public static Drawable getThemeDrawable(Context context, int attr) {
        int res = getThemeResource(context, attr);
        if (res != 0) {
            return context.getResources().getDrawable(res);
        }
        return null;
    }

    private static boolean isLightTheme(Context context) {
        TypedValue value = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.isLightTheme, value, true) || value.data == 0) {
            return false;
        }
        return true;
    }
}
