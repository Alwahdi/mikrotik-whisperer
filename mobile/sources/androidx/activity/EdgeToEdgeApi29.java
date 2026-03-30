package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

@RequiresApi(29)
final class EdgeToEdgeApi29 implements EdgeToEdgeImpl {
    @DoNotInline
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        lu.f(statusBarStyle, "statusBarStyle");
        lu.f(navigationBarStyle, "navigationBarStyle");
        lu.f(window, "window");
        lu.f(view, "view");
        boolean z = false;
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrimWithEnforcedContrast$activity_release(statusBarIsDark));
        window.setNavigationBarColor(navigationBarStyle.getScrimWithEnforcedContrast$activity_release(navigationBarIsDark));
        window.setStatusBarContrastEnforced(false);
        if (navigationBarStyle.getNightMode$activity_release() == 0) {
            z = true;
        }
        window.setNavigationBarContrastEnforced(z);
        WindowInsetsControllerCompat $this$setUp_u24lambda_u240 = new WindowInsetsControllerCompat(window, view);
        $this$setUp_u24lambda_u240.setAppearanceLightStatusBars(!statusBarIsDark);
        $this$setUp_u24lambda_u240.setAppearanceLightNavigationBars(!navigationBarIsDark);
    }
}
