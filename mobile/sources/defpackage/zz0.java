package defpackage;

import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;

/* renamed from: zz0  reason: default package */
public final class zz0 {
    private static final zz0 a = new zz0();

    /* renamed from: a  reason: collision with other field name */
    private final fz0 f6055a;

    /* renamed from: a  reason: collision with other field name */
    private final l01 f6056a;

    private zz0() {
        this(l01.a(), fz0.a());
    }

    private zz0(l01 l01, fz0 fz0) {
        this.f6056a = l01;
        this.f6055a = fz0;
    }

    public static zz0 a() {
        return a;
    }

    public final void c(FirebaseAuth firebaseAuth) {
        this.f6056a.f(firebaseAuth);
    }

    public final void b(Context context) {
        this.f6056a.b(context);
    }
}
