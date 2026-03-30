package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class d {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private final View f1469a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1470a = true;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1471b = true;
    private int c;
    private int d;

    public d(View view) {
        this.f1469a = view;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.a = this.f1469a.getTop();
        this.b = this.f1469a.getLeft();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f1469a;
        ViewCompat.offsetTopAndBottom(view, this.c - (view.getTop() - this.a));
        View view2 = this.f1469a;
        ViewCompat.offsetLeftAndRight(view2, this.d - (view2.getLeft() - this.b));
    }

    public boolean f(int offset) {
        if (!this.f1470a || this.c == offset) {
            return false;
        }
        this.c = offset;
        a();
        return true;
    }

    public boolean e(int offset) {
        if (!this.f1471b || this.d == offset) {
            return false;
        }
        this.d = offset;
        a();
        return true;
    }

    public int c() {
        return this.c;
    }

    public int b() {
        return this.a;
    }
}
