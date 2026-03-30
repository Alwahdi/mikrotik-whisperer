package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: ry  reason: default package */
public class ry<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ry.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public ry(boolean singleConsumer) {
        this._cur = new sy(8, singleConsumer);
    }

    public final int c() {
        return ((sy) this._cur).f();
    }

    public final void b() {
        while (true) {
            sy cur = (sy) this._cur;
            if (!cur.d()) {
                w.a(a, this, cur, cur.i());
            } else {
                return;
            }
        }
    }

    public final boolean a(E element) {
        while (true) {
            sy cur = (sy) this._cur;
            switch (cur.a(element)) {
                case 0:
                    return true;
                case 1:
                    w.a(a, this, cur, cur.i());
                    break;
                case 2:
                    return false;
            }
        }
    }

    public final E d() {
        while (true) {
            sy cur = (sy) this._cur;
            Object result = cur.j();
            if (result != sy.f5063a) {
                return result;
            }
            w.a(a, this, cur, cur.i());
        }
    }
}
