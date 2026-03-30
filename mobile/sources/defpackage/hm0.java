package defpackage;

/* renamed from: hm0  reason: default package */
public final class hm0 implements Comparable<hm0> {
    public static final hm0 a = new hm0(new pr0(0, 0));

    /* renamed from: a  reason: collision with other field name */
    private final pr0 f3171a;

    public hm0(pr0 timestamp) {
        this.f3171a = timestamp;
    }

    public pr0 b() {
        return this.f3171a;
    }

    /* renamed from: a */
    public int compareTo(hm0 other) {
        return this.f3171a.compareTo(other.f3171a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof hm0) && compareTo((hm0) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.f3171a.p() + ", nanos=" + this.f3171a.o() + ")";
    }
}
