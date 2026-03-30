package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.chip.a;
import java.util.List;

public class Chip extends AppCompatCheckBox implements a.C0012a, ll0 {
    private static final int[] a = {16842913};
    /* access modifiers changed from: private */
    public static final Rect b = new Rect();

    /* renamed from: b  reason: collision with other field name */
    private static final int[] f1606b = {16842911};
    private static final int c = uc0.Widget_MaterialComponents_Chip_Action;

    /* renamed from: a  reason: collision with other field name */
    private int f1607a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1608a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f1609a;

    /* renamed from: a  reason: collision with other field name */
    private InsetDrawable f1610a;

    /* renamed from: a  reason: collision with other field name */
    private RippleDrawable f1611a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public View.OnClickListener f1612a;

    /* renamed from: a  reason: collision with other field name */
    private CompoundButton.OnCheckedChangeListener f1613a;

    /* renamed from: a  reason: collision with other field name */
    private final c f1614a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public a f1615a;

    /* renamed from: a  reason: collision with other field name */
    private j00<Chip> f1616a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f1617a;

    /* renamed from: a  reason: collision with other field name */
    private final qq0 f1618a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1619a;

    /* renamed from: b  reason: collision with other field name */
    private int f1620b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1621b;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1622c;
    /* access modifiers changed from: private */
    public boolean d;
    private boolean e;
    private boolean f;

    class a extends qq0 {
        a() {
        }

        public void b(Typeface typeface, boolean fontResolvedSynchronously) {
            Chip chip = Chip.this;
            chip.setText(chip.f1615a.K2() ? Chip.this.f1615a.f1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }

        public void a(int reason) {
        }
    }

    public Chip(Context context, AttributeSet attrs) {
        this(context, attrs, yb0.chipStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = c
            android.content.Context r0 = defpackage.t00.c(r8, r9, r10, r4)
            r7.<init>(r0, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.f1608a = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r7.f1609a = r0
            com.google.android.material.chip.Chip$a r0 = new com.google.android.material.chip.Chip$a
            r0.<init>()
            r7.f1618a = r0
            android.content.Context r8 = r7.getContext()
            r7.D(r9)
            com.google.android.material.chip.a r6 = com.google.android.material.chip.a.t0(r8, r9, r10, r4)
            r7.o(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = androidx.core.view.ViewCompat.getElevation(r7)
            r6.U(r0)
            int[] r2 = defpackage.xc0.f5601D
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 >= r2) goto L_0x0052
            int r1 = defpackage.xc0.n0
            android.content.res.ColorStateList r1 = defpackage.o00.a(r8, r0, r1)
            r7.setTextColor(r1)
        L_0x0052:
            int r1 = defpackage.xc0.W0
            boolean r1 = r0.hasValue(r1)
            r0.recycle()
            com.google.android.material.chip.Chip$c r2 = new com.google.android.material.chip.Chip$c
            r2.<init>(r7)
            r7.f1614a = r2
            r7.y()
            if (r1 != 0) goto L_0x006a
            r7.p()
        L_0x006a:
            boolean r2 = r7.f1619a
            r7.setChecked(r2)
            java.lang.CharSequence r2 = r6.f1()
            r7.setText(r2)
            android.text.TextUtils$TruncateAt r2 = r6.Z0()
            r7.setEllipsize(r2)
            r7.C()
            com.google.android.material.chip.a r2 = r7.f1615a
            boolean r2 = r2.K2()
            if (r2 != 0) goto L_0x008f
            r2 = 1
            r7.setLines(r2)
            r7.setHorizontallyScrolling(r2)
        L_0x008f:
            r2 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r2)
            r7.B()
            boolean r2 = r7.w()
            if (r2 == 0) goto L_0x00a3
            int r2 = r7.f1620b
            r7.setMinHeight(r2)
        L_0x00a3:
            int r2 = androidx.core.view.ViewCompat.getLayoutDirection(r7)
            r7.f1607a = r2
            p8 r2 = new p8
            r2.<init>(r7)
            super.setOnCheckedChangeListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(CompoundButton buttonView, boolean isChecked) {
        j00<Chip> j00 = this.f1616a;
        if (j00 != null) {
            j00.a(this, isChecked);
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f1613a;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(buttonView, isChecked);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        q00.f(this, this.f1615a);
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.U(elevation);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(getAccessibilityClassName());
        info.setCheckable(r());
        info.setClickable(isClickable());
        getParent();
    }

    private void y() {
        if (!n() || !s() || this.f1612a == null) {
            ViewCompat.setAccessibilityDelegate(this, (AccessibilityDelegateCompat) null);
            this.f = false;
            return;
        }
        ViewCompat.setAccessibilityDelegate(this, this.f1614a);
        this.f = true;
    }

    private void o(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray a2 = vq0.i(context, attrs, xc0.f5601D, defStyleAttr, c, new int[0]);
        this.e = a2.getBoolean(xc0.R0, false);
        this.f1620b = (int) Math.ceil((double) a2.getDimension(xc0.F0, (float) Math.ceil((double) lv0.c(getContext(), 48))));
        a2.recycle();
    }

    private void B() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f1615a) != null) {
            int paddingEnd = (int) (aVar.H0() + this.f1615a.h1() + this.f1615a.o0());
            int paddingStart = (int) (this.f1615a.M0() + this.f1615a.i1() + this.f1615a.k0());
            if (this.f1610a != null) {
                Rect padding = new Rect();
                this.f1610a.getPadding(padding);
                paddingStart += padding.left;
                paddingEnd += padding.right;
            }
            ViewCompat.setPaddingRelative(this, paddingStart, getPaddingTop(), paddingEnd, getPaddingBottom());
        }
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        if (this.f1607a != layoutDirection) {
            this.f1607a = layoutDirection;
            B();
        }
    }

    private void D(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    private void p() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        public void getOutline(View view, Outline outline) {
            if (Chip.this.f1615a != null) {
                Chip.this.f1615a.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public Drawable getChipDrawable() {
        return this.f1615a;
    }

    public void setChipDrawable(@NonNull a drawable) {
        a aVar = this.f1615a;
        if (aVar != drawable) {
            x(aVar);
            this.f1615a = drawable;
            drawable.y2(false);
            j(this.f1615a);
            l(this.f1620b);
        }
    }

    private void z() {
        if (ye0.f5882a) {
            A();
            return;
        }
        this.f1615a.J2(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        B();
        m();
    }

    private void m() {
        if (getBackgroundDrawable() == this.f1610a && this.f1615a.getCallback() == null) {
            this.f1615a.setCallback(this.f1610a);
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f1610a;
        if (insetDrawable == null) {
            return this.f1615a;
        }
        return insetDrawable;
    }

    private void A() {
        this.f1611a = new RippleDrawable(ye0.e(this.f1615a.d1()), getBackgroundDrawable(), (Drawable) null);
        this.f1615a.J2(false);
        ViewCompat.setBackground(this, this.f1611a);
        B();
    }

    private void x(a chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.n2((a.C0012a) null);
        }
    }

    private void j(a chipDrawable) {
        chipDrawable.n2(this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] state = super.onCreateDrawableState(extraSpace + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(state, a);
        }
        if (r()) {
            CheckBox.mergeDrawableStates(state, f1606b);
        }
        return state;
    }

    public void setGravity(int gravity) {
        if (gravity != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(gravity);
        }
    }

    public void setBackgroundTintList(@Nullable ColorStateList tint) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setBackgroundColor(int color) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundResource(int resid) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackground(Drawable background) {
        if (background == getBackgroundDrawable() || background == this.f1611a) {
            super.setBackground(background);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundDrawable(Drawable background) {
        if (background == getBackgroundDrawable() || background == this.f1611a) {
            super.setBackgroundDrawable(background);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (right == null) {
            super.setCompoundDrawables(left, top, right, bottom);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int left, int top, int right, int bottom) {
        if (left != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (right == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (left != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (right == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        if (start != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (end == null) {
            super.setCompoundDrawablesRelative(start, top, end, bottom);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int start, int top, int end, int bottom) {
        if (start != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (end == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        if (start != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (end == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.Z0();
        }
        return null;
    }

    public void setEllipsize(TextUtils.TruncateAt where) {
        if (this.f1615a != null) {
            if (where != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(where);
                a aVar = this.f1615a;
                if (aVar != null) {
                    aVar.o2(where);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setSingleLine(boolean singleLine) {
        if (singleLine) {
            super.setSingleLine(singleLine);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setLines(int lines) {
        if (lines <= 1) {
            super.setLines(lines);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMinLines(int minLines) {
        if (minLines <= 1) {
            super.setMinLines(minLines);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int maxLines) {
        if (maxLines <= 1) {
            super.setMaxLines(maxLines);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(@Px int maxWidth) {
        super.setMaxWidth(maxWidth);
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.v2(maxWidth);
        }
    }

    public void a() {
        l(this.f1620b);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setChecked(boolean checked) {
        a aVar = this.f1615a;
        if (aVar == null) {
            this.f1619a = checked;
        } else if (aVar.m1()) {
            super.setChecked(checked);
        }
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener listener) {
        this.f1613a = listener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener listener) {
        this.f1612a = listener;
        y();
    }

    public boolean u() {
        boolean result;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f1612a;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            result = true;
        } else {
            result = false;
        }
        if (this.f) {
            this.f1614a.sendEventForVirtualView(1, 1);
        }
        return result;
    }

    public boolean onTouchEvent(MotionEvent event) {
        boolean handled = false;
        int action = event.getActionMasked();
        boolean eventInCloseIcon = getCloseIconTouchBounds().contains(event.getX(), event.getY());
        switch (action) {
            case 0:
                if (eventInCloseIcon) {
                    setCloseIconPressed(true);
                    handled = true;
                    break;
                }
                break;
            case 1:
                if (this.f1621b) {
                    u();
                    handled = true;
                    break;
                }
                break;
            case 2:
                if (this.f1621b) {
                    if (!eventInCloseIcon) {
                        setCloseIconPressed(false);
                    }
                    handled = true;
                    break;
                }
                break;
            case 3:
                break;
        }
        setCloseIconPressed(false);
        if (handled || super.onTouchEvent(event)) {
            return true;
        }
        return false;
    }

    public boolean onHoverEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case 7:
                setCloseIconHovered(getCloseIconTouchBounds().contains(event.getX(), event.getY()));
                break;
            case 10:
                setCloseIconHovered(false);
                break;
        }
        return super.onHoverEvent(event);
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (!this.f) {
            return super.dispatchHoverEvent(event);
        }
        return this.f1614a.dispatchHoverEvent(event) || super.dispatchHoverEvent(event);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (!this.f) {
            return super.dispatchKeyEvent(event);
        }
        if (!this.f1614a.dispatchKeyEvent(event) || this.f1614a.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(event);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (this.f) {
            this.f1614a.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }

    public void getFocusedRect(Rect r) {
        if (!this.f || !(this.f1614a.getKeyboardFocusedVirtualViewId() == 1 || this.f1614a.getAccessibilityFocusedVirtualViewId() == 1)) {
            super.getFocusedRect(r);
        } else {
            r.set(getCloseIconTouchBoundsInt());
        }
    }

    private void setCloseIconPressed(boolean pressed) {
        if (this.f1621b != pressed) {
            this.f1621b = pressed;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean hovered) {
        if (this.f1622c != hovered) {
            this.f1622c = hovered;
            refreshDrawableState();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        boolean changed = false;
        a aVar = this.f1615a;
        if (aVar != null && aVar.n1()) {
            changed = this.f1615a.j2(k());
        }
        if (changed) {
            invalidate();
        }
    }

    private int[] k() {
        int count = 0;
        if (isEnabled()) {
            count = 0 + 1;
        }
        if (this.d) {
            count++;
        }
        if (this.f1622c) {
            count++;
        }
        if (this.f1621b) {
            count++;
        }
        if (isChecked()) {
            count++;
        }
        int[] stateSet = new int[count];
        int i = 0;
        if (isEnabled()) {
            stateSet[0] = 16842910;
            i = 0 + 1;
        }
        if (this.d) {
            stateSet[i] = 16842908;
            i++;
        }
        if (this.f1622c) {
            stateSet[i] = 16843623;
            i++;
        }
        if (this.f1621b) {
            stateSet[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            stateSet[i] = 16842913;
            int i2 = i + 1;
        }
        return stateSet;
    }

    /* access modifiers changed from: private */
    public boolean n() {
        a aVar = this.f1615a;
        return (aVar == null || aVar.P0() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.f1609a.setEmpty();
        if (n() && this.f1612a != null) {
            this.f1615a.W0(this.f1609a);
        }
        return this.f1609a;
    }

    /* access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF bounds = getCloseIconTouchBounds();
        this.f1608a.set((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom);
        return this.f1608a;
    }

    public PointerIcon onResolvePointerIcon(MotionEvent event, int pointerIndex) {
        if (!getCloseIconTouchBounds().contains(event.getX(), event.getY()) || !isEnabled()) {
            return super.onResolvePointerIcon(event, pointerIndex);
        }
        return PointerIcon.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInternalOnCheckedChangeListener(@Nullable j00<Chip> listener) {
        this.f1616a = listener;
    }

    private class c extends ExploreByTouchHelper {
        c(Chip view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float x, float y) {
            if (!Chip.this.n() || !Chip.this.getCloseIconTouchBounds().contains(x, y)) {
                return 0;
            }
            return 1;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            virtualViewIds.add(0);
            if (Chip.this.n() && Chip.this.s() && Chip.this.f1612a != null) {
                virtualViewIds.add(1);
            }
        }

        /* access modifiers changed from: protected */
        public void onVirtualViewKeyboardFocusChanged(int virtualViewId, boolean hasFocus) {
            if (virtualViewId == 1) {
                boolean unused = Chip.this.d = hasFocus;
                Chip.this.refreshDrawableState();
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            CharSequence charSequence = "";
            if (virtualViewId == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    node.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence chipText = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i = sc0.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(chipText)) {
                        charSequence = chipText;
                    }
                    objArr[0] = charSequence;
                    node.setContentDescription(context.getString(i, objArr).trim());
                }
                node.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                node.setEnabled(Chip.this.isEnabled());
                return;
            }
            node.setContentDescription(charSequence);
            node.setBoundsInParent(Chip.b);
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat node) {
            node.setCheckable(Chip.this.r());
            node.setClickable(Chip.this.isClickable());
            node.setClassName(Chip.this.getAccessibilityClassName());
            CharSequence chipText = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                node.setText(chipText);
            } else {
                node.setContentDescription(chipText);
            }
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            if (action != 16) {
                return false;
            }
            if (virtualViewId == 0) {
                return Chip.this.performClick();
            }
            if (virtualViewId == 1) {
                return Chip.this.u();
            }
            return false;
        }
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.F0();
        }
        return null;
    }

    public void setChipBackgroundColorResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.E1(id);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList chipBackgroundColor) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.D1(chipBackgroundColor);
        }
    }

    public float getChipMinHeight() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.L0();
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.S1(id);
        }
    }

    public void setChipMinHeight(float minHeight) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.R1(minHeight);
        }
    }

    public float getChipCornerRadius() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return Math.max(0.0f, aVar.G0());
        }
        return 0.0f;
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.G1(id);
        }
    }

    public void setShapeAppearanceModel(@NonNull il0 shapeAppearanceModel) {
        this.f1615a.setShapeAppearanceModel(shapeAppearanceModel);
    }

    @NonNull
    public il0 getShapeAppearanceModel() {
        return this.f1615a.B();
    }

    @Deprecated
    public void setChipCornerRadius(float chipCornerRadius) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.F1(chipCornerRadius);
        }
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public void setChipStrokeColorResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.W1(id);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList chipStrokeColor) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.V1(chipStrokeColor);
        }
    }

    public float getChipStrokeWidth() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.Y1(id);
        }
    }

    public void setChipStrokeWidth(float chipStrokeWidth) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.X1(chipStrokeWidth);
        }
    }

    @Nullable
    public ColorStateList getRippleColor() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.d1();
        }
        return null;
    }

    public void setRippleColorResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.x2(id);
            if (!this.f1615a.k1()) {
                A();
            }
        }
    }

    public void setRippleColor(@Nullable ColorStateList rippleColor) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.w2(rippleColor);
        }
        if (!this.f1615a.k1()) {
            A();
        }
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public void setLayoutDirection(int layoutDirection) {
        if (this.f1615a != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(layoutDirection);
        }
    }

    public void setText(CharSequence text, TextView.BufferType type) {
        a aVar = this.f1615a;
        if (aVar != null) {
            if (text == null) {
                text = "";
            }
            super.setText(aVar.K2() ? null : text, type);
            a aVar2 = this.f1615a;
            if (aVar2 != null) {
                aVar2.B2(text);
            }
        }
    }

    @Deprecated
    public void setChipTextResource(@StringRes int id) {
        setText(getResources().getString(id));
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence chipText) {
        setText(chipText);
    }

    public void setTextAppearanceResource(@StyleRes int id) {
        setTextAppearance(getContext(), id);
    }

    public void setTextAppearance(@Nullable oq0 textAppearance) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.C2(textAppearance);
        }
        C();
    }

    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.D2(resId);
        }
        C();
    }

    public void setTextAppearance(int resId) {
        super.setTextAppearance(resId);
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.D2(resId);
        }
        C();
    }

    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.G2(TypedValue.applyDimension(unit, size, getResources().getDisplayMetrics()));
        }
        C();
    }

    private void C() {
        TextPaint textPaint = getPaint();
        a aVar = this.f1615a;
        if (aVar != null) {
            textPaint.drawableState = aVar.getState();
        }
        oq0 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), textPaint, this.f1618a);
        }
    }

    @Nullable
    private oq0 getTextAppearance() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.g1();
        }
        return null;
    }

    public void setChipIconVisible(@BoolRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.P1(id);
        }
    }

    public void setChipIconVisible(boolean chipIconVisible) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.Q1(chipIconVisible);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int id) {
        setChipIconVisible(id);
    }

    @Deprecated
    public void setChipIconEnabled(boolean chipIconEnabled) {
        setChipIconVisible(chipIconEnabled);
    }

    @Nullable
    public Drawable getChipIcon() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.I0();
        }
        return null;
    }

    public void setChipIconResource(@DrawableRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.K1(id);
        }
    }

    public void setChipIcon(@Nullable Drawable chipIcon) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.J1(chipIcon);
        }
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public void setChipIconTintResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.O1(id);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList chipIconTint) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.N1(chipIconTint);
        }
    }

    public float getChipIconSize() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.M1(id);
        }
    }

    public void setChipIconSize(float chipIconSize) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.L1(chipIconSize);
        }
    }

    public boolean s() {
        a aVar = this.f1615a;
        return aVar != null && aVar.o1();
    }

    public void setCloseIconVisible(@BoolRes int id) {
        setCloseIconVisible(getResources().getBoolean(id));
    }

    public void setCloseIconVisible(boolean closeIconVisible) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.m2(closeIconVisible);
        }
        y();
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int id) {
        setCloseIconVisible(id);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean closeIconEnabled) {
        setCloseIconVisible(closeIconEnabled);
    }

    @Nullable
    public Drawable getCloseIcon() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.P0();
        }
        return null;
    }

    public void setCloseIconResource(@DrawableRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.e2(id);
        }
        y();
    }

    public void setCloseIcon(@Nullable Drawable closeIcon) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.a2(closeIcon);
        }
        y();
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    public void setCloseIconTintResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.l2(id);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList closeIconTint) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.k2(closeIconTint);
        }
    }

    public float getCloseIconSize() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.S0();
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.g2(id);
        }
    }

    public void setCloseIconSize(float closeIconSize) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.f2(closeIconSize);
        }
    }

    public void setCloseIconContentDescription(@Nullable CharSequence closeIconContentDescription) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.b2(closeIconContentDescription);
        }
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.Q0();
        }
        return null;
    }

    public boolean r() {
        a aVar = this.f1615a;
        return aVar != null && aVar.m1();
    }

    public void setCheckableResource(@BoolRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.w1(id);
        }
    }

    public void setCheckable(boolean checkable) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.v1(checkable);
        }
    }

    public void setCheckedIconVisible(@BoolRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.B1(id);
        }
    }

    public void setCheckedIconVisible(boolean checkedIconVisible) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.C1(checkedIconVisible);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int id) {
        setCheckedIconVisible(id);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean checkedIconEnabled) {
        setCheckedIconVisible(checkedIconEnabled);
    }

    @Nullable
    public Drawable getCheckedIcon() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.D0();
        }
        return null;
    }

    public void setCheckedIconResource(@DrawableRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.y1(id);
        }
    }

    public void setCheckedIcon(@Nullable Drawable checkedIcon) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.x1(checkedIcon);
        }
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.E0();
        }
        return null;
    }

    public void setCheckedIconTintResource(@ColorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.A1(id);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList checkedIconTint) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.z1(checkedIconTint);
        }
    }

    @Nullable
    public g20 getShowMotionSpec() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    public void setShowMotionSpecResource(@AnimatorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.A2(id);
        }
    }

    public void setShowMotionSpec(@Nullable g20 showMotionSpec) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.z2(showMotionSpec);
        }
    }

    @Nullable
    public g20 getHideMotionSpec() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    public void setHideMotionSpecResource(@AnimatorRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.q2(id);
        }
    }

    public void setHideMotionSpec(@Nullable g20 hideMotionSpec) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.p2(hideMotionSpec);
        }
    }

    public float getChipStartPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.U1(id);
        }
    }

    public void setChipStartPadding(float chipStartPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.T1(chipStartPadding);
        }
    }

    public float getIconStartPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.c1();
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.u2(id);
        }
    }

    public void setIconStartPadding(float iconStartPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.t2(iconStartPadding);
        }
    }

    public float getIconEndPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.b1();
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.s2(id);
        }
    }

    public void setIconEndPadding(float iconEndPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.r2(iconEndPadding);
        }
    }

    public float getTextStartPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.i1();
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.I2(id);
        }
    }

    public void setTextStartPadding(float textStartPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.H2(textStartPadding);
        }
    }

    public float getTextEndPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.F2(id);
        }
    }

    public void setTextEndPadding(float textEndPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.E2(textEndPadding);
        }
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.T0();
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.i2(id);
        }
    }

    public void setCloseIconStartPadding(float closeIconStartPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.h2(closeIconStartPadding);
        }
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.d2(id);
        }
    }

    public void setCloseIconEndPadding(float closeIconEndPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.c2(closeIconEndPadding);
        }
    }

    public float getChipEndPadding() {
        a aVar = this.f1615a;
        if (aVar != null) {
            return aVar.H0();
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(@DimenRes int id) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.I1(id);
        }
    }

    public void setChipEndPadding(float chipEndPadding) {
        a aVar = this.f1615a;
        if (aVar != null) {
            aVar.H1(chipEndPadding);
        }
    }

    public boolean w() {
        return this.e;
    }

    public void setEnsureMinTouchTargetSize(boolean flag) {
        this.e = flag;
        l(this.f1620b);
    }

    public boolean l(int minTargetPx) {
        this.f1620b = minTargetPx;
        int deltaY = 0;
        if (!w()) {
            if (this.f1610a != null) {
                v();
            } else {
                z();
            }
            return false;
        }
        int deltaHeight = Math.max(0, minTargetPx - this.f1615a.getIntrinsicHeight());
        int deltaWidth = Math.max(0, minTargetPx - this.f1615a.getIntrinsicWidth());
        if (deltaWidth > 0 || deltaHeight > 0) {
            int deltaX = deltaWidth > 0 ? deltaWidth / 2 : 0;
            if (deltaHeight > 0) {
                deltaY = deltaHeight / 2;
            }
            if (this.f1610a != null) {
                Rect padding = new Rect();
                this.f1610a.getPadding(padding);
                if (padding.top == deltaY && padding.bottom == deltaY && padding.left == deltaX && padding.right == deltaX) {
                    z();
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (getMinHeight() != minTargetPx) {
                    setMinHeight(minTargetPx);
                }
                if (getMinWidth() != minTargetPx) {
                    setMinWidth(minTargetPx);
                }
            } else {
                setMinHeight(minTargetPx);
                setMinWidth(minTargetPx);
            }
            q(deltaX, deltaY, deltaX, deltaY);
            z();
            return true;
        }
        if (this.f1610a != null) {
            v();
        } else {
            z();
        }
        return false;
    }

    public void setAccessibilityClassName(@Nullable CharSequence className) {
        this.f1617a = className;
    }

    @NonNull
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f1617a)) {
            return this.f1617a;
        }
        if (r()) {
            ViewParent parent = getParent();
            return "android.widget.Button";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return "android.view.View";
        }
    }

    private void v() {
        if (this.f1610a != null) {
            this.f1610a = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            z();
        }
    }

    private void q(int insetLeft, int insetTop, int insetRight, int insetBottom) {
        this.f1610a = new InsetDrawable(this.f1615a, insetLeft, insetTop, insetRight, insetBottom);
    }
}
