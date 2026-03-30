package defpackage;

/* renamed from: gx  reason: default package */
public abstract class gx {
    public static final void a(int $this$checkParallelism) {
        boolean z = true;
        if ($this$checkParallelism < 1) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + $this$checkParallelism).toString());
        }
    }
}
