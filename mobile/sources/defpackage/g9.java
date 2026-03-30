package defpackage;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import defpackage.an0;
import defpackage.q7;

/* renamed from: g9  reason: default package */
public final class g9 {
    private static final Paint b = null;
    private static final boolean f = (Build.VERSION.SDK_INT < 18);
    private float A;
    private float B;
    private float C = 0.0f;
    private float D = 1.0f;
    private float a;

    /* renamed from: a  reason: collision with other field name */
    private int f3019a;

    /* renamed from: a  reason: collision with other field name */
    private TimeInterpolator f3020a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f3021a;

    /* renamed from: a  reason: collision with other field name */
    private Bitmap f3022a;

    /* renamed from: a  reason: collision with other field name */
    private Paint f3023a;

    /* renamed from: a  reason: collision with other field name */
    private final Rect f3024a;

    /* renamed from: a  reason: collision with other field name */
    private final RectF f3025a;

    /* renamed from: a  reason: collision with other field name */
    private Typeface f3026a;

    /* renamed from: a  reason: collision with other field name */
    private StaticLayout f3027a;

    /* renamed from: a  reason: collision with other field name */
    private final TextPaint f3028a;

    /* renamed from: a  reason: collision with other field name */
    private TextUtils.TruncateAt f3029a = TextUtils.TruncateAt.END;

    /* renamed from: a  reason: collision with other field name */
    private final View f3030a;

    /* renamed from: a  reason: collision with other field name */
    private bn0 f3031a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f3032a;

    /* renamed from: a  reason: collision with other field name */
    private q7 f3033a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f3034a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f3035a;

    /* renamed from: b  reason: collision with other field name */
    private float f3036b;

    /* renamed from: b  reason: collision with other field name */
    private int f3037b = 16;

    /* renamed from: b  reason: collision with other field name */
    private TimeInterpolator f3038b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f3039b;

    /* renamed from: b  reason: collision with other field name */
    private final Rect f3040b;

    /* renamed from: b  reason: collision with other field name */
    private Typeface f3041b;

    /* renamed from: b  reason: collision with other field name */
    private final TextPaint f3042b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f3043b;

    /* renamed from: b  reason: collision with other field name */
    private q7 f3044b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f3045b;
    private float c;

    /* renamed from: c  reason: collision with other field name */
    private int f3046c = 16;

    /* renamed from: c  reason: collision with other field name */
    private ColorStateList f3047c;

    /* renamed from: c  reason: collision with other field name */
    private Typeface f3048c;

    /* renamed from: c  reason: collision with other field name */
    private CharSequence f3049c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f3050c = true;
    private float d = 15.0f;

    /* renamed from: d  reason: collision with other field name */
    private int f3051d;

    /* renamed from: d  reason: collision with other field name */
    private ColorStateList f3052d;

    /* renamed from: d  reason: collision with other field name */
    private Typeface f3053d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f3054d;
    private float e = 15.0f;

    /* renamed from: e  reason: collision with other field name */
    private int f3055e;

    /* renamed from: e  reason: collision with other field name */
    private Typeface f3056e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f3057e;

    /* renamed from: f  reason: collision with other field name */
    private float f3058f;

    /* renamed from: f  reason: collision with other field name */
    private int f3059f = 1;

    /* renamed from: f  reason: collision with other field name */
    private Typeface f3060f;
    private float g;

    /* renamed from: g  reason: collision with other field name */
    private int f3061g = an0.f;

    /* renamed from: g  reason: collision with other field name */
    private Typeface f3062g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public g9(View view) {
        this.f3030a = view;
        TextPaint textPaint = new TextPaint(129);
        this.f3028a = textPaint;
        this.f3042b = new TextPaint(textPaint);
        this.f3040b = new Rect();
        this.f3024a = new Rect();
        this.f3025a = new RectF();
        this.c = e();
        Y(view.getContext().getResources().getConfiguration());
    }

    public void L0(TimeInterpolator interpolator) {
        this.f3038b = interpolator;
        a0();
    }

    public void G0(TimeInterpolator interpolator) {
        this.f3020a = interpolator;
        a0();
    }

    public TimeInterpolator N() {
        return this.f3020a;
    }

    public void v0(float textSize) {
        if (this.d != textSize) {
            this.d = textSize;
            a0();
        }
    }

    public void k0(float textSize) {
        if (this.e != textSize) {
            this.e = textSize;
            a0();
        }
    }

    public void i0(ColorStateList textColor) {
        if (this.f3039b != textColor) {
            this.f3039b = textColor;
            a0();
        }
    }

    public void t0(ColorStateList textColor) {
        if (this.f3021a != textColor) {
            this.f3021a = textColor;
            a0();
        }
    }

    public void d0(ColorStateList textColor) {
        if (this.f3039b != textColor || this.f3021a != textColor) {
            this.f3039b = textColor;
            this.f3021a = textColor;
            a0();
        }
    }

    public void q0(float letterSpacing) {
        if (this.x != letterSpacing) {
            this.x = letterSpacing;
            a0();
        }
    }

    public void o0(int left, int top, int right, int bottom) {
        if (!c0(this.f3024a, left, top, right, bottom)) {
            this.f3024a.set(left, top, right, bottom);
            this.f3057e = true;
        }
    }

    public void p0(Rect bounds) {
        o0(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void e0(int left, int top, int right, int bottom) {
        if (!c0(this.f3040b, left, top, right, bottom)) {
            this.f3040b.set(left, top, right, bottom);
            this.f3057e = true;
        }
    }

    public void f0(Rect bounds) {
        e0(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    public void o(RectF bounds, int labelWidth, int textGravity) {
        this.f3045b = f(this.f3032a);
        bounds.left = Math.max(s(labelWidth, textGravity), (float) this.f3040b.left);
        bounds.top = (float) this.f3040b.top;
        bounds.right = Math.min(t(bounds, labelWidth, textGravity), (float) this.f3040b.right);
        bounds.bottom = ((float) this.f3040b.top) + r();
    }

    private float s(int width, int gravity) {
        if (gravity == 17 || (gravity & 7) == 1) {
            return (((float) width) / 2.0f) - (this.z / 2.0f);
        }
        return ((gravity & GravityCompat.END) == 8388613 || (gravity & 5) == 5) ? this.f3045b ? (float) this.f3040b.left : ((float) this.f3040b.right) - this.z : this.f3045b ? ((float) this.f3040b.right) - this.z : (float) this.f3040b.left;
    }

    private float t(RectF bounds, int width, int gravity) {
        if (gravity == 17 || (gravity & 7) == 1) {
            return (((float) width) / 2.0f) + (this.z / 2.0f);
        }
        return ((gravity & GravityCompat.END) == 8388613 || (gravity & 5) == 5) ? this.f3045b ? bounds.left + this.z : (float) this.f3040b.right : this.f3045b ? (float) this.f3040b.right : bounds.left + this.z;
    }

    public float C() {
        Q(this.f3042b);
        return -this.f3042b.ascent();
    }

    public float A() {
        Q(this.f3042b);
        return (-this.f3042b.ascent()) + this.f3042b.descent();
    }

    public float r() {
        P(this.f3042b);
        return -this.f3042b.ascent();
    }

    public void n0(int currentOffsetY) {
        this.f3019a = currentOffsetY;
    }

    public void A0(float fadeModeStartFraction) {
        this.f3036b = fadeModeStartFraction;
        this.c = e();
    }

    private float e() {
        float f2 = this.f3036b;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    public void z0(boolean fadeModeEnabled) {
        this.f3034a = fadeModeEnabled;
    }

    private void Q(TextPaint textPaint) {
        textPaint.setTextSize(this.d);
        textPaint.setTypeface(this.f3053d);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.x);
        }
    }

    private void P(TextPaint textPaint) {
        textPaint.setTextSize(this.e);
        textPaint.setTypeface(this.f3026a);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.w);
        }
    }

    public void u0(int gravity) {
        if (this.f3037b != gravity) {
            this.f3037b = gravity;
            a0();
        }
    }

    public int B() {
        return this.f3037b;
    }

    public void j0(int gravity) {
        if (this.f3046c != gravity) {
            this.f3046c = gravity;
            a0();
        }
    }

    public int q() {
        return this.f3046c;
    }

    public void g0(int resId) {
        oq0 textAppearance = new oq0(this.f3030a.getContext(), resId);
        if (textAppearance.i() != null) {
            this.f3039b = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.e = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f4582c;
        if (colorStateList != null) {
            this.f3047c = colorStateList;
        }
        this.r = textAppearance.a;
        this.s = textAppearance.b;
        this.q = textAppearance.c;
        this.w = textAppearance.d;
        q7 q7Var = this.f3044b;
        if (q7Var != null) {
            q7Var.c();
        }
        this.f3044b = new q7(new a(), textAppearance.e());
        textAppearance.g(this.f3030a.getContext(), this.f3044b);
        a0();
    }

    /* renamed from: g9$a */
    class a implements q7.a {
        a() {
        }

        public void a(Typeface font) {
            g9.this.l0(font);
        }
    }

    public void r0(int resId) {
        oq0 textAppearance = new oq0(this.f3030a.getContext(), resId);
        if (textAppearance.i() != null) {
            this.f3021a = textAppearance.i();
        }
        if (textAppearance.j() != 0.0f) {
            this.d = textAppearance.j();
        }
        ColorStateList colorStateList = textAppearance.f4582c;
        if (colorStateList != null) {
            this.f3052d = colorStateList;
        }
        this.u = textAppearance.a;
        this.v = textAppearance.b;
        this.t = textAppearance.c;
        this.x = textAppearance.d;
        q7 q7Var = this.f3033a;
        if (q7Var != null) {
            q7Var.c();
        }
        this.f3033a = new q7(new b(), textAppearance.e());
        textAppearance.g(this.f3030a.getContext(), this.f3033a);
        a0();
    }

    /* renamed from: g9$b */
    class b implements q7.a {
        b() {
        }

        public void a(Typeface font) {
            g9.this.w0(font);
        }
    }

    public void M0(TextUtils.TruncateAt ellipsize) {
        this.f3029a = ellipsize;
        a0();
    }

    public TextUtils.TruncateAt R() {
        return this.f3029a;
    }

    public void l0(Typeface typeface) {
        if (m0(typeface)) {
            a0();
        }
    }

    public void w0(Typeface typeface) {
        if (x0(typeface)) {
            a0();
        }
    }

    public void N0(Typeface typeface) {
        boolean collapsedFontChanged = m0(typeface);
        boolean expandedFontChanged = x0(typeface);
        if (collapsedFontChanged || expandedFontChanged) {
            a0();
        }
    }

    private boolean m0(Typeface typeface) {
        q7 q7Var = this.f3044b;
        if (q7Var != null) {
            q7Var.c();
        }
        if (this.f3048c == typeface) {
            return false;
        }
        this.f3048c = typeface;
        Typeface b2 = at0.b(this.f3030a.getContext().getResources().getConfiguration(), typeface);
        this.f3041b = b2;
        if (b2 == null) {
            b2 = this.f3048c;
        }
        this.f3026a = b2;
        return true;
    }

    private boolean x0(Typeface typeface) {
        q7 q7Var = this.f3033a;
        if (q7Var != null) {
            q7Var.c();
        }
        if (this.f3060f == typeface) {
            return false;
        }
        this.f3060f = typeface;
        Typeface b2 = at0.b(this.f3030a.getContext().getResources().getConfiguration(), typeface);
        this.f3056e = b2;
        if (b2 == null) {
            b2 = this.f3060f;
        }
        this.f3053d = b2;
        return true;
    }

    public Typeface v() {
        Typeface typeface = this.f3026a;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Typeface E() {
        Typeface typeface = this.f3053d;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void Y(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3048c;
            if (typeface != null) {
                this.f3041b = at0.b(configuration, typeface);
            }
            Typeface typeface2 = this.f3060f;
            if (typeface2 != null) {
                this.f3056e = at0.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f3041b;
            if (typeface3 == null) {
                typeface3 = this.f3048c;
            }
            this.f3026a = typeface3;
            Typeface typeface4 = this.f3056e;
            if (typeface4 == null) {
                typeface4 = this.f3060f;
            }
            this.f3053d = typeface4;
            b0(true);
        }
    }

    public void y0(float fraction) {
        float fraction2 = MathUtils.clamp(fraction, 0.0f, 1.0f);
        if (fraction2 != this.a) {
            this.a = fraction2;
            c();
        }
    }

    public final boolean I0(int[] state) {
        this.f3035a = state;
        if (!V()) {
            return false;
        }
        a0();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f3021a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean V() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f3039b
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f3021a
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g9.V():boolean");
    }

    public float G() {
        return this.c;
    }

    public float F() {
        return this.a;
    }

    public float u() {
        return this.e;
    }

    public float D() {
        return this.d;
    }

    public void H0(boolean rtlTextDirectionHeuristicsEnabled) {
        this.f3050c = rtlTextDirectionHeuristicsEnabled;
    }

    private void c() {
        g(this.a);
    }

    private void g(float fraction) {
        float textBlendFraction;
        S(fraction);
        if (!this.f3034a) {
            textBlendFraction = fraction;
            this.j = X(this.h, this.i, fraction, this.f3020a);
            this.k = X(this.f3058f, this.g, fraction, this.f3020a);
            C0(fraction);
        } else if (fraction < this.c) {
            textBlendFraction = 0.0f;
            this.j = this.h;
            this.k = this.f3058f;
            C0(0.0f);
        } else {
            textBlendFraction = 1.0f;
            this.j = this.i;
            this.k = this.g - ((float) Math.max(0, this.f3019a));
            C0(1.0f);
        }
        TimeInterpolator timeInterpolator = f3.b;
        h0(1.0f - X(0.0f, 1.0f, 1.0f - fraction, timeInterpolator));
        s0(X(1.0f, 0.0f, fraction, timeInterpolator));
        if (this.f3039b != this.f3021a) {
            this.f3028a.setColor(a(y(), w(), textBlendFraction));
        } else {
            this.f3028a.setColor(w());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f2 = this.w;
            float f3 = this.x;
            if (f2 != f3) {
                this.f3028a.setLetterSpacing(X(f3, f2, fraction, timeInterpolator));
            } else {
                this.f3028a.setLetterSpacing(f2);
            }
        }
        this.n = X(this.t, this.q, fraction, (TimeInterpolator) null);
        this.o = X(this.u, this.r, fraction, (TimeInterpolator) null);
        this.p = X(this.v, this.s, fraction, (TimeInterpolator) null);
        int a2 = a(x(this.f3052d), x(this.f3047c), fraction);
        this.f3055e = a2;
        this.f3028a.setShadowLayer(this.n, this.o, this.p, a2);
        if (this.f3034a) {
            int originalAlpha = this.f3028a.getAlpha();
            this.f3028a.setAlpha((int) (d(fraction) * ((float) originalAlpha)));
        }
        ViewCompat.postInvalidateOnAnimation(this.f3030a);
    }

    private float d(float fraction) {
        float f2 = this.c;
        if (fraction <= f2) {
            return f3.b(1.0f, 0.0f, this.f3036b, f2, fraction);
        }
        return f3.b(0.0f, 1.0f, f2, 1.0f, fraction);
    }

    private int y() {
        return x(this.f3021a);
    }

    public int w() {
        return x(this.f3039b);
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f3035a;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void b(boolean forceRecalculate) {
        StaticLayout staticLayout;
        i(1.0f, forceRecalculate);
        CharSequence charSequence = this.f3043b;
        if (!(charSequence == null || (staticLayout = this.f3027a) == null)) {
            this.f3049c = TextUtils.ellipsize(charSequence, this.f3028a, (float) staticLayout.getWidth(), this.f3029a);
        }
        CharSequence charSequence2 = this.f3049c;
        float expandedTextHeight = 0.0f;
        if (charSequence2 != null) {
            this.z = Z(this.f3028a, charSequence2);
        } else {
            this.z = 0.0f;
        }
        int collapsedAbsGravity = GravityCompat.getAbsoluteGravity(this.f3046c, this.f3045b ? 1 : 0);
        switch (collapsedAbsGravity & 112) {
            case 48:
                this.g = (float) this.f3040b.top;
                break;
            case 80:
                this.g = ((float) this.f3040b.bottom) + this.f3028a.ascent();
                break;
            default:
                this.g = ((float) this.f3040b.centerY()) - ((this.f3028a.descent() - this.f3028a.ascent()) / 2.0f);
                break;
        }
        switch (collapsedAbsGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                this.i = ((float) this.f3040b.centerX()) - (this.z / 2.0f);
                break;
            case 5:
                this.i = ((float) this.f3040b.right) - this.z;
                break;
            default:
                this.i = (float) this.f3040b.left;
                break;
        }
        i(0.0f, forceRecalculate);
        StaticLayout staticLayout2 = this.f3027a;
        if (staticLayout2 != null) {
            expandedTextHeight = (float) staticLayout2.getHeight();
        }
        float expandedTextWidth = 0.0f;
        StaticLayout staticLayout3 = this.f3027a;
        if (staticLayout3 == null || this.f3059f <= 1) {
            CharSequence charSequence3 = this.f3043b;
            if (charSequence3 != null) {
                expandedTextWidth = Z(this.f3028a, charSequence3);
            }
        } else {
            expandedTextWidth = (float) staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.f3027a;
        this.f3051d = staticLayout4 != null ? staticLayout4.getLineCount() : 0;
        int expandedAbsGravity = GravityCompat.getAbsoluteGravity(this.f3037b, this.f3045b ? 1 : 0);
        switch (expandedAbsGravity & 112) {
            case 48:
                this.f3058f = (float) this.f3024a.top;
                break;
            case 80:
                this.f3058f = (((float) this.f3024a.bottom) - expandedTextHeight) + this.f3028a.descent();
                break;
            default:
                this.f3058f = ((float) this.f3024a.centerY()) - (expandedTextHeight / 2.0f);
                break;
        }
        switch (8388615 & expandedAbsGravity) {
            case 1:
                this.h = ((float) this.f3024a.centerX()) - (expandedTextWidth / 2.0f);
                break;
            case 5:
                this.h = ((float) this.f3024a.right) - expandedTextWidth;
                break;
            default:
                this.h = (float) this.f3024a.left;
                break;
        }
        j();
        C0(this.a);
    }

    private float Z(TextPaint textPaint, CharSequence textToDraw) {
        return textPaint.measureText(textToDraw, 0, textToDraw.length());
    }

    private void S(float fraction) {
        if (this.f3034a) {
            this.f3025a.set(fraction < this.c ? this.f3024a : this.f3040b);
            return;
        }
        this.f3025a.left = X((float) this.f3024a.left, (float) this.f3040b.left, fraction, this.f3020a);
        this.f3025a.top = X(this.f3058f, this.g, fraction, this.f3020a);
        this.f3025a.right = X((float) this.f3024a.right, (float) this.f3040b.right, fraction, this.f3020a);
        this.f3025a.bottom = X((float) this.f3024a.bottom, (float) this.f3040b.bottom, fraction, this.f3020a);
    }

    private void h0(float blend) {
        this.A = blend;
        ViewCompat.postInvalidateOnAnimation(this.f3030a);
    }

    private void s0(float blend) {
        this.B = blend;
        ViewCompat.postInvalidateOnAnimation(this.f3030a);
    }

    public void l(Canvas canvas) {
        int saveCount = canvas.save();
        if (this.f3043b != null && this.f3025a.width() > 0.0f && this.f3025a.height() > 0.0f) {
            this.f3028a.setTextSize(this.m);
            float x2 = this.j;
            float y2 = this.k;
            boolean drawTexture = this.f3054d && this.f3022a != null;
            float f2 = this.l;
            if (f2 != 1.0f && !this.f3034a) {
                canvas.scale(f2, f2, x2, y2);
            }
            if (drawTexture) {
                canvas.drawBitmap(this.f3022a, x2, y2, this.f3023a);
                canvas.restoreToCount(saveCount);
                return;
            }
            if (!O0() || (this.f3034a && this.a <= this.c)) {
                canvas.translate(x2, y2);
                this.f3027a.draw(canvas);
            } else {
                m(canvas, this.j - ((float) this.f3027a.getLineStart(0)), y2);
            }
            canvas.restoreToCount(saveCount);
        }
    }

    private boolean O0() {
        return this.f3059f > 1 && (!this.f3045b || this.f3034a) && !this.f3054d;
    }

    private void m(Canvas canvas, float currentExpandedX, float y2) {
        int originalAlpha = this.f3028a.getAlpha();
        canvas.translate(currentExpandedX, y2);
        if (!this.f3034a) {
            this.f3028a.setAlpha((int) (this.B * ((float) originalAlpha)));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.f3028a;
                textPaint.setShadowLayer(this.n, this.o, this.p, k00.a(this.f3055e, textPaint.getAlpha()));
            }
            this.f3027a.draw(canvas);
        }
        if (!this.f3034a) {
            this.f3028a.setAlpha((int) (this.A * ((float) originalAlpha)));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            TextPaint textPaint2 = this.f3028a;
            textPaint2.setShadowLayer(this.n, this.o, this.p, k00.a(this.f3055e, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f3027a.getLineBaseline(0);
        CharSequence charSequence = this.f3049c;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, (float) lineBaseline, this.f3028a);
        if (i2 >= 31) {
            this.f3028a.setShadowLayer(this.n, this.o, this.p, this.f3055e);
        }
        if (!this.f3034a) {
            String tmp = this.f3049c.toString().trim();
            if (tmp.endsWith("…")) {
                tmp = tmp.substring(0, tmp.length() - 1);
            }
            this.f3028a.setAlpha(originalAlpha);
            canvas.drawText(tmp, 0, Math.min(this.f3027a.getLineEnd(0), tmp.length()), 0.0f, (float) lineBaseline, this.f3028a);
        }
    }

    private boolean f(CharSequence text) {
        boolean defaultIsRtl = U();
        if (this.f3050c) {
            return W(text, defaultIsRtl);
        }
        return defaultIsRtl;
    }

    private boolean U() {
        return ViewCompat.getLayoutDirection(this.f3030a) == 1;
    }

    private boolean W(CharSequence text, boolean defaultIsRtl) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (defaultIsRtl) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(text, 0, text.length());
    }

    private void C0(float fraction) {
        h(fraction);
        boolean z2 = f && this.l != 1.0f;
        this.f3054d = z2;
        if (z2) {
            n();
        }
        ViewCompat.postInvalidateOnAnimation(this.f3030a);
    }

    private void h(float fraction) {
        i(fraction, false);
    }

    private void i(float fraction, boolean forceRecalculate) {
        float textSizeRatio;
        Typeface newTypeface;
        float newLetterSpacing;
        float newTextSize;
        boolean updateDrawText;
        float f2;
        float f3 = fraction;
        if (this.f3032a != null) {
            float collapsedWidth = (float) this.f3040b.width();
            float expandedWidth = (float) this.f3024a.width();
            if (T(f3, 1.0f)) {
                newTextSize = this.e;
                newLetterSpacing = this.w;
                this.l = 1.0f;
                newTypeface = this.f3026a;
                textSizeRatio = collapsedWidth;
            } else {
                newTextSize = this.d;
                newLetterSpacing = this.x;
                newTypeface = this.f3053d;
                if (T(f3, 0.0f)) {
                    this.l = 1.0f;
                } else {
                    this.l = X(this.d, this.e, f3, this.f3038b) / this.d;
                }
                float textSizeRatio2 = this.e / this.d;
                float scaledDownWidth = expandedWidth * textSizeRatio2;
                if (forceRecalculate || this.f3034a) {
                    textSizeRatio = expandedWidth;
                } else {
                    if (scaledDownWidth > collapsedWidth) {
                        f2 = Math.min(collapsedWidth / textSizeRatio2, expandedWidth);
                    } else {
                        f2 = expandedWidth;
                    }
                    textSizeRatio = f2;
                }
            }
            if (textSizeRatio > 0.0f) {
                boolean textSizeChanged = this.m != newTextSize;
                boolean letterSpacingChanged = this.y != newLetterSpacing;
                boolean typefaceChanged = this.f3062g != newTypeface;
                StaticLayout staticLayout = this.f3027a;
                updateDrawText = textSizeChanged || letterSpacingChanged || (staticLayout != null && (textSizeRatio > ((float) staticLayout.getWidth()) ? 1 : (textSizeRatio == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || typefaceChanged || this.f3057e;
                this.m = newTextSize;
                this.y = newLetterSpacing;
                this.f3062g = newTypeface;
                this.f3057e = false;
                this.f3028a.setLinearText(this.l != 1.0f);
            } else {
                updateDrawText = false;
            }
            if (this.f3043b == null || updateDrawText) {
                this.f3028a.setTextSize(this.m);
                this.f3028a.setTypeface(this.f3062g);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f3028a.setLetterSpacing(this.y);
                }
                this.f3045b = f(this.f3032a);
                StaticLayout k2 = k(O0() ? this.f3059f : 1, textSizeRatio, this.f3045b);
                this.f3027a = k2;
                this.f3043b = k2.getText();
            }
        }
    }

    private StaticLayout k(int maxLines, float availableWidth, boolean isRtl) {
        Layout.Alignment textAlignment;
        StaticLayout textLayout = null;
        if (maxLines == 1) {
            try {
                textAlignment = Layout.Alignment.ALIGN_NORMAL;
            } catch (an0.a e2) {
                Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            }
        } else {
            textAlignment = M();
        }
        textLayout = an0.c(this.f3032a, this.f3028a, (int) availableWidth).e(this.f3029a).h(isRtl).d(textAlignment).g(false).j(maxLines).i(this.C, this.D).f(this.f3061g).k(this.f3031a).a();
        return (StaticLayout) Preconditions.checkNotNull(textLayout);
    }

    private Layout.Alignment M() {
        switch (GravityCompat.getAbsoluteGravity(this.f3037b, this.f3045b ? 1 : 0) & 7) {
            case 1:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
                return this.f3045b ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return this.f3045b ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private void n() {
        if (this.f3022a == null && !this.f3024a.isEmpty() && !TextUtils.isEmpty(this.f3043b)) {
            g(0.0f);
            int width = this.f3027a.getWidth();
            int height = this.f3027a.getHeight();
            if (width > 0 && height > 0) {
                this.f3022a = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f3027a.draw(new Canvas(this.f3022a));
                if (this.f3023a == null) {
                    this.f3023a = new Paint(3);
                }
            }
        }
    }

    public void a0() {
        b0(false);
    }

    public void b0(boolean forceRecalculate) {
        if ((this.f3030a.getHeight() > 0 && this.f3030a.getWidth() > 0) || forceRecalculate) {
            b(forceRecalculate);
            c();
        }
    }

    public void K0(CharSequence text) {
        if (text == null || !TextUtils.equals(this.f3032a, text)) {
            this.f3032a = text;
            this.f3043b = null;
            j();
            a0();
        }
    }

    public CharSequence O() {
        return this.f3032a;
    }

    private void j() {
        Bitmap bitmap = this.f3022a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f3022a = null;
        }
    }

    public void F0(int maxLines) {
        if (maxLines != this.f3059f) {
            this.f3059f = maxLines;
            j();
            a0();
        }
    }

    public int L() {
        return this.f3059f;
    }

    public int I() {
        StaticLayout staticLayout = this.f3027a;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public int z() {
        return this.f3051d;
    }

    public void D0(float spacingAdd) {
        this.C = spacingAdd;
    }

    public float J() {
        return this.f3027a.getSpacingAdd();
    }

    public void E0(float spacingMultiplier) {
        this.D = spacingMultiplier;
    }

    public float K() {
        return this.f3027a.getSpacingMultiplier();
    }

    public void B0(int hyphenationFrequency) {
        this.f3061g = hyphenationFrequency;
    }

    public int H() {
        return this.f3061g;
    }

    public void J0(bn0 staticLayoutBuilderConfigurer) {
        if (this.f3031a != staticLayoutBuilderConfigurer) {
            this.f3031a = staticLayoutBuilderConfigurer;
            b0(true);
        }
    }

    private static boolean T(float value, float targetValue) {
        return Math.abs(value - targetValue) < 1.0E-5f;
    }

    public ColorStateList p() {
        return this.f3039b;
    }

    private static int a(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        return Color.argb(Math.round((((float) Color.alpha(color1)) * inverseRatio) + (((float) Color.alpha(color2)) * ratio)), Math.round((((float) Color.red(color1)) * inverseRatio) + (((float) Color.red(color2)) * ratio)), Math.round((((float) Color.green(color1)) * inverseRatio) + (((float) Color.green(color2)) * ratio)), Math.round((((float) Color.blue(color1)) * inverseRatio) + (((float) Color.blue(color2)) * ratio)));
    }

    private static float X(float startValue, float endValue, float fraction, TimeInterpolator interpolator) {
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        return f3.a(startValue, endValue, fraction);
    }

    private static boolean c0(Rect r2, int left, int top, int right, int bottom) {
        return r2.left == left && r2.top == top && r2.right == right && r2.bottom == bottom;
    }
}
