package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

class a extends c {
    a() {
    }

    private static float f(float fraction) {
        return (float) Math.sin((((double) fraction) * 3.141592653589793d) / 2.0d);
    }

    private static float e(float fraction) {
        return (float) (1.0d - Math.cos((((double) fraction) * 3.141592653589793d) / 2.0d));
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View startTitle, View endTitle, float offset, Drawable indicator) {
        float rightFraction;
        float leftFraction;
        RectF startIndicator = c.a(tabLayout, startTitle);
        RectF endIndicator = c.a(tabLayout, endTitle);
        if (startIndicator.left < endIndicator.left) {
            leftFraction = e(offset);
            rightFraction = f(offset);
        } else {
            leftFraction = f(offset);
            rightFraction = e(offset);
        }
        indicator.setBounds(f3.c((int) startIndicator.left, (int) endIndicator.left, leftFraction), indicator.getBounds().top, f3.c((int) startIndicator.right, (int) endIndicator.right, rightFraction), indicator.getBounds().bottom);
    }
}
