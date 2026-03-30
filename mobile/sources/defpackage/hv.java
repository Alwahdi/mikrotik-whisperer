package defpackage;

/* renamed from: hv  reason: default package */
public abstract class hv extends mv implements ra {
    private final boolean a = m0();

    public hv(ev parent) {
        super(true);
        G(parent);
    }

    public boolean z() {
        return true;
    }

    public boolean y() {
        return this.a;
    }

    private final boolean m0() {
        mv parentJob;
        mv t;
        l8 B = B();
        m8 m8Var = B instanceof m8 ? (m8) B : null;
        if (m8Var == null || (parentJob = m8Var.t()) == null) {
            return false;
        }
        while (!parentJob.y()) {
            l8 B2 = parentJob.B();
            m8 m8Var2 = B2 instanceof m8 ? (m8) B2 : null;
            if (m8Var2 == null || (t = m8Var2.t()) == null) {
                return false;
            }
            parentJob = t;
        }
        return true;
    }
}
