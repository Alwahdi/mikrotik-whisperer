package defpackage;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: m5  reason: default package */
public abstract class m5 {
    public static long b(long a, long b) {
        long u = a + b;
        if (u < 0) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return u;
    }

    public static long a(AtomicLong requested, long n) {
        long r;
        do {
            r = requested.get();
            if (r == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        } while (!requested.compareAndSet(r, b(r, n)));
        return r;
    }

    public static long c(AtomicLong requested, long n) {
        long current;
        long update;
        do {
            current = requested.get();
            if (current == LocationRequestCompat.PASSIVE_INTERVAL) {
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
            update = current - n;
            if (update < 0) {
                of0.l(new IllegalStateException("More produced than requested: " + update));
                update = 0;
            }
        } while (!requested.compareAndSet(current, update));
        return update;
    }
}
