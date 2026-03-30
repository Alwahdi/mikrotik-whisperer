package defpackage;

import android.text.TextUtils;

/* renamed from: w11  reason: default package */
final class w11 extends w51<hp, ny0> {
    private final n31 a;

    public w11(String str) {
        super(1);
        y90.g(str, "refresh token cannot be null");
        this.a = new n31(str);
    }

    public final String d() {
        return "getAccessToken";
    }

    public final fq0<w41, hp> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new u11(this)).a();
    }

    public final void p() {
        if (TextUtils.isEmpty(this.f5445a.s())) {
            this.f5445a.m(this.a.m());
        }
        ((ny0) this.f5439a).a(this.f5445a, this.f5437a);
        o(g01.a(this.f5445a.t()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(w41 w41, gq0 gq0) {
        this.f5447a = new q61(this, gq0);
        if (this.f5449a) {
            w41.b().t(this.a.m(), this.f5448a);
        } else {
            w41.b().L(this.a, this.f5448a);
        }
    }
}
