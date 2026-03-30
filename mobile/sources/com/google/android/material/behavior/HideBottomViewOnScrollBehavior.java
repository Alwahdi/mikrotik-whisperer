package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int f = yb0.motionDurationLong2;
    private static final int g = yb0.motionDurationMedium4;
    private static final int h = yb0.motionEasingEmphasizedInterpolator;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private TimeInterpolator f1472a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ViewPropertyAnimator f1473a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<b> f1474a = new LinkedHashSet<>();
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private TimeInterpolator f1475b;
    private int c = 0;
    private int d = 2;
    private int e = 0;

    public interface b {
        void a(View view, int i);
    }

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        this.c = child.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) child.getLayoutParams()).bottomMargin;
        this.a = i20.f(child.getContext(), f, 225);
        this.b = i20.f(child.getContext(), g, 175);
        Context context = child.getContext();
        int i = h;
        this.f1472a = i20.g(context, i, f3.d);
        this.f1475b = i20.g(child.getContext(), i, f3.c);
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View directTargetChild, View target, int nestedScrollAxes, int type) {
        return nestedScrollAxes == 2;
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        if (dyConsumed > 0) {
            e(child);
        } else if (dyConsumed < 0) {
            g(child);
        }
    }

    public boolean d() {
        return this.d == 2;
    }

    public void g(V child) {
        h(child, true);
    }

    public void h(V child, boolean animate) {
        if (!d()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f1473a;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                child.clearAnimation();
            }
            i(child, 2);
            if (animate) {
                b(child, 0, (long) this.a, this.f1472a);
                return;
            }
            child.setTranslationY((float) 0);
        }
    }

    public boolean c() {
        return this.d == 1;
    }

    public void e(V child) {
        f(child, true);
    }

    public void f(V child, boolean animate) {
        if (!c()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f1473a;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                child.clearAnimation();
            }
            i(child, 1);
            int targetTranslationY = this.c + this.e;
            if (animate) {
                b(child, targetTranslationY, (long) this.b, this.f1475b);
                return;
            }
            child.setTranslationY((float) targetTranslationY);
        }
    }

    private void i(V child, int state) {
        this.d = state;
        Iterator it = this.f1474a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(child, this.d);
        }
    }

    private void b(V child, int targetY, long duration, TimeInterpolator interpolator) {
        this.f1473a = child.animate().translationY((float) targetY).setInterpolator(interpolator).setDuration(duration).setListener(new a());
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animation) {
            ViewPropertyAnimator unused = HideBottomViewOnScrollBehavior.this.f1473a = null;
        }
    }
}
