package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;

public abstract class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int h = uc0.Widget_MaterialComponents_BottomAppBar;
    private static final int i = yb0.motionDurationLong2;
    private static final int j = yb0.motionEasingEmphasizedInterpolator;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    AnimatorListenerAdapter f1486a;

    /* renamed from: a  reason: collision with other field name */
    private final p00 f1487a;

    /* renamed from: a  reason: collision with other field name */
    zr0<FloatingActionButton> f1488a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1489a;
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */
    public final int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public abstract boolean p();

    /* access modifiers changed from: package-private */
    public abstract void u(float f2);

    /* access modifiers changed from: package-private */
    public abstract boolean v(int i2);

    /* access modifiers changed from: private */
    public static void w(BottomAppBar bar, View fab) {
        CoordinatorLayout.LayoutParams fabLayoutParams = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        fabLayoutParams.anchorGravity = 17;
        int i2 = bar.b;
        if (i2 == 1) {
            fabLayoutParams.anchorGravity = 17 | 48;
        }
        if (i2 == 0) {
            fabLayoutParams.anchorGravity |= 80;
        }
    }

    /* access modifiers changed from: private */
    public View l() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View v : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if (v instanceof FloatingActionButton) {
                return v;
            }
        }
        return null;
    }

    private float o(int fabAlignmentMode) {
        int totalEndInset;
        boolean isRtl = lv0.g(this);
        int i2 = 1;
        if (fabAlignmentMode != 1) {
            return 0.0f;
        }
        View fab = l();
        int totalEndInset2 = isRtl ? this.g : this.f;
        if (this.d == -1 || fab == null) {
            totalEndInset = totalEndInset2 + this.c;
        } else {
            totalEndInset = totalEndInset2 + (fab.getMeasuredWidth() / 2) + this.d;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - totalEndInset;
        if (isRtl) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    private float n() {
        return o(this.a);
    }

    private a s() {
        b6.a(this.f1487a.B().p());
        return null;
    }

    /* access modifiers changed from: private */
    public void t() {
        s().c(n());
        throw null;
    }

    /* access modifiers changed from: private */
    public void k(FloatingActionButton fab) {
        fab.e(this.f1486a);
        fab.f(new a(this));
        fab.g(this.f1488a);
    }

    class a extends AnimatorListenerAdapter {
        a(BottomAppBar this$0) {
        }

        public void onAnimationStart(Animator animation) {
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public int m() {
        return this.e;
    }

    /* access modifiers changed from: private */
    public int r() {
        return this.f;
    }

    /* access modifiers changed from: private */
    public int q() {
        return this.g;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */
        public final Rect a = new Rect();

        /* renamed from: a  reason: collision with other field name */
        private final View.OnLayoutChangeListener f1490a = new a();
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<BottomAppBar> f1491a;
        /* access modifiers changed from: private */
        public int i;

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i2) {
            b6.a(view);
            return m(coordinatorLayout, (BottomAppBar) null, i2);
        }

        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
            b6.a(view);
            return n(coordinatorLayout, (BottomAppBar) null, view2, view3, i2, i3);
        }

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                View view = v;
                BottomAppBar child = (BottomAppBar) Behavior.this.f1491a.get();
                if (child == null || !(view instanceof FloatingActionButton)) {
                    v.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = v.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton fab = (FloatingActionButton) view;
                    fab.i(Behavior.this.a);
                    height = Behavior.this.a.height();
                    child.v(height);
                    child.u(fab.getShapeAppearanceModel().r().a(new RectF(Behavior.this.a)));
                }
                CoordinatorLayout.LayoutParams fabLayoutParams = (CoordinatorLayout.LayoutParams) v.getLayoutParams();
                if (Behavior.this.i == 0) {
                    if (child.b == 1) {
                        fabLayoutParams.bottomMargin = child.m() + (child.getResources().getDimensionPixelOffset(cc0.mtrl_bottomappbar_fab_bottom_margin) - ((v.getMeasuredHeight() - height) / 2));
                    }
                    fabLayoutParams.leftMargin = child.q();
                    fabLayoutParams.rightMargin = child.r();
                    if (lv0.g(v)) {
                        fabLayoutParams.leftMargin += child.c;
                    } else {
                        fabLayoutParams.rightMargin += child.c;
                    }
                }
                child.t();
            }
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public boolean m(CoordinatorLayout parent, BottomAppBar child, int layoutDirection) {
            this.f1491a = new WeakReference<>(child);
            View dependentView = child.l();
            if (dependentView != null && !ViewCompat.isLaidOut(dependentView)) {
                BottomAppBar.w(child, dependentView);
                this.i = ((CoordinatorLayout.LayoutParams) dependentView.getLayoutParams()).bottomMargin;
                if (dependentView instanceof FloatingActionButton) {
                    FloatingActionButton fab = (FloatingActionButton) dependentView;
                    if (child.b == 0 && child.f1489a) {
                        ViewCompat.setElevation(fab, 0.0f);
                        fab.setCompatElevation(0.0f);
                    }
                    if (fab.getShowMotionSpec() == null) {
                        fab.setShowMotionSpecResource(xb0.mtrl_fab_show_motion_spec);
                    }
                    if (fab.getHideMotionSpec() == null) {
                        fab.setHideMotionSpecResource(xb0.mtrl_fab_hide_motion_spec);
                    }
                    child.k(fab);
                }
                dependentView.addOnLayoutChangeListener(this.f1490a);
                child.t();
            }
            parent.onLayoutChild(child, layoutDirection);
            return super.onLayoutChild(parent, child, layoutDirection);
        }

        public boolean n(CoordinatorLayout coordinatorLayout, BottomAppBar child, View directTargetChild, View target, int axes, int type) {
            return child.p() && super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        }
    }
}
