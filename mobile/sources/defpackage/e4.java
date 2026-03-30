package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: e4  reason: default package */
public abstract class e4 implements yr0 {
    private final List<rk> a;

    /* access modifiers changed from: protected */
    public abstract g4 d(rk rkVar);

    e4(List<rk> elements) {
        this.a = Collections.unmodifiableList(elements);
    }

    public List<rk> f() {
        return this.a;
    }

    public rk a(rk previousValue, pr0 localWriteTime) {
        return d(previousValue);
    }

    public rk c(rk previousValue, rk transformResult) {
        return d(previousValue);
    }

    public rk b(rk currentValue) {
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.a.equals(((e4) o).a);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.a.hashCode();
    }

    static ArrayList<rk> e(rk value) {
        if (value instanceof g4) {
            return new ArrayList<>(((g4) value).g());
        }
        return new ArrayList<>();
    }

    /* renamed from: e4$b */
    public static class b extends e4 {
        public b(List<rk> elements) {
            super(elements);
        }

        /* access modifiers changed from: protected */
        public g4 d(rk previousValue) {
            ArrayList<rk> e = e4.e(previousValue);
            for (rk element : f()) {
                if (!e.contains(element)) {
                    e.add(element);
                }
            }
            return g4.e(e);
        }
    }

    /* renamed from: e4$a */
    public static class a extends e4 {
        public a(List<rk> elements) {
            super(elements);
        }

        /* access modifiers changed from: protected */
        public g4 d(rk previousValue) {
            ArrayList<rk> e = e4.e(previousValue);
            for (rk element : f()) {
                e.removeAll(Collections.singleton(element));
            }
            return g4.e(e);
        }
    }
}
