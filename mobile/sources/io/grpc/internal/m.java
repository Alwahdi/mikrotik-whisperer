package io.grpc.internal;

import io.grpc.i;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

final class m {
    static final Logger a = Logger.getLogger(io.grpc.a.class.getName());

    /* renamed from: a  reason: collision with other field name */
    private int f3477a;

    /* renamed from: a  reason: collision with other field name */
    private final long f3478a;

    /* renamed from: a  reason: collision with other field name */
    private final hu f3479a;

    /* renamed from: a  reason: collision with other field name */
    private final Object f3480a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private final Collection<i> f3481a;

    static /* synthetic */ int a(m x0) {
        int i = x0.f3477a;
        x0.f3477a = i + 1;
        return i;
    }

    m(hu logId, int maxEvents, long channelCreationTimeNanos, String description) {
        v90.o(description, "description");
        this.f3479a = (hu) v90.o(logId, "logId");
        if (maxEvents > 0) {
            this.f3481a = new a(maxEvents);
        } else {
            this.f3481a = null;
        }
        this.f3478a = channelCreationTimeNanos;
        i.a aVar = new i.a();
        e(aVar.b(description + " created").c(i.b.CT_INFO).e(channelCreationTimeNanos).a());
    }

    class a extends ArrayDeque<i> {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        /* renamed from: a */
        public boolean add(i event) {
            if (size() == this.a) {
                removeFirst();
            }
            m.a(m.this);
            return super.add(event);
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.b.values().length];
            a = iArr;
            try {
                iArr[i.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[i.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(i event) {
        Level logLevel;
        switch (b.a[event.f3272a.ordinal()]) {
            case 1:
                logLevel = Level.FINE;
                break;
            case 2:
                logLevel = Level.FINER;
                break;
            default:
                logLevel = Level.FINEST;
                break;
        }
        f(event);
        d(this.f3479a, logLevel, event.f3273a);
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        boolean z;
        synchronized (this.f3480a) {
            z = this.f3481a != null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void f(i event) {
        synchronized (this.f3480a) {
            Collection<i> collection = this.f3481a;
            if (collection != null) {
                collection.add(event);
            }
        }
    }

    static void d(hu logId, Level logLevel, String msg) {
        Logger logger = a;
        if (logger.isLoggable(logLevel)) {
            LogRecord lr = new LogRecord(logLevel, "[" + logId + "] " + msg);
            lr.setLoggerName(logger.getName());
            lr.setSourceClassName(logger.getName());
            lr.setSourceMethodName("log");
            logger.log(lr);
        }
    }

    /* access modifiers changed from: package-private */
    public hu b() {
        return this.f3479a;
    }
}
