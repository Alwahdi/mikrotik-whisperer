package defpackage;

import java.util.AbstractList;

/* renamed from: s  reason: default package */
public abstract class s<E> extends AbstractList<E> {
    public abstract int a();

    public abstract E b(int i);

    public final /* bridge */ E remove(int index) {
        return b(index);
    }

    public final /* bridge */ int size() {
        return a();
    }

    protected s() {
    }
}
