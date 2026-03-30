package defpackage;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import defpackage.ms0;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* renamed from: me  reason: default package */
final class me extends ms0 {
    private Provider<Executor> a;
    private Provider<Context> b;
    private Provider c;
    private Provider d;
    private Provider e;
    private Provider<hg0> f;
    private Provider<e> g;
    private Provider<yv0> h;
    private Provider<rf> i;
    private Provider<ut0> j;
    private Provider<vv0> k;
    private Provider<ls0> l;

    private me(Context setApplicationContextParam) {
        q(setApplicationContextParam);
    }

    public static ms0.a o() {
        return new b();
    }

    private void q(Context setApplicationContextParam) {
        this.a = sh.a(uj.a());
        ik a2 = ws.a(setApplicationContextParam);
        this.b = a2;
        td a3 = td.a(a2, lr0.a(), mr0.a());
        this.c = a3;
        this.d = sh.a(r10.a(this.b, a3));
        this.e = pj0.a(this.b, kj.a());
        this.f = sh.a(ig0.a(lr0.a(), mr0.a(), lj.a(), this.e));
        ij0 b2 = ij0.b(lr0.a());
        this.g = b2;
        kj0 a4 = kj0.a(this.b, this.f, b2, mr0.a());
        this.h = a4;
        Provider<Executor> provider = this.a;
        Provider provider2 = this.d;
        Provider<hg0> provider3 = this.f;
        this.i = sf.a(provider, provider2, a4, provider3, provider3);
        Provider<Context> provider4 = this.b;
        Provider provider5 = this.d;
        Provider<hg0> provider6 = this.f;
        this.j = vt0.a(provider4, provider5, provider6, this.h, this.a, provider6, lr0.a());
        Provider<Executor> provider7 = this.a;
        Provider<hg0> provider8 = this.f;
        this.k = wv0.a(provider7, provider8, this.h, provider8);
        this.l = sh.a(ns0.a(lr0.a(), mr0.a(), this.i, this.j, this.k));
    }

    /* access modifiers changed from: package-private */
    public ls0 f() {
        return this.l.get();
    }

    /* access modifiers changed from: package-private */
    public hj c() {
        return this.f.get();
    }

    /* renamed from: me$b */
    private static final class b implements ms0.a {
        private Context a;

        private b() {
        }

        /* renamed from: c */
        public b b(Context applicationContext) {
            this.a = (Context) x90.b(applicationContext);
            return this;
        }

        public ms0 a() {
            x90.a(this.a, Context.class);
            return new me(this.a);
        }
    }
}
