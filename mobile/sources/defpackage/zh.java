package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;

/* renamed from: zh  reason: default package */
public abstract class zh {
    public static void a(Window window, boolean edgeToEdgeEnabled, Integer statusBarOverlapBackgroundColor, Integer navigationBarOverlapBackgroundColor) {
        if (Build.VERSION.SDK_INT >= 21) {
            boolean useDefaultBackgroundColorForNavigationBar = false;
            boolean useDefaultBackgroundColorForStatusBar = statusBarOverlapBackgroundColor == null || statusBarOverlapBackgroundColor.intValue() == 0;
            if (navigationBarOverlapBackgroundColor == null || navigationBarOverlapBackgroundColor.intValue() == 0) {
                useDefaultBackgroundColorForNavigationBar = true;
            }
            if (useDefaultBackgroundColorForStatusBar || useDefaultBackgroundColorForNavigationBar) {
                int defaultBackgroundColor = k00.b(window.getContext(), 16842801, ViewCompat.MEASURED_STATE_MASK);
                if (useDefaultBackgroundColorForStatusBar) {
                    statusBarOverlapBackgroundColor = Integer.valueOf(defaultBackgroundColor);
                }
                if (useDefaultBackgroundColorForNavigationBar) {
                    navigationBarOverlapBackgroundColor = Integer.valueOf(defaultBackgroundColor);
                }
            }
            WindowCompat.setDecorFitsSystemWindows(window, !edgeToEdgeEnabled);
            int statusBarColor = c(window.getContext(), edgeToEdgeEnabled);
            int navigationBarColor = b(window.getContext(), edgeToEdgeEnabled);
            window.setStatusBarColor(statusBarColor);
            window.setNavigationBarColor(navigationBarColor);
            f(window, d(statusBarColor, k00.i(statusBarOverlapBackgroundColor.intValue())));
            e(window, d(navigationBarColor, k00.i(navigationBarOverlapBackgroundColor.intValue())));
        }
    }

    public static void f(Window window, boolean isLight) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(isLight);
    }

    public static void e(Window window, boolean isLight) {
        WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(isLight);
    }

    private static int c(Context context, boolean isEdgeToEdgeEnabled) {
        if (isEdgeToEdgeEnabled && Build.VERSION.SDK_INT < 23) {
            return ColorUtils.setAlphaComponent(k00.b(context, 16843857, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (isEdgeToEdgeEnabled) {
            return 0;
        }
        return k00.b(context, 16843857, ViewCompat.MEASURED_STATE_MASK);
    }

    private static int b(Context context, boolean isEdgeToEdgeEnabled) {
        if (isEdgeToEdgeEnabled && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.setAlphaComponent(k00.b(context, 16843858, ViewCompat.MEASURED_STATE_MASK), 128);
        }
        if (isEdgeToEdgeEnabled) {
            return 0;
        }
        return k00.b(context, 16843858, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean d(int systemBarColor, boolean isLightBackground) {
        return k00.i(systemBarColor) || (systemBarColor == 0 && isLightBackground);
    }
}
