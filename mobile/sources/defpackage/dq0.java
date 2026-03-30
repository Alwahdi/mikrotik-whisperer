package defpackage;

/* renamed from: dq0  reason: default package */
public abstract class dq0 implements Runnable {
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public hq0 f2814a;

    public dq0(long submissionTime, hq0 taskContext) {
        this.a = submissionTime;
        this.f2814a = taskContext;
    }

    public dq0() {
        this(0, mq0.f4384a);
    }
}
