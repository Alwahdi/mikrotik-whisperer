package defpackage;

/* renamed from: oj  reason: default package */
public abstract class oj {
    public static RuntimeException a(Throwable t) {
        throw nj.d(t);
    }

    public static void b(Throwable t) {
        if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        } else if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        } else if (t instanceof LinkageError) {
            throw ((LinkageError) t);
        }
    }
}
