package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class b {
    static final TimeInterpolator a = f3.c;

    /* renamed from: a  reason: collision with other field name */
    static final int[] f1789a = {16842919, 16842910};
    static final int[] b = {16843623, 16842908, 16842910};
    static final int[] c = {16842908, 16842910};
    private static final int d = yb0.motionDurationLong2;

    /* renamed from: d  reason: collision with other field name */
    static final int[] f1790d = {16843623, 16842910};
    private static final int e = yb0.motionEasingEmphasizedInterpolator;

    /* renamed from: e  reason: collision with other field name */
    static final int[] f1791e = {16842910};
    private static final int f = yb0.motionDurationMedium1;

    /* renamed from: f  reason: collision with other field name */
    static final int[] f1792f = new int[0];
    private static final int g = yb0.motionEasingEmphasizedAccelerateInterpolator;

    /* renamed from: a  reason: collision with other field name */
    float f1793a;

    /* renamed from: a  reason: collision with other field name */
    int f1794a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Animator f1795a;

    /* renamed from: a  reason: collision with other field name */
    private final Matrix f1796a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1797a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    private final RectF f1798a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    Drawable f1799a;

    /* renamed from: a  reason: collision with other field name */
    private ViewTreeObserver.OnPreDrawListener f1800a;

    /* renamed from: a  reason: collision with other field name */
    final FloatingActionButton f1801a;

    /* renamed from: a  reason: collision with other field name */
    a f1802a;

    /* renamed from: a  reason: collision with other field name */
    private g20 f1803a;

    /* renamed from: a  reason: collision with other field name */
    final hl0 f1804a;

    /* renamed from: a  reason: collision with other field name */
    il0 f1805a;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<Animator.AnimatorListener> f1806a;

    /* renamed from: a  reason: collision with other field name */
    p00 f1807a;

    /* renamed from: a  reason: collision with other field name */
    private final zm0 f1808a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1809a;

    /* renamed from: b  reason: collision with other field name */
    float f1810b;

    /* renamed from: b  reason: collision with other field name */
    private int f1811b;

    /* renamed from: b  reason: collision with other field name */
    private final RectF f1812b = new RectF();

    /* renamed from: b  reason: collision with other field name */
    Drawable f1813b;

    /* renamed from: b  reason: collision with other field name */
    private g20 f1814b;

    /* renamed from: b  reason: collision with other field name */
    private ArrayList<Animator.AnimatorListener> f1815b;

    /* renamed from: b  reason: collision with other field name */
    boolean f1816b = true;

    /* renamed from: c  reason: collision with other field name */
    float f1817c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public int f1818c = 0;

    /* renamed from: c  reason: collision with other field name */
    private ArrayList<j> f1819c;

    /* renamed from: d  reason: collision with other field name */
    private float f1820d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with other field name */
    public float f1821e = 1.0f;

    interface j {
        void a();

        void b();
    }

    interface k {
        void a();

        void b();
    }

    b(FloatingActionButton view, hl0 shadowViewDelegate) {
        this.f1801a = view;
        this.f1804a = shadowViewDelegate;
        zm0 zm0 = new zm0();
        this.f1808a = zm0;
        zm0.a(f1789a, k(new i()));
        zm0.a(b, k(new h()));
        zm0.a(c, k(new h()));
        zm0.a(f1790d, k(new h()));
        zm0.a(f1791e, k(new l()));
        zm0.a(f1792f, k(new g()));
        this.f1820d = view.getRotation();
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList backgroundTint, PorterDuff.Mode backgroundTintMode, ColorStateList rippleColor, int borderWidth) {
        p00 l2 = l();
        this.f1807a = l2;
        l2.setTintList(backgroundTint);
        if (backgroundTintMode != null) {
            this.f1807a.setTintMode(backgroundTintMode);
        }
        this.f1807a.Z(-12303292);
        this.f1807a.K(this.f1801a.getContext());
        xe0 touchFeedbackShape = new xe0(this.f1807a.B());
        touchFeedbackShape.setTintList(ye0.e(rippleColor));
        this.f1799a = touchFeedbackShape;
        this.f1813b = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f1807a), touchFeedbackShape});
    }

    /* access modifiers changed from: package-private */
    public void M(ColorStateList tint) {
        p00 p00 = this.f1807a;
        if (p00 != null) {
            p00.setTintList(tint);
        }
        a aVar = this.f1802a;
        if (aVar != null) {
            aVar.c(tint);
        }
    }

    /* access modifiers changed from: package-private */
    public void N(PorterDuff.Mode tintMode) {
        p00 p00 = this.f1807a;
        if (p00 != null) {
            p00.setTintMode(tintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void U(int minTouchTargetSize) {
        this.f1794a = minTouchTargetSize;
    }

    /* access modifiers changed from: package-private */
    public void W(ColorStateList rippleColor) {
        Drawable drawable = this.f1799a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, ye0.e(rippleColor));
        }
    }

    /* access modifiers changed from: package-private */
    public final void O(float elevation) {
        if (this.f1793a != elevation) {
            this.f1793a = elevation;
            G(elevation, this.f1810b, this.f1817c);
        }
    }

    /* access modifiers changed from: package-private */
    public float n() {
        return this.f1793a;
    }

    /* access modifiers changed from: package-private */
    public float q() {
        return this.f1810b;
    }

    /* access modifiers changed from: package-private */
    public float t() {
        return this.f1817c;
    }

    /* access modifiers changed from: package-private */
    public final void R(float translationZ) {
        if (this.f1810b != translationZ) {
            this.f1810b = translationZ;
            G(this.f1793a, translationZ, this.f1817c);
        }
    }

    /* access modifiers changed from: package-private */
    public final void V(float translationZ) {
        if (this.f1817c != translationZ) {
            this.f1817c = translationZ;
            G(this.f1793a, this.f1810b, translationZ);
        }
    }

    /* access modifiers changed from: package-private */
    public final void T(int maxImageSize) {
        if (this.f1811b != maxImageSize) {
            this.f1811b = maxImageSize;
            f0();
        }
    }

    /* access modifiers changed from: package-private */
    public final void f0() {
        S(this.f1821e);
    }

    /* access modifiers changed from: package-private */
    public final void S(float scale) {
        this.f1821e = scale;
        Matrix matrix = this.f1796a;
        h(scale, matrix);
        this.f1801a.setImageMatrix(matrix);
    }

    /* access modifiers changed from: private */
    public void h(float scale, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f1801a.getDrawable();
        if (drawable != null && this.f1811b != 0) {
            RectF drawableBounds = this.f1798a;
            RectF imageBounds = this.f1812b;
            drawableBounds.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.f1811b;
            imageBounds.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(drawableBounds, imageBounds, Matrix.ScaleToFit.CENTER);
            int i3 = this.f1811b;
            matrix.postScale(scale, scale, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final void Y(il0 shapeAppearance) {
        this.f1805a = shapeAppearance;
        p00 p00 = this.f1807a;
        if (p00 != null) {
            p00.setShapeAppearanceModel(shapeAppearance);
        }
        Drawable drawable = this.f1799a;
        if (drawable instanceof ll0) {
            ((ll0) drawable).setShapeAppearanceModel(shapeAppearance);
        }
        a aVar = this.f1802a;
        if (aVar != null) {
            aVar.f(shapeAppearance);
        }
    }

    /* access modifiers changed from: package-private */
    public final il0 u() {
        return this.f1805a;
    }

    /* access modifiers changed from: package-private */
    public final g20 v() {
        return this.f1803a;
    }

    /* access modifiers changed from: package-private */
    public final void Z(g20 spec) {
        this.f1803a = spec;
    }

    /* access modifiers changed from: package-private */
    public final g20 p() {
        return this.f1814b;
    }

    /* access modifiers changed from: package-private */
    public final void Q(g20 spec) {
        this.f1814b = spec;
    }

    /* access modifiers changed from: package-private */
    public final boolean c0() {
        return !this.f1809a || this.f1801a.getSizeDimension() >= this.f1794a;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f1809a;
    }

    /* access modifiers changed from: package-private */
    public void P(boolean flag) {
        this.f1809a = flag;
    }

    /* access modifiers changed from: package-private */
    public void X(boolean shadowPaddingEnabled) {
        this.f1816b = shadowPaddingEnabled;
        g0();
    }

    /* access modifiers changed from: package-private */
    public void G(float elevation, float hoveredFocusedTranslationZ, float pressedTranslationZ) {
        B();
        g0();
        h0(elevation);
    }

    /* access modifiers changed from: package-private */
    public void h0(float elevation) {
        p00 p00 = this.f1807a;
        if (p00 != null) {
            p00.U(elevation);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(int[] state) {
        this.f1808a.d(state);
    }

    /* access modifiers changed from: package-private */
    public void B() {
        this.f1808a.c();
    }

    /* access modifiers changed from: package-private */
    public void f(Animator.AnimatorListener listener) {
        if (this.f1806a == null) {
            this.f1806a = new ArrayList<>();
        }
        this.f1806a.add(listener);
    }

    public void e(Animator.AnimatorListener listener) {
        if (this.f1815b == null) {
            this.f1815b = new ArrayList<>();
        }
        this.f1815b.add(listener);
    }

    /* access modifiers changed from: package-private */
    public void x(k listener, boolean fromUser) {
        AnimatorSet set;
        if (!z()) {
            Animator animator = this.f1795a;
            if (animator != null) {
                animator.cancel();
            }
            if (b0()) {
                g20 g20 = this.f1814b;
                if (g20 != null) {
                    set = i(g20, 0.0f, 0.0f, 0.0f);
                } else {
                    set = j(0.0f, 0.4f, 0.4f, f, g);
                }
                set.addListener(new a(fromUser, listener));
                ArrayList<Animator.AnimatorListener> arrayList = this.f1815b;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        set.addListener(it.next());
                    }
                }
                set.start();
                return;
            }
            this.f1801a.b(fromUser ? 8 : 4, fromUser);
            if (listener != null) {
                listener.b();
            }
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ k a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1823a;
        final /* synthetic */ boolean b;

        a(boolean z, k kVar) {
            this.b = z;
            this.a = kVar;
        }

        public void onAnimationStart(Animator animation) {
            b.this.f1801a.b(0, this.b);
            int unused = b.this.f1818c = 1;
            Animator unused2 = b.this.f1795a = animation;
            this.f1823a = false;
        }

        public void onAnimationCancel(Animator animation) {
            this.f1823a = true;
        }

        public void onAnimationEnd(Animator animation) {
            int unused = b.this.f1818c = 0;
            Animator unused2 = b.this.f1795a = null;
            if (!this.f1823a) {
                FloatingActionButton floatingActionButton = b.this.f1801a;
                boolean z = this.b;
                floatingActionButton.b(z ? 8 : 4, z);
                k kVar = this.a;
                if (kVar != null) {
                    kVar.b();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(k listener, boolean fromUser) {
        AnimatorSet set;
        if (!A()) {
            Animator animator = this.f1795a;
            if (animator != null) {
                animator.cancel();
            }
            boolean useDefaultAnimation = this.f1803a == null;
            if (b0()) {
                if (this.f1801a.getVisibility() != 0) {
                    float f2 = 0.0f;
                    this.f1801a.setAlpha(0.0f);
                    this.f1801a.setScaleY(useDefaultAnimation ? 0.4f : 0.0f);
                    this.f1801a.setScaleX(useDefaultAnimation ? 0.4f : 0.0f);
                    if (useDefaultAnimation) {
                        f2 = 0.4f;
                    }
                    S(f2);
                }
                g20 g20 = this.f1803a;
                if (g20 != null) {
                    set = i(g20, 1.0f, 1.0f, 1.0f);
                } else {
                    set = j(1.0f, 1.0f, 1.0f, d, e);
                }
                set.addListener(new C0016b(fromUser, listener));
                ArrayList<Animator.AnimatorListener> arrayList = this.f1806a;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        set.addListener(it.next());
                    }
                }
                set.start();
                return;
            }
            this.f1801a.b(0, fromUser);
            this.f1801a.setAlpha(1.0f);
            this.f1801a.setScaleY(1.0f);
            this.f1801a.setScaleX(1.0f);
            S(1.0f);
            if (listener != null) {
                listener.a();
            }
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$b  reason: collision with other inner class name */
    class C0016b extends AnimatorListenerAdapter {
        final /* synthetic */ k a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f1825a;

        C0016b(boolean z, k kVar) {
            this.f1825a = z;
            this.a = kVar;
        }

        public void onAnimationStart(Animator animation) {
            b.this.f1801a.b(0, this.f1825a);
            int unused = b.this.f1818c = 2;
            Animator unused2 = b.this.f1795a = animation;
        }

        public void onAnimationEnd(Animator animation) {
            int unused = b.this.f1818c = 0;
            Animator unused2 = b.this.f1795a = null;
            k kVar = this.a;
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    private AnimatorSet i(g20 spec, float opacity, float scale, float iconScale) {
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator animatorOpacity = ObjectAnimator.ofFloat(this.f1801a, View.ALPHA, new float[]{opacity});
        spec.e("opacity").a(animatorOpacity);
        animators.add(animatorOpacity);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(this.f1801a, View.SCALE_X, new float[]{scale});
        spec.e("scale").a(animatorScaleX);
        i0(animatorScaleX);
        animators.add(animatorScaleX);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(this.f1801a, View.SCALE_Y, new float[]{scale});
        spec.e("scale").a(animatorScaleY);
        i0(animatorScaleY);
        animators.add(animatorScaleY);
        h(iconScale, this.f1796a);
        ObjectAnimator animatorIconScale = ObjectAnimator.ofObject(this.f1801a, new ur(), new c(), new Matrix[]{new Matrix(this.f1796a)});
        spec.e("iconScale").a(animatorIconScale);
        animators.add(animatorIconScale);
        AnimatorSet set = new AnimatorSet();
        g3.a(set, animators);
        return set;
    }

    class c extends w00 {
        c() {
        }

        /* renamed from: a */
        public Matrix evaluate(float fraction, Matrix startValue, Matrix endValue) {
            float unused = b.this.f1821e = fraction;
            return super.a(fraction, startValue, endValue);
        }
    }

    private AnimatorSet j(float targetOpacity, float targetScale, float targetIconScale, int duration, int interpolator) {
        AnimatorSet set = new AnimatorSet();
        List<Animator> animators = new ArrayList<>();
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        float startAlpha = this.f1801a.getAlpha();
        float startScaleX = this.f1801a.getScaleX();
        float startScaleY = this.f1801a.getScaleY();
        float startImageMatrixScale = this.f1821e;
        float f2 = startAlpha;
        d dVar = r0;
        float f3 = startImageMatrixScale;
        d dVar2 = new d(startAlpha, targetOpacity, startScaleX, targetScale, startScaleY, startImageMatrixScale, targetIconScale, new Matrix(this.f1796a));
        animator.addUpdateListener(dVar);
        animators.add(animator);
        g3.a(set, animators);
        set.setDuration((long) i20.f(this.f1801a.getContext(), duration, this.f1801a.getContext().getResources().getInteger(lc0.material_motion_duration_long_1)));
        set.setInterpolator(i20.g(this.f1801a.getContext(), interpolator, f3.b));
        return set;
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Matrix f1826a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;

        d(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix matrix) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.d = f5;
            this.e = f6;
            this.f = f7;
            this.g = f8;
            this.f1826a = matrix;
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            float progress = ((Float) animation.getAnimatedValue()).floatValue();
            b.this.f1801a.setAlpha(f3.b(this.a, this.b, 0.0f, 0.2f, progress));
            b.this.f1801a.setScaleX(f3.a(this.c, this.d, progress));
            b.this.f1801a.setScaleY(f3.a(this.e, this.d, progress));
            float unused = b.this.f1821e = f3.a(this.f, this.g, progress);
            b.this.h(f3.a(this.f, this.g, progress), this.f1826a);
            b.this.f1801a.setImageMatrix(this.f1826a);
        }
    }

    private void i0(ObjectAnimator animator) {
        if (Build.VERSION.SDK_INT == 26) {
            animator.setEvaluator(new e());
        }
    }

    class e implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        e() {
        }

        /* renamed from: a */
        public Float evaluate(float fraction, Float startValue, Float endValue) {
            float evaluated = this.a.evaluate(fraction, startValue, endValue).floatValue();
            return Float.valueOf(evaluated < 0.1f ? 0.0f : evaluated);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(j listener) {
        if (this.f1819c == null) {
            this.f1819c = new ArrayList<>();
        }
        this.f1819c.add(listener);
    }

    /* access modifiers changed from: package-private */
    public void K() {
        ArrayList<j> arrayList = this.f1819c;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void J() {
        ArrayList<j> arrayList = this.f1819c;
        if (arrayList != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable m() {
        return this.f1813b;
    }

    /* access modifiers changed from: package-private */
    public void D() {
    }

    /* access modifiers changed from: package-private */
    public final void g0() {
        Rect rect = this.f1797a;
        s(rect);
        H(rect);
        this.f1804a.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void s(Rect rect) {
        int touchTargetPadding = w();
        float maxShadowSize = this.f1816b ? n() + this.f1817c : 0.0f;
        int hPadding = Math.max(touchTargetPadding, (int) Math.ceil((double) maxShadowSize));
        int vPadding = Math.max(touchTargetPadding, (int) Math.ceil((double) (1.5f * maxShadowSize)));
        rect.set(hPadding, vPadding, hPadding, vPadding);
    }

    /* access modifiers changed from: package-private */
    public int w() {
        if (this.f1809a) {
            return Math.max((this.f1794a - this.f1801a.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void H(Rect padding) {
        Preconditions.checkNotNull(this.f1813b, "Didn't initialize content background");
        if (a0()) {
            this.f1804a.setBackgroundDrawable(new InsetDrawable(this.f1813b, padding.left, padding.top, padding.right, padding.bottom));
            return;
        }
        this.f1804a.setBackgroundDrawable(this.f1813b);
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void C() {
        p00 p00 = this.f1807a;
        if (p00 != null) {
            q00.f(this.f1801a, p00);
        }
        if (L()) {
            this.f1801a.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    /* access modifiers changed from: package-private */
    public void E() {
        ViewTreeObserver viewTreeObserver = this.f1801a.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f1800a;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f1800a = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public void I() {
        float rotation = this.f1801a.getRotation();
        if (this.f1820d != rotation) {
            this.f1820d = rotation;
            e0();
        }
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.f1800a == null) {
            this.f1800a = new f();
        }
        return this.f1800a;
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            b.this.I();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public p00 l() {
        return new p00((il0) Preconditions.checkNotNull(this.f1805a));
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        if (this.f1801a.getVisibility() != 0) {
            if (this.f1818c == 2) {
                return true;
            }
            return false;
        } else if (this.f1818c != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        if (this.f1801a.getVisibility() == 0) {
            if (this.f1818c == 1) {
                return true;
            }
            return false;
        } else if (this.f1818c != 2) {
            return true;
        } else {
            return false;
        }
    }

    private ValueAnimator k(m impl) {
        ValueAnimator animator = new ValueAnimator();
        animator.setInterpolator(a);
        animator.setDuration(100);
        animator.addListener(impl);
        animator.addUpdateListener(impl);
        animator.setFloatValues(new float[]{0.0f, 1.0f});
        return animator;
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f1830a;
        private float b;

        /* access modifiers changed from: protected */
        public abstract float a();

        private m() {
        }

        /* synthetic */ m(b x0, a x1) {
            this();
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            if (!this.f1830a) {
                p00 p00 = b.this.f1807a;
                this.a = p00 == null ? 0.0f : p00.u();
                this.b = a();
                this.f1830a = true;
            }
            b bVar = b.this;
            float f = this.a;
            bVar.h0((float) ((int) (f + ((this.b - f) * animator.getAnimatedFraction()))));
        }

        public void onAnimationEnd(Animator animator) {
            b.this.h0((float) ((int) this.b));
            this.f1830a = false;
        }
    }

    private class l extends m {
        l() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return b.this.f1793a;
        }
    }

    private class h extends m {
        h() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            b bVar = b.this;
            return bVar.f1793a + bVar.f1810b;
        }
    }

    private class i extends m {
        i() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            b bVar = b.this;
            return bVar.f1793a + bVar.f1817c;
        }
    }

    private class g extends m {
        g() {
            super(b.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private boolean b0() {
        return ViewCompat.isLaidOut(this.f1801a) && !this.f1801a.isInEditMode();
    }

    /* access modifiers changed from: package-private */
    public void e0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f1820d % 90.0f != 0.0f) {
                if (this.f1801a.getLayerType() != 1) {
                    this.f1801a.setLayerType(1, (Paint) null);
                }
            } else if (this.f1801a.getLayerType() != 0) {
                this.f1801a.setLayerType(0, (Paint) null);
            }
        }
        p00 p00 = this.f1807a;
        if (p00 != null) {
            p00.a0((int) this.f1820d);
        }
    }
}
