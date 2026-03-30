package defpackage;

import com.google.firebase.auth.h;

/* renamed from: q41  reason: default package */
final class q41 extends w51<Void, h.b> {
    private final j41 a;

    public q41(d71 d71) {
        super(8);
        y90.j(d71);
        this.a = new j41(d71);
    }

    public final String d() {
        return "verifyPhoneNumber";
    }

    public final fq0<w41, Void> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new o41(this)).a();
    }

    public final void p() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(w41 w41, gq0 gq0) {
        this.f5447a = new q61(this, gq0);
        if (this.f5449a) {
            w41.b().G(this.a.m(), this.f5448a);
        } else {
            w41.b().Y(this.a, this.f5448a);
        }
    }
}
