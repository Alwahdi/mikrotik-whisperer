package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: qc  reason: default package */
public class qc {
    static final Logger a = Logger.getLogger(qc.class.getName());

    /* renamed from: a  reason: collision with other field name */
    public static final qc f4836a = new qc();

    /* renamed from: a  reason: collision with other field name */
    final int f4837a = 0;

    /* renamed from: a  reason: collision with other field name */
    final d90<Object, Object> f4838a = null;

    /* renamed from: qc$a */
    public interface a {
    }

    /* renamed from: qc$c */
    public static abstract class c {
        public abstract qc a();

        public abstract void b(qc qcVar, qc qcVar2);

        public abstract qc c(qc qcVar);
    }

    static c j() {
        return b.a;
    }

    /* renamed from: qc$b */
    private static final class b {
        static final c a;

        static {
            AtomicReference<Throwable> deferredStorageFailure = new AtomicReference<>();
            a = a(deferredStorageFailure);
            Throwable failure = deferredStorageFailure.get();
            if (failure != null) {
                qc.a.log(Level.FINE, "Storage override doesn't exist. Using default", failure);
            }
        }

        private static c a(AtomicReference<? super ClassNotFoundException> deferredStorageFailure) {
            try {
                return (c) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(c.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                deferredStorageFailure.set(e);
                return new zq0();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static qc e() {
        qc current = j().a();
        if (current == null) {
            return f4836a;
        }
        return current;
    }

    private qc() {
        k(0);
    }

    public qc b() {
        qc prev = j().c(this);
        if (prev == null) {
            return f4836a;
        }
        return prev;
    }

    public void f(qc toAttach) {
        d(toAttach, "toAttach");
        j().b(this, toAttach);
    }

    public boolean h() {
        return false;
    }

    public Throwable c() {
        return null;
    }

    public ze g() {
        return null;
    }

    public void a(a cancellationListener, Executor executor) {
        d(cancellationListener, "cancellationListener");
        d(executor, "executor");
    }

    public void i(a cancellationListener) {
    }

    static <T> T d(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    private static void k(int generation) {
        if (generation == 1000) {
            a.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", new Exception());
        }
    }
}
