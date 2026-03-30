package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;

public final class ShaderKt {
    public static final void transform(Shader $this$transform, vn<? super Matrix, jt0> block) {
        lu.f($this$transform, "<this>");
        lu.f(block, "block");
        Matrix matrix = new Matrix();
        $this$transform.getLocalMatrix(matrix);
        block.invoke(matrix);
        $this$transform.setLocalMatrix(matrix);
    }
}
