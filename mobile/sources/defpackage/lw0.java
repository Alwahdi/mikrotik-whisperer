package defpackage;

import android.content.Context;
import android.os.Looper;
import defpackage.i3;
import defpackage.vp;

/* renamed from: lw0  reason: default package */
final class lw0 extends i3.a<ql0, rl0> {
    lw0() {
    }

    public final /* synthetic */ i3.f b(Context context, Looper looper, y8 y8Var, Object obj, vp.a aVar, vp.b bVar) {
        rl0 rl0;
        rl0 rl02 = (rl0) obj;
        if (rl02 == null) {
            rl0 = rl0.a;
        } else {
            rl0 = rl02;
        }
        return new ql0(context, looper, true, y8Var, rl0, aVar, bVar);
    }
}
