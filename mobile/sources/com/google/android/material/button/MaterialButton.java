package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, ll0 {
    private static final int[] a = {16842911};
    private static final int[] b = {16842912};
    private static final int f = uc0.Widget_MaterialComponents_Button;

    /* renamed from: a  reason: collision with other field name */
    private int f1542a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1543a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f1544a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1545a;

    /* renamed from: a  reason: collision with other field name */
    private b f1546a;

    /* renamed from: a  reason: collision with other field name */
    private final a f1547a;

    /* renamed from: a  reason: collision with other field name */
    private String f1548a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<a> f1549a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1550a;

    /* renamed from: b  reason: collision with other field name */
    private int f1551b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1552b;
    private int c;
    private int d;
    private int e;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = f
            android.content.Context r0 = defpackage.t00.c(r9, r10, r11, r6)
            r8.<init>(r0, r10, r11)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r8.f1549a = r0
            r7 = 0
            r8.f1550a = r7
            r8.f1552b = r7
            android.content.Context r9 = r8.getContext()
            int[] r2 = defpackage.xc0.f5724w0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = defpackage.vq0.i(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.t2
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r8.d = r1
            int r1 = defpackage.xc0.w2
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = defpackage.lv0.i(r1, r2)
            r8.f1544a = r1
            android.content.Context r1 = r8.getContext()
            int r2 = defpackage.xc0.v2
            android.content.res.ColorStateList r1 = defpackage.o00.a(r1, r0, r2)
            r8.f1543a = r1
            android.content.Context r1 = r8.getContext()
            int r2 = defpackage.xc0.r2
            android.graphics.drawable.Drawable r1 = defpackage.o00.d(r1, r0, r2)
            r8.f1545a = r1
            int r1 = defpackage.xc0.s2
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.e = r1
            int r1 = defpackage.xc0.u2
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r8.f1542a = r1
            il0$b r1 = defpackage.il0.e(r9, r10, r11, r6)
            il0 r1 = r1.m()
            com.google.android.material.button.a r3 = new com.google.android.material.button.a
            r3.<init>(r8, r1)
            r8.f1547a = r3
            r3.r(r0)
            r0.recycle()
            int r3 = r8.d
            r8.setCompoundDrawablePadding(r3)
            android.graphics.drawable.Drawable r3 = r8.f1545a
            if (r3 == 0) goto L_0x0086
            r7 = 1
        L_0x0086:
            r8.h(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f1548a)) {
            return this.f1548a;
        }
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    /* access modifiers changed from: package-private */
    public void setA11yClassName(@Nullable String className) {
        this.f1548a = className;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(getA11yClassName());
        info.setCheckable(a());
        info.setChecked(isChecked());
        info.setClickable(isClickable());
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public Parcelable onSaveInstanceState() {
        c savedState = new c(super.onSaveInstanceState());
        savedState.a = this.f1550a;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof c)) {
            super.onRestoreInstanceState(state);
            return;
        }
        c savedState = (c) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList tint) {
        if (f()) {
            this.f1547a.D(tint);
        } else {
            super.setSupportBackgroundTintList(tint);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (f()) {
            return this.f1547a.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        if (f()) {
            this.f1547a.E(tintMode);
        } else {
            super.setSupportBackgroundTintMode(tintMode);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (f()) {
            return this.f1547a.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void setBackgroundTintList(@Nullable ColorStateList tintList) {
        setSupportBackgroundTintList(tintList);
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode tintMode) {
        setSupportBackgroundTintMode(tintMode);
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public void setBackgroundColor(@ColorInt int color) {
        if (f()) {
            this.f1547a.s(color);
        } else {
            super.setBackgroundColor(color);
        }
    }

    public void setBackground(@NonNull Drawable background) {
        setBackgroundDrawable(background);
    }

    public void setBackgroundResource(@DrawableRes int backgroundResourceId) {
        Drawable background = null;
        if (backgroundResourceId != 0) {
            background = AppCompatResources.getDrawable(getContext(), backgroundResourceId);
        }
        setBackgroundDrawable(background);
    }

    public void setBackgroundDrawable(@NonNull Drawable background) {
        if (!f()) {
            super.setBackgroundDrawable(background);
        } else if (background != getBackground()) {
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f1547a.t();
            super.setBackgroundDrawable(background);
        } else {
            getBackground().setState(background.getState());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        a aVar;
        super.onLayout(changed, left, top, right, bottom);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f1547a) != null) {
            aVar.J(bottom - top, right - left);
        }
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        super.onTextChanged(charSequence, i, i1, i2);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            q00.f(this, this.f1547a.f());
        }
    }

    @RequiresApi(21)
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        if (f()) {
            this.f1547a.f().U(elevation);
        }
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f1545a != null) {
            if (this.f1545a.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @RequiresApi(17)
    public void setTextAlignment(int textAlignment) {
        super.setTextAlignment(textAlignment);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    private Layout.Alignment getGravityTextAlignment() {
        switch (getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
            case GravityCompat.END:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private Layout.Alignment getActualTextAlignment() {
        if (Build.VERSION.SDK_INT < 17) {
            return getGravityTextAlignment();
        }
        switch (getTextAlignment()) {
            case 1:
                return getGravityTextAlignment();
            case 3:
            case 6:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private void i(int buttonWidth, int buttonHeight) {
        if (this.f1545a != null && getLayout() != null) {
            if (c() || b()) {
                this.c = 0;
                Layout.Alignment textAlignment = getActualTextAlignment();
                int i = this.e;
                boolean z = true;
                if (i == 1 || i == 3 || ((i == 2 && textAlignment == Layout.Alignment.ALIGN_NORMAL) || (i == 4 && textAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
                    this.f1551b = 0;
                    h(false);
                    return;
                }
                int localIconSize = this.f1542a;
                if (localIconSize == 0) {
                    localIconSize = this.f1545a.getIntrinsicWidth();
                }
                int availableWidth = ((((buttonWidth - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - localIconSize) - this.d) - ViewCompat.getPaddingStart(this);
                int newIconLeft = textAlignment == Layout.Alignment.ALIGN_CENTER ? availableWidth / 2 : availableWidth;
                boolean e2 = e();
                if (this.e != 4) {
                    z = false;
                }
                if (e2 != z) {
                    newIconLeft = -newIconLeft;
                }
                if (this.f1551b != newIconLeft) {
                    this.f1551b = newIconLeft;
                    h(false);
                }
            } else if (d()) {
                this.f1551b = 0;
                if (this.e == 16) {
                    this.c = 0;
                    h(false);
                    return;
                }
                int localIconSize2 = this.f1542a;
                if (localIconSize2 == 0) {
                    localIconSize2 = this.f1545a.getIntrinsicHeight();
                }
                int newIconTop = Math.max(0, (((((buttonHeight - getTextHeight()) - getPaddingTop()) - localIconSize2) - this.d) - getPaddingBottom()) / 2);
                if (this.c != newIconTop) {
                    this.c = newIconTop;
                    h(false);
                }
            }
        }
    }

    private int getTextLayoutWidth() {
        float maxWidth = 0.0f;
        int lineCount = getLineCount();
        for (int line = 0; line < lineCount; line++) {
            maxWidth = Math.max(maxWidth, getLayout().getLineWidth(line));
        }
        return (int) Math.ceil((double) maxWidth);
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        Paint textPaint = getPaint();
        String buttonText = getText().toString();
        if (getTransformationMethod() != null) {
            buttonText = getTransformationMethod().getTransformation(buttonText, this).toString();
        }
        Rect bounds = new Rect();
        textPaint.getTextBounds(buttonText, 0, buttonText.length(), bounds);
        return Math.min(bounds.height(), getLayout().getHeight());
    }

    private boolean e() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable background) {
        super.setBackgroundDrawable(background);
    }

    public void setIconPadding(@Px int iconPadding) {
        if (this.d != iconPadding) {
            this.d = iconPadding;
            setCompoundDrawablePadding(iconPadding);
        }
    }

    @Px
    public int getIconPadding() {
        return this.d;
    }

    public void setIconSize(@Px int iconSize) {
        if (iconSize < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f1542a != iconSize) {
            this.f1542a = iconSize;
            h(true);
        }
    }

    @Px
    public int getIconSize() {
        return this.f1542a;
    }

    public void setIcon(@Nullable Drawable icon) {
        if (this.f1545a != icon) {
            this.f1545a = icon;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconResource(@DrawableRes int iconResourceId) {
        Drawable icon = null;
        if (iconResourceId != 0) {
            icon = AppCompatResources.getDrawable(getContext(), iconResourceId);
        }
        setIcon(icon);
    }

    public Drawable getIcon() {
        return this.f1545a;
    }

    public void setIconTint(@Nullable ColorStateList iconTint) {
        if (this.f1543a != iconTint) {
            this.f1543a = iconTint;
            h(false);
        }
    }

    public void setIconTintResource(@ColorRes int iconTintResourceId) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), iconTintResourceId));
    }

    public ColorStateList getIconTint() {
        return this.f1543a;
    }

    public void setIconTintMode(PorterDuff.Mode iconTintMode) {
        if (this.f1544a != iconTintMode) {
            this.f1544a = iconTintMode;
            h(false);
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f1544a;
    }

    private void h(boolean needsIconReset) {
        Drawable drawable = this.f1545a;
        boolean hasIconChanged = true;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f1545a = mutate;
            DrawableCompat.setTintList(mutate, this.f1543a);
            PorterDuff.Mode mode = this.f1544a;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f1545a, mode);
            }
            int width = this.f1542a;
            if (width == 0) {
                width = this.f1545a.getIntrinsicWidth();
            }
            int height = this.f1542a;
            if (height == 0) {
                height = this.f1545a.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f1545a;
            int i = this.f1551b;
            int i2 = this.c;
            drawable2.setBounds(i, i2, i + width, i2 + height);
            this.f1545a.setVisible(true, needsIconReset);
        }
        if (needsIconReset) {
            g();
            return;
        }
        Drawable[] existingDrawables = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawableStart = existingDrawables[0];
        Drawable drawableTop = existingDrawables[1];
        Drawable drawableEnd = existingDrawables[2];
        if ((!c() || drawableStart == this.f1545a) && ((!b() || drawableEnd == this.f1545a) && (!d() || drawableTop == this.f1545a))) {
            hasIconChanged = false;
        }
        if (hasIconChanged) {
            g();
        }
    }

    private void g() {
        if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f1545a, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, (Drawable) null, (Drawable) null, this.f1545a, (Drawable) null);
        } else if (d()) {
            TextViewCompat.setCompoundDrawablesRelative(this, (Drawable) null, this.f1545a, (Drawable) null, (Drawable) null);
        }
    }

    private boolean c() {
        int i = this.e;
        return i == 1 || i == 2;
    }

    private boolean b() {
        int i = this.e;
        return i == 3 || i == 4;
    }

    private boolean d() {
        int i = this.e;
        return i == 16 || i == 32;
    }

    public void setRippleColor(@Nullable ColorStateList rippleColor) {
        if (f()) {
            this.f1547a.y(rippleColor);
        }
    }

    public void setRippleColorResource(@ColorRes int rippleColorResourceId) {
        if (f()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), rippleColorResourceId));
        }
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f1547a.h();
        }
        return null;
    }

    public void setStrokeColor(@Nullable ColorStateList strokeColor) {
        if (f()) {
            this.f1547a.B(strokeColor);
        }
    }

    public void setStrokeColorResource(@ColorRes int strokeColorResourceId) {
        if (f()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), strokeColorResourceId));
        }
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f1547a.j();
        }
        return null;
    }

    public void setStrokeWidth(@Px int strokeWidth) {
        if (f()) {
            this.f1547a.C(strokeWidth);
        }
    }

    public void setStrokeWidthResource(@DimenRes int strokeWidthResourceId) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(strokeWidthResourceId));
        }
    }

    @Px
    public int getStrokeWidth() {
        if (f()) {
            return this.f1547a.k();
        }
        return 0;
    }

    public void setCornerRadius(@Px int cornerRadius) {
        if (f()) {
            this.f1547a.v(cornerRadius);
        }
    }

    public void setCornerRadiusResource(@DimenRes int cornerRadiusResourceId) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(cornerRadiusResourceId));
        }
    }

    @Px
    public int getCornerRadius() {
        if (f()) {
            return this.f1547a.b();
        }
        return 0;
    }

    public int getIconGravity() {
        return this.e;
    }

    public void setIconGravity(int iconGravity) {
        if (this.e != iconGravity) {
            this.e = iconGravity;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setInsetBottom(@Dimension int insetBottom) {
        this.f1547a.w(insetBottom);
    }

    @Dimension
    public int getInsetBottom() {
        return this.f1547a.c();
    }

    public void setInsetTop(@Dimension int insetTop) {
        this.f1547a.x(insetTop);
    }

    @Dimension
    public int getInsetTop() {
        return this.f1547a.d();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (a()) {
            Button.mergeDrawableStates(drawableState, a);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(drawableState, b);
        }
        return drawableState;
    }

    public void setChecked(boolean checked) {
        if (a() && isEnabled() && this.f1550a != checked) {
            this.f1550a = checked;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f1550a);
            }
            if (!this.f1552b) {
                this.f1552b = true;
                Iterator it = this.f1549a.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(this, this.f1550a);
                }
                this.f1552b = false;
            }
        }
    }

    public boolean isChecked() {
        return this.f1550a;
    }

    public void toggle() {
        setChecked(!this.f1550a);
    }

    public boolean performClick() {
        if (this.f1547a.q()) {
            toggle();
        }
        return super.performClick();
    }

    public void setToggleCheckedStateOnClick(boolean toggleCheckedStateOnClick) {
        this.f1547a.F(toggleCheckedStateOnClick);
    }

    public boolean a() {
        a aVar = this.f1547a;
        return aVar != null && aVar.p();
    }

    public void setCheckable(boolean checkable) {
        if (f()) {
            this.f1547a.u(checkable);
        }
    }

    public void setShapeAppearanceModel(@NonNull il0 shapeAppearanceModel) {
        if (f()) {
            this.f1547a.z(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    @NonNull
    public il0 getShapeAppearanceModel() {
        if (f()) {
            return this.f1547a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(@Nullable b listener) {
        this.f1546a = listener;
    }

    public void setPressed(boolean pressed) {
        b bVar = this.f1546a;
        if (bVar != null) {
            bVar.a(this, pressed);
        }
        super.setPressed(pressed);
    }

    private boolean f() {
        a aVar = this.f1547a;
        return aVar != null && !aVar.o();
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean shouldDrawSurfaceColorStroke) {
        if (f()) {
            this.f1547a.A(shouldDrawSurfaceColorStroke);
        }
    }

    static class c extends AbsSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();
        boolean a;

        public c(Parcelable superState) {
            super(superState);
        }

        public c(Parcel source, ClassLoader loader) {
            super(source, loader);
            if (loader == null) {
                ClassLoader loader2 = getClass().getClassLoader();
            }
            f(source);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.a ? 1 : 0);
        }

        private void f(Parcel in) {
            boolean z = true;
            if (in.readInt() != 1) {
                z = false;
            }
            this.a = z;
        }

        class a implements Parcelable.ClassLoaderCreator<c> {
            a() {
            }

            /* renamed from: b */
            public c createFromParcel(Parcel in, ClassLoader loader) {
                return new c(in, loader);
            }

            /* renamed from: a */
            public c createFromParcel(Parcel in) {
                return new c(in, (ClassLoader) null);
            }

            /* renamed from: c */
            public c[] newArray(int size) {
                return new c[size];
            }
        }
    }
}
