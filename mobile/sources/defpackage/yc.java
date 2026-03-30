package defpackage;

import defpackage.tc;

/* renamed from: yc  reason: default package */
public interface yc {

    /* renamed from: yc$c */
    public interface c<E extends b> {
    }

    <R> R fold(R r, jo<? super R, ? super b, ? extends R> joVar);

    <E extends b> E get(c<E> cVar);

    yc minusKey(c<?> cVar);

    yc plus(yc ycVar);

    /* renamed from: yc$a */
    public static final class a {
        public static yc a(yc $this, yc context) {
            lu.f(context, "context");
            if (context == gi.a) {
                return $this;
            }
            return (yc) context.fold($this, C0062a.a);
        }

        /* renamed from: yc$a$a  reason: collision with other inner class name */
        static final class C0062a extends ow implements jo<yc, b, yc> {
            public static final C0062a a = new C0062a();

            C0062a() {
                super(2);
            }

            /* renamed from: b */
            public final yc invoke(yc acc, b element) {
                lu.f(acc, "acc");
                lu.f(element, "element");
                yc removed = acc.minusKey(element.getKey());
                gi giVar = gi.a;
                if (removed == giVar) {
                    return element;
                }
                tc.b bVar = tc.a;
                tc interceptor = (tc) removed.get(bVar);
                if (interceptor == null) {
                    return new ka(removed, element);
                }
                yc left = removed.minusKey(bVar);
                if (left == giVar) {
                    return new ka(element, interceptor);
                }
                return new ka(new ka(left, element), interceptor);
            }
        }
    }

    /* renamed from: yc$b */
    public interface b extends yc {
        <E extends b> E get(c<E> cVar);

        c<?> getKey();

        /* renamed from: yc$b$a */
        public static final class a {
            public static yc d(b $this, yc context) {
                lu.f(context, "context");
                return a.a($this, context);
            }

            public static <E extends b> E b(b $this, c<E> key) {
                lu.f(key, "key");
                if (!lu.a($this.getKey(), key)) {
                    return null;
                }
                lu.d($this, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return $this;
            }

            public static <R> R a(b $this, R initial, jo<? super R, ? super b, ? extends R> operation) {
                lu.f(operation, "operation");
                return operation.invoke(initial, $this);
            }

            public static yc c(b $this, c<?> key) {
                lu.f(key, "key");
                return lu.a($this.getKey(), key) ? gi.a : $this;
            }
        }
    }
}
