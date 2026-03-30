package defpackage;

import defpackage.aj;
import java.util.Map;

/* renamed from: a5  reason: default package */
final class a5 extends aj {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final Integer f13a;

    /* renamed from: a  reason: collision with other field name */
    private final String f14a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f15a;

    /* renamed from: a  reason: collision with other field name */
    private final pi f16a;
    private final long b;

    private a5(String transportName, Integer code, pi encodedPayload, long eventMillis, long uptimeMillis, Map<String, String> autoMetadata) {
        this.f14a = transportName;
        this.f13a = code;
        this.f16a = encodedPayload;
        this.a = eventMillis;
        this.b = uptimeMillis;
        this.f15a = autoMetadata;
    }

    public String j() {
        return this.f14a;
    }

    public Integer d() {
        return this.f13a;
    }

    public pi e() {
        return this.f16a;
    }

    public long f() {
        return this.a;
    }

    public long k() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> c() {
        return this.f15a;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f14a + ", code=" + this.f13a + ", encodedPayload=" + this.f16a + ", eventMillis=" + this.a + ", uptimeMillis=" + this.b + ", autoMetadata=" + this.f15a + "}";
    }

    public boolean equals(Object o) {
        Integer num;
        if (o == this) {
            return true;
        }
        if (!(o instanceof aj)) {
            return false;
        }
        aj that = (aj) o;
        if (!this.f14a.equals(that.j()) || ((num = this.f13a) != null ? !num.equals(that.d()) : that.d() != null) || !this.f16a.equals(that.e()) || this.a != that.f() || this.b != that.k() || !this.f15a.equals(that.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int h$ = ((1 * 1000003) ^ this.f14a.hashCode()) * 1000003;
        Integer num = this.f13a;
        int hashCode = num == null ? 0 : num.hashCode();
        long j = this.a;
        long j2 = this.b;
        return ((((((((h$ ^ hashCode) * 1000003) ^ this.f16a.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f15a.hashCode();
    }

    /* renamed from: a5$b */
    static final class b extends aj.a {
        private Integer a;

        /* renamed from: a  reason: collision with other field name */
        private Long f17a;

        /* renamed from: a  reason: collision with other field name */
        private String f18a;

        /* renamed from: a  reason: collision with other field name */
        private Map<String, String> f19a;

        /* renamed from: a  reason: collision with other field name */
        private pi f20a;
        private Long b;

        b() {
        }

        public aj.a j(String transportName) {
            if (transportName != null) {
                this.f18a = transportName;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public aj.a g(Integer code) {
            this.a = code;
            return this;
        }

        public aj.a h(pi encodedPayload) {
            if (encodedPayload != null) {
                this.f20a = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public aj.a i(long eventMillis) {
            this.f17a = Long.valueOf(eventMillis);
            return this;
        }

        public aj.a k(long uptimeMillis) {
            this.b = Long.valueOf(uptimeMillis);
            return this;
        }

        /* access modifiers changed from: protected */
        public aj.a f(Map<String, String> autoMetadata) {
            if (autoMetadata != null) {
                this.f19a = autoMetadata;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        /* access modifiers changed from: protected */
        public Map<String, String> e() {
            Map<String, String> map = this.f19a;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public aj d() {
            String missing = "";
            if (this.f18a == null) {
                missing = missing + " transportName";
            }
            if (this.f20a == null) {
                missing = missing + " encodedPayload";
            }
            if (this.f17a == null) {
                missing = missing + " eventMillis";
            }
            if (this.b == null) {
                missing = missing + " uptimeMillis";
            }
            if (this.f19a == null) {
                missing = missing + " autoMetadata";
            }
            if (missing.isEmpty()) {
                return new a5(this.f18a, this.a, this.f20a, this.f17a.longValue(), this.b.longValue(), this.f19a);
            }
            throw new IllegalStateException("Missing required properties:" + missing);
        }
    }
}
