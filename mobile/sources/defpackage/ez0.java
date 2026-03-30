package defpackage;

/* renamed from: ez0  reason: default package */
final class ez0 implements r40 {
    private final /* synthetic */ ha1 a;

    ez0(ha1 ha1) {
        this.a = ha1;
    }

    public final void b(Exception exc) {
        if (exc instanceof zl) {
            yy0.a.f("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.a.f3158a.b();
        }
    }
}
