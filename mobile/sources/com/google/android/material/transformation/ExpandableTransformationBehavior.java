package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    public AnimatorSet a;

    /* access modifiers changed from: protected */
    public abstract AnimatorSet f(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* access modifiers changed from: protected */
    public boolean d(View dependency, View child, boolean expanded, boolean animated) {
        AnimatorSet animatorSet = this.a;
        boolean currentlyAnimating = animatorSet != null;
        if (currentlyAnimating) {
            animatorSet.cancel();
        }
        AnimatorSet f = f(dependency, child, expanded, currentlyAnimating);
        this.a = f;
        f.addListener(new a());
        this.a.start();
        if (!animated) {
            this.a.end();
        }
        return true;
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animation) {
            AnimatorSet unused = ExpandableTransformationBehavior.this.a = null;
        }
    }
}
