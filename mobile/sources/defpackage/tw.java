package defpackage;

import java.util.Iterator;

/* renamed from: tw  reason: default package */
public class tw<T> implements Iterator<T> {
    private final Iterable<? extends T> a;

    /* renamed from: a  reason: collision with other field name */
    private Iterator<? extends T> f5176a;

    public tw(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    private void a() {
        if (this.f5176a == null) {
            this.f5176a = this.a.iterator();
        }
    }

    public boolean hasNext() {
        a();
        return this.f5176a.hasNext();
    }

    public T next() {
        a();
        return this.f5176a.next();
    }

    public void remove() {
        a();
        this.f5176a.remove();
    }
}
