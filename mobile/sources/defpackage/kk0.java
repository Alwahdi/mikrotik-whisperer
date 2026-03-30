package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: kk0  reason: default package */
abstract class kk0 extends jk0 {
    public static <T> T h(ck0<? extends T> $this$firstOrNull) {
        lu.f($this$firstOrNull, "<this>");
        Iterator iterator = $this$firstOrNull.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        return iterator.next();
    }

    public static final <T> ck0<T> f(ck0<? extends T> $this$filterNot, vn<? super T, Boolean> predicate) {
        lu.f($this$filterNot, "<this>");
        lu.f(predicate, "predicate");
        return new dl($this$filterNot, false, predicate);
    }

    /* renamed from: kk0$a */
    static final class a extends ow implements vn<T, Boolean> {
        public static final a a = new a();

        a() {
            super(1);
        }

        /* renamed from: b */
        public final Boolean invoke(T it) {
            return Boolean.valueOf(it == null);
        }
    }

    public static final <T> ck0<T> g(ck0<? extends T> $this$filterNotNull) {
        lu.f($this$filterNotNull, "<this>");
        ck0<T> f = f($this$filterNotNull, a.a);
        lu.d(f, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return f;
    }

    public static final <T, C extends Collection<? super T>> C j(ck0<? extends T> $this$toCollection, C destination) {
        lu.f($this$toCollection, "<this>");
        lu.f(destination, "destination");
        for (Object item : $this$toCollection) {
            destination.add(item);
        }
        return destination;
    }

    public static <T> List<T> k(ck0<? extends T> $this$toList) {
        lu.f($this$toList, "<this>");
        return l9.g(l($this$toList));
    }

    public static final <T> List<T> l(ck0<? extends T> $this$toMutableList) {
        lu.f($this$toMutableList, "<this>");
        return (List) j($this$toMutableList, new ArrayList());
    }

    public static <T, R> ck0<R> i(ck0<? extends T> $this$mapNotNull, vn<? super T, ? extends R> transform) {
        lu.f($this$mapNotNull, "<this>");
        lu.f(transform, "transform");
        return g(new bs0($this$mapNotNull, transform));
    }
}
