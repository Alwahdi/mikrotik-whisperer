package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class d extends ConstraintLayout {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f2127a = new c(this);

    /* renamed from: a  reason: collision with other field name */
    private p00 f2128a;

    public d(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(nc0.material_radial_view_group, this);
        ViewCompat.setBackground(this, c());
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5668d1, defStyleAttr, 0);
        this.a = a2.getDimensionPixelSize(xc0.x3, 0);
        a2.recycle();
    }

    private Drawable c() {
        p00 p00 = new p00();
        this.f2128a = p00;
        p00.T(new be0(0.5f));
        this.f2128a.V(ColorStateList.valueOf(-1));
        return this.f2128a;
    }

    public void setBackgroundColor(int color) {
        this.f2128a.V(ColorStateList.valueOf(color));
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        if (child.getId() == -1) {
            child.setId(ViewCompat.generateViewId());
        }
        i();
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        i();
    }

    private void i() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f2127a);
            handler.post(this.f2127a);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    /* access modifiers changed from: protected */
    public void h() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone((ConstraintLayout) this);
        Map<Integer, List<View>> levels = new HashMap<>();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != ic0.circle_center && !g(childAt)) {
                int level = (Integer) childAt.getTag(ic0.material_clock_level);
                if (level == null) {
                    level = 1;
                }
                if (!levels.containsKey(level)) {
                    levels.put(level, new ArrayList());
                }
                levels.get(level).add(childAt);
            }
        }
        for (Map.Entry<Integer, List<View>> entry : levels.entrySet()) {
            b(entry.getValue(), constraintSet, d(entry.getKey().intValue()));
        }
        constraintSet.applyTo(this);
    }

    private void b(List<View> views, ConstraintSet constraintSet, int leveledRadius) {
        float currentAngle = 0.0f;
        for (View view : views) {
            constraintSet.constrainCircle(view.getId(), ic0.circle_center, leveledRadius, currentAngle);
            currentAngle += 360.0f / ((float) views.size());
        }
    }

    public void f(int radius) {
        this.a = radius;
        h();
    }

    public int e() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int d(int level) {
        return level == 2 ? Math.round(((float) this.a) * 0.66f) : this.a;
    }

    private static boolean g(View child) {
        return "skip".equals(child.getTag());
    }
}
