package defpackage;

import java.util.Iterator;

/* renamed from: v30  reason: default package */
public class v30<T, R> extends mz<R> {
    private final Iterator<? extends T> a;

    /* renamed from: a  reason: collision with other field name */
    private final uo<? super T, ? extends R> f5296a;

    public v30(Iterator<? extends T> iterator, uo<? super T, ? extends R> mapper) {
        this.a = iterator;
        this.f5296a = mapper;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public R a() {
        return this.f5296a.apply(this.a.next());
    }
}
