package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */
    public int a = 0;

    /* access modifiers changed from: protected */
    public abstract boolean d(View view, View view2, boolean z, boolean z2);

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        zj dep;
        if (ViewCompat.isLaidOut(child) || (dep = c(parent, child)) == null || !b(dep.a())) {
            return false;
        }
        this.a = dep.a() ? 1 : 2;
        child.getViewTreeObserver().addOnPreDrawListener(new a(child, this.a, dep));
        return false;
    }

    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ View f2131a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ zj f2133a;

        a(View view, int i, zj zjVar) {
            this.f2131a = view;
            this.a = i;
            this.f2133a = zjVar;
        }

        public boolean onPreDraw() {
            this.f2131a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.a) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                zj zjVar = this.f2133a;
                expandableBehavior.d((View) zjVar, this.f2131a, zjVar.a(), false);
            }
            return false;
        }
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        zj dep = (zj) dependency;
        if (!b(dep.a())) {
            return false;
        }
        this.a = dep.a() ? 1 : 2;
        return d((View) dep, child, dep.a(), true);
    }

    /* access modifiers changed from: protected */
    public zj c(CoordinatorLayout parent, View child) {
        List<View> dependencies = parent.getDependencies(child);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View dependency = dependencies.get(i);
            if (layoutDependsOn(parent, child, dependency)) {
                return (zj) dependency;
            }
        }
        return null;
    }

    private boolean b(boolean expanded) {
        if (expanded) {
            int i = this.a;
            if (i == 0 || i == 2) {
                return true;
            }
            return false;
        } else if (this.a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
