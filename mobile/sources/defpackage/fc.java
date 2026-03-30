package defpackage;

import io.grpc.e;
import io.grpc.p;

/* renamed from: fc  reason: default package */
public final class fc {
    private final e a;

    /* renamed from: a  reason: collision with other field name */
    private final p f2965a;

    public static fc a(e state) {
        v90.e(state != e.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new fc(state, p.f3953a);
    }

    public static fc b(p error) {
        v90.e(!error.o(), "The error status must not be OK");
        return new fc(e.TRANSIENT_FAILURE, error);
    }

    public e c() {
        return this.a;
    }

    public p d() {
        return this.f2965a;
    }

    public boolean equals(Object other) {
        if (!(other instanceof fc)) {
            return false;
        }
        fc o = (fc) other;
        if (!this.a.equals(o.a) || !this.f2965a.equals(o.f2965a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.a.hashCode() ^ this.f2965a.hashCode();
    }

    public String toString() {
        if (this.f2965a.o()) {
            return this.a.toString();
        }
        return this.a + "(" + this.f2965a + ")";
    }

    private fc(e state, p status) {
        this.a = (e) v90.o(state, "state is null");
        this.f2965a = (p) v90.o(status, "status is null");
    }
}
