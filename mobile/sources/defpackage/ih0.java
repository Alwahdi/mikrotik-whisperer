package defpackage;

import com.google.firebase.database.collection.c;
import com.google.firebase.firestore.core.x;

/* renamed from: ih0  reason: default package */
final /* synthetic */ class ih0 implements Runnable {
    private final x a;

    /* renamed from: a  reason: collision with other field name */
    private final jh0 f3240a;

    /* renamed from: a  reason: collision with other field name */
    private final byte[] f3241a;

    /* renamed from: a  reason: collision with other field name */
    private final c[] f3242a;

    private ih0(jh0 jh0, byte[] bArr, x xVar, c[] cVarArr) {
        this.f3240a = jh0;
        this.f3241a = bArr;
        this.a = xVar;
        this.f3242a = cVarArr;
    }

    public static Runnable a(jh0 jh0, byte[] bArr, x xVar, c[] cVarArr) {
        return new ih0(jh0, bArr, xVar, cVarArr);
    }

    public void run() {
        jh0.i(this.f3240a, this.f3241a, this.a, this.f3242a);
    }
}
