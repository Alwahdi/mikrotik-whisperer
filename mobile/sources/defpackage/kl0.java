package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: kl0  reason: default package */
public class kl0 {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    private final List<f> f4119a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f4120a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    private final List<g> f4121b = new ArrayList();
    public float c;
    public float d;
    public float e;
    public float f;

    /* renamed from: kl0$f */
    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public kl0() {
        n(0.0f, 0.0f);
    }

    public void n(float startX, float startY) {
        o(startX, startY, 270.0f, 0.0f);
    }

    public void o(float startX, float startY, float shadowStartAngle, float shadowSweepAngle) {
        t(startX);
        u(startY);
        r(startX);
        s(startY);
        p(shadowStartAngle);
        q((shadowStartAngle + shadowSweepAngle) % 360.0f);
        this.f4119a.clear();
        this.f4121b.clear();
        this.f4120a = false;
    }

    public void m(float x, float y) {
        e operation = new e();
        float unused = operation.a = x;
        float unused2 = operation.b = y;
        this.f4119a.add(operation);
        c shadowOperation = new c(operation, i(), j());
        c(shadowOperation, shadowOperation.c() + 270.0f, shadowOperation.c() + 270.0f);
        r(x);
        s(y);
    }

    public void a(float left, float top, float right, float bottom, float startAngle, float sweepAngle) {
        float f2 = left;
        float f3 = top;
        float f4 = right;
        float f5 = bottom;
        float f6 = startAngle;
        float f7 = sweepAngle;
        d operation = new d(f2, f3, f4, f5);
        operation.s(f6);
        operation.t(f7);
        this.f4119a.add(operation);
        b arcShadowOperation = new b(operation);
        float endAngle = f6 + f7;
        boolean drawShadowInsideBounds = f7 < 0.0f;
        c(arcShadowOperation, drawShadowInsideBounds ? (f6 + 180.0f) % 360.0f : f6, drawShadowInsideBounds ? (180.0f + endAngle) % 360.0f : endAngle);
        r(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians((double) (f6 + f7))))));
        s(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians((double) (f6 + f7))))));
    }

    public void d(Matrix transform, Path path) {
        int size = this.f4119a.size();
        for (int i = 0; i < size; i++) {
            this.f4119a.get(i).a(transform, path);
        }
    }

    /* access modifiers changed from: package-private */
    public g f(Matrix transform) {
        b(h());
        return new a(new ArrayList<>(this.f4121b), new Matrix(transform));
    }

    /* renamed from: kl0$a */
    class a extends g {
        final /* synthetic */ List a;
        final /* synthetic */ Matrix c;

        a(List list, Matrix matrix) {
            this.a = list;
            this.c = matrix;
        }

        public void b(Matrix matrix, gl0 shadowRenderer, int shadowElevation, Canvas canvas) {
            for (g op : this.a) {
                op.b(this.c, shadowRenderer, shadowElevation, canvas);
            }
        }
    }

    private void c(g shadowOperation, float startShadowAngle, float endShadowAngle) {
        b(startShadowAngle);
        this.f4121b.add(shadowOperation);
        p(endShadowAngle);
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f4120a;
    }

    private void b(float nextShadowAngle) {
        if (g() != nextShadowAngle) {
            float shadowSweep = ((nextShadowAngle - g()) + 360.0f) % 360.0f;
            if (shadowSweep <= 180.0f) {
                d pathArcOperation = new d(i(), j(), i(), j());
                pathArcOperation.s(g());
                pathArcOperation.t(shadowSweep);
                this.f4121b.add(new b(pathArcOperation));
                p(nextShadowAngle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.d;
    }

    private float g() {
        return this.e;
    }

    private float h() {
        return this.f;
    }

    private void t(float startX) {
        this.a = startX;
    }

    private void u(float startY) {
        this.b = startY;
    }

    private void r(float endX) {
        this.c = endX;
    }

    private void s(float endY) {
        this.d = endY;
    }

    private void p(float currentShadowAngle) {
        this.e = currentShadowAngle;
    }

    private void q(float endShadowAngle) {
        this.f = endShadowAngle;
    }

    /* renamed from: kl0$g */
    static abstract class g {
        static final Matrix b = new Matrix();
        final Matrix a = new Matrix();

        public abstract void b(Matrix matrix, gl0 gl0, int i, Canvas canvas);

        g() {
        }

        public final void a(gl0 shadowRenderer, int shadowElevation, Canvas canvas) {
            b(b, shadowRenderer, shadowElevation, canvas);
        }
    }

    /* renamed from: kl0$c */
    static class c extends g {
        private final float a;

        /* renamed from: a  reason: collision with other field name */
        private final e f4123a;
        private final float b;

        public c(e operation, float startX, float startY) {
            this.f4123a = operation;
            this.a = startX;
            this.b = startY;
        }

        public void b(Matrix transform, gl0 shadowRenderer, int shadowElevation, Canvas canvas) {
            RectF rect = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f4123a.b - this.b), (double) (this.f4123a.a - this.a)), 0.0f);
            this.a.set(transform);
            this.a.preTranslate(this.a, this.b);
            this.a.preRotate(c());
            shadowRenderer.b(canvas, this.a, rect, shadowElevation);
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f4123a.b - this.b) / (this.f4123a.a - this.a))));
        }
    }

    /* renamed from: kl0$b */
    static class b extends g {
        private final d a;

        public b(d operation) {
            this.a = operation;
        }

        public void b(Matrix transform, gl0 shadowRenderer, int shadowElevation, Canvas canvas) {
            float startAngle = this.a.m();
            float sweepAngle = this.a.n();
            shadowRenderer.a(canvas, transform, new RectF(this.a.k(), this.a.o(), this.a.l(), this.a.j()), shadowElevation, startAngle, sweepAngle);
        }
    }

    /* renamed from: kl0$e */
    public static class e extends f {
        /* access modifiers changed from: private */
        public float a;
        /* access modifiers changed from: private */
        public float b;

        public void a(Matrix transform, Path path) {
            Matrix inverse = this.a;
            transform.invert(inverse);
            path.transform(inverse);
            path.lineTo(this.a, this.b);
            path.transform(transform);
        }
    }

    /* renamed from: kl0$d */
    public static class d extends f {
        private static final RectF a = new RectF();

        /* renamed from: a  reason: collision with other field name */
        public float f4124a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public d(float left, float top, float right, float bottom) {
            q(left);
            u(top);
            r(right);
            p(bottom);
        }

        public void a(Matrix transform, Path path) {
            Matrix inverse = this.a;
            transform.invert(inverse);
            path.transform(inverse);
            RectF rectF = a;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(transform);
        }

        /* access modifiers changed from: private */
        public float k() {
            return this.f4124a;
        }

        /* access modifiers changed from: private */
        public float o() {
            return this.b;
        }

        /* access modifiers changed from: private */
        public float l() {
            return this.c;
        }

        /* access modifiers changed from: private */
        public float j() {
            return this.d;
        }

        private void q(float left) {
            this.f4124a = left;
        }

        private void u(float top) {
            this.b = top;
        }

        private void r(float right) {
            this.c = right;
        }

        private void p(float bottom) {
            this.d = bottom;
        }

        /* access modifiers changed from: private */
        public float m() {
            return this.e;
        }

        /* access modifiers changed from: private */
        public float n() {
            return this.f;
        }

        /* access modifiers changed from: private */
        public void s(float startAngle) {
            this.e = startAngle;
        }

        /* access modifiers changed from: private */
        public void t(float sweepAngle) {
            this.f = sweepAngle;
        }
    }
}
