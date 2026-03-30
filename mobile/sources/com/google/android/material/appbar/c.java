package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

abstract class c<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private d f1468a;
    private int b = 0;

    public c() {
    }

    public c(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        b(parent, child, layoutDirection);
        if (this.f1468a == null) {
            this.f1468a = new d(child);
        }
        this.f1468a.d();
        this.f1468a.a();
        int i = this.a;
        if (i != 0) {
            this.f1468a.f(i);
            this.a = 0;
        }
        int i2 = this.b;
        if (i2 == 0) {
            return true;
        }
        this.f1468a.e(i2);
        this.b = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout parent, V child, int layoutDirection) {
        parent.onLayoutChild(child, layoutDirection);
    }

    public boolean c(int offset) {
        d dVar = this.f1468a;
        if (dVar != null) {
            return dVar.f(offset);
        }
        this.a = offset;
        return false;
    }

    public int a() {
        d dVar = this.f1468a;
        if (dVar != null) {
            return dVar.c();
        }
        return 0;
    }
}
