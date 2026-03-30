package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import defpackage.il0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.http.HttpStatus;

public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int i = sc0.side_sheet_accessibility_pane_title;
    private static final int j = uc0.Widget_Material3_SideSheet;
    private float a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public int f1839a = 5;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1840a;

    /* renamed from: a  reason: collision with other field name */
    private VelocityTracker f1841a;

    /* renamed from: a  reason: collision with other field name */
    private final ViewDragHelper.Callback f1842a = new a();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ViewDragHelper f1843a;

    /* renamed from: a  reason: collision with other field name */
    private final SideSheetBehavior<V>.defpackage.c f1844a = new c();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public d f1845a;

    /* renamed from: a  reason: collision with other field name */
    private il0 f1846a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<V> f1847a;

    /* renamed from: a  reason: collision with other field name */
    private final Set<Object> f1848a = new LinkedHashSet();

    /* renamed from: a  reason: collision with other field name */
    private p00 f1849a;

    /* renamed from: a  reason: collision with other field name */
    private r00 f1850a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public boolean f1851a = true;
    private float b;

    /* renamed from: b  reason: collision with other field name */
    private int f1852b = 5;

    /* renamed from: b  reason: collision with other field name */
    private WeakReference<View> f1853b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1854b;
    private float c = 0.1f;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public int f1855c;
    private int d;
    private int e;
    private int f;
    private int g = -1;
    private int h;

    public SideSheetBehavior() {
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5698n1);
        int i2 = xc0.L3;
        if (a2.hasValue(i2)) {
            this.f1840a = o00.a(context, a2, i2);
        }
        if (a2.hasValue(xc0.O3)) {
            this.f1846a = il0.e(context, attrs, 0, j).m();
        }
        int i3 = xc0.N3;
        if (a2.hasValue(i3)) {
            S(a2.getResourceId(i3, -1));
        }
        q(context);
        this.b = a2.getDimension(xc0.K3, -1.0f);
        T(a2.getBoolean(xc0.M3, true));
        a2.recycle();
        this.a = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void V(V view, int layoutDirection) {
        U(GravityCompat.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity, layoutDirection) == 3 ? 1 : 0);
    }

    private void U(int sheetEdge) {
        d dVar = this.f1845a;
        if (dVar != null && dVar.i() == sheetEdge) {
            return;
        }
        if (sheetEdge == 0) {
            this.f1845a = new b(this);
            if (this.f1846a != null && !H()) {
                il0.b builder = this.f1846a.v();
                builder.E(0.0f).w(0.0f);
                e0(builder.m());
            }
        } else if (sheetEdge == 1) {
            this.f1845a = new a(this);
            if (this.f1846a != null && !G()) {
                il0.b builder2 = this.f1846a.v();
                builder2.A(0.0f).s(0.0f);
                e0(builder2.m());
            }
        } else {
            throw new IllegalArgumentException("Invalid sheet edge position value: " + sheetEdge + ". Must be " + 0 + " or " + 1 + ".");
        }
    }

    private boolean H() {
        CoordinatorLayout.LayoutParams layoutParams = F();
        return layoutParams != null && layoutParams.rightMargin > 0;
    }

    private boolean G() {
        CoordinatorLayout.LayoutParams layoutParams = F();
        return layoutParams != null && layoutParams.leftMargin > 0;
    }

    private CoordinatorLayout.LayoutParams F() {
        View view;
        WeakReference<V> weakReference = this.f1847a;
        if (weakReference == null || (view = (View) weakReference.get()) == null || !(view.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) view.getLayoutParams();
    }

    private void e0(il0 shapeAppearanceModel) {
        p00 p00 = this.f1849a;
        if (p00 != null) {
            p00.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        return new b(super.onSaveInstanceState(parent, child), (SideSheetBehavior<?>) this);
    }

    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        b ss = (b) state;
        if (ss.getSuperState() != null) {
            super.onRestoreInstanceState(parent, child, ss.getSuperState());
        }
        int i2 = ss.a;
        if (i2 == 1 || i2 == 2) {
            i2 = 5;
        }
        this.f1839a = i2;
        this.f1852b = i2;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.f1847a = null;
        this.f1843a = null;
        this.f1850a = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f1847a = null;
        this.f1843a = null;
        this.f1850a = null;
    }

    public boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        child.measure(t(parentWidthMeasureSpec, parent.getPaddingLeft() + parent.getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, -1, lp.width), t(parentHeightMeasureSpec, parent.getPaddingTop() + parent.getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, -1, lp.height));
        return true;
    }

    private int t(int parentMeasureSpec, int padding, int maxSize, int childDimension) {
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
        if (this.f1847a == null) {
            this.f1847a = new WeakReference<>(child);
            this.f1850a = new r00(child);
            p00 p00 = this.f1849a;
            if (p00 != null) {
                ViewCompat.setBackground(child, p00);
                p00 p002 = this.f1849a;
                float f2 = this.b;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(child);
                }
                p002.U(f2);
            } else {
                ColorStateList colorStateList = this.f1840a;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(child, colorStateList);
                }
            }
            f0(child);
            d0();
            if (ViewCompat.getImportantForAccessibility(child) == 0) {
                ViewCompat.setImportantForAccessibility(child, 1);
            }
            s(child);
        }
        V(child, layoutDirection);
        if (this.f1843a == null) {
            this.f1843a = ViewDragHelper.create(parent, this.f1842a);
        }
        int savedOuterEdge = this.f1845a.g(child);
        parent.onLayoutChild(child, layoutDirection);
        this.d = parent.getWidth();
        this.e = this.f1845a.h(parent);
        this.f1855c = child.getWidth();
        ViewGroup.MarginLayoutParams margins = (ViewGroup.MarginLayoutParams) child.getLayoutParams();
        this.f = margins != null ? this.f1845a.a(margins) : 0;
        ViewCompat.offsetLeftAndRight(child, l(savedOuterEdge, child));
        O(parent);
        Iterator<Object> it = this.f1848a.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
        }
        return true;
    }

    private void f0(View sheet) {
        int visibility = this.f1839a == 5 ? 4 : 0;
        if (sheet.getVisibility() != visibility) {
            sheet.setVisibility(visibility);
        }
    }

    private void s(View sheet) {
        if (ViewCompat.getAccessibilityPaneTitle(sheet) == null) {
            ViewCompat.setAccessibilityPaneTitle(sheet, sheet.getResources().getString(i));
        }
    }

    private void O(CoordinatorLayout parent) {
        int i2;
        View coplanarSiblingView;
        if (this.f1853b == null && (i2 = this.g) != -1 && (coplanarSiblingView = parent.findViewById(i2)) != null) {
            this.f1853b = new WeakReference<>(coplanarSiblingView);
        }
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.f1855c;
    }

    /* access modifiers changed from: package-private */
    public int C() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public int B() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public int z() {
        return this.f;
    }

    private int l(int savedOuterEdge, V child) {
        switch (this.f1839a) {
            case 1:
            case 2:
                return savedOuterEdge - this.f1845a.g(child);
            case 3:
                return 0;
            case 5:
                return this.f1845a.d();
            default:
                throw new IllegalStateException("Unexpected value: " + this.f1839a);
        }
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        ViewDragHelper viewDragHelper;
        if (!a0(child)) {
            this.f1854b = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            Q();
        }
        if (this.f1841a == null) {
            this.f1841a = VelocityTracker.obtain();
        }
        this.f1841a.addMovement(event);
        switch (action) {
            case 0:
                this.h = (int) event.getX();
                break;
            case 1:
            case 3:
                if (this.f1854b) {
                    this.f1854b = false;
                    return false;
                }
                break;
        }
        if (this.f1854b || (viewDragHelper = this.f1843a) == null || !viewDragHelper.shouldInterceptTouchEvent(event)) {
            return false;
        }
        return true;
    }

    private boolean a0(V child) {
        return (child.isShown() || ViewCompat.getAccessibilityPaneTitle(child) != null) && this.f1851a;
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return HttpStatus.SC_INTERNAL_SERVER_ERROR;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.f1839a == 1 && action == 0) {
            return true;
        }
        if (Y()) {
            this.f1843a.processTouchEvent(event);
        }
        if (action == 0) {
            Q();
        }
        if (this.f1841a == null) {
            this.f1841a = VelocityTracker.obtain();
        }
        this.f1841a.addMovement(event);
        if (Y() && action == 2 && !this.f1854b && I(event)) {
            this.f1843a.captureChildView(child, event.getPointerId(event.getActionIndex()));
        }
        return !this.f1854b;
    }

    private boolean I(MotionEvent event) {
        if (Y() && m((float) this.h, event.getX()) > ((float) this.f1843a.getTouchSlop())) {
            return true;
        }
        return false;
    }

    private float m(float initialPoint, float currentPoint) {
        return Math.abs(initialPoint - currentPoint);
    }

    public int w() {
        return this.f1845a.c();
    }

    public void T(boolean draggable) {
        this.f1851a = draggable;
    }

    public float x() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public float y() {
        return 0.5f;
    }

    public void W(int state) {
        if (state == 1 || state == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("STATE_");
            sb.append(state == 1 ? "DRAGGING" : "SETTLING");
            sb.append(" should not be set externally.");
            throw new IllegalArgumentException(sb.toString());
        }
        int finalState = state;
        WeakReference<V> weakReference = this.f1847a;
        if (weakReference == null || weakReference.get() == null) {
            X(state);
        } else {
            R((View) this.f1847a.get(), new pl0(this, finalState));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(int finalState) {
        V child = (View) this.f1847a.get();
        if (child != null) {
            c0(child, finalState, false);
        }
    }

    private void R(V child, Runnable runnable) {
        if (K(child)) {
            child.post(runnable);
        } else {
            runnable.run();
        }
    }

    private boolean K(V child) {
        ViewParent parent = child.getParent();
        return parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(child);
    }

    /* access modifiers changed from: package-private */
    public void X(int state) {
        View sheet;
        if (this.f1839a != state) {
            this.f1839a = state;
            if (state == 3 || state == 5) {
                this.f1852b = state;
            }
            WeakReference<V> weakReference = this.f1847a;
            if (weakReference != null && (sheet = (View) weakReference.get()) != null) {
                f0(sheet);
                Iterator<Object> it = this.f1848a.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(sheet, state);
                }
                d0();
            }
        }
    }

    private void Q() {
        VelocityTracker velocityTracker = this.f1841a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1841a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean Z(View child, float velocity) {
        return this.f1845a.m(child, velocity);
    }

    private boolean Y() {
        return this.f1843a != null && (this.f1851a || this.f1839a == 1);
    }

    private void q(Context context) {
        if (this.f1846a != null) {
            p00 p00 = new p00(this.f1846a);
            this.f1849a = p00;
            p00.K(context);
            ColorStateList colorStateList = this.f1840a;
            if (colorStateList != null) {
                this.f1849a.V(colorStateList);
                return;
            }
            TypedValue defaultColor = new TypedValue();
            context.getTheme().resolveAttribute(16842801, defaultColor, true);
            this.f1849a.setTint(defaultColor.data);
        }
    }

    /* access modifiers changed from: private */
    public void c0(View child, int state, boolean isReleasingView) {
        if (L(child, state, isReleasingView)) {
            X(2);
            this.f1844a.b(state);
            return;
        }
        X(state);
    }

    private boolean L(View child, int state, boolean isReleasingView) {
        int left = A(state);
        ViewDragHelper viewDragHelper = E();
        return viewDragHelper != null && (!isReleasingView ? viewDragHelper.smoothSlideViewTo(child, left, child.getTop()) : viewDragHelper.settleCapturedViewAt(left, child.getTop()));
    }

    /* access modifiers changed from: package-private */
    public int A(int state) {
        switch (state) {
            case 3:
                return w();
            case 5:
                return this.f1845a.d();
            default:
                throw new IllegalArgumentException("Invalid state to get outer edge offset: " + state);
        }
    }

    /* access modifiers changed from: package-private */
    public ViewDragHelper E() {
        return this.f1843a;
    }

    class a extends ViewDragHelper.Callback {
        a() {
        }

        public boolean tryCaptureView(View child, int pointerId) {
            if (SideSheetBehavior.this.f1839a == 1 || SideSheetBehavior.this.f1847a == null || SideSheetBehavior.this.f1847a.get() != child) {
                return false;
            }
            return true;
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            ViewGroup.MarginLayoutParams layoutParams;
            View coplanarSiblingView = SideSheetBehavior.this.v();
            if (!(coplanarSiblingView == null || (layoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null)) {
                SideSheetBehavior.this.f1845a.n(layoutParams, changedView.getLeft(), changedView.getRight());
                coplanarSiblingView.setLayoutParams(layoutParams);
            }
            SideSheetBehavior.this.r(changedView, left);
        }

        public void onViewDragStateChanged(int state) {
            if (state == 1 && SideSheetBehavior.this.f1851a) {
                SideSheetBehavior.this.X(1);
            }
        }

        public void onViewReleased(View releasedChild, float xVelocity, float yVelocity) {
            int targetState = SideSheetBehavior.this.n(releasedChild, xVelocity, yVelocity);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.c0(releasedChild, targetState, sideSheetBehavior.b0());
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return child.getTop();
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return MathUtils.clamp(left, SideSheetBehavior.this.f1845a.f(), SideSheetBehavior.this.f1845a.e());
        }

        public int getViewHorizontalDragRange(View child) {
            return SideSheetBehavior.this.f1855c + SideSheetBehavior.this.z();
        }
    }

    /* access modifiers changed from: private */
    public int n(View releasedChild, float xVelocity, float yVelocity) {
        if (J(xVelocity)) {
            return 3;
        }
        if (Z(releasedChild, xVelocity) != 0) {
            if (this.f1845a.l(xVelocity, yVelocity) || this.f1845a.k(releasedChild)) {
                return 5;
            }
            return 3;
        } else if (xVelocity != 0.0f && e.a(xVelocity, yVelocity)) {
            return 5;
        } else {
            int currentLeft = releasedChild.getLeft();
            if (Math.abs(currentLeft - w()) < Math.abs(currentLeft - this.f1845a.d())) {
                return 3;
            }
            return 5;
        }
    }

    private boolean J(float xVelocity) {
        return this.f1845a.j(xVelocity);
    }

    /* access modifiers changed from: private */
    public void r(View child, int outerEdge) {
        if (!this.f1848a.isEmpty()) {
            float slideOffset = this.f1845a.b(outerEdge);
            Iterator<Object> it = this.f1848a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(child, slideOffset);
            }
        }
    }

    public void S(int coplanarSiblingViewId) {
        this.g = coplanarSiblingViewId;
        o();
        WeakReference<V> weakReference = this.f1847a;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (coplanarSiblingViewId != -1 && ViewCompat.isLaidOut(view)) {
                view.requestLayout();
            }
        }
    }

    public View v() {
        WeakReference<View> weakReference = this.f1853b;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private void o() {
        WeakReference<View> weakReference = this.f1853b;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f1853b = null;
    }

    public boolean b0() {
        return true;
    }

    class c {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private final Runnable f1857a = new f(this);

        /* renamed from: a  reason: collision with other field name */
        private boolean f1858a;

        c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f1858a = false;
            if (SideSheetBehavior.this.f1843a != null && SideSheetBehavior.this.f1843a.continueSettling(true)) {
                b(this.a);
            } else if (SideSheetBehavior.this.f1839a == 2) {
                SideSheetBehavior.this.X(this.a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int targetState) {
            if (SideSheetBehavior.this.f1847a != null && SideSheetBehavior.this.f1847a.get() != null) {
                this.a = targetState;
                if (!this.f1858a) {
                    ViewCompat.postOnAnimation((View) SideSheetBehavior.this.f1847a.get(), this.f1857a);
                    this.f1858a = true;
                }
            }
        }
    }

    protected static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        final int a;

        public b(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.a = source.readInt();
        }

        public b(Parcelable superState, SideSheetBehavior<?> behavior) {
            super(superState);
            this.a = behavior.f1839a;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.a);
        }

        class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            /* renamed from: b */
            public b createFromParcel(Parcel in, ClassLoader loader) {
                return new b(in, loader);
            }

            /* renamed from: a */
            public b createFromParcel(Parcel in) {
                return new b(in, (ClassLoader) null);
            }

            /* renamed from: c */
            public b[] newArray(int size) {
                return new b[size];
            }
        }
    }

    private void d0() {
        V child;
        WeakReference<V> weakReference = this.f1847a;
        if (weakReference != null && (child = (View) weakReference.get()) != null) {
            ViewCompat.removeAccessibilityAction(child, 262144);
            ViewCompat.removeAccessibilityAction(child, 1048576);
            if (this.f1839a != 5) {
                P(child, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
            }
            if (this.f1839a != 3) {
                P(child, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
            }
        }
    }

    private void P(V child, AccessibilityNodeInfoCompat.AccessibilityActionCompat action, int state) {
        ViewCompat.replaceAccessibilityAction(child, action, (CharSequence) null, p(state));
    }

    private AccessibilityViewCommand p(int state) {
        return new ol0(this, state);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean M(int state, View view, AccessibilityViewCommand.CommandArguments arguments) {
        W(state);
        return true;
    }
}
