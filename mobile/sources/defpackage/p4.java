package defpackage;

import com.google.firebase.firestore.i;
import java.util.concurrent.Executor;

/* renamed from: p4  reason: default package */
public class p4<T> implements bj<T> {
    private final bj<T> a;

    /* renamed from: a  reason: collision with other field name */
    private final Executor f4666a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f4667a = false;

    public p4(Executor executor, bj<T> eventListener) {
        this.f4666a = executor;
        this.a = eventListener;
    }

    public void a(T value, i error) {
        this.f4666a.execute(o4.a(this, value, error));
    }

    static /* synthetic */ void b(p4 p4Var, Object value, i error) {
        if (!p4Var.f4667a) {
            p4Var.a.a(value, error);
        }
    }

    public void c() {
        this.f4667a = true;
    }
}
