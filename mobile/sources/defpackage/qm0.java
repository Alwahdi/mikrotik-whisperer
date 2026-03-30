package defpackage;

/* renamed from: qm0  reason: default package */
public class qm0 extends dk {
    float a;

    /* renamed from: a  reason: collision with other field name */
    k80 f4849a;

    public qm0(k80 spot, float tint) {
        super(3, (((((float) spot.b().e()) / 255.0f) - 1.0f) * tint) + 1.0f, (((((float) spot.b().c()) / 255.0f) - 1.0f) * tint) + 1.0f, (((((float) spot.b().b()) / 255.0f) - 1.0f) * tint) + 1.0f);
        this.a = tint;
    }

    public k80 k() {
        return this.f4849a;
    }

    public float l() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qm0)) {
            return false;
        }
        ((qm0) obj).f4849a.equals(this.f4849a);
        throw null;
    }

    public int hashCode() {
        this.f4849a.hashCode();
        throw null;
    }
}
