package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import defpackage.i3.d;
import defpackage.vp;
import defpackage.z5;
import java.util.Set;

/* renamed from: i3  reason: default package */
public final class i3<O extends d> {
    private final a<?, O> a;

    /* renamed from: a  reason: collision with other field name */
    private final g<?> f3205a;

    /* renamed from: a  reason: collision with other field name */
    private final String f3206a;

    /* renamed from: i3$a */
    public static abstract class a<T extends f, O> extends e<T, O> {
        public T b(Context context, Looper looper, y8 y8Var, O o, vp.a aVar, vp.b bVar) {
            return a(context, looper, y8Var, o, aVar, bVar);
        }

        public T a(Context context, Looper looper, y8 y8Var, O o, ac acVar, p40 p40) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* renamed from: i3$b */
    public interface b {
    }

    /* renamed from: i3$c */
    public static class c<C extends b> {
    }

    /* renamed from: i3$d */
    public interface d {
    }

    /* renamed from: i3$e */
    public static abstract class e<T extends b, O> {
    }

    /* renamed from: i3$f */
    public interface f extends b {
        void a(cr crVar, Set<Scope> set);

        boolean d();

        boolean e();

        void f(z5.c cVar);

        String g();

        boolean h();

        int i();

        Set<Scope> j();

        nk[] k();

        boolean l();

        void m();

        void o(z5.e eVar);
    }

    /* renamed from: i3$g */
    public static final class g<C extends f> extends c<C> {
    }

    public <C extends f> i3(String str, a<C, O> aVar, g<C> gVar) {
        y90.k(aVar, "Cannot construct an Api with a null ClientBuilder");
        y90.k(gVar, "Cannot construct an Api with a null ClientKey");
        this.f3206a = str;
        this.a = aVar;
        this.f3205a = gVar;
    }

    public final a<?, O> b() {
        y90.m(this.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }

    public final String a() {
        return this.f3206a;
    }
}
