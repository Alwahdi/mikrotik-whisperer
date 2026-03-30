package com.google.android.material.carousel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

abstract class c {
    final int a;

    /* access modifiers changed from: package-private */
    public abstract float d(RecyclerView.LayoutParams layoutParams);

    /* access modifiers changed from: package-private */
    public abstract int e();

    /* access modifiers changed from: package-private */
    public abstract int f();

    /* access modifiers changed from: package-private */
    public abstract int g();

    /* access modifiers changed from: package-private */
    public abstract int h();

    /* access modifiers changed from: package-private */
    public abstract int i();

    /* access modifiers changed from: package-private */
    public abstract int j();

    /* access modifiers changed from: package-private */
    public abstract void k(View view, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void l(View view, Rect rect, float f, float f2);

    /* synthetic */ c(int x0, a x1) {
        this(x0);
    }

    private c(int orientation) {
        this.a = orientation;
    }

    static c b(CarouselLayoutManager layoutManager, int orientation) {
        switch (orientation) {
            case 0:
                return a(layoutManager);
            case 1:
                return c(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    class a extends c {
        final /* synthetic */ CarouselLayoutManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int orientation, CarouselLayoutManager carouselLayoutManager) {
            super(orientation, (a) null);
            this.a = carouselLayoutManager;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return this.a.getPaddingLeft();
        }

        /* access modifiers changed from: package-private */
        public int i() {
            return j();
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.a.getWidth() - this.a.getPaddingRight();
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return e();
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.a.getHeight();
        }

        public void k(View child, int head, int tail) {
            this.a.layoutDecoratedWithMargins(child, g(), head, h(), tail);
        }

        public float d(RecyclerView.LayoutParams layoutParams) {
            return (float) (layoutParams.topMargin + layoutParams.bottomMargin);
        }

        public void l(View child, Rect boundsRect, float halfItemSize, float offsetCenter) {
            child.offsetTopAndBottom((int) (offsetCenter - (((float) boundsRect.top) + halfItemSize)));
        }
    }

    private static c c(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    class b extends c {
        final /* synthetic */ CarouselLayoutManager a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int orientation, CarouselLayoutManager carouselLayoutManager) {
            super(orientation, (a) null);
            this.a = carouselLayoutManager;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int i() {
            return this.a.M() ? h() : g();
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.a.getWidth();
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return this.a.M() ? g() : h();
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return this.a.getPaddingTop();
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.a.getHeight() - this.a.getPaddingBottom();
        }

        public void k(View child, int head, int tail) {
            this.a.layoutDecoratedWithMargins(child, head, j(), tail, e());
        }

        public float d(RecyclerView.LayoutParams layoutParams) {
            return (float) (layoutParams.rightMargin + layoutParams.leftMargin);
        }

        public void l(View child, Rect boundsRect, float halfItemSize, float offsetCenter) {
            child.offsetLeftAndRight((int) (offsetCenter - (((float) boundsRect.left) + halfItemSize)));
        }
    }

    private static c a(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }
}
