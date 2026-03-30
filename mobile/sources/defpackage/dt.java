package defpackage;

/* renamed from: dt  reason: default package */
public final class dt extends bt implements e9<Integer> {
    public static final a a = new a((Cif) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public static final dt f2821a = new dt(1, 0);

    public dt(int start, int endInclusive) {
        super(start, endInclusive, 1);
    }

    /* renamed from: j */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    /* renamed from: h */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    public boolean g(int value) {
        return a() <= value && value <= b();
    }

    public boolean isEmpty() {
        return a() > b();
    }

    public boolean equals(Object other) {
        return (other instanceof dt) && ((isEmpty() && ((dt) other).isEmpty()) || (a() == ((dt) other).a() && b() == ((dt) other).b()));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public String toString() {
        return a() + ".." + b();
    }

    /* renamed from: dt$a */
    public static final class a {
        public /* synthetic */ a(Cif ifVar) {
            this();
        }

        private a() {
        }

        public final dt a() {
            return dt.f2821a;
        }
    }
}
