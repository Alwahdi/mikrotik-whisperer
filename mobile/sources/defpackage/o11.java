package defpackage;

/* renamed from: o11  reason: default package */
final class o11 extends w51<w4, ny0> {
    final k31 a;

    public o11(String str, String str2, String str3) {
        super(2);
        y90.g(str, "email cannot be null or empty");
        y90.g(str2, "password cannot be null or empty");
        this.a = new k31(str, str2, str3);
    }

    public final String d() {
        return "createUserWithEmailAndPassword";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new l11(this)).a();
    }

    public final void p() {
        y81 n = p01.n(this.f5438a, this.f5434a);
        ((ny0) this.f5439a).a(this.f5445a, n);
        o(new t71(n));
    }
}
