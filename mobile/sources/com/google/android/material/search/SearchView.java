package com.google.android.material.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public abstract class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior {
    public abstract boolean a();

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b6.a(view);
            return a(coordinatorLayout, (SearchView) null, view2);
        }

        public Behavior() {
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public boolean a(CoordinatorLayout parent, SearchView child, View dependency) {
            child.a();
            return false;
        }
    }
}
