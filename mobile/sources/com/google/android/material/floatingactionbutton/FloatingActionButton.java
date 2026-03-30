package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.b;
import java.util.List;

public class FloatingActionButton extends mv0 implements TintableBackgroundView, TintableImageSourceView, zj, ll0, CoordinatorLayout.AttachedBehavior {
    private static final int g = uc0.Widget_Design_FloatingActionButton;
    private final ak a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1764a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f1765a;

    /* renamed from: a  reason: collision with other field name */
    final Rect f1766a;

    /* renamed from: a  reason: collision with other field name */
    private final AppCompatImageHelper f1767a;

    /* renamed from: a  reason: collision with other field name */
    private b f1768a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1769a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f1770b;

    /* renamed from: b  reason: collision with other field name */
    private PorterDuff.Mode f1771b;

    /* renamed from: b  reason: collision with other field name */
    private final Rect f1772b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private ColorStateList f1773c;
    private int d;
    /* access modifiers changed from: private */
    public int e;
    private int f;

    public static abstract class b {
        public abstract void a(FloatingActionButton floatingActionButton);

        public abstract void b(FloatingActionButton floatingActionButton);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.floatingActionButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = g
            r1 = r17
            android.content.Context r2 = defpackage.t00.c(r1, r7, r8, r9)
            r0.<init>(r2, r7, r8)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r0.f1766a = r2
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r0.f1772b = r2
            android.content.Context r10 = r16.getContext()
            int[] r3 = defpackage.xc0.f5651X
            r11 = 0
            int[] r6 = new int[r11]
            r1 = r10
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = defpackage.vq0.i(r1, r2, r3, r4, r5, r6)
            int r2 = defpackage.xc0.I1
            android.content.res.ColorStateList r2 = defpackage.o00.a(r10, r1, r2)
            r0.f1764a = r2
            int r2 = defpackage.xc0.J1
            r3 = -1
            int r2 = r1.getInt(r2, r3)
            r4 = 0
            android.graphics.PorterDuff$Mode r2 = defpackage.lv0.i(r2, r4)
            r0.f1765a = r2
            int r2 = defpackage.xc0.T1
            android.content.res.ColorStateList r2 = defpackage.o00.a(r10, r1, r2)
            r0.f1773c = r2
            int r2 = defpackage.xc0.O1
            int r2 = r1.getInt(r2, r3)
            r0.c = r2
            int r2 = defpackage.xc0.N1
            int r2 = r1.getDimensionPixelSize(r2, r11)
            r0.d = r2
            int r2 = defpackage.xc0.K1
            int r2 = r1.getDimensionPixelSize(r2, r11)
            r0.b = r2
            int r2 = defpackage.xc0.L1
            r3 = 0
            float r2 = r1.getDimension(r2, r3)
            int r4 = defpackage.xc0.Q1
            float r4 = r1.getDimension(r4, r3)
            int r5 = defpackage.xc0.S1
            float r3 = r1.getDimension(r5, r3)
            int r5 = defpackage.xc0.V1
            boolean r5 = r1.getBoolean(r5, r11)
            r0.f1769a = r5
            android.content.res.Resources r5 = r16.getResources()
            int r6 = defpackage.cc0.mtrl_fab_min_touch_target
            int r5 = r5.getDimensionPixelSize(r6)
            int r6 = defpackage.xc0.R1
            int r6 = r1.getDimensionPixelSize(r6, r11)
            r0.setMaxImageSize(r6)
            int r6 = defpackage.xc0.U1
            g20 r6 = defpackage.g20.b(r10, r1, r6)
            int r12 = defpackage.xc0.P1
            g20 r12 = defpackage.g20.b(r10, r1, r12)
            wc r13 = defpackage.il0.e
            il0$b r9 = defpackage.il0.g(r10, r7, r8, r9, r13)
            il0 r9 = r9.m()
            int r13 = defpackage.xc0.M1
            boolean r11 = r1.getBoolean(r13, r11)
            int r13 = defpackage.xc0.H1
            r14 = 1
            boolean r13 = r1.getBoolean(r13, r14)
            r0.setEnabled(r13)
            r1.recycle()
            androidx.appcompat.widget.AppCompatImageHelper r13 = new androidx.appcompat.widget.AppCompatImageHelper
            r13.<init>(r0)
            r0.f1767a = r13
            r13.loadFromAttributes(r7, r8)
            ak r13 = new ak
            r13.<init>(r0)
            r0.a = r13
            com.google.android.material.floatingactionbutton.b r13 = r16.getImpl()
            r13.Y(r9)
            com.google.android.material.floatingactionbutton.b r13 = r16.getImpl()
            android.content.res.ColorStateList r14 = r0.f1764a
            android.graphics.PorterDuff$Mode r15 = r0.f1765a
            r17 = r1
            android.content.res.ColorStateList r1 = r0.f1773c
            int r7 = r0.b
            r13.y(r14, r15, r1, r7)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.U(r5)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.O(r2)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.R(r4)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.V(r3)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.Z(r6)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.Q(r12)
            com.google.android.material.floatingactionbutton.b r1 = r16.getImpl()
            r1.P(r11)
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX
            r0.setScaleType(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int preferredSize = getSizeDimension();
        this.e = (preferredSize - this.f) / 2;
        getImpl().g0();
        int d2 = Math.min(View.resolveSize(preferredSize, widthMeasureSpec), View.resolveSize(preferredSize, heightMeasureSpec));
        Rect rect = this.f1766a;
        setMeasuredDimension(rect.left + d2 + rect.right, rect.top + d2 + rect.bottom);
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f1773c;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f1773c;
    }

    public void setRippleColor(@ColorInt int color) {
        setRippleColor(ColorStateList.valueOf(color));
    }

    public void setRippleColor(@Nullable ColorStateList color) {
        if (this.f1773c != color) {
            this.f1773c = color;
            getImpl().W(this.f1773c);
        }
    }

    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f1764a;
    }

    public void setBackgroundTintList(@Nullable ColorStateList tint) {
        if (this.f1764a != tint) {
            this.f1764a = tint;
            getImpl().M(tint);
        }
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f1765a;
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        if (this.f1765a != tintMode) {
            this.f1765a = tintMode;
            getImpl().N(tintMode);
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList tint) {
        setBackgroundTintList(tint);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        setBackgroundTintMode(tintMode);
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public void setSupportImageTintList(@Nullable ColorStateList tint) {
        if (this.f1770b != tint) {
            this.f1770b = tint;
            n();
        }
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f1770b;
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode tintMode) {
        if (this.f1771b != tintMode) {
            this.f1771b = tintMode;
            n();
        }
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f1771b;
    }

    private void n() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f1770b;
            if (colorStateList == null) {
                DrawableCompat.clearColorFilter(drawable);
                return;
            }
            int color = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f1771b;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(color, mode));
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int resid) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundColor(int color) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setImageResource(@DrawableRes int resId) {
        this.f1767a.setImageResource(resId);
        n();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().f0();
            if (this.f1770b != null) {
                n();
            }
        }
    }

    public void setShapeAppearanceModel(@NonNull il0 shapeAppearance) {
        getImpl().Y(shapeAppearance);
    }

    @NonNull
    public il0 getShapeAppearanceModel() {
        return (il0) Preconditions.checkNotNull(getImpl().u());
    }

    public void setEnsureMinTouchTargetSize(boolean flag) {
        if (flag != getImpl().o()) {
            getImpl().P(flag);
            requestLayout();
        }
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    public void setMaxImageSize(int imageSize) {
        this.f = imageSize;
        getImpl().T(imageSize);
    }

    /* access modifiers changed from: package-private */
    public void o(b listener, boolean fromUser) {
        getImpl().d0(p(listener), fromUser);
    }

    public void f(Animator.AnimatorListener listener) {
        getImpl().f(listener);
    }

    /* access modifiers changed from: package-private */
    public void l(b listener, boolean fromUser) {
        getImpl().x(p(listener), fromUser);
    }

    public void e(Animator.AnimatorListener listener) {
        getImpl().e(listener);
    }

    public boolean a() {
        return this.a.c();
    }

    public void setExpandedComponentIdHint(@IdRes int expandedComponentIdHint) {
        this.a.f(expandedComponentIdHint);
    }

    public int getExpandedComponentIdHint() {
        return this.a.b();
    }

    public void setUseCompatPadding(boolean useCompatPadding) {
        if (this.f1769a != useCompatPadding) {
            this.f1769a = useCompatPadding;
            getImpl().D();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f1769a;
    }

    public void setSize(int size) {
        this.d = 0;
        if (size != this.c) {
            this.c = size;
            requestLayout();
        }
    }

    public int getSize() {
        return this.c;
    }

    private b.k p(b listener) {
        if (listener == null) {
            return null;
        }
        return new a(listener);
    }

    class a implements b.k {
        final /* synthetic */ b a;

        a(b bVar) {
        }

        public void a() {
            this.a.b(FloatingActionButton.this);
            throw null;
        }

        public void b() {
            this.a.a(FloatingActionButton.this);
            throw null;
        }
    }

    public void setCustomSize(@Px int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (size != this.d) {
            this.d = size;
            requestLayout();
        }
    }

    @Px
    public int getCustomSize() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return j(this.c);
    }

    private int j(int size) {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        Resources res = getResources();
        switch (size) {
            case -1:
                if (Math.max(res.getConfiguration().screenWidthDp, res.getConfiguration().screenHeightDp) < 470) {
                    return j(1);
                }
                return j(0);
            case 1:
                return res.getDimensionPixelSize(cc0.design_fab_size_mini);
            default:
                return res.getDimensionPixelSize(cc0.design_fab_size_normal);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().C();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().E();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().F(getDrawableState());
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().B();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        if (superState == null) {
            superState = new Bundle();
        }
        ck state = new ck(superState);
        state.a.put("expandableWidgetHelper", this.a.e());
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof ck)) {
            super.onRestoreInstanceState(state);
            return;
        }
        ck ess = (ck) state;
        super.onRestoreInstanceState(ess.getSuperState());
        this.a.d((Bundle) Preconditions.checkNotNull(ess.a.get("expandableWidgetHelper")));
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m(rect);
    }

    private void k(Rect rect) {
        i(rect);
        int touchTargetPadding = this.f1768a.w();
        rect.inset(-touchTargetPadding, -touchTargetPadding);
    }

    private void m(Rect rect) {
        int i = rect.left;
        Rect rect2 = this.f1766a;
        rect.left = i + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().m();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            k(this.f1772b);
            if (!this.f1772b.contains((int) ev.getX(), (int) ev.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(ev);
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean d(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean e(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
        }

        public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            super.onAttachedToLayoutParams(layoutParams);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;

        /* renamed from: a  reason: collision with other field name */
        private b f1774a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1775a;

        public BaseBehavior() {
            this.f1775a = true;
        }

        public BaseBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5653Y);
            this.f1775a = a2.getBoolean(xc0.W1, true);
            a2.recycle();
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams lp) {
            if (lp.dodgeInsetEdges == 0) {
                lp.dodgeInsetEdges = 80;
            }
        }

        /* renamed from: d */
        public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                g(parent, (AppBarLayout) dependency, child);
                return false;
            } else if (!b(dependency)) {
                return false;
            } else {
                h(dependency, child);
                return false;
            }
        }

        private static boolean b(View view) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) lp).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean f(View dependency, FloatingActionButton child) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            if (this.f1775a && lp.getAnchorId() == dependency.getId() && child.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean g(CoordinatorLayout parent, AppBarLayout appBarLayout, FloatingActionButton child) {
            if (!f(appBarLayout, child)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            fg.a(parent, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                child.l(this.f1774a, false);
                return true;
            }
            child.o(this.f1774a, false);
            return true;
        }

        private boolean h(View bottomSheet, FloatingActionButton child) {
            if (!f(bottomSheet, child)) {
                return false;
            }
            if (bottomSheet.getTop() < (child.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin) {
                child.l(this.f1774a, false);
                return true;
            }
            child.o(this.f1774a, false);
            return true;
        }

        /* renamed from: e */
        public boolean onLayoutChild(CoordinatorLayout parent, FloatingActionButton child, int layoutDirection) {
            List<View> dependencies = parent.getDependencies(child);
            int count = dependencies.size();
            for (int i = 0; i < count; i++) {
                View dependency = dependencies.get(i);
                if (!(dependency instanceof AppBarLayout)) {
                    if (b(dependency) && h(dependency, child)) {
                        break;
                    }
                } else if (g(parent, (AppBarLayout) dependency, child)) {
                    break;
                }
            }
            parent.onLayoutChild(child, layoutDirection);
            c(parent, child);
            return true;
        }

        /* renamed from: a */
        public boolean getInsetDodgeRect(CoordinatorLayout parent, FloatingActionButton child, Rect rect) {
            Rect shadowPadding = child.f1766a;
            rect.set(child.getLeft() + shadowPadding.left, child.getTop() + shadowPadding.top, child.getRight() - shadowPadding.right, child.getBottom() - shadowPadding.bottom);
            return true;
        }

        private void c(CoordinatorLayout parent, FloatingActionButton fab) {
            Rect padding = fab.f1766a;
            if (padding != null && padding.centerX() > 0 && padding.centerY() > 0) {
                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                int offsetTB = 0;
                int offsetLR = 0;
                if (fab.getRight() >= parent.getWidth() - lp.rightMargin) {
                    offsetLR = padding.right;
                } else if (fab.getLeft() <= lp.leftMargin) {
                    offsetLR = -padding.left;
                }
                if (fab.getBottom() >= parent.getHeight() - lp.bottomMargin) {
                    offsetTB = padding.bottom;
                } else if (fab.getTop() <= lp.topMargin) {
                    offsetTB = -padding.top;
                }
                if (offsetTB != 0) {
                    ViewCompat.offsetTopAndBottom(fab, offsetTB);
                }
                if (offsetLR != 0) {
                    ViewCompat.offsetLeftAndRight(fab, offsetLR);
                }
            }
        }
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        getImpl().h0(elevation);
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public void setCompatElevation(float elevation) {
        getImpl().O(elevation);
    }

    public void setCompatElevationResource(@DimenRes int id) {
        setCompatElevation(getResources().getDimension(id));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public void setCompatHoveredFocusedTranslationZ(float translationZ) {
        getImpl().R(translationZ);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int id) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(id));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    public void setCompatPressedTranslationZ(float translationZ) {
        getImpl().V(translationZ);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int id) {
        setCompatPressedTranslationZ(getResources().getDimension(id));
    }

    @Nullable
    public g20 getShowMotionSpec() {
        return getImpl().v();
    }

    public void setShowMotionSpec(@Nullable g20 spec) {
        getImpl().Z(spec);
    }

    public void setShowMotionSpecResource(@AnimatorRes int id) {
        setShowMotionSpec(g20.c(getContext(), id));
    }

    @Nullable
    public g20 getHideMotionSpec() {
        return getImpl().p();
    }

    public void setHideMotionSpec(@Nullable g20 spec) {
        getImpl().Q(spec);
    }

    public void setHideMotionSpecResource(@AnimatorRes int id) {
        setHideMotionSpec(g20.c(getContext(), id));
    }

    public void g(zr0<? extends FloatingActionButton> listener) {
        getImpl().g(new d(listener));
    }

    class d<T extends FloatingActionButton> implements b.j {

        /* renamed from: a  reason: collision with other field name */
        private final zr0<T> f1777a;

        d(zr0<T> listener) {
            this.f1777a = listener;
        }

        public void a() {
            this.f1777a.a(FloatingActionButton.this);
        }

        public void b() {
            this.f1777a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f1777a.equals(this.f1777a);
        }

        public int hashCode() {
            return this.f1777a.hashCode();
        }
    }

    public void setTranslationX(float translationX) {
        super.setTranslationX(translationX);
        getImpl().K();
    }

    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        getImpl().K();
    }

    public void setTranslationZ(float translationZ) {
        super.setTranslationZ(translationZ);
        getImpl().K();
    }

    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
        getImpl().J();
    }

    public void setScaleY(float scaleY) {
        super.setScaleY(scaleY);
        getImpl().J();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowPaddingEnabled(boolean shadowPaddingEnabled) {
        getImpl().X(shadowPaddingEnabled);
    }

    private b getImpl() {
        if (this.f1768a == null) {
            this.f1768a = h();
        }
        return this.f1768a;
    }

    private b h() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(this, new c());
        }
        return new b(this, new c());
    }

    private class c implements hl0 {
        c() {
        }

        public void setShadowPadding(int left, int top, int right, int bottom) {
            FloatingActionButton.this.f1766a.set(left, top, right, bottom);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(floatingActionButton.e + left, FloatingActionButton.this.e + top, FloatingActionButton.this.e + right, FloatingActionButton.this.e + bottom);
        }

        public void setBackgroundDrawable(Drawable background) {
            if (background != null) {
                FloatingActionButton.super.setBackgroundDrawable(background);
            }
        }

        public boolean a() {
            return FloatingActionButton.this.f1769a;
        }
    }
}
