package defpackage;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* renamed from: ze  reason: default package */
public final class ze implements Comparable<ze> {
    private static final b a = new b();
    private static final long b;
    private static final long c;
    private static final long d = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: a  reason: collision with other field name */
    private final long f6022a;

    /* renamed from: a  reason: collision with other field name */
    private final c f6023a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f6024a;

    /* renamed from: ze$c */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500);
        b = nanos;
        c = -nanos;
    }

    public static ze a(long duration, TimeUnit units) {
        return b(duration, units, a);
    }

    public static ze b(long duration, TimeUnit units, c ticker) {
        c(units, "units");
        return new ze(ticker, units.toNanos(duration), true);
    }

    private ze(c ticker, long offset, boolean baseInstantAlreadyExpired) {
        this(ticker, ticker.a(), offset, baseInstantAlreadyExpired);
    }

    private ze(c ticker, long baseInstant, long offset, boolean baseInstantAlreadyExpired) {
        this.f6023a = ticker;
        long offset2 = Math.min(b, Math.max(c, offset));
        this.f6022a = baseInstant + offset2;
        this.f6024a = baseInstantAlreadyExpired && offset2 <= 0;
    }

    public boolean h() {
        if (!this.f6024a) {
            if (this.f6022a - this.f6023a.a() > 0) {
                return false;
            }
            this.f6024a = true;
        }
        return true;
    }

    public boolean g(ze other) {
        d(other);
        return this.f6022a - other.f6022a < 0;
    }

    public ze i(ze other) {
        d(other);
        return g(other) ? this : other;
    }

    public long j(TimeUnit unit) {
        long nowNanos = this.f6023a.a();
        if (!this.f6024a && this.f6022a - nowNanos <= 0) {
            this.f6024a = true;
        }
        return unit.convert(this.f6022a - nowNanos, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long remainingNanos = j(TimeUnit.NANOSECONDS);
        long abs = Math.abs(remainingNanos);
        long j = d;
        long seconds = abs / j;
        long nanos = Math.abs(remainingNanos) % j;
        StringBuilder buf = new StringBuilder();
        if (remainingNanos < 0) {
            buf.append('-');
        }
        buf.append(seconds);
        if (nanos > 0) {
            buf.append(String.format(".%09d", new Object[]{Long.valueOf(nanos)}));
        }
        buf.append("s from now");
        if (this.f6023a != a) {
            buf.append(" (ticker=" + this.f6023a + ")");
        }
        return buf.toString();
    }

    /* renamed from: e */
    public int compareTo(ze that) {
        d(that);
        long diff = this.f6022a - that.f6022a;
        if (diff < 0) {
            return -1;
        }
        if (diff > 0) {
            return 1;
        }
        return 0;
    }

    public int hashCode() {
        return Arrays.asList(new Object[]{this.f6023a, Long.valueOf(this.f6022a)}).hashCode();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ze)) {
            return false;
        }
        ze other = (ze) o;
        c cVar = this.f6023a;
        if (cVar != null ? cVar != other.f6023a : other.f6023a != null) {
            return false;
        }
        if (this.f6022a != other.f6022a) {
            return false;
        }
        return true;
    }

    /* renamed from: ze$b */
    private static class b extends c {
        private b() {
        }

        public long a() {
            return System.nanoTime();
        }
    }

    private static <T> T c(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    private void d(ze other) {
        if (this.f6023a != other.f6023a) {
            throw new AssertionError("Tickers (" + this.f6023a + " and " + other.f6023a + ") don't match. Custom Ticker should only be used in tests!");
        }
    }
}
