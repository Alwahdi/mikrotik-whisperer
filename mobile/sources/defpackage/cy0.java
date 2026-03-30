package defpackage;

import com.google.android.gms.common.api.Status;
import defpackage.wp;

/* renamed from: cy0  reason: default package */
public final class cy0 extends vx0<Boolean> {
    private final qx<?> a;

    public cy0(qx<?> qxVar, gq0<Boolean> gq0) {
        super(4, gq0);
    }

    public final void i(wp.a<?> aVar) {
        b6.a(aVar.u().remove(this.a));
        this.a.e(false);
    }

    public final nk[] g(wp.a<?> aVar) {
        b6.a(aVar.u().get(this.a));
        return null;
    }

    public final boolean h(wp.a<?> aVar) {
        b6.a(aVar.u().get(this.a));
        return false;
    }

    public final /* bridge */ /* synthetic */ void d(my0 my0, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void c(RuntimeException runtimeException) {
        super.c(runtimeException);
    }

    public final /* bridge */ /* synthetic */ void b(Status status) {
        super.b(status);
    }
}
