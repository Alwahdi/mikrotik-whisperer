package defpackage;

/* renamed from: wd0  reason: default package */
public class wd0 extends rk {
    private final mh a;

    /* renamed from: a  reason: collision with other field name */
    private final ve f5481a;

    private wd0(ve databaseId, mh documentKey) {
        this.f5481a = databaseId;
        this.a = documentKey;
    }

    public int c() {
        return 6;
    }

    /* renamed from: g */
    public mh d() {
        return this.a;
    }

    public ve e() {
        return this.f5481a;
    }

    public boolean equals(Object o) {
        if (!(o instanceof wd0)) {
            return false;
        }
        wd0 ref = (wd0) o;
        if (!this.a.equals(ref.a) || !this.f5481a.equals(ref.f5481a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((31 * 31) + this.f5481a.hashCode()) * 31) + this.a.hashCode();
    }

    /* renamed from: a */
    public int compareTo(rk o) {
        if (!(o instanceof wd0)) {
            return b(o);
        }
        wd0 ref = (wd0) o;
        int cmp = this.f5481a.compareTo(ref.f5481a);
        return cmp != 0 ? cmp : this.a.compareTo(ref.a);
    }

    public static wd0 h(ve databaseId, mh documentKey) {
        return new wd0(databaseId, documentKey);
    }
}
