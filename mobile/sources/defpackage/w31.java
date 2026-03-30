package defpackage;

/* renamed from: w31  reason: default package */
final class w31 extends w51<w4, ny0> {
    private final n41 a;

    public w31(String str, String str2, String str3) {
        super(2);
        y90.g(str, "email cannot be null or empty");
        y90.g(str2, "password cannot be null or empty");
        this.a = new n41(str, str2, str3);
    }

    public final String d() {
        return "signInWithEmailAndPassword";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new u31(this)).a();
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
            w41.b().M(this.a.m(), this.a.p(), this.f5448a);
        } else {
            w41.b().U(this.a, this.f5448a);
        }
    }
}
