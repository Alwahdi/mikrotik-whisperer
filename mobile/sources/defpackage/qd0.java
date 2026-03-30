package defpackage;

/* renamed from: qd0  reason: default package */
public class qd0 extends pd0 {
    public qd0(float urx, float ury) {
        super(0.0f, 0.0f, urx, ury);
    }

    public qd0(float urx, float ury, int rotation) {
        super(0.0f, 0.0f, urx, ury);
        super.X(rotation);
    }

    private void Z() {
        throw new UnsupportedOperationException(i10.b("rectanglereadonly.this.rectangle.is.read.only", new Object[0]));
    }

    public void V(float llx) {
        Z();
    }

    public void W(float urx) {
        Z();
    }

    public void Y(float ury) {
        Z();
    }

    public void U(float lly) {
        Z();
    }

    public void Q(w5 value) {
        Z();
    }

    public void e(pd0 rect) {
        Z();
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("RectangleReadOnly: ");
        buf.append(M());
        buf.append('x');
        buf.append(D());
        buf.append(" (rot: ");
        buf.append(this.f4698a);
        buf.append(" degrees)");
        return buf.toString();
    }
}
