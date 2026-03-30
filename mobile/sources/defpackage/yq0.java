package defpackage;

import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: yq0  reason: default package */
public final class yq0 {
    private Boolean a = null;

    /* renamed from: a  reason: collision with other field name */
    private Integer f5924a = null;

    /* renamed from: a  reason: collision with other field name */
    private String f5925a = null;

    /* renamed from: a  reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f5926a = null;

    /* renamed from: a  reason: collision with other field name */
    private ThreadFactory f5927a = null;

    public yq0 f(String nameFormat) {
        String d = d(nameFormat, 0);
        this.f5925a = nameFormat;
        return this;
    }

    public yq0 e(boolean daemon) {
        this.a = Boolean.valueOf(daemon);
        return this;
    }

    public ThreadFactory b() {
        return c(this);
    }

    private static ThreadFactory c(yq0 builder) {
        ThreadFactory backingThreadFactory;
        String nameFormat = builder.f5925a;
        Boolean daemon = builder.a;
        Integer priority = builder.f5924a;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.f5926a;
        ThreadFactory threadFactory = builder.f5927a;
        if (threadFactory != null) {
            backingThreadFactory = threadFactory;
        } else {
            backingThreadFactory = Executors.defaultThreadFactory();
        }
        return new a(backingThreadFactory, nameFormat, nameFormat != null ? new AtomicLong(0) : null, daemon, priority, uncaughtExceptionHandler);
    }

    /* renamed from: yq0$a */
    static class a implements ThreadFactory {
        final /* synthetic */ Boolean a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Integer f5928a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ String f5929a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f5930a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ ThreadFactory f5931a;

        /* renamed from: a  reason: collision with other field name */
        final /* synthetic */ AtomicLong f5932a;

        a(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f5931a = threadFactory;
            this.f5929a = str;
            this.f5932a = atomicLong;
            this.a = bool;
            this.f5928a = num;
            this.f5930a = uncaughtExceptionHandler;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = this.f5931a.newThread(runnable);
            String str = this.f5929a;
            if (str != null) {
                thread.setName(yq0.d(str, Long.valueOf(this.f5932a.getAndIncrement())));
            }
            Boolean bool = this.a;
            if (bool != null) {
                thread.setDaemon(bool.booleanValue());
            }
            Integer num = this.f5928a;
            if (num != null) {
                thread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f5930a;
            if (uncaughtExceptionHandler != null) {
                thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return thread;
        }
    }

    /* access modifiers changed from: private */
    public static String d(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
