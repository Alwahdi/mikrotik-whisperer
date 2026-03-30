package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

class b extends c {
    b() {
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View startTitle, View endTitle, float offset, Drawable indicator) {
        float alpha;
        RectF bounds = c.a(tabLayout, offset < 0.5f ? startTitle : endTitle);
        if (offset < 0.5f) {
            alpha = f3.b(1.0f, 0.0f, 0.0f, 0.5f, offset);
        } else {
            alpha = f3.b(0.0f, 1.0f, 0.5f, 1.0f, offset);
        }
        indicator.setBounds((int) bounds.left, indicator.getBounds().top, (int) bounds.right, indicator.getBounds().bottom);
        indicator.setAlpha((int) (255.0f * alpha));
    }
}
