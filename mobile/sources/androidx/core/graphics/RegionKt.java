package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;

public final class RegionKt {
    public static final boolean contains(Region $this$contains, Point p) {
        lu.f($this$contains, "<this>");
        lu.f(p, "p");
        return $this$contains.contains(p.x, p.y);
    }

    public static final Region plus(Region $this$plus, Rect r) {
        lu.f($this$plus, "<this>");
        lu.f(r, "r");
        Region $this$plus_u24lambda_u2d0 = new Region($this$plus);
        $this$plus_u24lambda_u2d0.union(r);
        return $this$plus_u24lambda_u2d0;
    }

    public static final Region plus(Region $this$plus, Region r) {
        lu.f($this$plus, "<this>");
        lu.f(r, "r");
        Region $this$plus_u24lambda_u2d1 = new Region($this$plus);
        $this$plus_u24lambda_u2d1.op(r, Region.Op.UNION);
        return $this$plus_u24lambda_u2d1;
    }

    public static final Region minus(Region $this$minus, Rect r) {
        lu.f($this$minus, "<this>");
        lu.f(r, "r");
        Region $this$minus_u24lambda_u2d2 = new Region($this$minus);
        $this$minus_u24lambda_u2d2.op(r, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u2d2;
    }

    public static final Region minus(Region $this$minus, Region r) {
        lu.f($this$minus, "<this>");
        lu.f(r, "r");
        Region $this$minus_u24lambda_u2d3 = new Region($this$minus);
        $this$minus_u24lambda_u2d3.op(r, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u2d3;
    }

    public static final Region unaryMinus(Region $this$unaryMinus) {
        lu.f($this$unaryMinus, "<this>");
        Region $this$unaryMinus_u24lambda_u2d4 = new Region($this$unaryMinus.getBounds());
        $this$unaryMinus_u24lambda_u2d4.op($this$unaryMinus, Region.Op.DIFFERENCE);
        return $this$unaryMinus_u24lambda_u2d4;
    }

    public static final Region not(Region $this$not) {
        lu.f($this$not, "<this>");
        Region $this$unaryMinus$iv = $this$not;
        Region $this$unaryMinus_u24lambda_u2d4$iv = new Region($this$unaryMinus$iv.getBounds());
        $this$unaryMinus_u24lambda_u2d4$iv.op($this$unaryMinus$iv, Region.Op.DIFFERENCE);
        return $this$unaryMinus_u24lambda_u2d4$iv;
    }

    public static final Region or(Region $this$or, Rect r) {
        lu.f($this$or, "<this>");
        lu.f(r, "r");
        Region $this$plus_u24lambda_u2d0$iv = new Region($this$or);
        $this$plus_u24lambda_u2d0$iv.union(r);
        return $this$plus_u24lambda_u2d0$iv;
    }

    public static final Region or(Region $this$or, Region r) {
        lu.f($this$or, "<this>");
        lu.f(r, "r");
        Region $this$plus_u24lambda_u2d1$iv = new Region($this$or);
        $this$plus_u24lambda_u2d1$iv.op(r, Region.Op.UNION);
        return $this$plus_u24lambda_u2d1$iv;
    }

    public static final Region and(Region $this$and, Rect r) {
        lu.f($this$and, "<this>");
        lu.f(r, "r");
        Region $this$and_u24lambda_u2d5 = new Region($this$and);
        $this$and_u24lambda_u2d5.op(r, Region.Op.INTERSECT);
        return $this$and_u24lambda_u2d5;
    }

    public static final Region and(Region $this$and, Region r) {
        lu.f($this$and, "<this>");
        lu.f(r, "r");
        Region $this$and_u24lambda_u2d6 = new Region($this$and);
        $this$and_u24lambda_u2d6.op(r, Region.Op.INTERSECT);
        return $this$and_u24lambda_u2d6;
    }

    public static final Region xor(Region $this$xor, Rect r) {
        lu.f($this$xor, "<this>");
        lu.f(r, "r");
        Region $this$xor_u24lambda_u2d7 = new Region($this$xor);
        $this$xor_u24lambda_u2d7.op(r, Region.Op.XOR);
        return $this$xor_u24lambda_u2d7;
    }

    public static final Region xor(Region $this$xor, Region r) {
        lu.f($this$xor, "<this>");
        lu.f(r, "r");
        Region $this$xor_u24lambda_u2d8 = new Region($this$xor);
        $this$xor_u24lambda_u2d8.op(r, Region.Op.XOR);
        return $this$xor_u24lambda_u2d8;
    }

    public static final void forEach(Region $this$forEach, vn<? super Rect, jt0> action) {
        lu.f($this$forEach, "<this>");
        lu.f(action, "action");
        RegionIterator iterator = new RegionIterator($this$forEach);
        while (true) {
            Rect r = new Rect();
            if (iterator.next(r)) {
                action.invoke(r);
            } else {
                return;
            }
        }
    }

    public static final Iterator<Rect> iterator(Region $this$iterator) {
        lu.f($this$iterator, "<this>");
        return new RegionKt$iterator$1($this$iterator);
    }
}
