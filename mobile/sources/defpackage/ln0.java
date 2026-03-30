package defpackage;

import java.io.Closeable;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: ln0  reason: default package */
public class ln0<T> implements Closeable {
    private final Iterator<? extends T> a;

    /* renamed from: a  reason: collision with other field name */
    private final l50 f4266a;

    public static <T> ln0<T> U(Iterable<? extends T> iterable) {
        g40.c(iterable);
        return new ln0<>(iterable);
    }

    private ln0(Iterable<? extends T> iterable) {
        this((l50) null, new tw(iterable));
    }

    ln0(l50 params, Iterator<? extends T> iterator) {
        this.a = iterator;
    }

    public ln0<T> q(ha0<? super T> predicate) {
        return new ln0<>(this.f4266a, new u30(this.a, predicate));
    }

    public <R> ln0<R> K(uo<? super T, ? extends R> mapper) {
        return new ln0<>(this.f4266a, new v30(this.a, mapper));
    }

    public ln0<T> V(Comparator<? super T> comparator) {
        return new ln0<>(this.f4266a, new w30(this.a, comparator));
    }

    public void J(jc<? super T> action) {
        while (this.a.hasNext()) {
            action.accept(this.a.next());
        }
    }

    public <R, A> R f(u9<? super T, A, R> collector) {
        A container = collector.b().get();
        while (this.a.hasNext()) {
            collector.a().a(container, this.a.next());
        }
        return collector.c().apply(container);
    }

    public long o() {
        long count = 0;
        while (this.a.hasNext()) {
            this.a.next();
            count++;
        }
        return count;
    }

    public boolean c(ha0<? super T> predicate) {
        return P(predicate, 0);
    }

    public x40<T> w() {
        if (this.a.hasNext()) {
            return x40.d(this.a.next());
        }
        return x40.a();
    }

    public T C(T other) {
        if (this.a.hasNext()) {
            return this.a.next();
        }
        return other;
    }

    public void close() {
    }

    private boolean P(ha0<? super T> predicate, int matchKind) {
        boolean kindAny = matchKind == 0;
        boolean kindAll = matchKind == 1;
        while (this.a.hasNext()) {
            boolean match = predicate.test(this.a.next());
            if (match ^ kindAll) {
                if (!kindAny || !match) {
                    return false;
                }
                return true;
            }
        }
        if (!kindAny) {
            return true;
        }
        return false;
    }
}
