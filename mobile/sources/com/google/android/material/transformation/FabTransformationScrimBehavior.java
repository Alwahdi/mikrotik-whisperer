package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {
    private final h20 a = new h20(75, 150);
    private final h20 b = new h20(0, 150);

    public FabTransformationScrimBehavior() {
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof FloatingActionButton;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }

    /* access modifiers changed from: protected */
    public AnimatorSet f(View dependency, View child, boolean expanded, boolean isAnimating) {
        ArrayList arrayList = new ArrayList();
        g(child, expanded, isAnimating, arrayList, new ArrayList<>());
        AnimatorSet set = new AnimatorSet();
        g3.a(set, arrayList);
        set.addListener(new a(expanded, child));
        return set;
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f2142a;

        a(boolean z, View view) {
            this.f2142a = z;
            this.a = view;
        }

        public void onAnimationStart(Animator animation) {
            if (this.f2142a) {
                this.a.setVisibility(0);
            }
        }

        public void onAnimationEnd(Animator animation) {
            if (!this.f2142a) {
                this.a.setVisibility(4);
            }
        }
    }

    private void g(View child, boolean expanded, boolean currentlyAnimating, List<Animator> animations, List<Animator.AnimatorListener> list) {
        Animator animator;
        h20 timing = expanded ? this.a : this.b;
        if (expanded) {
            if (!currentlyAnimating) {
                child.setAlpha(0.0f);
            }
            animator = ObjectAnimator.ofFloat(child, View.ALPHA, new float[]{1.0f});
        } else {
            animator = ObjectAnimator.ofFloat(child, View.ALPHA, new float[]{0.0f});
        }
        timing.a(animator);
        animations.add(animator);
    }
}
