package defpackage;

import com.google.firebase.database.collection.c;
import com.google.firebase.database.collection.e;
import com.google.firebase.firestore.model.b;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: rh  reason: default package */
public final class rh implements Iterable<b> {
    private final c<mh, b> a;

    /* renamed from: a  reason: collision with other field name */
    private final e<b> f4897a;

    public static rh b(Comparator<b> comparator) {
        return new rh(hh.a(), new e(Collections.emptyList(), qh.a(comparator)));
    }

    static /* synthetic */ int g(Comparator comparator, b left, b right) {
        int comparison = comparator.compare(left, right);
        if (comparison == 0) {
            return b.i().compare(left, right);
        }
        return comparison;
    }

    private rh(c<mh, b> keyIndex, e<b> sortedSet) {
        this.a = keyIndex;
        this.f4897a = sortedSet;
    }

    public int size() {
        return this.a.size();
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public b c(mh key) {
        return this.a.b(key);
    }

    public b d() {
        return this.f4897a.b();
    }

    public b f() {
        return this.f4897a.a();
    }

    public rh a(b document) {
        rh removed = h(document.a());
        return new rh(removed.a.g(document.a(), document), removed.f4897a.c(document));
    }

    public rh h(mh key) {
        b document = this.a.b(key);
        if (document == null) {
            return this;
        }
        return new rh(this.a.j(key), this.f4897a.f(document));
    }

    public Iterator<b> iterator() {
        return this.f4897a.iterator();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        rh documentSet = (rh) other;
        if (size() != documentSet.size()) {
            return false;
        }
        Iterator<b> it = iterator();
        Iterator<b> it2 = documentSet.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int result = 0;
        Iterator<b> it = iterator();
        while (it.hasNext()) {
            result = (result * 31) + it.next().hashCode();
        }
        return result;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        boolean first = true;
        Iterator<b> it = iterator();
        while (it.hasNext()) {
            b doc = it.next();
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append(doc);
        }
        builder.append("]");
        return builder.toString();
    }
}
