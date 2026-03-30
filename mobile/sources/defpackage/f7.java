package defpackage;

/* renamed from: f7  reason: default package */
public class f7 extends dk {
    float a;
    float b;
    float c;
    float d;

    public f7(float floatCyan, float floatMagenta, float floatYellow, float floatBlack) {
        super(2, (1.0f - floatCyan) - floatBlack, (1.0f - floatMagenta) - floatBlack, (1.0f - floatYellow) - floatBlack);
        this.a = dk.j(floatCyan);
        this.b = dk.j(floatMagenta);
        this.c = dk.j(floatYellow);
        this.d = dk.j(floatBlack);
    }

    public float l() {
        return this.a;
    }

    public float m() {
        return this.b;
    }

    public float n() {
        return this.c;
    }

    public float k() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f7)) {
            return false;
        }
        f7 c2 = (f7) obj;
        if (this.a == c2.a && this.b == c2.b && this.c == c2.c && this.d == c2.d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToIntBits(this.a) ^ Float.floatToIntBits(this.b)) ^ Float.floatToIntBits(this.c)) ^ Float.floatToIntBits(this.d);
    }
}
