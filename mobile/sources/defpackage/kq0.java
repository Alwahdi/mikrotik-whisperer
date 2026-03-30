package defpackage;

/* renamed from: kq0  reason: default package */
public final class kq0 extends dq0 {
    public final Runnable a;

    public kq0(Runnable block, long submissionTime, hq0 taskContext) {
        super(submissionTime, taskContext);
        this.a = block;
    }

    public void run() {
        try {
            this.a.run();
        } finally {
            this.f2814a.a();
        }
    }

    public String toString() {
        return "Task[" + ef.a(this.a) + '@' + ef.b(this.a) + ", " + this.a + ", " + this.f2814a + ']';
    }
}
