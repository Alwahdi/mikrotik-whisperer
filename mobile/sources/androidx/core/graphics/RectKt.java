package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

public final class RectKt {
    public static final int component1(Rect $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.left;
    }

    public static final int component2(Rect $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.top;
    }

    public static final int component3(Rect $this$component3) {
        lu.f($this$component3, "<this>");
        return $this$component3.right;
    }

    public static final int component4(Rect $this$component4) {
        lu.f($this$component4, "<this>");
        return $this$component4.bottom;
    }

    public static final float component1(RectF $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.left;
    }

    public static final float component2(RectF $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.top;
    }

    public static final float component3(RectF $this$component3) {
        lu.f($this$component3, "<this>");
        return $this$component3.right;
    }

    public static final float component4(RectF $this$component4) {
        lu.f($this$component4, "<this>");
        return $this$component4.bottom;
    }

    public static final Rect plus(Rect $this$plus, Rect r) {
        lu.f($this$plus, "<this>");
        lu.f(r, "r");
        Rect $this$plus_u24lambda_u2d0 = new Rect($this$plus);
        $this$plus_u24lambda_u2d0.union(r);
        return $this$plus_u24lambda_u2d0;
    }

    public static final RectF plus(RectF $this$plus, RectF r) {
        lu.f($this$plus, "<this>");
        lu.f(r, "r");
        RectF $this$plus_u24lambda_u2d1 = new RectF($this$plus);
        $this$plus_u24lambda_u2d1.union(r);
        return $this$plus_u24lambda_u2d1;
    }

    public static final Rect plus(Rect $this$plus, int xy) {
        lu.f($this$plus, "<this>");
        Rect $this$plus_u24lambda_u2d2 = new Rect($this$plus);
        $this$plus_u24lambda_u2d2.offset(xy, xy);
        return $this$plus_u24lambda_u2d2;
    }

    public static final RectF plus(RectF $this$plus, float xy) {
        lu.f($this$plus, "<this>");
        RectF $this$plus_u24lambda_u2d3 = new RectF($this$plus);
        $this$plus_u24lambda_u2d3.offset(xy, xy);
        return $this$plus_u24lambda_u2d3;
    }

    public static final Rect plus(Rect $this$plus, Point xy) {
        lu.f($this$plus, "<this>");
        lu.f(xy, "xy");
        Rect $this$plus_u24lambda_u2d4 = new Rect($this$plus);
        $this$plus_u24lambda_u2d4.offset(xy.x, xy.y);
        return $this$plus_u24lambda_u2d4;
    }

    public static final RectF plus(RectF $this$plus, PointF xy) {
        lu.f($this$plus, "<this>");
        lu.f(xy, "xy");
        RectF $this$plus_u24lambda_u2d5 = new RectF($this$plus);
        $this$plus_u24lambda_u2d5.offset(xy.x, xy.y);
        return $this$plus_u24lambda_u2d5;
    }

    public static final Region minus(Rect $this$minus, Rect r) {
        lu.f($this$minus, "<this>");
        lu.f(r, "r");
        Region $this$minus_u24lambda_u2d6 = new Region($this$minus);
        $this$minus_u24lambda_u2d6.op(r, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u2d6;
    }

    public static final Region minus(RectF $this$minus, RectF r) {
        lu.f($this$minus, "<this>");
        lu.f(r, "r");
        Rect r$iv = new Rect();
        $this$minus.roundOut(r$iv);
        Region $this$minus_u24lambda_u2d7 = new Region(r$iv);
        Rect r$iv2 = new Rect();
        r.roundOut(r$iv2);
        $this$minus_u24lambda_u2d7.op(r$iv2, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u2d7;
    }

    public static final Rect minus(Rect $this$minus, int xy) {
        lu.f($this$minus, "<this>");
        Rect $this$minus_u24lambda_u2d8 = new Rect($this$minus);
        $this$minus_u24lambda_u2d8.offset(-xy, -xy);
        return $this$minus_u24lambda_u2d8;
    }

    public static final RectF minus(RectF $this$minus, float xy) {
        lu.f($this$minus, "<this>");
        RectF $this$minus_u24lambda_u2d9 = new RectF($this$minus);
        $this$minus_u24lambda_u2d9.offset(-xy, -xy);
        return $this$minus_u24lambda_u2d9;
    }

    public static final Rect minus(Rect $this$minus, Point xy) {
        lu.f($this$minus, "<this>");
        lu.f(xy, "xy");
        Rect $this$minus_u24lambda_u2d10 = new Rect($this$minus);
        $this$minus_u24lambda_u2d10.offset(-xy.x, -xy.y);
        return $this$minus_u24lambda_u2d10;
    }

    public static final RectF minus(RectF $this$minus, PointF xy) {
        lu.f($this$minus, "<this>");
        lu.f(xy, "xy");
        RectF $this$minus_u24lambda_u2d11 = new RectF($this$minus);
        $this$minus_u24lambda_u2d11.offset(-xy.x, -xy.y);
        return $this$minus_u24lambda_u2d11;
    }

    public static final Rect times(Rect $this$times, int factor) {
        lu.f($this$times, "<this>");
        Rect rect = new Rect($this$times);
        Rect $this$times_u24lambda_u2d12 = rect;
        $this$times_u24lambda_u2d12.top *= factor;
        $this$times_u24lambda_u2d12.left *= factor;
        $this$times_u24lambda_u2d12.right *= factor;
        $this$times_u24lambda_u2d12.bottom *= factor;
        return rect;
    }

    public static final RectF times(RectF $this$times, int factor) {
        lu.f($this$times, "<this>");
        float factor$iv = (float) factor;
        RectF rectF = new RectF($this$times);
        RectF $this$times_u24lambda_u2d13$iv = rectF;
        $this$times_u24lambda_u2d13$iv.top *= factor$iv;
        $this$times_u24lambda_u2d13$iv.left *= factor$iv;
        $this$times_u24lambda_u2d13$iv.right *= factor$iv;
        $this$times_u24lambda_u2d13$iv.bottom *= factor$iv;
        return rectF;
    }

    public static final RectF times(RectF $this$times, float factor) {
        lu.f($this$times, "<this>");
        RectF rectF = new RectF($this$times);
        RectF $this$times_u24lambda_u2d13 = rectF;
        $this$times_u24lambda_u2d13.top *= factor;
        $this$times_u24lambda_u2d13.left *= factor;
        $this$times_u24lambda_u2d13.right *= factor;
        $this$times_u24lambda_u2d13.bottom *= factor;
        return rectF;
    }

    public static final Rect or(Rect $this$or, Rect r) {
        lu.f($this$or, "<this>");
        lu.f(r, "r");
        Rect $this$plus_u24lambda_u2d0$iv = new Rect($this$or);
        $this$plus_u24lambda_u2d0$iv.union(r);
        return $this$plus_u24lambda_u2d0$iv;
    }

    public static final RectF or(RectF $this$or, RectF r) {
        lu.f($this$or, "<this>");
        lu.f(r, "r");
        RectF $this$plus_u24lambda_u2d1$iv = new RectF($this$or);
        $this$plus_u24lambda_u2d1$iv.union(r);
        return $this$plus_u24lambda_u2d1$iv;
    }

    public static final Rect and(Rect $this$and, Rect r) {
        lu.f($this$and, "<this>");
        lu.f(r, "r");
        Rect $this$and_u24lambda_u2d14 = new Rect($this$and);
        $this$and_u24lambda_u2d14.intersect(r);
        return $this$and_u24lambda_u2d14;
    }

    public static final RectF and(RectF $this$and, RectF r) {
        lu.f($this$and, "<this>");
        lu.f(r, "r");
        RectF $this$and_u24lambda_u2d15 = new RectF($this$and);
        $this$and_u24lambda_u2d15.intersect(r);
        return $this$and_u24lambda_u2d15;
    }

    public static final Region xor(Rect $this$xor, Rect r) {
        lu.f($this$xor, "<this>");
        lu.f(r, "r");
        Region $this$xor_u24lambda_u2d16 = new Region($this$xor);
        $this$xor_u24lambda_u2d16.op(r, Region.Op.XOR);
        return $this$xor_u24lambda_u2d16;
    }

    public static final Region xor(RectF $this$xor, RectF r) {
        lu.f($this$xor, "<this>");
        lu.f(r, "r");
        Rect r$iv = new Rect();
        $this$xor.roundOut(r$iv);
        Region $this$xor_u24lambda_u2d17 = new Region(r$iv);
        Rect r$iv2 = new Rect();
        r.roundOut(r$iv2);
        $this$xor_u24lambda_u2d17.op(r$iv2, Region.Op.XOR);
        return $this$xor_u24lambda_u2d17;
    }

    public static final boolean contains(Rect $this$contains, Point p) {
        lu.f($this$contains, "<this>");
        lu.f(p, "p");
        return $this$contains.contains(p.x, p.y);
    }

    public static final boolean contains(RectF $this$contains, PointF p) {
        lu.f($this$contains, "<this>");
        lu.f(p, "p");
        return $this$contains.contains(p.x, p.y);
    }

    public static final RectF toRectF(Rect $this$toRectF) {
        lu.f($this$toRectF, "<this>");
        return new RectF($this$toRectF);
    }

    public static final Rect toRect(RectF $this$toRect) {
        lu.f($this$toRect, "<this>");
        Rect r = new Rect();
        $this$toRect.roundOut(r);
        return r;
    }

    public static final Region toRegion(Rect $this$toRegion) {
        lu.f($this$toRegion, "<this>");
        return new Region($this$toRegion);
    }

    public static final Region toRegion(RectF $this$toRegion) {
        lu.f($this$toRegion, "<this>");
        Rect r$iv = new Rect();
        $this$toRegion.roundOut(r$iv);
        return new Region(r$iv);
    }

    public static final RectF transform(RectF $this$transform, Matrix m) {
        lu.f($this$transform, "<this>");
        lu.f(m, "m");
        RectF rectF = $this$transform;
        m.mapRect($this$transform);
        return $this$transform;
    }
}
