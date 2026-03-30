package defpackage;

/* renamed from: et  reason: default package */
public final class et extends s30 {
    private final long a;

    private et(Long val) {
        this.a = val.longValue();
    }

    public static et h(Long val) {
        return new et(val);
    }

    /* renamed from: g */
    public Long d() {
        return Long.valueOf(this.a);
    }

    public boolean equals(Object o) {
        return (o instanceof et) && this.a == ((et) o).a;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public long e() {
        return this.a;
    }
}
