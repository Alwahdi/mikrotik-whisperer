package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;

class a extends Drawable {
    float a;

    /* renamed from: a  reason: collision with other field name */
    private int f1778a;

    /* renamed from: a  reason: collision with other field name */
    private ColorStateList f1779a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f1780a;

    /* renamed from: a  reason: collision with other field name */
    private final Path f1781a = new Path();

    /* renamed from: a  reason: collision with other field name */
    private final Rect f1782a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    private final RectF f1783a = new RectF();

    /* renamed from: a  reason: collision with other field name */
    private final b f1784a = new b();

    /* renamed from: a  reason: collision with other field name */
    private il0 f1785a;

    /* renamed from: a  reason: collision with other field name */
    private final jl0 f1786a = jl0.k();

    /* renamed from: a  reason: collision with other field name */
    private boolean f1787a = true;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private final RectF f1788b = new RectF();
    private int c;
    private int d;
    private int e;

    a(il0 shapeAppearanceModel) {
        this.f1785a = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f1780a = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public void d(float width) {
        if (this.a != width) {
            this.a = width;
            this.f1780a.setStrokeWidth(1.3333f * width);
            this.f1787a = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList tint) {
        if (tint != null) {
            this.e = tint.getColorForState(getState(), this.e);
        }
        this.f1779a = tint;
        this.f1787a = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1780a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void e(int topOuterStrokeColor, int topInnerStrokeColor, int bottomOuterStrokeColor, int bottomInnerStrokeColor) {
        this.f1778a = topOuterStrokeColor;
        this.b = topInnerStrokeColor;
        this.c = bottomOuterStrokeColor;
        this.d = bottomInnerStrokeColor;
    }

    public void draw(Canvas canvas) {
        if (this.f1787a) {
            this.f1780a.setShader(a());
            this.f1787a = false;
        }
        float halfBorderWidth = this.f1780a.getStrokeWidth() / 2.0f;
        copyBounds(this.f1782a);
        this.f1783a.set(this.f1782a);
        float radius = Math.min(this.f1785a.r().a(b()), this.f1783a.width() / 2.0f);
        if (this.f1785a.u(b())) {
            this.f1783a.inset(halfBorderWidth, halfBorderWidth);
            canvas.drawRoundRect(this.f1783a, radius, radius, this.f1780a);
        }
    }

    public void getOutline(Outline outline) {
        if (this.f1785a.u(b())) {
            outline.setRoundRect(getBounds(), this.f1785a.r().a(b()));
            return;
        }
        copyBounds(this.f1782a);
        this.f1783a.set(this.f1782a);
        this.f1786a.e(this.f1785a, 1.0f, this.f1783a, this.f1781a);
        yh.j(outline, this.f1781a);
    }

    public boolean getPadding(Rect padding) {
        if (!this.f1785a.u(b())) {
            return true;
        }
        int borderWidth = Math.round(this.a);
        padding.set(borderWidth, borderWidth, borderWidth, borderWidth);
        return true;
    }

    /* access modifiers changed from: protected */
    public RectF b() {
        this.f1788b.set(getBounds());
        return this.f1788b;
    }

    public void f(il0 shapeAppearanceModel) {
        this.f1785a = shapeAppearanceModel;
        invalidateSelf();
    }

    public void setAlpha(int alpha) {
        this.f1780a.setAlpha(alpha);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.a > 0.0f ? -3 : -2;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect bounds) {
        this.f1787a = true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f1779a;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] state) {
        int newColor;
        ColorStateList colorStateList = this.f1779a;
        if (!(colorStateList == null || (newColor = colorStateList.getColorForState(state, this.e)) == this.e)) {
            this.f1787a = true;
            this.e = newColor;
        }
        if (this.f1787a != 0) {
            invalidateSelf();
        }
        return this.f1787a;
    }

    private Shader a() {
        Rect rect = this.f1782a;
        copyBounds(rect);
        float borderRatio = this.a / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.compositeColors(this.f1778a, this.e), ColorUtils.compositeColors(this.b, this.e), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.b, 0), this.e), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.d, 0), this.e), ColorUtils.compositeColors(this.d, this.e), ColorUtils.compositeColors(this.c, this.e)}, new float[]{0.0f, borderRatio, 0.5f, 0.5f, 1.0f - borderRatio, 1.0f}, Shader.TileMode.CLAMP);
    }

    public Drawable.ConstantState getConstantState() {
        return this.f1784a;
    }

    private class b extends Drawable.ConstantState {
        private b() {
        }

        public Drawable newDrawable() {
            return a.this;
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }
}
