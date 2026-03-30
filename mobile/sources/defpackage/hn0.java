package defpackage;

import java.util.concurrent.TimeUnit;

/* renamed from: hn0  reason: default package */
public final class hn0 {
    private long a;

    /* renamed from: a  reason: collision with other field name */
    private final ir0 f3175a = ir0.b();

    /* renamed from: a  reason: collision with other field name */
    private boolean f3176a;
    private long b;

    public static hn0 c() {
        return new hn0();
    }

    hn0() {
    }

    public hn0 g() {
        v90.u(!this.f3176a, "This stopwatch is already running.");
        this.f3176a = true;
        this.b = this.f3175a.a();
        return this;
    }

    public hn0 f() {
        this.a = 0;
        this.f3176a = false;
        return this;
    }

    private long e() {
        return this.f3176a ? (this.f3175a.a() - this.b) + this.a : this.a;
    }

    public long d(TimeUnit desiredUnit) {
        return desiredUnit.convert(e(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long nanos = e();
        TimeUnit unit = b(nanos);
        double value = ((double) nanos) / ((double) TimeUnit.NANOSECONDS.convert(1, unit));
        return i90.a(value) + " " + a(unit);
    }

    private static TimeUnit b(long nanos) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(nanos, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(nanos, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(nanos, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(nanos, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(nanos, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        if (timeUnit7.convert(nanos, timeUnit2) > 0) {
            return timeUnit7;
        }
        return timeUnit2;
    }

    /* renamed from: hn0$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private static String a(TimeUnit unit) {
        switch (a.a[unit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
