package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int g = uc0.Widget_Design_AppBarLayout;
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private int f1404a;

    /* renamed from: a  reason: collision with other field name */
    private final long f1405a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f1406a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator.AnimatorUpdateListener f1407a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f1408a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1409a;

    /* renamed from: a  reason: collision with other field name */
    private WindowInsetsCompat f1410a;

    /* renamed from: a  reason: collision with other field name */
    private Behavior f1411a;

    /* renamed from: a  reason: collision with other field name */
    private Integer f1412a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<View> f1413a;

    /* renamed from: a  reason: collision with other field name */
    private List<b> f1414a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1415a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f1416a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private final List<f> f1417b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1418b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1419c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1420d;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1421e;
    private int f;

    /* renamed from: f  reason: collision with other field name */
    private final boolean f1422f;

    public interface b<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public static abstract class c {
        public abstract void a(AppBarLayout appBarLayout, View view, float f);
    }

    public interface f {
        void a(float f, int i);
    }

    public interface g extends b<AppBarLayout> {
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.appBarLayoutStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            r11 = this;
            int r4 = g
            android.content.Context r0 = defpackage.t00.c(r12, r13, r14, r4)
            r11.<init>(r0, r13, r14)
            r6 = -1
            r11.b = r6
            r11.c = r6
            r11.d = r6
            r7 = 0
            r11.e = r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r11.f1417b = r0
            android.content.Context r12 = r11.getContext()
            r8 = 1
            r11.setOrientation(r8)
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 21
            if (r9 < r10) goto L_0x0036
            android.view.ViewOutlineProvider r0 = r11.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L_0x0033
            com.google.android.material.appbar.e.a(r11)
        L_0x0033:
            com.google.android.material.appbar.e.c(r11, r13, r14, r4)
        L_0x0036:
            int[] r2 = defpackage.xc0.f5687k
            int[] r5 = new int[r7]
            r0 = r12
            r1 = r13
            r3 = r14
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.a
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            androidx.core.view.ViewCompat.setBackground(r11, r1)
            int r1 = defpackage.xc0.g
            android.content.res.ColorStateList r1 = defpackage.o00.a(r12, r0, r1)
            if (r1 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r8 = 0
        L_0x0054:
            r11.f1422f = r8
            android.graphics.drawable.Drawable r2 = r11.getBackground()
            android.content.res.ColorStateList r2 = defpackage.yh.f(r2)
            if (r2 == 0) goto L_0x0071
            p00 r3 = new p00
            r3.<init>()
            r3.V(r2)
            if (r1 == 0) goto L_0x006e
            r11.n(r3, r2, r1)
            goto L_0x0071
        L_0x006e:
            r11.o(r12, r3)
        L_0x0071:
            int r3 = defpackage.yb0.motionDurationMedium2
            android.content.res.Resources r4 = r11.getResources()
            int r5 = defpackage.lc0.app_bar_elevation_anim_duration
            int r4 = r4.getInteger(r5)
            int r3 = defpackage.i20.f(r12, r3, r4)
            long r3 = (long) r3
            r11.f1405a = r3
            int r3 = defpackage.yb0.motionEasingStandardInterpolator
            android.animation.TimeInterpolator r4 = defpackage.f3.a
            android.animation.TimeInterpolator r3 = defpackage.i20.g(r12, r3, r4)
            r11.f1406a = r3
            int r3 = defpackage.xc0.e
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x009e
            boolean r3 = r0.getBoolean(r3, r7)
            r11.A(r3, r7, r7)
        L_0x009e:
            if (r9 < r10) goto L_0x00b1
            int r3 = defpackage.xc0.d
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x00b1
            int r3 = r0.getDimensionPixelSize(r3, r7)
            float r3 = (float) r3
            com.google.android.material.appbar.e.b(r11, r3)
        L_0x00b1:
            r3 = 26
            if (r9 < r3) goto L_0x00d5
            int r3 = defpackage.xc0.c
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x00c5
            boolean r3 = r0.getBoolean(r3, r7)
            r11.setKeyboardNavigationCluster(r3)
        L_0x00c5:
            int r3 = defpackage.xc0.b
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L_0x00d5
            boolean r3 = r0.getBoolean(r3, r7)
            r11.setTouchscreenBlocksFocus(r3)
        L_0x00d5:
            android.content.res.Resources r3 = r11.getResources()
            int r4 = defpackage.cc0.design_appbar_elevation
            float r3 = r3.getDimension(r4)
            r11.a = r3
            int r3 = defpackage.xc0.f
            boolean r3 = r0.getBoolean(r3, r7)
            r11.f1421e = r3
            int r3 = defpackage.xc0.h
            int r3 = r0.getResourceId(r3, r6)
            r11.f = r3
            int r3 = defpackage.xc0.i
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            r11.setStatusBarForeground(r3)
            r0.recycle()
            com.google.android.material.appbar.AppBarLayout$a r3 = new com.google.android.material.appbar.AppBarLayout$a
            r3.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r11, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            return AppBarLayout.this.v(insets);
        }
    }

    private void n(p00 background, ColorStateList originalBackgroundColor, ColorStateList liftOnScrollColor) {
        this.f1407a = new r3(this, originalBackgroundColor, liftOnScrollColor, background, k00.f(getContext(), yb0.colorSurface));
        ViewCompat.setBackground(this, background);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(ColorStateList originalBackgroundColor, ColorStateList liftOnScrollColor, p00 background, Integer colorSurface, ValueAnimator valueAnimator) {
        Integer num;
        int mixedColor = k00.k(originalBackgroundColor.getDefaultColor(), liftOnScrollColor.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        background.V(ColorStateList.valueOf(mixedColor));
        if (!(this.f1409a == null || (num = this.f1412a) == null || !num.equals(colorSurface))) {
            DrawableCompat.setTint(this.f1409a, mixedColor);
        }
        if (!this.f1417b.isEmpty()) {
            for (f liftOnScrollListener : this.f1417b) {
                if (background.v() != null) {
                    liftOnScrollListener.a(0.0f, mixedColor);
                }
            }
        }
    }

    private void o(Context context, p00 background) {
        background.K(context);
        this.f1407a = new q3(this, background);
        ViewCompat.setBackground(this, background);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(p00 background, ValueAnimator valueAnimator) {
        float elevation = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        background.U(elevation);
        Drawable drawable = this.f1409a;
        if (drawable instanceof p00) {
            ((p00) drawable).U(elevation);
        }
        for (f liftOnScrollListener : this.f1417b) {
            liftOnScrollListener.a(elevation, background.y());
        }
    }

    public void c(b listener) {
        if (this.f1414a == null) {
            this.f1414a = new ArrayList();
        }
        if (listener != null && !this.f1414a.contains(listener)) {
            this.f1414a.add(listener);
        }
    }

    public void d(g listener) {
        c(listener);
    }

    public void w(b listener) {
        List<b> list = this.f1414a;
        if (list != null && listener != null) {
            list.remove(listener);
        }
    }

    public void x(g listener) {
        w(listener);
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f1409a;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1409a = drawable3;
            this.f1412a = f();
            Drawable drawable4 = this.f1409a;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.f1409a.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.f1409a, ViewCompat.getLayoutDirection(this));
                this.f1409a.setVisible(getVisibility() == 0, false);
                this.f1409a.setCallback(this);
            }
            I();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int color) {
        setStatusBarForeground(new ColorDrawable(color));
    }

    public void setStatusBarForegroundResource(@DrawableRes int resId) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), resId));
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.f1409a;
    }

    private Integer f() {
        Drawable drawable = this.f1409a;
        if (drawable instanceof p00) {
            return Integer.valueOf(((p00) drawable).y());
        }
        ColorStateList statusBarForegroundColorStateList = yh.f(drawable);
        if (statusBarForegroundColorStateList != null) {
            return Integer.valueOf(statusBarForegroundColorStateList.getDefaultColor());
        }
        return null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (E()) {
            int saveCount = canvas.save();
            canvas.translate(0.0f, (float) (-this.f1404a));
            this.f1409a.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        Drawable d2 = this.f1409a;
        if (d2 != null && d2.isStateful() && d2.setState(state)) {
            invalidateDrawable(d2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.f1409a;
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.f1409a;
        if (drawable != null) {
            drawable.setVisible(visible, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && G()) {
            int newHeight = getMeasuredHeight();
            switch (heightMode) {
                case Integer.MIN_VALUE:
                    newHeight = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(heightMeasureSpec));
                    break;
                case 0:
                    newHeight += getTopInset();
                    break;
            }
            setMeasuredDimension(getMeasuredWidth(), newHeight);
        }
        p();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        super.onLayout(changed, l, t, r, b2);
        boolean z = true;
        if (ViewCompat.getFitsSystemWindows(this) && G()) {
            int topInset = getTopInset();
            for (int z2 = getChildCount() - 1; z2 >= 0; z2--) {
                ViewCompat.offsetTopAndBottom(getChildAt(z2), topInset);
            }
        }
        p();
        this.f1415a = false;
        int i = 0;
        int z3 = getChildCount();
        while (true) {
            if (i >= z3) {
                break;
            } else if (((e) getChildAt(i).getLayoutParams()).d() != null) {
                this.f1415a = true;
                break;
            } else {
                i++;
            }
        }
        Drawable drawable = this.f1409a;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f1418b) {
            if (!this.f1421e && !l()) {
                z = false;
            }
            B(z);
        }
    }

    private void I() {
        setWillNotDraw(!E());
    }

    private boolean E() {
        return this.f1409a != null && getTopInset() > 0;
    }

    private boolean l() {
        int z = getChildCount();
        for (int i = 0; i < z; i++) {
            if (((e) getChildAt(i).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void p() {
        Behavior behavior = this.f1411a;
        BaseBehavior.e savedState = (behavior == null || this.b == -1 || this.e != 0) ? null : behavior.P(AbsSavedState.EMPTY_STATE, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if (savedState != null) {
            this.f1411a.O(savedState, false);
        }
    }

    public void setOrientation(int orientation) {
        if (orientation == 1) {
            super.setOrientation(orientation);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q00.e(this);
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f1411a = behavior;
        return behavior;
    }

    @Nullable
    public p00 getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof p00) {
            return (p00) background;
        }
        return null;
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        q00.d(this, elevation);
    }

    public void setExpanded(boolean expanded) {
        z(expanded, ViewCompat.isLaidOut(this));
    }

    public void z(boolean expanded, boolean animate) {
        A(expanded, animate, true);
    }

    private void A(boolean expanded, boolean animate, boolean force) {
        int i = 0;
        int i2 = (expanded ? 1 : 2) | (animate ? 4 : 0);
        if (force) {
            i = 8;
        }
        this.e = i2 | i;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        return new e(-1, -2);
    }

    /* renamed from: i */
    public e generateLayoutParams(AttributeSet attrs) {
        return new e(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public e generateLayoutParams(ViewGroup.LayoutParams p) {
        if (Build.VERSION.SDK_INT >= 19 && (p instanceof LinearLayout.LayoutParams)) {
            return new e((LinearLayout.LayoutParams) p);
        }
        if (p instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) p);
        }
        return new e(p);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f1415a;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            if (child.getVisibility() != 8) {
                e lp = (e) child.getLayoutParams();
                int childHeight = child.getMeasuredHeight();
                int flags = lp.a;
                if ((flags & 1) == 0) {
                    break;
                }
                range += lp.topMargin + childHeight + lp.bottomMargin;
                if (i2 == 0 && ViewCompat.getFitsSystemWindows(child)) {
                    range -= getTopInset();
                }
                if ((flags & 2) != 0) {
                    range -= ViewCompat.getMinimumHeight(child);
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, range);
        this.b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int childRange;
        int i = this.c;
        if (i != -1) {
            return i;
        }
        int range = 0;
        for (int i2 = getChildCount() - 1; i2 >= 0; i2--) {
            View child = getChildAt(i2);
            if (child.getVisibility() != 8) {
                e lp = (e) child.getLayoutParams();
                int childHeight = child.getMeasuredHeight();
                int flags = lp.a;
                if ((flags & 5) == 5) {
                    int childRange2 = lp.topMargin + lp.bottomMargin;
                    if ((flags & 8) != 0) {
                        childRange = childRange2 + ViewCompat.getMinimumHeight(child);
                    } else if ((flags & 2) != 0) {
                        childRange = childRange2 + (childHeight - ViewCompat.getMinimumHeight(child));
                    } else {
                        childRange = childRange2 + childHeight;
                    }
                    if (i2 == 0 && ViewCompat.getFitsSystemWindows(child)) {
                        childRange = Math.min(childRange, childHeight - getTopInset());
                    }
                    range += childRange;
                } else if (range > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, range);
        this.c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int range = 0;
        int i2 = 0;
        int z = getChildCount();
        while (true) {
            if (i2 >= z) {
                break;
            }
            View child = getChildAt(i2);
            if (child.getVisibility() != 8) {
                e lp = (e) child.getLayoutParams();
                int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
                int flags = lp.a;
                if ((flags & 1) == 0) {
                    break;
                }
                range += childHeight;
                if ((flags & 2) != 0) {
                    range -= ViewCompat.getMinimumHeight(child);
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, range);
        this.d = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public void u(int offset) {
        this.f1404a = offset;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<b> list = this.f1414a;
        if (list != null) {
            int z = list.size();
            for (int i = 0; i < z; i++) {
                b listener = this.f1414a.get(i);
                if (listener != null) {
                    listener.a(this, offset);
                }
            }
        }
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minHeight = ViewCompat.getMinimumHeight(this);
        if (minHeight != 0) {
            return (minHeight * 2) + topInset;
        }
        int childCount = getChildCount();
        int lastChildMinHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
        if (lastChildMinHeight != 0) {
            return (lastChildMinHeight * 2) + topInset;
        }
        return getHeight() / 3;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        if (this.f1416a == null) {
            this.f1416a = new int[4];
        }
        int[] extraStates = this.f1416a;
        int[] states = super.onCreateDrawableState(extraStates.length + extraSpace);
        boolean z = this.f1419c;
        int i = yb0.state_liftable;
        if (!z) {
            i = -i;
        }
        extraStates[0] = i;
        extraStates[1] = (!z || !this.f1420d) ? -yb0.state_lifted : yb0.state_lifted;
        int i2 = yb0.state_collapsible;
        if (!z) {
            i2 = -i2;
        }
        extraStates[2] = i2;
        extraStates[3] = (!z || !this.f1420d) ? -yb0.state_collapsed : yb0.state_collapsed;
        return LinearLayout.mergeDrawableStates(states, extraStates);
    }

    public void setLiftableOverrideEnabled(boolean enabled) {
        this.f1418b = enabled;
    }

    private boolean B(boolean liftable) {
        if (this.f1419c == liftable) {
            return false;
        }
        this.f1419c = liftable;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean C(boolean lifted) {
        return D(lifted, !this.f1418b);
    }

    /* access modifiers changed from: package-private */
    public boolean D(boolean lifted, boolean force) {
        if (!force || this.f1420d == lifted) {
            return false;
        }
        this.f1420d = lifted;
        refreshDrawableState();
        if (!r()) {
            return true;
        }
        float f2 = 0.0f;
        if (this.f1422f) {
            float f3 = lifted ? 0.0f : 1.0f;
            if (lifted) {
                f2 = 1.0f;
            }
            H(f3, f2);
            return true;
        } else if (!this.f1421e) {
            return true;
        } else {
            float f4 = lifted ? 0.0f : this.a;
            if (lifted) {
                f2 = this.a;
            }
            H(f4, f2);
            return true;
        }
    }

    private boolean r() {
        return getBackground() instanceof p00;
    }

    private void H(float fromValue, float toValue) {
        ValueAnimator valueAnimator = this.f1408a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{fromValue, toValue});
        this.f1408a = ofFloat;
        ofFloat.setDuration(this.f1405a);
        this.f1408a.setInterpolator(this.f1406a);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f1407a;
        if (animatorUpdateListener != null) {
            this.f1408a.addUpdateListener(animatorUpdateListener);
        }
        this.f1408a.start();
    }

    public void setLiftOnScroll(boolean liftOnScroll) {
        this.f1421e = liftOnScroll;
    }

    public boolean q() {
        return this.f1421e;
    }

    public void setLiftOnScrollTargetView(@Nullable View liftOnScrollTargetView) {
        this.f = -1;
        if (liftOnScrollTargetView == null) {
            e();
        } else {
            this.f1413a = new WeakReference<>(liftOnScrollTargetView);
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int liftOnScrollTargetViewId) {
        this.f = liftOnScrollTargetViewId;
        e();
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public boolean F(View defaultScrollingView) {
        View scrollingView = g(defaultScrollingView);
        if (scrollingView == null) {
            scrollingView = defaultScrollingView;
        }
        return scrollingView != null && (scrollingView.canScrollVertically(-1) || scrollingView.getScrollY() > 0);
    }

    private View g(View defaultScrollingView) {
        int i;
        if (this.f1413a == null && (i = this.f) != -1) {
            View targetView = null;
            if (defaultScrollingView != null) {
                targetView = defaultScrollingView.findViewById(i);
            }
            if (targetView == null && (getParent() instanceof ViewGroup)) {
                targetView = ((ViewGroup) getParent()).findViewById(this.f);
            }
            if (targetView != null) {
                this.f1413a = new WeakReference<>(targetView);
            }
        }
        WeakReference<View> weakReference = this.f1413a;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private void e() {
        WeakReference<View> weakReference = this.f1413a;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f1413a = null;
    }

    @Deprecated
    public void setTargetElevation(float elevation) {
        if (Build.VERSION.SDK_INT >= 21) {
            e.b(this, elevation);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public void y() {
        this.e = 0;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f1410a;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    private boolean G() {
        if (getChildCount() <= 0) {
            return false;
        }
        View firstChild = getChildAt(0);
        if (firstChild.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(firstChild)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat v(WindowInsetsCompat insets) {
        WindowInsetsCompat newInsets = null;
        if (ViewCompat.getFitsSystemWindows(this)) {
            newInsets = insets;
        }
        if (!ObjectsCompat.equals(this.f1410a, newInsets)) {
            this.f1410a = newInsets;
            I();
            requestLayout();
        }
        return insets;
    }

    public static class e extends LinearLayout.LayoutParams {
        int a = 1;

        /* renamed from: a  reason: collision with other field name */
        Interpolator f1435a;

        /* renamed from: a  reason: collision with other field name */
        private c f1436a;

        public e(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a2 = c.obtainStyledAttributes(attrs, xc0.f5693m);
            this.a = a2.getInt(xc0.k, 0);
            f(a2.getInt(xc0.j, 0));
            int i = xc0.l;
            if (a2.hasValue(i)) {
                this.f1435a = AnimationUtils.loadInterpolator(c, a2.getResourceId(i, 0));
            }
            a2.recycle();
        }

        public e(int width, int height) {
            super(width, height);
        }

        public e(ViewGroup.LayoutParams p) {
            super(p);
        }

        public e(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public e(LinearLayout.LayoutParams source) {
            super(source);
        }

        public int c() {
            return this.a;
        }

        private c a(int scrollEffectInt) {
            switch (scrollEffectInt) {
                case 1:
                    return new d();
                default:
                    return null;
            }
        }

        public c b() {
            return this.f1436a;
        }

        public void f(int scrollEffect) {
            this.f1436a = a(scrollEffect);
        }

        public Interpolator d() {
            return this.f1435a;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int i = this.a;
            return (i & 1) == 1 && (i & 10) != 0;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ void I(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void J(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        public /* bridge */ /* synthetic */ void K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ void N(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i);
        }

        public /* bridge */ /* synthetic */ int a() {
            return super.a();
        }

        public /* bridge */ /* synthetic */ boolean c(int i) {
            return super.c(i);
        }

        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends a<T> {
        private ValueAnimator a;

        /* renamed from: a  reason: collision with other field name */
        private e f1423a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<View> f1424a;
        /* access modifiers changed from: private */
        public boolean b;
        /* access modifiers changed from: private */
        public int f;
        private int g;

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* renamed from: M */
        public boolean onStartNestedScroll(CoordinatorLayout parent, T child, View directTargetChild, View target, int nestedScrollAxes, int type) {
            ValueAnimator valueAnimator;
            boolean started = (nestedScrollAxes & 2) != 0 && (child.q() || v(parent, child, directTargetChild));
            if (started && (valueAnimator = this.a) != null) {
                valueAnimator.cancel();
            }
            this.f1424a = null;
            this.g = type;
            return started;
        }

        private boolean v(CoordinatorLayout parent, T child, View directTargetChild) {
            return child.m() && parent.getHeight() - directTargetChild.getHeight() <= child.getHeight();
        }

        /* renamed from: I */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T child, View target, int dx, int dy, int[] consumed, int type) {
            int max;
            int min;
            if (dy != 0) {
                if (dy < 0) {
                    int min2 = -child.getTotalScrollRange();
                    min = min2;
                    max = child.getDownNestedPreScrollRange() + min2;
                } else {
                    min = -child.getUpNestedPreScrollRange();
                    max = 0;
                }
                if (min != max) {
                    consumed[1] = k(coordinatorLayout, child, dy, min, max);
                }
            }
            if (child.q()) {
                T t = child;
                child.C(child.F(target));
                return;
            }
            T t2 = child;
        }

        /* renamed from: J */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
            if (dyUnconsumed < 0) {
                consumed[1] = k(coordinatorLayout, child, dyUnconsumed, -child.getDownNestedScrollRange(), 0);
            }
            if (dyUnconsumed == 0) {
                T(coordinatorLayout, child);
            }
        }

        /* renamed from: N */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T abl, View target, int type) {
            if (this.g == 0 || type == 1) {
                S(coordinatorLayout, abl);
                if (abl.q()) {
                    abl.C(abl.F(target));
                }
            }
            this.f1424a = new WeakReference<>(target);
        }

        private void r(CoordinatorLayout coordinatorLayout, T child, int offset, float velocity) {
            int duration;
            int distance = Math.abs(i() - offset);
            float velocity2 = Math.abs(velocity);
            if (velocity2 > 0.0f) {
                duration = Math.round((((float) distance) / velocity2) * 1000.0f) * 3;
            } else {
                duration = (int) ((1.0f + (((float) distance) / ((float) child.getHeight()))) * 150.0f);
            }
            s(coordinatorLayout, child, offset, duration);
        }

        private void s(CoordinatorLayout coordinatorLayout, T child, int offset, int duration) {
            int currentOffset = i();
            if (currentOffset == offset) {
                ValueAnimator valueAnimator = this.a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.a.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.a;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.a = valueAnimator3;
                valueAnimator3.setInterpolator(f3.e);
                this.a.addUpdateListener(new a(coordinatorLayout, child));
            } else {
                valueAnimator2.cancel();
            }
            this.a.setDuration((long) Math.min(duration, 600));
            this.a.setIntValues(new int[]{currentOffset, offset});
            this.a.start();
        }

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ AppBarLayout f1426a;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.f1426a = appBarLayout;
            }

            public void onAnimationUpdate(ValueAnimator animator) {
                BaseBehavior.this.l(this.a, this.f1426a, ((Integer) animator.getAnimatedValue()).intValue());
            }
        }

        private int A(T abl, int offset) {
            int count = abl.getChildCount();
            for (int i = 0; i < count; i++) {
                View child = abl.getChildAt(i);
                int top = child.getTop();
                int bottom = child.getBottom();
                e lp = (e) child.getLayoutParams();
                if (w(lp.c(), 32)) {
                    top -= lp.topMargin;
                    bottom += lp.bottomMargin;
                }
                if (top <= (-offset) && bottom >= (-offset)) {
                    return i;
                }
            }
            return -1;
        }

        private void S(CoordinatorLayout coordinatorLayout, T abl) {
            int topInset = abl.getTopInset() + abl.getPaddingTop();
            int offset = i() - topInset;
            int offsetChildIndex = A(abl, offset);
            if (offsetChildIndex >= 0) {
                View offsetChild = abl.getChildAt(offsetChildIndex);
                e lp = (e) offsetChild.getLayoutParams();
                int flags = lp.c();
                if ((flags & 17) == 17) {
                    int snapTop = -offsetChild.getTop();
                    int snapBottom = -offsetChild.getBottom();
                    if (offsetChildIndex == 0 && ViewCompat.getFitsSystemWindows(abl) && ViewCompat.getFitsSystemWindows(offsetChild)) {
                        snapTop -= abl.getTopInset();
                    }
                    if (w(flags, 2)) {
                        snapBottom += ViewCompat.getMinimumHeight(offsetChild);
                    } else if (w(flags, 5)) {
                        int seam = ViewCompat.getMinimumHeight(offsetChild) + snapBottom;
                        if (offset < seam) {
                            snapTop = seam;
                        } else {
                            snapBottom = seam;
                        }
                    }
                    if (w(flags, 32)) {
                        snapTop += lp.topMargin;
                        snapBottom -= lp.bottomMargin;
                    }
                    r(coordinatorLayout, abl, MathUtils.clamp(t(offset, snapBottom, snapTop) + topInset, -abl.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private int t(int value, int bottom, int top) {
            return value < (bottom + top) / 2 ? bottom : top;
        }

        private static boolean w(int flags, int check) {
            return (flags & check) == check;
        }

        /* renamed from: H */
        public boolean onMeasureChild(CoordinatorLayout parent, T child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            if (((CoordinatorLayout.LayoutParams) child.getLayoutParams()).height != -2) {
                return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
            }
            parent.onMeasureChild(child, parentWidthMeasureSpec, widthUsed, View.MeasureSpec.makeMeasureSpec(0, 0), heightUsed);
            return true;
        }

        /* renamed from: G */
        public boolean onLayoutChild(CoordinatorLayout parent, T abl, int layoutDirection) {
            int offset;
            boolean handled = super.onLayoutChild(parent, abl, layoutDirection);
            int pendingAction = abl.getPendingAction();
            e eVar = this.f1423a;
            if (eVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean animate = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int offset2 = -abl.getUpNestedPreScrollRange();
                        if (animate) {
                            r(parent, abl, offset2, 0.0f);
                        } else {
                            l(parent, abl, offset2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (animate) {
                            r(parent, abl, 0, 0.0f);
                        } else {
                            l(parent, abl, 0);
                        }
                    }
                }
            } else if (eVar.f1434a) {
                l(parent, abl, -abl.getTotalScrollRange());
            } else if (eVar.b) {
                l(parent, abl, 0);
            } else {
                View child = abl.getChildAt(eVar.f1433a);
                int offset3 = -child.getBottom();
                if (this.f1423a.c) {
                    offset = offset3 + ViewCompat.getMinimumHeight(child) + abl.getTopInset();
                } else {
                    offset = offset3 + Math.round(((float) child.getHeight()) * this.f1423a.a);
                }
                l(parent, abl, offset);
            }
            abl.y();
            this.f1423a = null;
            c(MathUtils.clamp(a(), -abl.getTotalScrollRange(), 0));
            U(parent, abl, a(), 0, true);
            abl.u(a());
            T(parent, abl);
            return handled;
        }

        private void T(CoordinatorLayout coordinatorLayout, T appBarLayout) {
            View scrollingView;
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            if (appBarLayout.getTotalScrollRange() != 0 && (scrollingView = B(coordinatorLayout)) != null && x(appBarLayout)) {
                if (!ViewCompat.hasAccessibilityDelegate(coordinatorLayout)) {
                    ViewCompat.setAccessibilityDelegate(coordinatorLayout, new b());
                }
                this.b = p(coordinatorLayout, appBarLayout, scrollingView);
            }
        }

        class b extends AccessibilityDelegateCompat {
            b() {
            }

            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setScrollable(BaseBehavior.this.b);
                info.setClassName(ScrollView.class.getName());
            }
        }

        private View B(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = coordinatorLayout.getChildAt(i);
                if (((CoordinatorLayout.LayoutParams) child.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) {
                    return child;
                }
            }
            return null;
        }

        private boolean x(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (((e) appBarLayout.getChildAt(i).getLayoutParams()).a != 0) {
                    return true;
                }
            }
            return false;
        }

        private boolean p(CoordinatorLayout coordinatorLayout, T appBarLayout, View scrollingView) {
            boolean a11yScrollable = false;
            if (i() != (-appBarLayout.getTotalScrollRange())) {
                q(coordinatorLayout, appBarLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
                a11yScrollable = true;
            }
            if (i() == 0) {
                return a11yScrollable;
            }
            if (scrollingView.canScrollVertically(-1)) {
                int dy = -appBarLayout.getDownNestedPreScrollRange();
                if (dy == 0) {
                    return a11yScrollable;
                }
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, (CharSequence) null, new c(coordinatorLayout, appBarLayout, scrollingView, dy));
                return true;
            }
            q(coordinatorLayout, appBarLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            return true;
        }

        class c implements AccessibilityViewCommand {
            final /* synthetic */ int a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ View f1427a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ CoordinatorLayout f1428a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ AppBarLayout f1430a;

            c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
                this.f1428a = coordinatorLayout;
                this.f1430a = appBarLayout;
                this.f1427a = view;
                this.a = i;
            }

            public boolean perform(View view, AccessibilityViewCommand.CommandArguments arguments) {
                BaseBehavior.this.onNestedPreScroll(this.f1428a, this.f1430a, this.f1427a, 0, this.a, new int[]{0, 0}, 1);
                return true;
            }
        }

        private void q(CoordinatorLayout parent, T appBarLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat action, boolean expand) {
            ViewCompat.replaceAccessibilityAction(parent, action, (CharSequence) null, new d(appBarLayout, expand));
        }

        class d implements AccessibilityViewCommand {

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ AppBarLayout f1431a;

            /* renamed from: a  reason: collision with other field name */
            final /* synthetic */ boolean f1432a;

            d(AppBarLayout appBarLayout, boolean z) {
                this.f1431a = appBarLayout;
                this.f1432a = z;
            }

            public boolean perform(View view, AccessibilityViewCommand.CommandArguments arguments) {
                this.f1431a.setExpanded(this.f1432a);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: u */
        public boolean d(T t) {
            WeakReference<View> weakReference = this.f1424a;
            if (weakReference == null) {
                return true;
            }
            View scrollingView = (View) weakReference.get();
            if (scrollingView == null || !scrollingView.isShown() || scrollingView.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: F */
        public void j(CoordinatorLayout parent, T layout) {
            S(parent, layout);
            if (layout.q()) {
                layout.C(layout.F(y(parent)));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: C */
        public int g(T view) {
            return (-view.getDownNestedScrollRange()) + view.getTopInset();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: D */
        public int h(T view) {
            return view.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Q */
        public int m(CoordinatorLayout coordinatorLayout, T appBarLayout, int newOffset, int minOffset, int maxOffset) {
            int i;
            int curOffset = i();
            int consumed = 0;
            if (minOffset == 0 || curOffset < minOffset || curOffset > maxOffset) {
                this.f = 0;
            } else {
                int newOffset2 = MathUtils.clamp(newOffset, minOffset, maxOffset);
                if (curOffset != newOffset2) {
                    if (appBarLayout.k()) {
                        i = E(appBarLayout, newOffset2);
                    } else {
                        i = newOffset2;
                    }
                    int interpolatedOffset = i;
                    boolean offsetChanged = c(interpolatedOffset);
                    consumed = curOffset - newOffset2;
                    this.f = newOffset2 - interpolatedOffset;
                    if (offsetChanged) {
                        for (int i2 = 0; i2 < appBarLayout.getChildCount(); i2++) {
                            e params = (e) appBarLayout.getChildAt(i2).getLayoutParams();
                            c scrollEffect = params.b();
                            if (!(scrollEffect == null || (params.c() & 1) == 0)) {
                                scrollEffect.a(appBarLayout, appBarLayout.getChildAt(i2), (float) a());
                            }
                        }
                    }
                    if (!offsetChanged && appBarLayout.k()) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.u(a());
                    U(coordinatorLayout, appBarLayout, newOffset2, newOffset2 < curOffset ? -1 : 1, false);
                }
            }
            T(coordinatorLayout, appBarLayout);
            return consumed;
        }

        private int E(T layout, int offset) {
            int absOffset = Math.abs(offset);
            int i = 0;
            int z = layout.getChildCount();
            while (true) {
                if (i >= z) {
                    break;
                }
                View child = layout.getChildAt(i);
                e childLp = (e) child.getLayoutParams();
                Interpolator interpolator = childLp.d();
                if (absOffset < child.getTop() || absOffset > child.getBottom()) {
                    i++;
                } else if (interpolator != null) {
                    int childScrollableHeight = 0;
                    int flags = childLp.c();
                    if ((flags & 1) != 0) {
                        childScrollableHeight = 0 + child.getHeight() + childLp.topMargin + childLp.bottomMargin;
                        if ((flags & 2) != 0) {
                            childScrollableHeight -= ViewCompat.getMinimumHeight(child);
                        }
                    }
                    if (ViewCompat.getFitsSystemWindows(child)) {
                        childScrollableHeight -= layout.getTopInset();
                    }
                    if (childScrollableHeight > 0) {
                        return Integer.signum(offset) * (child.getTop() + Math.round(((float) childScrollableHeight) * interpolator.getInterpolation(((float) (absOffset - child.getTop())) / ((float) childScrollableHeight))));
                    }
                }
            }
            return offset;
        }

        private void U(CoordinatorLayout parent, T layout, int offset, int direction, boolean forceJump) {
            View child = z(layout, offset);
            boolean lifted = false;
            if (child != null) {
                int flags = ((e) child.getLayoutParams()).c();
                if ((flags & 1) != 0) {
                    int minHeight = ViewCompat.getMinimumHeight(child);
                    boolean z = false;
                    if (direction > 0 && (flags & 12) != 0) {
                        if ((-offset) >= (child.getBottom() - minHeight) - layout.getTopInset()) {
                            z = true;
                        }
                        lifted = z;
                    } else if ((flags & 2) != 0) {
                        if ((-offset) >= (child.getBottom() - minHeight) - layout.getTopInset()) {
                            z = true;
                        }
                        lifted = z;
                    }
                }
            }
            if (layout.q()) {
                lifted = layout.F(y(parent));
            }
            boolean changed = layout.C(lifted);
            if (forceJump || (changed && R(parent, layout))) {
                if (layout.getBackground() != null) {
                    layout.getBackground().jumpToCurrentState();
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 23 && layout.getForeground() != null) {
                    layout.getForeground().jumpToCurrentState();
                }
                if (i >= 21 && layout.getStateListAnimator() != null) {
                    layout.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private boolean R(CoordinatorLayout parent, T layout) {
            List<View> dependencies = parent.getDependents(layout);
            int size = dependencies.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependencies.get(i).getLayoutParams()).getBehavior();
                if (behavior instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behavior).g() != 0;
                }
            }
            return false;
        }

        private static View z(AppBarLayout layout, int offset) {
            int absOffset = Math.abs(offset);
            int z = layout.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = layout.getChildAt(i);
                if (absOffset >= child.getTop() && absOffset <= child.getBottom()) {
                    return child;
                }
            }
            return null;
        }

        private View y(CoordinatorLayout parent) {
            int z = parent.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = parent.getChildAt(i);
                if ((child instanceof NestedScrollingChild) || (child instanceof AbsListView) || (child instanceof ScrollView)) {
                    return child;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int i() {
            return a() + this.f;
        }

        /* renamed from: L */
        public Parcelable onSaveInstanceState(CoordinatorLayout parent, T abl) {
            Parcelable superState = super.onSaveInstanceState(parent, abl);
            e scrollState = P(superState, abl);
            return scrollState == null ? superState : scrollState;
        }

        /* renamed from: K */
        public void onRestoreInstanceState(CoordinatorLayout parent, T appBarLayout, Parcelable state) {
            if (state instanceof e) {
                O((e) state, true);
                super.onRestoreInstanceState(parent, appBarLayout, this.f1423a.getSuperState());
                return;
            }
            super.onRestoreInstanceState(parent, appBarLayout, state);
            this.f1423a = null;
        }

        /* access modifiers changed from: package-private */
        public e P(Parcelable superState, T abl) {
            int offset = a();
            int i = 0;
            int count = abl.getChildCount();
            while (i < count) {
                View child = abl.getChildAt(i);
                int visBottom = child.getBottom() + offset;
                if (child.getTop() + offset > 0 || visBottom < 0) {
                    i++;
                } else {
                    e ss = new e(superState == null ? AbsSavedState.EMPTY_STATE : superState);
                    boolean z = false;
                    boolean z2 = offset == 0;
                    ss.b = z2;
                    ss.f1434a = !z2 && (-offset) >= abl.getTotalScrollRange();
                    ss.f1433a = i;
                    if (visBottom == ViewCompat.getMinimumHeight(child) + abl.getTopInset()) {
                        z = true;
                    }
                    ss.c = z;
                    ss.a = ((float) visBottom) / ((float) child.getHeight());
                    return ss;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void O(e state, boolean force) {
            if (this.f1423a == null || force) {
                this.f1423a = state;
            }
        }

        protected static class e extends AbsSavedState {
            public static final Parcelable.Creator<e> CREATOR = new a();
            float a;

            /* renamed from: a  reason: collision with other field name */
            int f1433a;

            /* renamed from: a  reason: collision with other field name */
            boolean f1434a;
            boolean b;
            boolean c;

            public e(Parcel source, ClassLoader loader) {
                super(source, loader);
                boolean z = true;
                this.f1434a = source.readByte() != 0;
                this.b = source.readByte() != 0;
                this.f1433a = source.readInt();
                this.a = source.readFloat();
                this.c = source.readByte() == 0 ? false : z;
            }

            public e(Parcelable superState) {
                super(superState);
            }

            public void writeToParcel(Parcel dest, int flags) {
                super.writeToParcel(dest, flags);
                dest.writeByte(this.f1434a ? (byte) 1 : 0);
                dest.writeByte(this.b ? (byte) 1 : 0);
                dest.writeInt(this.f1433a);
                dest.writeFloat(this.a);
                dest.writeByte(this.c ? (byte) 1 : 0);
            }

            class a implements Parcelable.ClassLoaderCreator<e> {
                a() {
                }

                /* renamed from: b */
                public e createFromParcel(Parcel source, ClassLoader loader) {
                    return new e(source, loader);
                }

                /* renamed from: a */
                public e createFromParcel(Parcel source) {
                    return new e(source, (ClassLoader) null);
                }

                /* renamed from: c */
                public e[] newArray(int size) {
                    return new e[size];
                }
            }
        }
    }

    public static class ScrollingViewBehavior extends b {
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, xc0.f5683i1);
            k(a.getDimensionPixelSize(xc0.z3, 0));
            a.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
            return dependency instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
            o(child, dependency);
            p(child, dependency);
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout parent, View child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                ViewCompat.removeAccessibilityAction(parent, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(parent, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
                ViewCompat.setAccessibilityDelegate(parent, (AccessibilityDelegateCompat) null);
            }
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout parent, View child, Rect rectangle, boolean immediate) {
            AppBarLayout header = d(parent.getDependencies(child));
            if (header != null) {
                Rect offsetRect = new Rect(rectangle);
                offsetRect.offset(child.getLeft(), child.getTop());
                Rect parentRect = this.a;
                parentRect.set(0, 0, parent.getWidth(), parent.getHeight());
                if (!parentRect.contains(offsetRect)) {
                    header.z(false, !immediate);
                    return true;
                }
            }
            return false;
        }

        private void o(View child, View dependency) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) dependency.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(child, (((dependency.getBottom() - child.getTop()) + ((BaseBehavior) behavior).f) + i()) - e(dependency));
            }
        }

        /* access modifiers changed from: package-private */
        public float f(View header) {
            int availScrollRange;
            if (header instanceof AppBarLayout) {
                AppBarLayout abl = (AppBarLayout) header;
                int totalScrollRange = abl.getTotalScrollRange();
                int preScrollDown = abl.getDownNestedPreScrollRange();
                int offset = n(abl);
                if ((preScrollDown == 0 || totalScrollRange + offset > preScrollDown) && (availScrollRange = totalScrollRange - preScrollDown) != 0) {
                    return (((float) offset) / ((float) availScrollRange)) + 1.0f;
                }
            }
            return 0.0f;
        }

        private static int n(AppBarLayout abl) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) abl.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).i();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public AppBarLayout d(List<View> views) {
            int z = views.size();
            for (int i = 0; i < z; i++) {
                View view = views.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public int h(View v) {
            if (v instanceof AppBarLayout) {
                return ((AppBarLayout) v).getTotalScrollRange();
            }
            return super.h(v);
        }

        private void p(View child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                if (appBarLayout.q()) {
                    appBarLayout.C(appBarLayout.F(child));
                }
            }
        }
    }

    public static class d extends c {
        private final Rect a = new Rect();
        private final Rect b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View child) {
            child.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(child, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void a(AppBarLayout appBarLayout, View child, float offset) {
            b(this.a, appBarLayout, child);
            float distanceFromCeiling = ((float) this.a.top) - Math.abs(offset);
            if (distanceFromCeiling <= 0.0f) {
                float p = MathUtils.clamp(Math.abs(distanceFromCeiling / ((float) this.a.height())), 0.0f, 1.0f);
                float offsetY = (-distanceFromCeiling) - ((((float) this.a.height()) * 0.3f) * (1.0f - ((1.0f - p) * (1.0f - p))));
                child.setTranslationY(offsetY);
                child.getDrawingRect(this.b);
                this.b.offset(0, (int) (-offsetY));
                ViewCompat.setClipBounds(child, this.b);
                return;
            }
            ViewCompat.setClipBounds(child, (Rect) null);
            child.setTranslationY(0.0f);
        }
    }
}
