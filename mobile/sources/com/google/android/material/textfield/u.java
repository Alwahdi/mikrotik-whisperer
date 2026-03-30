package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.util.ArrayList;
import java.util.List;

final class u {
    private final float a;

    /* renamed from: a  reason: collision with other field name */
    private final int f2050a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public Animator f2051a;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f2052a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f2053a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f2054a;

    /* renamed from: a  reason: collision with other field name */
    private Typeface f2055a;

    /* renamed from: a  reason: collision with other field name */
    private FrameLayout f2056a;

    /* renamed from: a  reason: collision with other field name */
    private LinearLayout f2057a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public TextView f2058a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final TextInputLayout f2059a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f2060a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2061a;
    private final int b;

    /* renamed from: b  reason: collision with other field name */
    private final TimeInterpolator f2062b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f2063b;

    /* renamed from: b  reason: collision with other field name */
    private TextView f2064b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f2065b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2066b;
    private final int c;

    /* renamed from: c  reason: collision with other field name */
    private final TimeInterpolator f2067c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f2068c;
    private int d;
    /* access modifiers changed from: private */
    public int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public u(TextInputLayout textInputView) {
        Context context = textInputView.getContext();
        this.f2053a = context;
        this.f2059a = textInputView;
        this.a = (float) context.getResources().getDimensionPixelSize(cc0.design_textinput_caption_translate_y);
        int i2 = yb0.motionDurationShort4;
        this.f2050a = i20.f(context, i2, 217);
        this.b = i20.f(context, yb0.motionDurationMedium4, 167);
        this.c = i20.f(context, i2, 167);
        int i3 = yb0.motionEasingEmphasizedDecelerateInterpolator;
        this.f2052a = i20.g(context, i3, f3.d);
        TimeInterpolator timeInterpolator = f3.a;
        this.f2062b = i20.g(context, i3, timeInterpolator);
        this.f2067c = i20.g(context, yb0.motionEasingLinearInterpolator, timeInterpolator);
    }

    /* access modifiers changed from: package-private */
    public void R(CharSequence helperText) {
        h();
        this.f2068c = helperText;
        this.f2064b.setText(helperText);
        int i2 = this.e;
        if (i2 != 2) {
            this.f = 2;
        }
        S(i2, this.f, P(this.f2064b, helperText));
    }

    /* access modifiers changed from: package-private */
    public void x() {
        h();
        int i2 = this.e;
        if (i2 == 2) {
            this.f = 0;
        }
        S(i2, this.f, P(this.f2064b, ""));
    }

    /* access modifiers changed from: package-private */
    public void Q(CharSequence errorText) {
        h();
        this.f2060a = errorText;
        this.f2058a.setText(errorText);
        int i2 = this.e;
        if (i2 != 1) {
            this.f = 1;
        }
        S(i2, this.f, P(this.f2058a, errorText));
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f2060a = null;
        h();
        if (this.e == 1) {
            if (!this.f2066b || TextUtils.isEmpty(this.f2068c)) {
                this.f = 0;
            } else {
                this.f = 2;
            }
        }
        S(this.e, this.f, P(this.f2058a, ""));
    }

    private boolean P(TextView captionView, CharSequence captionText) {
        return ViewCompat.isLaidOut(this.f2059a) && this.f2059a.isEnabled() && (this.f != this.e || captionView == null || !TextUtils.equals(captionView.getText(), captionText));
    }

    private void S(int captionToHide, int captionToShow, boolean animate) {
        int i2 = captionToShow;
        boolean z = animate;
        if (captionToHide != i2) {
            if (z) {
                AnimatorSet captionAnimator = new AnimatorSet();
                this.f2051a = captionAnimator;
                List<Animator> captionAnimatorList = new ArrayList<>();
                List<Animator> list = captionAnimatorList;
                int i3 = captionToHide;
                int i4 = captionToShow;
                i(list, this.f2066b, this.f2064b, 2, i3, i4);
                i(list, this.f2061a, this.f2058a, 1, i3, i4);
                g3.a(captionAnimator, captionAnimatorList);
                captionAnimator.addListener(new a(captionToShow, m(captionToHide), captionToHide, m(i2)));
                captionAnimator.start();
            } else {
                D(captionToHide, captionToShow);
            }
            this.f2059a.p0();
            this.f2059a.u0(z);
            this.f2059a.A0();
        }
    }

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ TextView f2069a;
        final /* synthetic */ int b;

        /* renamed from: b  reason: collision with other field name */
        final /* synthetic */ TextView f2071b;

        a(int i, TextView textView, int i2, TextView textView2) {
            this.a = i;
            this.f2069a = textView;
            this.b = i2;
            this.f2071b = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            int unused = u.this.e = this.a;
            Animator unused2 = u.this.f2051a = null;
            TextView textView = this.f2069a;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.b == 1 && u.this.f2058a != null) {
                    u.this.f2058a.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f2071b;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f2071b.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f2071b;
            if (textView != null) {
                textView.setVisibility(0);
                this.f2071b.setAlpha(0.0f);
            }
        }
    }

    private void D(int captionToHide, int captionToShow) {
        TextView captionViewDisplayed;
        TextView captionViewToShow;
        if (captionToHide != captionToShow) {
            if (!(captionToShow == 0 || (captionViewToShow = m(captionToShow)) == null)) {
                captionViewToShow.setVisibility(0);
                captionViewToShow.setAlpha(1.0f);
            }
            if (!(captionToHide == 0 || (captionViewDisplayed = m(captionToHide)) == null)) {
                captionViewDisplayed.setVisibility(4);
                if (captionToHide == 1) {
                    captionViewDisplayed.setText((CharSequence) null);
                }
            }
            this.e = captionToShow;
        }
    }

    private void i(List<Animator> captionAnimatorList, boolean captionEnabled, TextView captionView, int captionState, int captionToHide, int captionToShow) {
        if (captionView != null && captionEnabled) {
            boolean enableShowAnimation = false;
            if (captionState == captionToShow || captionState == captionToHide) {
                Animator animator = j(captionView, captionToShow == captionState);
                if (captionState == captionToShow && captionToHide != 0) {
                    enableShowAnimation = true;
                }
                if (enableShowAnimation) {
                    animator.setStartDelay((long) this.c);
                }
                captionAnimatorList.add(animator);
                if (captionToShow == captionState && captionToHide != 0) {
                    Animator translationYAnimator = k(captionView);
                    translationYAnimator.setStartDelay((long) this.c);
                    captionAnimatorList.add(translationYAnimator);
                }
            }
        }
    }

    private ObjectAnimator j(TextView captionView, boolean display) {
        long j;
        TimeInterpolator timeInterpolator;
        ObjectAnimator opacityAnimator = ObjectAnimator.ofFloat(captionView, View.ALPHA, new float[]{display ? 1.0f : 0.0f});
        if (display) {
            j = (long) this.b;
        } else {
            j = (long) this.c;
        }
        opacityAnimator.setDuration(j);
        if (display) {
            timeInterpolator = this.f2062b;
        } else {
            timeInterpolator = this.f2067c;
        }
        opacityAnimator.setInterpolator(timeInterpolator);
        return opacityAnimator;
    }

    private ObjectAnimator k(TextView captionView) {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(captionView, View.TRANSLATION_Y, new float[]{-this.a, 0.0f});
        translationYAnimator.setDuration((long) this.f2050a);
        translationYAnimator.setInterpolator(this.f2052a);
        return translationYAnimator;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Animator animator = this.f2051a;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean z(int index) {
        return index == 0 || index == 1;
    }

    private TextView m(int captionDisplayState) {
        switch (captionDisplayState) {
            case 1:
                return this.f2058a;
            case 2:
                return this.f2064b;
            default:
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            EditText editText = this.f2059a.getEditText();
            boolean isFontScaleLarge = o00.h(this.f2053a);
            LinearLayout linearLayout = this.f2057a;
            int i2 = cc0.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, v(isFontScaleLarge, i2, ViewCompat.getPaddingStart(editText)), v(isFontScaleLarge, cc0.material_helper_text_font_1_3_padding_top, this.f2053a.getResources().getDimensionPixelSize(cc0.material_helper_text_default_padding_top)), v(isFontScaleLarge, i2, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    private boolean g() {
        return (this.f2057a == null || this.f2059a.getEditText() == null) ? false : true;
    }

    private int v(boolean isFontScaleLarge, int largeFontPaddingRes, int defaultPadding) {
        if (isFontScaleLarge) {
            return this.f2053a.getResources().getDimensionPixelSize(largeFontPaddingRes);
        }
        return defaultPadding;
    }

    /* access modifiers changed from: package-private */
    public void e(TextView indicator, int index) {
        if (this.f2057a == null && this.f2056a == null) {
            LinearLayout linearLayout = new LinearLayout(this.f2053a);
            this.f2057a = linearLayout;
            linearLayout.setOrientation(0);
            this.f2059a.addView(this.f2057a, -1, -2);
            this.f2056a = new FrameLayout(this.f2053a);
            this.f2057a.addView(this.f2056a, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f2059a.getEditText() != null) {
                f();
            }
        }
        if (z(index)) {
            this.f2056a.setVisibility(0);
            this.f2056a.addView(indicator);
        } else {
            this.f2057a.addView(indicator, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f2057a.setVisibility(0);
        this.d++;
    }

    /* access modifiers changed from: package-private */
    public void C(TextView indicator, int index) {
        FrameLayout frameLayout;
        if (this.f2057a != null) {
            if (!z(index) || (frameLayout = this.f2056a) == null) {
                this.f2057a.removeView(indicator);
            } else {
                frameLayout.removeView(indicator);
            }
            int i2 = this.d - 1;
            this.d = i2;
            O(this.f2057a, i2);
        }
    }

    private void O(ViewGroup viewGroup, int indicatorsAdded) {
        if (indicatorsAdded == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(boolean enabled) {
        if (this.f2061a != enabled) {
            h();
            if (enabled) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f2053a);
                this.f2058a = appCompatTextView;
                appCompatTextView.setId(ic0.textinput_error);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f2058a.setTextAlignment(5);
                }
                Typeface typeface = this.f2055a;
                if (typeface != null) {
                    this.f2058a.setTypeface(typeface);
                }
                H(this.h);
                I(this.f2054a);
                F(this.f2065b);
                E(this.g);
                this.f2058a.setVisibility(4);
                e(this.f2058a, 0);
            } else {
                w();
                C(this.f2058a, 0);
                this.f2058a = null;
                this.f2059a.p0();
                this.f2059a.A0();
            }
            this.f2061a = enabled;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.f2061a;
    }

    /* access modifiers changed from: package-private */
    public boolean B() {
        return this.f2066b;
    }

    /* access modifiers changed from: package-private */
    public void K(boolean enabled) {
        if (this.f2066b != enabled) {
            h();
            if (enabled) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f2053a);
                this.f2064b = appCompatTextView;
                appCompatTextView.setId(ic0.textinput_helper_text);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 17) {
                    this.f2064b.setTextAlignment(5);
                }
                Typeface typeface = this.f2055a;
                if (typeface != null) {
                    this.f2064b.setTypeface(typeface);
                }
                this.f2064b.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f2064b, 1);
                J(this.i);
                L(this.f2063b);
                e(this.f2064b, 1);
                if (i2 >= 17) {
                    this.f2064b.setAccessibilityDelegate(new b());
                }
            } else {
                x();
                C(this.f2064b, 1);
                this.f2064b = null;
                this.f2059a.p0();
                this.f2059a.A0();
            }
            this.f2066b = enabled;
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            View editText = u.this.f2059a.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View t() {
        return this.f2064b;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return y(this.f);
    }

    private boolean y(int captionState) {
        if (captionState != 1 || this.f2058a == null || TextUtils.isEmpty(this.f2060a)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f2060a;
    }

    /* access modifiers changed from: package-private */
    public CharSequence s() {
        return this.f2068c;
    }

    /* access modifiers changed from: package-private */
    public void N(Typeface typeface) {
        if (typeface != this.f2055a) {
            this.f2055a = typeface;
            M(this.f2058a, typeface);
            M(this.f2064b, typeface);
        }
    }

    private void M(TextView captionView, Typeface typeface) {
        if (captionView != null) {
            captionView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f2058a;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList r() {
        TextView textView = this.f2058a;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void I(ColorStateList errorViewTextColor) {
        this.f2054a = errorViewTextColor;
        TextView textView = this.f2058a;
        if (textView != null && errorViewTextColor != null) {
            textView.setTextColor(errorViewTextColor);
        }
    }

    /* access modifiers changed from: package-private */
    public void H(int resId) {
        this.h = resId;
        TextView textView = this.f2058a;
        if (textView != null) {
            this.f2059a.c0(textView, resId);
        }
    }

    /* access modifiers changed from: package-private */
    public void F(CharSequence errorContentDescription) {
        this.f2065b = errorContentDescription;
        TextView textView = this.f2058a;
        if (textView != null) {
            textView.setContentDescription(errorContentDescription);
        }
    }

    /* access modifiers changed from: package-private */
    public void E(int accessibilityLiveRegion) {
        this.g = accessibilityLiveRegion;
        TextView textView = this.f2058a;
        if (textView != null) {
            ViewCompat.setAccessibilityLiveRegion(textView, accessibilityLiveRegion);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence o() {
        return this.f2065b;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        TextView textView = this.f2064b;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void L(ColorStateList helperTextViewTextColor) {
        this.f2063b = helperTextViewTextColor;
        TextView textView = this.f2064b;
        if (textView != null && helperTextViewTextColor != null) {
            textView.setTextColor(helperTextViewTextColor);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(int resId) {
        this.i = resId;
        TextView textView = this.f2064b;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, resId);
        }
    }
}
