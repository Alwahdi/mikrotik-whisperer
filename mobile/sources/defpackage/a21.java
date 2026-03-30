package defpackage;

import com.google.firebase.auth.b;

/* renamed from: a21  reason: default package */
final class a21 extends w51<w4, ny0> {
    private final b a;

    public a21(b bVar) {
        super(2);
        this.a = (b) y90.k(bVar, "credential cannot be null");
        y90.g(bVar.t(), "email cannot be null");
        y90.g(bVar.u(), "password cannot be null");
    }

    public final String d() {
        return "linkEmailAuthCredential";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new y11(this)).a();
    }

    public final void p() {
        y81 n = p01.n(this.f5438a, this.f5434a);
        ((ny0) this.f5439a).a(this.f5445a, n);
        o(new t71(n));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(w41 w41, gq0 gq0) {
        this.f5447a = new q61(this, gq0);
        if (this.f5449a) {
            w41.b().v(this.a.t(), this.a.u(), this.f5437a.E(), this.f5448a);
        } else {
            w41.b().T(new q31(this.a.t(), this.a.u(), this.f5437a.E()), this.f5448a);
        }
    }
}
