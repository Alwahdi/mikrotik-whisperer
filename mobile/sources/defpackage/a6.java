package defpackage;

import defpackage.a6;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a6  reason: default package */
public abstract class a6<B extends a6<B>> implements Comparable<B> {
    final List<String> a;

    public abstract String c();

    /* access modifiers changed from: package-private */
    public abstract B e(List<String> list);

    a6(List<String> segments) {
        this.a = segments;
    }

    public String i(int index) {
        return this.a.get(index);
    }

    public B b(String segment) {
        List<String> newPath = new ArrayList<>(this.a);
        newPath.add(segment);
        return e(newPath);
    }

    public B a(B path) {
        List<String> newPath = new ArrayList<>(this.a);
        newPath.addAll(path.a);
        return e(newPath);
    }

    public B o() {
        return p(1);
    }

    public B p(int count) {
        int length = n();
        n4.d(length >= count, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(count), Integer.valueOf(length));
        return e(this.a.subList(count, length));
    }

    public B q() {
        return e(this.a.subList(0, n() - 1));
    }

    /* renamed from: d */
    public int compareTo(B o) {
        int i = 0;
        int myLength = n();
        int theirLength = o.n();
        while (i < myLength && i < theirLength) {
            int localCompare = i(i).compareTo(o.i(i));
            if (localCompare != 0) {
                return localCompare;
            }
            i++;
        }
        return qu0.d(myLength, theirLength);
    }

    public String h() {
        return this.a.get(n() - 1);
    }

    public String g() {
        return this.a.get(0);
    }

    public boolean j() {
        return n() == 0;
    }

    public boolean l(B path) {
        if (n() > path.n()) {
            return false;
        }
        for (int i = 0; i < n(); i++) {
            if (!i(i).equals(path.i(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean k(B potentialChild) {
        if (n() + 1 != potentialChild.n()) {
            return false;
        }
        for (int i = 0; i < n(); i++) {
            if (!i(i).equals(potentialChild.i(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return c();
    }

    public int n() {
        return this.a.size();
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof a6) || compareTo((a6) o) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (37 * ((37 * 1) + getClass().hashCode())) + this.a.hashCode();
    }
}
