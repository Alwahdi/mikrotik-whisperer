package defpackage;

import defpackage.qk0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: tz  reason: default package */
public abstract class tz {
    static final Iterable<Class<?>> a;

    /* renamed from: a  reason: collision with other field name */
    private static final tz f5181a;

    /* access modifiers changed from: protected */
    public abstract sz<?> a(String str);

    /* access modifiers changed from: protected */
    public abstract boolean b();

    /* access modifiers changed from: protected */
    public abstract int c();

    static {
        Class cls = tz.class;
        b bVar = new b((a) null);
        a = bVar;
        f5181a = (tz) qk0.e(cls, bVar, cls.getClassLoader(), new a());
    }

    /* renamed from: tz$a */
    class a implements qk0.b<tz> {
        a() {
        }

        /* renamed from: d */
        public boolean a(tz provider) {
            return provider.b();
        }

        /* renamed from: c */
        public int b(tz provider) {
            return provider.c();
        }
    }

    public static tz d() {
        tz tzVar = f5181a;
        if (tzVar != null) {
            return tzVar;
        }
        throw new c("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }

    /* renamed from: tz$c */
    public static final class c extends RuntimeException {
        public c(String msg) {
            super(msg);
        }
    }

    /* renamed from: tz$b */
    private static final class b implements Iterable<Class<?>> {
        private b() {
        }

        /* synthetic */ b(a x0) {
            this();
        }

        public Iterator<Class<?>> iterator() {
            List<Class<?>> list = new ArrayList<>();
            Class<k40> cls = k40.class;
            try {
                int i = k40.a;
                list.add(cls);
            } catch (ClassNotFoundException e) {
            }
            try {
                list.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
            } catch (ClassNotFoundException e2) {
            }
            return list.iterator();
        }
    }
}
