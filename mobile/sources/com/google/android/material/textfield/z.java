package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.CheckableImageButton;

class z extends LinearLayout {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f2081a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f2082a;

    /* renamed from: a  reason: collision with other field name */
    private View.OnLongClickListener f2083a;

    /* renamed from: a  reason: collision with other field name */
    private ImageView.ScaleType f2084a;

    /* renamed from: a  reason: collision with other field name */
    private final TextView f2085a;

    /* renamed from: a  reason: collision with other field name */
    private final CheckableImageButton f2086a;

    /* renamed from: a  reason: collision with other field name */
    private final TextInputLayout f2087a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f2088a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2089a;

    z(TextInputLayout textInputLayout, TintTypedArray a2) {
        super(textInputLayout.getContext());
        this.f2087a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(nc0.design_text_input_start_icon, this, false);
        this.f2086a = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f2085a = appCompatTextView;
        j(a2);
        i(a2);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void j(TintTypedArray a2) {
        if (o00.h(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.f2086a.getLayoutParams(), 0);
        }
        u((View.OnClickListener) null);
        v((View.OnLongClickListener) null);
        int i = xc0.d6;
        if (a2.hasValue(i)) {
            this.f2081a = o00.b(getContext(), a2, i);
        }
        int i2 = xc0.e6;
        if (a2.hasValue(i2)) {
            this.f2082a = lv0.i(a2.getInt(i2, -1), (PorterDuff.Mode) null);
        }
        int i3 = xc0.a6;
        if (a2.hasValue(i3)) {
            s(a2.getDrawable(i3));
            int i4 = xc0.Z5;
            if (a2.hasValue(i4)) {
                r(a2.getText(i4));
            }
            q(a2.getBoolean(xc0.Y5, true));
        }
        t(a2.getDimensionPixelSize(xc0.b6, getResources().getDimensionPixelSize(cc0.mtrl_min_touch_target_size)));
        int i5 = xc0.c6;
        if (a2.hasValue(i5)) {
            w(t.b(a2.getInt(i5, -1)));
        }
    }

    private void i(TintTypedArray a2) {
        this.f2085a.setVisibility(8);
        this.f2085a.setId(ic0.textinput_prefix_text);
        this.f2085a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.f2085a, 1);
        o(a2.getResourceId(xc0.W5, 0));
        int i = xc0.X5;
        if (a2.hasValue(i)) {
            p(a2.getColorStateList(i));
        }
        n(a2.getText(xc0.V5));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        B();
    }

    /* access modifiers changed from: package-private */
    public TextView d() {
        return this.f2085a;
    }

    /* access modifiers changed from: package-private */
    public void n(CharSequence prefixText) {
        this.f2088a = TextUtils.isEmpty(prefixText) ? null : prefixText;
        this.f2085a.setText(prefixText);
        C();
    }

    /* access modifiers changed from: package-private */
    public CharSequence a() {
        return this.f2088a;
    }

    /* access modifiers changed from: package-private */
    public void p(ColorStateList prefixTextColor) {
        this.f2085a.setTextColor(prefixTextColor);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f2085a.getTextColors();
    }

    /* access modifiers changed from: package-private */
    public void o(int prefixTextAppearance) {
        TextViewCompat.setTextAppearance(this.f2085a, prefixTextAppearance);
    }

    /* access modifiers changed from: package-private */
    public void s(Drawable startIconDrawable) {
        this.f2086a.setImageDrawable(startIconDrawable);
        if (startIconDrawable != null) {
            t.a(this.f2087a, this.f2086a, this.f2081a, this.f2082a);
            z(true);
            m();
            return;
        }
        z(false);
        u((View.OnClickListener) null);
        v((View.OnLongClickListener) null);
        r((CharSequence) null);
    }

    /* access modifiers changed from: package-private */
    public Drawable f() {
        return this.f2086a.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public void u(View.OnClickListener startIconOnClickListener) {
        t.h(this.f2086a, startIconOnClickListener, this.f2083a);
    }

    /* access modifiers changed from: package-private */
    public void v(View.OnLongClickListener startIconOnLongClickListener) {
        this.f2083a = startIconOnLongClickListener;
        t.i(this.f2086a, startIconOnLongClickListener);
    }

    /* access modifiers changed from: package-private */
    public void z(boolean visible) {
        if (k() != visible) {
            this.f2086a.setVisibility(visible ? 0 : 8);
            B();
            C();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f2086a.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        t.d(this.f2087a, this.f2086a, this.f2081a);
    }

    /* access modifiers changed from: package-private */
    public void q(boolean startIconCheckable) {
        this.f2086a.setCheckable(startIconCheckable);
    }

    /* access modifiers changed from: package-private */
    public void r(CharSequence startIconContentDescription) {
        if (e() != startIconContentDescription) {
            this.f2086a.setContentDescription(startIconContentDescription);
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence e() {
        return this.f2086a.getContentDescription();
    }

    /* access modifiers changed from: package-private */
    public void x(ColorStateList startIconTintList) {
        if (this.f2081a != startIconTintList) {
            this.f2081a = startIconTintList;
            t.a(this.f2087a, this.f2086a, startIconTintList, this.f2082a);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(PorterDuff.Mode startIconTintMode) {
        if (this.f2082a != startIconTintMode) {
            this.f2082a = startIconTintMode;
            t.a(this.f2087a, this.f2086a, this.f2081a, startIconTintMode);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(int iconSize) {
        if (iconSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (iconSize != this.a) {
            this.a = iconSize;
            t.g(this.f2086a, iconSize);
        }
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public void w(ImageView.ScaleType startIconScaleType) {
        this.f2084a = startIconScaleType;
        t.j(this.f2086a, startIconScaleType);
    }

    /* access modifiers changed from: package-private */
    public ImageView.ScaleType h() {
        return this.f2084a;
    }

    /* access modifiers changed from: package-private */
    public void A(AccessibilityNodeInfoCompat info) {
        if (this.f2085a.getVisibility() == 0) {
            info.setLabelFor(this.f2085a);
            info.setTraversalAfter(this.f2085a);
            return;
        }
        info.setTraversalAfter(this.f2086a);
    }

    /* access modifiers changed from: package-private */
    public void B() {
        EditText editText = this.f2087a.f1962a;
        if (editText != null) {
            ViewCompat.setPaddingRelative(this.f2085a, k() ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(cc0.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public int c() {
        int startIconOffset;
        if (k()) {
            startIconOffset = this.f2086a.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.f2086a.getLayoutParams());
        } else {
            startIconOffset = 0;
        }
        return ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingStart(this.f2085a) + startIconOffset;
    }

    /* access modifiers changed from: package-private */
    public void l(boolean hintExpanded) {
        this.f2089a = hintExpanded;
        C();
    }

    private void C() {
        int i = 8;
        int prefixTextVisibility = (this.f2088a == null || this.f2089a) ? 8 : 0;
        if (this.f2086a.getVisibility() == 0 || prefixTextVisibility == 0) {
            i = 0;
        }
        setVisibility(i);
        this.f2085a.setVisibility(prefixTextVisibility);
        this.f2087a.o0();
    }
}
