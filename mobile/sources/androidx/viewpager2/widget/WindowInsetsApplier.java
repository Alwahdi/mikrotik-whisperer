package androidx.viewpager2.widget;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public final class WindowInsetsApplier implements OnApplyWindowInsetsListener {
    private WindowInsetsApplier() {
    }

    public static boolean install(@NonNull ViewPager2 viewPager) {
        ApplicationInfo appInfo = viewPager.getContext().getApplicationInfo();
        if (Build.VERSION.SDK_INT >= 30 && appInfo.targetSdkVersion >= 30) {
            return false;
        }
        ViewCompat.setOnApplyWindowInsetsListener(viewPager, new WindowInsetsApplier());
        return true;
    }

    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(@NonNull View v, @NonNull WindowInsetsCompat insets) {
        ViewPager2 viewPager = (ViewPager2) v;
        WindowInsetsCompat applied = ViewCompat.onApplyWindowInsets(viewPager, insets);
        if (applied.isConsumed()) {
            return applied;
        }
        RecyclerView rv = viewPager.mRecyclerView;
        int count = rv.getChildCount();
        for (int i = 0; i < count; i++) {
            ViewCompat.dispatchApplyWindowInsets(rv.getChildAt(i), new WindowInsetsCompat(applied));
        }
        return consumeAllInsets(applied);
    }

    private WindowInsetsCompat consumeAllInsets(@NonNull WindowInsetsCompat insets) {
        if (Build.VERSION.SDK_INT < 21) {
            return insets;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        if (windowInsetsCompat.toWindowInsets() != null) {
            return windowInsetsCompat;
        }
        return insets.consumeSystemWindowInsets().consumeStableInsets();
    }
}
