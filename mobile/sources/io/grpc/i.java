package io.grpc;

public final class i {
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3272a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3273a;

    /* renamed from: a  reason: collision with other field name */
    public final ku f3274a;
    public final ku b;

    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    private i(String description, b severity, long timestampNanos, ku channelRef, ku subchannelRef) {
        this.f3273a = description;
        this.f3272a = (b) v90.o(severity, "severity");
        this.a = timestampNanos;
        this.f3274a = channelRef;
        this.b = subchannelRef;
    }

    public int hashCode() {
        return f40.b(this.f3273a, this.f3272a, Long.valueOf(this.a), this.f3274a, this.b);
    }

    public boolean equals(Object o) {
        if (!(o instanceof i)) {
            return false;
        }
        i that = (i) o;
        if (!f40.a(this.f3273a, that.f3273a) || !f40.a(this.f3272a, that.f3272a) || this.a != that.a || !f40.a(this.f3274a, that.f3274a) || !f40.a(this.b, that.b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return f20.c(this).d("description", this.f3273a).d("severity", this.f3272a).c("timestampNanos", this.a).d("channelRef", this.f3274a).d("subchannelRef", this.b).toString();
    }

    public static final class a {
        private b a;

        /* renamed from: a  reason: collision with other field name */
        private Long f3275a;

        /* renamed from: a  reason: collision with other field name */
        private String f3276a;

        /* renamed from: a  reason: collision with other field name */
        private ku f3277a;
        private ku b;

        public a b(String description) {
            this.f3276a = description;
            return this;
        }

        public a e(long timestampNanos) {
            this.f3275a = Long.valueOf(timestampNanos);
            return this;
        }

        public a c(b severity) {
            this.a = severity;
            return this;
        }

        public a d(ku subchannelRef) {
            this.b = subchannelRef;
            return this;
        }

        public i a() {
            v90.o(this.f3276a, "description");
            v90.o(this.a, "severity");
            v90.o(this.f3275a, "timestampNanos");
            v90.u(this.f3277a == null || this.b == null, "at least one of channelRef and subchannelRef must be null");
            return new i(this.f3276a, this.a, this.f3275a.longValue(), this.f3277a, this.b);
        }
    }
}
