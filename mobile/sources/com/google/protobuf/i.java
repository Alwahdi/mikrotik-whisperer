package com.google.protobuf;

import com.google.protobuf.Internal;
import com.google.protobuf.a;
import com.google.protobuf.i;
import com.google.protobuf.i.b;
import com.google.protobuf.l;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class i<MessageType extends i<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    protected w a = w.a();
    protected int b = -1;

    public enum g {
        IS_INITIALIZED,
        VISIT,
        MERGE_FROM_STREAM,
        MAKE_IMMUTABLE,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    protected interface h {
        <K, V> o<K, V> a(o<K, V> oVar, o<K, V> oVar2);

        boolean b(boolean z, boolean z2, boolean z3, boolean z4);

        l.c c(l.c cVar, l.c cVar2);

        Object d(boolean z, Object obj, Object obj2);

        Object e(boolean z, Object obj, Object obj2);

        w f(w wVar, w wVar2);

        long g(boolean z, long j, boolean z2, long j2);

        Object h(boolean z, Object obj, Object obj2);

        Object i(boolean z, Object obj, Object obj2);

        Object j(boolean z, Object obj, Object obj2);

        Object k(boolean z, Object obj, Object obj2);

        String l(boolean z, String str, boolean z2, String str2);

        <T extends p> T m(T t, T t2);

        e n(boolean z, e eVar, boolean z2, e eVar2);

        Object o(boolean z, Object obj, Object obj2);

        int p(boolean z, int i, boolean z2, int i2);

        <T> l.d<T> q(l.d<T> dVar, l.d<T> dVar2);

        double r(boolean z, double d, boolean z2, double d2);

        void s(boolean z);
    }

    /* access modifiers changed from: protected */
    public abstract Object p(g gVar, Object obj, Object obj2);

    public final n50<MessageType> h() {
        return (n50) m(g.GET_PARSER);
    }

    /* renamed from: u */
    public final MessageType g() {
        return (i) m(g.GET_DEFAULT_INSTANCE);
    }

    public final BuilderType A() {
        return (b) m(g.NEW_BUILDER);
    }

    public String toString() {
        return q.e(this, super.toString());
    }

    public int hashCode() {
        if (this.a == 0) {
            e visitor = new e();
            J(visitor, this);
            this.a = visitor.a;
        }
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public int v(e visitor) {
        if (this.a == 0) {
            int inProgressHashCode = visitor.a;
            int unused = visitor.a = 0;
            J(visitor, this);
            this.a = visitor.a;
            int unused2 = visitor.a = inProgressHashCode;
        }
        return this.a;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!g().getClass().isInstance(other)) {
            return false;
        }
        try {
            J(d.f2578a, (i) other);
            return true;
        } catch (d.a e2) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean t(d visitor, p other) {
        if (this == other) {
            return true;
        }
        if (!g().getClass().isInstance(other)) {
            return false;
        }
        J(visitor, (i) other);
        return true;
    }

    /* access modifiers changed from: protected */
    public void x() {
        m(g.MAKE_IMMUTABLE);
        this.a.b();
    }

    public final boolean c() {
        return n(g.IS_INITIALIZED, Boolean.TRUE) != null;
    }

    /* renamed from: I */
    public final BuilderType a() {
        BuilderType builder = (b) m(g.NEW_BUILDER);
        builder.w(this);
        return builder;
    }

    /* access modifiers changed from: protected */
    public Object n(g method, Object arg0) {
        return p(method, arg0, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Object m(g method) {
        return p(method, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void J(h visitor, MessageType other) {
        p(g.VISIT, visitor, other);
        this.a = visitor.f(this.a, other.a);
    }

    public static abstract class b<MessageType extends i<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends a.C0031a<MessageType, BuilderType> {
        private final MessageType a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f2577a = false;
        protected MessageType b;

        protected b(MessageType defaultInstance) {
            this.a = defaultInstance;
            this.b = (i) defaultInstance.m(g.NEW_MUTABLE_INSTANCE);
        }

        /* access modifiers changed from: protected */
        public void s() {
            if (this.f2577a) {
                MessageType newInstance = (i) this.b.m(g.NEW_MUTABLE_INSTANCE);
                newInstance.J(f.a, this.b);
                this.b = newInstance;
                this.f2577a = false;
            }
        }

        /* renamed from: r */
        public BuilderType clone() {
            BuilderType builder = g().A();
            builder.w(f());
            return builder;
        }

        /* renamed from: p */
        public MessageType f() {
            if (this.f2577a) {
                return this.b;
            }
            this.b.x();
            this.f2577a = true;
            return this.b;
        }

        /* renamed from: n */
        public final MessageType q() {
            MessageType result = f();
            if (result.c()) {
                return result;
            }
            throw a.C0031a.m(result);
        }

        /* access modifiers changed from: protected */
        /* renamed from: u */
        public BuilderType k(MessageType message) {
            return w(message);
        }

        public BuilderType w(MessageType message) {
            s();
            this.b.J(f.a, message);
            return this;
        }

        /* renamed from: t */
        public MessageType g() {
            return this.a;
        }

        /* renamed from: v */
        public BuilderType o(f input, fk extensionRegistry) {
            s();
            try {
                this.b.p(g.MERGE_FROM_STREAM, input, extensionRegistry);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    static Object w(Method method, Object object, Object... params) {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static l.c r() {
        return k.d();
    }

    protected static l.c y(l.c list) {
        int size = list.size();
        return list.y(size == 0 ? 10 : size * 2);
    }

    protected static <E> l.d<E> s() {
        return r.b();
    }

    protected static <E> l.d<E> z(l.d<E> list) {
        int size = list.size();
        return list.w(size == 0 ? 10 : size * 2);
    }

    protected static class c<T extends i<T, ?>> extends b<T> {
        private T a;

        public c(T defaultInstance) {
            this.a = defaultInstance;
        }

        /* renamed from: f */
        public T a(f input, fk extensionRegistry) {
            return i.G(this.a, input, extensionRegistry);
        }
    }

    static <T extends i<T, ?>> T G(T instance, f input, fk extensionRegistry) {
        T result = (i) instance.m(g.NEW_MUTABLE_INSTANCE);
        try {
            result.p(g.MERGE_FROM_STREAM, input, extensionRegistry);
            result.x();
            return result;
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof m) {
                throw ((m) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends i<T, ?>> T l(T message) {
        if (message == null || message.c()) {
            return message;
        }
        throw message.k().a().i(message);
    }

    protected static <T extends i<T, ?>> T B(T defaultInstance, e data) {
        return l(D(defaultInstance, data, fk.a()));
    }

    protected static <T extends i<T, ?>> T D(T defaultInstance, e data, fk extensionRegistry) {
        return l(F(defaultInstance, data, extensionRegistry));
    }

    private static <T extends i<T, ?>> T F(T defaultInstance, e data, fk extensionRegistry) {
        T message;
        try {
            f input = data.t();
            message = G(defaultInstance, input, extensionRegistry);
            input.a(0);
            return message;
        } catch (m e2) {
            throw e2.i(message);
        } catch (m e3) {
            throw e3;
        }
    }

    private static <T extends i<T, ?>> T H(T defaultInstance, byte[] data, fk extensionRegistry) {
        T message;
        try {
            f input = f.g(data);
            message = G(defaultInstance, input, extensionRegistry);
            input.a(0);
            return message;
        } catch (m e2) {
            throw e2.i(message);
        } catch (m e3) {
            throw e3;
        }
    }

    protected static <T extends i<T, ?>> T E(T defaultInstance, byte[] data) {
        return l(H(defaultInstance, data, fk.a()));
    }

    static class d implements h {
        static final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        static final d f2578a = new d();

        static final class a extends RuntimeException {
            a() {
            }
        }

        private d() {
        }

        public boolean b(boolean minePresent, boolean mine, boolean otherPresent, boolean other) {
            if (minePresent == otherPresent && mine == other) {
                return mine;
            }
            throw a;
        }

        public int p(boolean minePresent, int mine, boolean otherPresent, int other) {
            if (minePresent == otherPresent && mine == other) {
                return mine;
            }
            throw a;
        }

        public double r(boolean minePresent, double mine, boolean otherPresent, double other) {
            if (minePresent == otherPresent && mine == other) {
                return mine;
            }
            throw a;
        }

        public long g(boolean minePresent, long mine, boolean otherPresent, long other) {
            if (minePresent == otherPresent && mine == other) {
                return mine;
            }
            throw a;
        }

        public String l(boolean minePresent, String mine, boolean otherPresent, String other) {
            if (minePresent == otherPresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public e n(boolean minePresent, e mine, boolean otherPresent, e other) {
            if (minePresent == otherPresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object k(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object o(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object j(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object e(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object d(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object h(boolean minePresent, Object mine, Object other) {
            if (minePresent && mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public Object i(boolean minePresent, Object mine, Object other) {
            if (minePresent && ((i) mine).t(this, (p) other)) {
                return mine;
            }
            throw a;
        }

        public void s(boolean minePresent) {
            if (minePresent) {
                throw a;
            }
        }

        public <T extends p> T m(T mine, T other) {
            if (mine == null && other == null) {
                return null;
            }
            if (mine == null || other == null) {
                throw a;
            }
            ((i) mine).t(this, other);
            return mine;
        }

        public <T> l.d<T> q(l.d<T> mine, l.d<T> other) {
            if (mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public l.c c(l.c mine, l.c other) {
            if (mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public w f(w mine, w other) {
            if (mine.equals(other)) {
                return mine;
            }
            throw a;
        }

        public <K, V> o<K, V> a(o<K, V> mine, o<K, V> other) {
            if (mine.equals(other)) {
                return mine;
            }
            throw a;
        }
    }

    private static class e implements h {
        /* access modifiers changed from: private */
        public int a;

        private e() {
            this.a = 0;
        }

        public boolean b(boolean minePresent, boolean mine, boolean otherPresent, boolean other) {
            this.a = (this.a * 53) + l.a(mine);
            return mine;
        }

        public int p(boolean minePresent, int mine, boolean otherPresent, int other) {
            this.a = (this.a * 53) + mine;
            return mine;
        }

        public double r(boolean minePresent, double mine, boolean otherPresent, double other) {
            this.a = (this.a * 53) + l.d(Double.doubleToLongBits(mine));
            return mine;
        }

        public long g(boolean minePresent, long mine, boolean otherPresent, long other) {
            this.a = (this.a * 53) + l.d(mine);
            return mine;
        }

        public String l(boolean minePresent, String mine, boolean otherPresent, String other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public e n(boolean minePresent, e mine, boolean otherPresent, e other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public Object k(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + l.a(((Boolean) mine).booleanValue());
            return mine;
        }

        public Object o(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + ((Integer) mine).intValue();
            return mine;
        }

        public Object j(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + l.d(Double.doubleToLongBits(((Double) mine).doubleValue()));
            return mine;
        }

        public Object e(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + l.d(((Long) mine).longValue());
            return mine;
        }

        public Object d(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public Object h(boolean minePresent, Object mine, Object other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public Object i(boolean minePresent, Object mine, Object other) {
            return m((p) mine, (p) other);
        }

        public void s(boolean minePresent) {
            if (minePresent) {
                throw new IllegalStateException();
            }
        }

        public <T extends p> T m(T mine, T t) {
            int protoHash;
            if (mine == null) {
                protoHash = 37;
            } else if (mine instanceof i) {
                protoHash = ((i) mine).v(this);
            } else {
                protoHash = mine.hashCode();
            }
            this.a = (this.a * 53) + protoHash;
            return mine;
        }

        public <T> l.d<T> q(l.d<T> mine, l.d<T> dVar) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public l.c c(l.c mine, l.c other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public w f(w mine, w other) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }

        public <K, V> o<K, V> a(o<K, V> mine, o<K, V> oVar) {
            this.a = (this.a * 53) + mine.hashCode();
            return mine;
        }
    }

    protected static class f implements h {
        public static final f a = new f();

        private f() {
        }

        public boolean b(boolean minePresent, boolean mine, boolean otherPresent, boolean other) {
            return otherPresent ? other : mine;
        }

        public int p(boolean minePresent, int mine, boolean otherPresent, int other) {
            return otherPresent ? other : mine;
        }

        public double r(boolean minePresent, double mine, boolean otherPresent, double other) {
            return otherPresent ? other : mine;
        }

        public long g(boolean minePresent, long mine, boolean otherPresent, long other) {
            return otherPresent ? other : mine;
        }

        public String l(boolean minePresent, String mine, boolean otherPresent, String other) {
            return otherPresent ? other : mine;
        }

        public e n(boolean minePresent, e mine, boolean otherPresent, e other) {
            return otherPresent ? other : mine;
        }

        public Object k(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object o(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object j(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object e(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object d(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object h(boolean minePresent, Object mine, Object other) {
            return other;
        }

        public Object i(boolean minePresent, Object mine, Object other) {
            if (minePresent) {
                return m((p) mine, (p) other);
            }
            return other;
        }

        public void s(boolean minePresent) {
        }

        public <T extends p> T m(T mine, T other) {
            if (mine == null || other == null) {
                return mine != null ? mine : other;
            }
            return mine.a().C(other).q();
        }

        public <T> l.d<T> q(Internal.ProtobufList<T> mine, l.d<T> other) {
            int size = mine.size();
            int otherSize = other.size();
            if (size > 0 && otherSize > 0) {
                if (!mine.e()) {
                    mine = mine.w(size + otherSize);
                }
                mine.addAll(other);
            }
            return size > 0 ? mine : other;
        }

        public l.c c(l.c mine, l.c other) {
            int size = mine.size();
            int otherSize = other.size();
            if (size > 0 && otherSize > 0) {
                if (!mine.e()) {
                    mine = mine.y(size + otherSize);
                }
                mine.addAll(other);
            }
            return size > 0 ? mine : other;
        }

        public w f(w mine, w other) {
            if (other == w.a()) {
                return mine;
            }
            return w.c(mine, other);
        }

        public <K, V> o<K, V> a(MapFieldLite<K, V> mine, o<K, V> other) {
            if (!other.isEmpty()) {
                if (!mine.i()) {
                    mine = mine.l();
                }
                mine.k(other);
            }
            return mine;
        }
    }
}
