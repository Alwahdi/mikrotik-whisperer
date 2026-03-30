package androidx.activity;

import android.view.View;
import android.view.Window;

final class EdgeToEdgeBase implements EdgeToEdgeImpl {
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        lu.f(statusBarStyle, "statusBarStyle");
        lu.f(navigationBarStyle, "navigationBarStyle");
        lu.f(window, "window");
        lu.f(view, "view");
    }
}
