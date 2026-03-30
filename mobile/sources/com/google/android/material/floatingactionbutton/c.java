package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

class c extends b {
    private StateListAnimator a;

    c(FloatingActionButton view, hl0 shadowViewDelegate) {
        super(view, shadowViewDelegate);
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList backgroundTint, PorterDuff.Mode backgroundTintMode, ColorStateList rippleColor, int borderWidth) {
        Drawable rippleContent;
        p00 l = l();
        this.f1807a = l;
        l.setTintList(backgroundTint);
        if (backgroundTintMode != null) {
            this.f1807a.setTintMode(backgroundTintMode);
        }
        this.f1807a.K(this.f1801a.getContext());
        if (borderWidth > 0) {
            this.f1802a = j0(borderWidth, backgroundTint);
            rippleContent = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f1802a), (Drawable) Preconditions.checkNotNull(this.f1807a)});
        } else {
            this.f1802a = null;
            rippleContent = this.f1807a;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(ye0.e(rippleColor), rippleContent, (Drawable) null);
        this.f1799a = rippleDrawable;
        this.f1813b = rippleDrawable;
    }

    /* access modifiers changed from: package-private */
    public void W(ColorStateList rippleColor) {
        Drawable drawable = this.f1799a;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(ye0.e(rippleColor));
        } else {
            super.W(rippleColor);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(float elevation, float hoveredFocusedTranslationZ, float pressedTranslationZ) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f1801a.refreshDrawableState();
        } else if (this.f1801a.getStateListAnimator() == this.a) {
            StateListAnimator k0 = k0(elevation, hoveredFocusedTranslationZ, pressedTranslationZ);
            this.a = k0;
            this.f1801a.setStateListAnimator(k0);
        }
        if (a0()) {
            g0();
        }
    }

    private StateListAnimator k0(float elevation, float hoveredFocusedTranslationZ, float pressedTranslationZ) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(b.f1789a, l0(elevation, pressedTranslationZ));
        stateListAnimator.addState(b.b, l0(elevation, hoveredFocusedTranslationZ));
        stateListAnimator.addState(b.c, l0(elevation, hoveredFocusedTranslationZ));
        stateListAnimator.addState(b.f1790d, l0(elevation, hoveredFocusedTranslationZ));
        AnimatorSet set = new AnimatorSet();
        List<Animator> animators = new ArrayList<>();
        animators.add(ObjectAnimator.ofFloat(this.f1801a, "elevation", new float[]{elevation}).setDuration(0));
        int i = Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 24) {
            FloatingActionButton floatingActionButton = this.f1801a;
            animators.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
        }
        animators.add(ObjectAnimator.ofFloat(this.f1801a, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        set.playSequentially((Animator[]) animators.toArray(new Animator[0]));
        set.setInterpolator(b.a);
        stateListAnimator.addState(b.f1791e, set);
        stateListAnimator.addState(b.f1792f, l0(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator l0(float elevation, float translationZ) {
        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(this.f1801a, "elevation", new float[]{elevation}).setDuration(0)).with(ObjectAnimator.ofFloat(this.f1801a, View.TRANSLATION_Z, new float[]{translationZ}).setDuration(100));
        set.setInterpolator(b.a);
        return set;
    }

    public float n() {
        return this.f1801a.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void D() {
        g0();
    }

    /* access modifiers changed from: package-private */
    public boolean a0() {
        return this.f1804a.a() || !c0();
    }

    /* access modifiers changed from: package-private */
    public void F(int[] state) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.f1801a.isEnabled()) {
            this.f1801a.setElevation(this.f1793a);
            if (this.f1801a.isPressed()) {
                this.f1801a.setTranslationZ(this.f1817c);
            } else if (this.f1801a.isFocused() || this.f1801a.isHovered()) {
                this.f1801a.setTranslationZ(this.f1810b);
            } else {
                this.f1801a.setTranslationZ(0.0f);
            }
        } else {
            this.f1801a.setElevation(0.0f);
            this.f1801a.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void B() {
    }

    /* access modifiers changed from: package-private */
    public void e0() {
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public a j0(int borderWidth, ColorStateList backgroundTint) {
        Context context = this.f1801a.getContext();
        a borderDrawable = new a((il0) Preconditions.checkNotNull(this.f1805a));
        borderDrawable.e(ContextCompat.getColor(context, zb0.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, zb0.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, zb0.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, zb0.design_fab_stroke_end_outer_color));
        borderDrawable.d((float) borderWidth);
        borderDrawable.c(backgroundTint);
        return borderDrawable;
    }

    /* access modifiers changed from: package-private */
    public p00 l() {
        return new a((il0) Preconditions.checkNotNull(this.f1805a));
    }

    /* access modifiers changed from: package-private */
    public void s(Rect rect) {
        if (this.f1804a.a()) {
            super.s(rect);
        } else if (!c0()) {
            int minPadding = (this.f1794a - this.f1801a.getSizeDimension()) / 2;
            rect.set(minPadding, minPadding, minPadding, minPadding);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    static class a extends p00 {
        a(il0 shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        public boolean isStateful() {
            return true;
        }
    }
}
