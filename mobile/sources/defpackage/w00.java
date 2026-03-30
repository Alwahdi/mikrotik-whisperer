package defpackage;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: w00  reason: default package */
public abstract class w00 implements TypeEvaluator<Matrix> {
    private final Matrix a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    private final float[] f5423a = new float[9];
    private final float[] b = new float[9];

    public Matrix a(float fraction, Matrix startValue, Matrix endValue) {
        startValue.getValues(this.f5423a);
        endValue.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.b;
            float f = fArr[i];
            float[] fArr2 = this.f5423a;
            fArr[i] = fArr2[i] + (fraction * (f - fArr2[i]));
        }
        this.a.setValues(this.b);
        return this.a;
    }
}
