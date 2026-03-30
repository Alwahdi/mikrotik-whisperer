package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import defpackage.i3;
import defpackage.wp;

/* renamed from: yx0  reason: default package */
public final class yx0<ResultT> extends sw0 {
    private final fn0 a;

    /* renamed from: a  reason: collision with other field name */
    private final fq0<i3.b, ResultT> f5957a;

    /* renamed from: a  reason: collision with other field name */
    private final gq0<ResultT> f5958a;

    public yx0(int i, fq0<i3.b, ResultT> fq0, gq0<ResultT> gq0, fn0 fn0) {
        super(i);
        this.f5958a = gq0;
        this.f5957a = fq0;
        this.a = fn0;
    }

    public final void f(wp.a<?> aVar) {
        try {
            this.f5957a.b(aVar.l(), this.f5958a);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            b(ix0.a(e2));
        } catch (RuntimeException e3) {
            c(e3);
        }
    }

    public final void b(Status status) {
        this.f5958a.d(this.a.a(status));
    }

    public final void c(RuntimeException runtimeException) {
        this.f5958a.d(runtimeException);
    }

    public final void d(my0 my0, boolean z) {
        my0.a(this.f5958a, z);
    }

    public final nk[] g(wp.a<?> aVar) {
        return this.f5957a.d();
    }

    public final boolean h(wp.a<?> aVar) {
        return this.f5957a.c();
    }
}
