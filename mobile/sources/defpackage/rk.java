package defpackage;

/* renamed from: rk  reason: default package */
public abstract class rk implements Comparable<rk> {
    public abstract int a(rk rkVar);

    public abstract int c();

    public abstract Object d();

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public String toString() {
        Object val = d();
        return val == null ? "null" : val.toString();
    }

    /* access modifiers changed from: protected */
    public int b(rk other) {
        int cmp = qu0.d(c(), other.c());
        n4.d(cmp != 0, "Default compareTo should not be used for values of same type.", new Object[0]);
        return cmp;
    }
}
