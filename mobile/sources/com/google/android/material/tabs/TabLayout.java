package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final Pools.Pool<g> b = new Pools.SynchronizedPool(16);
    private static final int w = uc0.Widget_Design_TabLayout;
    float a;

    /* renamed from: a  reason: collision with other field name */
    int f1903a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final TimeInterpolator f1904a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f1905a;

    /* renamed from: a  reason: collision with other field name */
    ColorStateList f1906a;

    /* renamed from: a  reason: collision with other field name */
    private DataSetObserver f1907a;

    /* renamed from: a  reason: collision with other field name */
    PorterDuff.Mode f1908a;

    /* renamed from: a  reason: collision with other field name */
    Drawable f1909a;

    /* renamed from: a  reason: collision with other field name */
    private final Pools.Pool<i> f1910a;

    /* renamed from: a  reason: collision with other field name */
    private PagerAdapter f1911a;

    /* renamed from: a  reason: collision with other field name */
    ViewPager f1912a;

    /* renamed from: a  reason: collision with other field name */
    private b f1913a;

    /* renamed from: a  reason: collision with other field name */
    private c f1914a;

    /* renamed from: a  reason: collision with other field name */
    final f f1915a;

    /* renamed from: a  reason: collision with other field name */
    private g f1916a;

    /* renamed from: a  reason: collision with other field name */
    private h f1917a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public c f1918a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<g> f1919a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1920a;

    /* renamed from: b  reason: collision with other field name */
    float f1921b;

    /* renamed from: b  reason: collision with other field name */
    int f1922b;

    /* renamed from: b  reason: collision with other field name */
    ColorStateList f1923b;

    /* renamed from: b  reason: collision with other field name */
    private c f1924b;

    /* renamed from: b  reason: collision with other field name */
    private final ArrayList<c> f1925b;

    /* renamed from: b  reason: collision with other field name */
    boolean f1926b;
    float c;

    /* renamed from: c  reason: collision with other field name */
    int f1927c;

    /* renamed from: c  reason: collision with other field name */
    ColorStateList f1928c;

    /* renamed from: c  reason: collision with other field name */
    boolean f1929c;
    int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1930d;
    int e;
    /* access modifiers changed from: private */
    public final int f;
    /* access modifiers changed from: private */
    public final int g;
    /* access modifiers changed from: private */
    public int h;
    private int i;
    final int j;
    int k;
    private final int l;
    private final int m;
    private final int n;
    private int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    /* access modifiers changed from: private */
    public int v;

    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public interface d extends c<g> {
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.tabStyle);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(android.content.Context r13, android.util.AttributeSet r14, int r15) {
        /*
            r12 = this;
            int r4 = w
            android.content.Context r0 = defpackage.t00.c(r13, r14, r15, r4)
            r12.<init>(r0, r14, r15)
            r6 = -1
            r12.f1903a = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12.f1919a = r0
            r12.h = r6
            r7 = 0
            r12.i = r7
            r0 = 2147483647(0x7fffffff, float:NaN)
            r12.k = r0
            r12.t = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r12.f1925b = r0
            androidx.core.util.Pools$SimplePool r0 = new androidx.core.util.Pools$SimplePool
            r1 = 12
            r0.<init>(r1)
            r12.f1910a = r0
            android.content.Context r13 = r12.getContext()
            r12.setHorizontalScrollBarEnabled(r7)
            com.google.android.material.tabs.TabLayout$f r8 = new com.google.android.material.tabs.TabLayout$f
            r8.<init>(r13)
            r12.f1915a = r8
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r6)
            super.addView(r8, r7, r0)
            int[] r2 = defpackage.xc0.f5734z1
            r9 = 1
            int[] r5 = new int[r9]
            int r10 = defpackage.xc0.x4
            r5[r7] = r10
            r0 = r13
            r1 = r14
            r3 = r15
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r1 = r12.getBackground()
            android.content.res.ColorStateList r1 = defpackage.yh.f(r1)
            if (r1 == 0) goto L_0x0076
            p00 r2 = new p00
            r2.<init>()
            r2.V(r1)
            r2.K(r13)
            float r3 = androidx.core.view.ViewCompat.getElevation(r12)
            r2.U(r3)
            androidx.core.view.ViewCompat.setBackground(r12, r2)
        L_0x0076:
            int r2 = defpackage.xc0.e4
            android.graphics.drawable.Drawable r2 = defpackage.o00.d(r13, r0, r2)
            r12.setSelectedTabIndicator((android.graphics.drawable.Drawable) r2)
            int r2 = defpackage.xc0.h4
            int r2 = r0.getColor(r2, r7)
            r12.setSelectedTabIndicatorColor(r2)
            int r2 = defpackage.xc0.k4
            int r2 = r0.getDimensionPixelSize(r2, r6)
            r8.i(r2)
            int r2 = defpackage.xc0.j4
            int r2 = r0.getInt(r2, r7)
            r12.setSelectedTabIndicatorGravity(r2)
            int r2 = defpackage.xc0.g4
            int r2 = r0.getInt(r2, r7)
            r12.setTabIndicatorAnimationMode(r2)
            int r2 = defpackage.xc0.i4
            boolean r2 = r0.getBoolean(r2, r9)
            r12.setTabIndicatorFullWidth(r2)
            int r2 = defpackage.xc0.p4
            int r2 = r0.getDimensionPixelSize(r2, r7)
            r12.e = r2
            r12.d = r2
            r12.f1927c = r2
            r12.f1922b = r2
            int r3 = defpackage.xc0.s4
            int r2 = r0.getDimensionPixelSize(r3, r2)
            r12.f1922b = r2
            int r2 = defpackage.xc0.t4
            int r3 = r12.f1927c
            int r2 = r0.getDimensionPixelSize(r2, r3)
            r12.f1927c = r2
            int r2 = defpackage.xc0.r4
            int r3 = r12.d
            int r2 = r0.getDimensionPixelSize(r2, r3)
            r12.d = r2
            int r2 = defpackage.xc0.q4
            int r3 = r12.e
            int r2 = r0.getDimensionPixelSize(r2, r3)
            r12.e = r2
            boolean r2 = defpackage.vq0.g(r13)
            if (r2 == 0) goto L_0x00eb
            int r2 = defpackage.yb0.textAppearanceTitleSmall
            r12.f = r2
            goto L_0x00ef
        L_0x00eb:
            int r2 = defpackage.yb0.textAppearanceButton
            r12.f = r2
        L_0x00ef:
            int r2 = defpackage.uc0.TextAppearance_Design_Tab
            int r2 = r0.getResourceId(r10, r2)
            r12.g = r2
            int[] r3 = androidx.appcompat.R.styleable.TextAppearance
            android.content.res.TypedArray r4 = r13.obtainStyledAttributes(r2, r3)
            int r5 = androidx.appcompat.R.styleable.TextAppearance_android_textSize     // Catch:{ all -> 0x0213 }
            int r8 = r4.getDimensionPixelSize(r5, r7)     // Catch:{ all -> 0x0213 }
            float r8 = (float) r8     // Catch:{ all -> 0x0213 }
            r12.a = r8     // Catch:{ all -> 0x0213 }
            int r8 = androidx.appcompat.R.styleable.TextAppearance_android_textColor     // Catch:{ all -> 0x0213 }
            android.content.res.ColorStateList r10 = defpackage.o00.a(r13, r4, r8)     // Catch:{ all -> 0x0213 }
            r12.f1906a = r10     // Catch:{ all -> 0x0213 }
            r4.recycle()
            int r10 = defpackage.xc0.v4
            boolean r11 = r0.hasValue(r10)
            if (r11 == 0) goto L_0x0121
            int r2 = r0.getResourceId(r10, r2)
            r12.h = r2
        L_0x0121:
            int r2 = r12.h
            if (r2 == r6) goto L_0x015f
            android.content.res.TypedArray r2 = r13.obtainStyledAttributes(r2, r3)
            float r3 = r12.a     // Catch:{ all -> 0x015a }
            int r3 = (int) r3     // Catch:{ all -> 0x015a }
            int r3 = r2.getDimensionPixelSize(r5, r3)     // Catch:{ all -> 0x015a }
            float r3 = (float) r3     // Catch:{ all -> 0x015a }
            r12.f1921b = r3     // Catch:{ all -> 0x015a }
            android.content.res.ColorStateList r3 = defpackage.o00.a(r13, r2, r8)     // Catch:{ all -> 0x015a }
            if (r3 == 0) goto L_0x0156
            android.content.res.ColorStateList r5 = r12.f1906a     // Catch:{ all -> 0x015a }
            int r5 = r5.getDefaultColor()     // Catch:{ all -> 0x015a }
            int[] r8 = new int[r9]     // Catch:{ all -> 0x015a }
            r10 = 16842913(0x10100a1, float:2.369401E-38)
            r8[r7] = r10     // Catch:{ all -> 0x015a }
            int r10 = r3.getDefaultColor()     // Catch:{ all -> 0x015a }
            int r8 = r3.getColorForState(r8, r10)     // Catch:{ all -> 0x015a }
            android.content.res.ColorStateList r5 = s(r5, r8)     // Catch:{ all -> 0x015a }
            r12.f1906a = r5     // Catch:{ all -> 0x015a }
        L_0x0156:
            r2.recycle()
            goto L_0x015f
        L_0x015a:
            r3 = move-exception
            r2.recycle()
            throw r3
        L_0x015f:
            int r2 = defpackage.xc0.y4
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x016e
            android.content.res.ColorStateList r2 = defpackage.o00.a(r13, r0, r2)
            r12.f1906a = r2
        L_0x016e:
            int r2 = defpackage.xc0.w4
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x0186
            int r2 = r0.getColor(r2, r7)
            android.content.res.ColorStateList r3 = r12.f1906a
            int r3 = r3.getDefaultColor()
            android.content.res.ColorStateList r3 = s(r3, r2)
            r12.f1906a = r3
        L_0x0186:
            int r2 = defpackage.xc0.c4
            android.content.res.ColorStateList r2 = defpackage.o00.a(r13, r0, r2)
            r12.f1923b = r2
            int r2 = defpackage.xc0.d4
            int r2 = r0.getInt(r2, r6)
            r3 = 0
            android.graphics.PorterDuff$Mode r2 = defpackage.lv0.i(r2, r3)
            r12.f1908a = r2
            int r2 = defpackage.xc0.u4
            android.content.res.ColorStateList r2 = defpackage.o00.a(r13, r0, r2)
            r12.f1928c = r2
            int r2 = defpackage.xc0.f4
            r3 = 300(0x12c, float:4.2E-43)
            int r2 = r0.getInt(r2, r3)
            r12.q = r2
            int r2 = defpackage.yb0.motionEasingEmphasizedInterpolator
            android.animation.TimeInterpolator r3 = defpackage.f3.b
            android.animation.TimeInterpolator r2 = defpackage.i20.g(r13, r2, r3)
            r12.f1904a = r2
            int r2 = defpackage.xc0.n4
            int r2 = r0.getDimensionPixelSize(r2, r6)
            r12.l = r2
            int r2 = defpackage.xc0.m4
            int r2 = r0.getDimensionPixelSize(r2, r6)
            r12.m = r2
            int r2 = defpackage.xc0.Z3
            int r2 = r0.getResourceId(r2, r7)
            r12.j = r2
            int r2 = defpackage.xc0.a4
            int r2 = r0.getDimensionPixelSize(r2, r7)
            r12.o = r2
            int r2 = defpackage.xc0.o4
            int r2 = r0.getInt(r2, r9)
            r12.s = r2
            int r2 = defpackage.xc0.b4
            int r2 = r0.getInt(r2, r7)
            r12.p = r2
            int r2 = defpackage.xc0.l4
            boolean r2 = r0.getBoolean(r2, r7)
            r12.f1920a = r2
            int r2 = defpackage.xc0.z4
            boolean r2 = r0.getBoolean(r2, r7)
            r12.f1929c = r2
            r0.recycle()
            android.content.res.Resources r2 = r12.getResources()
            int r3 = defpackage.cc0.design_tab_text_size_2line
            int r3 = r2.getDimensionPixelSize(r3)
            float r3 = (float) r3
            r12.c = r3
            int r3 = defpackage.cc0.design_tab_scrollable_min_width
            int r3 = r2.getDimensionPixelSize(r3)
            r12.n = r3
            r12.p()
            return
        L_0x0213:
            r2 = move-exception
            r4.recycle()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSelectedTabIndicatorColor(@ColorInt int color) {
        this.i = color;
        yh.k(this.f1909a, color);
        T(false);
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int height) {
        this.t = height;
        this.f1915a.i(height);
    }

    public void M(int position, float positionOffset, boolean updateSelectedTabView) {
        N(position, positionOffset, updateSelectedTabView, true);
    }

    public void N(int position, float positionOffset, boolean updateSelectedTabView, boolean updateIndicatorPosition) {
        O(position, positionOffset, updateSelectedTabView, updateIndicatorPosition, true);
    }

    /* access modifiers changed from: package-private */
    public void O(int position, float positionOffset, boolean updateSelectedTabView, boolean updateIndicatorPosition, boolean alwaysScroll) {
        int roundedPosition = Math.round(((float) position) + positionOffset);
        if (roundedPosition >= 0 && roundedPosition < this.f1915a.getChildCount()) {
            if (updateIndicatorPosition) {
                this.f1915a.h(position, positionOffset);
            }
            ValueAnimator valueAnimator = this.f1905a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f1905a.cancel();
            }
            int scrollXForPosition = q(position, positionOffset);
            int scrollX = getScrollX();
            boolean toMove = (position < getSelectedTabPosition() && scrollXForPosition >= scrollX) || (position > getSelectedTabPosition() && scrollXForPosition <= scrollX) || position == getSelectedTabPosition();
            if (ViewCompat.getLayoutDirection(this) == 1) {
                toMove = (position < getSelectedTabPosition() && scrollXForPosition <= scrollX) || (position > getSelectedTabPosition() && scrollXForPosition >= scrollX) || position == getSelectedTabPosition();
            }
            if (toMove || this.v == 1 || alwaysScroll) {
                scrollTo(position < 0 ? 0 : scrollXForPosition, 0);
            }
            if (updateSelectedTabView) {
                setSelectedTabView(roundedPosition);
            }
        }
    }

    public void i(g tab) {
        k(tab, this.f1919a.isEmpty());
    }

    public void k(g tab, boolean setSelected) {
        j(tab, this.f1919a.size(), setSelected);
    }

    public void j(g tab, int position, boolean setSelected) {
        if (tab.f1938a == this) {
            r(tab, position);
            l(tab);
            if (setSelected) {
                tab.l();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    private boolean B() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        return B() && super.onInterceptTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() != 8 || B()) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable d listener) {
        setOnTabSelectedListener((c) listener);
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c listener) {
        c cVar = this.f1914a;
        if (cVar != null) {
            H(cVar);
        }
        this.f1914a = listener;
        if (listener != null) {
            g(listener);
        }
    }

    public void h(d listener) {
        g(listener);
    }

    public void g(c listener) {
        if (!this.f1925b.contains(listener)) {
            this.f1925b.add(listener);
        }
    }

    public void H(c listener) {
        this.f1925b.remove(listener);
    }

    public g D() {
        g tab = u();
        tab.f1938a = this;
        tab.f1937a = v(tab);
        if (tab.c != -1) {
            tab.f1937a.setId(tab.c);
        }
        return tab;
    }

    /* access modifiers changed from: protected */
    public g u() {
        g tab = b.acquire();
        if (tab == null) {
            return new g();
        }
        return tab;
    }

    /* access modifiers changed from: protected */
    public boolean F(g tab) {
        return b.release(tab);
    }

    public int getTabCount() {
        return this.f1919a.size();
    }

    public g A(int index) {
        if (index < 0 || index >= getTabCount()) {
            return null;
        }
        return this.f1919a.get(index);
    }

    public int getSelectedTabPosition() {
        g gVar = this.f1916a;
        if (gVar != null) {
            return gVar.g();
        }
        return -1;
    }

    public void G() {
        for (int i2 = this.f1915a.getChildCount() - 1; i2 >= 0; i2--) {
            I(i2);
        }
        Iterator<g> it = this.f1919a.iterator();
        while (it.hasNext()) {
            g tab = it.next();
            it.remove();
            tab.k();
            F(tab);
        }
        this.f1916a = null;
    }

    public void setTabMode(int mode) {
        if (mode != this.s) {
            this.s = mode;
            p();
        }
    }

    public int getTabMode() {
        return this.s;
    }

    public void setTabGravity(int gravity) {
        if (this.p != gravity) {
            this.p = gravity;
            p();
        }
    }

    public int getTabGravity() {
        return this.p;
    }

    public void setSelectedTabIndicatorGravity(int indicatorGravity) {
        if (this.r != indicatorGravity) {
            this.r = indicatorGravity;
            ViewCompat.postInvalidateOnAnimation(this.f1915a);
        }
    }

    public int getTabIndicatorGravity() {
        return this.r;
    }

    public void setTabIndicatorAnimationMode(int tabIndicatorAnimationMode) {
        this.u = tabIndicatorAnimationMode;
        switch (tabIndicatorAnimationMode) {
            case 0:
                this.f1918a = new c();
                return;
            case 1:
                this.f1918a = new a();
                return;
            case 2:
                this.f1918a = new b();
                return;
            default:
                throw new IllegalArgumentException(tabIndicatorAnimationMode + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public int getTabIndicatorAnimationMode() {
        return this.u;
    }

    public void setTabIndicatorFullWidth(boolean tabIndicatorFullWidth) {
        this.f1926b = tabIndicatorFullWidth;
        this.f1915a.g();
        ViewCompat.postInvalidateOnAnimation(this.f1915a);
    }

    public boolean C() {
        return this.f1926b;
    }

    public void setInlineLabel(boolean inline) {
        if (this.f1920a != inline) {
            this.f1920a = inline;
            for (int i2 = 0; i2 < this.f1915a.getChildCount(); i2++) {
                View child = this.f1915a.getChildAt(i2);
                if (child instanceof i) {
                    ((i) child).t();
                }
            }
            p();
        }
    }

    public void setInlineLabelResource(@BoolRes int inlineResourceId) {
        setInlineLabel(getResources().getBoolean(inlineResourceId));
    }

    public void setUnboundedRipple(boolean unboundedRipple) {
        if (this.f1929c != unboundedRipple) {
            this.f1929c = unboundedRipple;
            for (int i2 = 0; i2 < this.f1915a.getChildCount(); i2++) {
                View child = this.f1915a.getChildAt(i2);
                if (child instanceof i) {
                    ((i) child).s(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int unboundedRippleResourceId) {
        setUnboundedRipple(getResources().getBoolean(unboundedRippleResourceId));
    }

    public void setTabTextColors(@Nullable ColorStateList textColor) {
        if (this.f1906a != textColor) {
            this.f1906a = textColor;
            R();
        }
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f1906a;
    }

    public void setTabIconTint(@Nullable ColorStateList iconTint) {
        if (this.f1923b != iconTint) {
            this.f1923b = iconTint;
            R();
        }
    }

    public void setTabIconTintResource(@ColorRes int iconTintResourceId) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), iconTintResourceId));
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.f1923b;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.f1928c;
    }

    public void setTabRippleColor(@Nullable ColorStateList color) {
        if (this.f1928c != color) {
            this.f1928c = color;
            for (int i2 = 0; i2 < this.f1915a.getChildCount(); i2++) {
                View child = this.f1915a.getChildAt(i2);
                if (child instanceof i) {
                    ((i) child).s(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int tabRippleColorResourceId) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), tabRippleColorResourceId));
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.f1909a;
    }

    public void setSelectedTabIndicator(@Nullable Drawable tabSelectedIndicator) {
        if (tabSelectedIndicator == null) {
            tabSelectedIndicator = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.wrap(tabSelectedIndicator).mutate();
        this.f1909a = mutate;
        yh.k(mutate, this.i);
        int indicatorHeight = this.t;
        if (indicatorHeight == -1) {
            indicatorHeight = this.f1909a.getIntrinsicHeight();
        }
        this.f1915a.i(indicatorHeight);
    }

    public void setSelectedTabIndicator(@DrawableRes int tabSelectedIndicatorResourceId) {
        if (tabSelectedIndicatorResourceId != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), tabSelectedIndicatorResourceId));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        P(viewPager, true);
    }

    public void P(ViewPager viewPager, boolean autoRefresh) {
        Q(viewPager, autoRefresh, false);
    }

    private void Q(ViewPager viewPager, boolean autoRefresh, boolean implicitSetup) {
        ViewPager viewPager2 = this.f1912a;
        if (viewPager2 != null) {
            h hVar = this.f1917a;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.f1913a;
            if (bVar != null) {
                this.f1912a.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f1924b;
        if (cVar != null) {
            H(cVar);
            this.f1924b = null;
        }
        if (viewPager != null) {
            this.f1912a = viewPager;
            if (this.f1917a == null) {
                this.f1917a = new h(this);
            }
            this.f1917a.a();
            viewPager.addOnPageChangeListener(this.f1917a);
            j jVar = new j(viewPager);
            this.f1924b = jVar;
            g(jVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                L(adapter, autoRefresh);
            }
            if (this.f1913a == null) {
                this.f1913a = new b();
            }
            this.f1913a.a(autoRefresh);
            viewPager.addOnAdapterChangeListener(this.f1913a);
            M(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f1912a = null;
            L((PagerAdapter) null, false);
        }
        this.f1930d = implicitSetup;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter adapter) {
        L(adapter, false);
    }

    /* access modifiers changed from: package-private */
    public void U(int scrollState) {
        this.v = scrollState;
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q00.e(this);
        if (this.f1912a == null) {
            ViewParent vp = getParent();
            if (vp instanceof ViewPager) {
                Q((ViewPager) vp, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1930d) {
            setupWithViewPager((ViewPager) null);
            this.f1930d = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f1915a.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* access modifiers changed from: package-private */
    public void L(PagerAdapter adapter, boolean addObserver) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter = this.f1911a;
        if (!(pagerAdapter == null || (dataSetObserver = this.f1907a) == null)) {
            pagerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
        this.f1911a = adapter;
        if (addObserver && adapter != null) {
            if (this.f1907a == null) {
                this.f1907a = new e();
            }
            adapter.registerDataSetObserver(this.f1907a);
        }
        E();
    }

    /* access modifiers changed from: package-private */
    public void E() {
        int curItem;
        G();
        PagerAdapter pagerAdapter = this.f1911a;
        if (pagerAdapter != null) {
            int adapterCount = pagerAdapter.getCount();
            for (int i2 = 0; i2 < adapterCount; i2++) {
                k(D().o(this.f1911a.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.f1912a;
            if (viewPager != null && adapterCount > 0 && (curItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && curItem < getTabCount()) {
                J(A(curItem));
            }
        }
    }

    private void R() {
        int z = this.f1919a.size();
        for (int i2 = 0; i2 < z; i2++) {
            this.f1919a.get(i2).p();
        }
    }

    private i v(g tab) {
        Pools.Pool<i> pool = this.f1910a;
        i tabView = pool != null ? pool.acquire() : null;
        if (tabView == null) {
            tabView = new i(getContext());
        }
        tabView.setTab(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f1941b)) {
            tabView.setContentDescription(tab.f1939a);
        } else {
            tabView.setContentDescription(tab.f1941b);
        }
        return tabView;
    }

    private void r(g tab, int position) {
        tab.n(position);
        this.f1919a.add(position, tab);
        int count = this.f1919a.size();
        int newIndicatorPosition = -1;
        for (int i2 = position + 1; i2 < count; i2++) {
            if (this.f1919a.get(i2).g() == this.f1903a) {
                newIndicatorPosition = i2;
            }
            this.f1919a.get(i2).n(i2);
        }
        this.f1903a = newIndicatorPosition;
    }

    private void l(g tab) {
        i tabView = tab.f1937a;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f1915a.addView(tabView, tab.g(), t());
    }

    public void addView(View child) {
        m(child);
    }

    public void addView(View child, int index) {
        m(child);
    }

    public void addView(View child, ViewGroup.LayoutParams params) {
        m(child);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        m(child);
    }

    private void m(View child) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private LinearLayout.LayoutParams t() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -1);
        S(lp);
        return lp;
    }

    private void S(LinearLayout.LayoutParams lp) {
        if (this.s == 1 && this.p == 0) {
            lp.width = 0;
            lp.weight = 1.0f;
            return;
        }
        lp.width = -2;
        lp.weight = 0.0f;
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        q00.d(this, elevation);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        AccessibilityNodeInfoCompat.wrap(info).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f1915a.getChildCount(); i2++) {
            View tabView = this.f1915a.getChildAt(i2);
            if (tabView instanceof i) {
                ((i) tabView).h(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int idealHeight = Math.round(lv0.c(getContext(), getDefaultHeight()));
        boolean z = false;
        switch (View.MeasureSpec.getMode(heightMeasureSpec)) {
            case Integer.MIN_VALUE:
                if (getChildCount() == 1 && View.MeasureSpec.getSize(heightMeasureSpec) >= idealHeight) {
                    getChildAt(0).setMinimumHeight(idealHeight);
                    break;
                }
            case 0:
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getPaddingTop() + idealHeight + getPaddingBottom(), BasicMeasure.EXACTLY);
                break;
        }
        int specWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        if (View.MeasureSpec.getMode(widthMeasureSpec) != 0) {
            int i2 = this.m;
            if (i2 <= 0) {
                i2 = (int) (((float) specWidth) - lv0.c(getContext(), 56));
            }
            this.k = i2;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getChildCount() == 1) {
            View child = getChildAt(0);
            boolean remeasure = false;
            switch (this.s) {
                case 0:
                case 2:
                    if (child.getMeasuredWidth() < getMeasuredWidth()) {
                        z = true;
                    }
                    remeasure = z;
                    break;
                case 1:
                    if (child.getMeasuredWidth() != getMeasuredWidth()) {
                        z = true;
                    }
                    remeasure = z;
                    break;
            }
            if (remeasure) {
                child.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), child.getLayoutParams().height));
            }
        }
    }

    private void I(int position) {
        i view = (i) this.f1915a.getChildAt(position);
        this.f1915a.removeViewAt(position);
        if (view != null) {
            view.m();
            this.f1910a.release(view);
        }
        requestLayout();
    }

    private void n(int newPosition) {
        if (newPosition != -1) {
            if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.f1915a.d()) {
                M(newPosition, 0.0f, true);
                return;
            }
            int startScrollX = getScrollX();
            int targetScrollX = q(newPosition, 0.0f);
            if (startScrollX != targetScrollX) {
                z();
                this.f1905a.setIntValues(new int[]{startScrollX, targetScrollX});
                this.f1905a.start();
            }
            this.f1915a.c(newPosition, this.q);
        }
    }

    private void z() {
        if (this.f1905a == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f1905a = valueAnimator;
            valueAnimator.setInterpolator(this.f1904a);
            this.f1905a.setDuration((long) this.q);
            this.f1905a.addUpdateListener(new a());
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            TabLayout.this.scrollTo(((Integer) animator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener listener) {
        z();
        this.f1905a.addListener(listener);
    }

    private void setSelectedTabView(int position) {
        int tabCount = this.f1915a.getChildCount();
        if (position < tabCount) {
            int i2 = 0;
            while (i2 < tabCount) {
                View child = this.f1915a.getChildAt(i2);
                boolean z = false;
                if ((i2 != position || child.isSelected()) && (i2 == position || !child.isSelected())) {
                    child.setSelected(i2 == position);
                    if (i2 == position) {
                        z = true;
                    }
                    child.setActivated(z);
                } else {
                    child.setSelected(i2 == position);
                    if (i2 == position) {
                        z = true;
                    }
                    child.setActivated(z);
                    if (child instanceof i) {
                        ((i) child).u();
                    }
                }
                i2++;
            }
        }
    }

    public void J(g tab) {
        K(tab, true);
    }

    public void K(g tab, boolean updateIndicator) {
        g currentTab = this.f1916a;
        if (currentTab != tab) {
            int newPosition = tab != null ? tab.g() : -1;
            if (updateIndicator) {
                if ((currentTab == null || currentTab.g() == -1) && newPosition != -1) {
                    M(newPosition, 0.0f, true);
                } else {
                    n(newPosition);
                }
                if (newPosition != -1) {
                    setSelectedTabView(newPosition);
                }
            }
            this.f1916a = tab;
            if (!(currentTab == null || currentTab.f1938a == null)) {
                y(currentTab);
            }
            if (tab != null) {
                x(tab);
            }
        } else if (currentTab != null) {
            w(tab);
            n(tab.g());
        }
    }

    private void x(g tab) {
        for (int i2 = this.f1925b.size() - 1; i2 >= 0; i2--) {
            this.f1925b.get(i2).c(tab);
        }
    }

    private void y(g tab) {
        for (int i2 = this.f1925b.size() - 1; i2 >= 0; i2--) {
            this.f1925b.get(i2).b(tab);
        }
    }

    private void w(g tab) {
        for (int i2 = this.f1925b.size() - 1; i2 >= 0; i2--) {
            this.f1925b.get(i2).a(tab);
        }
    }

    private int q(int position, float positionOffset) {
        View selectedChild;
        View nextChild;
        int i2 = this.s;
        int nextWidth = 0;
        if ((i2 != 0 && i2 != 2) || (selectedChild = this.f1915a.getChildAt(position)) == null) {
            return 0;
        }
        if (position + 1 < this.f1915a.getChildCount()) {
            nextChild = this.f1915a.getChildAt(position + 1);
        } else {
            nextChild = null;
        }
        int selectedWidth = selectedChild.getWidth();
        if (nextChild != null) {
            nextWidth = nextChild.getWidth();
        }
        int scrollBase = (selectedChild.getLeft() + (selectedWidth / 2)) - (getWidth() / 2);
        int scrollOffset = (int) (((float) (selectedWidth + nextWidth)) * 0.5f * positionOffset);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            return scrollBase + scrollOffset;
        }
        return scrollBase - scrollOffset;
    }

    private void p() {
        int paddingStart = 0;
        int i2 = this.s;
        if (i2 == 0 || i2 == 2) {
            paddingStart = Math.max(0, this.o - this.f1922b);
        }
        ViewCompat.setPaddingRelative(this.f1915a, paddingStart, 0, 0, 0);
        switch (this.s) {
            case 0:
                o(this.p);
                break;
            case 1:
            case 2:
                if (this.p == 2) {
                    Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
                }
                this.f1915a.setGravity(1);
                break;
        }
        T(true);
    }

    private void o(int tabGravity) {
        switch (tabGravity) {
            case 0:
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
                break;
            case 1:
                this.f1915a.setGravity(1);
                return;
            case 2:
                break;
            default:
                return;
        }
        this.f1915a.setGravity(GravityCompat.START);
    }

    /* access modifiers changed from: package-private */
    public void T(boolean requestLayout) {
        for (int i2 = 0; i2 < this.f1915a.getChildCount(); i2++) {
            View child = this.f1915a.getChildAt(i2);
            child.setMinimumWidth(getTabMinWidth());
            S((LinearLayout.LayoutParams) child.getLayoutParams());
            if (requestLayout) {
                child.requestLayout();
            }
        }
    }

    public static class g {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        private Drawable f1935a;

        /* renamed from: a  reason: collision with other field name */
        private View f1936a;

        /* renamed from: a  reason: collision with other field name */
        public i f1937a;

        /* renamed from: a  reason: collision with other field name */
        public TabLayout f1938a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f1939a;

        /* renamed from: a  reason: collision with other field name */
        private Object f1940a;
        /* access modifiers changed from: private */
        public int b = 1;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with other field name */
        public CharSequence f1941b;
        /* access modifiers changed from: private */
        public int c = -1;

        public View e() {
            return this.f1936a;
        }

        public g m(View view) {
            this.f1936a = view;
            p();
            return this;
        }

        public Drawable f() {
            return this.f1935a;
        }

        public int g() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public void n(int position) {
            this.a = position;
        }

        public CharSequence i() {
            return this.f1939a;
        }

        public g o(CharSequence text) {
            if (TextUtils.isEmpty(this.f1941b) && !TextUtils.isEmpty(text)) {
                this.f1937a.setContentDescription(text);
            }
            this.f1939a = text;
            p();
            return this;
        }

        public int h() {
            return this.b;
        }

        public void l() {
            TabLayout tabLayout = this.f1938a;
            if (tabLayout != null) {
                tabLayout.J(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean j() {
            TabLayout tabLayout = this.f1938a;
            if (tabLayout != null) {
                int selectedPosition = tabLayout.getSelectedTabPosition();
                return selectedPosition != -1 && selectedPosition == this.a;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        /* access modifiers changed from: package-private */
        public void p() {
            i iVar = this.f1937a;
            if (iVar != null) {
                iVar.r();
            }
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f1938a = null;
            this.f1937a = null;
            this.f1940a = null;
            this.f1935a = null;
            this.c = -1;
            this.f1939a = null;
            this.f1941b = null;
            this.a = -1;
            this.f1936a = null;
        }
    }

    public final class i extends LinearLayout {
        private int a = 2;

        /* renamed from: a  reason: collision with other field name */
        private Drawable f1943a;

        /* renamed from: a  reason: collision with other field name */
        private View f1944a;

        /* renamed from: a  reason: collision with other field name */
        private ImageView f1945a;

        /* renamed from: a  reason: collision with other field name */
        private TextView f1946a;

        /* renamed from: a  reason: collision with other field name */
        private g f1947a;

        /* renamed from: a  reason: collision with other field name */
        private p5 f1949a;
        private View b;

        /* renamed from: b  reason: collision with other field name */
        private ImageView f1950b;

        /* renamed from: b  reason: collision with other field name */
        private TextView f1951b;

        public i(Context context) {
            super(context);
            s(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f1922b, TabLayout.this.f1927c, TabLayout.this.d, TabLayout.this.e);
            setGravity(17);
            setOrientation(TabLayout.this.f1920a ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        }

        /* access modifiers changed from: private */
        public void s(Context context) {
            Drawable background;
            int i = TabLayout.this.j;
            GradientDrawable gradientDrawable = null;
            if (i != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i);
                this.f1943a = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f1943a.setState(getDrawableState());
                }
            } else {
                this.f1943a = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            if (TabLayout.this.f1928c != null) {
                GradientDrawable maskDrawable = new GradientDrawable();
                maskDrawable.setCornerRadius(1.0E-5f);
                maskDrawable.setColor(-1);
                ColorStateList rippleColor = ye0.a(TabLayout.this.f1928c);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = TabLayout.this.f1929c;
                    GradientDrawable gradientDrawable3 = z ? null : gradientDrawable2;
                    if (!z) {
                        gradientDrawable = maskDrawable;
                    }
                    background = new RippleDrawable(rippleColor, gradientDrawable3, gradientDrawable);
                } else {
                    Drawable rippleDrawable = DrawableCompat.wrap(maskDrawable);
                    DrawableCompat.setTintList(rippleDrawable, rippleColor);
                    background = new LayerDrawable(new Drawable[]{gradientDrawable2, rippleDrawable});
                }
            } else {
                background = gradientDrawable2;
            }
            ViewCompat.setBackground(this, background);
            TabLayout.this.invalidate();
        }

        /* access modifiers changed from: private */
        public void h(Canvas canvas) {
            Drawable drawable = this.f1943a;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f1943a.draw(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            boolean changed = false;
            int[] state = getDrawableState();
            Drawable drawable = this.f1943a;
            if (drawable != null && drawable.isStateful()) {
                changed = false | this.f1943a.setState(state);
            }
            if (changed) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public boolean performClick() {
            boolean handled = super.performClick();
            if (this.f1947a == null) {
                return handled;
            }
            if (!handled) {
                playSoundEffect(0);
            }
            this.f1947a.l();
            return true;
        }

        public void setSelected(boolean selected) {
            boolean changed = isSelected() != selected;
            super.setSelected(selected);
            if (changed && selected && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f1946a;
            if (textView != null) {
                textView.setSelected(selected);
            }
            ImageView imageView = this.f1945a;
            if (imageView != null) {
                imageView.setSelected(selected);
            }
            View view = this.b;
            if (view != null) {
                view.setSelected(selected);
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(info);
            p5 p5Var = this.f1949a;
            if (p5Var != null && p5Var.isVisible()) {
                CharSequence customContentDescription = getContentDescription();
                info.setContentDescription(customContentDescription + ", " + this.f1949a.h());
            }
            AccessibilityNodeInfoCompat infoCompat = AccessibilityNodeInfoCompat.wrap(info);
            infoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f1947a.g(), 1, false, isSelected()));
            if (isSelected()) {
                infoCompat.setClickable(false);
                infoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            infoCompat.setRoleDescription(getResources().getString(sc0.item_view_role_description));
        }

        public void onMeasure(int origWidthMeasureSpec, int origHeightMeasureSpec) {
            int widthMeasureSpec;
            Layout layout;
            int specWidthSize = View.MeasureSpec.getSize(origWidthMeasureSpec);
            int specWidthMode = View.MeasureSpec.getMode(origWidthMeasureSpec);
            int maxWidth = TabLayout.this.getTabMaxWidth();
            int heightMeasureSpec = origHeightMeasureSpec;
            if (maxWidth <= 0 || (specWidthMode != 0 && specWidthSize <= maxWidth)) {
                widthMeasureSpec = origWidthMeasureSpec;
            } else {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(TabLayout.this.k, Integer.MIN_VALUE);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.f1946a != null) {
                float textSize = TabLayout.this.a;
                int maxLines = this.a;
                ImageView imageView = this.f1945a;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f1946a;
                    if (textView != null && textView.getLineCount() > 1) {
                        textSize = TabLayout.this.c;
                    }
                } else {
                    maxLines = 1;
                }
                float curTextSize = this.f1946a.getTextSize();
                int curLineCount = this.f1946a.getLineCount();
                int curMaxLines = TextViewCompat.getMaxLines(this.f1946a);
                if (textSize != curTextSize || (curMaxLines >= 0 && maxLines != curMaxLines)) {
                    boolean updateTextView = true;
                    if (TabLayout.this.s == 1 && textSize > curTextSize && curLineCount == 1 && ((layout = this.f1946a.getLayout()) == null || e(layout, 0, textSize) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        updateTextView = false;
                    }
                    if (updateTextView) {
                        this.f1946a.setTextSize(0, textSize);
                        this.f1946a.setMaxLines(maxLines);
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(@Nullable g tab) {
            if (tab != this.f1947a) {
                this.f1947a = tab;
                r();
            }
        }

        /* access modifiers changed from: package-private */
        public void m() {
            setTab((g) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public final void u() {
            ViewParent customViewParent;
            g tab = this.f1947a;
            View custom = tab != null ? tab.e() : null;
            if (custom != null) {
                ViewParent customParent = custom.getParent();
                if (customParent != this) {
                    if (customParent != null) {
                        ((ViewGroup) customParent).removeView(custom);
                    }
                    View view = this.b;
                    if (!(view == null || (customViewParent = view.getParent()) == null)) {
                        ((ViewGroup) customViewParent).removeView(this.b);
                    }
                    addView(custom);
                }
                this.b = custom;
                TextView textView = this.f1946a;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1945a;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1945a.setImageDrawable((Drawable) null);
                }
                TextView textView2 = (TextView) custom.findViewById(16908308);
                this.f1951b = textView2;
                if (textView2 != null) {
                    this.a = TextViewCompat.getMaxLines(textView2);
                }
                this.f1950b = (ImageView) custom.findViewById(16908294);
            } else {
                View view2 = this.b;
                if (view2 != null) {
                    removeView(view2);
                    this.b = null;
                }
                this.f1951b = null;
                this.f1950b = null;
            }
            if (this.b == null) {
                if (this.f1945a == null) {
                    k();
                }
                if (this.f1946a == null) {
                    l();
                    this.a = TextViewCompat.getMaxLines(this.f1946a);
                }
                TextViewCompat.setTextAppearance(this.f1946a, TabLayout.this.f);
                if (!isSelected() || TabLayout.this.h == -1) {
                    TextViewCompat.setTextAppearance(this.f1946a, TabLayout.this.g);
                } else {
                    TextViewCompat.setTextAppearance(this.f1946a, TabLayout.this.h);
                }
                ColorStateList colorStateList = TabLayout.this.f1906a;
                if (colorStateList != null) {
                    this.f1946a.setTextColor(colorStateList);
                }
                v(this.f1946a, this.f1945a, true);
                p();
                d(this.f1945a);
                d(this.f1946a);
            } else {
                TextView textView3 = this.f1951b;
                if (!(textView3 == null && this.f1950b == null)) {
                    v(textView3, this.f1950b, false);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.f1941b)) {
                setContentDescription(tab.f1941b);
            }
        }

        /* access modifiers changed from: package-private */
        public final void r() {
            u();
            g gVar = this.f1947a;
            setSelected(gVar != null && gVar.j());
        }

        private void k() {
            ViewGroup iconViewParent = this;
            if (r5.a) {
                iconViewParent = g();
                addView(iconViewParent, 0);
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(nc0.design_layout_tab_icon, iconViewParent, false);
            this.f1945a = imageView;
            iconViewParent.addView(imageView, 0);
        }

        private void l() {
            ViewGroup textViewParent = this;
            if (r5.a) {
                textViewParent = g();
                addView(textViewParent);
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(nc0.design_layout_tab_text, textViewParent, false);
            this.f1946a = textView;
            textViewParent.addView(textView);
        }

        private FrameLayout g() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        @NonNull
        private p5 getOrCreateBadge() {
            if (this.f1949a == null) {
                this.f1949a = p5.d(getContext());
            }
            p();
            p5 p5Var = this.f1949a;
            if (p5Var != null) {
                return p5Var;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Nullable
        private p5 getBadge() {
            return this.f1949a;
        }

        private void d(View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new a(view));
            }
        }

        class a implements View.OnLayoutChangeListener {
            final /* synthetic */ View a;

            a(View view) {
                this.a = view;
            }

            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (this.a.getVisibility() == 0) {
                    i.this.q(this.a);
                }
            }
        }

        private void p() {
            g gVar;
            g gVar2;
            if (j()) {
                if (this.b != null) {
                    o();
                } else if (this.f1945a != null && (gVar2 = this.f1947a) != null && gVar2.f() != null) {
                    View view = this.f1944a;
                    ImageView imageView = this.f1945a;
                    if (view != imageView) {
                        o();
                        n(this.f1945a);
                        return;
                    }
                    q(imageView);
                } else if (this.f1946a == null || (gVar = this.f1947a) == null || gVar.h() != 1) {
                    o();
                } else {
                    View view2 = this.f1944a;
                    TextView textView = this.f1946a;
                    if (view2 != textView) {
                        o();
                        n(this.f1946a);
                        return;
                    }
                    q(textView);
                }
            }
        }

        private void n(View anchorView) {
            if (j() && anchorView != null) {
                f(false);
                r5.a(this.f1949a, anchorView, i(anchorView));
                this.f1944a = anchorView;
            }
        }

        private void o() {
            if (j()) {
                f(true);
                View view = this.f1944a;
                if (view != null) {
                    r5.b(this.f1949a, view);
                    this.f1944a = null;
                }
            }
        }

        private void f(boolean flag) {
            setClipChildren(flag);
            setClipToPadding(flag);
            ViewGroup parent = (ViewGroup) getParent();
            if (parent != null) {
                parent.setClipChildren(flag);
                parent.setClipToPadding(flag);
            }
        }

        /* access modifiers changed from: package-private */
        public final void t() {
            setOrientation(TabLayout.this.f1920a ^ true ? 1 : 0);
            TextView textView = this.f1951b;
            if (textView == null && this.f1950b == null) {
                v(this.f1946a, this.f1945a, true);
            } else {
                v(textView, this.f1950b, false);
            }
        }

        private void v(TextView textView, ImageView iconView, boolean addDefaultMargins) {
            Drawable icon;
            g gVar = this.f1947a;
            CharSequence contentDesc = null;
            if (gVar == null || gVar.f() == null) {
                icon = null;
            } else {
                icon = DrawableCompat.wrap(this.f1947a.f()).mutate();
            }
            if (icon != null) {
                DrawableCompat.setTintList(icon, TabLayout.this.f1923b);
                PorterDuff.Mode mode = TabLayout.this.f1908a;
                if (mode != null) {
                    DrawableCompat.setTintMode(icon, mode);
                }
            }
            g gVar2 = this.f1947a;
            CharSequence text = gVar2 != null ? gVar2.i() : null;
            if (iconView != null) {
                if (icon != null) {
                    iconView.setImageDrawable(icon);
                    iconView.setVisibility(0);
                    setVisibility(0);
                } else {
                    iconView.setVisibility(8);
                    iconView.setImageDrawable((Drawable) null);
                }
            }
            boolean showingText = true;
            boolean hasText = !TextUtils.isEmpty(text);
            if (textView != null) {
                if (!hasText || this.f1947a.b != 1) {
                    showingText = false;
                }
                textView.setText(hasText ? text : null);
                textView.setVisibility(showingText ? 0 : 8);
                if (hasText) {
                    setVisibility(0);
                }
            } else {
                showingText = false;
            }
            if (addDefaultMargins && iconView != null) {
                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) iconView.getLayoutParams();
                int iconMargin = 0;
                if (showingText && iconView.getVisibility() == 0) {
                    iconMargin = (int) lv0.c(getContext(), 8);
                }
                if (TabLayout.this.f1920a) {
                    if (iconMargin != MarginLayoutParamsCompat.getMarginEnd(lp)) {
                        MarginLayoutParamsCompat.setMarginEnd(lp, iconMargin);
                        lp.bottomMargin = 0;
                        iconView.setLayoutParams(lp);
                        iconView.requestLayout();
                    }
                } else if (iconMargin != lp.bottomMargin) {
                    lp.bottomMargin = iconMargin;
                    MarginLayoutParamsCompat.setMarginEnd(lp, 0);
                    iconView.setLayoutParams(lp);
                    iconView.requestLayout();
                }
            }
            g gVar3 = this.f1947a;
            if (gVar3 != null) {
                contentDesc = gVar3.f1941b;
            }
            int i = Build.VERSION.SDK_INT;
            if (i < 21 || i > 23) {
                TooltipCompat.setTooltipText(this, hasText ? text : contentDesc);
            }
        }

        /* access modifiers changed from: private */
        public void q(View anchor) {
            if (j() && anchor == this.f1944a) {
                r5.c(this.f1949a, anchor, i(anchor));
            }
        }

        private boolean j() {
            return this.f1949a != null;
        }

        private FrameLayout i(View anchor) {
            if ((anchor == this.f1945a || anchor == this.f1946a) && r5.a) {
                return (FrameLayout) anchor.getParent();
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            boolean initialized = false;
            int left = 0;
            int right = 0;
            View[] viewArr = {this.f1946a, this.f1945a, this.b};
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    int left2 = view.getLeft();
                    if (initialized) {
                        left2 = Math.min(left, left2);
                    }
                    left = left2;
                    int right2 = view.getRight();
                    if (initialized) {
                        right2 = Math.max(right, right2);
                    }
                    right = right2;
                    initialized = true;
                }
            }
            return right - left;
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            boolean initialized = false;
            int top = 0;
            int bottom = 0;
            View[] viewArr = {this.f1946a, this.f1945a, this.b};
            for (int i = 0; i < 3; i++) {
                View view = viewArr[i];
                if (view != null && view.getVisibility() == 0) {
                    int top2 = view.getTop();
                    if (initialized) {
                        top2 = Math.min(top, top2);
                    }
                    top = top2;
                    int bottom2 = view.getBottom();
                    if (initialized) {
                        bottom2 = Math.max(bottom, bottom2);
                    }
                    bottom = bottom2;
                    initialized = true;
                }
            }
            return bottom - top;
        }

        @Nullable
        public g getTab() {
            return this.f1947a;
        }

        private float e(Layout layout, int line, float textSize) {
            return layout.getLineWidth(line) * (textSize / layout.getPaint().getTextSize());
        }
    }

    class f extends LinearLayout {
        private int a = -1;

        /* renamed from: a  reason: collision with other field name */
        ValueAnimator f1932a;

        f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        /* access modifiers changed from: package-private */
        public void i(int height) {
            Rect bounds = TabLayout.this.f1909a.getBounds();
            TabLayout.this.f1909a.setBounds(bounds.left, 0, bounds.right, height);
            requestLayout();
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            int z = getChildCount();
            for (int i = 0; i < z; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void h(int position, float positionOffset) {
            TabLayout.this.f1903a = Math.round(((float) position) + positionOffset);
            ValueAnimator valueAnimator = this.f1932a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f1932a.cancel();
            }
            j(getChildAt(position), getChildAt(position + 1), positionOffset);
        }

        public void onRtlPropertiesChanged(int layoutDirection) {
            super.onRtlPropertiesChanged(layoutDirection);
            if (Build.VERSION.SDK_INT < 23 && this.a != layoutDirection) {
                requestLayout();
                this.a = layoutDirection;
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                if (tabLayout.p == 1 || tabLayout.s == 2) {
                    int count = getChildCount();
                    int largestTabWidth = 0;
                    int z = count;
                    for (int i = 0; i < z; i++) {
                        View child = getChildAt(i);
                        if (child.getVisibility() == 0) {
                            largestTabWidth = Math.max(largestTabWidth, child.getMeasuredWidth());
                        }
                    }
                    if (largestTabWidth > 0) {
                        boolean remeasure = false;
                        if (largestTabWidth * count <= getMeasuredWidth() - (((int) lv0.c(getContext(), 16)) * 2)) {
                            for (int i2 = 0; i2 < count; i2++) {
                                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getChildAt(i2).getLayoutParams();
                                if (lp.width != largestTabWidth || lp.weight != 0.0f) {
                                    lp.width = largestTabWidth;
                                    lp.weight = 0.0f;
                                    remeasure = true;
                                }
                            }
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.p = 0;
                            tabLayout2.T(false);
                            remeasure = true;
                        }
                        if (remeasure) {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            ValueAnimator valueAnimator = this.f1932a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        private void f(int position) {
            if (TabLayout.this.v == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View currentView = getChildAt(position);
                c e = TabLayout.this.f1918a;
                TabLayout tabLayout = TabLayout.this;
                e.c(tabLayout, currentView, tabLayout.f1909a);
                TabLayout.this.f1903a = position;
            }
        }

        /* access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f1903a == -1) {
                tabLayout.f1903a = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.f1903a);
        }

        /* access modifiers changed from: private */
        public void j(View startTitle, View endTitle, float fraction) {
            if (startTitle != null && startTitle.getWidth() > 0) {
                c e = TabLayout.this.f1918a;
                TabLayout tabLayout = TabLayout.this;
                e.d(tabLayout, startTitle, endTitle, fraction, tabLayout.f1909a);
            } else {
                Drawable drawable = TabLayout.this.f1909a;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f1909a.getBounds().bottom);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }

        /* access modifiers changed from: package-private */
        public void c(int position, int duration) {
            ValueAnimator valueAnimator = this.f1932a;
            if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.f1903a == position)) {
                this.f1932a.cancel();
            }
            k(true, position, duration);
        }

        private void k(boolean recreateAnimation, int position, int duration) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f1903a != position) {
                View currentView = getChildAt(tabLayout.getSelectedTabPosition());
                View targetView = getChildAt(position);
                if (targetView == null) {
                    g();
                    return;
                }
                TabLayout.this.f1903a = position;
                ValueAnimator.AnimatorUpdateListener updateListener = new a(currentView, targetView);
                if (recreateAnimation) {
                    ValueAnimator animator = new ValueAnimator();
                    this.f1932a = animator;
                    animator.setInterpolator(TabLayout.this.f1904a);
                    animator.setDuration((long) duration);
                    animator.setFloatValues(new float[]{0.0f, 1.0f});
                    animator.addUpdateListener(updateListener);
                    animator.start();
                    return;
                }
                this.f1932a.removeAllUpdateListeners();
                this.f1932a.addUpdateListener(updateListener);
            }
        }

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ View a;
            final /* synthetic */ View b;

            a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.j(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        public void draw(Canvas canvas) {
            int indicatorHeight = TabLayout.this.f1909a.getBounds().height();
            if (indicatorHeight < 0) {
                indicatorHeight = TabLayout.this.f1909a.getIntrinsicHeight();
            }
            int indicatorTop = 0;
            int indicatorBottom = 0;
            switch (TabLayout.this.r) {
                case 0:
                    indicatorTop = getHeight() - indicatorHeight;
                    indicatorBottom = getHeight();
                    break;
                case 1:
                    indicatorTop = (getHeight() - indicatorHeight) / 2;
                    indicatorBottom = (getHeight() + indicatorHeight) / 2;
                    break;
                case 2:
                    indicatorTop = 0;
                    indicatorBottom = indicatorHeight;
                    break;
                case 3:
                    indicatorTop = 0;
                    indicatorBottom = getHeight();
                    break;
            }
            if (TabLayout.this.f1909a.getBounds().width() > 0) {
                Rect indicatorBounds = TabLayout.this.f1909a.getBounds();
                TabLayout.this.f1909a.setBounds(indicatorBounds.left, indicatorTop, indicatorBounds.right, indicatorBottom);
                TabLayout.this.f1909a.draw(canvas);
            }
            super.draw(canvas);
        }
    }

    private static ColorStateList s(int defaultColor, int selectedColor) {
        int[][] states = new int[2][];
        int[] colors = new int[2];
        states[0] = HorizontalScrollView.SELECTED_STATE_SET;
        colors[0] = selectedColor;
        int i2 = 0 + 1;
        states[i2] = HorizontalScrollView.EMPTY_STATE_SET;
        colors[i2] = defaultColor;
        int i3 = i2 + 1;
        return new ColorStateList(states, colors);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        boolean hasIconAndText = false;
        int i2 = 0;
        int count = this.f1919a.size();
        while (true) {
            if (i2 < count) {
                g tab = this.f1919a.get(i2);
                if (tab != null && tab.f() != null && !TextUtils.isEmpty(tab.i())) {
                    hasIconAndText = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!hasIconAndText || this.f1920a) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.l;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.s;
        if (i3 == 0 || i3 == 2) {
            return this.n;
        }
        return 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return generateDefaultLayoutParams();
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.k;
    }

    public static class h implements ViewPager.OnPageChangeListener {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private final WeakReference<TabLayout> f1942a;
        private int b;

        public h(TabLayout tabLayout) {
            this.f1942a = new WeakReference<>(tabLayout);
        }

        public void onPageScrollStateChanged(int state) {
            this.a = this.b;
            this.b = state;
            TabLayout tabLayout = (TabLayout) this.f1942a.get();
            if (tabLayout != null) {
                tabLayout.U(this.b);
            }
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            TabLayout tabLayout = (TabLayout) this.f1942a.get();
            if (tabLayout != null) {
                int i = this.b;
                boolean updateIndicator = true;
                boolean updateSelectedTabView = i != 2 || this.a == 1;
                if (i == 2 && this.a == 0) {
                    updateIndicator = false;
                }
                tabLayout.O(position, positionOffset, updateSelectedTabView, updateIndicator, false);
            }
        }

        public void onPageSelected(int position) {
            TabLayout tabLayout = (TabLayout) this.f1942a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != position && position < tabLayout.getTabCount()) {
                int i = this.b;
                tabLayout.K(tabLayout.A(position), i == 0 || (i == 2 && this.a == 0));
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.b = 0;
            this.a = 0;
        }
    }

    public static class j implements d {
        private final ViewPager a;

        public j(ViewPager viewPager) {
            this.a = viewPager;
        }

        public void c(g tab) {
            this.a.setCurrentItem(tab.g());
        }

        public void b(g tab) {
        }

        public void a(g tab) {
        }
    }

    private class e extends DataSetObserver {
        e() {
        }

        public void onChanged() {
            TabLayout.this.E();
        }

        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    private class b implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with other field name */
        private boolean f1931a;

        b() {
        }

        public void onAdapterChanged(ViewPager viewPager, PagerAdapter oldAdapter, PagerAdapter newAdapter) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f1912a == viewPager) {
                tabLayout.L(newAdapter, this.f1931a);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean autoRefresh) {
            this.f1931a = autoRefresh;
        }
    }
}
