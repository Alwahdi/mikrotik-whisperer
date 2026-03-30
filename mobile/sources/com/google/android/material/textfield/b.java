package com.google.android.material.textfield;

import android.animation.ValueAnimator;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ f a;

    public /* synthetic */ b(f fVar) {
        this.a = fVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.E(valueAnimator);
    }
}
