package defpackage;

import defpackage.zj0;

/* renamed from: e5  reason: default package */
final class e5 extends zj0 {
    private final as0<?, byte[]> a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f2844a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2845a;

    /* renamed from: a  reason: collision with other field name */
    private final qi f2846a;

    /* renamed from: a  reason: collision with other field name */
    private final wi<?> f2847a;

    private e5(es0 transportContext, String transportName, wi<?> event, as0<?, byte[]> transformer, qi encoding) {
        this.f2844a = transportContext;
        this.f2845a = transportName;
        this.f2847a = event;
        this.a = transformer;
        this.f2846a = encoding;
    }

    public es0 f() {
        return this.f2844a;
    }

    public String g() {
        return this.f2845a;
    }

    /* access modifiers changed from: package-private */
    public wi<?> c() {
        return this.f2847a;
    }

    /* access modifiers changed from: package-private */
    public as0<?, byte[]> e() {
        return this.a;
    }

    public qi b() {
        return this.f2846a;
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f2844a + ", transportName=" + this.f2845a + ", event=" + this.f2847a + ", transformer=" + this.a + ", encoding=" + this.f2846a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zj0)) {
            return false;
        }
        zj0 that = (zj0) o;
        if (!this.f2844a.equals(that.f()) || !this.f2845a.equals(that.g()) || !this.f2847a.equals(that.c()) || !this.a.equals(that.e()) || !this.f2846a.equals(that.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((1 * 1000003) ^ this.f2844a.hashCode()) * 1000003) ^ this.f2845a.hashCode()) * 1000003) ^ this.f2847a.hashCode()) * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.f2846a.hashCode();
    }

    /* renamed from: e5$b */
    static final class b extends zj0.a {
        private as0<?, byte[]> a;

        /* renamed from: a  reason: collision with other field name */
        private es0 f2848a;

        /* renamed from: a  reason: collision with other field name */
        private String f2849a;

        /* renamed from: a  reason: collision with other field name */
        private qi f2850a;

        /* renamed from: a  reason: collision with other field name */
        private wi<?> f2851a;

        b() {
        }

        public zj0.a e(es0 transportContext) {
            if (transportContext != null) {
                this.f2848a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public zj0.a f(String transportName) {
            if (transportName != null) {
                this.f2849a = transportName;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        /* access modifiers changed from: package-private */
        public zj0.a c(wi<?> event) {
            if (event != null) {
                this.f2851a = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public zj0.a d(as0<?, byte[]> transformer) {
            if (transformer != null) {
                this.a = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        /* access modifiers changed from: package-private */
        public zj0.a b(qi encoding) {
            if (encoding != null) {
                this.f2850a = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        public zj0 a() {
            String missing = "";
            if (this.f2848a == null) {
                missing = missing + " transportContext";
            }
            if (this.f2849a == null) {
                missing = missing + " transportName";
            }
            if (this.f2851a == null) {
                missing = missing + " event";
            }
            if (this.a == null) {
                missing = missing + " transformer";
            }
            if (this.f2850a == null) {
                missing = missing + " encoding";
            }
            if (missing.isEmpty()) {
                return new e5(this.f2848a, this.f2849a, this.f2851a, this.a, this.f2850a);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
