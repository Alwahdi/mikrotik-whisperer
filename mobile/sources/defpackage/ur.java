package defpackage;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* renamed from: ur  reason: default package */
public class ur extends Property<ImageView, Matrix> {
    private final Matrix a = new Matrix();

    public ur() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* renamed from: b */
    public void set(ImageView object, Matrix value) {
        object.setImageMatrix(value);
    }

    /* renamed from: a */
    public Matrix get(ImageView object) {
        this.a.set(object.getImageMatrix());
        return this.a;
    }
}
