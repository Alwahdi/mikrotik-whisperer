package com.google.android.material.search;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    private boolean a = false;

    public SearchBar$ScrollingViewBehavior() {
    }

    public SearchBar$ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        boolean changed = super.onDependentViewChanged(parent, child, dependency);
        if (!this.a && (dependency instanceof AppBarLayout)) {
            this.a = true;
            q((AppBarLayout) dependency);
        }
        return changed;
    }

    private void q(AppBarLayout appBarLayout) {
        appBarLayout.setBackgroundColor(0);
        if (Build.VERSION.SDK_INT == 21) {
            appBarLayout.setOutlineProvider((ViewOutlineProvider) null);
        } else {
            appBarLayout.setTargetElevation(0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return true;
    }
}
