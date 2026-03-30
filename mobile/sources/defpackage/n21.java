package defpackage;

import java.util.Iterator;

/* renamed from: n21  reason: default package */
final class n21<K> extends h21<K> {
    private final transient d21<K, ?> a;
    private final transient t11<K> b;

    n21(d21<K, ?> d21, t11<K> t11) {
        this.a = d21;
        this.b = t11;
    }

    public final u21<K> b() {
        return (u21) c().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int a(Object[] objArr, int i) {
        return c().a(objArr, i);
    }

    public final t11<K> c() {
        return this.b;
    }

    public final boolean contains(Object obj) {
        return this.a.get(obj) != null;
    }

    public final int size() {
        return this.a.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return b();
    }
}
