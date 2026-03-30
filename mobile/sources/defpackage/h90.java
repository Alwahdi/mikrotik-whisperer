package defpackage;

import defpackage.ux;
import io.grpc.l;
import io.grpc.m;

/* renamed from: h90  reason: default package */
public final class h90 extends ux.f {
    private final l a;

    /* renamed from: a  reason: collision with other field name */
    private final m<?, ?> f3153a;

    /* renamed from: a  reason: collision with other field name */
    private final n7 f3154a;

    public h90(m<?, ?> method, l headers, n7 callOptions) {
        this.f3153a = (m) v90.o(method, "method");
        this.a = (l) v90.o(headers, "headers");
        this.f3154a = (n7) v90.o(callOptions, "callOptions");
    }

    public l b() {
        return this.a;
    }

    public n7 a() {
        return this.f3154a;
    }

    public m<?, ?> c() {
        return this.f3153a;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        h90 that = (h90) o;
        if (!f40.a(this.f3154a, that.f3154a) || !f40.a(this.a, that.a) || !f40.a(this.f3153a, that.f3153a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return f40.b(this.f3154a, this.a, this.f3153a);
    }

    public final String toString() {
        return "[method=" + this.f3153a + " headers=" + this.a + " callOptions=" + this.f3154a + "]";
    }
}
