package defpackage;

import io.grpc.l;

/* renamed from: a9  reason: default package */
public abstract class a9 extends mn0 {

    /* renamed from: a9$a */
    public static abstract class a {
        public abstract a9 a(b bVar, l lVar);
    }

    public void l() {
    }

    public void j() {
    }

    public void k(l trailers) {
    }

    /* renamed from: a9$b */
    public static final class b {
        private final n7 a;

        /* renamed from: a  reason: collision with other field name */
        private final v4 f35a;

        b(v4 transportAttrs, n7 callOptions) {
            this.f35a = (v4) v90.o(transportAttrs, "transportAttrs");
            this.a = (n7) v90.o(callOptions, "callOptions");
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return f20.c(this).d("transportAttrs", this.f35a).d("callOptions", this.a).toString();
        }

        /* renamed from: a9$b$a */
        public static final class a {
            private n7 a = n7.a;

            /* renamed from: a  reason: collision with other field name */
            private v4 f36a = v4.a;

            a() {
            }

            public a c(v4 transportAttrs) {
                this.f36a = (v4) v90.o(transportAttrs, "transportAttrs cannot be null");
                return this;
            }

            public a b(n7 callOptions) {
                this.a = (n7) v90.o(callOptions, "callOptions cannot be null");
                return this;
            }

            public b a() {
                return new b(this.f36a, this.a);
            }
        }
    }
}
