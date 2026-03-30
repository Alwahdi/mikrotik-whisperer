package defpackage;

import defpackage.yc;

/* renamed from: xq0  reason: default package */
public abstract class xq0 {
    private static final jo<Object, yc.b, Object> a = a.a;

    /* renamed from: a  reason: collision with other field name */
    public static final uo0 f5753a = new uo0("NO_THREAD_ELEMENTS");
    private static final jo<wq0<?>, yc.b, wq0<?>> b = b.a;
    private static final jo<dr0, yc.b, dr0> c = c.a;

    /* renamed from: xq0$a */
    static final class a extends ow implements jo<Object, yc.b, Object> {
        public static final a a = new a();

        a() {
            super(2);
        }

        /* renamed from: b */
        public final Object invoke(Object countOrElement, yc.b element) {
            if (!(element instanceof wq0)) {
                return countOrElement;
            }
            Integer num = countOrElement instanceof Integer ? (Integer) countOrElement : null;
            int inCount = num != null ? num.intValue() : 1;
            return inCount == 0 ? element : Integer.valueOf(inCount + 1);
        }
    }

    /* renamed from: xq0$b */
    static final class b extends ow implements jo<wq0<?>, yc.b, wq0<?>> {
        public static final b a = new b();

        b() {
            super(2);
        }

        /* renamed from: b */
        public final wq0<?> invoke(wq0<?> found, yc.b element) {
            if (found != null) {
                return found;
            }
            if (element instanceof wq0) {
                return (wq0) element;
            }
            return null;
        }
    }

    /* renamed from: xq0$c */
    static final class c extends ow implements jo<dr0, yc.b, dr0> {
        public static final c a = new c();

        c() {
            super(2);
        }

        /* renamed from: b */
        public final dr0 invoke(dr0 state, yc.b element) {
            if (element instanceof wq0) {
                state.a((wq0) element, ((wq0) element).U(state.f2817a));
            }
            return state;
        }
    }

    public static final Object b(yc context) {
        Object fold = context.fold(0, a);
        lu.c(fold);
        return fold;
    }

    public static final Object c(yc context, Object countOrElement) {
        Object countOrElement2 = countOrElement == null ? b(context) : countOrElement;
        if (countOrElement2 == 0) {
            return f5753a;
        }
        if (countOrElement2 instanceof Integer) {
            return context.fold(new dr0(context, ((Number) countOrElement2).intValue()), c);
        }
        return ((wq0) countOrElement2).U(context);
    }

    public static final void a(yc context, Object oldState) {
        if (oldState != f5753a) {
            if (oldState instanceof dr0) {
                ((dr0) oldState).b(context);
                return;
            }
            Object fold = context.fold(null, b);
            if (fold != null) {
                ((wq0) fold).f(context, oldState);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
    }
}
