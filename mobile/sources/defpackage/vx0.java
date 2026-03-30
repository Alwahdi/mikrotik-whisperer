package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import defpackage.wp;

/* renamed from: vx0  reason: default package */
abstract class vx0<T> extends sw0 {
    protected final gq0<T> a;

    public vx0(int i, gq0<T> gq0) {
        super(i);
        this.a = gq0;
    }

    /* access modifiers changed from: protected */
    public abstract void i(wp.a<?> aVar);

    public void b(Status status) {
        this.a.d(new l3(status));
    }

    public void c(RuntimeException runtimeException) {
        this.a.d(runtimeException);
    }

    public final void f(wp.a<?> aVar) {
        try {
            i(aVar);
        } catch (DeadObjectException e) {
            b(ix0.a(e));
            throw e;
        } catch (RemoteException e2) {
            b(ix0.a(e2));
        } catch (RuntimeException e3) {
            c(e3);
        }
    }
}
