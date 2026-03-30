package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class b extends c<View> {
    final Rect a = new Rect();
    final Rect b = new Rect();
    private int c = 0;
    private int d;

    /* access modifiers changed from: package-private */
    public abstract View d(List<View> list);

    /* access modifiers changed from: package-private */
    public abstract float f(View view);

    public b() {
    }

    public b(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onMeasureChild(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        View header;
        int availableHeight;
        int height;
        int i;
        View view = child;
        int childLpHeight = child.getLayoutParams().height;
        if ((childLpHeight != -1 && childLpHeight != -2) || (header = d(parent.getDependencies(child))) == null) {
            return false;
        }
        int availableHeight2 = View.MeasureSpec.getSize(parentHeightMeasureSpec);
        if (availableHeight2 <= 0) {
            availableHeight = parent.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(header)) {
            WindowInsetsCompat parentInsets = parent.getLastWindowInsets();
            if (parentInsets != null) {
                availableHeight2 += parentInsets.getSystemWindowInsetTop() + parentInsets.getSystemWindowInsetBottom();
            }
            availableHeight = availableHeight2;
        } else {
            availableHeight = availableHeight2;
        }
        int height2 = h(header) + availableHeight;
        int headerHeight = header.getMeasuredHeight();
        if (l()) {
            view.setTranslationY((float) (-headerHeight));
            height = height2;
        } else {
            view.setTranslationY(0.0f);
            height = height2 - headerHeight;
        }
        if (childLpHeight == -1) {
            i = BasicMeasure.EXACTLY;
        } else {
            i = Integer.MIN_VALUE;
        }
        parent.onMeasureChild(child, parentWidthMeasureSpec, widthUsed, View.MeasureSpec.makeMeasureSpec(height, i), heightUsed);
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout parent, View child, int layoutDirection) {
        View header = d(parent.getDependencies(child));
        if (header != null) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            Rect available = this.a;
            available.set(parent.getPaddingLeft() + lp.leftMargin, header.getBottom() + lp.topMargin, (parent.getWidth() - parent.getPaddingRight()) - lp.rightMargin, ((parent.getHeight() + header.getBottom()) - parent.getPaddingBottom()) - lp.bottomMargin);
            WindowInsetsCompat parentInsets = parent.getLastWindowInsets();
            if (parentInsets != null && ViewCompat.getFitsSystemWindows(parent) && !ViewCompat.getFitsSystemWindows(child)) {
                available.left += parentInsets.getSystemWindowInsetLeft();
                available.right -= parentInsets.getSystemWindowInsetRight();
            }
            Rect out = this.b;
            GravityCompat.apply(j(lp.gravity), child.getMeasuredWidth(), child.getMeasuredHeight(), available, out, layoutDirection);
            int overlap = e(header);
            child.layout(out.left, out.top - overlap, out.right, out.bottom - overlap);
            this.c = out.top - header.getBottom();
            return;
        }
        super.b(parent, child, layoutDirection);
        this.c = 0;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int e(View header) {
        if (this.d == 0) {
            return 0;
        }
        float f = f(header);
        int i = this.d;
        return MathUtils.clamp((int) (f * ((float) i)), 0, i);
    }

    private static int j(int gravity) {
        if (gravity == 0) {
            return 8388659;
        }
        return gravity;
    }

    /* access modifiers changed from: package-private */
    public int h(View v) {
        return v.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int i() {
        return this.c;
    }

    public final void k(int overlayTop) {
        this.d = overlayTop;
    }

    public final int g() {
        return this.d;
    }
}
