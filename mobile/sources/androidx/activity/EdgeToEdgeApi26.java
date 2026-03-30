package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

@RequiresApi(26)
final class EdgeToEdgeApi26 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        lu.f(statusBarStyle, "statusBarStyle");
        lu.f(navigationBarStyle, "navigationBarStyle");
        lu.f(window, "window");
        lu.f(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrim$activity_release(statusBarIsDark));
        window.setNavigationBarColor(navigationBarStyle.getScrim$activity_release(navigationBarIsDark));
        WindowInsetsControllerCompat $this$setUp_u24lambda_u240 = new WindowInsetsControllerCompat(window, view);
        $this$setUp_u24lambda_u240.setAppearanceLightStatusBars(!statusBarIsDark);
        $this$setUp_u24lambda_u240.setAppearanceLightNavigationBars(!navigationBarIsDark);
    }
}
