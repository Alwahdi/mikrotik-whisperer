package defpackage;

import com.google.firebase.auth.FirebaseAuth;

/* renamed from: ha1  reason: default package */
final class ha1 implements Runnable {
    private final String a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ yy0 f3158a;

    ha1(yy0 yy0, String str) {
        this.f3158a = yy0;
        this.a = y90.f(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(gl.k(this.a));
        if (instance.e() != null) {
            eq0<hp> c = instance.c(true);
            yy0.a.f("Token refreshing started", new Object[0]);
            c.e(new ez0(this));
        }
    }
}
