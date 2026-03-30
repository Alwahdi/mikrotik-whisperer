package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class b extends d {
    final SideSheetBehavior<? extends View> a;

    b(SideSheetBehavior<? extends View> sheetBehavior) {
        this.a = sheetBehavior;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a.C();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return Math.max(0, (d() - this.a.u()) - this.a.z());
    }

    /* access modifiers changed from: package-private */
    public boolean k(View releasedChild) {
        return releasedChild.getLeft() > (d() + c()) / 2;
    }

    /* access modifiers changed from: package-private */
    public boolean l(float xVelocity, float yVelocity) {
        return e.a(xVelocity, yVelocity) && Math.abs(xVelocity) > ((float) this.a.D());
    }

    /* access modifiers changed from: package-private */
    public boolean m(View child, float velocity) {
        return Math.abs(((float) child.getRight()) + (this.a.x() * velocity)) > this.a.y();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int g(V child) {
        return child.getLeft() - this.a.z();
    }

    /* access modifiers changed from: package-private */
    public float b(int left) {
        float hiddenOffset = (float) d();
        return (hiddenOffset - ((float) left)) / (hiddenOffset - ((float) c()));
    }

    /* access modifiers changed from: package-private */
    public void n(ViewGroup.MarginLayoutParams coplanarSiblingLayoutParams, int sheetLeft, int sheetRight) {
        int parentWidth = this.a.C();
        if (sheetLeft <= parentWidth) {
            coplanarSiblingLayoutParams.rightMargin = parentWidth - sheetLeft;
        }
    }

    public int h(CoordinatorLayout parent) {
        return parent.getRight();
    }

    /* access modifiers changed from: package-private */
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return c();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.a.C();
    }

    /* access modifiers changed from: package-private */
    public boolean j(float xVelocity) {
        return xVelocity < 0.0f;
    }
}
