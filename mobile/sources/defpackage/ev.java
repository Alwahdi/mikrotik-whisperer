package defpackage;

import defpackage.yc;
import java.util.concurrent.CancellationException;

/* renamed from: ev  reason: default package */
public interface ev extends yc.b {
    public static final b a = b.b;

    l8 C(n8 n8Var);

    ah J(boolean z, boolean z2, vn<? super Throwable, jt0> vnVar);

    CancellationException K();

    boolean P();

    boolean c();

    void o(CancellationException cancellationException);

    /* renamed from: ev$a */
    public static final class a {
        public static <R> R b(ev evVar, R initial, jo<? super R, ? super yc.b, ? extends R> operation) {
            return yc.b.a.a(evVar, initial, operation);
        }

        public static <E extends yc.b> E c(ev evVar, yc.c<E> key) {
            return yc.b.a.b(evVar, key);
        }

        public static yc e(ev evVar, yc.c<?> key) {
            return yc.b.a.c(evVar, key);
        }

        public static yc f(ev evVar, yc context) {
            return yc.b.a.d(evVar, context);
        }

        public static /* synthetic */ void a(ev evVar, CancellationException cancellationException, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    cancellationException = null;
                }
                evVar.o(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ ah d(ev evVar, boolean z, boolean z2, vn vnVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                if ((i & 2) != 0) {
                    z2 = true;
                }
                return evVar.J(z, z2, vnVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }
    }

    /* renamed from: ev$b */
    public static final class b implements yc.c<ev> {
        static final /* synthetic */ b b = new b();

        private b() {
        }
    }
}
