package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int A = uc0.Widget_Design_TextInputLayout;
    private static final int[][] a = {new int[]{16842919}, new int[0]};

    /* renamed from: a  reason: collision with other field name */
    private int f1954a;

    /* renamed from: a  reason: collision with other field name */
    private ValueAnimator f1955a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1956a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1957a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f1958a;

    /* renamed from: a  reason: collision with other field name */
    private Typeface f1959a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1960a;

    /* renamed from: a  reason: collision with other field name */
    private StateListDrawable f1961a;

    /* renamed from: a  reason: collision with other field name */
    EditText f1962a;

    /* renamed from: a  reason: collision with other field name */
    private final FrameLayout f1963a;

    /* renamed from: a  reason: collision with other field name */
    private TextView f1964a;

    /* renamed from: a  reason: collision with other field name */
    private Fade f1965a;

    /* renamed from: a  reason: collision with other field name */
    private e f1966a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final r f1967a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final u f1968a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final z f1969a;

    /* renamed from: a  reason: collision with other field name */
    final g9 f1970a;

    /* renamed from: a  reason: collision with other field name */
    private il0 f1971a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f1972a;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashSet<f> f1973a;

    /* renamed from: a  reason: collision with other field name */
    private p00 f1974a;

    /* renamed from: a  reason: collision with other field name */
    boolean f1975a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f1976b;

    /* renamed from: b  reason: collision with other field name */
    private final Rect f1977b;

    /* renamed from: b  reason: collision with other field name */
    private Drawable f1978b;

    /* renamed from: b  reason: collision with other field name */
    private TextView f1979b;

    /* renamed from: b  reason: collision with other field name */
    private Fade f1980b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f1981b;

    /* renamed from: b  reason: collision with other field name */
    private p00 f1982b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1983b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private ColorStateList f1984c;

    /* renamed from: c  reason: collision with other field name */
    private Drawable f1985c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f1986c;

    /* renamed from: c  reason: collision with other field name */
    private p00 f1987c;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with other field name */
    public boolean f1988c;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private ColorStateList f1989d;

    /* renamed from: d  reason: collision with other field name */
    private p00 f1990d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1991d;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private ColorStateList f1992e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1993e;
    private int f;

    /* renamed from: f  reason: collision with other field name */
    private ColorStateList f1994f;

    /* renamed from: f  reason: collision with other field name */
    private boolean f1995f;
    private int g;

    /* renamed from: g  reason: collision with other field name */
    private ColorStateList f1996g;

    /* renamed from: g  reason: collision with other field name */
    private boolean f1997g;
    private int h;

    /* renamed from: h  reason: collision with other field name */
    private ColorStateList f1998h;

    /* renamed from: h  reason: collision with other field name */
    private boolean f1999h;
    private final int i;

    /* renamed from: i  reason: collision with other field name */
    private boolean f2000i;
    private int j;

    /* renamed from: j  reason: collision with other field name */
    private boolean f2001j;
    private int k;

    /* renamed from: k  reason: collision with other field name */
    private boolean f2002k;
    private int l;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with other field name */
    public boolean f2003l;
    private int m;

    /* renamed from: m  reason: collision with other field name */
    private boolean f2004m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public interface e {
        int a(Editable editable);
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int T(Editable text) {
        if (text != null) {
            return text.length();
        }
        return 0;
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, yb0.textInputStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r30, android.util.AttributeSet r31, int r32) {
        /*
            r29 = this;
            r0 = r29
            r7 = r31
            r8 = r32
            int r9 = A
            r1 = r30
            android.content.Context r2 = defpackage.t00.c(r1, r7, r8, r9)
            r0.<init>(r2, r7, r8)
            r10 = -1
            r0.f1954a = r10
            r0.b = r10
            r0.c = r10
            r0.d = r10
            com.google.android.material.textfield.u r2 = new com.google.android.material.textfield.u
            r2.<init>(r0)
            r0.f1968a = r2
            sq0 r2 = defpackage.sq0.a
            r0.f1966a = r2
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r0.f1957a = r2
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r0.f1977b = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r0.f1958a = r2
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            r0.f1973a = r2
            g9 r2 = new g9
            r2.<init>(r0)
            r0.f1970a = r2
            r11 = 0
            r0.f2004m = r11
            android.content.Context r12 = r29.getContext()
            r13 = 1
            r0.setOrientation(r13)
            r0.setWillNotDraw(r11)
            r0.setAddStatesFromChildren(r13)
            android.widget.FrameLayout r14 = new android.widget.FrameLayout
            r14.<init>(r12)
            r0.f1963a = r14
            r14.setAddStatesFromChildren(r13)
            android.animation.TimeInterpolator r1 = defpackage.f3.a
            r2.L0(r1)
            r2.G0(r1)
            r1 = 8388659(0x800033, float:1.1755015E-38)
            r2.j0(r1)
            int[] r3 = defpackage.xc0.f5600C1
            r1 = 5
            int[] r6 = new int[r1]
            int r15 = defpackage.xc0.k5
            r6[r11] = r15
            int r5 = defpackage.xc0.i5
            r6[r13] = r5
            int r4 = defpackage.xc0.C5
            r2 = 2
            r6[r2] = r4
            int r1 = defpackage.xc0.H5
            r16 = 3
            r6[r16] = r1
            int r11 = defpackage.xc0.L5
            r17 = 4
            r6[r17] = r11
            r18 = r1
            r1 = r12
            r2 = r31
            r19 = r4
            r4 = r32
            r20 = r5
            r5 = r9
            androidx.appcompat.widget.TintTypedArray r1 = defpackage.vq0.j(r1, r2, r3, r4, r5, r6)
            com.google.android.material.textfield.z r2 = new com.google.android.material.textfield.z
            r2.<init>(r0, r1)
            r0.f1969a = r2
            int r3 = defpackage.xc0.K5
            boolean r3 = r1.getBoolean(r3, r13)
            r0.f1991d = r3
            int r3 = defpackage.xc0.S4
            java.lang.CharSequence r3 = r1.getText(r3)
            r0.setHint((java.lang.CharSequence) r3)
            int r3 = defpackage.xc0.J5
            boolean r3 = r1.getBoolean(r3, r13)
            r0.f2001j = r3
            int r3 = defpackage.xc0.E5
            boolean r3 = r1.getBoolean(r3, r13)
            r0.f2000i = r3
            int r3 = defpackage.xc0.U4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x00d7
            int r3 = r1.getInt(r3, r10)
            r0.setMinEms(r3)
            goto L_0x00e6
        L_0x00d7:
            int r3 = defpackage.xc0.R4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x00e6
            int r3 = r1.getDimensionPixelSize(r3, r10)
            r0.setMinWidth(r3)
        L_0x00e6:
            int r3 = defpackage.xc0.T4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x00f6
            int r3 = r1.getInt(r3, r10)
            r0.setMaxEms(r3)
            goto L_0x0105
        L_0x00f6:
            int r3 = defpackage.xc0.Q4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x0105
            int r3 = r1.getDimensionPixelSize(r3, r10)
            r0.setMaxWidth(r3)
        L_0x0105:
            il0$b r3 = defpackage.il0.e(r12, r7, r8, r9)
            il0 r3 = r3.m()
            r0.f1971a = r3
            android.content.res.Resources r3 = r12.getResources()
            int r4 = defpackage.cc0.mtrl_textinput_box_label_cutout_padding
            int r3 = r3.getDimensionPixelOffset(r4)
            r0.i = r3
            int r3 = defpackage.xc0.X4
            r4 = 0
            int r3 = r1.getDimensionPixelOffset(r3, r4)
            r0.k = r3
            int r3 = defpackage.xc0.e5
            android.content.res.Resources r4 = r12.getResources()
            int r5 = defpackage.cc0.mtrl_textinput_box_stroke_width_default
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.m = r3
            int r3 = defpackage.xc0.f5
            android.content.res.Resources r4 = r12.getResources()
            int r5 = defpackage.cc0.mtrl_textinput_box_stroke_width_focused
            int r4 = r4.getDimensionPixelSize(r5)
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r0.n = r3
            int r3 = r0.m
            r0.l = r3
            int r3 = defpackage.xc0.b5
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r1.getDimension(r3, r4)
            int r5 = defpackage.xc0.a5
            float r5 = r1.getDimension(r5, r4)
            int r6 = defpackage.xc0.Y4
            float r6 = r1.getDimension(r6, r4)
            int r9 = defpackage.xc0.Z4
            float r4 = r1.getDimension(r9, r4)
            il0 r9 = r0.f1971a
            il0$b r9 = r9.v()
            r17 = 0
            int r21 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r21 < 0) goto L_0x0177
            r9.A(r3)
        L_0x0177:
            int r21 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r21 < 0) goto L_0x017e
            r9.E(r5)
        L_0x017e:
            int r21 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r21 < 0) goto L_0x0185
            r9.w(r6)
        L_0x0185:
            int r17 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r17 < 0) goto L_0x018c
            r9.s(r4)
        L_0x018c:
            il0 r10 = r9.m()
            r0.f1971a = r10
            int r10 = defpackage.xc0.V4
            android.content.res.ColorStateList r10 = defpackage.o00.b(r12, r1, r10)
            if (r10 == 0) goto L_0x0207
            int r13 = r10.getDefaultColor()
            r0.v = r13
            r0.p = r13
            boolean r13 = r10.isStateful()
            r21 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r13 == 0) goto L_0x01d9
            r22 = r3
            r13 = 1
            int[] r3 = new int[r13]
            r13 = 0
            r3[r13] = r21
            r13 = -1
            int r3 = r10.getColorForState(r3, r13)
            r0.w = r3
            r3 = 2
            int[] r13 = new int[r3]
            r13 = {16842908, 16842910} // fill-array
            r3 = -1
            int r13 = r10.getColorForState(r13, r3)
            r0.x = r13
            r13 = 2
            int[] r3 = new int[r13]
            r3 = {16843623, 16842910} // fill-array
            r13 = -1
            int r3 = r10.getColorForState(r3, r13)
            r0.y = r3
            r23 = r4
            r21 = r5
            goto L_0x0218
        L_0x01d9:
            r22 = r3
            int r3 = r0.v
            r0.x = r3
            int r3 = defpackage.zb0.mtrl_filled_background_color
            android.content.res.ColorStateList r3 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r12, r3)
            r23 = r4
            r13 = 1
            int[] r4 = new int[r13]
            r13 = 0
            r4[r13] = r21
            r13 = -1
            int r4 = r3.getColorForState(r4, r13)
            r0.w = r4
            r4 = 1
            int[] r13 = new int[r4]
            r4 = 16843623(0x1010367, float:2.3696E-38)
            r21 = r5
            r5 = 0
            r13[r5] = r4
            r4 = -1
            int r13 = r3.getColorForState(r13, r4)
            r0.y = r13
            goto L_0x0218
        L_0x0207:
            r22 = r3
            r23 = r4
            r21 = r5
            r5 = 0
            r0.p = r5
            r0.v = r5
            r0.w = r5
            r0.x = r5
            r0.y = r5
        L_0x0218:
            int r3 = defpackage.xc0.P4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x0229
            android.content.res.ColorStateList r3 = r1.getColorStateList(r3)
            r0.f1996g = r3
            r0.f1994f = r3
        L_0x0229:
            int r3 = defpackage.xc0.c5
            android.content.res.ColorStateList r4 = defpackage.o00.b(r12, r1, r3)
            r5 = 0
            int r3 = r1.getColor(r3, r5)
            r0.u = r3
            int r3 = defpackage.zb0.mtrl_textinput_default_box_stroke_color
            int r3 = androidx.core.content.ContextCompat.getColor(r12, r3)
            r0.s = r3
            int r3 = defpackage.zb0.mtrl_textinput_disabled_color
            int r3 = androidx.core.content.ContextCompat.getColor(r12, r3)
            r0.z = r3
            int r3 = defpackage.zb0.mtrl_textinput_hovered_box_stroke_color
            int r3 = androidx.core.content.ContextCompat.getColor(r12, r3)
            r0.t = r3
            if (r4 == 0) goto L_0x0253
            r0.setBoxStrokeColorStateList(r4)
        L_0x0253:
            int r3 = defpackage.xc0.d5
            boolean r5 = r1.hasValue(r3)
            if (r5 == 0) goto L_0x0263
            android.content.res.ColorStateList r3 = defpackage.o00.b(r12, r1, r3)
            r0.setBoxStrokeErrorColor(r3)
        L_0x0263:
            r3 = -1
            int r5 = r1.getResourceId(r11, r3)
            if (r5 == r3) goto L_0x0272
            r3 = 0
            int r11 = r1.getResourceId(r11, r3)
            r0.setHintTextAppearance(r11)
        L_0x0272:
            int r3 = defpackage.xc0.m5
            android.content.res.ColorStateList r3 = r1.getColorStateList(r3)
            r0.f1989d = r3
            int r3 = defpackage.xc0.n5
            android.content.res.ColorStateList r3 = r1.getColorStateList(r3)
            r0.f1992e = r3
            r3 = r19
            r11 = 0
            int r3 = r1.getResourceId(r3, r11)
            int r13 = defpackage.xc0.x5
            java.lang.CharSequence r13 = r1.getText(r13)
            int r11 = defpackage.xc0.w5
            r19 = r4
            r4 = 1
            int r11 = r1.getInt(r11, r4)
            int r4 = defpackage.xc0.y5
            r24 = r5
            r5 = 0
            boolean r4 = r1.getBoolean(r4, r5)
            r16 = r6
            r6 = r18
            int r6 = r1.getResourceId(r6, r5)
            int r7 = defpackage.xc0.G5
            boolean r7 = r1.getBoolean(r7, r5)
            int r5 = defpackage.xc0.F5
            java.lang.CharSequence r5 = r1.getText(r5)
            int r8 = defpackage.xc0.T5
            r25 = r9
            r9 = 0
            int r8 = r1.getResourceId(r8, r9)
            int r9 = defpackage.xc0.S5
            java.lang.CharSequence r9 = r1.getText(r9)
            r26 = r10
            int r10 = defpackage.xc0.g5
            r27 = r12
            r12 = 0
            boolean r10 = r1.getBoolean(r10, r12)
            int r12 = defpackage.xc0.h5
            r28 = r5
            r5 = -1
            int r5 = r1.getInt(r12, r5)
            r0.setCounterMaxLength(r5)
            r5 = 0
            int r12 = r1.getResourceId(r15, r5)
            r0.g = r12
            r12 = r20
            int r12 = r1.getResourceId(r12, r5)
            r0.f = r12
            int r12 = defpackage.xc0.W4
            int r5 = r1.getInt(r12, r5)
            r0.setBoxBackgroundMode(r5)
            r0.setErrorContentDescription(r13)
            r0.setErrorAccessibilityLiveRegion(r11)
            int r5 = r0.f
            r0.setCounterOverflowTextAppearance(r5)
            r0.setHelperTextTextAppearance(r6)
            r0.setErrorTextAppearance(r3)
            int r5 = r0.g
            r0.setCounterTextAppearance(r5)
            r0.setPlaceholderText(r9)
            r0.setPlaceholderTextAppearance(r8)
            int r5 = defpackage.xc0.D5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x0321
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setErrorTextColor(r5)
        L_0x0321:
            int r5 = defpackage.xc0.I5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x0330
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setHelperTextColor(r5)
        L_0x0330:
            int r5 = defpackage.xc0.M5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x033f
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setHintTextColor(r5)
        L_0x033f:
            int r5 = defpackage.xc0.l5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x034e
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setCounterTextColor(r5)
        L_0x034e:
            int r5 = defpackage.xc0.j5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x035e
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setCounterOverflowTextColor(r5)
        L_0x035e:
            int r5 = defpackage.xc0.U5
            boolean r12 = r1.hasValue(r5)
            if (r12 == 0) goto L_0x036e
            android.content.res.ColorStateList r5 = r1.getColorStateList(r5)
            r0.setPlaceholderTextColor(r5)
        L_0x036e:
            com.google.android.material.textfield.r r5 = new com.google.android.material.textfield.r
            r5.<init>(r0, r1)
            r0.f1967a = r5
            int r12 = defpackage.xc0.O4
            r15 = 1
            boolean r12 = r1.getBoolean(r12, r15)
            r1.recycle()
            r15 = 2
            androidx.core.view.ViewCompat.setImportantForAccessibility(r0, r15)
            int r15 = android.os.Build.VERSION.SDK_INT
            r17 = r1
            r1 = 26
            if (r15 < r1) goto L_0x038f
            r1 = 1
            androidx.core.view.ViewCompat.setImportantForAutofill(r0, r1)
        L_0x038f:
            r14.addView(r2)
            r14.addView(r5)
            r0.addView(r14)
            r0.setEnabled(r12)
            r0.setHelperTextEnabled(r7)
            r0.setErrorEnabled(r4)
            r0.setCounterEnabled(r10)
            r1 = r28
            r0.setHelperText(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 16) {
            this.f1967a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f1967a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.f2004m = false;
        boolean updatedHeight = s0();
        boolean updatedIcon = o0();
        if (updatedHeight || updatedIcon) {
            this.f1962a.post(new tq0(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f1962a.requestLayout();
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (child instanceof EditText) {
            FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(params);
            flp.gravity = (flp.gravity & -113) | 16;
            this.f1963a.addView(child, flp);
            this.f1963a.setLayoutParams(params);
            t0();
            setEditText((EditText) child);
            return;
        }
        super.addView(child, index, params);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public p00 getBoxBackground() {
        int i2 = this.j;
        if (i2 == 1 || i2 == 2) {
            return this.f1974a;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int boxBackgroundMode) {
        if (boxBackgroundMode != this.j) {
            this.j = boxBackgroundMode;
            if (this.f1962a != null) {
                V();
            }
        }
    }

    public int getBoxBackgroundMode() {
        return this.j;
    }

    private void V() {
        p();
        r0();
        A0();
        h0();
        k();
        if (this.j != 0) {
            t0();
        }
        b0();
    }

    private void p() {
        switch (this.j) {
            case 0:
                this.f1974a = null;
                this.f1987c = null;
                this.f1990d = null;
                return;
            case 1:
                this.f1974a = new p00(this.f1971a);
                this.f1987c = new p00();
                this.f1990d = new p00();
                return;
            case 2:
                if (!this.f1991d || (this.f1974a instanceof h)) {
                    this.f1974a = new p00(this.f1971a);
                } else {
                    this.f1974a = h.j0(this.f1971a);
                }
                this.f1987c = null;
                this.f1990d = null;
                return;
            default:
                throw new IllegalArgumentException(this.j + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    /* access modifiers changed from: package-private */
    public void r0() {
        EditText editText = this.f1962a;
        if (editText != null && this.f1974a != null) {
            if ((this.f1995f || editText.getBackground() == null) && this.j != 0) {
                q0();
                this.f1995f = true;
            }
        }
    }

    private void q0() {
        Drawable editTextBoxBackground = getEditTextBoxBackground();
        if (Build.VERSION.SDK_INT >= 21 || !(editTextBoxBackground instanceof LayerDrawable)) {
            ViewCompat.setBackground(this.f1962a, editTextBoxBackground);
            return;
        }
        int paddingLeft = this.f1962a.getPaddingLeft();
        int paddingTop = this.f1962a.getPaddingTop();
        int paddingRight = this.f1962a.getPaddingRight();
        int paddingBottom = this.f1962a.getPaddingBottom();
        ViewCompat.setBackground(this.f1962a, editTextBoxBackground);
        this.f1962a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f1962a;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.f1974a;
        }
        int rippleColor = k00.d(this.f1962a, yb0.i);
        int i2 = this.j;
        if (i2 == 2) {
            return K(getContext(), this.f1974a, rippleColor, a);
        }
        if (i2 == 1) {
            return H(this.f1974a, this.p, rippleColor, a);
        }
        return null;
    }

    private static Drawable K(Context context, p00 boxBackground, int rippleColor, int[][] states) {
        int surfaceColor = k00.c(context, yb0.colorSurface, "TextInputLayout");
        p00 rippleBackground = new p00(boxBackground.B());
        int pressedBackgroundColor = k00.k(rippleColor, surfaceColor, 0.1f);
        rippleBackground.V(new ColorStateList(states, new int[]{pressedBackgroundColor, 0}));
        if (Build.VERSION.SDK_INT >= 21) {
            rippleBackground.setTint(surfaceColor);
            ColorStateList rippleColorStateList = new ColorStateList(states, new int[]{pressedBackgroundColor, surfaceColor});
            p00 mask = new p00(boxBackground.B());
            mask.setTint(-1);
            return new LayerDrawable(new Drawable[]{new RippleDrawable(rippleColorStateList, rippleBackground, mask), boxBackground});
        }
        return new LayerDrawable(new Drawable[]{rippleBackground, boxBackground});
    }

    private static Drawable H(p00 boxBackground, int boxBackgroundColor, int rippleColor, int[][] states) {
        int[] colors = {k00.k(rippleColor, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(new ColorStateList(states, colors), boxBackground, boxBackground);
        }
        p00 rippleBackground = new p00(boxBackground.B());
        rippleBackground.V(new ColorStateList(states, colors));
        return new LayerDrawable(new Drawable[]{boxBackground, rippleBackground});
    }

    private void b0() {
        EditText editText = this.f1962a;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (Build.VERSION.SDK_INT >= 21 && autoCompleteTextView.getDropDownBackground() == null) {
                int i2 = this.j;
                if (i2 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i2 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f1982b == null) {
            this.f1982b = G(true);
        }
        return this.f1982b;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f1961a == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f1961a = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.f1961a.addState(new int[0], G(false));
        }
        return this.f1961a;
    }

    private p00 G(boolean roundedTopCorners) {
        float elevation;
        float cornerRadius = (float) getResources().getDimensionPixelOffset(cc0.mtrl_shape_corner_size_small_component);
        float topCornerRadius = roundedTopCorners ? cornerRadius : 0.0f;
        EditText editText = this.f1962a;
        if (editText instanceof v) {
            elevation = ((v) editText).getPopupElevation();
        } else {
            elevation = (float) getResources().getDimensionPixelOffset(cc0.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int verticalPadding = getResources().getDimensionPixelOffset(cc0.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        il0 shapeAppearanceModel = il0.a().A(topCornerRadius).E(topCornerRadius).s(cornerRadius).w(cornerRadius).m();
        ColorStateList dropDownBackgroundTint = null;
        EditText editText2 = this.f1962a;
        if (editText2 instanceof v) {
            dropDownBackgroundTint = ((v) editText2).getDropDownBackgroundTintList();
        }
        p00 popupDrawable = p00.m(getContext(), elevation, dropDownBackgroundTint);
        popupDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        popupDrawable.X(0, verticalPadding, 0, verticalPadding);
        return popupDrawable;
    }

    private void h0() {
        if (this.j != 1) {
            return;
        }
        if (o00.i(getContext())) {
            this.k = getResources().getDimensionPixelSize(cc0.material_font_2_0_box_collapsed_padding_top);
        } else if (o00.h(getContext())) {
            this.k = getResources().getDimensionPixelSize(cc0.material_font_1_3_box_collapsed_padding_top);
        }
    }

    private void k() {
        if (this.f1962a != null && this.j == 1) {
            if (o00.i(getContext())) {
                EditText editText = this.f1962a;
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(cc0.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f1962a), getResources().getDimensionPixelSize(cc0.material_filled_edittext_font_2_0_padding_bottom));
            } else if (o00.h(getContext())) {
                EditText editText2 = this.f1962a;
                ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(cc0.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f1962a), getResources().getDimensionPixelSize(cc0.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int boxCollapsedPaddingTop) {
        this.k = boxCollapsedPaddingTop;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.k;
    }

    public void setBoxStrokeWidthResource(@DimenRes int boxStrokeWidthResId) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(boxStrokeWidthResId));
    }

    public void setBoxStrokeWidth(int boxStrokeWidth) {
        this.m = boxStrokeWidth;
        A0();
    }

    public int getBoxStrokeWidth() {
        return this.m;
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int boxStrokeWidthFocusedResId) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(boxStrokeWidthFocusedResId));
    }

    public void setBoxStrokeWidthFocused(int boxStrokeWidthFocused) {
        this.n = boxStrokeWidthFocused;
        A0();
    }

    public int getBoxStrokeWidthFocused() {
        return this.n;
    }

    public void setBoxStrokeColor(@ColorInt int boxStrokeColor) {
        if (this.u != boxStrokeColor) {
            this.u = boxStrokeColor;
            A0();
        }
    }

    public int getBoxStrokeColor() {
        return this.u;
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList boxStrokeColorStateList) {
        if (boxStrokeColorStateList.isStateful()) {
            this.s = boxStrokeColorStateList.getDefaultColor();
            this.z = boxStrokeColorStateList.getColorForState(new int[]{-16842910}, -1);
            this.t = boxStrokeColorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.u = boxStrokeColorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.u != boxStrokeColorStateList.getDefaultColor()) {
            this.u = boxStrokeColorStateList.getDefaultColor();
        }
        A0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList strokeErrorColor) {
        if (this.f1998h != strokeErrorColor) {
            this.f1998h = strokeErrorColor;
            A0();
        }
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f1998h;
    }

    public void setBoxBackgroundColorResource(@ColorRes int boxBackgroundColorId) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), boxBackgroundColorId));
    }

    public void setBoxBackgroundColor(@ColorInt int boxBackgroundColor) {
        if (this.p != boxBackgroundColor) {
            this.p = boxBackgroundColor;
            this.v = boxBackgroundColor;
            this.x = boxBackgroundColor;
            this.y = boxBackgroundColor;
            m();
        }
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList boxBackgroundColorStateList) {
        int defaultColor = boxBackgroundColorStateList.getDefaultColor();
        this.v = defaultColor;
        this.p = defaultColor;
        this.w = boxBackgroundColorStateList.getColorForState(new int[]{-16842910}, -1);
        this.x = boxBackgroundColorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.y = boxBackgroundColorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        m();
    }

    public int getBoxBackgroundColor() {
        return this.p;
    }

    public void setShapeAppearanceModel(@NonNull il0 shapeAppearanceModel) {
        p00 p00 = this.f1974a;
        if (p00 != null && p00.B() != shapeAppearanceModel) {
            this.f1971a = shapeAppearanceModel;
            m();
        }
    }

    @NonNull
    public il0 getShapeAppearanceModel() {
        return this.f1971a;
    }

    public void setBoxCornerFamily(int cornerFamily) {
        this.f1971a = this.f1971a.v().y(cornerFamily, this.f1971a.r()).C(cornerFamily, this.f1971a.t()).q(cornerFamily, this.f1971a.j()).u(cornerFamily, this.f1971a.l()).m();
        m();
    }

    public float getBoxCornerRadiusTopStart() {
        if (lv0.g(this)) {
            return this.f1971a.t().a(this.f1958a);
        }
        return this.f1971a.r().a(this.f1958a);
    }

    public float getBoxCornerRadiusTopEnd() {
        if (lv0.g(this)) {
            return this.f1971a.r().a(this.f1958a);
        }
        return this.f1971a.t().a(this.f1958a);
    }

    public float getBoxCornerRadiusBottomEnd() {
        if (lv0.g(this)) {
            return this.f1971a.j().a(this.f1958a);
        }
        return this.f1971a.l().a(this.f1958a);
    }

    public float getBoxCornerRadiusBottomStart() {
        if (lv0.g(this)) {
            return this.f1971a.l().a(this.f1958a);
        }
        return this.f1971a.j().a(this.f1958a);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f1959a) {
            this.f1959a = typeface;
            this.f1970a.N0(typeface);
            this.f1968a.N(typeface);
            TextView textView = this.f1964a;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f1959a;
    }

    public void setLengthCounter(@NonNull e lengthCounter) {
        this.f1966a = lengthCounter;
    }

    @NonNull
    public e getLengthCounter() {
        return this.f1966a;
    }

    public void dispatchProvideAutofillStructure(ViewStructure structure, int flags) {
        EditText editText = this.f1962a;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(structure, flags);
        } else if (this.f1972a != null) {
            boolean wasProvidingHint = this.f1993e;
            this.f1993e = false;
            CharSequence hint = editText.getHint();
            this.f1962a.setHint(this.f1972a);
            try {
                super.dispatchProvideAutofillStructure(structure, flags);
            } finally {
                this.f1962a.setHint(hint);
                this.f1993e = wasProvidingHint;
            }
        } else {
            structure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(structure, flags);
            onProvideAutofillVirtualStructure(structure, flags);
            structure.setChildCount(this.f1963a.getChildCount());
            for (int i2 = 0; i2 < this.f1963a.getChildCount(); i2++) {
                View child = this.f1963a.getChildAt(i2);
                ViewStructure childStructure = structure.newChild(i2);
                child.dispatchProvideAutofillStructure(childStructure, flags);
                if (child == this.f1962a) {
                    childStructure.setHint(getHint());
                }
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f1962a == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f1962a = editText;
            int i2 = this.f1954a;
            if (i2 != -1) {
                setMinEms(i2);
            } else {
                setMinWidth(this.c);
            }
            int i3 = this.b;
            if (i3 != -1) {
                setMaxEms(i3);
            } else {
                setMaxWidth(this.d);
            }
            this.f1995f = false;
            V();
            setTextInputAccessibilityDelegate(new d(this));
            this.f1970a.N0(this.f1962a.getTypeface());
            this.f1970a.v0(this.f1962a.getTextSize());
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                this.f1970a.q0(this.f1962a.getLetterSpacing());
            }
            int editTextGravity = this.f1962a.getGravity();
            this.f1970a.j0((editTextGravity & -113) | 48);
            this.f1970a.u0(editTextGravity);
            this.f1962a.addTextChangedListener(new a());
            if (this.f1994f == null) {
                this.f1994f = this.f1962a.getHintTextColors();
            }
            if (this.f1991d) {
                if (TextUtils.isEmpty(this.f1986c)) {
                    CharSequence hint = this.f1962a.getHint();
                    this.f1972a = hint;
                    setHint(hint);
                    this.f1962a.setHint((CharSequence) null);
                }
                this.f1993e = true;
            }
            if (i4 >= 29) {
                n0();
            }
            if (this.f1964a != null) {
                k0(this.f1962a.getText());
            }
            p0();
            this.f1968a.f();
            this.f1969a.bringToFront();
            this.f1967a.bringToFront();
            C();
            this.f1967a.x0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            v0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable s) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.u0(!textInputLayout.f2003l);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f1975a) {
                textInputLayout2.k0(s);
            }
            if (TextInputLayout.this.f1988c) {
                TextInputLayout.this.y0(s);
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    private void t0() {
        if (this.j != 1) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.f1963a.getLayoutParams();
            int newTopMargin = v();
            if (newTopMargin != lp.topMargin) {
                lp.topMargin = newTopMargin;
                this.f1963a.requestLayout();
            }
        }
    }

    public int getBaseline() {
        EditText editText = this.f1962a;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public void u0(boolean animate) {
        v0(animate, false);
    }

    private void v0(boolean animate, boolean force) {
        ColorStateList colorStateList;
        TextView textView;
        int disabledHintColor;
        boolean isEnabled = isEnabled();
        EditText editText = this.f1962a;
        boolean hasText = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f1962a;
        boolean hasFocus = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f1994f;
        if (colorStateList2 != null) {
            this.f1970a.d0(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f1994f;
            if (colorStateList3 != null) {
                disabledHintColor = colorStateList3.getColorForState(new int[]{-16842910}, this.z);
            } else {
                disabledHintColor = this.z;
            }
            this.f1970a.d0(ColorStateList.valueOf(disabledHintColor));
        } else if (d0()) {
            this.f1970a.d0(this.f1968a.r());
        } else if (this.f1983b && (textView = this.f1964a) != null) {
            this.f1970a.d0(textView.getTextColors());
        } else if (hasFocus && (colorStateList = this.f1996g) != null) {
            this.f1970a.i0(colorStateList);
        }
        if (hasText || !this.f2000i || (isEnabled() && hasFocus)) {
            if (force || this.f1999h) {
                z(animate);
            }
        } else if (force || !this.f1999h) {
            F(animate);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.f1962a;
    }

    public void setMinEms(int minEms) {
        this.f1954a = minEms;
        EditText editText = this.f1962a;
        if (editText != null && minEms != -1) {
            editText.setMinEms(minEms);
        }
    }

    public int getMinEms() {
        return this.f1954a;
    }

    public void setMaxEms(int maxEms) {
        this.b = maxEms;
        EditText editText = this.f1962a;
        if (editText != null && maxEms != -1) {
            editText.setMaxEms(maxEms);
        }
    }

    public int getMaxEms() {
        return this.b;
    }

    public void setMinWidth(@Px int minWidth) {
        this.c = minWidth;
        EditText editText = this.f1962a;
        if (editText != null && minWidth != -1) {
            editText.setMinWidth(minWidth);
        }
    }

    public void setMinWidthResource(@DimenRes int minWidthId) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(minWidthId));
    }

    @Px
    public int getMinWidth() {
        return this.c;
    }

    public void setMaxWidth(@Px int maxWidth) {
        this.d = maxWidth;
        EditText editText = this.f1962a;
        if (editText != null && maxWidth != -1) {
            editText.setMaxWidth(maxWidth);
        }
    }

    public void setMaxWidthResource(@DimenRes int maxWidthId) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(maxWidthId));
    }

    @Px
    public int getMaxWidth() {
        return this.d;
    }

    public void setHint(@Nullable CharSequence hint) {
        if (this.f1991d) {
            setHintInternal(hint);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHint(@StringRes int textHintId) {
        setHint(textHintId != 0 ? getResources().getText(textHintId) : null);
    }

    private void setHintInternal(CharSequence hint) {
        if (!TextUtils.equals(hint, this.f1986c)) {
            this.f1986c = hint;
            this.f1970a.K0(hint);
            if (!this.f1999h) {
                W();
            }
        }
    }

    @Nullable
    public CharSequence getHint() {
        if (this.f1991d) {
            return this.f1986c;
        }
        return null;
    }

    public void setHintEnabled(boolean enabled) {
        if (enabled != this.f1991d) {
            this.f1991d = enabled;
            if (!enabled) {
                this.f1993e = false;
                if (!TextUtils.isEmpty(this.f1986c) && TextUtils.isEmpty(this.f1962a.getHint())) {
                    this.f1962a.setHint(this.f1986c);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence editTextHint = this.f1962a.getHint();
                if (!TextUtils.isEmpty(editTextHint)) {
                    if (TextUtils.isEmpty(this.f1986c)) {
                        setHint(editTextHint);
                    }
                    this.f1962a.setHint((CharSequence) null);
                }
                this.f1993e = true;
            }
            if (this.f1962a != null) {
                t0();
            }
        }
    }

    public boolean R() {
        return this.f1993e;
    }

    public void setHintTextAppearance(@StyleRes int resId) {
        this.f1970a.g0(resId);
        this.f1996g = this.f1970a.p();
        if (this.f1962a != null) {
            u0(false);
            t0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList hintTextColor) {
        if (this.f1996g != hintTextColor) {
            if (this.f1994f == null) {
                this.f1970a.i0(hintTextColor);
            }
            this.f1996g = hintTextColor;
            if (this.f1962a != null) {
                u0(false);
            }
        }
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f1996g;
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList textColor) {
        this.f1994f = textColor;
        this.f1996g = textColor;
        if (this.f1962a != null) {
            u0(false);
        }
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f1994f;
    }

    public void setErrorEnabled(boolean enabled) {
        this.f1968a.G(enabled);
    }

    public void setErrorTextAppearance(@StyleRes int errorTextAppearance) {
        this.f1968a.H(errorTextAppearance);
    }

    public void setErrorTextColor(@Nullable ColorStateList errorTextColor) {
        this.f1968a.I(errorTextColor);
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f1968a.q();
    }

    public void setHelperTextTextAppearance(@StyleRes int helperTextTextAppearance) {
        this.f1968a.J(helperTextTextAppearance);
    }

    public void setHelperTextColor(@Nullable ColorStateList helperTextColor) {
        this.f1968a.L(helperTextColor);
    }

    public boolean N() {
        return this.f1968a.A();
    }

    public void setHelperTextEnabled(boolean enabled) {
        this.f1968a.K(enabled);
    }

    public void setHelperText(@Nullable CharSequence helperText) {
        if (!TextUtils.isEmpty(helperText)) {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f1968a.R(helperText);
        } else if (O()) {
            setHelperTextEnabled(false);
        }
    }

    public boolean O() {
        return this.f1968a.B();
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f1968a.u();
    }

    public void setErrorContentDescription(@Nullable CharSequence errorContentDescription) {
        this.f1968a.F(errorContentDescription);
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f1968a.o();
    }

    public void setErrorAccessibilityLiveRegion(int errorAccessibilityLiveRegion) {
        this.f1968a.E(errorAccessibilityLiveRegion);
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f1968a.n();
    }

    public void setError(@Nullable CharSequence errorText) {
        if (!this.f1968a.A()) {
            if (!TextUtils.isEmpty(errorText)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(errorText)) {
            this.f1968a.Q(errorText);
        } else {
            this.f1968a.w();
        }
    }

    public void setErrorIconDrawable(@DrawableRes int resId) {
        this.f1967a.b0(resId);
    }

    public void setErrorIconDrawable(@Nullable Drawable errorIconDrawable) {
        this.f1967a.c0(errorIconDrawable);
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f1967a.s();
    }

    public void setErrorIconTintList(@Nullable ColorStateList errorIconTintList) {
        this.f1967a.f0(errorIconTintList);
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode errorIconTintMode) {
        this.f1967a.g0(errorIconTintMode);
    }

    public void setCounterEnabled(boolean enabled) {
        if (this.f1975a != enabled) {
            if (enabled) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f1964a = appCompatTextView;
                appCompatTextView.setId(ic0.textinput_counter);
                Typeface typeface = this.f1959a;
                if (typeface != null) {
                    this.f1964a.setTypeface(typeface);
                }
                this.f1964a.setMaxLines(1);
                this.f1968a.e(this.f1964a, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f1964a.getLayoutParams(), getResources().getDimensionPixelOffset(cc0.mtrl_textinput_counter_margin_start));
                m0();
                j0();
            } else {
                this.f1968a.C(this.f1964a, 2);
                this.f1964a = null;
            }
            this.f1975a = enabled;
        }
    }

    public void setCounterTextAppearance(int counterTextAppearance) {
        if (this.g != counterTextAppearance) {
            this.g = counterTextAppearance;
            m0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList counterTextColor) {
        if (this.f1976b != counterTextColor) {
            this.f1976b = counterTextColor;
            m0();
        }
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f1976b;
    }

    public void setCounterOverflowTextAppearance(int counterOverflowTextAppearance) {
        if (this.f != counterOverflowTextAppearance) {
            this.f = counterOverflowTextAppearance;
            m0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList counterOverflowTextColor) {
        if (this.f1984c != counterOverflowTextColor) {
            this.f1984c = counterOverflowTextColor;
            m0();
        }
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f1984c;
    }

    public void setCounterMaxLength(int maxLength) {
        if (this.e != maxLength) {
            if (maxLength > 0) {
                this.e = maxLength;
            } else {
                this.e = -1;
            }
            if (this.f1975a) {
                j0();
            }
        }
    }

    private void j0() {
        if (this.f1964a != null) {
            EditText editText = this.f1962a;
            k0(editText == null ? null : editText.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void k0(Editable text) {
        int length = this.f1966a.a(text);
        boolean wasCounterOverflowed = this.f1983b;
        int i2 = this.e;
        if (i2 == -1) {
            this.f1964a.setText(String.valueOf(length));
            this.f1964a.setContentDescription((CharSequence) null);
            this.f1983b = false;
        } else {
            this.f1983b = length > i2;
            l0(getContext(), this.f1964a, length, this.e, this.f1983b);
            if (wasCounterOverflowed != this.f1983b) {
                m0();
            }
            this.f1964a.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(sc0.character_counter_pattern, new Object[]{Integer.valueOf(length), Integer.valueOf(this.e)})));
        }
        if (this.f1962a != null && wasCounterOverflowed != this.f1983b) {
            u0(false);
            A0();
            p0();
        }
    }

    private static void l0(Context context, TextView counterView, int length, int counterMaxLength, boolean counterOverflowed) {
        int i2;
        if (counterOverflowed) {
            i2 = sc0.character_counter_overflowed_content_description;
        } else {
            i2 = sc0.character_counter_content_description;
        }
        counterView.setContentDescription(context.getString(i2, new Object[]{Integer.valueOf(length), Integer.valueOf(counterMaxLength)}));
    }

    public void setPlaceholderText(@Nullable CharSequence placeholderText) {
        if (this.f1979b == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f1979b = appCompatTextView;
            appCompatTextView.setId(ic0.textinput_placeholder);
            ViewCompat.setImportantForAccessibility(this.f1979b, 2);
            Fade A2 = A();
            this.f1965a = A2;
            A2.setStartDelay(67);
            this.f1980b = A();
            setPlaceholderTextAppearance(this.h);
            setPlaceholderTextColor(this.f1956a);
        }
        if (TextUtils.isEmpty(placeholderText)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f1988c) {
                setPlaceholderTextEnabled(true);
            }
            this.f1981b = placeholderText;
        }
        x0();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f1988c) {
            return this.f1981b;
        }
        return null;
    }

    private void setPlaceholderTextEnabled(boolean placeholderEnabled) {
        if (this.f1988c != placeholderEnabled) {
            if (placeholderEnabled) {
                j();
            } else {
                a0();
                this.f1979b = null;
            }
            this.f1988c = placeholderEnabled;
        }
    }

    private Fade A() {
        Fade placeholderFadeTransition = new Fade();
        placeholderFadeTransition.setDuration((long) i20.f(getContext(), yb0.motionDurationShort2, 87));
        placeholderFadeTransition.setInterpolator(i20.g(getContext(), yb0.motionEasingLinearInterpolator, f3.a));
        return placeholderFadeTransition;
    }

    private void x0() {
        EditText editText = this.f1962a;
        y0(editText == null ? null : editText.getText());
    }

    /* access modifiers changed from: private */
    public void y0(Editable text) {
        if (this.f1966a.a(text) != 0 || this.f1999h) {
            L();
        } else {
            g0();
        }
    }

    private void g0() {
        if (this.f1979b != null && this.f1988c && !TextUtils.isEmpty(this.f1981b)) {
            this.f1979b.setText(this.f1981b);
            TransitionManager.beginDelayedTransition(this.f1963a, this.f1965a);
            this.f1979b.setVisibility(0);
            this.f1979b.bringToFront();
            if (Build.VERSION.SDK_INT >= 16) {
                announceForAccessibility(this.f1981b);
            }
        }
    }

    private void L() {
        TextView textView = this.f1979b;
        if (textView != null && this.f1988c) {
            textView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(this.f1963a, this.f1980b);
            this.f1979b.setVisibility(4);
        }
    }

    private void j() {
        TextView textView = this.f1979b;
        if (textView != null) {
            this.f1963a.addView(textView);
            this.f1979b.setVisibility(0);
        }
    }

    private void a0() {
        TextView textView = this.f1979b;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList placeholderTextColor) {
        if (this.f1956a != placeholderTextColor) {
            this.f1956a = placeholderTextColor;
            TextView textView = this.f1979b;
            if (textView != null && placeholderTextColor != null) {
                textView.setTextColor(placeholderTextColor);
            }
        }
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f1956a;
    }

    public void setPlaceholderTextAppearance(@StyleRes int placeholderTextAppearance) {
        this.h = placeholderTextAppearance;
        TextView textView = this.f1979b;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, placeholderTextAppearance);
        }
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.h;
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList cursorColor) {
        if (this.f1989d != cursorColor) {
            this.f1989d = cursorColor;
            n0();
        }
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorColor() {
        return this.f1989d;
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList cursorErrorColor) {
        if (this.f1992e != cursorErrorColor) {
            this.f1992e = cursorErrorColor;
            if (Q()) {
                n0();
            }
        }
    }

    @RequiresApi(29)
    @Nullable
    public ColorStateList getCursorErrorColor() {
        return this.f1992e;
    }

    public void setPrefixText(@Nullable CharSequence prefixText) {
        this.f1969a.n(prefixText);
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f1969a.a();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f1969a.d();
    }

    public void setPrefixTextColor(@NonNull ColorStateList prefixTextColor) {
        this.f1969a.p(prefixTextColor);
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f1969a.b();
    }

    public void setPrefixTextAppearance(@StyleRes int prefixTextAppearance) {
        this.f1969a.o(prefixTextAppearance);
    }

    public void setSuffixText(@Nullable CharSequence suffixText) {
        this.f1967a.p0(suffixText);
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f1967a.w();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f1967a.z();
    }

    public void setSuffixTextColor(@NonNull ColorStateList suffixTextColor) {
        this.f1967a.r0(suffixTextColor);
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f1967a.x();
    }

    public void setSuffixTextAppearance(@StyleRes int suffixTextAppearance) {
        this.f1967a.q0(suffixTextAppearance);
    }

    public void setEnabled(boolean enabled) {
        Y(this, enabled);
        super.setEnabled(enabled);
    }

    private static void Y(ViewGroup vg, boolean enabled) {
        int count = vg.getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            View child = vg.getChildAt(i2);
            child.setEnabled(enabled);
            if (child instanceof ViewGroup) {
                Y((ViewGroup) child, enabled);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f1975a || !this.f1983b || (textView = this.f1964a) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    private void m0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f1964a;
        if (textView != null) {
            c0(textView, this.f1983b ? this.f : this.g);
            if (!this.f1983b && (colorStateList2 = this.f1976b) != null) {
                this.f1964a.setTextColor(colorStateList2);
            }
            if (this.f1983b && (colorStateList = this.f1984c) != null) {
                this.f1964a.setTextColor(colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(TextView textView, int textAppearance) {
        boolean useDefaultColor = false;
        try {
            TextViewCompat.setTextAppearance(textView, textAppearance);
            if (Build.VERSION.SDK_INT >= 23 && textView.getTextColors().getDefaultColor() == -65281) {
                useDefaultColor = true;
            }
        } catch (Exception e2) {
            useDefaultColor = true;
        }
        if (useDefaultColor) {
            TextViewCompat.setTextAppearance(textView, uc0.b);
            textView.setTextColor(ContextCompat.getColor(getContext(), zb0.design_error));
        }
    }

    private int v() {
        if (!this.f1991d) {
            return 0;
        }
        switch (this.j) {
            case 0:
                return (int) this.f1970a.r();
            case 2:
                return (int) (this.f1970a.r() / 2.0f);
            default:
                return 0;
        }
    }

    private Rect r(Rect rect) {
        if (this.f1962a != null) {
            Rect bounds = this.f1977b;
            boolean isRtl = lv0.g(this);
            bounds.bottom = rect.bottom;
            switch (this.j) {
                case 1:
                    bounds.left = I(rect.left, isRtl);
                    bounds.top = rect.top + this.k;
                    bounds.right = J(rect.right, isRtl);
                    return bounds;
                case 2:
                    bounds.left = rect.left + this.f1962a.getPaddingLeft();
                    bounds.top = rect.top - v();
                    bounds.right = rect.right - this.f1962a.getPaddingRight();
                    return bounds;
                default:
                    bounds.left = I(rect.left, isRtl);
                    bounds.top = getPaddingTop();
                    bounds.right = J(rect.right, isRtl);
                    return bounds;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private int I(int rectLeft, boolean isRtl) {
        if (!isRtl && getPrefixText() != null) {
            return this.f1969a.c() + rectLeft;
        }
        if (!isRtl || getSuffixText() == null) {
            return this.f1962a.getCompoundPaddingLeft() + rectLeft;
        }
        return this.f1967a.y() + rectLeft;
    }

    private int J(int rectRight, boolean isRtl) {
        if (!isRtl && getSuffixText() != null) {
            return rectRight - this.f1967a.y();
        }
        if (!isRtl || getPrefixText() == null) {
            return rectRight - this.f1962a.getCompoundPaddingRight();
        }
        return rectRight - this.f1969a.c();
    }

    private Rect u(Rect rect) {
        if (this.f1962a != null) {
            Rect bounds = this.f1977b;
            float labelHeight = this.f1970a.C();
            bounds.left = rect.left + this.f1962a.getCompoundPaddingLeft();
            bounds.top = t(rect, labelHeight);
            bounds.right = rect.right - this.f1962a.getCompoundPaddingRight();
            bounds.bottom = s(rect, bounds, labelHeight);
            return bounds;
        }
        throw new IllegalStateException();
    }

    private int t(Rect rect, float labelHeight) {
        if (S()) {
            return (int) (((float) rect.centerY()) - (labelHeight / 2.0f));
        }
        return rect.top + this.f1962a.getCompoundPaddingTop();
    }

    private int s(Rect rect, Rect bounds, float labelHeight) {
        if (S()) {
            return (int) (((float) bounds.top) + labelHeight);
        }
        return rect.bottom - this.f1962a.getCompoundPaddingBottom();
    }

    private boolean S() {
        if (this.j != 1 || (Build.VERSION.SDK_INT >= 16 && this.f1962a.getMinLines() > 1)) {
            return false;
        }
        return true;
    }

    private int q() {
        int backgroundColor = this.p;
        if (this.j == 1) {
            return k00.j(k00.e(this, yb0.colorSurface, 0), this.p);
        }
        return backgroundColor;
    }

    private void m() {
        p00 p00 = this.f1974a;
        if (p00 != null) {
            il0 B = p00.B();
            il0 il0 = this.f1971a;
            if (B != il0) {
                this.f1974a.setShapeAppearanceModel(il0);
            }
            if (w()) {
                this.f1974a.b0((float) this.l, this.o);
            }
            int q2 = q();
            this.p = q2;
            this.f1974a.V(ColorStateList.valueOf(q2));
            n();
            r0();
        }
    }

    private void n() {
        ColorStateList colorStateList;
        if (this.f1987c != null && this.f1990d != null) {
            if (x()) {
                p00 p00 = this.f1987c;
                if (this.f1962a.isFocused()) {
                    colorStateList = ColorStateList.valueOf(this.s);
                } else {
                    colorStateList = ColorStateList.valueOf(this.o);
                }
                p00.V(colorStateList);
                this.f1990d.V(ColorStateList.valueOf(this.o));
            }
            invalidate();
        }
    }

    private boolean w() {
        return this.j == 2 && x();
    }

    private boolean x() {
        return this.l > -1 && this.o != 0;
    }

    /* access modifiers changed from: package-private */
    public void p0() {
        Drawable editTextBackground;
        TextView textView;
        EditText editText = this.f1962a;
        if (editText != null && this.j == 0 && (editTextBackground = editText.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(editTextBackground)) {
                editTextBackground = editTextBackground.mutate();
            }
            if (d0()) {
                editTextBackground.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f1983b || (textView = this.f1964a) == null) {
                DrawableCompat.clearColorFilter(editTextBackground);
                this.f1962a.refreshDrawableState();
            } else {
                editTextBackground.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d0() {
        return this.f1968a.l();
    }

    static class h extends AbsSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();
        CharSequence a;

        /* renamed from: a  reason: collision with other field name */
        boolean f2005a;

        h(Parcelable superState) {
            super(superState);
        }

        h(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            this.f2005a = source.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            TextUtils.writeToParcel(this.a, dest, flags);
            dest.writeInt(this.f2005a ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.a + "}";
        }

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            /* renamed from: b */
            public h createFromParcel(Parcel in, ClassLoader loader) {
                return new h(in, loader);
            }

            /* renamed from: a */
            public h createFromParcel(Parcel in) {
                return new h(in, (ClassLoader) null);
            }

            /* renamed from: c */
            public h[] newArray(int size) {
                return new h[size];
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        h ss = new h(super.onSaveInstanceState());
        if (d0()) {
            ss.a = getError();
        }
        ss.f2005a = this.f1967a.E();
        return ss;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof h)) {
            super.onRestoreInstanceState(state);
            return;
        }
        h ss = (h) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setError(ss.a);
        if (ss.f2005a) {
            post(new b());
        }
        requestLayout();
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TextInputLayout.this.f1967a.h();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        this.f2003l = true;
        super.dispatchRestoreInstanceState(container);
        this.f2003l = false;
    }

    @Nullable
    public CharSequence getError() {
        if (this.f1968a.A()) {
            return this.f1968a.p();
        }
        return null;
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f1968a.B()) {
            return this.f1968a.s();
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean enabled) {
        this.f2001j = enabled;
    }

    public void setExpandedHintEnabled(boolean enabled) {
        if (this.f2000i != enabled) {
            this.f2000i = enabled;
            u0(false);
        }
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        boolean isLayoutDirectionRtl = true;
        if (layoutDirection != 1) {
            isLayoutDirectionRtl = false;
        }
        if (isLayoutDirectionRtl != this.f1997g) {
            float boxCornerRadiusTopLeft = this.f1971a.r().a(this.f1958a);
            float boxCornerRadiusTopRight = this.f1971a.t().a(this.f1958a);
            float boxCornerRadiusBottomLeft = this.f1971a.j().a(this.f1958a);
            float boxCornerRadiusBottomRight = this.f1971a.l().a(this.f1958a);
            xc topLeftTreatment = this.f1971a.q();
            xc topRightTreatment = this.f1971a.s();
            il0 newShapeAppearanceModel = il0.a().z(topRightTreatment).D(topLeftTreatment).r(this.f1971a.k()).v(this.f1971a.i()).A(boxCornerRadiusTopRight).E(boxCornerRadiusTopLeft).s(boxCornerRadiusBottomRight).w(boxCornerRadiusBottomLeft).m();
            this.f1997g = isLayoutDirectionRtl;
            setShapeAppearanceModel(newShapeAppearanceModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.f2004m) {
            this.f1967a.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f2004m = true;
        }
        w0();
        this.f1967a.x0();
    }

    private boolean s0() {
        int maxIconHeight;
        if (this.f1962a == null || this.f1962a.getMeasuredHeight() >= (maxIconHeight = Math.max(this.f1967a.getMeasuredHeight(), this.f1969a.getMeasuredHeight()))) {
            return false;
        }
        this.f1962a.setMinimumHeight(maxIconHeight);
        return true;
    }

    private void w0() {
        EditText editText;
        if (this.f1979b != null && (editText = this.f1962a) != null) {
            this.f1979b.setGravity(editText.getGravity());
            this.f1979b.setPadding(this.f1962a.getCompoundPaddingLeft(), this.f1962a.getCompoundPaddingTop(), this.f1962a.getCompoundPaddingRight(), this.f1962a.getCompoundPaddingBottom());
        }
    }

    public void setStartIconDrawable(@DrawableRes int resId) {
        setStartIconDrawable(resId != 0 ? AppCompatResources.getDrawable(getContext(), resId) : null);
    }

    public void setStartIconDrawable(@Nullable Drawable startIconDrawable) {
        this.f1969a.s(startIconDrawable);
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f1969a.f();
    }

    public void setStartIconMinSize(@IntRange(from = 0) int iconSize) {
        this.f1969a.t(iconSize);
    }

    public int getStartIconMinSize() {
        return this.f1969a.g();
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener startIconOnClickListener) {
        this.f1969a.u(startIconOnClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener startIconOnLongClickListener) {
        this.f1969a.v(startIconOnLongClickListener);
    }

    public void setStartIconVisible(boolean visible) {
        this.f1969a.z(visible);
    }

    public void Z() {
        this.f1969a.m();
    }

    public void setStartIconCheckable(boolean startIconCheckable) {
        this.f1969a.q(startIconCheckable);
    }

    public void setStartIconContentDescription(@StringRes int resId) {
        setStartIconContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setStartIconContentDescription(@Nullable CharSequence startIconContentDescription) {
        this.f1969a.r(startIconContentDescription);
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f1969a.e();
    }

    public void setStartIconTintList(@Nullable ColorStateList startIconTintList) {
        this.f1969a.x(startIconTintList);
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode startIconTintMode) {
        this.f1969a.y(startIconTintMode);
    }

    public void setEndIconMode(int endIconMode) {
        this.f1967a.U(endIconMode);
    }

    public int getEndIconMode() {
        return this.f1967a.p();
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener endIconOnClickListener) {
        this.f1967a.V(endIconOnClickListener);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener errorIconOnClickListener) {
        this.f1967a.d0(errorIconOnClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener endIconOnLongClickListener) {
        this.f1967a.W(endIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener errorIconOnLongClickListener) {
        this.f1967a.e0(errorIconOnLongClickListener);
    }

    public void setEndIconVisible(boolean visible) {
        this.f1967a.a0(visible);
    }

    public boolean M() {
        return this.f1967a.F();
    }

    public void setEndIconActivated(boolean endIconActivated) {
        this.f1967a.N(endIconActivated);
    }

    public void setEndIconCheckable(boolean endIconCheckable) {
        this.f1967a.O(endIconCheckable);
    }

    public void setEndIconDrawable(@DrawableRes int resId) {
        this.f1967a.R(resId);
    }

    public void setEndIconDrawable(@Nullable Drawable endIconDrawable) {
        this.f1967a.S(endIconDrawable);
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f1967a.n();
    }

    public void setEndIconMinSize(@IntRange(from = 0) int iconSize) {
        this.f1967a.T(iconSize);
    }

    public int getEndIconMinSize() {
        return this.f1967a.o();
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f1969a.w(scaleType);
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f1969a.h();
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f1967a.X(scaleType);
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f1967a.q();
    }

    public void setEndIconContentDescription(@StringRes int resId) {
        this.f1967a.P(resId);
    }

    public void setEndIconContentDescription(@Nullable CharSequence endIconContentDescription) {
        this.f1967a.Q(endIconContentDescription);
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f1967a.l();
    }

    public void setEndIconTintList(@Nullable ColorStateList endIconTintList) {
        this.f1967a.Y(endIconTintList);
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode endIconTintMode) {
        this.f1967a.Z(endIconTintMode);
    }

    public void i(f listener) {
        this.f1973a.add(listener);
        if (this.f1962a != null) {
            listener.a(this);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int resId) {
        this.f1967a.k0(resId);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable icon) {
        this.f1967a.l0(icon);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int resId) {
        this.f1967a.i0(resId);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence description) {
        this.f1967a.j0(description);
    }

    @Deprecated
    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f1967a.v();
    }

    @Deprecated
    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f1967a.u();
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean enabled) {
        this.f1967a.m0(enabled);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList tintList) {
        this.f1967a.n0(tintList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.f1967a.o0(mode);
    }

    public void setTextInputAccessibilityDelegate(@Nullable d delegate) {
        EditText editText = this.f1962a;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, delegate);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f1967a.r();
    }

    private void C() {
        Iterator it = this.f1973a.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean o0() {
        if (this.f1962a == null) {
            return false;
        }
        boolean updatedIcon = false;
        if (f0()) {
            int right = this.f1969a.getMeasuredWidth() - this.f1962a.getPaddingLeft();
            if (this.f1960a == null || this.q != right) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f1960a = colorDrawable;
                this.q = right;
                colorDrawable.setBounds(0, 0, right, 1);
            }
            Drawable[] compounds = TextViewCompat.getCompoundDrawablesRelative(this.f1962a);
            Drawable drawable = compounds[0];
            Drawable drawable2 = this.f1960a;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f1962a, drawable2, compounds[1], compounds[2], compounds[3]);
                updatedIcon = true;
            }
        } else if (this.f1960a != null) {
            Drawable[] compounds2 = TextViewCompat.getCompoundDrawablesRelative(this.f1962a);
            TextViewCompat.setCompoundDrawablesRelative(this.f1962a, (Drawable) null, compounds2[1], compounds2[2], compounds2[3]);
            this.f1960a = null;
            updatedIcon = true;
        }
        if (e0()) {
            int right2 = this.f1967a.z().getMeasuredWidth() - this.f1962a.getPaddingRight();
            View iconView = this.f1967a.k();
            if (iconView != null) {
                right2 = iconView.getMeasuredWidth() + right2 + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) iconView.getLayoutParams());
            }
            Drawable[] compounds3 = TextViewCompat.getCompoundDrawablesRelative(this.f1962a);
            Drawable drawable3 = this.f1978b;
            if (drawable3 == null || this.r == right2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f1978b = colorDrawable2;
                    this.r = right2;
                    colorDrawable2.setBounds(0, 0, right2, 1);
                }
                Drawable drawable4 = compounds3[2];
                Drawable drawable5 = this.f1978b;
                if (drawable4 == drawable5) {
                    return updatedIcon;
                }
                this.f1985c = compounds3[2];
                TextViewCompat.setCompoundDrawablesRelative(this.f1962a, compounds3[0], compounds3[1], drawable5, compounds3[3]);
                return true;
            }
            this.r = right2;
            drawable3.setBounds(0, 0, right2, 1);
            TextViewCompat.setCompoundDrawablesRelative(this.f1962a, compounds3[0], compounds3[1], this.f1978b, compounds3[3]);
            return true;
        } else if (this.f1978b == null) {
            return updatedIcon;
        } else {
            Drawable[] compounds4 = TextViewCompat.getCompoundDrawablesRelative(this.f1962a);
            if (compounds4[2] == this.f1978b) {
                TextViewCompat.setCompoundDrawablesRelative(this.f1962a, compounds4[0], compounds4[1], this.f1985c, compounds4[3]);
                updatedIcon = true;
            }
            this.f1978b = null;
            return updatedIcon;
        }
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f1969a.getMeasuredWidth() > 0;
    }

    private boolean e0() {
        return (this.f1967a.G() || ((this.f1967a.A() && M()) || this.f1967a.w() != null)) && this.f1967a.getMeasuredWidth() > 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        EditText editText = this.f1962a;
        if (editText != null) {
            Rect rect = this.f1957a;
            fg.a(this, editText, rect);
            i0(rect);
            if (this.f1991d) {
                this.f1970a.v0(this.f1962a.getTextSize());
                int editTextGravity = this.f1962a.getGravity();
                this.f1970a.j0((editTextGravity & -113) | 48);
                this.f1970a.u0(editTextGravity);
                this.f1970a.f0(r(rect));
                this.f1970a.p0(u(rect));
                this.f1970a.a0();
                if (B() && !this.f1999h) {
                    W();
                }
            }
        }
    }

    private void i0(Rect bounds) {
        p00 p00 = this.f1987c;
        if (p00 != null) {
            int i2 = bounds.bottom;
            p00.setBounds(bounds.left, i2 - this.m, bounds.right, i2);
        }
        p00 p002 = this.f1990d;
        if (p002 != null) {
            int i3 = bounds.bottom;
            p002.setBounds(bounds.left, i3 - this.n, bounds.right, i3);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f1970a.Y(newConfig);
    }

    private void E(Canvas canvas) {
        if (this.f1991d) {
            this.f1970a.l(canvas);
        }
    }

    private void D(Canvas canvas) {
        p00 p00;
        if (this.f1990d != null && (p00 = this.f1987c) != null) {
            p00.draw(canvas);
            if (this.f1962a.isFocused()) {
                Rect focusedUnderlineBounds = this.f1990d.getBounds();
                Rect defaultUnderlineBounds = this.f1987c.getBounds();
                float hintExpansionFraction = this.f1970a.F();
                int midpointX = defaultUnderlineBounds.centerX();
                focusedUnderlineBounds.left = f3.c(midpointX, defaultUnderlineBounds.left, hintExpansionFraction);
                focusedUnderlineBounds.right = f3.c(midpointX, defaultUnderlineBounds.right, hintExpansionFraction);
                this.f1990d.draw(canvas);
            }
        }
    }

    private void z(boolean animate) {
        ValueAnimator valueAnimator = this.f1955a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f1955a.cancel();
        }
        if (!animate || !this.f2001j) {
            this.f1970a.y0(1.0f);
        } else {
            l(1.0f);
        }
        this.f1999h = false;
        if (B()) {
            W();
        }
        x0();
        this.f1969a.l(false);
        this.f1967a.H(false);
    }

    private boolean B() {
        return this.f1991d && !TextUtils.isEmpty(this.f1986c) && (this.f1974a instanceof h);
    }

    private void W() {
        if (B()) {
            RectF cutoutBounds = this.f1958a;
            this.f1970a.o(cutoutBounds, this.f1962a.getWidth(), this.f1962a.getGravity());
            if (cutoutBounds.width() > 0.0f && cutoutBounds.height() > 0.0f) {
                o(cutoutBounds);
                cutoutBounds.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (cutoutBounds.height() / 2.0f)) + ((float) this.l));
                ((h) this.f1974a).o0(cutoutBounds);
            }
        }
    }

    private void X() {
        if (B() && !this.f1999h) {
            y();
            W();
        }
    }

    private void y() {
        if (B()) {
            ((h) this.f1974a).m0();
        }
    }

    private void o(RectF cutoutBounds) {
        float f2 = cutoutBounds.left;
        int i2 = this.i;
        cutoutBounds.left = f2 - ((float) i2);
        cutoutBounds.right += (float) i2;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.f2002k) {
            boolean z2 = true;
            this.f2002k = true;
            super.drawableStateChanged();
            int[] state = getDrawableState();
            boolean changed = false;
            g9 g9Var = this.f1970a;
            if (g9Var != null) {
                changed = false | g9Var.I0(state);
            }
            if (this.f1962a != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z2 = false;
                }
                u0(z2);
            }
            p0();
            A0();
            if (changed) {
                invalidate();
            }
            this.f2002k = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r5.f1962a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void A0() {
        /*
            r5 = this;
            p00 r0 = r5.f1974a
            if (r0 == 0) goto L_0x00d1
            int r0 = r5.j
            if (r0 != 0) goto L_0x000a
            goto L_0x00d1
        L_0x000a:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r5.f1962a
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L_0x0030
            android.widget.EditText r3 = r5.f1962a
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            boolean r3 = r5.isEnabled()
            if (r3 != 0) goto L_0x003c
            int r3 = r5.z
            r5.o = r3
            goto L_0x007a
        L_0x003c:
            boolean r3 = r5.d0()
            if (r3 == 0) goto L_0x0051
            android.content.res.ColorStateList r3 = r5.f1998h
            if (r3 == 0) goto L_0x004a
            r5.z0(r0, r1)
            goto L_0x007a
        L_0x004a:
            int r3 = r5.getErrorCurrentTextColors()
            r5.o = r3
            goto L_0x007a
        L_0x0051:
            boolean r3 = r5.f1983b
            if (r3 == 0) goto L_0x0068
            android.widget.TextView r3 = r5.f1964a
            if (r3 == 0) goto L_0x0068
            android.content.res.ColorStateList r4 = r5.f1998h
            if (r4 == 0) goto L_0x0061
            r5.z0(r0, r1)
            goto L_0x007a
        L_0x0061:
            int r3 = r3.getCurrentTextColor()
            r5.o = r3
            goto L_0x007a
        L_0x0068:
            if (r0 == 0) goto L_0x006f
            int r3 = r5.u
            r5.o = r3
            goto L_0x007a
        L_0x006f:
            if (r1 == 0) goto L_0x0076
            int r3 = r5.t
            r5.o = r3
            goto L_0x007a
        L_0x0076:
            int r3 = r5.s
            r5.o = r3
        L_0x007a:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 29
            if (r3 < r4) goto L_0x0083
            r5.n0()
        L_0x0083:
            com.google.android.material.textfield.r r3 = r5.f1967a
            r3.I()
            r5.Z()
            int r3 = r5.j
            r4 = 2
            if (r3 != r4) goto L_0x00aa
            int r3 = r5.l
            if (r0 == 0) goto L_0x009f
            boolean r4 = r5.isEnabled()
            if (r4 == 0) goto L_0x009f
            int r4 = r5.n
            r5.l = r4
            goto L_0x00a3
        L_0x009f:
            int r4 = r5.m
            r5.l = r4
        L_0x00a3:
            int r4 = r5.l
            if (r4 == r3) goto L_0x00aa
            r5.X()
        L_0x00aa:
            int r3 = r5.j
            if (r3 != r2) goto L_0x00cd
            boolean r2 = r5.isEnabled()
            if (r2 != 0) goto L_0x00b9
            int r2 = r5.w
            r5.p = r2
            goto L_0x00cd
        L_0x00b9:
            if (r1 == 0) goto L_0x00c2
            if (r0 != 0) goto L_0x00c2
            int r2 = r5.y
            r5.p = r2
            goto L_0x00cd
        L_0x00c2:
            if (r0 == 0) goto L_0x00c9
            int r2 = r5.x
            r5.p = r2
            goto L_0x00cd
        L_0x00c9:
            int r2 = r5.v
            r5.p = r2
        L_0x00cd:
            r5.m()
            return
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.A0():void");
    }

    private boolean Q() {
        return d0() || (this.f1964a != null && this.f1983b);
    }

    private void z0(boolean hasFocus, boolean isHovered) {
        int defaultStrokeErrorColor = this.f1998h.getDefaultColor();
        int hoveredStrokeErrorColor = this.f1998h.getColorForState(new int[]{16843623, 16842910}, defaultStrokeErrorColor);
        int focusedStrokeErrorColor = this.f1998h.getColorForState(new int[]{16843518, 16842910}, defaultStrokeErrorColor);
        if (hasFocus) {
            this.o = focusedStrokeErrorColor;
        } else if (isHovered) {
            this.o = hoveredStrokeErrorColor;
        } else {
            this.o = defaultStrokeErrorColor;
        }
    }

    private void n0() {
        ColorStateList color = this.f1989d;
        if (color == null) {
            color = k00.h(getContext(), yb0.h);
        }
        EditText editText = this.f1962a;
        if (editText != null && editText.getTextCursorDrawable() != null) {
            Drawable cursorDrawable = DrawableCompat.wrap(this.f1962a.getTextCursorDrawable()).mutate();
            if (Q() && this.f1992e != null) {
                color = this.f1992e;
            }
            DrawableCompat.setTintList(cursorDrawable, color);
        }
    }

    private void F(boolean animate) {
        ValueAnimator valueAnimator = this.f1955a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f1955a.cancel();
        }
        if (!animate || !this.f2001j) {
            this.f1970a.y0(0.0f);
        } else {
            l(0.0f);
        }
        if (B() && ((h) this.f1974a).l0()) {
            y();
        }
        this.f1999h = true;
        L();
        this.f1969a.l(true);
        this.f1967a.H(true);
    }

    /* access modifiers changed from: package-private */
    public void l(float target) {
        if (this.f1970a.F() != target) {
            if (this.f1955a == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f1955a = valueAnimator;
                valueAnimator.setInterpolator(i20.g(getContext(), yb0.motionEasingEmphasizedInterpolator, f3.b));
                this.f1955a.setDuration((long) i20.f(getContext(), yb0.motionDurationMedium4, 167));
                this.f1955a.addUpdateListener(new c());
            }
            this.f1955a.setFloatValues(new float[]{this.f1970a.F(), target});
            this.f1955a.start();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        public void onAnimationUpdate(ValueAnimator animator) {
            TextInputLayout.this.f1970a.y0(((Float) animator.getAnimatedValue()).floatValue());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean P() {
        return this.f1999h;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.f1970a.w();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.f1970a.r();
    }

    public static class d extends AccessibilityDelegateCompat {
        private final TextInputLayout a;

        public d(TextInputLayout layout) {
            this.a = layout;
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            String hint;
            View helperTextView;
            String text;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = info;
            super.onInitializeAccessibilityNodeInfo(host, info);
            EditText editText = this.a.getEditText();
            CharSequence inputText = editText != null ? editText.getText() : null;
            CharSequence hintText = this.a.getHint();
            CharSequence errorText = this.a.getError();
            CharSequence placeholderText = this.a.getPlaceholderText();
            int maxCharLimit = this.a.getCounterMaxLength();
            CharSequence counterOverflowDesc = this.a.getCounterOverflowDescription();
            boolean showingText = !TextUtils.isEmpty(inputText);
            boolean hasHint = !TextUtils.isEmpty(hintText);
            boolean isHintCollapsed = !this.a.P();
            boolean showingError = !TextUtils.isEmpty(errorText);
            boolean contentInvalid = showingError || !TextUtils.isEmpty(counterOverflowDesc);
            String hint2 = hasHint ? hintText.toString() : "";
            this.a.f1969a.A(accessibilityNodeInfoCompat);
            if (showingText) {
                accessibilityNodeInfoCompat.setText(inputText);
                hint = hint2;
                EditText editText2 = editText;
            } else if (!TextUtils.isEmpty(hint2)) {
                hint = hint2;
                accessibilityNodeInfoCompat.setText(hint);
                if (!isHintCollapsed || placeholderText == null) {
                } else {
                    EditText editText3 = editText;
                    accessibilityNodeInfoCompat.setText(hint + ", " + placeholderText);
                }
            } else {
                hint = hint2;
                EditText editText4 = editText;
                if (placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(placeholderText);
                }
            }
            if (!TextUtils.isEmpty(hint)) {
                CharSequence charSequence = hintText;
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(hint);
                } else {
                    if (showingText) {
                        text = inputText + ", " + hint;
                    } else {
                        text = hint;
                    }
                    accessibilityNodeInfoCompat.setText(text);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!showingText);
            }
            accessibilityNodeInfoCompat.setMaxTextLength((inputText == null || inputText.length() != maxCharLimit) ? -1 : maxCharLimit);
            if (contentInvalid) {
                accessibilityNodeInfoCompat.setError(showingError ? errorText : counterOverflowDesc);
            }
            if (Build.VERSION.SDK_INT >= 17 && (helperTextView = this.a.f1968a.t()) != null) {
                accessibilityNodeInfoCompat.setLabelFor(helperTextView);
            }
            this.a.f1967a.m().o(host, accessibilityNodeInfoCompat);
        }

        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onPopulateAccessibilityEvent(host, event);
            this.a.f1967a.m().p(host, event);
        }
    }
}
