package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int l = uc0.Widget_Design_CollapsingToolbar;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private long f1437a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f1438a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f1439a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1440a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1441a;

    /* renamed from: a  reason: collision with other field name */
    private View f1442a;

    /* renamed from: a  reason: collision with other field name */
    private ViewGroup f1443a;

    /* renamed from: a  reason: collision with other field name */
    WindowInsetsCompat f1444a;

    /* renamed from: a  reason: collision with other field name */
    private AppBarLayout.g f1445a;

    /* renamed from: a  reason: collision with other field name */
    final di f1446a;

    /* renamed from: a  reason: collision with other field name */
    final g9 f1447a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1448a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private final TimeInterpolator f1449b;

    /* renamed from: b  reason: collision with other field name */
    Drawable f1450b;

    /* renamed from: b  reason: collision with other field name */
    private View f1451b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1452b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1453c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1454d;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1455e;
    private int f;

    /* renamed from: f  reason: collision with other field name */
    private boolean f1456f;
    private int g;
    int h;
    private int i;
    private int j;
    private int k;

    public interface e extends bn0 {
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.collapsingToolbarLayoutStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = l
            android.content.Context r0 = defpackage.t00.c(r11, r12, r13, r4)
            r10.<init>(r0, r12, r13)
            r6 = 1
            r10.f1448a = r6
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.f1440a = r0
            r7 = -1
            r10.g = r7
            r8 = 0
            r10.j = r8
            r10.k = r8
            android.content.Context r11 = r10.getContext()
            g9 r9 = new g9
            r9.<init>(r10)
            r10.f1447a = r9
            android.animation.TimeInterpolator r0 = defpackage.f3.e
            r9.L0(r0)
            r9.H0(r8)
            di r0 = new di
            r0.<init>(r11)
            r10.f1446a = r0
            int[] r2 = defpackage.xc0.f5616I
            int[] r5 = new int[r8]
            r0 = r11
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.j1
            r2 = 8388691(0x800053, float:1.175506E-38)
            int r1 = r0.getInt(r1, r2)
            r9.u0(r1)
            int r1 = defpackage.xc0.f1
            r2 = 8388627(0x800013, float:1.175497E-38)
            int r1 = r0.getInt(r1, r2)
            r9.j0(r1)
            int r1 = defpackage.xc0.k1
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r10.e = r1
            r10.d = r1
            r10.c = r1
            r10.b = r1
            int r1 = defpackage.xc0.n1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0075
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r10.b = r1
        L_0x0075:
            int r1 = defpackage.xc0.m1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0084
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r10.d = r1
        L_0x0084:
            int r1 = defpackage.xc0.o1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0093
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r10.c = r1
        L_0x0093:
            int r1 = defpackage.xc0.l1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x00a2
            int r1 = r0.getDimensionPixelSize(r1, r8)
            r10.e = r1
        L_0x00a2:
            int r1 = defpackage.xc0.z1
            boolean r1 = r0.getBoolean(r1, r6)
            r10.f1452b = r1
            int r1 = defpackage.xc0.x1
            java.lang.CharSequence r1 = r0.getText(r1)
            r10.setTitle(r1)
            int r1 = defpackage.uc0.TextAppearance_Design_CollapsingToolbar_Expanded
            r9.r0(r1)
            int r1 = androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title
            r9.g0(r1)
            int r1 = defpackage.xc0.p1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x00cd
            int r1 = r0.getResourceId(r1, r8)
            r9.r0(r1)
        L_0x00cd:
            int r1 = defpackage.xc0.g1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x00dd
            int r1 = r0.getResourceId(r1, r8)
            r9.g0(r1)
        L_0x00dd:
            int r1 = defpackage.xc0.B1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x00f1
            int r1 = r0.getInt(r1, r7)
            android.text.TextUtils$TruncateAt r1 = r10.b(r1)
            r10.setTitleEllipsize(r1)
        L_0x00f1:
            int r1 = defpackage.xc0.q1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0101
            android.content.res.ColorStateList r1 = defpackage.o00.a(r11, r0, r1)
            r9.t0(r1)
        L_0x0101:
            int r1 = defpackage.xc0.h1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0111
            android.content.res.ColorStateList r1 = defpackage.o00.a(r11, r0, r1)
            r9.i0(r1)
        L_0x0111:
            int r1 = defpackage.xc0.v1
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.g = r1
            int r1 = defpackage.xc0.t1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x0128
            int r1 = r0.getInt(r1, r6)
            r9.F0(r1)
        L_0x0128:
            int r1 = defpackage.xc0.A1
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x013c
            int r1 = r0.getResourceId(r1, r8)
            android.view.animation.Interpolator r1 = android.view.animation.AnimationUtils.loadInterpolator(r11, r1)
            r9.G0(r1)
        L_0x013c:
            int r1 = defpackage.xc0.u1
            r2 = 600(0x258, float:8.41E-43)
            int r1 = r0.getInt(r1, r2)
            long r1 = (long) r1
            r10.f1437a = r1
            int r1 = defpackage.yb0.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r2 = defpackage.f3.c
            android.animation.TimeInterpolator r2 = defpackage.i20.g(r11, r1, r2)
            r10.f1438a = r2
            android.animation.TimeInterpolator r2 = defpackage.f3.d
            android.animation.TimeInterpolator r1 = defpackage.i20.g(r11, r1, r2)
            r10.f1449b = r1
            int r1 = defpackage.xc0.i1
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r10.setContentScrim(r1)
            int r1 = defpackage.xc0.w1
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r10.setStatusBarScrim(r1)
            int r1 = defpackage.xc0.y1
            int r1 = r0.getInt(r1, r8)
            r10.setTitleCollapseMode(r1)
            int r1 = defpackage.xc0.C1
            int r1 = r0.getResourceId(r1, r7)
            r10.a = r1
            int r1 = defpackage.xc0.s1
            boolean r1 = r0.getBoolean(r1, r8)
            r10.f1455e = r1
            int r1 = defpackage.xc0.r1
            boolean r1 = r0.getBoolean(r1, r8)
            r10.f1456f = r1
            r0.recycle()
            r10.setWillNotDraw(r8)
            com.google.android.material.appbar.CollapsingToolbarLayout$a r1 = new com.google.android.material.appbar.CollapsingToolbarLayout$a
            r1.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r10, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            return CollapsingToolbarLayout.this.o(insets);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.f1445a == null) {
                this.f1445a = new d();
            }
            appBarLayout.d(this.f1445a);
            ViewCompat.requestApplyInsets(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.g gVar = this.f1445a;
        if (gVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).x(gVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat o(WindowInsetsCompat insets) {
        WindowInsetsCompat newInsets = null;
        if (ViewCompat.getFitsSystemWindows(this)) {
            newInsets = insets;
        }
        if (!ObjectsCompat.equals(this.f1444a, newInsets)) {
            this.f1444a = newInsets;
            requestLayout();
        }
        return insets.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f1443a == null && (drawable = this.f1441a) != null && this.f > 0) {
            drawable.mutate().setAlpha(this.f);
            this.f1441a.draw(canvas);
        }
        if (this.f1452b && this.f1453c) {
            if (this.f1443a == null || this.f1441a == null || this.f <= 0 || !l() || this.f1447a.F() >= this.f1447a.G()) {
                this.f1447a.l(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f1441a.getBounds(), Region.Op.DIFFERENCE);
                this.f1447a.l(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f1450b != null && this.f > 0) {
            WindowInsetsCompat windowInsetsCompat = this.f1444a;
            int topInset = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (topInset > 0) {
                this.f1450b.setBounds(0, -this.h, getWidth(), topInset - this.h);
                this.f1450b.mutate().setAlpha(this.f);
                this.f1450b.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f1447a.Y(newConfig);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean invalidated = false;
        if (this.f1441a != null && this.f > 0 && n(child)) {
            t(this.f1441a, child, getWidth(), getHeight());
            this.f1441a.mutate().setAlpha(this.f);
            this.f1441a.draw(canvas);
            invalidated = true;
        }
        return super.drawChild(canvas, child, drawingTime) || invalidated;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        Drawable drawable = this.f1441a;
        if (drawable != null) {
            s(drawable, w, h2);
        }
    }

    private boolean l() {
        return this.i == 1;
    }

    private void c(AppBarLayout appBarLayout) {
        if (l()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void s(Drawable contentScrim, int width, int height) {
        t(contentScrim, this.f1443a, width, height);
    }

    private void t(Drawable contentScrim, View toolbar, int width, int height) {
        int bottom;
        if (!l() || toolbar == null || !this.f1452b) {
            bottom = height;
        } else {
            bottom = toolbar.getBottom();
        }
        contentScrim.setBounds(0, 0, width, bottom);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r5 = this;
            boolean r0 = r5.f1448a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r5.f1443a = r0
            r5.f1442a = r0
            int r0 = r5.a
            r1 = -1
            if (r0 == r1) goto L_0x001f
            android.view.View r0 = r5.findViewById(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r5.f1443a = r0
            if (r0 == 0) goto L_0x001f
            android.view.View r0 = r5.e(r0)
            r5.f1442a = r0
        L_0x001f:
            android.view.ViewGroup r0 = r5.f1443a
            if (r0 != 0) goto L_0x003e
            r0 = 0
            r1 = 0
            int r2 = r5.getChildCount()
        L_0x0029:
            if (r1 >= r2) goto L_0x003c
            android.view.View r3 = r5.getChildAt(r1)
            boolean r4 = m(r3)
            if (r4 == 0) goto L_0x0039
            r0 = r3
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r1 = r1 + 1
            goto L_0x0029
        L_0x003c:
            r5.f1443a = r0
        L_0x003e:
            r5.u()
            r0 = 0
            r5.f1448a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.d():void");
    }

    private static boolean m(View view) {
        return (view instanceof Toolbar) || (Build.VERSION.SDK_INT >= 21 && (view instanceof android.widget.Toolbar));
    }

    private boolean n(View child) {
        View view = this.f1442a;
        if (view == null || view == this) {
            if (child == this.f1443a) {
                return true;
            }
            return false;
        } else if (child == view) {
            return true;
        } else {
            return false;
        }
    }

    private View e(View descendant) {
        View directChild = descendant;
        ViewParent p = descendant.getParent();
        while (p != this && p != null) {
            if (p instanceof View) {
                directChild = (View) p;
            }
            p = p.getParent();
        }
        return directChild;
    }

    private void u() {
        View view;
        if (!this.f1452b && (view = this.f1451b) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1451b);
            }
        }
        if (this.f1452b && this.f1443a != null) {
            if (this.f1451b == null) {
                this.f1451b = new View(getContext());
            }
            if (this.f1451b.getParent() == null) {
                this.f1443a.addView(this.f1451b, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        d();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        WindowInsetsCompat windowInsetsCompat = this.f1444a;
        int topInset = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.f1455e) && topInset > 0) {
            this.j = topInset;
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + topInset, BasicMeasure.EXACTLY));
        }
        if (this.f1456f != 0 && this.f1447a.L() > 1) {
            x();
            w(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int lineCount = this.f1447a.z();
            if (lineCount > 1) {
                this.k = (lineCount - 1) * Math.round(this.f1447a.A());
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.k, BasicMeasure.EXACTLY));
            }
        }
        ViewGroup viewGroup = this.f1443a;
        if (viewGroup != null) {
            View view = this.f1442a;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        WindowInsetsCompat windowInsetsCompat = this.f1444a;
        if (windowInsetsCompat != null) {
            int insetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int z = getChildCount();
            for (int i2 = 0; i2 < z; i2++) {
                View child = getChildAt(i2);
                if (!ViewCompat.getFitsSystemWindows(child) && child.getTop() < insetTop) {
                    ViewCompat.offsetTopAndBottom(child, insetTop);
                }
            }
        }
        int z2 = getChildCount();
        for (int i3 = 0; i3 < z2; i3++) {
            k(getChildAt(i3)).d();
        }
        w(left, top, right, bottom, false);
        x();
        v();
        int z3 = getChildCount();
        for (int i4 = 0; i4 < z3; i4++) {
            k(getChildAt(i4)).a();
        }
    }

    private void w(int left, int top, int right, int bottom, boolean forceRecalculate) {
        View view;
        if (this.f1452b && (view = this.f1451b) != null) {
            boolean z = false;
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.f1451b.getVisibility() == 0;
            this.f1453c = z2;
            if (z2 || forceRecalculate) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z = true;
                }
                boolean isRtl = z;
                q(isRtl);
                this.f1447a.o0(isRtl ? this.d : this.b, this.f1440a.top + this.c, (right - left) - (isRtl ? this.b : this.d), (bottom - top) - this.e);
                this.f1447a.b0(forceRecalculate);
            }
        }
    }

    private void x() {
        if (this.f1443a != null && this.f1452b && TextUtils.isEmpty(this.f1447a.O())) {
            setTitle(j(this.f1443a));
        }
    }

    private void q(boolean isRtl) {
        int titleMarginTop;
        int titleMarginEnd;
        int titleMarginStart;
        int titleMarginBottom;
        View view = this.f1442a;
        if (view == null) {
            view = this.f1443a;
        }
        int maxOffset = i(view);
        fg.a(this, this.f1451b, this.f1440a);
        ViewGroup viewGroup = this.f1443a;
        if (viewGroup instanceof Toolbar) {
            Toolbar compatToolbar = (Toolbar) viewGroup;
            titleMarginStart = compatToolbar.getTitleMarginStart();
            titleMarginEnd = compatToolbar.getTitleMarginEnd();
            titleMarginTop = compatToolbar.getTitleMarginTop();
            titleMarginBottom = compatToolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            titleMarginStart = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
            titleMarginBottom = 0;
        } else {
            android.widget.Toolbar frameworkToolbar = (android.widget.Toolbar) viewGroup;
            titleMarginStart = frameworkToolbar.getTitleMarginStart();
            titleMarginEnd = frameworkToolbar.getTitleMarginEnd();
            titleMarginTop = frameworkToolbar.getTitleMarginTop();
            titleMarginBottom = frameworkToolbar.getTitleMarginBottom();
        }
        g9 g9Var = this.f1447a;
        Rect rect = this.f1440a;
        g9Var.e0(rect.left + (isRtl ? titleMarginEnd : titleMarginStart), rect.top + maxOffset + titleMarginTop, rect.right - (isRtl ? titleMarginStart : titleMarginEnd), (rect.bottom + maxOffset) - titleMarginBottom);
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (Build.VERSION.SDK_INT < 21 || !(view instanceof android.widget.Toolbar)) {
            return null;
        }
        return ((android.widget.Toolbar) view).getTitle();
    }

    private static int h(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (!(lp instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) lp;
        return view.getMeasuredHeight() + mlp.topMargin + mlp.bottomMargin;
    }

    static d k(View view) {
        int i2 = ic0.view_offset_helper;
        d offsetHelper = (d) view.getTag(i2);
        if (offsetHelper != null) {
            return offsetHelper;
        }
        d offsetHelper2 = new d(view);
        view.setTag(i2, offsetHelper2);
        return offsetHelper2;
    }

    public void setTitle(@Nullable CharSequence title) {
        this.f1447a.K0(title);
        r();
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.f1452b) {
            return this.f1447a.O();
        }
        return null;
    }

    public void setTitleCollapseMode(int titleCollapseMode) {
        this.i = titleCollapseMode;
        boolean fadeModeEnabled = l();
        this.f1447a.z0(fadeModeEnabled);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (fadeModeEnabled && this.f1441a == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorSurfaceContainer = k00.h(getContext(), yb0.colorSurfaceContainer);
        if (colorSurfaceContainer != null) {
            return colorSurfaceContainer.getDefaultColor();
        }
        return this.f1446a.d(getResources().getDimension(cc0.design_appbar_elevation));
    }

    public int getTitleCollapseMode() {
        return this.i;
    }

    public void setTitleEnabled(boolean enabled) {
        if (enabled != this.f1452b) {
            this.f1452b = enabled;
            r();
            u();
            requestLayout();
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt ellipsize) {
        this.f1447a.M0(ellipsize);
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f1447a.R();
    }

    private TextUtils.TruncateAt b(int ellipsize) {
        switch (ellipsize) {
            case 0:
                return TextUtils.TruncateAt.START;
            case 1:
                return TextUtils.TruncateAt.MIDDLE;
            case 3:
                return TextUtils.TruncateAt.MARQUEE;
            default:
                return TextUtils.TruncateAt.END;
        }
    }

    public void setScrimsShown(boolean shown) {
        p(shown, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void p(boolean shown, boolean animate) {
        if (this.f1454d != shown) {
            int i2 = 255;
            if (animate) {
                if (!shown) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!shown) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.f1454d = shown;
        }
    }

    private void a(int targetAlpha) {
        TimeInterpolator timeInterpolator;
        d();
        ValueAnimator valueAnimator = this.f1439a;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f1439a = valueAnimator2;
            if (targetAlpha > this.f) {
                timeInterpolator = this.f1438a;
            } else {
                timeInterpolator = this.f1449b;
            }
            valueAnimator2.setInterpolator(timeInterpolator);
            this.f1439a.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f1439a.cancel();
        }
        this.f1439a.setDuration(this.f1437a);
        this.f1439a.setIntValues(new int[]{this.f, targetAlpha});
        this.f1439a.start();
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) animator.getAnimatedValue()).intValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int alpha) {
        ViewGroup viewGroup;
        if (alpha != this.f) {
            if (!(this.f1441a == null || (viewGroup = this.f1443a) == null)) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.f = alpha;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f;
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f1441a;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1441a = drawable3;
            if (drawable3 != null) {
                s(drawable3, getWidth(), getHeight());
                this.f1441a.setCallback(this);
                this.f1441a.setAlpha(this.f);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int color) {
        setContentScrim(new ColorDrawable(color));
    }

    public void setContentScrimResource(@DrawableRes int resId) {
        setContentScrim(ContextCompat.getDrawable(getContext(), resId));
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.f1441a;
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f1450b;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1450b = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f1450b.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f1450b, ViewCompat.getLayoutDirection(this));
                this.f1450b.setVisible(getVisibility() == 0, false);
                this.f1450b.setCallback(this);
                this.f1450b.setAlpha(this.f);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable d2 = this.f1450b;
        if (d2 != null && d2.isStateful()) {
            changed = false | d2.setState(state);
        }
        Drawable d3 = this.f1441a;
        if (d3 != null && d3.isStateful()) {
            changed |= d3.setState(state);
        }
        g9 g9Var = this.f1447a;
        if (g9Var != null) {
            changed |= g9Var.I0(state);
        }
        if (changed) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f1441a || who == this.f1450b;
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.f1450b;
        if (!(drawable == null || drawable.isVisible() == visible)) {
            this.f1450b.setVisible(visible, false);
        }
        Drawable drawable2 = this.f1441a;
        if (drawable2 != null && drawable2.isVisible() != visible) {
            this.f1441a.setVisible(visible, false);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int color) {
        setStatusBarScrim(new ColorDrawable(color));
    }

    public void setStatusBarScrimResource(@DrawableRes int resId) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), resId));
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.f1450b;
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int resId) {
        this.f1447a.g0(resId);
    }

    public void setCollapsedTitleTextColor(@ColorInt int color) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(color));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colors) {
        this.f1447a.i0(colors);
    }

    public void setCollapsedTitleGravity(int gravity) {
        this.f1447a.j0(gravity);
    }

    public int getCollapsedTitleGravity() {
        return this.f1447a.q();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int resId) {
        this.f1447a.r0(resId);
    }

    public void setExpandedTitleColor(@ColorInt int color) {
        setExpandedTitleTextColor(ColorStateList.valueOf(color));
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colors) {
        this.f1447a.t0(colors);
    }

    public void setExpandedTitleGravity(int gravity) {
        this.f1447a.u0(gravity);
    }

    public int getExpandedTitleGravity() {
        return this.f1447a.B();
    }

    public void setExpandedTitleTextSize(float textSize) {
        this.f1447a.v0(textSize);
    }

    public float getExpandedTitleTextSize() {
        return this.f1447a.D();
    }

    public void setCollapsedTitleTextSize(float textSize) {
        this.f1447a.k0(textSize);
    }

    public float getCollapsedTitleTextSize() {
        return this.f1447a.u();
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.f1447a.l0(typeface);
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f1447a.v();
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.f1447a.w0(typeface);
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.f1447a.E();
    }

    public int getExpandedTitleMarginStart() {
        return this.b;
    }

    public void setExpandedTitleMarginStart(int margin) {
        this.b = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.c;
    }

    public void setExpandedTitleMarginTop(int margin) {
        this.c = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.d;
    }

    public void setExpandedTitleMarginEnd(int margin) {
        this.d = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.e;
    }

    public void setExpandedTitleMarginBottom(int margin) {
        this.e = margin;
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int maxLines) {
        this.f1447a.F0(maxLines);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f1447a.L();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f1447a.I();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float spacingAdd) {
        this.f1447a.D0(spacingAdd);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.f1447a.J();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float spacingMultiplier) {
        this.f1447a.E0(spacingMultiplier);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.f1447a.K();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int hyphenationFrequency) {
        this.f1447a.B0(hyphenationFrequency);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.f1447a.H();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable e staticLayoutBuilderConfigurer) {
        this.f1447a.J0(staticLayoutBuilderConfigurer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean rtlTextDirectionHeuristicsEnabled) {
        this.f1447a.H0(rtlTextDirectionHeuristicsEnabled);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean forceApplySystemWindowInsetTop) {
        this.f1455e = forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean extraMultilineHeightEnabled) {
        this.f1456f = extraMultilineHeightEnabled;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int height) {
        if (this.g != height) {
            this.g = height;
            v();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.g;
        if (i2 >= 0) {
            return i2 + this.j + this.k;
        }
        WindowInsetsCompat windowInsetsCompat = this.f1444a;
        int insetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minHeight = ViewCompat.getMinimumHeight(this);
        if (minHeight > 0) {
            return Math.min((minHeight * 2) + insetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator interpolator) {
        this.f1447a.G0(interpolator);
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f1447a.N();
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long duration) {
        this.f1437a = duration;
    }

    public long getScrimAnimationDuration() {
        return this.f1437a;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new c(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new c(p);
    }

    public static class c extends FrameLayout.LayoutParams {
        float a = 0.5f;

        /* renamed from: a  reason: collision with other field name */
        int f1457a = 0;

        public c(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a2 = c.obtainStyledAttributes(attrs, xc0.f5619J);
            this.f1457a = a2.getInt(xc0.D1, 0);
            a(a2.getFloat(xc0.E1, 0.5f));
            a2.recycle();
        }

        public c(int width, int height) {
            super(width, height);
        }

        public c(ViewGroup.LayoutParams p) {
            super(p);
        }

        public void a(float multiplier) {
            this.a = multiplier;
        }
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        if (this.f1441a != null || this.f1450b != null) {
            setScrimsShown(getHeight() + this.h < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: package-private */
    public final int i(View child) {
        return ((getHeight() - k(child).b()) - child.getHeight()) - ((c) child.getLayoutParams()).bottomMargin;
    }

    private void r() {
        setContentDescription(getTitle());
    }

    private class d implements AppBarLayout.g {
        d() {
        }

        public void a(AppBarLayout layout, int verticalOffset) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.h = verticalOffset;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.f1444a;
            int insetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int z = CollapsingToolbarLayout.this.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = CollapsingToolbarLayout.this.getChildAt(i);
                c lp = (c) child.getLayoutParams();
                d offsetHelper = CollapsingToolbarLayout.k(child);
                switch (lp.f1457a) {
                    case 1:
                        offsetHelper.f(MathUtils.clamp(-verticalOffset, 0, CollapsingToolbarLayout.this.i(child)));
                        break;
                    case 2:
                        offsetHelper.f(Math.round(((float) (-verticalOffset)) * lp.a));
                        break;
                }
            }
            CollapsingToolbarLayout.this.v();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f1450b != null && insetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int expandRange = (height - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - insetTop;
            CollapsingToolbarLayout.this.f1447a.A0(Math.min(1.0f, ((float) (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger())) / ((float) expandRange)));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f1447a.n0(collapsingToolbarLayout3.h + expandRange);
            CollapsingToolbarLayout.this.f1447a.y0(((float) Math.abs(verticalOffset)) / ((float) expandRange));
        }
    }
}
