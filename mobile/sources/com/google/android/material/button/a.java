package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class a {
    private static final boolean f;
    private static final boolean g;
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1561a;

    /* renamed from: a  reason: collision with other field name */
    private PorterDuff.Mode f1562a;

    /* renamed from: a  reason: collision with other field name */
    private Drawable f1563a;

    /* renamed from: a  reason: collision with other field name */
    private LayerDrawable f1564a;

    /* renamed from: a  reason: collision with other field name */
    private final MaterialButton f1565a;

    /* renamed from: a  reason: collision with other field name */
    private il0 f1566a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f1567a = false;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ColorStateList f1568b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1569b = false;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private ColorStateList f1570c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f1571c = false;
    private int d;

    /* renamed from: d  reason: collision with other field name */
    private boolean f1572d;
    private int e;

    /* renamed from: e  reason: collision with other field name */
    private boolean f1573e = true;

    /* renamed from: f  reason: collision with other field name */
    private int f1574f;

    /* renamed from: g  reason: collision with other field name */
    private int f1575g;

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        f = i >= 21;
        if (i < 21 || i > 22) {
            z = false;
        }
        g = z;
    }

    a(MaterialButton button, il0 shapeAppearanceModel) {
        this.f1565a = button;
        this.f1566a = shapeAppearanceModel;
    }

    /* access modifiers changed from: package-private */
    public void r(TypedArray attributes) {
        this.a = attributes.getDimensionPixelOffset(xc0.i2, 0);
        this.b = attributes.getDimensionPixelOffset(xc0.j2, 0);
        this.c = attributes.getDimensionPixelOffset(xc0.k2, 0);
        this.d = attributes.getDimensionPixelOffset(xc0.l2, 0);
        int i = xc0.p2;
        if (attributes.hasValue(i)) {
            int dimensionPixelSize = attributes.getDimensionPixelSize(i, -1);
            this.e = dimensionPixelSize;
            z(this.f1566a.w((float) dimensionPixelSize));
            this.f1571c = true;
        }
        this.f1574f = attributes.getDimensionPixelSize(xc0.z2, 0);
        this.f1562a = lv0.i(attributes.getInt(xc0.o2, -1), PorterDuff.Mode.SRC_IN);
        this.f1561a = o00.a(this.f1565a.getContext(), attributes, xc0.n2);
        this.f1568b = o00.a(this.f1565a.getContext(), attributes, xc0.y2);
        this.f1570c = o00.a(this.f1565a.getContext(), attributes, xc0.x2);
        this.f1572d = attributes.getBoolean(xc0.m2, false);
        this.f1575g = attributes.getDimensionPixelSize(xc0.q2, 0);
        this.f1573e = attributes.getBoolean(xc0.A2, true);
        int paddingStart = ViewCompat.getPaddingStart(this.f1565a);
        int paddingTop = this.f1565a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f1565a);
        int paddingBottom = this.f1565a.getPaddingBottom();
        if (attributes.hasValue(xc0.h2)) {
            t();
        } else {
            H();
        }
        ViewCompat.setPaddingRelative(this.f1565a, this.a + paddingStart, this.c + paddingTop, this.b + paddingEnd, this.d + paddingBottom);
    }

    private void H() {
        this.f1565a.setInternalBackground(a());
        p00 materialShapeDrawable = f();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.U((float) this.f1575g);
            materialShapeDrawable.setState(this.f1565a.getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f1569b = true;
        this.f1565a.setSupportBackgroundTintList(this.f1561a);
        this.f1565a.setSupportBackgroundTintMode(this.f1562a);
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.f1569b;
    }

    private InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.a, this.c, this.b, this.d);
    }

    /* access modifiers changed from: package-private */
    public void D(ColorStateList tintList) {
        if (this.f1561a != tintList) {
            this.f1561a = tintList;
            if (f() != null) {
                DrawableCompat.setTintList(f(), this.f1561a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f1561a;
    }

    /* access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        if (this.f1562a != mode) {
            this.f1562a = mode;
            if (f() != null && this.f1562a != null) {
                DrawableCompat.setTintMode(f(), this.f1562a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f1562a;
    }

    /* access modifiers changed from: package-private */
    public void A(boolean shouldDrawSurfaceColorStroke) {
        this.f1567a = shouldDrawSurfaceColorStroke;
        K();
    }

    private Drawable a() {
        int i;
        p00 backgroundDrawable = new p00(this.f1566a);
        backgroundDrawable.K(this.f1565a.getContext());
        DrawableCompat.setTintList(backgroundDrawable, this.f1561a);
        PorterDuff.Mode mode = this.f1562a;
        if (mode != null) {
            DrawableCompat.setTintMode(backgroundDrawable, mode);
        }
        backgroundDrawable.c0((float) this.f1574f, this.f1568b);
        p00 surfaceColorStrokeDrawable = new p00(this.f1566a);
        surfaceColorStrokeDrawable.setTint(0);
        float f2 = (float) this.f1574f;
        if (this.f1567a) {
            i = k00.d(this.f1565a, yb0.colorSurface);
        } else {
            i = 0;
        }
        surfaceColorStrokeDrawable.b0(f2, i);
        if (f) {
            p00 p00 = new p00(this.f1566a);
            this.f1563a = p00;
            DrawableCompat.setTint(p00, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(ye0.e(this.f1570c), L(new LayerDrawable(new Drawable[]{surfaceColorStrokeDrawable, backgroundDrawable})), this.f1563a);
            this.f1564a = rippleDrawable;
            return rippleDrawable;
        }
        xe0 xe0 = new xe0(this.f1566a);
        this.f1563a = xe0;
        DrawableCompat.setTintList(xe0, ye0.e(this.f1570c));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{surfaceColorStrokeDrawable, backgroundDrawable, this.f1563a});
        this.f1564a = layerDrawable;
        return L(layerDrawable);
    }

    /* access modifiers changed from: package-private */
    public void J(int height, int width) {
        Drawable drawable = this.f1563a;
        if (drawable != null) {
            drawable.setBounds(this.a, this.c, width - this.b, height - this.d);
        }
    }

    /* access modifiers changed from: package-private */
    public void s(int color) {
        if (f() != null) {
            f().setTint(color);
        }
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList rippleColor) {
        if (this.f1570c != rippleColor) {
            this.f1570c = rippleColor;
            boolean z = f;
            if (z && (this.f1565a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1565a.getBackground()).setColor(ye0.e(rippleColor));
            } else if (!z && (this.f1565a.getBackground() instanceof xe0)) {
                ((xe0) this.f1565a.getBackground()).setTintList(ye0.e(rippleColor));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.f1570c;
    }

    /* access modifiers changed from: package-private */
    public void B(ColorStateList strokeColor) {
        if (this.f1568b != strokeColor) {
            this.f1568b = strokeColor;
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        return this.f1568b;
    }

    /* access modifiers changed from: package-private */
    public void C(int strokeWidth) {
        if (this.f1574f != strokeWidth) {
            this.f1574f = strokeWidth;
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f1574f;
    }

    private void K() {
        int i;
        p00 materialShapeDrawable = f();
        p00 surfaceColorStrokeDrawable = n();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.c0((float) this.f1574f, this.f1568b);
            if (surfaceColorStrokeDrawable != null) {
                float f2 = (float) this.f1574f;
                if (this.f1567a) {
                    i = k00.d(this.f1565a, yb0.colorSurface);
                } else {
                    i = 0;
                }
                surfaceColorStrokeDrawable.b0(f2, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(int cornerRadius) {
        if (!this.f1571c || this.e != cornerRadius) {
            this.e = cornerRadius;
            this.f1571c = true;
            z(this.f1566a.w((float) cornerRadius));
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.e;
    }

    private p00 g(boolean getSurfaceColorStrokeDrawable) {
        LayerDrawable layerDrawable = this.f1564a;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f) {
            return (p00) ((LayerDrawable) ((InsetDrawable) this.f1564a.getDrawable(0)).getDrawable()).getDrawable(getSurfaceColorStrokeDrawable ^ true ? 1 : 0);
        }
        return (p00) this.f1564a.getDrawable(getSurfaceColorStrokeDrawable ^ true ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    public p00 f() {
        return g(false);
    }

    /* access modifiers changed from: package-private */
    public void u(boolean checkable) {
        this.f1572d = checkable;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f1572d;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f1573e;
    }

    /* access modifiers changed from: package-private */
    public void F(boolean toggleCheckedStateOnClick) {
        this.f1573e = toggleCheckedStateOnClick;
    }

    private p00 n() {
        return g(true);
    }

    private void I(il0 shapeAppearanceModel) {
        if (!g || this.f1569b) {
            if (f() != null) {
                f().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (n() != null) {
                n().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (e() != null) {
                e().setShapeAppearanceModel(shapeAppearanceModel);
                return;
            }
            return;
        }
        int paddingStart = ViewCompat.getPaddingStart(this.f1565a);
        int paddingTop = this.f1565a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f1565a);
        int paddingBottom = this.f1565a.getPaddingBottom();
        H();
        ViewCompat.setPaddingRelative(this.f1565a, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public ll0 e() {
        LayerDrawable layerDrawable = this.f1564a;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.f1564a.getNumberOfLayers() > 2) {
            return (ll0) this.f1564a.getDrawable(2);
        }
        return (ll0) this.f1564a.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public void z(il0 shapeAppearanceModel) {
        this.f1566a = shapeAppearanceModel;
        I(shapeAppearanceModel);
    }

    /* access modifiers changed from: package-private */
    public il0 i() {
        return this.f1566a;
    }

    public void w(int newInsetBottom) {
        G(this.c, newInsetBottom);
    }

    public int c() {
        return this.d;
    }

    public void x(int newInsetTop) {
        G(newInsetTop, this.d);
    }

    private void G(int newInsetTop, int newInsetBottom) {
        int paddingStart = ViewCompat.getPaddingStart(this.f1565a);
        int paddingTop = this.f1565a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f1565a);
        int paddingBottom = this.f1565a.getPaddingBottom();
        int oldInsetTop = this.c;
        int oldInsetBottom = this.d;
        this.d = newInsetBottom;
        this.c = newInsetTop;
        if (!this.f1569b) {
            H();
        }
        ViewCompat.setPaddingRelative(this.f1565a, paddingStart, (paddingTop + newInsetTop) - oldInsetTop, paddingEnd, (paddingBottom + newInsetBottom) - oldInsetBottom);
    }

    public int d() {
        return this.c;
    }
}
