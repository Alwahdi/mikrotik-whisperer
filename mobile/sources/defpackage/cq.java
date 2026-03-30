package defpackage;

/* renamed from: cq  reason: default package */
public class cq extends dk {
    public static final cq a = new cq(0.0f);
    public static final cq b = new cq(1.0f);

    /* renamed from: a  reason: collision with other field name */
    private float f2672a;

    public cq(int intGray) {
        this(((float) intGray) / 255.0f);
    }

    public cq(float floatGray) {
        super(1, floatGray, floatGray, floatGray);
        this.f2672a = dk.j(floatGray);
    }

    public float k() {
        return this.f2672a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof cq) && ((cq) obj).f2672a == this.f2672a;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f2672a);
    }
}
