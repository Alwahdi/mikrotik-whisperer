package defpackage;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* renamed from: gl0  reason: default package */
public class gl0 {
    private static final float[] a = {0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with other field name */
    private static final int[] f3105a = new int[3];
    private static final float[] b = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: b  reason: collision with other field name */
    private static final int[] f3106b = new int[4];

    /* renamed from: a  reason: collision with other field name */
    private int f3107a;

    /* renamed from: a  reason: collision with other field name */
    private final Paint f3108a;

    /* renamed from: a  reason: collision with other field name */
    private final Path f3109a;

    /* renamed from: b  reason: collision with other field name */
    private int f3110b;

    /* renamed from: b  reason: collision with other field name */
    private final Paint f3111b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private final Paint f3112c;
    private final Paint d;

    public gl0() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public gl0(int color) {
        this.f3109a = new Path();
        Paint paint = new Paint();
        this.d = paint;
        this.f3108a = new Paint();
        d(color);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f3111b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f3112c = new Paint(paint2);
    }

    public void d(int color) {
        this.f3107a = ColorUtils.setAlphaComponent(color, 68);
        this.f3110b = ColorUtils.setAlphaComponent(color, 20);
        this.c = ColorUtils.setAlphaComponent(color, 0);
        this.f3108a.setColor(this.f3107a);
    }

    public void b(Canvas canvas, Matrix transform, RectF bounds, int elevation) {
        bounds.bottom += (float) elevation;
        bounds.offset(0.0f, (float) (-elevation));
        int[] iArr = f3105a;
        iArr[0] = this.c;
        iArr[1] = this.f3110b;
        iArr[2] = this.f3107a;
        Paint paint = this.f3112c;
        float f = bounds.left;
        paint.setShader(new LinearGradient(f, bounds.top, f, bounds.bottom, iArr, a, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(transform);
        canvas.drawRect(bounds, this.f3112c);
        canvas.restore();
    }

    public void a(Canvas canvas, Matrix matrix, RectF bounds, int elevation, float startAngle, float sweepAngle) {
        Canvas canvas2 = canvas;
        RectF rectF = bounds;
        int i = elevation;
        float f = sweepAngle;
        boolean drawShadowInsideBounds = f < 0.0f;
        Path arcBounds = this.f3109a;
        if (drawShadowInsideBounds) {
            int[] iArr = f3106b;
            iArr[0] = 0;
            iArr[1] = this.c;
            iArr[2] = this.f3110b;
            iArr[3] = this.f3107a;
            float f2 = startAngle;
        } else {
            arcBounds.rewind();
            arcBounds.moveTo(bounds.centerX(), bounds.centerY());
            arcBounds.arcTo(rectF, startAngle, f);
            arcBounds.close();
            rectF.inset((float) (-i), (float) (-i));
            int[] iArr2 = f3106b;
            iArr2[0] = 0;
            iArr2[1] = this.f3107a;
            iArr2[2] = this.f3110b;
            iArr2[3] = this.c;
        }
        float radius = bounds.width() / 2.0f;
        if (radius > 0.0f) {
            float startRatio = 1.0f - (((float) i) / radius);
            float[] fArr = b;
            fArr[1] = startRatio;
            fArr[2] = startRatio + ((1.0f - startRatio) / 2.0f);
            this.f3111b.setShader(new RadialGradient(bounds.centerX(), bounds.centerY(), radius, f3106b, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            canvas2.scale(1.0f, bounds.height() / bounds.width());
            if (!drawShadowInsideBounds) {
                canvas2.clipPath(arcBounds, Region.Op.DIFFERENCE);
                canvas2.drawPath(arcBounds, this.d);
            }
            canvas.drawArc(bounds, startAngle, sweepAngle, true, this.f3111b);
            canvas.restore();
        }
    }

    public Paint c() {
        return this.f3108a;
    }
}
