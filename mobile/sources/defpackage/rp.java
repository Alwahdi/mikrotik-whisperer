package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import defpackage.i3;
import defpackage.i3.d;
import defpackage.wp;
import defpackage.y8;
import java.util.Collections;

/* renamed from: rp  reason: default package */
public abstract class rp<O extends i3.d> {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f4913a;

    /* renamed from: a  reason: collision with other field name */
    private final Looper f4914a;

    /* renamed from: a  reason: collision with other field name */
    private final fn0 f4915a;

    /* renamed from: a  reason: collision with other field name */
    private final O f4916a;

    /* renamed from: a  reason: collision with other field name */
    private final i3<O> f4917a;

    /* renamed from: a  reason: collision with other field name */
    private final o3<O> f4918a;

    /* renamed from: a  reason: collision with other field name */
    private final vp f4919a;

    /* renamed from: a  reason: collision with other field name */
    protected final wp f4920a;

    /* renamed from: rp$a */
    public static class a {
        public static final a a = new C0057a().a();

        /* renamed from: a  reason: collision with other field name */
        public final Looper f4921a;

        /* renamed from: a  reason: collision with other field name */
        public final fn0 f4922a;

        /* renamed from: rp$a$a  reason: collision with other inner class name */
        public static class C0057a {
            private Looper a;

            /* renamed from: a  reason: collision with other field name */
            private fn0 f4923a;

            public C0057a b(fn0 fn0) {
                y90.k(fn0, "StatusExceptionMapper must not be null.");
                this.f4923a = fn0;
                return this;
            }

            public a a() {
                if (this.f4923a == null) {
                    this.f4923a = new m3();
                }
                if (this.a == null) {
                    this.a = Looper.getMainLooper();
                }
                return new a(this.f4923a, this.a);
            }
        }

        private a(fn0 fn0, Account account, Looper looper) {
            this.f4922a = fn0;
            this.f4921a = looper;
        }
    }

    public rp(Context context, i3<O> i3Var, O o, a aVar) {
        y90.k(context, "Null context is not permitted.");
        y90.k(i3Var, "Api must not be null.");
        y90.k(aVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f4913a = applicationContext;
        this.f4917a = i3Var;
        this.f4916a = o;
        this.f4914a = aVar.f4921a;
        this.f4918a = o3.b(i3Var, o);
        this.f4919a = new cx0(this);
        wp e = wp.e(applicationContext);
        this.f4920a = e;
        this.a = e.h();
        this.f4915a = aVar.f4922a;
        e.c(this);
    }

    public rp(Context context, i3<O> i3Var, O o, fn0 fn0) {
        this(context, i3Var, o, new a.C0057a().b(fn0).a());
    }

    private final <TResult, A extends i3.b> eq0<TResult> h(int i, fq0<A, TResult> fq0) {
        gq0 gq0 = new gq0();
        this.f4920a.d(this, i, fq0, gq0, this.f4915a);
        return gq0.a();
    }

    public <TResult, A extends i3.b> eq0<TResult> b(fq0<A, TResult> fq0) {
        return h(0, fq0);
    }

    public <TResult, A extends i3.b> eq0<TResult> c(fq0<A, TResult> fq0) {
        return h(1, fq0);
    }

    public i3.f g(Looper looper, wp.a<O> aVar) {
        return this.f4917a.b().b(this.f4913a, looper, a().b(), this.f4916a, aVar, aVar);
    }

    public O e() {
        return this.f4916a;
    }

    public o3<O> d() {
        return this.f4918a;
    }

    public final int f() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public y8.a a() {
        return new y8.a().c((Account) null).a(Collections.emptySet()).d(this.f4913a.getClass().getName()).e(this.f4913a.getPackageName());
    }

    public kx0 i(Context context, Handler handler) {
        return new kx0(context, handler, a().b());
    }
}
