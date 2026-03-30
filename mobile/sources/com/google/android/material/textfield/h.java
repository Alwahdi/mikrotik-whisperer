package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import defpackage.p00;

abstract class h extends p00 {
    b a;

    static h j0(il0 shapeAppearanceModel) {
        return k0(new b(shapeAppearanceModel != null ? shapeAppearanceModel : new il0(), new RectF()));
    }

    /* access modifiers changed from: private */
    public static h k0(b drawableState) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new d(drawableState);
        }
        return new c(drawableState);
    }

    private h(b drawableState) {
        super((p00.c) drawableState);
        this.a = drawableState;
    }

    public Drawable mutate() {
        this.a = new b(this.a);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean l0() {
        return !this.a.a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void n0(float left, float top, float right, float bottom) {
        if (left != this.a.a.left || top != this.a.a.top || right != this.a.a.right || bottom != this.a.a.bottom) {
            this.a.a.set(left, top, right, bottom);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void o0(RectF bounds) {
        n0(bounds.left, bounds.top, bounds.right, bounds.bottom);
    }

    /* access modifiers changed from: package-private */
    public void m0() {
        n0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    private static class d extends h {
        d(b drawableState) {
            super(drawableState);
        }

        /* access modifiers changed from: protected */
        public void r(Canvas canvas) {
            if (this.a.a.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(this.a.a);
            } else {
                canvas.clipRect(this.a.a, Region.Op.DIFFERENCE);
            }
            super.r(canvas);
            canvas.restore();
        }
    }

    private static class c extends h {
        private int b;
        private Paint d;

        c(b drawableState) {
            super(drawableState);
        }

        public void draw(Canvas canvas) {
            r0(canvas);
            super.draw(canvas);
            q0(canvas);
        }

        /* access modifiers changed from: protected */
        public void r(Canvas canvas) {
            super.r(canvas);
            canvas.drawRect(this.a.a, p0());
        }

        private Paint p0() {
            if (this.d == null) {
                Paint paint = new Paint(1);
                this.d = paint;
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                this.d.setColor(-1);
                this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            }
            return this.d;
        }

        private void r0(Canvas canvas) {
            Drawable.Callback callback = getCallback();
            if (t0(callback)) {
                View viewCallback = (View) callback;
                if (viewCallback.getLayerType() != 2) {
                    viewCallback.setLayerType(2, (Paint) null);
                    return;
                }
                return;
            }
            s0(canvas);
        }

        private void s0(Canvas canvas) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.b = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
                return;
            }
            this.b = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }

        private void q0(Canvas canvas) {
            if (!t0(getCallback())) {
                canvas.restoreToCount(this.b);
            }
        }

        private boolean t0(Drawable.Callback callback) {
            return callback instanceof View;
        }
    }

    private static final class b extends p00.c {
        /* access modifiers changed from: private */
        public final RectF a;

        private b(il0 shapeAppearanceModel, RectF cutoutBounds) {
            super(shapeAppearanceModel, (di) null);
            this.a = cutoutBounds;
        }

        private b(b state) {
            super(state);
            this.a = state.a;
        }

        public Drawable newDrawable() {
            h drawable = h.k0(this);
            drawable.invalidateSelf();
            return drawable;
        }
    }
}
