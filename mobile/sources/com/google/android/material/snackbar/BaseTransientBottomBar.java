package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.a;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler a = new Handler(Looper.getMainLooper(), new h());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final String f1859a = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f1860a = {yb0.snackbarStyle};
    private static final TimeInterpolator d = f3.b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with other field name */
    public static final boolean f1861d;
    private static final TimeInterpolator e = f3.a;
    private static final TimeInterpolator f = f3.d;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final int f1862a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f1863a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final Context f1864a;

    /* renamed from: a  reason: collision with other field name */
    private final ViewGroup f1865a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityManager f1866a;

    /* renamed from: a  reason: collision with other field name */
    private Behavior f1867a;

    /* renamed from: a  reason: collision with other field name */
    protected final s f1868a;

    /* renamed from: a  reason: collision with other field name */
    a.b f1869a = new l();

    /* renamed from: a  reason: collision with other field name */
    private final Runnable f1870a = new i();

    /* renamed from: a  reason: collision with other field name */
    private List<q<B>> f1871a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final pc f1872a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1873a;
    /* access modifiers changed from: private */
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    private final TimeInterpolator f1874b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1875b = false;
    /* access modifiers changed from: private */
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    private final TimeInterpolator f1876c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1877c;

    /* renamed from: d  reason: collision with other field name */
    private int f1878d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with other field name */
    public int f1879e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with other field name */
    public int f1880f;
    /* access modifiers changed from: private */
    public int g;
    private int h;
    /* access modifiers changed from: private */
    public int i;
    /* access modifiers changed from: private */
    public int j;

    public static abstract class q<B> {
        public abstract void a(B b, int i);

        public abstract void b(B b);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f1861d = i2 >= 16 && i2 <= 19;
    }

    class h implements Handler.Callback {
        h() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((BaseTransientBottomBar) message.obj).W();
                    return true;
                case 1:
                    ((BaseTransientBottomBar) message.obj).I(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    class i implements Runnable {
        i() {
        }

        public void run() {
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f1868a != null && baseTransientBottomBar.f1864a != null) {
                int currentInsetBottom = (sv0.b(BaseTransientBottomBar.this.f1864a).height() - BaseTransientBottomBar.this.G()) + ((int) BaseTransientBottomBar.this.f1868a.getTranslationY());
                if (currentInsetBottom >= BaseTransientBottomBar.this.i) {
                    BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                    int unused = baseTransientBottomBar2.j = baseTransientBottomBar2.i;
                    return;
                }
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f1868a.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(BaseTransientBottomBar.f1859a, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                int unused2 = baseTransientBottomBar3.j = baseTransientBottomBar3.i;
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.i - currentInsetBottom;
                BaseTransientBottomBar.this.f1868a.requestLayout();
            }
        }
    }

    protected BaseTransientBottomBar(Context context, ViewGroup parent, View content, pc contentViewCallback) {
        if (parent == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (content == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback != null) {
            this.f1865a = parent;
            this.f1872a = contentViewCallback;
            this.f1864a = context;
            vq0.a(context);
            s sVar = (s) LayoutInflater.from(context).inflate(E(), parent, false);
            this.f1868a = sVar;
            sVar.setBaseTransientBottomBar(this);
            if (content instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) content).c(sVar.getActionTextColorAlpha());
                ((SnackbarContentLayout) content).setMaxInlineActionWidth(sVar.getMaxInlineActionWidth());
            }
            sVar.addView(content);
            ViewCompat.setAccessibilityLiveRegion(sVar, 1);
            ViewCompat.setImportantForAccessibility(sVar, 1);
            ViewCompat.setFitsSystemWindows(sVar, true);
            ViewCompat.setOnApplyWindowInsetsListener(sVar, new j());
            ViewCompat.setAccessibilityDelegate(sVar, new k());
            this.f1866a = (AccessibilityManager) context.getSystemService("accessibility");
            int i2 = yb0.motionDurationLong2;
            this.c = i20.f(context, i2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
            this.f1862a = i20.f(context, i2, 150);
            this.b = i20.f(context, yb0.motionDurationMedium1, 75);
            int i3 = yb0.motionEasingEmphasizedInterpolator;
            this.f1863a = i20.g(context, i3, e);
            this.f1876c = i20.g(context, i3, f);
            this.f1874b = i20.g(context, i3, d);
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    class j implements OnApplyWindowInsetsListener {
        j() {
        }

        public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
            int unused = BaseTransientBottomBar.this.f1879e = insets.getSystemWindowInsetBottom();
            int unused2 = BaseTransientBottomBar.this.f1880f = insets.getSystemWindowInsetLeft();
            int unused3 = BaseTransientBottomBar.this.g = insets.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.c0();
            return insets;
        }
    }

    class k extends AccessibilityDelegateCompat {
        k() {
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.addAction(1048576);
            info.setDismissable(true);
        }

        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            if (action != 1048576) {
                return super.performAccessibilityAction(host, action, args);
            }
            BaseTransientBottomBar.this.x();
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void c0() {
        ViewGroup.LayoutParams layoutParams = this.f1868a.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(f1859a, "Unable to update margins because layout params are not MarginLayoutParams");
        } else if (this.f1868a.f1889a == null) {
            Log.w(f1859a, "Unable to update margins because original view margins are not set");
        } else if (this.f1868a.getParent() != null) {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int newBottomMargin = this.f1868a.f1889a.bottom + (A() != null ? this.h : this.f1879e);
            int newLeftMargin = this.f1868a.f1889a.left + this.f1880f;
            int newRightMargin = this.f1868a.f1889a.right + this.g;
            int newTopMargin = this.f1868a.f1889a.top;
            boolean marginChanged = (marginParams.bottomMargin == newBottomMargin && marginParams.leftMargin == newLeftMargin && marginParams.rightMargin == newRightMargin && marginParams.topMargin == newTopMargin) ? false : true;
            if (marginChanged) {
                marginParams.bottomMargin = newBottomMargin;
                marginParams.leftMargin = newLeftMargin;
                marginParams.rightMargin = newRightMargin;
                marginParams.topMargin = newTopMargin;
                this.f1868a.requestLayout();
            }
            if ((marginChanged || this.j != this.i) && Build.VERSION.SDK_INT >= 29 && U()) {
                this.f1868a.removeCallbacks(this.f1870a);
                this.f1868a.post(this.f1870a);
            }
        }
    }

    private boolean U() {
        return this.i > 0 && !this.f1873a && K();
    }

    private boolean K() {
        ViewGroup.LayoutParams layoutParams = this.f1868a.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    /* access modifiers changed from: protected */
    public int E() {
        return H() ? nc0.mtrl_layout_snackbar : nc0.design_layout_snackbar;
    }

    /* access modifiers changed from: protected */
    public boolean H() {
        TypedArray a2 = this.f1864a.obtainStyledAttributes(f1860a);
        int snackbarStyleResId = a2.getResourceId(0, -1);
        a2.recycle();
        if (snackbarStyleResId != -1) {
            return true;
        }
        return false;
    }

    public B R(int duration) {
        this.f1878d = duration;
        return this;
    }

    public int B() {
        return this.f1878d;
    }

    public View A() {
        return null;
    }

    public void V() {
        a.c().m(B(), this.f1869a);
    }

    public void x() {
        y(3);
    }

    /* access modifiers changed from: protected */
    public void y(int event) {
        a.c().b(this.f1869a, event);
    }

    public boolean J() {
        return a.c().e(this.f1869a);
    }

    class l implements a.b {
        l() {
        }

        public void show() {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        public void a(int event) {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(1, event, 0, BaseTransientBottomBar.this));
        }
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> C() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public final void W() {
        if (this.f1868a.getParent() == null) {
            ViewGroup.LayoutParams lp = this.f1868a.getLayoutParams();
            if (lp instanceof CoordinatorLayout.LayoutParams) {
                S((CoordinatorLayout.LayoutParams) lp);
            }
            this.f1868a.c(this.f1865a);
            Q();
            this.f1868a.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.f1868a)) {
            X();
        } else {
            this.f1877c = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void L() {
        WindowInsets insets;
        if (Build.VERSION.SDK_INT >= 29 && (insets = this.f1868a.getRootWindowInsets()) != null) {
            this.i = insets.getMandatorySystemGestureInsets().bottom;
            c0();
        }
    }

    /* access modifiers changed from: package-private */
    public void M() {
        if (J()) {
            a.post(new m());
        }
    }

    class m implements Runnable {
        m() {
        }

        public void run() {
            BaseTransientBottomBar.this.O(3);
        }
    }

    /* access modifiers changed from: package-private */
    public void N() {
        if (this.f1877c) {
            X();
            this.f1877c = false;
        }
    }

    private void X() {
        if (T()) {
            s();
            return;
        }
        if (this.f1868a.getParent() != null) {
            this.f1868a.setVisibility(0);
        }
        P();
    }

    /* access modifiers changed from: private */
    public int G() {
        int[] absoluteLocation = new int[2];
        this.f1868a.getLocationInWindow(absoluteLocation);
        return absoluteLocation[1] + this.f1868a.getHeight();
    }

    private void S(CoordinatorLayout.LayoutParams lp) {
        CoordinatorLayout.LayoutParams clp = lp;
        SwipeDismissBehavior<? extends View> behavior = this.f1867a;
        if (behavior == null) {
            behavior = C();
        }
        if (behavior instanceof Behavior) {
            ((Behavior) behavior).m(this);
        }
        behavior.h(new n());
        clp.setBehavior(behavior);
        if (A() == null) {
            clp.insetEdge = 80;
        }
    }

    class n implements SwipeDismissBehavior.c {
        n() {
        }

        public void b(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.y(0);
        }

        public void a(int state) {
            switch (state) {
                case 0:
                    a.c().k(BaseTransientBottomBar.this.f1869a);
                    return;
                case 1:
                case 2:
                    a.c().j(BaseTransientBottomBar.this.f1869a);
                    return;
                default:
                    return;
            }
        }
    }

    private void Q() {
        this.h = u();
        c0();
    }

    private int u() {
        if (A() == null) {
            return 0;
        }
        int[] anchorViewLocation = new int[2];
        A().getLocationOnScreen(anchorViewLocation);
        int anchorViewAbsoluteYTop = anchorViewLocation[1];
        int[] targetParentLocation = new int[2];
        this.f1865a.getLocationOnScreen(targetParentLocation);
        return (targetParentLocation[1] + this.f1865a.getHeight()) - anchorViewAbsoluteYTop;
    }

    class o implements Runnable {
        o() {
        }

        public void run() {
            s sVar = BaseTransientBottomBar.this.f1868a;
            if (sVar != null) {
                if (sVar.getParent() != null) {
                    BaseTransientBottomBar.this.f1868a.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f1868a.getAnimationMode() == 1) {
                    BaseTransientBottomBar.this.Y();
                } else {
                    BaseTransientBottomBar.this.a0();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f1868a.post(new o());
    }

    private void t(int event) {
        if (this.f1868a.getAnimationMode() == 1) {
            Z(event);
        } else {
            b0(event);
        }
    }

    /* access modifiers changed from: private */
    public void Y() {
        ValueAnimator alphaAnimator = z(0.0f, 1.0f);
        ValueAnimator scaleAnimator = D(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{alphaAnimator, scaleAnimator});
        animatorSet.setDuration((long) this.f1862a);
        animatorSet.addListener(new p());
        animatorSet.start();
    }

    class p extends AnimatorListenerAdapter {
        p() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.P();
        }
    }

    private void Z(int event) {
        ValueAnimator animator = z(1.0f, 0.0f);
        animator.setDuration((long) this.b);
        animator.addListener(new a(event));
        animator.start();
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O(this.a);
        }
    }

    private ValueAnimator z(float... alphaValues) {
        ValueAnimator animator = ValueAnimator.ofFloat(alphaValues);
        animator.setInterpolator(this.f1863a);
        animator.addUpdateListener(new b());
        return animator;
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f1868a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    private ValueAnimator D(float... scaleValues) {
        ValueAnimator animator = ValueAnimator.ofFloat(scaleValues);
        animator.setInterpolator(this.f1876c);
        animator.addUpdateListener(new c());
        return animator;
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float scale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f1868a.setScaleX(scale);
            BaseTransientBottomBar.this.f1868a.setScaleY(scale);
        }
    }

    /* access modifiers changed from: private */
    public void a0() {
        int translationYBottom = F();
        if (f1861d) {
            ViewCompat.offsetTopAndBottom(this.f1868a, translationYBottom);
        } else {
            this.f1868a.setTranslationY((float) translationYBottom);
        }
        ValueAnimator animator = new ValueAnimator();
        animator.setIntValues(new int[]{translationYBottom, 0});
        animator.setInterpolator(this.f1874b);
        animator.setDuration((long) this.c);
        animator.addListener(new d());
        animator.addUpdateListener(new e(translationYBottom));
        animator.start();
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1872a.a(BaseTransientBottomBar.this.c - BaseTransientBottomBar.this.f1862a, BaseTransientBottomBar.this.f1862a);
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.P();
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        private int a;
        final /* synthetic */ int b;

        e(int i) {
            this.b = i;
            this.a = i;
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            int currentAnimatedIntValue = ((Integer) animator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f1861d) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f1868a, currentAnimatedIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.f1868a.setTranslationY((float) currentAnimatedIntValue);
            }
            this.a = currentAnimatedIntValue;
        }
    }

    private void b0(int event) {
        ValueAnimator animator = new ValueAnimator();
        animator.setIntValues(new int[]{0, F()});
        animator.setInterpolator(this.f1874b);
        animator.setDuration((long) this.c);
        animator.addListener(new f(event));
        animator.addUpdateListener(new g());
        animator.start();
    }

    class f extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f1872a.b(0, BaseTransientBottomBar.this.b);
        }

        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O(this.a);
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        g() {
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            int currentAnimatedIntValue = ((Integer) animator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f1861d) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f1868a, currentAnimatedIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.f1868a.setTranslationY((float) currentAnimatedIntValue);
            }
            this.a = currentAnimatedIntValue;
        }
    }

    private int F() {
        int translationY = this.f1868a.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f1868a.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return translationY + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return translationY;
    }

    /* access modifiers changed from: package-private */
    public final void I(int event) {
        if (!T() || this.f1868a.getVisibility() != 0) {
            O(event);
        } else {
            t(event);
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Throwable, com.google.android.material.snackbar.BaseTransientBottomBar$q] */
    /* access modifiers changed from: package-private */
    public void P() {
        int i2;
        a.c().i(this.f1869a);
        List<q<B>> list = this.f1871a;
        if (list != null && list.size() - 1 >= 0) {
            b6.a(this.f1871a.get(i2));
            ? r0 = 0;
            r0.b(this);
            throw r0;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable, com.google.android.material.snackbar.BaseTransientBottomBar$q] */
    /* access modifiers changed from: package-private */
    public void O(int event) {
        int i2;
        a.c().h(this.f1869a);
        List<q<B>> list = this.f1871a;
        if (list == null || list.size() - 1 < 0) {
            ViewParent parent = this.f1868a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1868a);
                return;
            }
            return;
        }
        b6.a(this.f1871a.get(i2));
        ? r0 = 0;
        r0.a(this, event);
        throw r0;
    }

    /* access modifiers changed from: package-private */
    public boolean T() {
        AccessibilityManager accessibilityManager = this.f1866a;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> serviceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (serviceList == null || !serviceList.isEmpty()) {
            return false;
        }
        return true;
    }

    protected static class s extends FrameLayout {
        private static final View.OnTouchListener a = new a();

        /* renamed from: a  reason: collision with other field name */
        private final float f1885a;

        /* renamed from: a  reason: collision with other field name */
        private int f1886a;

        /* renamed from: a  reason: collision with other field name */
        private ColorStateList f1887a;

        /* renamed from: a  reason: collision with other field name */
        private PorterDuff.Mode f1888a;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with other field name */
        public Rect f1889a;

        /* renamed from: a  reason: collision with other field name */
        private BaseTransientBottomBar<?> f1890a;

        /* renamed from: a  reason: collision with other field name */
        il0 f1891a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1892a;
        private final float b;

        /* renamed from: b  reason: collision with other field name */
        private final int f1893b;
        private final int c;

        class a implements View.OnTouchListener {
            a() {
            }

            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        }

        protected s(Context context, AttributeSet attrs) {
            super(t00.c(context, attrs, 0, 0), attrs);
            Context context2 = getContext();
            TypedArray a2 = context2.obtainStyledAttributes(attrs, xc0.f5707q1);
            int i = xc0.V3;
            if (a2.hasValue(i)) {
                ViewCompat.setElevation(this, (float) a2.getDimensionPixelSize(i, 0));
            }
            this.f1886a = a2.getInt(xc0.R3, 0);
            if (a2.hasValue(xc0.X3) || a2.hasValue(xc0.Y3)) {
                this.f1891a = il0.e(context2, attrs, 0, 0).m();
            }
            this.f1885a = a2.getFloat(xc0.S3, 1.0f);
            setBackgroundTintList(o00.a(context2, a2, xc0.T3));
            setBackgroundTintMode(lv0.i(a2.getInt(xc0.U3, -1), PorterDuff.Mode.SRC_IN));
            this.b = a2.getFloat(xc0.Q3, 1.0f);
            this.f1893b = a2.getDimensionPixelSize(xc0.P3, -1);
            this.c = a2.getDimensionPixelSize(xc0.W3, -1);
            a2.recycle();
            setOnTouchListener(a);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, d());
            }
        }

        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (!(drawable == null || this.f1887a == null)) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f1887a);
                DrawableCompat.setTintMode(drawable, this.f1888a);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(@Nullable ColorStateList backgroundTint) {
            this.f1887a = backgroundTint;
            if (getBackground() != null) {
                Drawable wrappedBackground = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrappedBackground, backgroundTint);
                DrawableCompat.setTintMode(wrappedBackground, this.f1888a);
                if (wrappedBackground != getBackground()) {
                    super.setBackgroundDrawable(wrappedBackground);
                }
            }
        }

        public void setBackgroundTintMode(@Nullable PorterDuff.Mode backgroundTintMode) {
            this.f1888a = backgroundTintMode;
            if (getBackground() != null) {
                Drawable wrappedBackground = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrappedBackground, backgroundTintMode);
                if (wrappedBackground != getBackground()) {
                    super.setBackgroundDrawable(wrappedBackground);
                }
            }
        }

        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : a);
            super.setOnClickListener(onClickListener);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int i;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.f1893b > 0 && getMeasuredWidth() > (i = this.f1893b)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY), heightMeasureSpec);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int l, int t, int r, int b2) {
            super.onLayout(changed, l, t, r, b2);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f1890a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.N();
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f1890a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.L();
            }
            ViewCompat.requestApplyInsets(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f1890a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.M();
            }
        }

        public void setLayoutParams(ViewGroup.LayoutParams params) {
            super.setLayoutParams(params);
            if (!this.f1892a && (params instanceof ViewGroup.MarginLayoutParams)) {
                e((ViewGroup.MarginLayoutParams) params);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.f1890a;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.c0();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.f1886a;
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int animationMode) {
            this.f1886a = animationMode;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.f1885a;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.b;
        }

        /* access modifiers changed from: package-private */
        public int getMaxWidth() {
            return this.f1893b;
        }

        /* access modifiers changed from: package-private */
        public int getMaxInlineActionWidth() {
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public void c(ViewGroup targetParent) {
            this.f1892a = true;
            targetParent.addView(this);
            this.f1892a = false;
        }

        /* access modifiers changed from: private */
        public void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f1890a = baseTransientBottomBar;
        }

        private void e(ViewGroup.MarginLayoutParams params) {
            this.f1889a = new Rect(params.leftMargin, params.topMargin, params.rightMargin, params.bottomMargin);
        }

        private Drawable d() {
            Drawable background;
            int backgroundColor = k00.l(this, yb0.colorSurface, yb0.colorOnSurface, getBackgroundOverlayColorAlpha());
            il0 il0 = this.f1891a;
            if (il0 != null) {
                background = BaseTransientBottomBar.w(backgroundColor, il0);
            } else {
                background = BaseTransientBottomBar.v(backgroundColor, getResources());
            }
            if (this.f1887a == null) {
                return DrawableCompat.wrap(background);
            }
            Drawable wrappedDrawable = DrawableCompat.wrap(background);
            DrawableCompat.setTintList(wrappedDrawable, this.f1887a);
            return wrappedDrawable;
        }
    }

    /* access modifiers changed from: private */
    public static p00 w(int backgroundColor, il0 shapeAppearanceModel) {
        p00 background = new p00(shapeAppearanceModel);
        background.V(ColorStateList.valueOf(backgroundColor));
        return background;
    }

    /* access modifiers changed from: private */
    public static GradientDrawable v(int backgroundColor, Resources resources) {
        float cornerRadius = resources.getDimension(cc0.mtrl_snackbar_background_corner_radius);
        GradientDrawable background = new GradientDrawable();
        background.setShape(0);
        background.setCornerRadius(cornerRadius);
        background.setColor(backgroundColor);
        return background;
    }

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final r a = new r(this);

        /* access modifiers changed from: private */
        public void m(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a.c(baseTransientBottomBar);
        }

        public boolean b(View child) {
            return this.a.a(child);
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent event) {
            this.a.b(parent, child, event);
            return super.onInterceptTouchEvent(parent, child, event);
        }
    }

    public static class r {
        private a.b a;

        public r(SwipeDismissBehavior<?> behavior) {
            behavior.i(0.1f);
            behavior.g(0.6f);
            behavior.j(0);
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.f1869a;
        }

        public boolean a(View child) {
            return child instanceof s;
        }

        public void b(CoordinatorLayout parent, View child, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    if (parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY())) {
                        a.c().j(this.a);
                        return;
                    }
                    return;
                case 1:
                case 3:
                    a.c().k(this.a);
                    return;
                default:
                    return;
            }
        }
    }
}
