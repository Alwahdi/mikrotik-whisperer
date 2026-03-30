package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;

public final class PathKt {
    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path $this$flatten, float error) {
        lu.f($this$flatten, "<this>");
        Collection<PathSegment> flatten = PathUtils.flatten($this$flatten, error);
        lu.e(flatten, "flatten(this, error)");
        return flatten;
    }

    @RequiresApi(19)
    public static final Path plus(Path $this$plus, Path p) {
        lu.f($this$plus, "<this>");
        lu.f(p, "p");
        Path $this$plus_u24lambda_u2d0 = new Path($this$plus);
        $this$plus_u24lambda_u2d0.op(p, Path.Op.UNION);
        return $this$plus_u24lambda_u2d0;
    }

    @RequiresApi(19)
    public static final Path minus(Path $this$minus, Path p) {
        lu.f($this$minus, "<this>");
        lu.f(p, "p");
        Path $this$minus_u24lambda_u2d1 = new Path($this$minus);
        $this$minus_u24lambda_u2d1.op(p, Path.Op.DIFFERENCE);
        return $this$minus_u24lambda_u2d1;
    }

    @RequiresApi(19)
    public static final Path or(Path $this$or, Path p) {
        lu.f($this$or, "<this>");
        lu.f(p, "p");
        Path $this$plus_u24lambda_u2d0$iv = new Path($this$or);
        $this$plus_u24lambda_u2d0$iv.op(p, Path.Op.UNION);
        return $this$plus_u24lambda_u2d0$iv;
    }

    @RequiresApi(19)
    public static final Path and(Path $this$and, Path p) {
        lu.f($this$and, "<this>");
        lu.f(p, "p");
        Path $this$and_u24lambda_u2d2 = new Path();
        $this$and_u24lambda_u2d2.op($this$and, p, Path.Op.INTERSECT);
        return $this$and_u24lambda_u2d2;
    }

    @RequiresApi(19)
    public static final Path xor(Path $this$xor, Path p) {
        lu.f($this$xor, "<this>");
        lu.f(p, "p");
        Path $this$xor_u24lambda_u2d3 = new Path($this$xor);
        $this$xor_u24lambda_u2d3.op(p, Path.Op.XOR);
        return $this$xor_u24lambda_u2d3;
    }
}
