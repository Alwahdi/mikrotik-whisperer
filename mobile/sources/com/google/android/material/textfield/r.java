package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

class r extends LinearLayout {
    private int a = 0;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f2024a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f2025a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final TextWatcher f2026a = new a();

    /* renamed from: a  reason: collision with other field name */
    private View.OnLongClickListener f2027a;

    /* renamed from: a  reason: collision with other field name */
    private final AccessibilityManager f2028a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public EditText f2029a;

    /* renamed from: a  reason: collision with other field name */
    private final FrameLayout f2030a;

    /* renamed from: a  reason: collision with other field name */
    private ImageView.ScaleType f2031a;

    /* renamed from: a  reason: collision with other field name */
    private final TextView f2032a;

    /* renamed from: a  reason: collision with other field name */
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener f2033a;

    /* renamed from: a  reason: collision with other field name */
    private final CheckableImageButton f2034a;

    /* renamed from: a  reason: collision with other field name */
    private final TextInputLayout.f f2035a;

    /* renamed from: a  reason: collision with other field name */
    final TextInputLayout f2036a;

    /* renamed from: a  reason: collision with other field name */
    private final d f2037a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f2038a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<TextInputLayout.g> f2039a = new LinkedHashSet<>();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2040a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f2041b;

    /* renamed from: b  reason: collision with other field name */
    private PorterDuff.Mode f2042b;

    /* renamed from: b  reason: collision with other field name */
    private View.OnLongClickListener f2043b;

    /* renamed from: b  reason: collision with other field name */
    private final CheckableImageButton f2044b;

    class a extends uq0 {
        a() {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            r.this.m().b(s, start, count, after);
        }

        public void afterTextChanged(Editable s) {
            r.this.m().a(s);
        }
    }

    class b implements TextInputLayout.f {
        b() {
        }

        public void a(TextInputLayout textInputLayout) {
            if (r.this.f2029a != textInputLayout.getEditText()) {
                if (r.this.f2029a != null) {
                    r.this.f2029a.removeTextChangedListener(r.this.f2026a);
                    if (r.this.f2029a.getOnFocusChangeListener() == r.this.m().e()) {
                        r.this.f2029a.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                    }
                }
                EditText unused = r.this.f2029a = textInputLayout.getEditText();
                if (r.this.f2029a != null) {
                    r.this.f2029a.addTextChangedListener(r.this.f2026a);
                }
                r.this.m().n(r.this.f2029a);
                r rVar = r.this;
                rVar.h0(rVar.m());
            }
        }
    }

    r(TextInputLayout textInputLayout, TintTypedArray a2) {
        super(textInputLayout.getContext());
        b bVar = new b();
        this.f2035a = bVar;
        this.f2028a = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f2036a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f2030a = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        CheckableImageButton i = i(this, layoutInflater, ic0.text_input_error_icon);
        this.f2034a = i;
        CheckableImageButton i2 = i(frameLayout, layoutInflater, ic0.text_input_end_icon);
        this.f2044b = i2;
        this.f2037a = new d(this, a2);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f2032a = appCompatTextView;
        C(a2);
        B(a2);
        D(a2);
        frameLayout.addView(i2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(i);
        textInputLayout.i(bVar);
        addOnAttachStateChangeListener(new c());
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        public void onViewAttachedToWindow(View ignored) {
            r.this.g();
        }

        public void onViewDetachedFromWindow(View ignored) {
            r.this.M();
        }
    }

    private CheckableImageButton i(ViewGroup root, LayoutInflater inflater, int id) {
        CheckableImageButton iconView = (CheckableImageButton) inflater.inflate(nc0.design_text_input_end_icon, root, false);
        iconView.setId(id);
        t.e(iconView);
        if (o00.h(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) iconView.getLayoutParams(), 0);
        }
        return iconView;
    }

    private void C(TintTypedArray a2) {
        int i = xc0.A5;
        if (a2.hasValue(i)) {
            this.f2024a = o00.b(getContext(), a2, i);
        }
        int i2 = xc0.B5;
        if (a2.hasValue(i2)) {
            this.f2025a = lv0.i(a2.getInt(i2, -1), (PorterDuff.Mode) null);
        }
        int i3 = xc0.z5;
        if (a2.hasValue(i3)) {
            c0(a2.getDrawable(i3));
        }
        this.f2034a.setContentDescription(getResources().getText(sc0.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.f2034a, 2);
        this.f2034a.setClickable(false);
        this.f2034a.setPressable(false);
        this.f2034a.setFocusable(false);
    }

    private void B(TintTypedArray a2) {
        int i = xc0.P5;
        if (!a2.hasValue(i)) {
            int i2 = xc0.u5;
            if (a2.hasValue(i2)) {
                this.f2041b = o00.b(getContext(), a2, i2);
            }
            int i3 = xc0.v5;
            if (a2.hasValue(i3)) {
                this.f2042b = lv0.i(a2.getInt(i3, -1), (PorterDuff.Mode) null);
            }
        }
        int i4 = xc0.s5;
        if (a2.hasValue(i4)) {
            U(a2.getInt(i4, 0));
            int i5 = xc0.p5;
            if (a2.hasValue(i5)) {
                Q(a2.getText(i5));
            }
            O(a2.getBoolean(xc0.o5, true));
        } else if (a2.hasValue(i)) {
            int i6 = xc0.Q5;
            if (a2.hasValue(i6)) {
                this.f2041b = o00.b(getContext(), a2, i6);
            }
            int i7 = xc0.R5;
            if (a2.hasValue(i7)) {
                this.f2042b = lv0.i(a2.getInt(i7, -1), (PorterDuff.Mode) null);
            }
            U(a2.getBoolean(i, false));
            Q(a2.getText(xc0.N5));
        }
        T(a2.getDimensionPixelSize(xc0.r5, getResources().getDimensionPixelSize(cc0.mtrl_min_touch_target_size)));
        int i8 = xc0.t5;
        if (a2.hasValue(i8)) {
            X(t.b(a2.getInt(i8, -1)));
        }
    }

    private void D(TintTypedArray a2) {
        this.f2032a.setVisibility(8);
        this.f2032a.setId(ic0.textinput_suffix_text);
        this.f2032a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.f2032a, 1);
        q0(a2.getResourceId(xc0.g6, 0));
        int i = xc0.h6;
        if (a2.hasValue(i)) {
            r0(a2.getColorStateList(i));
        }
        p0(a2.getText(xc0.f6));
    }

    /* access modifiers changed from: package-private */
    public void b0(int resId) {
        c0(resId != 0 ? AppCompatResources.getDrawable(getContext(), resId) : null);
        K();
    }

    /* access modifiers changed from: package-private */
    public void c0(Drawable errorIconDrawable) {
        this.f2034a.setImageDrawable(errorIconDrawable);
        w0();
        t.a(this.f2036a, this.f2034a, this.f2024a, this.f2025a);
    }

    /* access modifiers changed from: package-private */
    public Drawable s() {
        return this.f2034a.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void f0(ColorStateList errorIconTintList) {
        if (this.f2024a != errorIconTintList) {
            this.f2024a = errorIconTintList;
            t.a(this.f2036a, this.f2034a, errorIconTintList, this.f2025a);
        }
    }

    /* access modifiers changed from: package-private */
    public void g0(PorterDuff.Mode errorIconTintMode) {
        if (this.f2025a != errorIconTintMode) {
            this.f2025a = errorIconTintMode;
            t.a(this.f2036a, this.f2034a, this.f2024a, errorIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(View.OnClickListener errorIconOnClickListener) {
        t.h(this.f2034a, errorIconOnClickListener, this.f2027a);
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton r() {
        return this.f2044b;
    }

    /* access modifiers changed from: package-private */
    public s m() {
        return this.f2037a.c(this.a);
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void U(int endIconMode) {
        if (this.a != endIconMode) {
            t0(m());
            int previousEndIconMode = this.a;
            this.a = endIconMode;
            j(previousEndIconMode);
            a0(endIconMode != 0);
            s delegate = m();
            R(t(delegate));
            P(delegate.c());
            O(delegate.l());
            if (delegate.i(this.f2036a.getBoxBackgroundMode())) {
                s0(delegate);
                V(delegate.f());
                EditText editText = this.f2029a;
                if (editText != null) {
                    delegate.n(editText);
                    h0(delegate);
                }
                t.a(this.f2036a, this.f2044b, this.f2041b, this.f2042b);
                L(true);
                return;
            }
            throw new IllegalStateException("The current box background mode " + this.f2036a.getBoxBackgroundMode() + " is not supported by the end icon mode " + endIconMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(boolean force) {
        boolean wasActivated;
        boolean wasChecked;
        boolean stateChanged = false;
        s delegate = m();
        if (delegate.l() && (wasChecked = this.f2044b.isChecked()) != delegate.m()) {
            this.f2044b.setChecked(!wasChecked);
            stateChanged = true;
        }
        if (delegate.j() && (wasActivated = this.f2044b.isActivated()) != delegate.k()) {
            N(!wasActivated);
            stateChanged = true;
        }
        if (force || stateChanged) {
            J();
        }
    }

    private void s0(s delegate) {
        delegate.s();
        this.f2033a = delegate.h();
        g();
    }

    private void t0(s delegate) {
        M();
        this.f2033a = null;
        delegate.u();
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f2033a != null && this.f2028a != null && ViewCompat.isAttachedToWindow(this)) {
            AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.f2028a, this.f2033a);
        }
    }

    /* access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f2033a;
        if (touchExplorationStateChangeListener != null && (accessibilityManager = this.f2028a) != null) {
            AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
        }
    }

    private int t(s delegate) {
        int customIconResId = this.f2037a.a;
        return customIconResId == 0 ? delegate.d() : customIconResId;
    }

    /* access modifiers changed from: package-private */
    public void V(View.OnClickListener endIconOnClickListener) {
        t.h(this.f2044b, endIconOnClickListener, this.f2043b);
    }

    /* access modifiers changed from: package-private */
    public void W(View.OnLongClickListener endIconOnLongClickListener) {
        this.f2043b = endIconOnLongClickListener;
        t.i(this.f2044b, endIconOnLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void e0(View.OnLongClickListener errorIconOnLongClickListener) {
        this.f2027a = errorIconOnLongClickListener;
        t.i(this.f2034a, errorIconOnLongClickListener);
    }

    /* access modifiers changed from: private */
    public void h0(s delegate) {
        if (this.f2029a != null) {
            if (delegate.e() != null) {
                this.f2029a.setOnFocusChangeListener(delegate.e());
            }
            if (delegate.g() != null) {
                this.f2044b.setOnFocusChangeListener(delegate.g());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void K() {
        t.d(this.f2036a, this.f2034a, this.f2024a);
    }

    /* access modifiers changed from: package-private */
    public void a0(boolean visible) {
        if (F() != visible) {
            this.f2044b.setVisibility(visible ? 0 : 8);
            v0();
            x0();
            this.f2036a.o0();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.f2030a.getVisibility() == 0 && this.f2044b.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void N(boolean endIconActivated) {
        this.f2044b.setActivated(endIconActivated);
    }

    /* access modifiers changed from: package-private */
    public void J() {
        t.d(this.f2036a, this.f2044b, this.f2041b);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean endIconCheckable) {
        this.f2044b.setCheckable(endIconCheckable);
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return A() && this.f2044b.isChecked();
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f2044b.performClick();
        this.f2044b.jumpDrawablesToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public void R(int resId) {
        S(resId != 0 ? AppCompatResources.getDrawable(getContext(), resId) : null);
    }

    /* access modifiers changed from: package-private */
    public void S(Drawable endIconDrawable) {
        this.f2044b.setImageDrawable(endIconDrawable);
        if (endIconDrawable != null) {
            t.a(this.f2036a, this.f2044b, this.f2041b, this.f2042b);
            J();
        }
    }

    /* access modifiers changed from: package-private */
    public Drawable n() {
        return this.f2044b.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void P(int resId) {
        Q(resId != 0 ? getResources().getText(resId) : null);
    }

    /* access modifiers changed from: package-private */
    public void Q(CharSequence endIconContentDescription) {
        if (l() != endIconContentDescription) {
            this.f2044b.setContentDescription(endIconContentDescription);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence l() {
        return this.f2044b.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void Y(ColorStateList endIconTintList) {
        if (this.f2041b != endIconTintList) {
            this.f2041b = endIconTintList;
            t.a(this.f2036a, this.f2044b, endIconTintList, this.f2042b);
        }
    }

    /* access modifiers changed from: package-private */
    public void Z(PorterDuff.Mode endIconTintMode) {
        if (this.f2042b != endIconTintMode) {
            this.f2042b = endIconTintMode;
            t.a(this.f2036a, this.f2044b, this.f2041b, endIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void T(int iconSize) {
        if (iconSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (iconSize != this.b) {
            this.b = iconSize;
            t.g(this.f2044b, iconSize);
            t.g(this.f2034a, iconSize);
        }
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void X(ImageView.ScaleType endIconScaleType) {
        this.f2031a = endIconScaleType;
        t.j(this.f2044b, endIconScaleType);
        t.j(this.f2034a, endIconScaleType);
    }

    /* access modifiers changed from: package-private */
    public ImageView.ScaleType q() {
        return this.f2031a;
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return this.a != 0;
    }

    /* access modifiers changed from: package-private */
    public TextView z() {
        return this.f2032a;
    }

    /* access modifiers changed from: package-private */
    public void p0(CharSequence suffixText) {
        this.f2038a = TextUtils.isEmpty(suffixText) ? null : suffixText;
        this.f2032a.setText(suffixText);
        y0();
    }

    /* access modifiers changed from: package-private */
    public CharSequence w() {
        return this.f2038a;
    }

    /* access modifiers changed from: package-private */
    public void q0(int suffixTextAppearance) {
        TextViewCompat.setTextAppearance(this.f2032a, suffixTextAppearance);
    }

    /* access modifiers changed from: package-private */
    public void r0(ColorStateList suffixTextColor) {
        this.f2032a.setTextColor(suffixTextColor);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList x() {
        return this.f2032a.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public void k0(int resId) {
        l0(resId != 0 ? AppCompatResources.getDrawable(getContext(), resId) : null);
    }

    /* access modifiers changed from: package-private */
    public void l0(Drawable icon) {
        this.f2044b.setImageDrawable(icon);
    }

    /* access modifiers changed from: package-private */
    public void i0(int resId) {
        j0(resId != 0 ? getResources().getText(resId) : null);
    }

    /* access modifiers changed from: package-private */
    public void j0(CharSequence description) {
        this.f2044b.setContentDescription(description);
    }

    /* access modifiers changed from: package-private */
    public Drawable v() {
        return this.f2044b.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public CharSequence u() {
        return this.f2044b.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void m0(boolean enabled) {
        if (enabled && this.a != 1) {
            U(1);
        } else if (!enabled) {
            U(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void n0(ColorStateList tintList) {
        this.f2041b = tintList;
        t.a(this.f2036a, this.f2044b, tintList, this.f2042b);
    }

    /* access modifiers changed from: package-private */
    public void o0(PorterDuff.Mode mode) {
        this.f2042b = mode;
        t.a(this.f2036a, this.f2044b, this.f2041b, mode);
    }

    /* access modifiers changed from: package-private */
    public void H(boolean hintExpanded) {
        this.f2040a = hintExpanded;
        y0();
    }

    /* access modifiers changed from: package-private */
    public void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f2036a.d0());
        }
    }

    private void y0() {
        int oldVisibility = this.f2032a.getVisibility();
        boolean z = false;
        int newVisibility = (this.f2038a == null || this.f2040a) ? 8 : 0;
        if (oldVisibility != newVisibility) {
            s m = m();
            if (newVisibility == 0) {
                z = true;
            }
            m.q(z);
        }
        v0();
        this.f2032a.setVisibility(newVisibility);
        this.f2036a.o0();
    }

    /* access modifiers changed from: package-private */
    public void x0() {
        if (this.f2036a.f1962a != null) {
            ViewCompat.setPaddingRelative(this.f2032a, getContext().getResources().getDimensionPixelSize(cc0.material_input_text_to_prefix_suffix_padding), this.f2036a.f1962a.getPaddingTop(), (F() || G()) ? 0 : ViewCompat.getPaddingEnd(this.f2036a.f1962a), this.f2036a.f1962a.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public int y() {
        int endIconOffset;
        if (F() || G()) {
            endIconOffset = this.f2044b.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.f2044b.getLayoutParams());
        } else {
            endIconOffset = 0;
        }
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.f2032a) + endIconOffset;
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton k() {
        if (G()) {
            return this.f2034a;
        }
        if (!A() || !F()) {
            return null;
        }
        return this.f2044b;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        return this.f2034a.getVisibility() == 0;
    }

    private void w0() {
        int i = 0;
        boolean visible = s() != null && this.f2036a.N() && this.f2036a.d0();
        CheckableImageButton checkableImageButton = this.f2034a;
        if (!visible) {
            i = 8;
        }
        checkableImageButton.setVisibility(i);
        v0();
        x0();
        if (!A()) {
            this.f2036a.o0();
        }
    }

    private void v0() {
        int i = 8;
        this.f2030a.setVisibility((this.f2044b.getVisibility() != 0 || G()) ? 8 : 0);
        if (F() || G() || ((this.f2038a == null || this.f2040a) ? 8 : 0) == 0) {
            i = 0;
        }
        setVisibility(i);
    }

    private void j(int previousIcon) {
        Iterator it = this.f2039a.iterator();
        while (it.hasNext()) {
            ((TextInputLayout.g) it.next()).a(this.f2036a, previousIcon);
        }
    }

    private void u0(boolean tintEndIconOnError) {
        if (!tintEndIconOnError || n() == null) {
            t.a(this.f2036a, this.f2044b, this.f2041b, this.f2042b);
            return;
        }
        Drawable endIconDrawable = DrawableCompat.wrap(n()).mutate();
        DrawableCompat.setTint(endIconDrawable, this.f2036a.getErrorCurrentTextColors());
        this.f2044b.setImageDrawable(endIconDrawable);
    }

    private static class d {
        /* access modifiers changed from: private */
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        private final SparseArray<s> f2045a = new SparseArray<>();

        /* renamed from: a  reason: collision with other field name */
        private final r f2046a;
        private final int b;

        d(r endLayout, TintTypedArray a2) {
            this.f2046a = endLayout;
            this.a = a2.getResourceId(xc0.q5, 0);
            this.b = a2.getResourceId(xc0.O5, 0);
        }

        /* access modifiers changed from: package-private */
        public s c(int endIconMode) {
            s delegate = this.f2045a.get(endIconMode);
            if (delegate != null) {
                return delegate;
            }
            s delegate2 = b(endIconMode);
            this.f2045a.append(endIconMode, delegate2);
            return delegate2;
        }

        private s b(int endIconMode) {
            switch (endIconMode) {
                case -1:
                    return new g(this.f2046a);
                case 0:
                    return new w(this.f2046a);
                case 1:
                    return new y(this.f2046a, this.b);
                case 2:
                    return new f(this.f2046a);
                case 3:
                    return new p(this.f2046a);
                default:
                    throw new IllegalArgumentException("Invalid end icon mode: " + endIconMode);
            }
        }
    }
}
