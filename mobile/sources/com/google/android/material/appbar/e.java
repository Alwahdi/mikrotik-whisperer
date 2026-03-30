package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

abstract class e {
    private static final int[] a = {16843848};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void c(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        Context context = view.getContext();
        TypedArray a2 = vq0.i(context, attrs, a, defStyleAttr, defStyleRes, new int[0]);
        try {
            if (a2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a2.getResourceId(0, 0)));
            }
        } finally {
            a2.recycle();
        }
    }

    static void b(View view, float elevation) {
        int dur = view.getResources().getInteger(lc0.app_bar_elevation_anim_duration);
        StateListAnimator sla = new StateListAnimator();
        sla.addState(new int[]{16842910, yb0.state_liftable, -yb0.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration((long) dur));
        sla.addState(new int[]{16842910}, ObjectAnimator.ofFloat(view, "elevation", new float[]{elevation}).setDuration((long) dur));
        sla.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(sla);
    }
}
