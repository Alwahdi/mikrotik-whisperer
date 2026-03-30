package defpackage;

import defpackage.yc;

/* renamed from: tc  reason: default package */
public interface tc extends yc.b {
    public static final b a = b.b;

    <T> rc<T> interceptContinuation(rc<? super T> rcVar);

    void releaseInterceptedContinuation(rc<?> rcVar);

    /* renamed from: tc$b */
    public static final class b implements yc.c<tc> {
        static final /* synthetic */ b b = new b();

        private b() {
        }
    }

    /* renamed from: tc$a */
    public static final class a {
        public static <E extends yc.b> E a(tc $this, yc.c<E> key) {
            lu.f(key, "key");
            if (key instanceof l) {
                if (!((l) key).a($this.getKey())) {
                    return null;
                }
                E b = ((l) key).b($this);
                if (b instanceof yc.b) {
                    return b;
                }
                return null;
            } else if (tc.a != key) {
                return null;
            } else {
                lu.d($this, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return $this;
            }
        }

        public static yc b(tc $this, yc.c<?> key) {
            lu.f(key, "key");
            return key instanceof l ? (!((l) key).a($this.getKey()) || ((l) key).b($this) == null) ? $this : gi.a : tc.a == key ? gi.a : $this;
        }
    }
}
