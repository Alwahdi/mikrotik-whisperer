package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

class f extends s {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private AnimatorSet f2006a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f2007a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f2008a;

    /* renamed from: a  reason: collision with other field name */
    private final View.OnClickListener f2009a = new c(this);

    /* renamed from: a  reason: collision with other field name */
    private final View.OnFocusChangeListener f2010a = new d(this);

    /* renamed from: a  reason: collision with other field name */
    private EditText f2011a;
    private final int b;

    /* renamed from: b  reason: collision with other field name */
    private final TimeInterpolator f2012b;

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f2011a;
        if (editText != null) {
            Editable text = editText.getText();
            if (text != null) {
                text.clear();
            }
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean hasFocus) {
        A(J());
    }

    f(r endLayout) {
        super(endLayout);
        Context context = endLayout.getContext();
        int i = yb0.motionDurationShort3;
        this.a = i20.f(context, i, 100);
        this.b = i20.f(endLayout.getContext(), i, 150);
        this.f2007a = i20.g(endLayout.getContext(), yb0.motionEasingLinearInterpolator, f3.a);
        this.f2012b = i20.g(endLayout.getContext(), yb0.motionEasingEmphasizedInterpolator, f3.d);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        D();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f2011a;
        if (editText != null) {
            editText.post(new e(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return gc0.mtrl_ic_cancel;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return sc0.clear_text_end_icon_content_description;
    }

    /* access modifiers changed from: package-private */
    public void q(boolean visible) {
        if (this.f2049a.w() != null) {
            A(visible);
        }
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f2009a;
    }

    public void n(EditText editText) {
        this.f2011a = editText;
        this.f2048a.setEndIconVisible(J());
    }

    /* access modifiers changed from: package-private */
    public void a(Editable s) {
        if (this.f2049a.w() == null) {
            A(J());
        }
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f2010a;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return this.f2010a;
    }

    private void A(boolean show) {
        boolean shouldSkipAnimation = this.f2049a.F() == show;
        if (show && !this.f2006a.isRunning()) {
            this.f2008a.cancel();
            this.f2006a.start();
            if (shouldSkipAnimation) {
                this.f2006a.end();
            }
        } else if (!show) {
            this.f2006a.cancel();
            this.f2008a.start();
            if (shouldSkipAnimation) {
                this.f2008a.end();
            }
        }
    }

    private void D() {
        ValueAnimator scaleAnimator = C();
        ValueAnimator fadeAnimator = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f2006a = animatorSet;
        animatorSet.playTogether(new Animator[]{scaleAnimator, fadeAnimator});
        this.f2006a.addListener(new a());
        ValueAnimator B = B(1.0f, 0.0f);
        this.f2008a = B;
        B.addListener(new b());
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationStart(Animator animation) {
            f.this.f2049a.a0(true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animation) {
            f.this.f2049a.a0(false);
        }
    }

    private ValueAnimator B(float... values) {
        ValueAnimator animator = ValueAnimator.ofFloat(values);
        animator.setInterpolator(this.f2007a);
        animator.setDuration((long) this.a);
        animator.addUpdateListener(new b(this));
        return animator;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator animation) {
        this.f2047a.setAlpha(((Float) animation.getAnimatedValue()).floatValue());
    }

    private ValueAnimator C() {
        ValueAnimator animator = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        animator.setInterpolator(this.f2012b);
        animator.setDuration((long) this.b);
        animator.addUpdateListener(new a(this));
        return animator;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator animation) {
        float scale = ((Float) animation.getAnimatedValue()).floatValue();
        this.f2047a.setScaleX(scale);
        this.f2047a.setScaleY(scale);
    }

    private boolean J() {
        EditText editText = this.f2011a;
        return editText != null && (editText.hasFocus() || this.f2047a.hasFocus()) && this.f2011a.getText().length() > 0;
    }
}
