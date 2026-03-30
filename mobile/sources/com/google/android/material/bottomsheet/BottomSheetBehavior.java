package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import defpackage.lv0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int w = uc0.Widget_Design_BottomSheet_Modal;
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private int f1492a = 0;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f1493a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1494a;

    /* renamed from: a  reason: collision with other field name */
    final SparseIntArray f1495a = new SparseIntArray();

    /* renamed from: a  reason: collision with other field name */
    private VelocityTracker f1496a;

    /* renamed from: a  reason: collision with other field name */
    private final ViewDragHelper.Callback f1497a = new d();

    /* renamed from: a  reason: collision with other field name */
    ViewDragHelper f1498a;

    /* renamed from: a  reason: collision with other field name */
    private final BottomSheetBehavior<V>.defpackage.h f1499a = new h(this, (a) null);

    /* renamed from: a  reason: collision with other field name */
    g00 f1500a;

    /* renamed from: a  reason: collision with other field name */
    private il0 f1501a;

    /* renamed from: a  reason: collision with other field name */
    WeakReference<V> f1502a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<f> f1503a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private Map<View, Integer> f1504a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public p00 f1505a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f1506a = true;
    float b = 0.5f;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public int f1507b;

    /* renamed from: b  reason: collision with other field name */
    WeakReference<View> f1508b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1509b = false;
    float c = -1.0f;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public int f1510c;

    /* renamed from: c  reason: collision with other field name */
    WeakReference<View> f1511c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1512c;
    private float d = 0.1f;

    /* renamed from: d  reason: collision with other field name */
    private int f1513d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1514d;
    private int e;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with other field name */
    public boolean f1515e;
    private int f = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with other field name */
    public boolean f1516f;
    private int g = -1;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with other field name */
    public boolean f1517g;
    /* access modifiers changed from: private */
    public int h;

    /* renamed from: h  reason: collision with other field name */
    private boolean f1518h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with other field name */
    public boolean f1519i;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with other field name */
    public boolean f1520j;
    int k;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with other field name */
    public boolean f1521k;
    int l;

    /* renamed from: l  reason: collision with other field name */
    private boolean f1522l;
    int m;

    /* renamed from: m  reason: collision with other field name */
    private boolean f1523m;
    int n;

    /* renamed from: n  reason: collision with other field name */
    boolean f1524n;
    int o = 4;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with other field name */
    public boolean f1525o;
    int p = 4;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with other field name */
    public boolean f1526p = true;
    private int q;

    /* renamed from: q  reason: collision with other field name */
    private boolean f1527q;
    private int r;

    /* renamed from: r  reason: collision with other field name */
    private boolean f1528r;
    int s;

    /* renamed from: s  reason: collision with other field name */
    boolean f1529s;
    int t;
    int u;
    private int v = -1;

    public static abstract class f {
        public abstract void b(View view, float f);

        public abstract void c(View view, int i);

        /* access modifiers changed from: package-private */
        public void a(View bottomSheet) {
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        int i2;
        this.e = context.getResources().getDimensionPixelSize(cc0.mtrl_min_touch_target_size);
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5726x);
        int i3 = xc0.Q;
        if (a2.hasValue(i3)) {
            this.f1494a = o00.a(context, a2, i3);
        }
        if (a2.hasValue(xc0.i0)) {
            this.f1501a = il0.e(context, attrs, yb0.bottomSheetStyle, w).m();
        }
        D(context);
        E();
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = a2.getDimension(xc0.P, -1.0f);
        }
        int i4 = xc0.N;
        if (a2.hasValue(i4)) {
            g0(a2.getDimensionPixelSize(i4, -1));
        }
        int i5 = xc0.O;
        if (a2.hasValue(i5)) {
            f0(a2.getDimensionPixelSize(i5, -1));
        }
        int i6 = xc0.W;
        TypedValue value = a2.peekValue(i6);
        if (value == null || (i2 = value.data) != -1) {
            h0(a2.getDimensionPixelSize(i6, -1));
        } else {
            h0(i2);
        }
        e0(a2.getBoolean(xc0.V, false));
        c0(a2.getBoolean(xc0.a0, false));
        b0(a2.getBoolean(xc0.T, true));
        l0(a2.getBoolean(xc0.Z, false));
        Z(a2.getBoolean(xc0.R, true));
        j0(a2.getInt(xc0.X, 0));
        d0(a2.getFloat(xc0.U, 0.5f));
        int i7 = xc0.S;
        TypedValue value2 = a2.peekValue(i7);
        if (value2 == null || value2.type != 16) {
            a0(a2.getDimensionPixelOffset(i7, 0));
        } else {
            a0(value2.data);
        }
        k0(a2.getInt(xc0.Y, HttpStatus.SC_INTERNAL_SERVER_ERROR));
        this.f1515e = a2.getBoolean(xc0.e0, false);
        this.f1516f = a2.getBoolean(xc0.f0, false);
        this.f1517g = a2.getBoolean(xc0.g0, false);
        this.f1518h = a2.getBoolean(xc0.h0, true);
        this.f1519i = a2.getBoolean(xc0.b0, false);
        this.f1520j = a2.getBoolean(xc0.c0, false);
        this.f1521k = a2.getBoolean(xc0.d0, false);
        this.f1522l = a2.getBoolean(xc0.j0, true);
        a2.recycle();
        this.a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        return new g(super.onSaveInstanceState(parent, child), (BottomSheetBehavior<?>) this);
    }

    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        g ss = (g) state;
        super.onRestoreInstanceState(parent, child, ss.getSuperState());
        W(ss);
        int i2 = ss.a;
        if (i2 == 1 || i2 == 2) {
            this.o = 4;
            this.p = 4;
            return;
        }
        this.o = i2;
        this.p = i2;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f1502a = null;
        this.f1498a = null;
        this.f1500a = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f1502a = null;
        this.f1498a = null;
        this.f1500a = null;
    }

    public boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        child.measure(I(parentWidthMeasureSpec, parent.getPaddingLeft() + parent.getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, this.f, lp.width), I(parentHeightMeasureSpec, parent.getPaddingTop() + parent.getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, this.g, lp.height));
        return true;
    }

    private int I(int parentMeasureSpec, int padding, int maxSize, int childDimension) {
        int i2;
        int result = ViewGroup.getChildMeasureSpec(parentMeasureSpec, padding, childDimension);
        if (maxSize == -1) {
            return result;
        }
        int mode = View.MeasureSpec.getMode(result);
        int size = View.MeasureSpec.getSize(result);
        switch (mode) {
            case BasicMeasure.EXACTLY:
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, maxSize), BasicMeasure.EXACTLY);
            default:
                if (size == 0) {
                    i2 = maxSize;
                } else {
                    i2 = Math.min(size, maxSize);
                }
                return View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        }
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        if (ViewCompat.getFitsSystemWindows(parent) && !ViewCompat.getFitsSystemWindows(child)) {
            child.setFitsSystemWindows(true);
        }
        if (this.f1502a == null) {
            this.f1513d = parent.getResources().getDimensionPixelSize(cc0.design_bottom_sheet_peek_height_min);
            o0(child);
            ViewCompat.setWindowInsetsAnimationCallback(child, new a(child));
            this.f1502a = new WeakReference<>(child);
            this.f1500a = new g00(child);
            p00 p00 = this.f1505a;
            if (p00 != null) {
                ViewCompat.setBackground(child, p00);
                p00 p002 = this.f1505a;
                float f2 = this.c;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(child);
                }
                p002.U(f2);
            } else {
                ColorStateList colorStateList = this.f1494a;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(child, colorStateList);
                }
            }
            v0();
            if (ViewCompat.getImportantForAccessibility(child) == 0) {
                ViewCompat.setImportantForAccessibility(child, 1);
            }
        }
        if (this.f1498a == null) {
            this.f1498a = ViewDragHelper.create(parent, this.f1497a);
        }
        int savedTop = child.getTop();
        parent.onLayoutChild(child, layoutDirection);
        this.s = parent.getWidth();
        this.t = parent.getHeight();
        int height = child.getHeight();
        this.r = height;
        int i2 = this.t;
        int i3 = i2 - height;
        int i4 = this.j;
        if (i3 < i4) {
            if (this.f1518h) {
                int i5 = this.g;
                if (i5 != -1) {
                    i2 = Math.min(i2, i5);
                }
                this.r = i2;
            } else {
                int insetHeight = i2 - i4;
                int i6 = this.g;
                this.r = i6 == -1 ? insetHeight : Math.min(insetHeight, i6);
            }
        }
        this.l = Math.max(0, this.t - this.r);
        w();
        u();
        int i7 = this.o;
        if (i7 == 3) {
            ViewCompat.offsetTopAndBottom(child, J());
        } else if (i7 == 6) {
            ViewCompat.offsetTopAndBottom(child, this.m);
        } else if (this.f1524n && i7 == 5) {
            ViewCompat.offsetTopAndBottom(child, this.t);
        } else if (i7 == 4) {
            ViewCompat.offsetTopAndBottom(child, this.n);
        } else if (i7 == 1 || i7 == 2) {
            ViewCompat.offsetTopAndBottom(child, savedTop - child.getTop());
        }
        x0(this.o, false);
        this.f1511c = new WeakReference<>(G(child));
        for (int i8 = 0; i8 < this.f1503a.size(); i8++) {
            this.f1503a.get(i8).a(child);
        }
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        int i2;
        ViewDragHelper viewDragHelper;
        if (!child.isShown() || !this.f1526p) {
            this.f1527q = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            V();
        }
        if (this.f1496a == null) {
            this.f1496a = VelocityTracker.obtain();
        }
        this.f1496a.addMovement(event);
        View scroll = null;
        switch (action) {
            case 0:
                int initialX = (int) event.getX();
                this.v = (int) event.getY();
                if (this.o != 2) {
                    WeakReference<View> weakReference = this.f1511c;
                    View scroll2 = weakReference != null ? (View) weakReference.get() : null;
                    if (scroll2 != null && parent.isPointInChildBounds(scroll2, initialX, this.v)) {
                        this.u = event.getPointerId(event.getActionIndex());
                        this.f1529s = true;
                    }
                }
                this.f1527q = this.u == -1 && !parent.isPointInChildBounds(child, initialX, this.v);
                break;
            case 1:
            case 3:
                this.f1529s = false;
                this.u = -1;
                if (this.f1527q) {
                    this.f1527q = false;
                    return false;
                }
                break;
        }
        if (this.f1527q == 0 && (viewDragHelper = this.f1498a) != null && viewDragHelper.shouldInterceptTouchEvent(event)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f1511c;
        if (weakReference2 != null) {
            scroll = (View) weakReference2.get();
        }
        if (action != 2 || scroll == null || this.f1527q || this.o == 1 || parent.isPointInChildBounds(scroll, (int) event.getX(), (int) event.getY()) || this.f1498a == null || (i2 = this.v) == -1 || Math.abs(((float) i2) - event.getY()) <= ((float) this.f1498a.getTouchSlop())) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.o == 1 && action == 0) {
            return true;
        }
        if (q0()) {
            this.f1498a.processTouchEvent(event);
        }
        if (action == 0) {
            V();
        }
        if (this.f1496a == null) {
            this.f1496a = VelocityTracker.obtain();
        }
        this.f1496a.addMovement(event);
        if (q0() && action == 2 && !this.f1527q && Math.abs(((float) this.v) - event.getY()) > ((float) this.f1498a.getTouchSlop())) {
            this.f1498a.captureChildView(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.f1527q;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View directTargetChild, View target, int axes, int type) {
        this.q = 0;
        this.f1528r = false;
        if ((axes & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
        if (type != 1) {
            WeakReference<View> weakReference = this.f1511c;
            View scrollingChild = weakReference != null ? (View) weakReference.get() : null;
            if (!T() || target == scrollingChild) {
                int currentTop = child.getTop();
                int newTop = currentTop - dy;
                if (dy > 0) {
                    if (newTop < J()) {
                        consumed[1] = currentTop - J();
                        ViewCompat.offsetTopAndBottom(child, -consumed[1]);
                        n0(3);
                    } else if (this.f1526p) {
                        consumed[1] = dy;
                        ViewCompat.offsetTopAndBottom(child, -dy);
                        n0(1);
                    } else {
                        return;
                    }
                } else if (dy < 0 && !target.canScrollVertically(-1)) {
                    if (newTop > this.n && !A()) {
                        consumed[1] = currentTop - this.n;
                        ViewCompat.offsetTopAndBottom(child, -consumed[1]);
                        n0(4);
                    } else if (this.f1526p) {
                        consumed[1] = dy;
                        ViewCompat.offsetTopAndBottom(child, -dy);
                        n0(1);
                    } else {
                        return;
                    }
                }
                F(child.getTop());
                this.q = dy;
                this.f1528r = true;
            }
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
        int currentTop;
        WeakReference<View> weakReference;
        if (child.getTop() == J()) {
            n0(3);
        } else if (!T() || ((weakReference = this.f1511c) != null && target == weakReference.get() && this.f1528r)) {
            if (this.q > 0) {
                if (this.f1506a) {
                    currentTop = 3;
                } else if (child.getTop() > this.m) {
                    currentTop = 6;
                } else {
                    currentTop = 3;
                }
            } else if (this.f1524n != 0 && r0(child, M())) {
                currentTop = 5;
            } else if (this.q == 0) {
                int currentTop2 = child.getTop();
                if (!this.f1506a) {
                    int targetState = this.m;
                    if (currentTop2 < targetState) {
                        if (currentTop2 < Math.abs(currentTop2 - this.n)) {
                            currentTop = 3;
                        } else if (s0() != 0) {
                            currentTop = 4;
                        } else {
                            currentTop = 6;
                        }
                    } else if (Math.abs(currentTop2 - targetState) < Math.abs(currentTop2 - this.n)) {
                        currentTop = 6;
                    } else {
                        currentTop = 4;
                    }
                } else if (Math.abs(currentTop2 - this.l) < Math.abs(currentTop2 - this.n)) {
                    currentTop = 3;
                } else {
                    currentTop = 4;
                }
            } else if (this.f1506a != 0) {
                currentTop = 4;
            } else {
                int targetState2 = child.getTop();
                if (Math.abs(targetState2 - this.m) < Math.abs(targetState2 - this.n)) {
                    currentTop = 6;
                } else {
                    currentTop = 4;
                }
            }
            u0(child, currentTop, false);
            this.f1528r = false;
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v2, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        WeakReference<View> weakReference;
        if (!T() || (weakReference = this.f1511c) == null || target != weakReference.get()) {
            return false;
        }
        if (this.o != 3 || super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)) {
            return true;
        }
        return false;
    }

    public void b0(boolean fitToContents) {
        if (this.f1506a != fitToContents) {
            this.f1506a = fitToContents;
            if (this.f1502a != null) {
                u();
            }
            n0((!this.f1506a || this.o != 6) ? this.o : 3);
            x0(this.o, true);
            v0();
        }
    }

    public void g0(int maxWidth) {
        this.f = maxWidth;
    }

    public void f0(int maxHeight) {
        this.g = maxHeight;
    }

    public void h0(int peekHeight) {
        i0(peekHeight, false);
    }

    public final void i0(int peekHeight, boolean animate) {
        boolean layout = false;
        if (peekHeight == -1) {
            if (!this.f1512c) {
                this.f1512c = true;
                layout = true;
            }
        } else if (this.f1512c || this.f1510c != peekHeight) {
            this.f1512c = false;
            this.f1510c = Math.max(0, peekHeight);
            layout = true;
        }
        if (layout) {
            z0(animate);
        }
    }

    /* access modifiers changed from: private */
    public void z0(boolean animate) {
        V view;
        if (this.f1502a != null) {
            u();
            if (this.o == 4 && (view = (View) this.f1502a.get()) != null) {
                if (animate) {
                    m0(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void d0(float ratio) {
        if (ratio <= 0.0f || ratio >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.b = ratio;
        if (this.f1502a != null) {
            w();
        }
    }

    public void a0(int offset) {
        if (offset >= 0) {
            this.k = offset;
            x0(this.o, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public int J() {
        if (this.f1506a) {
            return this.l;
        }
        return Math.max(this.k, this.f1518h ? 0 : this.j);
    }

    public void e0(boolean hideable) {
        if (this.f1524n != hideable) {
            this.f1524n = hideable;
            if (!hideable && this.o == 5) {
                m0(4);
            }
            v0();
        }
    }

    public boolean Q() {
        return this.f1524n;
    }

    public void l0(boolean skipCollapsed) {
        this.f1525o = skipCollapsed;
    }

    public void Z(boolean draggable) {
        this.f1526p = draggable;
    }

    public void k0(int significantVelocityThreshold) {
        this.f1507b = significantVelocityThreshold;
    }

    public void j0(int flags) {
        this.f1492a = flags;
    }

    public void Y(f callback) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.f1503a.clear();
        if (callback != null) {
            this.f1503a.add(callback);
        }
    }

    public void m0(int state) {
        int finalState;
        if (state == 1 || state == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(state == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        } else if (this.f1524n || state != 5) {
            if (state != 6 || !this.f1506a || L(state) > this.l) {
                finalState = state;
            } else {
                finalState = 3;
            }
            WeakReference<V> weakReference = this.f1502a;
            if (weakReference == null || weakReference.get() == null) {
                n0(state);
                return;
            }
            V child = (View) this.f1502a.get();
            X(child, new a(child, finalState));
        } else {
            Log.w("BottomSheetBehavior", "Cannot set state: " + state);
        }
    }

    class a implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ View f1530a;

        a(View view, int i) {
            this.f1530a = view;
            this.a = i;
        }

        public void run() {
            BottomSheetBehavior.this.u0(this.f1530a, this.a, false);
        }
    }

    private void X(V child, Runnable runnable) {
        if (S(child)) {
            child.post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean S(V child) {
        ViewParent parent = child.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(child);
    }

    public void c0(boolean gestureInsetBottomIgnored) {
        this.f1514d = gestureInsetBottomIgnored;
    }

    public boolean P() {
        return this.f1514d;
    }

    public int K() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void n0(int state) {
        View bottomSheet;
        if (this.o != state) {
            this.o = state;
            if (state == 4 || state == 3 || state == 6 || (this.f1524n && state == 5)) {
                this.p = state;
            }
            WeakReference<V> weakReference = this.f1502a;
            if (weakReference != null && (bottomSheet = (View) weakReference.get()) != null) {
                if (state == 3) {
                    y0(true);
                } else if (state == 6 || state == 5 || state == 4) {
                    y0(false);
                }
                x0(state, true);
                for (int i2 = 0; i2 < this.f1503a.size(); i2++) {
                    this.f1503a.get(i2).c(bottomSheet, state);
                }
                v0();
            }
        }
    }

    private void x0(int state, boolean animate) {
        boolean removeCorners;
        ValueAnimator valueAnimator;
        if (state != 2 && this.f1523m != (removeCorners = O()) && this.f1505a != null) {
            this.f1523m = removeCorners;
            float to = 1.0f;
            if (!animate || (valueAnimator = this.f1493a) == null) {
                ValueAnimator valueAnimator2 = this.f1493a;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.f1493a.cancel();
                }
                p00 p00 = this.f1505a;
                if (this.f1523m) {
                    to = x();
                }
                p00.W(to);
            } else if (valueAnimator.isRunning()) {
                this.f1493a.reverse();
            } else {
                float from = this.f1505a.w();
                if (removeCorners) {
                    to = x();
                }
                this.f1493a.setFloatValues(new float[]{from, to});
                this.f1493a.start();
            }
        }
    }

    private float x() {
        WeakReference<V> weakReference;
        WindowInsets insets;
        if (this.f1505a == null || (weakReference = this.f1502a) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        V view = (View) this.f1502a.get();
        if (!N() || (insets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(v(this.f1505a.D(), insets.getRoundedCorner(0)), v(this.f1505a.E(), insets.getRoundedCorner(1)));
    }

    private float v(float materialShapeDrawableCornerSize, RoundedCorner deviceRoundedCorner) {
        if (deviceRoundedCorner != null) {
            float deviceCornerRadius = (float) deviceRoundedCorner.getRadius();
            if (deviceCornerRadius > 0.0f && materialShapeDrawableCornerSize > 0.0f) {
                return deviceCornerRadius / materialShapeDrawableCornerSize;
            }
        }
        return 0.0f;
    }

    private boolean N() {
        WeakReference<V> weakReference = this.f1502a;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] location = new int[2];
        ((View) this.f1502a.get()).getLocationOnScreen(location);
        if (location[1] == 0) {
            return true;
        }
        return false;
    }

    private boolean O() {
        return this.o == 3 && (this.f1522l || N());
    }

    private int y() {
        int i2;
        if (this.f1512c) {
            return Math.min(Math.max(this.f1513d, this.t - ((this.s * 9) / 16)), this.r) + this.i;
        }
        if (this.f1514d != 0 || this.f1515e || (i2 = this.h) <= 0) {
            return this.f1510c + this.i;
        }
        return Math.max(this.f1510c, i2 + this.e);
    }

    private void u() {
        int peek = y();
        if (this.f1506a) {
            this.n = Math.max(this.t - peek, this.l);
        } else {
            this.n = this.t - peek;
        }
    }

    private void w() {
        this.m = (int) (((float) this.t) * (1.0f - this.b));
    }

    private float z(int top) {
        int i2 = this.n;
        if (top > i2 || i2 == J()) {
            int i3 = this.n;
            return ((float) (i3 - top)) / ((float) (this.t - i3));
        }
        int i4 = this.n;
        return ((float) (i4 - top)) / ((float) (i4 - J()));
    }

    private void V() {
        this.u = -1;
        this.v = -1;
        VelocityTracker velocityTracker = this.f1496a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1496a = null;
        }
    }

    private void W(g ss) {
        int i2 = this.f1492a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f1510c = ss.b;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f1506a = ss.f1535a;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.f1524n = ss.f1536b;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.f1525o = ss.c;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r0(View child, float yvel) {
        if (this.f1525o) {
            return true;
        }
        if (!R() || child.getTop() < this.n) {
            return false;
        }
        if (Math.abs((((float) child.getTop()) + (this.d * yvel)) - ((float) this.n)) / ((float) y()) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View G(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i2 = 0; i2 < count; i2++) {
                View scrollingChild = G(group.getChildAt(i2));
                if (scrollingChild != null) {
                    return scrollingChild;
                }
            }
        }
        return null;
    }

    private boolean q0() {
        return this.f1498a != null && (this.f1526p || this.o == 1);
    }

    private void D(Context context) {
        if (this.f1501a != null) {
            p00 p00 = new p00(this.f1501a);
            this.f1505a = p00;
            p00.K(context);
            ColorStateList colorStateList = this.f1494a;
            if (colorStateList != null) {
                this.f1505a.V(colorStateList);
                return;
            }
            TypedValue defaultColor = new TypedValue();
            context.getTheme().resolveAttribute(16842801, defaultColor, true);
            this.f1505a.setTint(defaultColor.data);
        }
    }

    private void E() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{x(), 1.0f});
        this.f1493a = ofFloat;
        ofFloat.setDuration(500);
        this.f1493a.addUpdateListener(new b());
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            float value = ((Float) animation.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f1505a != null) {
                BottomSheetBehavior.this.f1505a.W(value);
            }
        }
    }

    private void o0(View child) {
        boolean shouldHandleGestureInsets = Build.VERSION.SDK_INT >= 29 && !P() && !this.f1512c;
        if (this.f1515e || this.f1516f || this.f1517g || this.f1519i || this.f1520j || this.f1521k || shouldHandleGestureInsets) {
            lv0.b(child, new c(shouldHandleGestureInsets));
        }
    }

    class c implements lv0.c {

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f1532a;

        c(boolean z) {
            this.f1532a = z;
        }

        public WindowInsetsCompat a(View view, WindowInsetsCompat insets, lv0.d initialPadding) {
            int i;
            int i2;
            int i3;
            Insets systemBarInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets mandatoryGestureInsets = insets.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            int unused = BottomSheetBehavior.this.j = systemBarInsets.top;
            boolean isRtl = lv0.g(view);
            int bottomPadding = view.getPaddingBottom();
            int leftPadding = view.getPaddingLeft();
            int rightPadding = view.getPaddingRight();
            if (BottomSheetBehavior.this.f1515e) {
                int unused2 = BottomSheetBehavior.this.i = insets.getSystemWindowInsetBottom();
                bottomPadding = initialPadding.d + BottomSheetBehavior.this.i;
            }
            if (BottomSheetBehavior.this.f1516f) {
                leftPadding = (isRtl ? initialPadding.c : initialPadding.a) + systemBarInsets.left;
            }
            if (BottomSheetBehavior.this.f1517g) {
                rightPadding = (isRtl ? initialPadding.a : initialPadding.c) + systemBarInsets.right;
            }
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean marginUpdated = false;
            if (BottomSheetBehavior.this.f1519i && mlp.leftMargin != (i3 = systemBarInsets.left)) {
                mlp.leftMargin = i3;
                marginUpdated = true;
            }
            if (BottomSheetBehavior.this.f1520j && mlp.rightMargin != (i2 = systemBarInsets.right)) {
                mlp.rightMargin = i2;
                marginUpdated = true;
            }
            if (BottomSheetBehavior.this.f1521k && mlp.topMargin != (i = systemBarInsets.top)) {
                mlp.topMargin = i;
                marginUpdated = true;
            }
            if (marginUpdated) {
                view.setLayoutParams(mlp);
            }
            view.setPadding(leftPadding, view.getPaddingTop(), rightPadding, bottomPadding);
            if (this.f1532a) {
                int unused3 = BottomSheetBehavior.this.h = mandatoryGestureInsets.bottom;
            }
            if (BottomSheetBehavior.this.f1515e || this.f1532a) {
                BottomSheetBehavior.this.z0(false);
            }
            return insets;
        }
    }

    private float M() {
        VelocityTracker velocityTracker = this.f1496a;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.a);
        return this.f1496a.getYVelocity(this.u);
    }

    /* access modifiers changed from: private */
    public void u0(View child, int state, boolean isReleasingView) {
        int top = L(state);
        ViewDragHelper viewDragHelper = this.f1498a;
        if (viewDragHelper != null && (!isReleasingView ? viewDragHelper.smoothSlideViewTo(child, child.getLeft(), top) : viewDragHelper.settleCapturedViewAt(child.getLeft(), top))) {
            n0(2);
            x0(state, true);
            this.f1499a.c(state);
            return;
        }
        n0(state);
    }

    private int L(int state) {
        switch (state) {
            case 3:
                return J();
            case 4:
                return this.n;
            case 5:
                return this.t;
            case 6:
                return this.m;
            default:
                throw new IllegalArgumentException("Invalid state to get top offset: " + state);
        }
    }

    class d extends ViewDragHelper.Callback {
        private long a;

        d() {
        }

        public boolean tryCaptureView(View child, int pointerId) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i = bottomSheetBehavior.o;
            if (i == 1 || bottomSheetBehavior.f1529s) {
                return false;
            }
            if (i == 3 && bottomSheetBehavior.u == pointerId) {
                WeakReference<View> weakReference = bottomSheetBehavior.f1511c;
                View scroll = weakReference != null ? (View) weakReference.get() : null;
                if (scroll != null && scroll.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.f1502a;
            if (weakReference2 == null || weakReference2.get() != child) {
                return false;
            }
            return true;
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            BottomSheetBehavior.this.F(top);
        }

        public void onViewDragStateChanged(int state) {
            if (state == 1 && BottomSheetBehavior.this.f1526p) {
                BottomSheetBehavior.this.n0(1);
            }
        }

        private boolean a(View child) {
            int top = child.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.t + bottomSheetBehavior.J()) / 2;
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            int targetState;
            int targetState2;
            if (yvel >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.f1524n || !bottomSheetBehavior.r0(releasedChild, yvel)) {
                    if (yvel == 0.0f || Math.abs(xvel) > Math.abs(yvel)) {
                        int currentTop = releasedChild.getTop();
                        if (!BottomSheetBehavior.this.f1506a) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i = bottomSheetBehavior2.m;
                            if (currentTop < i) {
                                if (currentTop < Math.abs(currentTop - bottomSheetBehavior2.n)) {
                                    targetState = 3;
                                } else if (BottomSheetBehavior.this.s0()) {
                                    targetState = 4;
                                } else {
                                    targetState = 6;
                                }
                            } else if (Math.abs(currentTop - i) >= Math.abs(currentTop - BottomSheetBehavior.this.n)) {
                                targetState = 4;
                            } else if (BottomSheetBehavior.this.s0()) {
                                targetState = 4;
                            } else {
                                targetState = 6;
                            }
                        } else if (Math.abs(currentTop - BottomSheetBehavior.this.l) < Math.abs(currentTop - BottomSheetBehavior.this.n)) {
                            targetState = 3;
                        } else {
                            targetState = 4;
                        }
                    } else if (BottomSheetBehavior.this.f1506a) {
                        targetState = 4;
                    } else {
                        int targetState3 = releasedChild.getTop();
                        if (Math.abs(targetState3 - BottomSheetBehavior.this.m) >= Math.abs(targetState3 - BottomSheetBehavior.this.n)) {
                            targetState = 4;
                        } else if (BottomSheetBehavior.this.s0()) {
                            targetState = 4;
                        } else {
                            targetState = 6;
                        }
                    }
                } else if ((Math.abs(xvel) < Math.abs(yvel) && yvel > ((float) BottomSheetBehavior.this.f1507b)) || a(releasedChild)) {
                    targetState = 5;
                } else if (BottomSheetBehavior.this.f1506a) {
                    targetState = 3;
                } else if (Math.abs(releasedChild.getTop() - BottomSheetBehavior.this.J()) < Math.abs(releasedChild.getTop() - BottomSheetBehavior.this.m)) {
                    targetState = 3;
                } else {
                    targetState = 6;
                }
            } else if (BottomSheetBehavior.this.f1506a) {
                targetState = 3;
            } else {
                int targetState4 = releasedChild.getTop();
                long dragDurationMillis = System.currentTimeMillis() - this.a;
                if (BottomSheetBehavior.this.s0()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior3.p0(dragDurationMillis, (((float) targetState4) * 100.0f) / ((float) bottomSheetBehavior3.t))) {
                        targetState2 = 3;
                    } else {
                        targetState2 = 4;
                    }
                    targetState = targetState2;
                } else if (targetState4 > BottomSheetBehavior.this.m) {
                    targetState = 6;
                } else {
                    targetState = 3;
                }
            }
            BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
            bottomSheetBehavior4.u0(releasedChild, targetState, bottomSheetBehavior4.t0());
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return MathUtils.clamp(top, BottomSheetBehavior.this.J(), getViewVerticalDragRange(child));
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return child.getLeft();
        }

        public int getViewVerticalDragRange(View child) {
            if (BottomSheetBehavior.this.A()) {
                return BottomSheetBehavior.this.t;
            }
            return BottomSheetBehavior.this.n;
        }
    }

    /* access modifiers changed from: package-private */
    public void F(int top) {
        View bottomSheet = (View) this.f1502a.get();
        if (bottomSheet != null && !this.f1503a.isEmpty()) {
            float slideOffset = z(top);
            for (int i2 = 0; i2 < this.f1503a.size(); i2++) {
                this.f1503a.get(i2).b(bottomSheet, slideOffset);
            }
        }
    }

    public boolean T() {
        return true;
    }

    public boolean s0() {
        return false;
    }

    public boolean t0() {
        return true;
    }

    public boolean R() {
        return true;
    }

    /* access modifiers changed from: private */
    public boolean A() {
        return Q() && R();
    }

    public boolean p0(long dragDurationMillis, float yPositionPercentage) {
        return false;
    }

    private class h {
        /* access modifiers changed from: private */
        public int a;

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f1538a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public boolean f1539a;

        private h() {
            this.f1538a = new a();
        }

        /* synthetic */ h(BottomSheetBehavior x0, a x1) {
            this();
        }

        class a implements Runnable {
            a() {
            }

            public void run() {
                boolean unused = h.this.f1539a = false;
                ViewDragHelper viewDragHelper = BottomSheetBehavior.this.f1498a;
                if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                    h hVar = h.this;
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.o == 2) {
                        bottomSheetBehavior.n0(hVar.a);
                        return;
                    }
                    return;
                }
                h hVar2 = h.this;
                hVar2.c(hVar2.a);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int targetState) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.f1502a;
            if (weakReference != null && weakReference.get() != null) {
                this.a = targetState;
                if (!this.f1539a) {
                    ViewCompat.postOnAnimation((View) BottomSheetBehavior.this.f1502a.get(), this.f1538a);
                    this.f1539a = true;
                }
            }
        }
    }

    protected static class g extends AbsSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();
        final int a;

        /* renamed from: a  reason: collision with other field name */
        boolean f1535a;
        int b;

        /* renamed from: b  reason: collision with other field name */
        boolean f1536b;
        boolean c;

        public g(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.a = source.readInt();
            this.b = source.readInt();
            boolean z = false;
            this.f1535a = source.readInt() == 1;
            this.f1536b = source.readInt() == 1;
            this.c = source.readInt() == 1 ? true : z;
        }

        public g(Parcelable superState, BottomSheetBehavior<?> behavior) {
            super(superState);
            this.a = behavior.o;
            this.b = behavior.f1510c;
            this.f1535a = behavior.f1506a;
            this.f1536b = behavior.f1524n;
            this.c = behavior.f1525o;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.a);
            out.writeInt(this.b);
            out.writeInt(this.f1535a ? 1 : 0);
            out.writeInt(this.f1536b ? 1 : 0);
            out.writeInt(this.c ? 1 : 0);
        }

        class a implements Parcelable.ClassLoaderCreator<g> {
            a() {
            }

            /* renamed from: b */
            public g createFromParcel(Parcel in, ClassLoader loader) {
                return new g(in, loader);
            }

            /* renamed from: a */
            public g createFromParcel(Parcel in) {
                return new g(in, (ClassLoader) null);
            }

            /* renamed from: c */
            public g[] newArray(int size) {
                return new g[size];
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> H(V view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (params instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior<?> behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void y0(boolean expanded) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f1502a;
        if (weakReference != null) {
            ViewParent viewParent = ((View) weakReference.get()).getParent();
            if (viewParent instanceof CoordinatorLayout) {
                CoordinatorLayout parent = (CoordinatorLayout) viewParent;
                int childCount = parent.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && expanded) {
                    if (this.f1504a == null) {
                        this.f1504a = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View child = parent.getChildAt(i2);
                    if (child != this.f1502a.get()) {
                        if (expanded) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.f1504a.put(child, Integer.valueOf(child.getImportantForAccessibility()));
                            }
                            if (this.f1509b) {
                                ViewCompat.setImportantForAccessibility(child, 4);
                            }
                        } else if (this.f1509b && (map = this.f1504a) != null && map.containsKey(child)) {
                            ViewCompat.setImportantForAccessibility(child, this.f1504a.get(child).intValue());
                        }
                    }
                }
                if (!expanded) {
                    this.f1504a = null;
                } else if (this.f1509b) {
                    ((View) this.f1502a.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    private void v0() {
        WeakReference<V> weakReference = this.f1502a;
        if (weakReference != null) {
            w0((View) weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.f1508b;
        if (weakReference2 != null) {
            w0((View) weakReference2.get(), 1);
        }
    }

    private void w0(View view, int viewIndex) {
        if (view != null) {
            B(view, viewIndex);
            int nextState = 6;
            if (!this.f1506a && this.o != 6) {
                this.f1495a.put(viewIndex, t(view, sc0.bottomsheet_action_expand_halfway, 6));
            }
            if (this.f1524n && R() && this.o != 5) {
                U(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            switch (this.o) {
                case 3:
                    if (this.f1506a != 0) {
                        nextState = 4;
                    }
                    U(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, nextState);
                    return;
                case 4:
                    if (this.f1506a) {
                        nextState = 3;
                    }
                    U(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, nextState);
                    return;
                case 6:
                    U(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                    U(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
                    return;
                default:
                    return;
            }
        }
    }

    private void B(View view, int viewIndex) {
        if (view != null) {
            ViewCompat.removeAccessibilityAction(view, 524288);
            ViewCompat.removeAccessibilityAction(view, 262144);
            ViewCompat.removeAccessibilityAction(view, 1048576);
            int expandHalfwayActionId = this.f1495a.get(viewIndex, -1);
            if (expandHalfwayActionId != -1) {
                ViewCompat.removeAccessibilityAction(view, expandHalfwayActionId);
                this.f1495a.delete(viewIndex);
            }
        }
    }

    private void U(View child, AccessibilityNodeInfoCompat.AccessibilityActionCompat action, int state) {
        ViewCompat.replaceAccessibilityAction(child, action, (CharSequence) null, C(state));
    }

    private int t(View child, int stringResId, int state) {
        return ViewCompat.addAccessibilityAction(child, child.getResources().getString(stringResId), C(state));
    }

    class e implements AccessibilityViewCommand {
        final /* synthetic */ int a;

        e(int i) {
            this.a = i;
        }

        public boolean perform(View view, AccessibilityViewCommand.CommandArguments arguments) {
            BottomSheetBehavior.this.m0(this.a);
            return true;
        }
    }

    private AccessibilityViewCommand C(int state) {
        return new e(state);
    }
}
