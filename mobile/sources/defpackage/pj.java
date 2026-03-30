package defpackage;

import defpackage.se0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;

/* renamed from: pj  reason: default package */
public abstract class pj {
    private static final int a = f(Throwable.class, -1);

    /* renamed from: a  reason: collision with other field name */
    private static final wd f4716a;

    static {
        wd wdVar;
        try {
            if (mk.a()) {
                wdVar = rv0.f4951a;
            } else {
                wdVar = v8.f5311a;
            }
        } catch (Throwable th) {
            wdVar = rv0.f4951a;
        }
        f4716a = wdVar;
    }

    public static final <E extends Throwable> E g(E exception) {
        E e2;
        if (!(exception instanceof vc)) {
            return (Throwable) f4716a.a(exception.getClass()).invoke(exception);
        }
        try {
            se0.a aVar = se0.a;
            e2 = se0.a(((vc) exception).a());
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            e2 = se0.a(te0.a(th));
        }
        if (se0.c(e2)) {
            e2 = null;
        }
        return (Throwable) e2;
    }

    /* renamed from: pj$b */
    static final class b extends ow implements vn {
        public static final b a = new b();

        b() {
            super(1);
        }

        /* renamed from: b */
        public final Void invoke(Throwable it) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> vn<Throwable, Throwable> b(Class<E> clz) {
        vn nullResult = b.a;
        if (a != f(clz, 0)) {
            return nullResult;
        }
        for (Constructor constructor : l4.o(clz.getConstructors(), new a())) {
            vn result = c(constructor);
            if (result != null) {
                return result;
            }
        }
        return nullResult;
    }

    private static final vn<Throwable, Throwable> c(Constructor<?> constructor) {
        Class<String> cls = String.class;
        Class[] p = constructor.getParameterTypes();
        switch (p.length) {
            case 0:
                return new f(constructor);
            case 1:
                Class cls2 = p[0];
                if (lu.a(cls2, Throwable.class)) {
                    return new d(constructor);
                }
                if (lu.a(cls2, cls)) {
                    return new e(constructor);
                }
                return null;
            case 2:
                if (!lu.a(p[0], cls) || !lu.a(p[1], Throwable.class)) {
                    return null;
                }
                return new c(constructor);
            default:
                return null;
        }
    }

    /* renamed from: pj$c */
    public static final class c extends ow implements vn<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        /* renamed from: b */
        public final Throwable invoke(Throwable e) {
            Object obj;
            try {
                se0.a aVar = se0.a;
                Throwable e2 = e;
                Object newInstance = this.a.newInstance(new Object[]{e2.getMessage(), e2});
                if (newInstance != null) {
                    obj = se0.a((Throwable) newInstance);
                    if (se0.c(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th) {
                se0.a aVar2 = se0.a;
                obj = se0.a(te0.a(th));
            }
        }
    }

    /* renamed from: pj$d */
    public static final class d extends ow implements vn<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        /* renamed from: b */
        public final Throwable invoke(Throwable e) {
            Object obj;
            try {
                se0.a aVar = se0.a;
                Object newInstance = this.a.newInstance(new Object[]{e});
                if (newInstance != null) {
                    obj = se0.a((Throwable) newInstance);
                    if (se0.c(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th) {
                se0.a aVar2 = se0.a;
                obj = se0.a(te0.a(th));
            }
        }
    }

    /* renamed from: pj$e */
    public static final class e extends ow implements vn<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        /* renamed from: b */
        public final Throwable invoke(Throwable e) {
            Object obj;
            try {
                se0.a aVar = se0.a;
                Throwable e2 = e;
                Object newInstance = this.a.newInstance(new Object[]{e2.getMessage()});
                if (newInstance != null) {
                    Throwable it = (Throwable) newInstance;
                    it.initCause(e2);
                    obj = se0.a(it);
                    if (se0.c(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th) {
                se0.a aVar2 = se0.a;
                obj = se0.a(te0.a(th));
            }
        }
    }

    /* renamed from: pj$f */
    public static final class f extends ow implements vn<Throwable, Throwable> {
        final /* synthetic */ Constructor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        /* renamed from: b */
        public final Throwable invoke(Throwable e) {
            Object obj;
            try {
                se0.a aVar = se0.a;
                Throwable e2 = e;
                Object newInstance = this.a.newInstance(new Object[0]);
                if (newInstance != null) {
                    Throwable it = (Throwable) newInstance;
                    it.initCause(e2);
                    obj = se0.a(it);
                    if (se0.c(obj)) {
                        obj = null;
                    }
                    return (Throwable) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            } catch (Throwable th) {
                se0.a aVar2 = se0.a;
                obj = se0.a(te0.a(th));
            }
        }
    }

    private static final int f(Class<?> $this$fieldsCountOrDefault, int defaultValue) {
        Integer num;
        aw<?> c2 = xv.c($this$fieldsCountOrDefault);
        try {
            se0.a aVar = se0.a;
            num = se0.a(Integer.valueOf(e($this$fieldsCountOrDefault, 0, 1, (Object) null)));
        } catch (Throwable th) {
            se0.a aVar2 = se0.a;
            num = se0.a(te0.a(th));
        }
        Integer valueOf = Integer.valueOf(defaultValue);
        if (se0.c(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    private static final int d(Class<?> $this$fieldsCount, int accumulator) {
        Class<?> cls = $this$fieldsCount;
        int totalFields = accumulator;
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            int count$iv = 0;
            int length = declaredFields.length;
            for (int i = 0; i < length; i++) {
                if (!Modifier.isStatic(declaredFields[i].getModifiers())) {
                    count$iv++;
                }
            }
            totalFields += count$iv;
            cls = cls.getSuperclass();
        } while (cls != null);
        return totalFields;
    }

    static /* synthetic */ int e(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return d(cls, i);
    }

    /* renamed from: pj$a */
    public static final class a<T> implements Comparator {
        public final int compare(T a, T b) {
            return oa.a(Integer.valueOf(((Constructor) b).getParameterTypes().length), Integer.valueOf(((Constructor) a).getParameterTypes().length));
        }
    }
}
