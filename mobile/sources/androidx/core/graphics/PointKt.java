package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;

public final class PointKt {
    public static final int component1(Point $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.x;
    }

    public static final int component2(Point $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.y;
    }

    public static final float component1(PointF $this$component1) {
        lu.f($this$component1, "<this>");
        return $this$component1.x;
    }

    public static final float component2(PointF $this$component2) {
        lu.f($this$component2, "<this>");
        return $this$component2.y;
    }

    public static final Point plus(Point $this$plus, Point p) {
        lu.f($this$plus, "<this>");
        lu.f(p, "p");
        Point $this$plus_u24lambda_u2d0 = new Point($this$plus.x, $this$plus.y);
        $this$plus_u24lambda_u2d0.offset(p.x, p.y);
        return $this$plus_u24lambda_u2d0;
    }

    public static final PointF plus(PointF $this$plus, PointF p) {
        lu.f($this$plus, "<this>");
        lu.f(p, "p");
        PointF $this$plus_u24lambda_u2d1 = new PointF($this$plus.x, $this$plus.y);
        $this$plus_u24lambda_u2d1.offset(p.x, p.y);
        return $this$plus_u24lambda_u2d1;
    }

    public static final Point plus(Point $this$plus, int xy) {
        lu.f($this$plus, "<this>");
        Point $this$plus_u24lambda_u2d2 = new Point($this$plus.x, $this$plus.y);
        $this$plus_u24lambda_u2d2.offset(xy, xy);
        return $this$plus_u24lambda_u2d2;
    }

    public static final PointF plus(PointF $this$plus, float xy) {
        lu.f($this$plus, "<this>");
        PointF $this$plus_u24lambda_u2d3 = new PointF($this$plus.x, $this$plus.y);
        $this$plus_u24lambda_u2d3.offset(xy, xy);
        return $this$plus_u24lambda_u2d3;
    }

    public static final Point minus(Point $this$minus, Point p) {
        lu.f($this$minus, "<this>");
        lu.f(p, "p");
        Point $this$minus_u24lambda_u2d4 = new Point($this$minus.x, $this$minus.y);
        $this$minus_u24lambda_u2d4.offset(-p.x, -p.y);
        return $this$minus_u24lambda_u2d4;
    }

    public static final PointF minus(PointF $this$minus, PointF p) {
        lu.f($this$minus, "<this>");
        lu.f(p, "p");
        PointF $this$minus_u24lambda_u2d5 = new PointF($this$minus.x, $this$minus.y);
        $this$minus_u24lambda_u2d5.offset(-p.x, -p.y);
        return $this$minus_u24lambda_u2d5;
    }

    public static final Point minus(Point $this$minus, int xy) {
        lu.f($this$minus, "<this>");
        Point $this$minus_u24lambda_u2d6 = new Point($this$minus.x, $this$minus.y);
        $this$minus_u24lambda_u2d6.offset(-xy, -xy);
        return $this$minus_u24lambda_u2d6;
    }

    public static final PointF minus(PointF $this$minus, float xy) {
        lu.f($this$minus, "<this>");
        PointF $this$minus_u24lambda_u2d7 = new PointF($this$minus.x, $this$minus.y);
        $this$minus_u24lambda_u2d7.offset(-xy, -xy);
        return $this$minus_u24lambda_u2d7;
    }

    public static final Point unaryMinus(Point $this$unaryMinus) {
        lu.f($this$unaryMinus, "<this>");
        return new Point(-$this$unaryMinus.x, -$this$unaryMinus.y);
    }

    public static final PointF unaryMinus(PointF $this$unaryMinus) {
        lu.f($this$unaryMinus, "<this>");
        return new PointF(-$this$unaryMinus.x, -$this$unaryMinus.y);
    }

    public static final PointF toPointF(Point $this$toPointF) {
        lu.f($this$toPointF, "<this>");
        return new PointF($this$toPointF);
    }

    public static final Point toPoint(PointF $this$toPoint) {
        lu.f($this$toPoint, "<this>");
        return new Point((int) $this$toPoint.x, (int) $this$toPoint.y);
    }
}
