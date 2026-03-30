package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

final class a extends d {
    final SideSheetBehavior<? extends View> a;

    a(SideSheetBehavior<? extends View> sheetBehavior) {
        this.a = sheetBehavior;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return 1;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return (-this.a.u()) - this.a.z();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return Math.max(0, this.a.B() + this.a.z());
    }

    /* access modifiers changed from: package-private */
    public boolean k(View releasedChild) {
        return releasedChild.getRight() < (c() - d()) / 2;
    }

    /* access modifiers changed from: package-private */
    public boolean l(float xVelocity, float yVelocity) {
        return e.a(xVelocity, yVelocity) && Math.abs(xVelocity) > ((float) this.a.D());
    }

    /* access modifiers changed from: package-private */
    public boolean m(View child, float velocity) {
        return Math.abs(((float) child.getLeft()) + (this.a.x() * velocity)) > this.a.y();
    }

    /* access modifiers changed from: package-private */
    public <V extends View> int g(V child) {
        return child.getRight() + this.a.z();
    }

    /* access modifiers changed from: package-private */
    public float b(int left) {
        float hiddenOffset = (float) d();
        return (((float) left) - hiddenOffset) / (((float) c()) - hiddenOffset);
    }

    /* access modifiers changed from: package-private */
    public void n(ViewGroup.MarginLayoutParams coplanarSiblingLayoutParams, int sheetLeft, int sheetRight) {
        if (sheetLeft <= this.a.C()) {
            coplanarSiblingLayoutParams.leftMargin = sheetRight;
        }
    }

    public int h(CoordinatorLayout parent) {
        return parent.getLeft();
    }

    /* access modifiers changed from: package-private */
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return -this.a.u();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.a.z();
    }

    /* access modifiers changed from: package-private */
    public boolean j(float xVelocity) {
        return xVelocity > 0.0f;
    }
}
