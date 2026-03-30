package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.a;
import com.google.firebase.auth.g;

/* renamed from: y51  reason: default package */
final class y51 extends h51 {
    final /* synthetic */ w51 a;

    y51(w51 w51) {
        this.a = w51;
    }

    public final void f(s61 s61) {
        int i = this.a.a;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5445a = s61;
        w51.q();
    }

    public final void K(s61 s61, b61 b61) {
        int i = this.a.a;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unexpected response type: ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5445a = s61;
        w51.f5434a = b61;
        w51.q();
    }

    public final void J(u51 u51) {
        int i = this.a.a;
        boolean z = i == 3;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5446a = u51;
        w51.q();
    }

    public final void k(a71 a71) {
        int i = this.a.a;
        boolean z = i == 4;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5432a = a71;
        w51.q();
    }

    public final void E() {
        int i = this.a.a;
        boolean z = i == 5;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        this.a.q();
    }

    public final void X() {
        int i = this.a.a;
        boolean z = i == 6;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        this.a.q();
    }

    public final void r(String str) {
        int i = this.a.a;
        boolean z = i == 7;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5440a = str;
        w51.q();
    }

    public final void H(String str) {
        int i = this.a.a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        this.a.f5450b = str;
        c(new a61(this, str));
    }

    public final void h(g gVar) {
        int i = this.a.a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        boolean unused = this.a.f5452c = true;
        this.a.f5453d = true;
        c(new z51(this, gVar));
    }

    public final void S(String str) {
        int i = this.a.a;
        boolean z = i == 8;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        w51 w51 = this.a;
        w51.f5450b = str;
        boolean unused = w51.f5452c = true;
        this.a.f5453d = true;
        c(new d61(this, str));
    }

    public final void d(Status status) {
        String p = status.p();
        if (p != null) {
            if (p.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (p.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (p.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (p.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (p.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (p.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (p.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (p.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (p.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (p.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        w51 w51 = this.a;
        if (w51.a == 8) {
            boolean unused = w51.f5452c = true;
            this.a.f5453d = false;
            c(new c61(this, status));
            return;
        }
        w51.n(status);
        this.a.j(status);
    }

    public final void e0(Status status, g gVar) {
        int i = this.a.a;
        boolean z = i == 2;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        b(status, gVar, (String) null, (String) null);
    }

    public final void g0(m51 m51) {
        b(m51.m(), m51.p(), m51.r(), m51.s());
    }

    public final void x(p51 p51) {
        w51 w51 = this.a;
        w51.f5444a = p51;
        w51.j(ea1.a("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    private final void b(Status status, a aVar, String str, String str2) {
        this.a.n(status);
        w51 w51 = this.a;
        w51.f5436a = aVar;
        w51.c = str;
        w51.d = str2;
        jz0 jz0 = w51.f5443a;
        if (jz0 != null) {
            jz0.d(status);
        }
        this.a.j(status);
    }

    public final void l() {
        int i = this.a.a;
        boolean z = i == 9;
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected response type ");
        sb.append(i);
        y90.m(z, sb.toString());
        this.a.q();
    }

    private final void c(e61 e61) {
        this.a.f5442a.execute(new p61(this, e61));
    }
}
