package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* renamed from: i00  reason: default package */
public class i00 extends AppCompatCheckBox {
    private static final int[][] a;
    private static final int b = uc0.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: b  reason: collision with other field name */
    private static final int[] f3184b = {yb0.state_indeterminate};
    private static final int c = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");

    /* renamed from: c  reason: collision with other field name */
    private static final int[] f3185c;

    /* renamed from: a  reason: collision with other field name */
    private int f3186a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f3187a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f3188a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f3189a;

    /* renamed from: a  reason: collision with other field name */
    private CompoundButton.OnCheckedChangeListener f3190a;

    /* renamed from: a  reason: collision with other field name */
    private final Animatable2Compat.AnimationCallback f3191a;

    /* renamed from: a  reason: collision with other field name */
    private final AnimatedVectorDrawableCompat f3192a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f3193a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<c> f3194a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3195a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public int[] f3196a;

    /* renamed from: b  reason: collision with other field name */
    ColorStateList f3197b;

    /* renamed from: b  reason: collision with other field name */
    private Drawable f3198b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f3199b;

    /* renamed from: b  reason: collision with other field name */
    private final LinkedHashSet<b> f3200b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3201b;

    /* renamed from: c  reason: collision with other field name */
    ColorStateList f3202c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3203c;
    private boolean d;
    private boolean e;

    /* renamed from: i00$b */
    public interface b {
        void a(i00 i00, int i);
    }

    /* renamed from: i00$c */
    public interface c {
        void a(i00 i00, boolean z);
    }

    static {
        int i = yb0.state_error;
        f3185c = new int[]{i};
        a = new int[][]{new int[]{16842910, i}, new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    }

    /* renamed from: i00$a */
    class a extends Animatable2Compat.AnimationCallback {
        a() {
        }

        public void onAnimationStart(Drawable drawable) {
            super.onAnimationStart(drawable);
            i00 i00 = i00.this;
            ColorStateList colorStateList = i00.f3197b;
            if (colorStateList != null) {
                DrawableCompat.setTint(drawable, colorStateList.getColorForState(i00.f3196a, i00.this.f3197b.getDefaultColor()));
            }
        }

        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            ColorStateList colorStateList = i00.this.f3197b;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
    }

    public i00(Context context, AttributeSet attrs) {
        this(context, attrs, yb0.e);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i00(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = b
            android.content.Context r0 = defpackage.t00.c(r9, r10, r11, r4)
            r8.<init>(r0, r10, r11)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r8.f3194a = r0
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            r8.f3200b = r0
            android.content.Context r0 = r8.getContext()
            int r1 = defpackage.gc0.mtrl_checkbox_button_checked_unchecked
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(r0, r1)
            r8.f3192a = r0
            i00$a r0 = new i00$a
            r0.<init>()
            r8.f3191a = r0
            android.content.Context r9 = r8.getContext()
            android.graphics.drawable.Drawable r0 = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(r8)
            r8.f3189a = r0
            android.content.res.ColorStateList r0 = r8.getSuperButtonTintList()
            r8.f3197b = r0
            r6 = 0
            r8.setSupportButtonTintList(r6)
            int[] r2 = defpackage.xc0.f5596B0
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r10
            r3 = r11
            androidx.appcompat.widget.TintTypedArray r0 = defpackage.vq0.j(r0, r1, r2, r3, r4, r5)
            int r1 = defpackage.xc0.a3
            android.graphics.drawable.Drawable r1 = r0.getDrawable(r1)
            r8.f3198b = r1
            android.graphics.drawable.Drawable r1 = r8.f3189a
            r2 = 1
            if (r1 == 0) goto L_0x007d
            boolean r1 = defpackage.vq0.g(r9)
            if (r1 == 0) goto L_0x007d
            boolean r1 = r8.d(r0)
            if (r1 == 0) goto L_0x007d
            super.setButtonDrawable((android.graphics.drawable.Drawable) r6)
            int r1 = defpackage.gc0.mtrl_checkbox_button
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r9, r1)
            r8.f3189a = r1
            r8.d = r2
            android.graphics.drawable.Drawable r1 = r8.f3198b
            if (r1 != 0) goto L_0x007d
            int r1 = defpackage.gc0.mtrl_checkbox_button_icon
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r9, r1)
            r8.f3198b = r1
        L_0x007d:
            int r1 = defpackage.xc0.b3
            android.content.res.ColorStateList r1 = defpackage.o00.b(r9, r0, r1)
            r8.f3202c = r1
            int r1 = defpackage.xc0.c3
            r3 = -1
            int r1 = r0.getInt(r1, r3)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = defpackage.lv0.i(r1, r3)
            r8.f3188a = r1
            int r1 = defpackage.xc0.h3
            boolean r1 = r0.getBoolean(r1, r7)
            r8.f3195a = r1
            int r1 = defpackage.xc0.d3
            boolean r1 = r0.getBoolean(r1, r2)
            r8.f3201b = r1
            int r1 = defpackage.xc0.g3
            boolean r1 = r0.getBoolean(r1, r7)
            r8.f3203c = r1
            int r1 = defpackage.xc0.f3
            java.lang.CharSequence r1 = r0.getText(r1)
            r8.f3193a = r1
            int r1 = defpackage.xc0.e3
            boolean r2 = r0.hasValue(r1)
            if (r2 == 0) goto L_0x00c4
            int r1 = r0.getInt(r1, r7)
            r8.setCheckedState(r1)
        L_0x00c4:
            r0.recycle()
            r8.g()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 >= r2) goto L_0x00dc
            android.graphics.drawable.Drawable r1 = r8.f3198b
            if (r1 == 0) goto L_0x00dc
            h00 r1 = new h00
            r1.<init>(r8)
            r8.post(r1)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i00.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        this.f3198b.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        if (!this.f3201b || !TextUtils.isEmpty(getText()) || (drawable = CompoundButtonCompat.getButtonDrawable(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int dx = ((getWidth() - drawable.getIntrinsicWidth()) / 2) * (lv0.g(this) ? -1 : 1);
        int saveCount = canvas.save();
        canvas.translate((float) dx, 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(saveCount);
        if (getBackground() != null) {
            Rect bounds = drawable.getBounds();
            DrawableCompat.setHotspotBounds(getBackground(), bounds.left + dx, bounds.top, bounds.right + dx, bounds.bottom);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3195a && this.f3197b == null && this.f3202c == null) {
            setUseMaterialThemeColors(true);
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableStates = super.onCreateDrawableState(extraSpace + 2);
        if (getCheckedState() == 2) {
            CheckBox.mergeDrawableStates(drawableStates, f3184b);
        }
        if (e()) {
            CheckBox.mergeDrawableStates(drawableStates, f3185c);
        }
        this.f3196a = yh.e(drawableStates);
        k();
        return drawableStates;
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        k();
    }

    public void setChecked(boolean checked) {
        setCheckedState(checked);
    }

    public boolean isChecked() {
        return this.f3186a == 1;
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener listener) {
        this.f3190a = listener;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null && e()) {
            info.setText(info.getText() + ", " + this.f3193a);
        }
    }

    public void setCheckedState(int checkedState) {
        AutofillManager autofillManager;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f3186a != checkedState) {
            this.f3186a = checkedState;
            super.setChecked(checkedState == 1);
            refreshDrawableState();
            h();
            if (!this.e) {
                this.e = true;
                LinkedHashSet<b> linkedHashSet = this.f3200b;
                if (linkedHashSet != null) {
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).a(this, this.f3186a);
                    }
                }
                if (!(this.f3186a == 2 || (onCheckedChangeListener = this.f3190a) == null)) {
                    onCheckedChangeListener.onCheckedChanged(this, isChecked());
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 26 && (autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class)) != null) {
                    autofillManager.notifyValueChanged(this);
                }
                this.e = false;
                if (i < 21 && this.f3198b != null) {
                    refreshDrawableState();
                }
            }
        }
    }

    public int getCheckedState() {
        return this.f3186a;
    }

    public void setErrorShown(boolean errorShown) {
        Drawable drawable;
        if (this.f3203c != errorShown) {
            this.f3203c = errorShown;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT < 21 && (drawable = this.f3198b) != null) {
                drawable.jumpToCurrentState();
            }
            Iterator it = this.f3194a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(this, this.f3203c);
            }
        }
    }

    public boolean e() {
        return this.f3203c;
    }

    public void setErrorAccessibilityLabelResource(@StringRes int resId) {
        setErrorAccessibilityLabel(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setErrorAccessibilityLabel(@Nullable CharSequence errorAccessibilityLabel) {
        this.f3193a = errorAccessibilityLabel;
    }

    @Nullable
    public CharSequence getErrorAccessibilityLabel() {
        return this.f3193a;
    }

    public void setButtonDrawable(@DrawableRes int resId) {
        setButtonDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setButtonDrawable(@Nullable Drawable drawable) {
        this.f3189a = drawable;
        this.d = false;
        g();
    }

    @Nullable
    public Drawable getButtonDrawable() {
        return this.f3189a;
    }

    public void setButtonTintList(@Nullable ColorStateList tintList) {
        if (this.f3197b != tintList) {
            this.f3197b = tintList;
            g();
        }
    }

    @Nullable
    public ColorStateList getButtonTintList() {
        return this.f3197b;
    }

    public void setButtonTintMode(@Nullable PorterDuff.Mode tintMode) {
        setSupportButtonTintMode(tintMode);
        g();
    }

    public void setButtonIconDrawableResource(@DrawableRes int resId) {
        setButtonIconDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setButtonIconDrawable(@Nullable Drawable drawable) {
        this.f3198b = drawable;
        g();
    }

    @Nullable
    public Drawable getButtonIconDrawable() {
        return this.f3198b;
    }

    public void setButtonIconTintList(@Nullable ColorStateList tintList) {
        if (this.f3202c != tintList) {
            this.f3202c = tintList;
            g();
        }
    }

    @Nullable
    public ColorStateList getButtonIconTintList() {
        return this.f3202c;
    }

    public void setButtonIconTintMode(@NonNull PorterDuff.Mode tintMode) {
        if (this.f3188a != tintMode) {
            this.f3188a = tintMode;
            g();
        }
    }

    @NonNull
    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f3188a;
    }

    public void setUseMaterialThemeColors(boolean useMaterialThemeColors) {
        this.f3195a = useMaterialThemeColors;
        if (useMaterialThemeColors) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, (ColorStateList) null);
        }
    }

    public void setCenterIfNoTextEnabled(boolean centerIfNoTextEnabled) {
        this.f3201b = centerIfNoTextEnabled;
    }

    private void g() {
        this.f3189a = yh.c(this.f3189a, this.f3197b, CompoundButtonCompat.getButtonTintMode(this));
        this.f3198b = yh.c(this.f3198b, this.f3202c, this.f3188a);
        i();
        j();
        super.setButtonDrawable(yh.a(this.f3189a, this.f3198b));
        refreshDrawableState();
    }

    private void i() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
        if (this.d) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat2 = this.f3192a;
            if (animatedVectorDrawableCompat2 != null) {
                animatedVectorDrawableCompat2.unregisterAnimationCallback(this.f3191a);
                this.f3192a.registerAnimationCallback(this.f3191a);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                Drawable drawable = this.f3189a;
                if ((drawable instanceof AnimatedStateListDrawable) && (animatedVectorDrawableCompat = this.f3192a) != null) {
                    int i = ic0.b;
                    int i2 = ic0.T;
                    ((AnimatedStateListDrawable) drawable).addTransition(i, i2, animatedVectorDrawableCompat, false);
                    ((AnimatedStateListDrawable) this.f3189a).addTransition(ic0.indeterminate, i2, this.f3192a, false);
                }
            }
        }
    }

    private void j() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable = this.f3189a;
        if (!(drawable == null || (colorStateList2 = this.f3197b) == null)) {
            DrawableCompat.setTintList(drawable, colorStateList2);
        }
        Drawable drawable2 = this.f3198b;
        if (drawable2 != null && (colorStateList = this.f3202c) != null) {
            DrawableCompat.setTintList(drawable2, colorStateList);
        }
    }

    private void k() {
        Drawable drawable;
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT < 21 && (drawable = this.f3198b) != null && (colorStateList = this.f3202c) != null) {
            drawable.setColorFilter(yh.l(drawable, colorStateList, this.f3188a));
        }
    }

    @RequiresApi(30)
    public void setStateDescription(@Nullable CharSequence stateDescription) {
        this.f3199b = stateDescription;
        if (stateDescription == null) {
            h();
        } else {
            super.setStateDescription(stateDescription);
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 30 && this.f3199b == null) {
            super.setStateDescription(getButtonStateDescription());
        }
    }

    @NonNull
    private String getButtonStateDescription() {
        int i = this.f3186a;
        if (i == 1) {
            return getResources().getString(sc0.mtrl_checkbox_state_description_checked);
        }
        if (i == 0) {
            return getResources().getString(sc0.mtrl_checkbox_state_description_unchecked);
        }
        return getResources().getString(sc0.mtrl_checkbox_state_description_indeterminate);
    }

    @Nullable
    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f3197b;
        if (colorStateList != null) {
            return colorStateList;
        }
        if (Build.VERSION.SDK_INT < 21 || super.getButtonTintList() == null) {
            return getSupportButtonTintList();
        }
        return super.getButtonTintList();
    }

    private boolean d(TintTypedArray attributes) {
        int buttonResourceId = attributes.getResourceId(xc0.Y2, 0);
        int buttonCompatResourceId = attributes.getResourceId(xc0.Z2, 0);
        if (Build.VERSION.SDK_INT < 21) {
            if (buttonResourceId == gc0.a && buttonCompatResourceId == gc0.b) {
                return true;
            }
            return false;
        } else if (buttonResourceId == c && buttonCompatResourceId == 0) {
            return true;
        } else {
            return false;
        }
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f3187a == null) {
            int[][] iArr = a;
            int[] checkBoxColorsList = new int[iArr.length];
            int colorControlActivated = k00.d(this, yb0.h);
            int colorError = k00.d(this, yb0.j);
            int colorSurface = k00.d(this, yb0.colorSurface);
            int colorOnSurface = k00.d(this, yb0.colorOnSurface);
            checkBoxColorsList[0] = k00.k(colorSurface, colorError, 1.0f);
            checkBoxColorsList[1] = k00.k(colorSurface, colorControlActivated, 1.0f);
            checkBoxColorsList[2] = k00.k(colorSurface, colorOnSurface, 0.54f);
            checkBoxColorsList[3] = k00.k(colorSurface, colorOnSurface, 0.38f);
            checkBoxColorsList[4] = k00.k(colorSurface, colorOnSurface, 0.38f);
            this.f3187a = new ColorStateList(iArr, checkBoxColorsList);
        }
        return this.f3187a;
    }

    public Parcelable onSaveInstanceState() {
        d ss = new d(super.onSaveInstanceState());
        ss.a = getCheckedState();
        return ss;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof d)) {
            super.onRestoreInstanceState(state);
            return;
        }
        d ss = (d) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCheckedState(ss.a);
    }

    /* renamed from: i00$d */
    static class d extends View.BaseSavedState {
        @NonNull
        public static final Parcelable.Creator<d> CREATOR = new a();
        int a;

        /* synthetic */ d(Parcel x0, a x1) {
            this(x0);
        }

        d(Parcelable superState) {
            super(superState);
        }

        private d(Parcel in) {
            super(in);
            this.a = ((Integer) in.readValue(getClass().getClassLoader())).intValue();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeValue(Integer.valueOf(this.a));
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + f() + "}";
        }

        /* renamed from: i00$d$a */
        class a implements Parcelable.Creator<d> {
            a() {
            }

            /* renamed from: a */
            public d createFromParcel(Parcel in) {
                return new d(in, (a) null);
            }

            /* renamed from: b */
            public d[] newArray(int size) {
                return new d[size];
            }
        }

        private String f() {
            switch (this.a) {
                case 1:
                    return "checked";
                case 2:
                    return "indeterminate";
                default:
                    return "unchecked";
            }
        }
    }
}
