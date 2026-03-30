package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;

public final class PictureKt {
    public static final Picture record(Picture $this$record, int width, int height, vn<? super Canvas, jt0> block) {
        lu.f($this$record, "<this>");
        lu.f(block, "block");
        Canvas c = $this$record.beginRecording(width, height);
        lu.e(c, "beginRecording(width, height)");
        try {
            block.invoke(c);
            return $this$record;
        } finally {
            ps.b(1);
            $this$record.endRecording();
            ps.a(1);
        }
    }
}
