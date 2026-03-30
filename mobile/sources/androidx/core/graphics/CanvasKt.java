package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

public final class CanvasKt {
    public static final void withSave(Canvas $this$withSave, vn<? super Canvas, jt0> block) {
        lu.f($this$withSave, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withSave.save();
        try {
            block.invoke($this$withSave);
        } finally {
            ps.b(1);
            $this$withSave.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas $this$withTranslation_u24default, float x, float y, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            x = 0.0f;
        }
        if ((i & 2) != 0) {
            y = 0.0f;
        }
        lu.f($this$withTranslation_u24default, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withTranslation_u24default.save();
        $this$withTranslation_u24default.translate(x, y);
        try {
            block.invoke($this$withTranslation_u24default);
        } finally {
            ps.b(1);
            $this$withTranslation_u24default.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withTranslation(Canvas $this$withTranslation, float x, float y, vn<? super Canvas, jt0> block) {
        lu.f($this$withTranslation, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withTranslation.save();
        $this$withTranslation.translate(x, y);
        try {
            block.invoke($this$withTranslation);
        } finally {
            ps.b(1);
            $this$withTranslation.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas $this$withRotation_u24default, float degrees, float pivotX, float pivotY, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            degrees = 0.0f;
        }
        if ((i & 2) != 0) {
            pivotX = 0.0f;
        }
        if ((i & 4) != 0) {
            pivotY = 0.0f;
        }
        lu.f($this$withRotation_u24default, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withRotation_u24default.save();
        $this$withRotation_u24default.rotate(degrees, pivotX, pivotY);
        try {
            block.invoke($this$withRotation_u24default);
        } finally {
            ps.b(1);
            $this$withRotation_u24default.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withRotation(Canvas $this$withRotation, float degrees, float pivotX, float pivotY, vn<? super Canvas, jt0> block) {
        lu.f($this$withRotation, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withRotation.save();
        $this$withRotation.rotate(degrees, pivotX, pivotY);
        try {
            block.invoke($this$withRotation);
        } finally {
            ps.b(1);
            $this$withRotation.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas $this$withScale_u24default, float x, float y, float pivotX, float pivotY, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            x = 1.0f;
        }
        if ((i & 2) != 0) {
            y = 1.0f;
        }
        if ((i & 4) != 0) {
            pivotX = 0.0f;
        }
        if ((i & 8) != 0) {
            pivotY = 0.0f;
        }
        lu.f($this$withScale_u24default, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withScale_u24default.save();
        $this$withScale_u24default.scale(x, y, pivotX, pivotY);
        try {
            block.invoke($this$withScale_u24default);
        } finally {
            ps.b(1);
            $this$withScale_u24default.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withScale(Canvas $this$withScale, float x, float y, float pivotX, float pivotY, vn<? super Canvas, jt0> block) {
        lu.f($this$withScale, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withScale.save();
        $this$withScale.scale(x, y, pivotX, pivotY);
        try {
            block.invoke($this$withScale);
        } finally {
            ps.b(1);
            $this$withScale.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas $this$withSkew_u24default, float x, float y, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            x = 0.0f;
        }
        if ((i & 2) != 0) {
            y = 0.0f;
        }
        lu.f($this$withSkew_u24default, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withSkew_u24default.save();
        $this$withSkew_u24default.skew(x, y);
        try {
            block.invoke($this$withSkew_u24default);
        } finally {
            ps.b(1);
            $this$withSkew_u24default.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withSkew(Canvas $this$withSkew, float x, float y, vn<? super Canvas, jt0> block) {
        lu.f($this$withSkew, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withSkew.save();
        $this$withSkew.skew(x, y);
        try {
            block.invoke($this$withSkew);
        } finally {
            ps.b(1);
            $this$withSkew.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas $this$withMatrix_u24default, Matrix matrix, vn block, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        lu.f($this$withMatrix_u24default, "<this>");
        lu.f(matrix, "matrix");
        lu.f(block, "block");
        int checkpoint = $this$withMatrix_u24default.save();
        $this$withMatrix_u24default.concat(matrix);
        try {
            block.invoke($this$withMatrix_u24default);
        } finally {
            ps.b(1);
            $this$withMatrix_u24default.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withMatrix(Canvas $this$withMatrix, Matrix matrix, vn<? super Canvas, jt0> block) {
        lu.f($this$withMatrix, "<this>");
        lu.f(matrix, "matrix");
        lu.f(block, "block");
        int checkpoint = $this$withMatrix.save();
        $this$withMatrix.concat(matrix);
        try {
            block.invoke($this$withMatrix);
        } finally {
            ps.b(1);
            $this$withMatrix.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withClip(Canvas $this$withClip, Rect clipRect, vn<? super Canvas, jt0> block) {
        lu.f($this$withClip, "<this>");
        lu.f(clipRect, "clipRect");
        lu.f(block, "block");
        int checkpoint = $this$withClip.save();
        $this$withClip.clipRect(clipRect);
        try {
            block.invoke($this$withClip);
        } finally {
            ps.b(1);
            $this$withClip.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withClip(Canvas $this$withClip, RectF clipRect, vn<? super Canvas, jt0> block) {
        lu.f($this$withClip, "<this>");
        lu.f(clipRect, "clipRect");
        lu.f(block, "block");
        int checkpoint = $this$withClip.save();
        $this$withClip.clipRect(clipRect);
        try {
            block.invoke($this$withClip);
        } finally {
            ps.b(1);
            $this$withClip.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withClip(Canvas $this$withClip, int left, int top, int right, int bottom, vn<? super Canvas, jt0> block) {
        lu.f($this$withClip, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withClip.save();
        $this$withClip.clipRect(left, top, right, bottom);
        try {
            block.invoke($this$withClip);
        } finally {
            ps.b(1);
            $this$withClip.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withClip(Canvas $this$withClip, float left, float top, float right, float bottom, vn<? super Canvas, jt0> block) {
        lu.f($this$withClip, "<this>");
        lu.f(block, "block");
        int checkpoint = $this$withClip.save();
        $this$withClip.clipRect(left, top, right, bottom);
        try {
            block.invoke($this$withClip);
        } finally {
            ps.b(1);
            $this$withClip.restoreToCount(checkpoint);
            ps.a(1);
        }
    }

    public static final void withClip(Canvas $this$withClip, Path clipPath, vn<? super Canvas, jt0> block) {
        lu.f($this$withClip, "<this>");
        lu.f(clipPath, "clipPath");
        lu.f(block, "block");
        int checkpoint = $this$withClip.save();
        $this$withClip.clipPath(clipPath);
        try {
            block.invoke($this$withClip);
        } finally {
            ps.b(1);
            $this$withClip.restoreToCount(checkpoint);
            ps.a(1);
        }
    }
}
