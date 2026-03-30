package defpackage;

/* renamed from: d5  reason: default package */
final class d5 extends b90 {
    private final long a;

    /* renamed from: a  reason: collision with other field name */
    private final aj f2706a;

    /* renamed from: a  reason: collision with other field name */
    private final es0 f2707a;

    d5(long id, es0 transportContext, aj event) {
        this.a = id;
        if (transportContext != null) {
            this.f2707a = transportContext;
            if (event != null) {
                this.f2706a = event;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public long c() {
        return this.a;
    }

    public es0 d() {
        return this.f2707a;
    }

    public aj b() {
        return this.f2706a;
    }

    public String toString() {
        return "PersistedEvent{id=" + this.a + ", transportContext=" + this.f2707a + ", event=" + this.f2706a + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof b90)) {
            return false;
        }
        b90 that = (b90) o;
        if (this.a != that.c() || !this.f2707a.equals(that.d()) || !this.f2706a.equals(that.b())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return (((((1 * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f2707a.hashCode()) * 1000003) ^ this.f2706a.hashCode();
    }
}
