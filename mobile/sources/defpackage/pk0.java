package defpackage;

/* renamed from: pk0  reason: default package */
public final class pk0 extends rk {
    private final pr0 a;

    /* renamed from: a  reason: collision with other field name */
    private final rk f4717a;

    public pk0(pr0 localWriteTime, rk previousValue) {
        this.a = localWriteTime;
        this.f4717a = previousValue;
    }

    public int c() {
        return 3;
    }

    public Object d() {
        return null;
    }

    public Object g() {
        rk rkVar = this.f4717a;
        if (rkVar instanceof pk0) {
            return ((pk0) rkVar).g();
        }
        if (rkVar != null) {
            return rkVar.d();
        }
        return null;
    }

    public pr0 e() {
        return this.a;
    }

    public String toString() {
        return "<ServerTimestamp localTime=" + this.a.toString() + ">";
    }

    public boolean equals(Object o) {
        return (o instanceof pk0) && this.a.equals(((pk0) o).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (o instanceof pk0) {
            return this.a.compareTo(((pk0) o).a);
        }
        if (o instanceof qr0) {
            return 1;
        }
        return b(o);
    }
}
