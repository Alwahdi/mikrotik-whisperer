package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;

@RequiresApi(21)
final class EdgeToEdgeApi21 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        lu.f(statusBarStyle, "statusBarStyle");
        lu.f(navigationBarStyle, "navigationBarStyle");
        lu.f(window, "window");
        lu.f(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.addFlags(67108864);
        window.addFlags(134217728);
    }
}
