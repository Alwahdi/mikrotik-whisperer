package defpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* renamed from: e30  reason: default package */
public class e30 implements ThreadFactory {
    private final int a;

    /* renamed from: a  reason: collision with other field name */
    private final String f2841a;

    /* renamed from: a  reason: collision with other field name */
    private final ThreadFactory f2842a;

    public e30(String str) {
        this(str, 0);
    }

    private e30(String str, int i) {
        this.f2842a = Executors.defaultThreadFactory();
        this.f2841a = (String) y90.k(str, "Name must not be null");
        this.a = 0;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f2842a.newThread(new ry0(runnable, 0));
        newThread.setName(this.f2841a);
        return newThread;
    }
}
