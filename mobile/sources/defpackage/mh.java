package defpackage;

import com.google.firebase.database.collection.e;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: mh  reason: default package */
public final class mh implements Comparable<mh> {
    private static final e<mh> a;

    /* renamed from: a  reason: collision with other field name */
    private static final Comparator<mh> f4359a;

    /* renamed from: a  reason: collision with other field name */
    private final me0 f4360a;

    static {
        Comparator<mh> a2 = lh.a();
        f4359a = a2;
        a = new e<>(Collections.emptyList(), a2);
    }

    public static Comparator<mh> a() {
        return f4359a;
    }

    public static e<mh> d() {
        return a;
    }

    public static mh c() {
        return g(Collections.emptyList());
    }

    public static mh e(me0 path) {
        return new mh(path);
    }

    public static mh g(List<String> segments) {
        return new mh(me0.s(segments));
    }

    public static boolean j(me0 path) {
        return path.n() % 2 == 0;
    }

    private mh(me0 path) {
        n4.d(j(path), "Not a document key path: %s", path);
        this.f4360a = path;
    }

    public me0 h() {
        return this.f4360a;
    }

    public boolean i(String collectionId) {
        if (this.f4360a.n() >= 2) {
            me0 me0 = this.f4360a;
            if (me0.a.get(me0.n() - 2).equals(collectionId)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public int compareTo(mh another) {
        return this.f4360a.compareTo(another.f4360a);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.f4360a.equals(((mh) o).f4360a);
    }

    public int hashCode() {
        return this.f4360a.hashCode();
    }

    public String toString() {
        return this.f4360a.toString();
    }
}
