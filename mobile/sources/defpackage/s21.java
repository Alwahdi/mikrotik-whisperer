package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.a;

/* renamed from: s21  reason: default package */
final class s21 extends w51<w4, ny0> {
    private final l41 a;

    public s21(a aVar, String str) {
        super(2);
        y90.k(aVar, "credential cannot be null");
        this.a = new l41(e31.a(aVar, str).m(false));
    }

    public final String d() {
        return "reauthenticateWithCredentialWithData";
    }

    public final fq0<w41, w4> b() {
        return fq0.a().c(false).d((this.f5449a || this.f5451b) ? null : new nk[]{c51.b}).b(new q21(this)).a();
    }

    public final void p() {
        y81 n = p01.n(this.f5438a, this.f5434a);
        if (this.f5437a.r().equalsIgnoreCase(n.r())) {
            ((ny0) this.f5439a).a(this.f5445a, n);
            o(new t71(n));
            return;
        }
        j(new Status(17024));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(w41 w41, gq0 gq0) {
        this.f5447a = new q61(this, gq0);
        if (this.f5449a) {
            w41.b().q(this.a.m(), this.f5448a);
        } else {
            w41.b().i(this.a, this.f5448a);
        }
    }
}
