package defpackage;

import defpackage.i3;
import defpackage.i3.b;

/* renamed from: fq0  reason: default package */
public abstract class fq0<A extends i3.b, ResultT> {
    private final boolean a;

    /* renamed from: a  reason: collision with other field name */
    private final nk[] f2989a;

    /* access modifiers changed from: protected */
    public abstract void b(A a2, gq0<ResultT> gq0);

    /* renamed from: fq0$a */
    public static class a<A extends i3.b, ResultT> {
        /* access modifiers changed from: private */
        public ce0<A, gq0<ResultT>> a;

        /* renamed from: a  reason: collision with other field name */
        private boolean f2990a;

        /* renamed from: a  reason: collision with other field name */
        private nk[] f2991a;

        private a() {
            this.f2990a = true;
        }

        public a<A, ResultT> b(ce0<A, gq0<ResultT>> ce0) {
            this.a = ce0;
            return this;
        }

        public a<A, ResultT> d(nk... nkVarArr) {
            this.f2991a = nkVarArr;
            return this;
        }

        public a<A, ResultT> c(boolean z) {
            this.f2990a = z;
            return this;
        }

        public fq0<A, ResultT> a() {
            y90.b(this.a != null, "execute parameter required");
            return new ox0(this, this.f2991a, this.f2990a);
        }
    }

    private fq0(nk[] nkVarArr, boolean z) {
        this.f2989a = nkVarArr;
        this.a = z;
    }

    public final nk[] d() {
        return this.f2989a;
    }

    public boolean c() {
        return this.a;
    }

    public static <A extends i3.b, ResultT> a<A, ResultT> a() {
        return new a<>();
    }
}
