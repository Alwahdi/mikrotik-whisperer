package defpackage;

import java.util.Collections;
import java.util.Comparator;

/* renamed from: ma  reason: default package */
public final class ma<T> implements Comparator<T> {
    private static final ma<Comparable<Object>> a = new ma<>(new a());
    private static final ma<Comparable<Object>> b = new ma<>(Collections.reverseOrder());

    /* renamed from: a  reason: collision with other field name */
    private final Comparator<? super T> f4322a;

    /* renamed from: ma$a */
    static class a implements Comparator<Comparable<Object>> {
        a() {
        }

        /* renamed from: a */
        public int compare(Comparable<Object> o1, Comparable<Object> o2) {
            return o1.compareTo(o2);
        }
    }

    public static <T> Comparator<T> d(Comparator<? super T> c1, Comparator<? super T> c2) {
        g40.c(c1);
        g40.c(c2);
        return new b(c1, c2);
    }

    /* renamed from: ma$b */
    static class b implements Comparator<T> {
        final /* synthetic */ Comparator a;
        final /* synthetic */ Comparator b;

        b(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        public int compare(T t1, T t2) {
            int result = this.a.compare(t1, t2);
            return result != 0 ? result : this.b.compare(t1, t2);
        }
    }

    /* renamed from: ma$c */
    static class c implements Comparator<T> {
        final /* synthetic */ uo a;

        c(uo uoVar) {
            this.a = uoVar;
        }

        public int compare(T t1, T t2) {
            return ((Comparable) this.a.apply(t1)).compareTo((Comparable) this.a.apply(t2));
        }
    }

    public static <T, U extends Comparable<? super U>> ma<T> a(uo<? super T, ? extends U> keyExtractor) {
        g40.c(keyExtractor);
        return new ma<>(new c(keyExtractor));
    }

    public ma(Comparator<? super T> comparator) {
        this.f4322a = comparator;
    }

    /* renamed from: b */
    public ma<T> reversed() {
        return new ma<>(Collections.reverseOrder(this.f4322a));
    }

    /* renamed from: c */
    public ma<T> thenComparing(Comparator<? super T> other) {
        return new ma<>(d(this.f4322a, other));
    }

    public int compare(T o1, T o2) {
        return this.f4322a.compare(o1, o2);
    }
}
