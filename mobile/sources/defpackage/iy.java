package defpackage;

import com.google.firebase.firestore.core.b0;
import defpackage.ky;

/* renamed from: iy  reason: default package */
final /* synthetic */ class iy implements Runnable {
    private final b0 a;

    /* renamed from: a  reason: collision with other field name */
    private final ky.b f3991a;

    /* renamed from: a  reason: collision with other field name */
    private final ky f3992a;

    private iy(ky kyVar, ky.b bVar, b0 b0Var) {
        this.f3992a = kyVar;
        this.f3991a = bVar;
        this.a = b0Var;
    }

    public static Runnable a(ky kyVar, ky.b bVar, b0 b0Var) {
        return new iy(kyVar, bVar, b0Var);
    }

    public void run() {
        ky.m(this.f3992a, this.f3991a, this.a);
    }
}
