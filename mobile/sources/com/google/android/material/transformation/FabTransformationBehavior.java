package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f2134a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    private final RectF f2135a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    private final int[] f2136a = new int[2];
    private float b;

    /* renamed from: b  reason: collision with other field name */
    private final RectF f2137b = new RectF();

    /* access modifiers changed from: protected */
    public abstract b v(Context context, boolean z);

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (child.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(dependency instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) dependency).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == child.getId()) {
                return true;
            }
            return false;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams lp) {
        if (lp.dodgeInsetEdges == 0) {
            lp.dodgeInsetEdges = 80;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet f(View dependency, View child, boolean expanded, boolean isAnimating) {
        boolean z = expanded;
        b spec = v(child.getContext(), z);
        if (z) {
            this.a = dependency.getTranslationX();
            this.b = dependency.getTranslationY();
        }
        List<Animator> animations = new ArrayList<>();
        List<Animator.AnimatorListener> listeners = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 21) {
            r(dependency, child, expanded, isAnimating, spec, animations, listeners);
        }
        RectF childBounds = this.f2135a;
        View view = dependency;
        View view2 = child;
        boolean z2 = expanded;
        List<Animator> list = animations;
        List<Animator.AnimatorListener> list2 = listeners;
        u(view, view2, z2, isAnimating, spec, list, list2, childBounds);
        float childWidth = childBounds.width();
        float childHeight = childBounds.height();
        q(view, view2, z2, spec, animations);
        boolean z3 = isAnimating;
        b bVar = spec;
        t(view, view2, z2, z3, bVar, list, list2);
        s(view, view2, z2, z3, bVar, childWidth, childHeight, animations, listeners);
        List<Animator> list3 = animations;
        List<Animator.AnimatorListener> list4 = listeners;
        p(view, view2, z2, z3, bVar, list3, list4);
        o(view, view2, z2, z3, bVar, list3, list4);
        AnimatorSet set = new AnimatorSet();
        g3.a(set, animations);
        set.addListener(new a(z, child, dependency));
        int count = listeners.size();
        for (int i = 0; i < count; i++) {
            set.addListener(listeners.get(i));
        }
        return set;
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ boolean f2139a;
        final /* synthetic */ View b;

        a(boolean z, View view, View view2) {
            this.f2139a = z;
            this.a = view;
            this.b = view2;
        }

        public void onAnimationStart(Animator animation) {
            if (this.f2139a) {
                this.a.setVisibility(0);
                this.b.setAlpha(0.0f);
                this.b.setVisibility(4);
            }
        }

        public void onAnimationEnd(Animator animation) {
            if (!this.f2139a) {
                this.a.setVisibility(4);
                this.b.setAlpha(1.0f);
                this.b.setVisibility(0);
            }
        }
    }

    private void r(View dependency, View child, boolean expanded, boolean currentlyAnimating, b spec, List<Animator> animations, List<Animator.AnimatorListener> list) {
        Animator animator;
        float translationZ = ViewCompat.getElevation(child) - ViewCompat.getElevation(dependency);
        if (expanded) {
            if (!currentlyAnimating) {
                child.setTranslationZ(-translationZ);
            }
            animator = ObjectAnimator.ofFloat(child, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            animator = ObjectAnimator.ofFloat(child, View.TRANSLATION_Z, new float[]{-translationZ});
        }
        spec.a.e("elevation").a(animator);
        animations.add(animator);
    }

    private void q(View dependency, View child, boolean expanded, b spec, List<Animator> animations) {
        float translationX = k(dependency, child, spec.f2140a);
        float translationY = l(dependency, child, spec.f2140a);
        Pair<h20, h20> j = j(translationX, translationY, expanded, spec);
        h20 translationXTiming = (h20) j.first;
        h20 translationYTiming = (h20) j.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        fArr[0] = expanded ? translationX : this.a;
        ValueAnimator translationXAnimator = ObjectAnimator.ofFloat(dependency, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        fArr2[0] = expanded ? translationY : this.b;
        ValueAnimator translationYAnimator = ObjectAnimator.ofFloat(dependency, property2, fArr2);
        translationXTiming.a(translationXAnimator);
        translationYTiming.a(translationYAnimator);
        animations.add(translationXAnimator);
        animations.add(translationYAnimator);
    }

    private void u(View dependency, View child, boolean expanded, boolean currentlyAnimating, b spec, List<Animator> animations, List<Animator.AnimatorListener> list, RectF childBounds) {
        h20 translationXTiming;
        h20 translationYTiming;
        ValueAnimator translationYAnimator;
        ValueAnimator translationXAnimator;
        View view = dependency;
        View view2 = child;
        boolean z = expanded;
        b bVar = spec;
        List<Animator> list2 = animations;
        float translationX = k(view, view2, bVar.f2140a);
        float translationY = l(view, view2, bVar.f2140a);
        Pair<h20, h20> j = j(translationX, translationY, z, bVar);
        h20 translationXTiming2 = (h20) j.first;
        h20 translationYTiming2 = (h20) j.second;
        if (z) {
            if (!currentlyAnimating) {
                view2.setTranslationX(-translationX);
                view2.setTranslationY(-translationY);
            }
            ValueAnimator translationXAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f});
            ValueAnimator translationYAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{0.0f});
            translationYTiming = translationYTiming2;
            translationXTiming = translationXTiming2;
            float f = -translationY;
            Pair<h20, h20> pair = j;
            float f2 = translationX;
            h(child, spec, translationXTiming2, translationYTiming2, -translationX, f, 0.0f, 0.0f, childBounds);
            translationXAnimator = translationXAnimator2;
            translationYAnimator = translationYAnimator2;
            float f3 = translationY;
        } else {
            translationYTiming = translationYTiming2;
            translationXTiming = translationXTiming2;
            Pair<h20, h20> pair2 = j;
            ValueAnimator translationXAnimator3 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{-translationX});
            translationXAnimator = translationXAnimator3;
            translationYAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{-translationY});
        }
        translationXTiming.a(translationXAnimator);
        translationYTiming.a(translationYAnimator);
        list2.add(translationXAnimator);
        list2.add(translationYAnimator);
    }

    private void t(View dependency, View child, boolean expanded, boolean currentlyAnimating, b spec, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    private void s(View dependency, View child, boolean expanded, boolean currentlyAnimating, b spec, float childWidth, float childHeight, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    private void p(View dependency, View child, boolean expanded, boolean currentlyAnimating, b spec, List<Animator> list, List<Animator.AnimatorListener> list2) {
    }

    private void o(View unusedDependency, View child, boolean expanded, boolean currentlyAnimating, b spec, List<Animator> animations, List<Animator.AnimatorListener> list) {
        ViewGroup childContentContainer;
        Animator animator;
        if ((child instanceof ViewGroup) && (childContentContainer = g(child)) != null) {
            if (expanded) {
                if (!currentlyAnimating) {
                    o8.a.set(childContentContainer, Float.valueOf(0.0f));
                }
                animator = ObjectAnimator.ofFloat(childContentContainer, o8.a, new float[]{1.0f});
            } else {
                animator = ObjectAnimator.ofFloat(childContentContainer, o8.a, new float[]{0.0f});
            }
            spec.a.e("contentFade").a(animator);
            animations.add(animator);
        }
    }

    private Pair<h20, h20> j(float translationX, float translationY, boolean expanded, b spec) {
        h20 translationYTiming;
        h20 translationXTiming;
        if (translationX == 0.0f || translationY == 0.0f) {
            translationXTiming = spec.a.e("translationXLinear");
            translationYTiming = spec.a.e("translationYLinear");
        } else if ((!expanded || translationY >= 0.0f) && (expanded || translationY <= 0.0f)) {
            translationXTiming = spec.a.e("translationXCurveDownwards");
            translationYTiming = spec.a.e("translationYCurveDownwards");
        } else {
            translationXTiming = spec.a.e("translationXCurveUpwards");
            translationYTiming = spec.a.e("translationYCurveUpwards");
        }
        return new Pair<>(translationXTiming, translationYTiming);
    }

    private float k(View dependency, View child, s90 positioning) {
        RectF dependencyBounds = this.f2135a;
        RectF childBounds = this.f2137b;
        i(dependency, dependencyBounds);
        n(child, childBounds);
        float translationX = 0.0f;
        switch (positioning.f4976a & 7) {
            case 1:
                translationX = childBounds.centerX() - dependencyBounds.centerX();
                break;
            case 3:
                translationX = childBounds.left - dependencyBounds.left;
                break;
            case 5:
                translationX = childBounds.right - dependencyBounds.right;
                break;
        }
        return translationX + positioning.a;
    }

    private float l(View dependency, View child, s90 positioning) {
        RectF dependencyBounds = this.f2135a;
        RectF childBounds = this.f2137b;
        i(dependency, dependencyBounds);
        n(child, childBounds);
        float translationY = 0.0f;
        switch (positioning.f4976a & 112) {
            case 16:
                translationY = childBounds.centerY() - dependencyBounds.centerY();
                break;
            case 48:
                translationY = childBounds.top - dependencyBounds.top;
                break;
            case 80:
                translationY = childBounds.bottom - dependencyBounds.bottom;
                break;
        }
        return translationY + positioning.b;
    }

    private void n(View view, RectF rect) {
        RectF windowBounds = rect;
        windowBounds.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] windowLocation = this.f2136a;
        view.getLocationInWindow(windowLocation);
        windowBounds.offsetTo((float) windowLocation[0], (float) windowLocation[1]);
        windowBounds.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void i(View view, RectF rect) {
        n(view, rect);
        rect.offset(this.a, this.b);
    }

    private void h(View child, b spec, h20 translationXTiming, h20 translationYTiming, float fromX, float fromY, float toX, float toY, RectF childBounds) {
        float translationX = m(spec, translationXTiming, fromX, toX);
        float translationY = m(spec, translationYTiming, fromY, toY);
        Rect window = this.f2134a;
        child.getWindowVisibleDisplayFrame(window);
        RectF windowF = this.f2135a;
        windowF.set(window);
        RectF childVisibleBounds = this.f2137b;
        n(child, childVisibleBounds);
        childVisibleBounds.offset(translationX, translationY);
        childVisibleBounds.intersect(windowF);
        childBounds.set(childVisibleBounds);
    }

    private float m(b spec, h20 timing, float from, float to) {
        long delay = timing.c();
        long duration = timing.d();
        h20 expansionTiming = spec.a.e("expansion");
        return f3.a(from, to, timing.e().getInterpolation(((float) (((expansionTiming.c() + expansionTiming.d()) + 17) - delay)) / ((float) duration)));
    }

    private ViewGroup g(View view) {
        View childContentContainer = view.findViewById(ic0.mtrl_child_content_container);
        if (childContentContainer != null) {
            return w(childContentContainer);
        }
        return w(view);
    }

    private ViewGroup w(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    protected static class b {
        public g20 a;

        /* renamed from: a  reason: collision with other field name */
        public s90 f2140a;

        protected b() {
        }
    }
}
