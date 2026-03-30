package defpackage;

/* renamed from: u40  reason: default package */
public abstract class u40 {
    public abstract t4<?> a();

    public abstract Object c(Object obj);

    public String toString() {
        return ef.a(this) + '@' + ef.b(this);
    }

    public final boolean b(u40 that) {
        t4 thatOp;
        t4 thisOp = a();
        if (thisOp == null || (thatOp = that.a()) == null || thisOp.f() >= thatOp.f()) {
            return false;
        }
        return true;
    }
}
