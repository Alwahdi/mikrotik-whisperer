package defpackage;

import android.database.Cursor;
import com.google.firebase.firestore.core.b0;
import defpackage.di0;

/* renamed from: bi0  reason: default package */
final /* synthetic */ class bi0 implements hc {
    private final b0 a;

    /* renamed from: a  reason: collision with other field name */
    private final di0.c f230a;

    /* renamed from: a  reason: collision with other field name */
    private final di0 f231a;

    private bi0(di0 di0, b0 b0Var, di0.c cVar) {
        this.f231a = di0;
        this.a = b0Var;
        this.f230a = cVar;
    }

    public static hc a(di0 di0, b0 b0Var, di0.c cVar) {
        return new bi0(di0, b0Var, cVar);
    }

    public void accept(Object obj) {
        di0.p(this.f231a, this.a, this.f230a, (Cursor) obj);
    }
}
