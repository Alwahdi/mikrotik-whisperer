package defpackage;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* renamed from: jl0  reason: default package */
public class jl0 {
    private final Path a = new Path();

    /* renamed from: a  reason: collision with other field name */
    private final PointF f4063a = new PointF();

    /* renamed from: a  reason: collision with other field name */
    private final kl0 f4064a = new kl0();

    /* renamed from: a  reason: collision with other field name */
    private boolean f4065a = true;

    /* renamed from: a  reason: collision with other field name */
    private final float[] f4066a = new float[2];

    /* renamed from: a  reason: collision with other field name */
    private final Matrix[] f4067a = new Matrix[4];

    /* renamed from: a  reason: collision with other field name */
    private final kl0[] f4068a = new kl0[4];
    private final Path b = new Path();

    /* renamed from: b  reason: collision with other field name */
    private final float[] f4069b = new float[2];

    /* renamed from: b  reason: collision with other field name */
    private final Matrix[] f4070b = new Matrix[4];
    private final Path c = new Path();
    private final Path d = new Path();

    /* renamed from: jl0$a */
    private static class a {
        static final jl0 a = new jl0();
    }

    /* renamed from: jl0$b */
    public interface b {
        void a(kl0 kl0, Matrix matrix, int i);

        void b(kl0 kl0, Matrix matrix, int i);
    }

    public jl0() {
        for (int i = 0; i < 4; i++) {
            this.f4068a[i] = new kl0();
            this.f4067a[i] = new Matrix();
            this.f4070b[i] = new Matrix();
        }
    }

    public static jl0 k() {
        return a.a;
    }

    public void e(il0 shapeAppearanceModel, float interpolation, RectF bounds, Path path) {
        d(shapeAppearanceModel, interpolation, bounds, (b) null, path);
    }

    public void d(il0 shapeAppearanceModel, float interpolation, RectF bounds, b pathListener, Path path) {
        path.rewind();
        this.a.rewind();
        this.b.rewind();
        this.b.addRect(bounds, Path.Direction.CW);
        c cVar = new c(shapeAppearanceModel, interpolation, bounds, pathListener, path);
        for (int index = 0; index < 4; index++) {
            m(cVar, index);
            n(index);
        }
        for (int index2 = 0; index2 < 4; index2++) {
            b(cVar, index2);
            c(cVar, index2);
        }
        path.close();
        this.a.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.a.isEmpty()) {
            path.op(this.a, Path.Op.UNION);
        }
    }

    private void m(c spec, int index) {
        h(index, spec.f4073a).b(this.f4068a[index], 90.0f, spec.a, spec.f4072a, g(index, spec.f4073a));
        float edgeAngle = a(index);
        this.f4067a[index].reset();
        f(index, spec.f4072a, this.f4063a);
        Matrix matrix = this.f4067a[index];
        PointF pointF = this.f4063a;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f4067a[index].preRotate(edgeAngle);
    }

    private void n(int index) {
        this.f4066a[0] = this.f4068a[index].i();
        this.f4066a[1] = this.f4068a[index].j();
        this.f4067a[index].mapPoints(this.f4066a);
        float edgeAngle = a(index);
        this.f4070b[index].reset();
        Matrix matrix = this.f4070b[index];
        float[] fArr = this.f4066a;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f4070b[index].preRotate(edgeAngle);
    }

    private void b(c spec, int index) {
        this.f4066a[0] = this.f4068a[index].k();
        this.f4066a[1] = this.f4068a[index].l();
        this.f4067a[index].mapPoints(this.f4066a);
        if (index == 0) {
            Path path = spec.f4071a;
            float[] fArr = this.f4066a;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = spec.f4071a;
            float[] fArr2 = this.f4066a;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f4068a[index].d(this.f4067a[index], spec.f4071a);
        b bVar = spec.f4074a;
        if (bVar != null) {
            bVar.a(this.f4068a[index], this.f4067a[index], index);
        }
    }

    private void c(c spec, int index) {
        int nextIndex = (index + 1) % 4;
        this.f4066a[0] = this.f4068a[index].i();
        this.f4066a[1] = this.f4068a[index].j();
        this.f4067a[index].mapPoints(this.f4066a);
        this.f4069b[0] = this.f4068a[nextIndex].k();
        this.f4069b[1] = this.f4068a[nextIndex].l();
        this.f4067a[nextIndex].mapPoints(this.f4069b);
        float[] fArr = this.f4066a;
        float f = fArr[0];
        float[] fArr2 = this.f4069b;
        float edgeLength = Math.max(((float) Math.hypot((double) (f - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float center = i(spec.f4072a, index);
        this.f4064a.n(0.0f, 0.0f);
        ai edgeTreatment = j(index, spec.f4073a);
        edgeTreatment.b(edgeLength, center, spec.a, this.f4064a);
        this.c.reset();
        this.f4064a.d(this.f4070b[index], this.c);
        if (!this.f4065a || Build.VERSION.SDK_INT < 19 || (!edgeTreatment.a() && !l(this.c, index) && !l(this.c, nextIndex))) {
            this.f4064a.d(this.f4070b[index], spec.f4071a);
        } else {
            Path path = this.c;
            path.op(path, this.b, Path.Op.DIFFERENCE);
            this.f4066a[0] = this.f4064a.k();
            this.f4066a[1] = this.f4064a.l();
            this.f4070b[index].mapPoints(this.f4066a);
            Path path2 = this.a;
            float[] fArr3 = this.f4066a;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f4064a.d(this.f4070b[index], this.a);
        }
        b bVar = spec.f4074a;
        if (bVar != null) {
            bVar.b(this.f4064a, this.f4070b[index], index);
        }
    }

    private boolean l(Path edgePath, int index) {
        this.d.reset();
        this.f4068a[index].d(this.f4067a[index], this.d);
        RectF bounds = new RectF();
        edgePath.computeBounds(bounds, true);
        this.d.computeBounds(bounds, true);
        edgePath.op(this.d, Path.Op.INTERSECT);
        edgePath.computeBounds(bounds, true);
        if (!bounds.isEmpty()) {
            return true;
        }
        if (bounds.width() <= 1.0f || bounds.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private float i(RectF bounds, int index) {
        float[] fArr = this.f4066a;
        kl0[] kl0Arr = this.f4068a;
        fArr[0] = kl0Arr[index].c;
        fArr[1] = kl0Arr[index].d;
        this.f4067a[index].mapPoints(fArr);
        switch (index) {
            case 1:
            case 3:
                return Math.abs(bounds.centerX() - this.f4066a[0]);
            default:
                return Math.abs(bounds.centerY() - this.f4066a[1]);
        }
    }

    private xc h(int index, il0 shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.k();
            case 2:
                return shapeAppearanceModel.i();
            case 3:
                return shapeAppearanceModel.q();
            default:
                return shapeAppearanceModel.s();
        }
    }

    private wc g(int index, il0 shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.l();
            case 2:
                return shapeAppearanceModel.j();
            case 3:
                return shapeAppearanceModel.r();
            default:
                return shapeAppearanceModel.t();
        }
    }

    private ai j(int index, il0 shapeAppearanceModel) {
        switch (index) {
            case 1:
                return shapeAppearanceModel.h();
            case 2:
                return shapeAppearanceModel.n();
            case 3:
                return shapeAppearanceModel.p();
            default:
                return shapeAppearanceModel.o();
        }
    }

    private void f(int index, RectF bounds, PointF pointF) {
        switch (index) {
            case 1:
                pointF.set(bounds.right, bounds.bottom);
                return;
            case 2:
                pointF.set(bounds.left, bounds.bottom);
                return;
            case 3:
                pointF.set(bounds.left, bounds.top);
                return;
            default:
                pointF.set(bounds.right, bounds.top);
                return;
        }
    }

    private float a(int index) {
        return (float) (((index + 1) % 4) * 90);
    }

    /* renamed from: jl0$c */
    static final class c {
        public final float a;

        /* renamed from: a  reason: collision with other field name */
        public final Path f4071a;

        /* renamed from: a  reason: collision with other field name */
        public final RectF f4072a;

        /* renamed from: a  reason: collision with other field name */
        public final il0 f4073a;

        /* renamed from: a  reason: collision with other field name */
        public final b f4074a;

        c(il0 shapeAppearanceModel, float interpolation, RectF bounds, b pathListener, Path path) {
            this.f4074a = pathListener;
            this.f4073a = shapeAppearanceModel;
            this.a = interpolation;
            this.f4072a = bounds;
            this.f4071a = path;
        }
    }
}
