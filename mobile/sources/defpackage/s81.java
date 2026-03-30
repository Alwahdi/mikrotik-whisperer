package defpackage;

/* renamed from: s81  reason: default package */
final class s81 extends da1 {
    private final long a;

    s81(long j) {
        this.a = j;
    }

    public long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof da1) || this.a != ((da1) obj).a()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.a + "}";
    }
}
