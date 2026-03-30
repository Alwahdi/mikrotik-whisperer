package defpackage;

import com.google.firebase.auth.b;

/* renamed from: m21  reason: default package */
final class m21 extends w51<w4, ny0> {
    private final b a;

    public m21(b bVar) {
        super(2);
        this.a = (b) y90.k(bVar, "credential cannot be null");
    }

    public final String d() {
        return "linkEmailAuthCredential";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new k21(this)).a();
    }

    public final void p() {
        y81 n = p01.n(this.f5438a, this.f5434a);
        ((ny0) this.f5439a).a(this.f5445a, n);
        o(new t71(n));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(w41 w41, gq0 gq0) {
        this.f5447a = new q61(this, gq0);
        p41 p41 = new p41(this.a.s(this.f5437a));
        if (this.f5449a) {
            w41.b().c0(p41.m(), this.f5448a);
        } else {
            w41.b().R(p41, this.f5448a);
        }
    }
}
