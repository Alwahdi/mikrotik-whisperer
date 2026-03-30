package defpackage;

import java.util.Set;

/* renamed from: h21  reason: default package */
public abstract class h21<E> extends v11<E> implements Set<E> {
    private transient t11<E> a;

    h21() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return p21.b(this, obj);
    }

    public int hashCode() {
        return p21.a(this);
    }

    public t11<E> c() {
        t11<E> t11 = this.a;
        if (t11 != null) {
            return t11;
        }
        t11<E> j = j();
        this.a = j;
        return j;
    }

    /* access modifiers changed from: package-private */
    public t11<E> j() {
        return t11.o(toArray());
    }
}
