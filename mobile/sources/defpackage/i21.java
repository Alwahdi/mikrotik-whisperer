package defpackage;

import com.google.firebase.auth.g;

/* renamed from: i21  reason: default package */
final class i21 extends w51<w4, ny0> {
    private final g a;

    public i21(g gVar) {
        super(2);
        this.a = (g) y90.k(gVar, "credential cannot be null");
    }

    public final String d() {
        return "linkPhoneAuthCredential";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new g21(this)).a();
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
            w41.b().s(this.f5437a.E(), this.a, this.f5448a);
        } else {
            w41.b().a0(new v31(this.f5437a.E(), this.a), this.f5448a);
        }
    }
}
