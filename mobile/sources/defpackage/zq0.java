package defpackage;

import defpackage.qc;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: zq0  reason: default package */
final class zq0 extends qc.c {
    static final ThreadLocal<qc> a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    private static final Logger f6049a = Logger.getLogger(zq0.class.getName());

    zq0() {
    }

    public qc c(qc toAttach) {
        qc current = a();
        a.set(toAttach);
        return current;
    }

    public void b(qc toDetach, qc toRestore) {
        if (a() != toDetach) {
            f6049a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (toRestore != qc.f4836a) {
            a.set(toRestore);
        } else {
            a.set((Object) null);
        }
    }

    public qc a() {
        qc current = a.get();
        if (current == null) {
            return qc.f4836a;
        }
        return current;
    }
}
