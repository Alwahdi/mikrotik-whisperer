package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

abstract class a<V extends View> extends c<V> {
    private VelocityTracker a;

    /* renamed from: a  reason: collision with other field name */
    OverScroller f1463a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1464a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1465a;
    private int c = -1;
    private int d;
    private int e = -1;

    /* access modifiers changed from: package-private */
    public abstract boolean d(V v);

    /* access modifiers changed from: package-private */
    public abstract int g(V v);

    /* access modifiers changed from: package-private */
    public abstract int h(V v);

    /* access modifiers changed from: package-private */
    public abstract int i();

    /* access modifiers changed from: package-private */
    public abstract void j(CoordinatorLayout coordinatorLayout, V v);

    /* access modifiers changed from: package-private */
    public abstract int m(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    public a() {
    }

    public a(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent ev) {
        int pointerIndex;
        if (this.e < 0) {
            this.e = ViewConfiguration.get(parent.getContext()).getScaledTouchSlop();
        }
        if (ev.getActionMasked() == 2 && this.f1465a) {
            int i = this.c;
            if (i == -1 || (pointerIndex = ev.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) ev.getY(pointerIndex);
            if (Math.abs(y - this.d) > this.e) {
                this.d = y;
                return true;
            }
        }
        if (ev.getActionMasked() == 0) {
            this.c = -1;
            int x = (int) ev.getX();
            int y2 = (int) ev.getY();
            boolean z = d(child) && parent.isPointInChildBounds(child, x, y2);
            this.f1465a = z;
            if (z) {
                this.d = y2;
                this.c = ev.getPointerId(0);
                e();
                OverScroller overScroller = this.f1463a;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f1463a.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
        }
        return false;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent ev) {
        boolean consumeUp = false;
        switch (ev.getActionMasked()) {
            case 1:
                VelocityTracker velocityTracker = this.a;
                if (velocityTracker != null) {
                    consumeUp = true;
                    velocityTracker.addMovement(ev);
                    this.a.computeCurrentVelocity(1000);
                    f(parent, child, -h(child), 0, this.a.getYVelocity(this.c));
                    break;
                }
                break;
            case 2:
                int activePointerIndex = ev.findPointerIndex(this.c);
                if (activePointerIndex != -1) {
                    int y = (int) ev.getY(activePointerIndex);
                    this.d = y;
                    k(parent, child, this.d - y, g(child), 0);
                    break;
                } else {
                    return false;
                }
            case 3:
                break;
            case 6:
                int newIndex = ev.getActionIndex() == 0 ? 1 : 0;
                this.c = ev.getPointerId(newIndex);
                this.d = (int) (ev.getY(newIndex) + 0.5f);
                break;
        }
        this.f1465a = false;
        this.c = -1;
        VelocityTracker velocityTracker2 = this.a;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.a = null;
        }
        VelocityTracker velocityTracker3 = this.a;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(ev);
        }
        if (this.f1465a || consumeUp) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int l(CoordinatorLayout parent, V header, int newOffset) {
        return m(parent, header, newOffset, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int k(CoordinatorLayout coordinatorLayout, V header, int dy, int minOffset, int maxOffset) {
        return m(coordinatorLayout, header, i() - dy, minOffset, maxOffset);
    }

    /* access modifiers changed from: package-private */
    public final boolean f(CoordinatorLayout coordinatorLayout, V layout, int minOffset, int maxOffset, float velocityY) {
        V v = layout;
        Runnable runnable = this.f1464a;
        if (runnable != null) {
            layout.removeCallbacks(runnable);
            this.f1464a = null;
        }
        if (this.f1463a == null) {
            this.f1463a = new OverScroller(layout.getContext());
        }
        this.f1463a.fling(0, a(), 0, Math.round(velocityY), 0, 0, minOffset, maxOffset);
        if (this.f1463a.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            C0011a aVar = new C0011a(coordinatorLayout, layout);
            this.f1464a = aVar;
            ViewCompat.postOnAnimation(layout, aVar);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        j(coordinatorLayout, layout);
        return false;
    }

    private void e() {
        if (this.a == null) {
            this.a = VelocityTracker.obtain();
        }
    }

    /* renamed from: com.google.android.material.appbar.a$a  reason: collision with other inner class name */
    private class C0011a implements Runnable {
        private final V a;

        /* renamed from: a  reason: collision with other field name */
        private final CoordinatorLayout f1466a;

        C0011a(CoordinatorLayout parent, V layout) {
            this.f1466a = parent;
            this.a = layout;
        }

        public void run() {
            OverScroller overScroller;
            if (this.a != null && (overScroller = a.this.f1463a) != null) {
                if (overScroller.computeScrollOffset()) {
                    a aVar = a.this;
                    aVar.l(this.f1466a, this.a, aVar.f1463a.getCurrY());
                    ViewCompat.postOnAnimation(this.a, this);
                    return;
                }
                a.this.j(this.f1466a, this.a);
            }
        }
    }
}
