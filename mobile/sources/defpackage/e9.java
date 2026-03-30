package defpackage;

import java.lang.Comparable;

/* renamed from: e9  reason: default package */
public interface e9<T extends Comparable<? super T>> {
    T getEndInclusive();

    T getStart();

    /* renamed from: e9$a */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(e9<T> $this, T value) {
            lu.f(value, "value");
            return value.compareTo($this.getStart()) >= 0 && value.compareTo($this.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(e9<T> $this) {
            return $this.getStart().compareTo($this.getEndInclusive()) > 0;
        }
    }
}
