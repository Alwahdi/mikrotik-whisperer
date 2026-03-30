package defpackage;

/* renamed from: s30  reason: default package */
public abstract class s30 extends rk {
    public int c() {
        return 2;
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (!(o instanceof s30)) {
            return b(o);
        }
        if (this instanceof th) {
            double thisDouble = ((th) this).e();
            if (o instanceof th) {
                return qu0.c(thisDouble, ((th) o).e());
            }
            n4.d(o instanceof et, "Unknown NumberValue: %s", o);
            return qu0.g(thisDouble, ((et) o).e());
        }
        n4.d(this instanceof et, "Unknown NumberValue: %s", this);
        long thisLong = ((et) this).e();
        if (o instanceof et) {
            return qu0.f(thisLong, ((et) o).e());
        }
        n4.d(o instanceof th, "Unknown NumberValue: %s", o);
        return qu0.g(((th) o).e(), thisLong) * -1;
    }
}
