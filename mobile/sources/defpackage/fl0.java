package defpackage;

/* renamed from: fl0  reason: default package */
public class fl0 extends dk {
    j80 a;

    public fl0(j80 shadingPattern) {
        super(5, 0.5f, 0.5f, 0.5f);
    }

    public j80 k() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fl0)) {
            return false;
        }
        ((fl0) obj).a.equals(this.a);
        throw null;
    }

    public int hashCode() {
        this.a.hashCode();
        throw null;
    }
}
