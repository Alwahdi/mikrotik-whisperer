package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class p extends s {
    private static final boolean d = (Build.VERSION.SDK_INT >= 21);
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private long f2013a = LocationRequestCompat.PASSIVE_INTERVAL;

    /* renamed from: a  reason: collision with other field name */
    private final TimeInterpolator f2014a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f2015a;

    /* renamed from: a  reason: collision with other field name */
    private final View.OnClickListener f2016a = new j(this);

    /* renamed from: a  reason: collision with other field name */
    private final View.OnFocusChangeListener f2017a = new k(this);

    /* renamed from: a  reason: collision with other field name */
    private AccessibilityManager f2018a;

    /* renamed from: a  reason: collision with other field name */
    private AutoCompleteTextView f2019a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f2020a = new n(this);

    /* renamed from: a  reason: collision with other field name */
    private boolean f2021a;
    private final int b;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with other field name */
    public ValueAnimator f2022b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f2023b;
    private boolean c;

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean hasFocus) {
        this.f2021a = hasFocus;
        r();
        if (!hasFocus) {
            O(false);
            this.f2023b = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(boolean enabled) {
        AutoCompleteTextView autoCompleteTextView = this.f2019a;
        if (autoCompleteTextView != null && !q.a(autoCompleteTextView)) {
            ViewCompat.setImportantForAccessibility(this.f2047a, enabled ? 2 : 1);
        }
    }

    p(r endLayout) {
        super(endLayout);
        Context context = endLayout.getContext();
        int i = yb0.motionDurationShort3;
        this.b = i20.f(context, i, 67);
        this.a = i20.f(endLayout.getContext(), i, 50);
        this.f2014a = i20.g(endLayout.getContext(), yb0.motionEasingLinearInterpolator, f3.a);
    }

    /* access modifiers changed from: package-private */
    public void s() {
        F();
        this.f2018a = (AccessibilityManager) this.a.getSystemService("accessibility");
    }

    /* access modifiers changed from: package-private */
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f2019a;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener((View.OnTouchListener) null);
            if (d) {
                this.f2019a.setOnDismissListener((AutoCompleteTextView.OnDismissListener) null);
            }
        }
    }

    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f2020a;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return d ? gc0.mtrl_dropdown_arrow : gc0.mtrl_ic_arrow_drop_down;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return sc0.exposed_dropdown_menu_content_description;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f2021a;
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int boxBackgroundMode) {
        return boxBackgroundMode != 0;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f2016a;
    }

    public void n(EditText editText) {
        this.f2019a = D(editText);
        P();
        this.f2048a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f2018a.isTouchExplorationEnabled()) {
            ViewCompat.setImportantForAccessibility(this.f2047a, 2);
        }
        this.f2048a.setEndIconVisible(true);
    }

    public void a(Editable s) {
        if (this.f2018a.isTouchExplorationEnabled() && q.a(this.f2019a) && !this.f2047a.hasFocus()) {
            this.f2019a.dismissDropDown();
        }
        this.f2019a.post(new o(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean isPopupShowing = this.f2019a.isPopupShowing();
        O(isPopupShowing);
        this.f2023b = isPopupShowing;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return this.f2017a;
    }

    public void o(View host, AccessibilityNodeInfoCompat info) {
        if (!q.a(this.f2019a)) {
            info.setClassName(Spinner.class.getName());
        }
        if (info.isShowingHintText()) {
            info.setHintText((CharSequence) null);
        }
    }

    public void p(View host, AccessibilityEvent event) {
        if (this.f2018a.isEnabled() && !q.a(this.f2019a)) {
            boolean invalidState = event.getEventType() == 32768 && this.c && !this.f2019a.isPopupShowing();
            if (event.getEventType() == 1 || invalidState) {
                Q();
                R();
            }
        }
    }

    private void Q() {
        if (this.f2019a != null) {
            if (G()) {
                this.f2023b = false;
            }
            if (!this.f2023b) {
                if (d) {
                    O(!this.c);
                } else {
                    this.c = !this.c;
                    r();
                }
                if (this.c) {
                    this.f2019a.requestFocus();
                    this.f2019a.showDropDown();
                    return;
                }
                this.f2019a.dismissDropDown();
                return;
            }
            this.f2023b = false;
        }
    }

    private void P() {
        this.f2019a.setOnTouchListener(new l(this));
        if (d) {
            this.f2019a.setOnDismissListener(new m(this));
        }
        this.f2019a.setThreshold(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent event) {
        if (event.getAction() == 1) {
            if (G()) {
                this.f2023b = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    private boolean G() {
        long activeFor = System.currentTimeMillis() - this.f2013a;
        return activeFor < 0 || activeFor > 300;
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void R() {
        this.f2023b = true;
        this.f2013a = System.currentTimeMillis();
    }

    private void O(boolean checked) {
        if (this.c != checked) {
            this.c = checked;
            this.f2022b.cancel();
            this.f2015a.start();
        }
    }

    private void F() {
        this.f2022b = E(this.b, 0.0f, 1.0f);
        ValueAnimator E = E(this.a, 1.0f, 0.0f);
        this.f2015a = E;
        E.addListener(new a());
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationEnd(Animator animation) {
            p.this.r();
            p.this.f2022b.start();
        }
    }

    private ValueAnimator E(int duration, float... values) {
        ValueAnimator animator = ValueAnimator.ofFloat(values);
        animator.setInterpolator(this.f2014a);
        animator.setDuration((long) duration);
        animator.addUpdateListener(new i(this));
        return animator;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator animation) {
        this.f2047a.setAlpha(((Float) animation.getAnimatedValue()).floatValue());
    }
}
