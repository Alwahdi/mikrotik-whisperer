package defpackage;

/* renamed from: f80  reason: default package */
public class f80 extends q30 {
    private float a;
    private float b;
    private float c;
    private float d;

    public f80(float llx, float lly, float urx, float ury, int rotation) {
        super(new float[0]);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        if (rotation == 90 || rotation == 270) {
            this.a = lly;
            this.b = llx;
            this.c = ury;
            this.d = urx;
        } else {
            this.a = llx;
            this.b = lly;
            this.c = urx;
            this.d = ury;
        }
        super.I(new k70(this.a));
        super.I(new k70(this.b));
        super.I(new k70(this.c));
        super.I(new k70(this.d));
    }

    public f80(float llx, float lly, float urx, float ury) {
        this(llx, lly, urx, ury, 0);
    }

    public f80(float urx, float ury) {
        this(0.0f, 0.0f, urx, ury, 0);
    }

    public f80(pd0 rectangle, int rotation) {
        this(rectangle.E(), rectangle.B(), rectangle.G(), rectangle.J(), rotation);
    }

    public f80(pd0 rectangle) {
        this(rectangle.E(), rectangle.B(), rectangle.G(), rectangle.J(), 0);
    }

    public boolean I(o70 object) {
        return false;
    }

    public boolean J(float[] values) {
        return false;
    }

    public boolean K(int[] values) {
        return false;
    }

    public float X() {
        return this.a;
    }

    public float Y() {
        return this.c;
    }

    public float Z() {
        return this.d;
    }

    public float V() {
        return this.b;
    }

    public float b0() {
        return this.c - this.a;
    }

    public float W() {
        return this.d - this.b;
    }

    public f80 a0(f2 transform) {
        float[] pts = {this.a, this.b, this.c, this.d};
        transform.i(pts, 0, pts, 0, 2);
        float[] dstPts = {pts[0], pts[1], pts[2], pts[3]};
        if (pts[0] > pts[2]) {
            dstPts[0] = pts[2];
            dstPts[2] = pts[0];
        }
        if (pts[1] > pts[3]) {
            dstPts[1] = pts[3];
            dstPts[3] = pts[1];
        }
        return new f80(dstPts[0], dstPts[1], dstPts[2], dstPts[3]);
    }
}
