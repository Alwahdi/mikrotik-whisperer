package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import defpackage.rq0;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a extends p00 implements Drawable.Callback, rq0.b {
    private static final ShapeDrawable a = new ShapeDrawable(new OvalShape());
    private static final int[] b = {16842910};

    /* renamed from: a  reason: collision with other field name */
    private float f1623a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f1624a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1625a;

    /* renamed from: a  reason: collision with other field name */
    private ColorFilter f1626a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint.FontMetrics f1627a = new Paint.FontMetrics();

    /* renamed from: a  reason: collision with other field name */
    private final PointF f1628a = new PointF();

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f1629a = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1630a;

    /* renamed from: a  reason: collision with other field name */
    private TextUtils.TruncateAt f1631a;

    /* renamed from: a  reason: collision with other field name */
    private g20 f1632a;

    /* renamed from: a  reason: collision with other field name */
    private CharSequence f1633a;

    /* renamed from: a  reason: collision with other field name */
    private WeakReference<C0012a> f1634a = new WeakReference<>((Object) null);

    /* renamed from: a  reason: collision with other field name */
    private final rq0 f1635a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f1636a;

    /* renamed from: b  reason: collision with other field name */
    private float f1637b = -1.0f;

    /* renamed from: b  reason: collision with other field name */
    private int f1638b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f1639b;

    /* renamed from: b  reason: collision with other field name */
    private Drawable f1640b;

    /* renamed from: b  reason: collision with other field name */
    private g20 f1641b;

    /* renamed from: b  reason: collision with other field name */
    private CharSequence f1642b;
    private float c;

    /* renamed from: c  reason: collision with other field name */
    private int f1643c;

    /* renamed from: c  reason: collision with other field name */
    private ColorStateList f1644c;

    /* renamed from: c  reason: collision with other field name */
    private final Path f1645c = new Path();

    /* renamed from: c  reason: collision with other field name */
    private PorterDuffColorFilter f1646c;

    /* renamed from: c  reason: collision with other field name */
    private Drawable f1647c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1648c;
    private float d;

    /* renamed from: d  reason: collision with other field name */
    private int f1649d;

    /* renamed from: d  reason: collision with other field name */
    private ColorStateList f1650d;

    /* renamed from: d  reason: collision with other field name */
    private final Paint f1651d = new Paint(1);

    /* renamed from: d  reason: collision with other field name */
    private final RectF f1652d = new RectF();

    /* renamed from: d  reason: collision with other field name */
    private Drawable f1653d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1654d;
    private float e;

    /* renamed from: e  reason: collision with other field name */
    private int f1655e;

    /* renamed from: e  reason: collision with other field name */
    private ColorStateList f1656e;

    /* renamed from: e  reason: collision with other field name */
    private final Paint f1657e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1658e;
    private float f;

    /* renamed from: f  reason: collision with other field name */
    private int f1659f;

    /* renamed from: f  reason: collision with other field name */
    private ColorStateList f1660f;

    /* renamed from: f  reason: collision with other field name */
    private boolean f1661f;
    private float g;

    /* renamed from: g  reason: collision with other field name */
    private int f1662g;

    /* renamed from: g  reason: collision with other field name */
    private ColorStateList f1663g;

    /* renamed from: g  reason: collision with other field name */
    private boolean f1664g;
    private float h;

    /* renamed from: h  reason: collision with other field name */
    private int f1665h;

    /* renamed from: h  reason: collision with other field name */
    private ColorStateList f1666h;

    /* renamed from: h  reason: collision with other field name */
    private boolean f1667h;
    private float i;

    /* renamed from: i  reason: collision with other field name */
    private int f1668i = 255;

    /* renamed from: i  reason: collision with other field name */
    private ColorStateList f1669i;

    /* renamed from: i  reason: collision with other field name */
    private boolean f1670i;
    private float j;

    /* renamed from: j  reason: collision with other field name */
    private int f1671j;

    /* renamed from: j  reason: collision with other field name */
    private boolean f1672j;
    private float k;

    /* renamed from: k  reason: collision with other field name */
    private boolean f1673k;
    private float l;
    private float m;

    /* renamed from: com.google.android.material.chip.a$a  reason: collision with other inner class name */
    public interface C0012a {
        void a();
    }

    public static a t0(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        a chip = new a(context, attrs, defStyleAttr, defStyleRes);
        chip.s1(attrs, defStyleAttr, defStyleRes);
        return chip;
    }

    private a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        K(context);
        this.f1624a = context;
        rq0 rq0 = new rq0(this);
        this.f1635a = rq0;
        this.f1633a = "";
        rq0.g().density = context.getResources().getDisplayMetrics().density;
        this.f1657e = null;
        int[] iArr = b;
        setState(iArr);
        j2(iArr);
        this.f1672j = true;
        if (ye0.f5882a) {
            a.setTint(-1);
        }
    }

    private void s1(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a2 = vq0.i(this.f1624a, attrs, xc0.f5601D, defStyleAttr, defStyleRes, new int[0]);
        this.f1673k = a2.hasValue(xc0.W0);
        Z1(o00.a(this.f1624a, a2, xc0.J0));
        D1(o00.a(this.f1624a, a2, xc0.w0));
        R1(a2.getDimension(xc0.E0, 0.0f));
        int i2 = xc0.x0;
        if (a2.hasValue(i2)) {
            F1(a2.getDimension(i2, 0.0f));
        }
        V1(o00.a(this.f1624a, a2, xc0.H0));
        X1(a2.getDimension(xc0.I0, 0.0f));
        w2(o00.a(this.f1624a, a2, xc0.V0));
        B2(a2.getText(xc0.q0));
        oq0 textAppearance = o00.g(this.f1624a, a2, xc0.l0);
        textAppearance.l(a2.getDimension(xc0.m0, textAppearance.j()));
        if (Build.VERSION.SDK_INT < 23) {
            textAppearance.k(o00.a(this.f1624a, a2, xc0.n0));
        }
        C2(textAppearance);
        switch (a2.getInt(xc0.o0, 0)) {
            case 1:
                o2(TextUtils.TruncateAt.START);
                break;
            case 2:
                o2(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                o2(TextUtils.TruncateAt.END);
                break;
        }
        Q1(a2.getBoolean(xc0.D0, false));
        if (!(attrs == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            Q1(a2.getBoolean(xc0.A0, false));
        }
        J1(o00.d(this.f1624a, a2, xc0.z0));
        int i3 = xc0.C0;
        if (a2.hasValue(i3)) {
            N1(o00.a(this.f1624a, a2, i3));
        }
        L1(a2.getDimension(xc0.B0, -1.0f));
        m2(a2.getBoolean(xc0.Q0, false));
        if (!(attrs == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            m2(a2.getBoolean(xc0.L0, false));
        }
        a2(o00.d(this.f1624a, a2, xc0.K0));
        k2(o00.a(this.f1624a, a2, xc0.P0));
        f2(a2.getDimension(xc0.N0, 0.0f));
        v1(a2.getBoolean(xc0.r0, false));
        C1(a2.getBoolean(xc0.v0, false));
        if (!(attrs == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            C1(a2.getBoolean(xc0.t0, false));
        }
        x1(o00.d(this.f1624a, a2, xc0.s0));
        int i4 = xc0.u0;
        if (a2.hasValue(i4)) {
            z1(o00.a(this.f1624a, a2, i4));
        }
        z2(g20.b(this.f1624a, a2, xc0.X0));
        p2(g20.b(this.f1624a, a2, xc0.S0));
        T1(a2.getDimension(xc0.G0, 0.0f));
        t2(a2.getDimension(xc0.U0, 0.0f));
        r2(a2.getDimension(xc0.T0, 0.0f));
        H2(a2.getDimension(xc0.Z0, 0.0f));
        E2(a2.getDimension(xc0.Y0, 0.0f));
        h2(a2.getDimension(xc0.O0, 0.0f));
        c2(a2.getDimension(xc0.M0, 0.0f));
        H1(a2.getDimension(xc0.y0, 0.0f));
        v2(a2.getDimensionPixelSize(xc0.p0, Integer.MAX_VALUE));
        a2.recycle();
    }

    public void J2(boolean useCompatRipple) {
        if (this.f1670i != useCompatRipple) {
            this.f1670i = useCompatRipple;
            P2();
            onStateChange(getState());
        }
    }

    public boolean k1() {
        return this.f1670i;
    }

    public void n2(C0012a delegate) {
        this.f1634a = new WeakReference<>(delegate);
    }

    /* access modifiers changed from: protected */
    public void t1() {
        C0012a delegate = (C0012a) this.f1634a.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void W0(RectF bounds) {
        n0(getBounds(), bounds);
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f + k0() + this.i + this.f1635a.h(f1().toString()) + this.j + o0() + this.m), this.f1671j);
    }

    public int getIntrinsicHeight() {
        return (int) this.f1623a;
    }

    private boolean M2() {
        return this.f1648c && this.f1630a != null;
    }

    private boolean L2() {
        return this.f1664g && this.f1653d != null && this.f1667h;
    }

    private boolean N2() {
        return this.f1658e && this.f1640b != null;
    }

    private boolean s0() {
        return this.f1664g && this.f1653d != null && this.f1661f;
    }

    /* access modifiers changed from: package-private */
    public float k0() {
        if (M2() || L2()) {
            return this.g + Y0() + this.h;
        }
        return 0.0f;
    }

    private float Y0() {
        Drawable iconDrawable = this.f1667h ? this.f1653d : this.f1630a;
        float f2 = this.d;
        if (f2 > 0.0f || iconDrawable == null) {
            return f2;
        }
        return (float) iconDrawable.getIntrinsicWidth();
    }

    private float X0() {
        Drawable icon = this.f1667h ? this.f1653d : this.f1630a;
        float maxChipIconHeight = this.d;
        if (maxChipIconHeight > 0.0f || icon == null) {
            return maxChipIconHeight;
        }
        float maxChipIconHeight2 = (float) Math.ceil((double) lv0.c(this.f1624a, 24));
        if (((float) icon.getIntrinsicHeight()) <= maxChipIconHeight2) {
            return (float) icon.getIntrinsicHeight();
        }
        return maxChipIconHeight2;
    }

    /* access modifiers changed from: package-private */
    public float o0() {
        if (N2()) {
            return this.k + this.e + this.l;
        }
        return 0.0f;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int saveCount = 0;
            int i2 = this.f1668i;
            if (i2 < 255) {
                saveCount = v7.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i2);
            }
            y0(canvas, bounds);
            v0(canvas, bounds);
            if (this.f1673k) {
                super.draw(canvas);
            }
            x0(canvas, bounds);
            A0(canvas, bounds);
            w0(canvas, bounds);
            u0(canvas, bounds);
            if (this.f1672j) {
                C0(canvas, bounds);
            }
            z0(canvas, bounds);
            B0(canvas, bounds);
            if (this.f1668i < 255) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    private void y0(Canvas canvas, Rect bounds) {
        if (!this.f1673k) {
            this.f1651d.setColor(this.f1638b);
            this.f1651d.setStyle(Paint.Style.FILL);
            this.f1652d.set(bounds);
            canvas.drawRoundRect(this.f1652d, G0(), G0(), this.f1651d);
        }
    }

    private void v0(Canvas canvas, Rect bounds) {
        if (!this.f1673k) {
            this.f1651d.setColor(this.f1643c);
            this.f1651d.setStyle(Paint.Style.FILL);
            this.f1651d.setColorFilter(j1());
            this.f1652d.set(bounds);
            canvas.drawRoundRect(this.f1652d, G0(), G0(), this.f1651d);
        }
    }

    private void x0(Canvas canvas, Rect bounds) {
        if (this.c > 0.0f && !this.f1673k) {
            this.f1651d.setColor(this.f1655e);
            this.f1651d.setStyle(Paint.Style.STROKE);
            if (!this.f1673k) {
                this.f1651d.setColorFilter(j1());
            }
            RectF rectF = this.f1652d;
            float f2 = this.c;
            rectF.set(((float) bounds.left) + (f2 / 2.0f), ((float) bounds.top) + (f2 / 2.0f), ((float) bounds.right) - (f2 / 2.0f), ((float) bounds.bottom) - (f2 / 2.0f));
            float strokeCornerRadius = this.f1637b - (this.c / 2.0f);
            canvas.drawRoundRect(this.f1652d, strokeCornerRadius, strokeCornerRadius, this.f1651d);
        }
    }

    private void A0(Canvas canvas, Rect bounds) {
        this.f1651d.setColor(this.f1659f);
        this.f1651d.setStyle(Paint.Style.FILL);
        this.f1652d.set(bounds);
        if (!this.f1673k) {
            canvas.drawRoundRect(this.f1652d, G0(), G0(), this.f1651d);
            return;
        }
        h(new RectF(bounds), this.f1645c);
        super.q(canvas, this.f1651d, this.f1645c, s());
    }

    private void w0(Canvas canvas, Rect bounds) {
        if (M2()) {
            j0(bounds, this.f1652d);
            RectF rectF = this.f1652d;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.f1630a.setBounds(0, 0, (int) this.f1652d.width(), (int) this.f1652d.height());
            this.f1630a.draw(canvas);
            canvas.translate(-tx, -ty);
        }
    }

    private void u0(Canvas canvas, Rect bounds) {
        if (L2()) {
            j0(bounds, this.f1652d);
            RectF rectF = this.f1652d;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.f1653d.setBounds(0, 0, (int) this.f1652d.width(), (int) this.f1652d.height());
            this.f1653d.draw(canvas);
            canvas.translate(-tx, -ty);
        }
    }

    private void C0(Canvas canvas, Rect bounds) {
        if (this.f1633a != null) {
            Paint.Align align = r0(bounds, this.f1628a);
            p0(bounds, this.f1652d);
            if (this.f1635a.e() != null) {
                this.f1635a.g().drawableState = getState();
                this.f1635a.n(this.f1624a);
            }
            this.f1635a.g().setTextAlign(align);
            boolean clip = Math.round(this.f1635a.h(f1().toString())) > Math.round(this.f1652d.width());
            int saveCount = 0;
            if (clip) {
                saveCount = canvas.save();
                canvas.clipRect(this.f1652d);
            }
            CharSequence finalText = this.f1633a;
            if (clip && this.f1631a != null) {
                finalText = TextUtils.ellipsize(this.f1633a, this.f1635a.g(), this.f1652d.width(), this.f1631a);
            }
            int length = finalText.length();
            PointF pointF = this.f1628a;
            canvas.drawText(finalText, 0, length, pointF.x, pointF.y, this.f1635a.g());
            if (clip) {
                canvas.restoreToCount(saveCount);
            }
        }
    }

    private void z0(Canvas canvas, Rect bounds) {
        if (N2()) {
            m0(bounds, this.f1652d);
            RectF rectF = this.f1652d;
            float tx = rectF.left;
            float ty = rectF.top;
            canvas.translate(tx, ty);
            this.f1640b.setBounds(0, 0, (int) this.f1652d.width(), (int) this.f1652d.height());
            if (ye0.f5882a) {
                this.f1647c.setBounds(this.f1640b.getBounds());
                this.f1647c.jumpToCurrentState();
                this.f1647c.draw(canvas);
            } else {
                this.f1640b.draw(canvas);
            }
            canvas.translate(-tx, -ty);
        }
    }

    private void B0(Canvas canvas, Rect bounds) {
        Paint paint = this.f1657e;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(bounds, this.f1657e);
            if (M2() || L2()) {
                j0(bounds, this.f1652d);
                canvas.drawRect(this.f1652d, this.f1657e);
            }
            if (this.f1633a != null) {
                canvas.drawLine((float) bounds.left, bounds.exactCenterY(), (float) bounds.right, bounds.exactCenterY(), this.f1657e);
            }
            if (N2()) {
                m0(bounds, this.f1652d);
                canvas.drawRect(this.f1652d, this.f1657e);
            }
            this.f1657e.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            l0(bounds, this.f1652d);
            canvas.drawRect(this.f1652d, this.f1657e);
            this.f1657e.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            n0(bounds, this.f1652d);
            canvas.drawRect(this.f1652d, this.f1657e);
        }
    }

    private void j0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (M2() || L2()) {
            float offsetFromStart = this.f + this.g;
            float chipWidth = Y0();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = ((float) bounds.left) + offsetFromStart;
                outBounds.left = f2;
                outBounds.right = f2 + chipWidth;
            } else {
                float f3 = ((float) bounds.right) - offsetFromStart;
                outBounds.right = f3;
                outBounds.left = f3 - chipWidth;
            }
            float chipHeight = X0();
            float exactCenterY = bounds.exactCenterY() - (chipHeight / 2.0f);
            outBounds.top = exactCenterY;
            outBounds.bottom = exactCenterY + chipHeight;
        }
    }

    /* access modifiers changed from: package-private */
    public Paint.Align r0(Rect bounds, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f1633a != null) {
            float offsetFromStart = this.f + k0() + this.i;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = ((float) bounds.left) + offsetFromStart;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) bounds.right) - offsetFromStart;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) bounds.centerY()) - q0();
        }
        return align;
    }

    private float q0() {
        this.f1635a.g().getFontMetrics(this.f1627a);
        Paint.FontMetrics fontMetrics = this.f1627a;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private void p0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (this.f1633a != null) {
            float offsetFromStart = this.f + k0() + this.i;
            float offsetFromEnd = this.m + o0() + this.j;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                outBounds.left = ((float) bounds.left) + offsetFromStart;
                outBounds.right = ((float) bounds.right) - offsetFromEnd;
            } else {
                outBounds.left = ((float) bounds.left) + offsetFromEnd;
                outBounds.right = ((float) bounds.right) - offsetFromStart;
            }
            outBounds.top = (float) bounds.top;
            outBounds.bottom = (float) bounds.bottom;
        }
    }

    private void m0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (N2()) {
            float offsetFromEnd = this.m + this.l;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = ((float) bounds.right) - offsetFromEnd;
                outBounds.right = f2;
                outBounds.left = f2 - this.e;
            } else {
                float f3 = ((float) bounds.left) + offsetFromEnd;
                outBounds.left = f3;
                outBounds.right = f3 + this.e;
            }
            float exactCenterY = bounds.exactCenterY();
            float f4 = this.e;
            float f5 = exactCenterY - (f4 / 2.0f);
            outBounds.top = f5;
            outBounds.bottom = f5 + f4;
        }
    }

    private void l0(Rect bounds, RectF outBounds) {
        outBounds.set(bounds);
        if (N2()) {
            float offsetFromEnd = this.m + this.l + this.e + this.k + this.j;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                outBounds.right = ((float) bounds.right) - offsetFromEnd;
            } else {
                outBounds.left = ((float) bounds.left) + offsetFromEnd;
            }
        }
    }

    private void n0(Rect bounds, RectF outBounds) {
        outBounds.setEmpty();
        if (N2()) {
            float offsetFromEnd = this.m + this.l + this.e + this.k + this.j;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f2 = (float) bounds.right;
                outBounds.right = f2;
                outBounds.left = f2 - offsetFromEnd;
            } else {
                int i2 = bounds.left;
                outBounds.left = (float) i2;
                outBounds.right = ((float) i2) + offsetFromEnd;
            }
            outBounds.top = (float) bounds.top;
            outBounds.bottom = (float) bounds.bottom;
        }
    }

    public boolean isStateful() {
        return q1(this.f1625a) || q1(this.f1639b) || q1(this.f1644c) || (this.f1670i && q1(this.f1669i)) || p1(this.f1635a.e()) || s0() || r1(this.f1630a) || r1(this.f1653d) || q1(this.f1666h);
    }

    public boolean n1() {
        return r1(this.f1640b);
    }

    public boolean j2(int[] stateSet) {
        if (Arrays.equals(this.f1636a, stateSet)) {
            return false;
        }
        this.f1636a = stateSet;
        if (N2()) {
            return u1(getState(), stateSet);
        }
        return false;
    }

    public int[] U0() {
        return this.f1636a;
    }

    public void a() {
        t1();
        invalidateSelf();
    }

    public boolean onStateChange(int[] state) {
        if (this.f1673k) {
            super.onStateChange(state);
        }
        return u1(state, U0());
    }

    private boolean u1(int[] chipState, int[] closeIconState) {
        int newChipSurfaceColor;
        int newChipBackgroundColor;
        int newChipStrokeColor;
        int newCompatRippleColor;
        int newTextColor;
        int[] iArr = chipState;
        int[] iArr2 = closeIconState;
        boolean invalidate = super.onStateChange(chipState);
        boolean sizeChanged = false;
        ColorStateList colorStateList = this.f1625a;
        if (colorStateList != null) {
            newChipSurfaceColor = colorStateList.getColorForState(iArr, this.f1638b);
        } else {
            newChipSurfaceColor = 0;
        }
        int newChipSurfaceColor2 = l(newChipSurfaceColor);
        if (this.f1638b != newChipSurfaceColor2) {
            this.f1638b = newChipSurfaceColor2;
            invalidate = true;
        }
        ColorStateList colorStateList2 = this.f1639b;
        if (colorStateList2 != null) {
            newChipBackgroundColor = colorStateList2.getColorForState(iArr, this.f1643c);
        } else {
            newChipBackgroundColor = 0;
        }
        int newChipBackgroundColor2 = l(newChipBackgroundColor);
        if (this.f1643c != newChipBackgroundColor2) {
            this.f1643c = newChipBackgroundColor2;
            invalidate = true;
        }
        int newCompositeSurfaceBackgroundColor = k00.j(newChipSurfaceColor2, newChipBackgroundColor2);
        boolean newChecked = true;
        if ((this.f1649d != newCompositeSurfaceBackgroundColor) || (v() == null)) {
            this.f1649d = newCompositeSurfaceBackgroundColor;
            V(ColorStateList.valueOf(newCompositeSurfaceBackgroundColor));
            invalidate = true;
        }
        ColorStateList colorStateList3 = this.f1644c;
        if (colorStateList3 != null) {
            newChipStrokeColor = colorStateList3.getColorForState(iArr, this.f1655e);
        } else {
            newChipStrokeColor = 0;
        }
        if (this.f1655e != newChipStrokeColor) {
            this.f1655e = newChipStrokeColor;
            invalidate = true;
        }
        if (this.f1669i == null || !ye0.f(chipState)) {
            newCompatRippleColor = 0;
        } else {
            newCompatRippleColor = this.f1669i.getColorForState(iArr, this.f1659f);
        }
        if (this.f1659f != newCompatRippleColor) {
            this.f1659f = newCompatRippleColor;
            if (this.f1670i) {
                invalidate = true;
            }
        }
        if (this.f1635a.e() == null || this.f1635a.e().i() == null) {
            newTextColor = 0;
        } else {
            newTextColor = this.f1635a.e().i().getColorForState(iArr, this.f1662g);
        }
        if (this.f1662g != newTextColor) {
            this.f1662g = newTextColor;
            invalidate = true;
        }
        if (!l1(getState(), 16842912) || !this.f1661f) {
            newChecked = false;
        }
        if (!(this.f1667h == newChecked || this.f1653d == null)) {
            float oldChipIconWidth = k0();
            this.f1667h = newChecked;
            invalidate = true;
            if (oldChipIconWidth != k0()) {
                sizeChanged = true;
            }
        }
        ColorStateList colorStateList4 = this.f1666h;
        int newTint = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f1665h) : 0;
        if (this.f1665h != newTint) {
            this.f1665h = newTint;
            this.f1646c = yh.l(this, this.f1666h, this.f1629a);
            invalidate = true;
        }
        if (r1(this.f1630a)) {
            invalidate |= this.f1630a.setState(iArr);
        }
        if (r1(this.f1653d)) {
            invalidate |= this.f1653d.setState(iArr);
        }
        if (r1(this.f1640b)) {
            int[] closeIconMergedState = new int[(iArr.length + iArr2.length)];
            int i2 = newChipSurfaceColor2;
            System.arraycopy(iArr, 0, closeIconMergedState, 0, iArr.length);
            System.arraycopy(iArr2, 0, closeIconMergedState, iArr.length, iArr2.length);
            invalidate |= this.f1640b.setState(closeIconMergedState);
        }
        if (ye0.f5882a && r1(this.f1647c)) {
            invalidate |= this.f1647c.setState(iArr2);
        }
        if (invalidate) {
            invalidateSelf();
        }
        if (sizeChanged) {
            t1();
        }
        return invalidate;
    }

    private static boolean q1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean r1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean p1(oq0 textAppearance) {
        return (textAppearance == null || textAppearance.i() == null || !textAppearance.i().isStateful()) ? false : true;
    }

    public boolean onLayoutDirectionChanged(int layoutDirection) {
        boolean invalidate = super.onLayoutDirectionChanged(layoutDirection);
        if (M2()) {
            invalidate |= DrawableCompat.setLayoutDirection(this.f1630a, layoutDirection);
        }
        if (L2()) {
            invalidate |= DrawableCompat.setLayoutDirection(this.f1653d, layoutDirection);
        }
        if (N2()) {
            invalidate |= DrawableCompat.setLayoutDirection(this.f1640b, layoutDirection);
        }
        if (!invalidate) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int level) {
        boolean invalidate = super.onLevelChange(level);
        if (M2()) {
            invalidate |= this.f1630a.setLevel(level);
        }
        if (L2()) {
            invalidate |= this.f1653d.setLevel(level);
        }
        if (N2()) {
            invalidate |= this.f1640b.setLevel(level);
        }
        if (invalidate) {
            invalidateSelf();
        }
        return invalidate;
    }

    public boolean setVisible(boolean visible, boolean restart) {
        boolean invalidate = super.setVisible(visible, restart);
        if (M2()) {
            invalidate |= this.f1630a.setVisible(visible, restart);
        }
        if (L2()) {
            invalidate |= this.f1653d.setVisible(visible, restart);
        }
        if (N2()) {
            invalidate |= this.f1640b.setVisible(visible, restart);
        }
        if (invalidate) {
            invalidateSelf();
        }
        return invalidate;
    }

    public void setAlpha(int alpha) {
        if (this.f1668i != alpha) {
            this.f1668i = alpha;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f1668i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f1626a != colorFilter) {
            this.f1626a = colorFilter;
            invalidateSelf();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f1626a;
    }

    public void setTintList(ColorStateList tint) {
        if (this.f1666h != tint) {
            this.f1666h = tint;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode tintMode) {
        if (this.f1629a != tintMode) {
            this.f1629a = tintMode;
            this.f1646c = yh.l(this, this.f1666h, tintMode);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.f1673k) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f1637b);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f1637b);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public void invalidateDrawable(Drawable who) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, what, when);
        }
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, what);
        }
    }

    private void O2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void i0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.f1640b) {
                if (drawable.isStateful()) {
                    drawable.setState(U0());
                }
                DrawableCompat.setTintList(drawable, this.f1660f);
                return;
            }
            Drawable drawable2 = this.f1630a;
            if (drawable == drawable2 && this.f1654d) {
                DrawableCompat.setTintList(drawable2, this.f1656e);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private ColorFilter j1() {
        ColorFilter colorFilter = this.f1626a;
        return colorFilter != null ? colorFilter : this.f1646c;
    }

    private void P2() {
        this.f1669i = this.f1670i ? ye0.e(this.f1650d) : null;
    }

    private void Z1(ColorStateList chipSurfaceColor) {
        if (this.f1625a != chipSurfaceColor) {
            this.f1625a = chipSurfaceColor;
            onStateChange(getState());
        }
    }

    private static boolean l1(int[] stateSet, int state) {
        if (stateSet == null) {
            return false;
        }
        for (int s : stateSet) {
            if (s == state) {
                return true;
            }
        }
        return false;
    }

    public void G2(float size) {
        oq0 textAppearance = g1();
        if (textAppearance != null) {
            textAppearance.l(size);
            this.f1635a.g().setTextSize(size);
            a();
        }
    }

    public ColorStateList F0() {
        return this.f1639b;
    }

    public void E1(int id) {
        D1(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void D1(ColorStateList chipBackgroundColor) {
        if (this.f1639b != chipBackgroundColor) {
            this.f1639b = chipBackgroundColor;
            onStateChange(getState());
        }
    }

    public float L0() {
        return this.f1623a;
    }

    public void S1(int id) {
        R1(this.f1624a.getResources().getDimension(id));
    }

    public void R1(float chipMinHeight) {
        if (this.f1623a != chipMinHeight) {
            this.f1623a = chipMinHeight;
            invalidateSelf();
            t1();
        }
    }

    public float G0() {
        return this.f1673k ? D() : this.f1637b;
    }

    public void G1(int id) {
        F1(this.f1624a.getResources().getDimension(id));
    }

    public void F1(float chipCornerRadius) {
        if (this.f1637b != chipCornerRadius) {
            this.f1637b = chipCornerRadius;
            setShapeAppearanceModel(B().w(chipCornerRadius));
        }
    }

    public ColorStateList N0() {
        return this.f1644c;
    }

    public void W1(int id) {
        V1(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void V1(ColorStateList chipStrokeColor) {
        if (this.f1644c != chipStrokeColor) {
            this.f1644c = chipStrokeColor;
            if (this.f1673k) {
                d0(chipStrokeColor);
            }
            onStateChange(getState());
        }
    }

    public float O0() {
        return this.c;
    }

    public void Y1(int id) {
        X1(this.f1624a.getResources().getDimension(id));
    }

    public void X1(float chipStrokeWidth) {
        if (this.c != chipStrokeWidth) {
            this.c = chipStrokeWidth;
            this.f1651d.setStrokeWidth(chipStrokeWidth);
            if (this.f1673k) {
                super.e0(chipStrokeWidth);
            }
            invalidateSelf();
        }
    }

    public ColorStateList d1() {
        return this.f1650d;
    }

    public void x2(int id) {
        w2(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void w2(ColorStateList rippleColor) {
        if (this.f1650d != rippleColor) {
            this.f1650d = rippleColor;
            P2();
            onStateChange(getState());
        }
    }

    public CharSequence f1() {
        return this.f1633a;
    }

    public void B2(CharSequence text) {
        if (text == null) {
            text = "";
        }
        if (!TextUtils.equals(this.f1633a, text)) {
            this.f1633a = text;
            this.f1635a.m(true);
            invalidateSelf();
            t1();
        }
    }

    public oq0 g1() {
        return this.f1635a.e();
    }

    public void D2(int id) {
        C2(new oq0(this.f1624a, id));
    }

    public void C2(oq0 textAppearance) {
        this.f1635a.k(textAppearance, this.f1624a);
    }

    public TextUtils.TruncateAt Z0() {
        return this.f1631a;
    }

    public void o2(TextUtils.TruncateAt truncateAt) {
        this.f1631a = truncateAt;
    }

    public void P1(int id) {
        Q1(this.f1624a.getResources().getBoolean(id));
    }

    public void Q1(boolean chipIconVisible) {
        if (this.f1648c != chipIconVisible) {
            boolean oldShowsChipIcon = M2();
            this.f1648c = chipIconVisible;
            boolean newShowsChipIcon = M2();
            if (oldShowsChipIcon != newShowsChipIcon) {
                if (newShowsChipIcon) {
                    i0(this.f1630a);
                } else {
                    O2(this.f1630a);
                }
                invalidateSelf();
                t1();
            }
        }
    }

    public Drawable I0() {
        Drawable drawable = this.f1630a;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void K1(int id) {
        J1(AppCompatResources.getDrawable(this.f1624a, id));
    }

    public void J1(Drawable chipIcon) {
        Drawable oldChipIcon = I0();
        if (oldChipIcon != chipIcon) {
            float oldChipIconWidth = k0();
            this.f1630a = chipIcon != null ? DrawableCompat.wrap(chipIcon).mutate() : null;
            float newChipIconWidth = k0();
            O2(oldChipIcon);
            if (M2()) {
                i0(this.f1630a);
            }
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public ColorStateList K0() {
        return this.f1656e;
    }

    public void O1(int id) {
        N1(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void N1(ColorStateList chipIconTint) {
        this.f1654d = true;
        if (this.f1656e != chipIconTint) {
            this.f1656e = chipIconTint;
            if (M2()) {
                DrawableCompat.setTintList(this.f1630a, chipIconTint);
            }
            onStateChange(getState());
        }
    }

    public float J0() {
        return this.d;
    }

    public void M1(int id) {
        L1(this.f1624a.getResources().getDimension(id));
    }

    public void L1(float chipIconSize) {
        if (this.d != chipIconSize) {
            float oldChipIconWidth = k0();
            this.d = chipIconSize;
            float newChipIconWidth = k0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public boolean o1() {
        return this.f1658e;
    }

    public void m2(boolean closeIconVisible) {
        if (this.f1658e != closeIconVisible) {
            boolean oldShowsCloseIcon = N2();
            this.f1658e = closeIconVisible;
            boolean newShowsCloseIcon = N2();
            if (oldShowsCloseIcon != newShowsCloseIcon) {
                if (newShowsCloseIcon) {
                    i0(this.f1640b);
                } else {
                    O2(this.f1640b);
                }
                invalidateSelf();
                t1();
            }
        }
    }

    public Drawable P0() {
        Drawable drawable = this.f1640b;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void e2(int id) {
        a2(AppCompatResources.getDrawable(this.f1624a, id));
    }

    public void a2(Drawable closeIcon) {
        Drawable oldCloseIcon = P0();
        if (oldCloseIcon != closeIcon) {
            float oldCloseIconWidth = o0();
            this.f1640b = closeIcon != null ? DrawableCompat.wrap(closeIcon).mutate() : null;
            if (ye0.f5882a) {
                Q2();
            }
            float newCloseIconWidth = o0();
            O2(oldCloseIcon);
            if (N2()) {
                i0(this.f1640b);
            }
            invalidateSelf();
            if (oldCloseIconWidth != newCloseIconWidth) {
                t1();
            }
        }
    }

    private void Q2() {
        this.f1647c = new RippleDrawable(ye0.e(d1()), this.f1640b, a);
    }

    public ColorStateList V0() {
        return this.f1660f;
    }

    public void l2(int id) {
        k2(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void k2(ColorStateList closeIconTint) {
        if (this.f1660f != closeIconTint) {
            this.f1660f = closeIconTint;
            if (N2()) {
                DrawableCompat.setTintList(this.f1640b, closeIconTint);
            }
            onStateChange(getState());
        }
    }

    public float S0() {
        return this.e;
    }

    public void g2(int id) {
        f2(this.f1624a.getResources().getDimension(id));
    }

    public void f2(float closeIconSize) {
        if (this.e != closeIconSize) {
            this.e = closeIconSize;
            invalidateSelf();
            if (N2()) {
                t1();
            }
        }
    }

    public void b2(CharSequence closeIconContentDescription) {
        if (this.f1642b != closeIconContentDescription) {
            this.f1642b = BidiFormatter.getInstance().unicodeWrap(closeIconContentDescription);
            invalidateSelf();
        }
    }

    public CharSequence Q0() {
        return this.f1642b;
    }

    public boolean m1() {
        return this.f1661f;
    }

    public void w1(int id) {
        v1(this.f1624a.getResources().getBoolean(id));
    }

    public void v1(boolean checkable) {
        if (this.f1661f != checkable) {
            this.f1661f = checkable;
            float oldChipIconWidth = k0();
            if (!checkable && this.f1667h) {
                this.f1667h = false;
            }
            float newChipIconWidth = k0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public void B1(int id) {
        C1(this.f1624a.getResources().getBoolean(id));
    }

    public void C1(boolean checkedIconVisible) {
        if (this.f1664g != checkedIconVisible) {
            boolean oldShowsCheckedIcon = L2();
            this.f1664g = checkedIconVisible;
            boolean newShowsCheckedIcon = L2();
            if (oldShowsCheckedIcon != newShowsCheckedIcon) {
                if (newShowsCheckedIcon) {
                    i0(this.f1653d);
                } else {
                    O2(this.f1653d);
                }
                invalidateSelf();
                t1();
            }
        }
    }

    public Drawable D0() {
        return this.f1653d;
    }

    public void y1(int id) {
        x1(AppCompatResources.getDrawable(this.f1624a, id));
    }

    public void x1(Drawable checkedIcon) {
        if (this.f1653d != checkedIcon) {
            float oldChipIconWidth = k0();
            this.f1653d = checkedIcon;
            float newChipIconWidth = k0();
            O2(this.f1653d);
            i0(this.f1653d);
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public ColorStateList E0() {
        return this.f1663g;
    }

    public void A1(int id) {
        z1(AppCompatResources.getColorStateList(this.f1624a, id));
    }

    public void z1(ColorStateList checkedIconTint) {
        if (this.f1663g != checkedIconTint) {
            this.f1663g = checkedIconTint;
            if (s0()) {
                DrawableCompat.setTintList(this.f1653d, checkedIconTint);
            }
            onStateChange(getState());
        }
    }

    public g20 e1() {
        return this.f1632a;
    }

    public void A2(int id) {
        z2(g20.c(this.f1624a, id));
    }

    public void z2(g20 showMotionSpec) {
        this.f1632a = showMotionSpec;
    }

    public g20 a1() {
        return this.f1641b;
    }

    public void q2(int id) {
        p2(g20.c(this.f1624a, id));
    }

    public void p2(g20 hideMotionSpec) {
        this.f1641b = hideMotionSpec;
    }

    public float M0() {
        return this.f;
    }

    public void U1(int id) {
        T1(this.f1624a.getResources().getDimension(id));
    }

    public void T1(float chipStartPadding) {
        if (this.f != chipStartPadding) {
            this.f = chipStartPadding;
            invalidateSelf();
            t1();
        }
    }

    public float c1() {
        return this.g;
    }

    public void u2(int id) {
        t2(this.f1624a.getResources().getDimension(id));
    }

    public void t2(float iconStartPadding) {
        if (this.g != iconStartPadding) {
            float oldChipIconWidth = k0();
            this.g = iconStartPadding;
            float newChipIconWidth = k0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public float b1() {
        return this.h;
    }

    public void s2(int id) {
        r2(this.f1624a.getResources().getDimension(id));
    }

    public void r2(float iconEndPadding) {
        if (this.h != iconEndPadding) {
            float oldChipIconWidth = k0();
            this.h = iconEndPadding;
            float newChipIconWidth = k0();
            invalidateSelf();
            if (oldChipIconWidth != newChipIconWidth) {
                t1();
            }
        }
    }

    public float i1() {
        return this.i;
    }

    public void I2(int id) {
        H2(this.f1624a.getResources().getDimension(id));
    }

    public void H2(float textStartPadding) {
        if (this.i != textStartPadding) {
            this.i = textStartPadding;
            invalidateSelf();
            t1();
        }
    }

    public float h1() {
        return this.j;
    }

    public void F2(int id) {
        E2(this.f1624a.getResources().getDimension(id));
    }

    public void E2(float textEndPadding) {
        if (this.j != textEndPadding) {
            this.j = textEndPadding;
            invalidateSelf();
            t1();
        }
    }

    public float T0() {
        return this.k;
    }

    public void i2(int id) {
        h2(this.f1624a.getResources().getDimension(id));
    }

    public void h2(float closeIconStartPadding) {
        if (this.k != closeIconStartPadding) {
            this.k = closeIconStartPadding;
            invalidateSelf();
            if (N2()) {
                t1();
            }
        }
    }

    public float R0() {
        return this.l;
    }

    public void d2(int id) {
        c2(this.f1624a.getResources().getDimension(id));
    }

    public void c2(float closeIconEndPadding) {
        if (this.l != closeIconEndPadding) {
            this.l = closeIconEndPadding;
            invalidateSelf();
            if (N2()) {
                t1();
            }
        }
    }

    public float H0() {
        return this.m;
    }

    public void I1(int id) {
        H1(this.f1624a.getResources().getDimension(id));
    }

    public void H1(float chipEndPadding) {
        if (this.m != chipEndPadding) {
            this.m = chipEndPadding;
            invalidateSelf();
            t1();
        }
    }

    public void v2(int maxWidth) {
        this.f1671j = maxWidth;
    }

    /* access modifiers changed from: package-private */
    public boolean K2() {
        return this.f1672j;
    }

    /* access modifiers changed from: package-private */
    public void y2(boolean shouldDrawText) {
        this.f1672j = shouldDrawText;
    }
}
