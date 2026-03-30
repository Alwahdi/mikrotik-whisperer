package defpackage;

import android.database.Cursor;
import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.core.x;

/* renamed from: hh0  reason: default package */
final /* synthetic */ class hh0 implements hc {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final x f3164a;

    /* renamed from: a  reason: collision with other field name */
    private final jh0 f3165a;

    /* renamed from: a  reason: collision with other field name */
    private final l5 f3166a;

    /* renamed from: a  reason: collision with other field name */
    private final c[] f3167a;

    private hh0(jh0 jh0, int i, l5 l5Var, x xVar, c[] cVarArr) {
        this.f3165a = jh0;
        this.a = i;
        this.f3166a = l5Var;
        this.f3164a = xVar;
        this.f3167a = cVarArr;
    }

    public static hc a(jh0 jh0, int i, l5 l5Var, x xVar, c[] cVarArr) {
        return new hh0(jh0, i, l5Var, xVar, cVarArr);
    }

    public void accept(Object obj) {
        jh0.j(this.f3165a, this.a, this.f3166a, this.f3164a, this.f3167a, (Cursor) obj);
    }
}
