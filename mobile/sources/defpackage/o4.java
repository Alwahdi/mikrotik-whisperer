package defpackage;

import com.google.firebase.firestore.i;

/* renamed from: o4  reason: default package */
final /* synthetic */ class o4 implements Runnable {
    private final i a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f4480a;

    /* renamed from: a  reason: collision with other field name */
    private final p4 f4481a;

    private o4(p4 p4Var, Object obj, i iVar) {
        this.f4481a = p4Var;
        this.f4480a = obj;
        this.a = iVar;
    }

    public static Runnable a(p4 p4Var, Object obj, i iVar) {
        return new o4(p4Var, obj, iVar);
    }

    public void run() {
        p4.b(this.f4481a, this.f4480a, this.a);
    }
}
