package androidx.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.VisibleForTesting;

public final class EdgeToEdge {
    private static final int DefaultDarkScrim = Color.argb(128, 27, 27, 27);
    private static final int DefaultLightScrim = Color.argb(230, 255, 255, 255);
    private static EdgeToEdgeImpl Impl;

    public static final void enable(ComponentActivity componentActivity) {
        lu.f(componentActivity, "<this>");
        enable$default(componentActivity, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
    }

    public static final void enable(ComponentActivity componentActivity, SystemBarStyle systemBarStyle) {
        lu.f(componentActivity, "<this>");
        lu.f(systemBarStyle, "statusBarStyle");
        enable$default(componentActivity, systemBarStyle, (SystemBarStyle) null, 2, (Object) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static /* synthetic */ void enable$default(ComponentActivity componentActivity, SystemBarStyle systemBarStyle, SystemBarStyle systemBarStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, 0, 0, (vn) null, 4, (Object) null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = SystemBarStyle.Companion.auto$default(SystemBarStyle.Companion, DefaultLightScrim, DefaultDarkScrim, (vn) null, 4, (Object) null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final void enable(ComponentActivity $this$enableEdgeToEdge, SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle) {
        lu.f($this$enableEdgeToEdge, "<this>");
        lu.f(statusBarStyle, "statusBarStyle");
        lu.f(navigationBarStyle, "navigationBarStyle");
        View view = $this$enableEdgeToEdge.getWindow().getDecorView();
        lu.e(view, "window.decorView");
        vn<Resources, Boolean> detectDarkMode$activity_release = statusBarStyle.getDetectDarkMode$activity_release();
        Resources resources = view.getResources();
        lu.e(resources, "view.resources");
        boolean statusBarIsDark = detectDarkMode$activity_release.invoke(resources).booleanValue();
        vn<Resources, Boolean> detectDarkMode$activity_release2 = navigationBarStyle.getDetectDarkMode$activity_release();
        Resources resources2 = view.getResources();
        lu.e(resources2, "view.resources");
        boolean navigationBarIsDark = detectDarkMode$activity_release2.invoke(resources2).booleanValue();
        EdgeToEdgeImpl impl = Impl;
        if (impl == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                impl = new EdgeToEdgeApi29();
            } else if (i >= 26) {
                impl = new EdgeToEdgeApi26();
            } else if (i >= 23) {
                impl = new EdgeToEdgeApi23();
            } else {
                if (i >= 21) {
                    impl = new EdgeToEdgeApi21();
                } else {
                    impl = new EdgeToEdgeBase();
                }
                Impl = impl;
            }
        }
        Window window = $this$enableEdgeToEdge.getWindow();
        lu.e(window, "window");
        impl.setUp(statusBarStyle, navigationBarStyle, window, view, statusBarIsDark, navigationBarIsDark);
    }
}
