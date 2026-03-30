package defpackage;

/* renamed from: nw  reason: default package */
public class nw extends dk {
    private float a;

    /* renamed from: a  reason: collision with other field name */
    c70 f4473a;
    private float b;
    private float c;

    public nw(c70 labColorSpace, float l, float a2, float b2) {
        super(7);
        this.a = l;
        this.b = a2;
        this.c = b2;
        w5 altRgbColor = labColorSpace.b(l, a2, b2);
        f(altRgbColor.e(), altRgbColor.c(), altRgbColor.b(), 255);
    }

    public c70 n() {
        return this.f4473a;
    }

    public float m() {
        return this.a;
    }

    public float k() {
        return this.b;
    }

    public float l() {
        return this.c;
    }
}
