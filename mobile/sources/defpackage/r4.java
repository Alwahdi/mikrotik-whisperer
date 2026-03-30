package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: r4  reason: default package */
public final class r4 {
    /* access modifiers changed from: private */
    public static final Logger a = Logger.getLogger(r4.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final String f4878a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final AtomicLong f4879a;

    public r4(String name, long value) {
        AtomicLong atomicLong = new AtomicLong();
        this.f4879a = atomicLong;
        v90.e(value > 0, "value must be positive");
        this.f4878a = name;
        atomicLong.set(value);
    }

    public b d() {
        return new b(this.f4879a.get());
    }

    /* renamed from: r4$b */
    public final class b {
        private final long a;

        private b(long value) {
            this.a = value;
        }

        public long b() {
            return this.a;
        }

        public void a() {
            long j = this.a;
            long newValue = Math.max(2 * j, j);
            boolean swapped = r4.this.f4879a.compareAndSet(this.a, newValue);
            if (r4.this.f4879a.get() < newValue) {
                throw new AssertionError();
            } else if (swapped) {
                r4.a.log(Level.WARNING, "Increased {0} to {1}", new Object[]{r4.this.f4878a, Long.valueOf(newValue)});
            }
        }
    }
}
