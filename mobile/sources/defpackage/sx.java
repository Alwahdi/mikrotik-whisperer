package defpackage;

import com.google.firebase.firestore.core.f0;
import com.google.firebase.firestore.core.q;
import com.google.firebase.firestore.core.y;

/* renamed from: sx  reason: default package */
public class sx implements rx {
    private final q a;

    /* renamed from: a  reason: collision with other field name */
    private final y f5059a;

    /* renamed from: a  reason: collision with other field name */
    private final p4<f0> f5060a;

    public sx(q client, y queryListener, p4<f0> asyncEventListener) {
        this.a = client;
        this.f5059a = queryListener;
        this.f5060a = asyncEventListener;
    }

    public void remove() {
        this.f5060a.c();
        this.a.s(this.f5059a);
    }
}
