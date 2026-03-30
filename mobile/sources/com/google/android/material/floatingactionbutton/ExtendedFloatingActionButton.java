package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public abstract class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    static final Property<View, Float> a;
    static final Property<View, Float> b;
    static final Property<View, Float> c;
    static final Property<View, Float> d;
    private static final int j = uc0.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;

    /* renamed from: a  reason: collision with other field name */
    private final d f1754a;

    /* renamed from: b  reason: collision with other field name */
    private final d f1755b;

    /* renamed from: c  reason: collision with other field name */
    private final d f1756c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1757c;

    /* renamed from: d  reason: collision with other field name */
    private final d f1758d;
    private int g;
    private int h;
    private int i;

    public static abstract class f {
    }

    static {
        Class<Float> cls = Float.class;
        a = new b(cls, "width");
        b = new c(cls, "height");
        c = new d(cls, "paddingStart");
        d = new e(cls, "paddingEnd");
    }

    /* access modifiers changed from: private */
    public void l(int strategyType, f callback) {
        d strategy;
        switch (strategyType) {
            case 0:
                strategy = this.f1756c;
                break;
            case 1:
                strategy = this.f1758d;
                break;
            case 2:
                strategy = this.f1754a;
                break;
            case 3:
                strategy = this.f1755b;
                break;
            default:
                throw new IllegalStateException("Unknown strategy type: " + strategyType);
        }
        if (!strategy.d()) {
            if (!m()) {
                strategy.c();
                strategy.e(callback);
                return;
            }
            if (strategyType == 2) {
                ViewGroup.LayoutParams lp = getLayoutParams();
                if (lp != null) {
                    this.h = lp.width;
                    this.i = lp.height;
                } else {
                    this.h = getWidth();
                    this.i = getHeight();
                }
            }
            measure(0, 0);
            Animator animator = strategy.f();
            animator.addListener(new a(this, strategy, callback));
            for (Animator.AnimatorListener l : strategy.b()) {
                animator.addListener(l);
            }
            animator.start();
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ f a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ d f1762a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1763a;

        a(ExtendedFloatingActionButton this$0, d dVar, f fVar) {
            this.f1762a = dVar;
        }

        public void onAnimationStart(Animator animation) {
            this.f1762a.onAnimationStart(animation);
            this.f1763a = false;
        }

        public void onAnimationCancel(Animator animation) {
            this.f1763a = true;
            this.f1762a.a();
        }

        public void onAnimationEnd(Animator animation) {
            this.f1762a.g();
            if (!this.f1763a) {
                this.f1762a.e(this.a);
            }
        }
    }

    private boolean k() {
        if (getVisibility() != 0) {
            if (this.g == 2) {
                return true;
            }
            return false;
        } else if (this.g != 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean m() {
        return (ViewCompat.isLaidOut(this) || (!k() && this.f1757c)) && !isInEditMode();
    }

    class b extends Property<View, Float> {
        b(Class type, String name) {
            super(type, name);
        }

        /* renamed from: b */
        public void set(View object, Float value) {
            object.getLayoutParams().width = value.intValue();
            object.requestLayout();
        }

        /* renamed from: a */
        public Float get(View object) {
            return Float.valueOf((float) object.getLayoutParams().width);
        }
    }

    class c extends Property<View, Float> {
        c(Class type, String name) {
            super(type, name);
        }

        /* renamed from: b */
        public void set(View object, Float value) {
            object.getLayoutParams().height = value.intValue();
            object.requestLayout();
        }

        /* renamed from: a */
        public Float get(View object) {
            return Float.valueOf((float) object.getLayoutParams().height);
        }
    }

    class d extends Property<View, Float> {
        d(Class type, String name) {
            super(type, name);
        }

        /* renamed from: b */
        public void set(View object, Float value) {
            ViewCompat.setPaddingRelative(object, value.intValue(), object.getPaddingTop(), ViewCompat.getPaddingEnd(object), object.getPaddingBottom());
        }

        /* renamed from: a */
        public Float get(View object) {
            return Float.valueOf((float) ViewCompat.getPaddingStart(object));
        }
    }

    class e extends Property<View, Float> {
        e(Class type, String name) {
            super(type, name);
        }

        /* renamed from: b */
        public void set(View object, Float value) {
            ViewCompat.setPaddingRelative(object, ViewCompat.getPaddingStart(object), object.getPaddingTop(), value.intValue(), object.getPaddingBottom());
        }

        /* renamed from: a */
        public Float get(View object) {
            return Float.valueOf((float) ViewCompat.getPaddingEnd(object));
        }
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;

        /* renamed from: a  reason: collision with other field name */
        private f f1759a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1760a;
        private f b;

        /* renamed from: b  reason: collision with other field name */
        private boolean f1761b;

        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            b6.a(view);
            return b(coordinatorLayout, (ExtendedFloatingActionButton) null, rect);
        }

        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            b6.a(view);
            return d(coordinatorLayout, (ExtendedFloatingActionButton) null, view2);
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            b6.a(view);
            return e(coordinatorLayout, (ExtendedFloatingActionButton) null, i);
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.f1760a = false;
            this.f1761b = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            TypedArray a2 = context.obtainStyledAttributes(attrs, xc0.f5649W);
            this.f1760a = a2.getBoolean(xc0.F1, false);
            this.f1761b = a2.getBoolean(xc0.G1, true);
            a2.recycle();
        }

        public boolean b(CoordinatorLayout parent, ExtendedFloatingActionButton child, Rect rect) {
            return super.getInsetDodgeRect(parent, child, rect);
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams lp) {
            if (lp.dodgeInsetEdges == 0) {
                lp.dodgeInsetEdges = 80;
            }
        }

        public boolean d(CoordinatorLayout parent, ExtendedFloatingActionButton child, View dependency) {
            if (dependency instanceof AppBarLayout) {
                h(parent, (AppBarLayout) dependency, child);
                return false;
            } else if (!c(dependency)) {
                return false;
            } else {
                i(dependency, child);
                return false;
            }
        }

        private static boolean c(View view) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) lp).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean f(View dependency, ExtendedFloatingActionButton child) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            if ((this.f1760a || this.f1761b) && lp.getAnchorId() == dependency.getId()) {
                return true;
            }
            return false;
        }

        private boolean h(CoordinatorLayout parent, AppBarLayout appBarLayout, ExtendedFloatingActionButton child) {
            if (!f(appBarLayout, child)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            fg.a(parent, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                g(child);
                return true;
            }
            a(child);
            return true;
        }

        private boolean i(View bottomSheet, ExtendedFloatingActionButton child) {
            if (!f(bottomSheet, child)) {
                return false;
            }
            if (bottomSheet.getTop() < (child.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin) {
                g(child);
                return true;
            }
            a(child);
            return true;
        }

        /* access modifiers changed from: protected */
        public void g(ExtendedFloatingActionButton fab) {
            f callback;
            boolean z = this.f1761b;
            if (z) {
                callback = this.b;
            } else {
                callback = this.f1759a;
            }
            fab.l(z ? 2 : 1, callback);
        }

        /* access modifiers changed from: protected */
        public void a(ExtendedFloatingActionButton fab) {
            f callback;
            boolean z = this.f1761b;
            if (z) {
                callback = this.b;
            } else {
                callback = this.f1759a;
            }
            fab.l(z ? 3 : 0, callback);
        }

        public boolean e(CoordinatorLayout parent, ExtendedFloatingActionButton child, int layoutDirection) {
            List<View> dependencies = parent.getDependencies(child);
            int count = dependencies.size();
            for (int i = 0; i < count; i++) {
                View dependency = dependencies.get(i);
                if (!(dependency instanceof AppBarLayout)) {
                    if (c(dependency) && i(dependency, child)) {
                        break;
                    }
                } else if (h(parent, (AppBarLayout) dependency, child)) {
                    break;
                }
            }
            parent.onLayoutChild(child, layoutDirection);
            return true;
        }
    }
}
