package defpackage;

/* renamed from: q40  reason: default package */
public final class q40 extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q40(Throwable e) {
        super(e != null ? e.getMessage() : null, e != null ? e : new NullPointerException());
    }
}
