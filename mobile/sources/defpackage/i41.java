package defpackage;

import com.google.firebase.auth.g;

/* renamed from: i41  reason: default package */
final class i41 extends w51<w4, ny0> {
    private final t41 a;

    public i41(g gVar, String str) {
        super(2);
        y90.j(gVar);
        this.a = new t41(gVar, str);
    }

    public final String d() {
        return "signInWithPhoneNumber";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new b41(this)).a();
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
            w41.b().y(this.a.m(), this.f5448a);
        } else {
            w41.b().N(this.a, this.f5448a);
        }
    }
}
